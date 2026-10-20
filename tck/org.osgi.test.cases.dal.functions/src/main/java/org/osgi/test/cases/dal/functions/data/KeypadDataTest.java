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
import org.osgi.service.dal.functions.data.KeypadData;
import org.osgi.test.cases.dal.functions.AbstractFunctionTest;

/**
 * Validates the {@code KeypadData} data structure.
 */
public final class KeypadDataTest extends AbstractFunctionTest {

	private static final int	KEY_CODE	= 8;
	private static final String	KEY_NAME	= "Backspace";

	/**
	 * Checks {@link KeypadData#equals(Object)} method.
	 */
	@Test
	public void testEquals() {
		// check without metadata
		KeypadData data = new KeypadData(
				Long.MIN_VALUE,
				null,
				KeypadData.TYPE_PRESSED,
				KeypadData.SUB_TYPE_PRESSED_NORMAL,
				KEY_CODE,
				KEY_NAME);
		assertThat(data).as("The keypad data comparison is wrong!").isEqualTo(data);
		assertThat(new KeypadData(
						Long.MIN_VALUE,
						null,
						KeypadData.TYPE_PRESSED,
						KeypadData.SUB_TYPE_PRESSED_NORMAL,
						KEY_CODE,
						KEY_NAME)).as("The keypad data comparison is wrong!").isEqualTo(data);

		// check with metadata
		Map<String,Object> metadata = new HashMap<>();
		metadata.put(FunctionData.DESCRIPTION, "test-description");
		data = new KeypadData(
				Long.MIN_VALUE,
				metadata,
				KeypadData.TYPE_PRESSED,
				KeypadData.SUB_TYPE_PRESSED_NORMAL,
				KEY_CODE,
				KEY_NAME);
		assertThat(data).as("The keypad data comparison is wrong!").isEqualTo(data);
		assertThat(new KeypadData(
						Long.MIN_VALUE,
						metadata,
						KeypadData.TYPE_PRESSED,
						KeypadData.SUB_TYPE_PRESSED_NORMAL,
						KEY_CODE,
						KEY_NAME)).as("The keypad data comparison is wrong!").isEqualTo(data);

		// check with fields map
		Map<String,Object> fields = new HashMap<>();
		fields.put(KeypadData.FIELD_TYPE, Integer.valueOf(KeypadData.TYPE_PRESSED));
		fields.put(KeypadData.FIELD_SUB_TYPE, Integer.valueOf(KeypadData.SUB_TYPE_PRESSED_NORMAL));
		fields.put(KeypadData.FIELD_KEY_CODE, Integer.valueOf(KEY_CODE));
		fields.put(KeypadData.FIELD_KEY_NAME, KEY_NAME);
		fields.put(FunctionData.FIELD_METADATA, metadata);
		fields.put(FunctionData.FIELD_TIMESTAMP, Long.valueOf(Long.MIN_VALUE));
		data = new KeypadData(fields);
		assertThat(data).as("The keypad data comparison is wrong!").isEqualTo(data);
		assertThat(new KeypadData(
						Long.MIN_VALUE,
						metadata,
						KeypadData.TYPE_PRESSED,
						KeypadData.SUB_TYPE_PRESSED_NORMAL,
						KEY_CODE,
						KEY_NAME)).as("The keypad data comparison is wrong!").isEqualTo(data);
	}

