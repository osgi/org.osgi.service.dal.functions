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

package org.osgi.test.cases.dal.functions.data;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.fail;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.Test;
import org.osgi.service.dal.FunctionData;
import org.osgi.service.dal.functions.data.AlarmData;
import org.osgi.test.cases.dal.functions.AbstractFunctionTest;

/**
 * Validates the {@code AlarmData} data structure.
 */
public final class AlarmDataTest extends AbstractFunctionTest {

	/**
	 * Checks {@link AlarmData#equals(Object)} method.
	 */
	@Test
	public void testEquals() {
		// check without metadata
		AlarmData data = new AlarmData(Long.MIN_VALUE, null, AlarmData.SEVERITY_UNDEFINED, AlarmData.TYPE_COLD);
		assertThat(data).as("The alarm data comparison is wrong!").isEqualTo(data);
		assertThat(new AlarmData(Long.MIN_VALUE, null, AlarmData.SEVERITY_UNDEFINED, AlarmData.TYPE_COLD)).as("The alarm data comparison is wrong!").isEqualTo(data);

		// check with metadata
		Map<String,Object> metadata = new HashMap<>();
		metadata.put(FunctionData.DESCRIPTION, "test-description");
		data = new AlarmData(Long.MIN_VALUE, metadata, AlarmData.SEVERITY_UNDEFINED, AlarmData.TYPE_COLD);
		assertThat(data).as("The alarm data comparison is wrong!").isEqualTo(data);
		assertThat(new AlarmData(Long.MIN_VALUE, metadata, AlarmData.SEVERITY_UNDEFINED, AlarmData.TYPE_COLD)).as("The alarm data comparison is wrong!").isEqualTo(data);

		// check with fields map
		Map<String,Object> fields = new HashMap<>();
		fields.put(AlarmData.FIELD_SEVERITY, Integer.valueOf(AlarmData.SEVERITY_UNDEFINED));
		fields.put(AlarmData.FIELD_TYPE, Integer.valueOf(AlarmData.TYPE_COLD));
		fields.put(FunctionData.FIELD_METADATA, metadata);
		fields.put(FunctionData.FIELD_TIMESTAMP, Long.valueOf(Long.MIN_VALUE));
		data = new AlarmData(fields);
		assertThat(data).as("The alarm data comparison is wrong!").isEqualTo(data);
		assertThat(new AlarmData(Long.MIN_VALUE, metadata, AlarmData.SEVERITY_UNDEFINED, AlarmData.TYPE_COLD)).as("The alarm data comparison is wrong!").isEqualTo(data);
	}

	/**
	 * Checks {@link AlarmData#compareTo(Object)} with {@code AlarmData}.
	 */
	@Test
	public void testComparison() {
		// check without metadata
		AlarmData data = new AlarmData(Long.MIN_VALUE, null, AlarmData.SEVERITY_UNDEFINED, AlarmData.TYPE_COLD);
		assertThat(data.compareTo(data)).as("The alarm data comparison is wrong!").isZero();
		assertThat(data.compareTo(new AlarmData(Long.MIN_VALUE, null, AlarmData.SEVERITY_UNDEFINED, AlarmData.TYPE_COLD))).as("The alarm data comparison is wrong!").isZero();

		// check with metadata
		Map<String,Object> metadata = new HashMap<>();
		metadata.put(FunctionData.DESCRIPTION, "test-description");
		data = new AlarmData(Long.MIN_VALUE, metadata, AlarmData.SEVERITY_UNDEFINED, AlarmData.TYPE_COLD);
		assertThat(data.compareTo(data)).as("The alarm data comparison is wrong!").isZero();
		assertThat(data.compareTo(new AlarmData(Long.MIN_VALUE, metadata, AlarmData.SEVERITY_UNDEFINED, AlarmData.TYPE_COLD))).as("The alarm data comparison is wrong!").isZero();

		// check with fields map
		Map<String,Object> fields = new HashMap<>();
		fields.put(AlarmData.FIELD_SEVERITY, Integer.valueOf(AlarmData.SEVERITY_UNDEFINED));
		fields.put(AlarmData.FIELD_TYPE, Integer.valueOf(AlarmData.TYPE_COLD));
		fields.put(FunctionData.FIELD_METADATA, metadata);
		fields.put(FunctionData.FIELD_TIMESTAMP, Long.valueOf(Long.MIN_VALUE));
		data = new AlarmData(fields);
		assertThat(data.compareTo(data)).as("The alarm data comparison is wrong!").isZero();
		assertThat(data.compareTo(new AlarmData(Long.MIN_VALUE, metadata, AlarmData.SEVERITY_UNDEFINED, AlarmData.TYPE_COLD))).as("The alarm data comparison is wrong!").isZero();
	}

