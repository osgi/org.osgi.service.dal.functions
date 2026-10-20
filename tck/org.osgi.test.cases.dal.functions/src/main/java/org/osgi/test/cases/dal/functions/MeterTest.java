/*******************************************************************************
 * Copyright (c) Contributors to the Eclipse Foundation
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 * SPDX-License-Identifier: Apache-2.0 
 *******************************************************************************/

package org.osgi.test.cases.dal.functions;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.osgi.service.dal.DeviceException;
import org.osgi.service.dal.Function;
import org.osgi.service.dal.functions.Meter;
import org.osgi.service.dal.functions.data.LevelData;
import org.osgi.test.cases.dal.functions.step.FunctionsTestSteps;

/**
 * Validates the {@code Meter} functions.
 */
public final class MeterTest extends AbstractFunctionTest {

	/**
	 * Tests the total meter consumption.
	 * 
	 * @throws DeviceException If operation error is available.
	 */
	@Test
	public void testTotal() throws DeviceException {
		super.testStepProxy.execute(
				FunctionsTestSteps.STEP_ID_AVAILABLE_METER,
				FunctionsTestSteps.STEP_MESSAGE_AVAILABLE_METER);
		Function[] meters = super.getFunctions(Meter.class.getName());
		for (int i = 0; i < meters.length; i++) {
			Meter currentMeter = (Meter) meters[i];
			LevelData total = currentMeter.getTotal();
			assertThat(total).as("No total metering info.").isNotNull();
			super.assertEquals(
					currentMeter.getPropertyMetadata(Meter.PROPERTY_TOTAL),
					total.getLevel(), total);
		}
	}

	/**
	 * Tests the current meter consumption.
	 * 
	 * @throws DeviceException If operation error is available.
	 */
	@Test
	public void testCurrent() throws DeviceException {
		super.testStepProxy.execute(
				FunctionsTestSteps.STEP_ID_AVAILABLE_METER,
				FunctionsTestSteps.STEP_MESSAGE_AVAILABLE_METER);
		Function[] meters = super.getFunctions(Meter.class.getName());
		for (int i = 0; i < meters.length; i++) {
			Meter currentMeter = (Meter) meters[i];
			LevelData current = currentMeter.getCurrent();
			assertThat(current).as("No total metering info.").isNotNull();
			super.assertEquals(
					currentMeter.getPropertyMetadata(Meter.PROPERTY_CURRENT),
					current.getLevel(), current);
			assertThat(current.getLevel().compareTo(currentMeter.getTotal().getLevel()) <= 0).as("The current value is greater than the total value.").isTrue();
		}
	}

	/**
	 * Checks {@code Meter} current consumption events.
	 */
	@Test
	public void testCurrentPropertyEvent() {
		super.testStepProxy.execute(
				FunctionsTestSteps.STEP_ID_AVAILABLE_METER,
				FunctionsTestSteps.STEP_MESSAGE_AVAILABLE_METER);
		super.checkPropertyEvent(
				Meter.class.getName(),
				Meter.PROPERTY_CURRENT,
				FunctionsTestSteps.STEP_ID_EVENT_METER_CURRENT,
				FunctionsTestSteps.STEP_MESSAGE_EVENT_METER_CURRENT);
	}

	/**
	 * Checks {@code Meter} total consumption events.
	 */
	@Test
	public void testTotalPropertyEvent() {
		super.testStepProxy.execute(
				FunctionsTestSteps.STEP_ID_AVAILABLE_METER,
				FunctionsTestSteps.STEP_MESSAGE_AVAILABLE_METER);
		super.checkPropertyEvent(
				Meter.class.getName(),
				Meter.PROPERTY_TOTAL,
				FunctionsTestSteps.STEP_ID_EVENT_METER_TOTAL,
				FunctionsTestSteps.STEP_MESSAGE_EVENT_METER_TOTAL);
	}
}