	/**
	 * Checks {@link KeypadData#compareTo(Object)} with {@code KeypadData}.
	 */
	@Test
	public void testComparison() {
		// check without metadata
		KeypadData data = new KeypadData(
				Long.MIN_VALUE,
				null,
				KeypadData.TYPE_PRESSED,
				KeypadData.SUB_TYPE_PRESSED_NORMAL,
				KEY_CODE,
				KEY_NAME);
		assertThat(data.compareTo(data)).as("The keypad data comparison is wrong!").isZero();
		assertThat(data.compareTo(
				new KeypadData(
						Long.MIN_VALUE,
						null,
						KeypadData.TYPE_PRESSED,
						KeypadData.SUB_TYPE_PRESSED_NORMAL,
						KEY_CODE,
						KEY_NAME))).as("The keypad data comparison is wrong!").isZero();

		// check with metadata
		Map<String,Object> metadata = new HashMap<>();
		metadata.put(FunctionData.DESCRIPTION, "test-description");
		data = new KeypadData(
				Long.MIN_VALUE,
				metadata,
				KeypadData.TYPE_PRESSED,
				KeypadData.SUB_TYPE_PRESSED_NORMAL,
				KEY_CODE,
				KEY_NAME);
		assertThat(data.compareTo(data)).as("The keypad data comparison is wrong!").isZero();
		assertThat(data.compareTo(
				new KeypadData(
						Long.MIN_VALUE,
						metadata,
						KeypadData.TYPE_PRESSED,
						KeypadData.SUB_TYPE_PRESSED_NORMAL,
						KEY_CODE,
						KEY_NAME))).as("The keypad data comparison is wrong!").isZero();

		// check with fields map
		Map<String,Object> fields = new HashMap<>();
		fields.put(KeypadData.FIELD_TYPE, Integer.valueOf(KeypadData.TYPE_PRESSED));
		fields.put(KeypadData.FIELD_SUB_TYPE, Integer.valueOf(KeypadData.SUB_TYPE_PRESSED_NORMAL));
		fields.put(KeypadData.FIELD_KEY_CODE, Integer.valueOf(KEY_CODE));
		fields.put(KeypadData.FIELD_KEY_NAME, KEY_NAME);
		fields.put(FunctionData.FIELD_METADATA, metadata);
		fields.put(FunctionData.FIELD_TIMESTAMP, Long.valueOf(Long.MIN_VALUE));
		data = new KeypadData(fields);
		assertThat(data.compareTo(data)).as("The keypad data comparison is wrong!").isZero();
		assertThat(data.compareTo(
				new KeypadData(
						Long.MIN_VALUE,
						metadata,
						KeypadData.TYPE_PRESSED,
						KeypadData.SUB_TYPE_PRESSED_NORMAL,
						KEY_CODE,
						KEY_NAME))).as("The keypad data comparison is wrong!").isZero();
	}

	/**
	 * Checks {@link KeypadData#hashCode()}.
	 */
	@Test
	public void testHashCode() {
		// check without metadata
		KeypadData data = new KeypadData(
				Long.MIN_VALUE,
				null,
				KeypadData.TYPE_PRESSED,
				KeypadData.SUB_TYPE_PRESSED_NORMAL,
				KEY_CODE,
				KEY_NAME);
		assertThat(data.hashCode()).as("The keypad data hash code is wrong!").isEqualTo(data.hashCode());
		assertThat((new KeypadData(
						Long.MIN_VALUE,
						null,
						KeypadData.TYPE_PRESSED,
						KeypadData.SUB_TYPE_PRESSED_NORMAL,
						KEY_CODE,
						KEY_NAME)).hashCode()).as("The keypad data hash code is wrong!").isEqualTo(data.hashCode());

		// check with metadata
		Map<String,Object> metadata = new HashMap<>();
		metadata.put(FunctionData.DESCRIPTION, "test-description");
		data = new KeypadData(
				Long.MIN_VALUE,
				metadata,
				KeypadData.TYPE_PRESSED,
				KeypadData.SUB_TYPE_PRESSED_NORMAL,
				KEY_CODE,
				KEY_NAME);
		assertThat(data.hashCode()).as("The keypad data hash code is wrong!").isEqualTo(data.hashCode());
		assertThat((new KeypadData(
						Long.MIN_VALUE,
						metadata,
						KeypadData.TYPE_PRESSED,
						KeypadData.SUB_TYPE_PRESSED_NORMAL,
						KEY_CODE,
						KEY_NAME)).hashCode()).as("The keypad data hash code is wrong!").isEqualTo(data.hashCode());

		// check with fields map
		Map<String,Object> fields = new HashMap<>();
		fields.put(KeypadData.FIELD_TYPE, Integer.valueOf(KeypadData.TYPE_PRESSED));
		fields.put(KeypadData.FIELD_TYPE, Integer.valueOf(KeypadData.SUB_TYPE_PRESSED_NORMAL));
		fields.put(KeypadData.FIELD_KEY_CODE, Integer.valueOf(KEY_CODE));
		fields.put(KeypadData.FIELD_KEY_NAME, KEY_NAME);
		fields.put(FunctionData.FIELD_METADATA, metadata);
		fields.put(FunctionData.FIELD_TIMESTAMP, Long.valueOf(Long.MIN_VALUE));
		data = new KeypadData(fields);
		assertThat(data.hashCode()).as("The keypad data hash code is wrong!").isEqualTo(data.hashCode());
		assertThat((new KeypadData(
						Long.MIN_VALUE,
						metadata,
						KeypadData.TYPE_PRESSED,
						KeypadData.SUB_TYPE_PRESSED_NORMAL,
						KEY_CODE,
						KEY_NAME)).hashCode()).as("The keypad data hash code is wrong!").isEqualTo(data.hashCode());
	}

