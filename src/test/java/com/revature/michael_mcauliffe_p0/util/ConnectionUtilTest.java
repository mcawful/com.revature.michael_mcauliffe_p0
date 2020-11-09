package com.revature.michael_mcauliffe_p0.util;

import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.SQLException;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class ConnectionUtilTest {

	private ConnectionUtil connectionUtil = new ConnectionUtil();
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() throws SQLException {
		
		Connection conn = connectionUtil.createConnection();
		assertFalse("Should return true if connection is established", conn.isClosed());
		conn.close();
	}
	
}
