package fr.epita.core.tanmoy.test;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;

import fr.epita.iam.iamcore.tests.TestLog4j2Usage;

public class TestLog4j2 {
	
	private static final Logger LOGGER = LogManager.getLogger(TestLog4j2Usage.class);
	
	
	@Test
	public void testLog4J2(){
		LOGGER.info("this is an info message with parameter : {}", "parameter");
		
	}
	
}


}