	/**
	 * Checks {@code KeypadData} field values.
	 */
	@Test
	public void testFields() {
		// check without metadata
		KeypadData data = new KeypadData(
				Long.MIN_VALUE,
				null,
				KeypadData.TYPE_PRESSED,
				KeypadData.SUB_TYPE_PRESSED_NORMAL,
				KEY_CODE,
				KEY_NAME);
		checkKeypadDataFields(
				Long.MIN_VALUE,
				null,
				KeypadData.TYPE_PRESSED,
				KeypadData.SUB_TYPE_PRESSED_NORMAL,
				KEY_CODE,
				KEY_NAME,
				data);

		// check with metadata
		Map<String,Object> metadata = new HashMap<>();
		metadata.put(FunctionData.DESCRIPTION, "test-description");
		data = new KeypadData(
				Long.MIN_VALUE,
				metadata,
				KeypadData.TYPE_PRESSED,
				KeypadData.SUB_TYPE_PRESSED_NORMAL,
				KEY_CODE,
				KEY_NAME);
		checkKeypadDataFields(
				Long.MIN_VALUE,
				metadata,
				KeypadData.TYPE_PRESSED,
				KeypadData.SUB_TYPE_PRESSED_NORMAL,
				KEY_CODE,
				KEY_NAME,
				data);

		// check with fields map
		Map<String,Object> fields = new HashMap<>();
		fields.put(KeypadData.FIELD_TYPE, Integer.valueOf(KeypadData.TYPE_PRESSED));
		fields.put(KeypadData.FIELD_SUB_TYPE, Integer.valueOf(KeypadData.SUB_TYPE_PRESSED_NORMAL));
		fields.put(KeypadData.FIELD_KEY_CODE, Integer.valueOf(KEY_CODE));
		fields.put(KeypadData.FIELD_KEY_NAME, KEY_NAME);
		fields.put(FunctionData.FIELD_METADATA, metadata);
		fields.put(FunctionData.FIELD_TIMESTAMP, Long.valueOf(Long.MIN_VALUE));
		data = new KeypadData(fields);
		checkKeypadDataFields(
				Long.MIN_VALUE,
				metadata,
				KeypadData.TYPE_PRESSED,
				KeypadData.SUB_TYPE_PRESSED_NORMAL,
				KEY_CODE,
				KEY_NAME,
				data);
	}

