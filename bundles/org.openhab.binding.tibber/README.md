# Tibber Binding

The Tibber Binding connects to the [Tibber API](https://developer.tibber.com), and use queries at frequent polls to retrieve price and consumption information for users with Tibber subscription, and provides additional live measurements via websocket for users having Tibber Pulse. 

Refresh time (poll frequency) is set manually as part of setup, minimum 1 minute.

If using Tibber Pulse, Pulse has to be chosen as addon from dropdown list during setup. Binding will check/verify if Pulse is connected, and will start live data stream if Pulse verified present. 

## Supported Things

Provided one have Tibber Account, the Tibber API is recognized as a thing in OpenHab using the Tibber binding. Tibber Pulse is optional, but will enable live measurements. The channels (i.e. measurements) associated with the binding: 

Tibber Account:

* Current Total:        Current Total Price (energy + tax)
* Starts At:            Current Price Timestamp
* Daily Cost:           Daily Cost (last/previous day)
* Daily Consumption:    Daily Consumption (last/previous day)
* Dail From:            Timestamp (daily from)
* Daily To:             Timestamp (daily to)
* Hourly Cost:          Hourly Cost (last/previous hour)
* Hourly Consumption:   Hourly Consumption (last/previous hour)
* Hourly From:          Timestamp (hourly from)
* Hourly To:            TimeStamp (hourly to)

Tibber Pulse:

* Timestamp:                Timestamp for live measurements
* Power:                    Live Power Consumption
* Last Meter Consumption:   Last Recorded Meter Consumption
* Accumulated Consumption:  Accumulated Consumption since Midnight
* Accumulated Cost:         Accumulated Cost since Midnight
* Currency:                 Currency of Cost
* Min Power:                Min Power Consumption since Midnight
* Average Power:            Average Power Consumption since Midnight
* Max Power:                Max Power Consumption since Midnight


## Binding Configuration

To access and initiate the Tibber binding, a Tibber account is required.

Required input needed for initialization:

* Tibber token
* Tibber HomeId
* Refresh Interval (min 1 minute)
* Addons (Pulse or None)

Note: Tibber token is retrieved from your Tibber account:
[Tibber Account](https://developer.tibber.com/settings/accesstoken)

Note: Tibber HomeId is retrieved from [www.developer.com](https://developer.tibber.com/explorer). Sign in (Tibber account) and load personal token. HomeId is retrieved by copying and running query below from Tibber API explorer. If Pulse is connected, realTimeConsumptionEnabled will report "true" for the associated HomeId. Copy desired HomeId, without quotation marks, and paste into PaperUI configuration.

```
{
  viewer {
    homes {
      id
      features {
        realTimeConsumptionEnabled
      }
    }
  }
}
```

If user have multiple HomeIds / Pulse, separate Things have to be created for the desired HomeIds in PaperUI.


## Thing Configuration

When Tibber binding is installed, Tibber API should be autodiscovered in PaperUI. Retrieve personal token and HomeId from description above, and initialize/start binding from PaperUI. Tibber API will be autodiscovered if provided input is correct.

Note: 
Gson is required. If not able to initialize binding, perform from OpenHab console:

```
bundle:install http://central.maven.org/maven2/com/google/code/gson/gson/2.8.5/gson-2.8.5.jar
```


## Full Example

demo.items:

```
String                 TibberAPIId                           "Home"                       {channel="tibber:tibberapi:034d4e74:id"}
Number:Dimensionless   TibberAPICurrentTotal                 "Current total price"        {channel="tibber:tibberapi:034d4e74:current_total"}
String                 TibberAPICurrentStartsAt              "Timestamp current"          {channel="tibber:tibberapi:034d4e74:current_startsAt"}
String                 TibberAPIDailyFrom                    "Timestamp daily from"       {channel="tibber:tibberapi:034d4e74:daily_from"}
String                 TibberAPIDailyTo                      "Timestamp daily to"         {channel="tibber:tibberapi:034d4e74:daily_to"}
Number:Dimensionless   TibberAPIDailyCost                    "Total daily cost"           {channel="tibber:tibberapi:034d4e74:daily_cost"}
Number:Dimensionless   TibberAPIDailyConsumption             "Total daily consumption"    {channel="tibber:tibberapi:034d4e74:daily_consumption"}
String                 TibberAPIHourlyFrom                   "Timestamp hourly from"      {channel="tibber:tibberapi:034d4e74:hourly_from"}
String                 TibberAPIHourlyTo                     "Timestamp hourly to"        {channel="tibber:tibberapi:034d4e74:hourly_to"}
Number:Dimensionless   TibberAPIHourlyCost                   "Total hourly cost"          {channel="tibber:tibberapi:034d4e74:hourly_cost"}
Number:Dimensionless   TibberAPIHourlyConsumption            "Total hourly consumption"   {channel="tibber:tibberapi:034d4e74:hourly_consumption"}
String                 TibberAPILiveTimestamp                "Live timestamp"             {channel="tibber:tibberapi:034d4e74:live_timestamp"}
Number:Dimensionless   TibberAPILivePower                    "Live consumption"           {channel="tibber:tibberapi:034d4e74:live_power"}
Number:Dimensionless   TibberAPILiveLastMeterConsumption     "Last meter consumption"     {channel="tibber:tibberapi:034d4e74:live_lastMeterConsumption"}
Number:Dimensionless   TibberAPILiveAccumulatedConsumption   "Accumulated consumption"    {channel="tibber:tibberapi:034d4e74:live_accumulatedConsumption"}
Number:Dimensionless   TibberAPILiveAccumulatedCost          "Accumulated cost"           {channel="tibber:tibberapi:034d4e74:live_accumulatedCost"}
String                 TibberAPILiveCurrency                 "Currency"                   {channel="tibber:tibberapi:034d4e74:live_currency"}
Number:Dimensionless   TibberAPILiveMinPower                 "Min consumption"            {channel="tibber:tibberapi:034d4e74:live_minPower"}
Number:Dimensionless   TibberAPILiveAveragePower             "Average consumption"        {channel="tibber:tibberapi:034d4e74:live_averagePower"}
Number:Dimensionless   TibberAPILiveMaxPower                 "Max consumption"            {channel="tibber:tibberapi:034d4e74:live_maxPower"}
```
