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
package org.apache.commons.dbutils.handlers;

import java.sql.SQLException;

import org.apache.commons.dbutils.BaseTestCase;
import org.apache.commons.dbutils.ResultSetHandler;

/**
 * ScalarHandlerTest
 */
public class ScalarHandlerTest extends BaseTestCase {

	/**
	 * Constructor for ScalarHandlerTest.
	 */
	public ScalarHandlerTest(String name) {
		super(name);
	}

	public void testHandle() throws SQLException {
		ResultSetHandler h = new ScalarHandler();
		Object results = (Object) h.handle(this.rs);

		assertNotNull(results);
		assertEquals("1", results);
	}

	public void testColumnIndexHandle() throws SQLException {
		ResultSetHandler h = new ScalarHandler(2);
		Object results = (Object) h.handle(this.rs);

		assertNotNull(results);
		assertEquals("2", results);
	}

	public void testColumnNameHandle() throws SQLException {
		ResultSetHandler h = new ScalarHandler("THree");
		Object results = (Object) h.handle(this.rs);

		assertNotNull(results);
		assertEquals("3", results);
	}

	public void testEmptyResultSetHandle() throws SQLException {
		ResultSetHandler h = new ScalarHandler();
		Object results = (Object) h.handle(this.emptyResultSet);

		assertNull(results);
	}

}
