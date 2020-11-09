package com.revature.michael_mcauliffe_p0.dao;

import static org.junit.Assert.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import com.revature.michael_mcauliffe_p0.pojos.Track;
import com.revature.michael_mcauliffe_p0.util.ConnectionUtil;

public class TrackPostgresTest {

	public TrackDaoPostgres trackDao = new TrackDaoPostgres();
	
	@Mock
	private ConnectionUtil connUtil;
	
	@Mock
	private Connection connection;
	
	private PreparedStatement stmt;
	
	private PreparedStatement spy;
	
	private Connection realConnection;
	
	private String sql;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		
		realConnection = new ConnectionUtil().createConnection();
		
		stmt = realConnection.prepareStatement(sql); 
		
		spy = Mockito.spy(stmt);

		when(connection.createStatement()).thenReturn(spy);
		when(connUtil.createConnection()).thenReturn(connection);
		
		trackDao.setConnUtil(connUtil);
	}

	@After
	public void tearDown() throws Exception {
		
		realConnection.close();
	}

	@Test
	public void addTrackTest() throws SQLException {
		
		Track track = new Track("Hip to be Square", "Fore!", "Heuy Lewis and the News");
		
		trackDao.addTrack(track);
		
		sql = "insert into tracks (track_title, album_title, artist_name)"
				+ " values (?, ?, ?);";
		
		connection.setAutoCommit(false);
		
		spy.setString(1, track.getTrackTitle());
		spy.setString(2, track.getAlbumTitle());
		spy.setString(3, track.getArtistName());
		
		int rowsAffected = verify(spy).executeUpdate();
		
		ResultSetMetaData rsmd = stmt.getMetaData();
		
		System.out.println(rsmd.toString());
		
		connection.rollback();
		
		connection.setAutoCommit(true);
		
		fail("Not yet implemented");
	}

}
