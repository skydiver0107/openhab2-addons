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
package org.openhab.binding.freeathome.internal.model;

import org.eclipse.smarthome.core.types.State;

/**
 * Interface to convert values of update events to openhab states
 *
 * @author Stian Kjoglum - Initial contribution
 *
 */
public interface StateConverter {
    public State convert(String value);
}
