package fr.epita.core.tanmoy.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.inject.Inject;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.BeforeClass;
import org.junit.Test;

import fr.epita.core.datamodel.Identity;
import fr.epita.core.tanmoy.test.TestSpring;
import fr.epita.core.services.IdentityJDBCDAO;

public class TestSpring {

	@Inject
	IdentityJDBCDAO dao;	
	
	private static final Logger LOGGER = LogManager.getLogger(TestSpring.class);
	

	@BeforeClass
	public static void globalSetup() throws SQLException{
		LOGGER.info("beginning the setup");
		Connection connection = getConnection();
		PreparedStatement pstmt = connection.prepareStatement("CREATE TABLE IDENTITIES " 
	    + " (IDENTITIES_UID INT NOT NULL GENERATED ALWAYS AS IDENTITY CONSTRAINT IDENTITIES_PK PRIMARY KEY, " 
	    + " IDENTITIES_DISPLAYNAME VARCHAR(255), "
	    + " IDENTITIES_EMAIL VARCHAR(255), "
	    + " IDENTITIES_BIRTHDATE DATE "
	    + " )");
		
		pstmt.execute();
		connection.commit();
		pstmt.close();
		connection.close();
		LOGGER.info("setup finished : ready to proceed with the testcase");
		
	}
	
	/**
	 * @return
	 * @throws SQLException
	 */
	private static Connection getConnection() throws SQLException {
		Connection connection = DriverManager.getConnection("jdbc:derby://localhost:1527/sample;create=true", "ZAC", "ZAC");
		return connection;
	}
	
	
	
	@Test
	public void testSpringContext() throws SQLException{
		dao.writeIdentity(new Identity(null, "Zac", "zcobain.36@gmail.com"));
	}

}