	/**
	 * Checks {@link AlarmData#hashCode()}.
	 */
	@Test
	public void testHashCode() {
		// check without metadata
		AlarmData data = new AlarmData(Long.MIN_VALUE, null, AlarmData.SEVERITY_UNDEFINED, AlarmData.TYPE_COLD);
		assertThat(data.hashCode()).as("The alarm data hash code is wrong!").isEqualTo(data.hashCode());
		assertThat((new AlarmData(Long.MIN_VALUE, null, AlarmData.SEVERITY_UNDEFINED, AlarmData.TYPE_COLD)).hashCode()).as("The alarm data hash code is wrong!").isEqualTo(data.hashCode());

		// check with metadata
		Map<String,Object> metadata = new HashMap<>();
		metadata.put(FunctionData.DESCRIPTION, "test-description");
		data = new AlarmData(Long.MIN_VALUE, metadata, AlarmData.SEVERITY_UNDEFINED, AlarmData.TYPE_COLD);
		assertThat(data.hashCode()).as("The alarm data hash code is wrong!").isEqualTo(data.hashCode());
		assertThat((new AlarmData(Long.MIN_VALUE, metadata, AlarmData.SEVERITY_UNDEFINED, AlarmData.TYPE_COLD)).hashCode()).as("The alarm data hash code is wrong!").isEqualTo(data.hashCode());

		// check with fields map
		Map<String,Object> fields = new HashMap<>();
		fields.put(AlarmData.FIELD_SEVERITY, Integer.valueOf(AlarmData.SEVERITY_UNDEFINED));
		fields.put(AlarmData.FIELD_TYPE, Integer.valueOf(AlarmData.TYPE_COLD));
		fields.put(FunctionData.FIELD_TIMESTAMP, Long.valueOf(Long.MIN_VALUE));
		fields.put(FunctionData.FIELD_METADATA, metadata);
		data = new AlarmData(fields);
		assertThat(data.hashCode()).as("The alarm data hash code is wrong!").isEqualTo(data.hashCode());
		assertThat((new AlarmData(Long.MIN_VALUE, metadata, AlarmData.SEVERITY_UNDEFINED, AlarmData.TYPE_COLD)).hashCode()).as("The alarm data hash code is wrong!").isEqualTo(data.hashCode());
	}

	/**
	 * Checks {@code AlarmData} field values.
	 */
	@Test
	public void testFields() {
		// check without metadata
		AlarmData data = new AlarmData(Long.MIN_VALUE, null, AlarmData.SEVERITY_UNDEFINED, AlarmData.TYPE_COLD);
		checkAlarmDataFields(Long.MIN_VALUE, null, AlarmData.SEVERITY_UNDEFINED, AlarmData.TYPE_COLD, data);

		// check with metadata
		Map<String,Object> metadata = new HashMap<>();
		metadata.put(FunctionData.DESCRIPTION, "test-description");
		data = new AlarmData(Long.MIN_VALUE, metadata, AlarmData.SEVERITY_UNDEFINED, AlarmData.TYPE_COLD);
		checkAlarmDataFields(Long.MIN_VALUE, metadata, AlarmData.SEVERITY_UNDEFINED, AlarmData.TYPE_COLD, data);

		// check with fields map
		Map<String,Object> fields = new HashMap<>();
		fields.put(AlarmData.FIELD_SEVERITY, Integer.valueOf(AlarmData.SEVERITY_UNDEFINED));
		fields.put(AlarmData.FIELD_TYPE, Integer.valueOf(AlarmData.TYPE_COLD));
		fields.put(FunctionData.FIELD_TIMESTAMP, Long.valueOf(Long.MIN_VALUE));
		fields.put(FunctionData.FIELD_METADATA, metadata);
		data = new AlarmData(fields);
		checkAlarmDataFields(Long.MIN_VALUE, metadata, AlarmData.SEVERITY_UNDEFINED, AlarmData.TYPE_COLD, data);

		fields.clear();
		data = new AlarmData(fields);
		checkAlarmDataFields(Long.MIN_VALUE, null, AlarmData.SEVERITY_UNDEFINED, AlarmData.TYPE_UNDEFINED, data);
	}

