/**
 * Copyright (c) 2010-2020 Contributors to the openHAB project
 *
 * See the NOTICE file(s) distributed with this work for additional
 * information.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0
 *
 * SPDX-License-Identifier: EPL-2.0
 */
package org.openhab.binding.freeathome.internal.config;

/**
 * Configuration of a 4.3" touch panel with integrated thermostat
 *
 * @author Stian Kjoglum - Initial contribution
 *
 */
public class FreeAtHomeTouchConfig {
    public String deviceId;
    public String channelId;
    public String dataPointIdTarget;
    public String dataPointIdSwitch;
    public String dataPointIdEco;
    public String dataPointIdTargetUpdate;
    public String dataPointIdRoomUpdate;
    public String dataPointIdSwitchUpdate;
    public String dataPointIdEcoUpdate;
    public String dataPointIdHeatStateUpdate;
    public String dataPointIdHeatActuatorStateUpdate;
}
