/*
 * Copyright 2003-2004 The Apache Software Foundation
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
 */
package org.apache.commons.dbutils;

import java.util.Iterator;

/**
 * ResultSetIteratorTest
 */
public class ResultSetIteratorTest extends BaseTestCase {

	/**
	 * Constructor for ResultSetIteratorTest.
	 * @param arg0
	 */
	public ResultSetIteratorTest(String arg0) {
		super(arg0);
	}

	public void testNext() {
		
		Iterator iter = new ResultSetIterator(this.rs);

		int rowCount = 0;
		Object[] row = null;
		while (iter.hasNext()) {
			rowCount++;
			row = (Object[]) iter.next();

			assertNotNull(row);
			assertEquals(COLS, row.length);
		}

		assertEquals(ROWS, rowCount);
		assertEquals("4", row[0]);
		assertEquals("5", row[1]);
		assertEquals("6", row[2]);
	}

}