	/**
	 * Checks the {@code AlarmData} construction with an invalid fields.
	 */
	@Test
	public void testInvalidFields() {
		Map<String,Object> fields = new HashMap<>();
		fields.put(AlarmData.FIELD_SEVERITY, "invalid-severity");
		fields.put(AlarmData.FIELD_TYPE, Integer.valueOf(AlarmData.TYPE_COLD));
		checkInvalidFieldType(fields);

		fields.clear();
		fields.put(AlarmData.FIELD_SEVERITY, Integer.valueOf(AlarmData.SEVERITY_UNDEFINED));
		fields.put(AlarmData.FIELD_TYPE, "cold");
		checkInvalidFieldType(fields);

		fields.clear();
		fields.put(AlarmData.FIELD_SEVERITY, Integer.valueOf(AlarmData.SEVERITY_UNDEFINED));
		fields.put(AlarmData.FIELD_TYPE, Integer.valueOf(AlarmData.TYPE_COLD));
		fields.put(FunctionData.FIELD_METADATA, Boolean.TRUE);
		checkInvalidFieldType(fields);

		fields.clear();
		fields.put(AlarmData.FIELD_SEVERITY, Integer.valueOf(AlarmData.SEVERITY_UNDEFINED));
		fields.put(AlarmData.FIELD_TYPE, Integer.valueOf(AlarmData.TYPE_COLD));
		fields.put(FunctionData.FIELD_TIMESTAMP, Boolean.TRUE);
		checkInvalidFieldType(fields);

		try {
			new AlarmData(null);
			fail("The alarm data is built with null fields");
		} catch (NullPointerException npe) { // NOPMD
			// go ahead, it's expected
		}

		try {
			new AlarmData(
					System.currentTimeMillis(),
					new HashMap<>(),
					Integer.MIN_VALUE,
					AlarmData.TYPE_ACCESS_CONTROL);
			fail("Alarm data is built with invalid severity.");
		} catch (IllegalArgumentException iae) {
			// go ahead, it's expected
		}
	}

	/**
	 * Checks {@link AlarmData#toString()}.
	 */
	@Test
	public void testToString() {
		AlarmData alarmData = new AlarmData(
				System.currentTimeMillis(),
				new HashMap<>(),
				AlarmData.SEVERITY_UNDEFINED,
				AlarmData.TYPE_ACCESS_CONTROL);
		assertThat(alarmData.toString()).as("There is no string representation of the alarm data.").isNotNull();
		alarmData = new AlarmData(
				Long.MIN_VALUE,
				null,
				AlarmData.SEVERITY_MAJOR,
				Integer.MIN_VALUE);
		assertThat(alarmData.toString()).as("There is no string representation of the alarm data.").isNotNull();
	}

	private void checkInvalidFieldType(Map<String, ? > fields) {
		try {
			new AlarmData(fields);
			fail("The alarm data is built with invalid fields: " + fields);
		} catch (ClassCastException cce) {
			// go ahead, it's expected
		}
	}

	private void checkAlarmDataFields(long timestamp, Map<String, ? > metadata,
			int severity, int type, AlarmData actualData) {
		super.assertFunctionDataFields(timestamp, metadata, actualData);
		assertThat(actualData.getSeverity()).as("The severity is not correct!").isEqualTo(severity);
		assertThat(actualData.getType()).as("The alarm is not correct!").isEqualTo(type);
	}
}