	/**
	 * Checks the {@code KeypadData} construction with invalid fields.
	 */
	@Test
	public void testInvalidFields() {
		Map<String,Object> fields = new HashMap<>();
		fields.put(KeypadData.FIELD_TYPE, "invalid-event-type");
		fields.put(KeypadData.FIELD_KEY_CODE, Integer.valueOf(KEY_CODE));
		checkInvalidFieldType(fields);

		fields.clear();
		fields.put(KeypadData.FIELD_TYPE, Integer.valueOf(KeypadData.TYPE_PRESSED));
		fields.put(KeypadData.FIELD_KEY_CODE, Integer.valueOf(KEY_CODE));
		fields.put(KeypadData.FIELD_SUB_TYPE, "invalid-event-sub-type");
		checkInvalidFieldType(fields);

		fields.clear();
		fields.put(KeypadData.FIELD_TYPE, Integer.valueOf(KeypadData.TYPE_PRESSED));
		fields.put(KeypadData.FIELD_KEY_CODE, "invalid-key-code");
		checkInvalidFieldType(fields);

		fields.clear();
		fields.put(KeypadData.FIELD_TYPE, Integer.valueOf(KeypadData.TYPE_PRESSED));
		fields.put(KeypadData.FIELD_KEY_CODE, Integer.valueOf(KEY_CODE));
		fields.put(KeypadData.FIELD_KEY_NAME, Integer.valueOf(Integer.MAX_VALUE));
		checkInvalidFieldType(fields);

		fields.clear();
		fields.put(KeypadData.FIELD_TYPE, Integer.valueOf(KeypadData.TYPE_PRESSED));
		fields.put(KeypadData.FIELD_KEY_CODE, Integer.valueOf(KEY_CODE));
		fields.put(FunctionData.FIELD_METADATA, Boolean.TRUE);
		checkInvalidFieldType(fields);

		fields.clear();
		fields.put(KeypadData.FIELD_TYPE, Integer.valueOf(KeypadData.TYPE_PRESSED));
		fields.put(KeypadData.FIELD_KEY_CODE, Integer.valueOf(KEY_CODE));
		fields.put(FunctionData.FIELD_TIMESTAMP, Boolean.TRUE);
		checkInvalidFieldType(fields);

		fields.clear();
		try {
			new KeypadData(fields);
			fail("The keypad data is built with empty fields.");
		} catch (IllegalArgumentException iae) {
			// go ahead, it's expected
		}

		try {
			new KeypadData(null);
			fail("The keypad data is built with null fields");
		} catch (NullPointerException npe) { // NOPMD
			// go ahead, it's expected
		}
	}

	/**
	 * Checks the {@code KeypadData} construction with invalid sub-types.
	 */
	@Test
	public void testInvalidSubtypes() {
		checkInvalidSubtype(KeypadData.TYPE_RELEASED, KeypadData.SUB_TYPE_PRESSED_NORMAL);
		checkInvalidSubtype(KeypadData.TYPE_RELEASED, KeypadData.SUB_TYPE_PRESSED_LONG);
		checkInvalidSubtype(KeypadData.TYPE_RELEASED, KeypadData.SUB_TYPE_PRESSED_DOUBLE);
		checkInvalidSubtype(KeypadData.TYPE_RELEASED, KeypadData.SUB_TYPE_PRESSED_DOUBLE_LONG);
	}

	/**
	 * Checks {@link KeypadData#toString()}.
	 */
	@Test
	public void testToString() {
		KeypadData keypadData = new KeypadData(
				System.currentTimeMillis(),
				new HashMap<>(),
				KeypadData.TYPE_PRESSED,
				KeypadData.SUB_TYPE_PRESSED_LONG,
				Integer.MIN_VALUE,
				"test-key-name");
		assertThat(keypadData.toString()).as("There is no string representation of the keypad data.").isNotNull();
		keypadData = new KeypadData(
				Long.MIN_VALUE,
				null,
				KeypadData.TYPE_PRESSED,
				Integer.MIN_VALUE,
				Integer.MIN_VALUE,
				null);
		assertThat(keypadData.toString()).as("There is no string representation of the keypad data.").isNotNull();
	}

	private void checkInvalidSubtype(int type, int subType) {
		try {
			new KeypadData(
					Long.MIN_VALUE,
					null,
					type,
					subType,
					KEY_CODE,
					KEY_NAME);
			fail("KeypadData has been built with invalid combination of type: " + type +
					" and sub-type: " + subType);
		} catch (IllegalArgumentException iae) {
			// expected, go ahead
		}
	}

	private void checkInvalidFieldType(Map<String, ? > fields) {
		try {
			new KeypadData(fields);
			fail("The keypad data is built with invalid fields: " + fields);
		} catch (ClassCastException cce) {
			// go ahead, it's expected
		}
	}

	private void checkKeypadDataFields(
			long timestamp,
			Map<String, ? > metadata,
			int type,
			int subType,
			int keyCode,
			String keyName,
			KeypadData actualData) {
		super.assertFunctionDataFields(timestamp, metadata, actualData);
		// event type
		assertThat(actualData.getType()).as("The event type is not correct!").isEqualTo(type);

		// event sub-type
		assertThat(actualData.getSubType()).as("The event sub-type is not correct!").isEqualTo(subType);

		// key code
		assertThat(actualData.getKeyCode()).as("The key code is not correct!").isEqualTo(keyCode);

		// key name
		assertThat(actualData.getKeyName()).as("The key name is not correct!").isEqualTo(keyName);
	}
}
