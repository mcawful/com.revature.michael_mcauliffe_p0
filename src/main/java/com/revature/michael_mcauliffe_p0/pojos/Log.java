package com.revature.michael_mcauliffe_p0.pojos;

import org.apache.log4j.Logger;

public class Log {

	private static Logger log;
	
	public void info(Object ob) {
		
		log.info(ob);
	}
	
	public Log() {
		
		log = Logger.getRootLogger();
	}
	
	public void sessionStarted() {
		
		log.info("Session has started.");
	}
	
	public void sessionEnded() {
		
		log.info("Session has ended.\n");
	}
}
