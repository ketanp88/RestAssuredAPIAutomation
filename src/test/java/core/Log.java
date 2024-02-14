package core;

import org.apache.logging.log4j.*;


public class Log {

	//private static Logger log = LogManager.getLogger(Log.class);
	
	public static void info(String message)
	{
		Logger log = LogManager.getLogger(Log.class);
		log.info(message);
		consoleLog(message);
	}
	
	public static void error(String message)
	{
		Logger log = LogManager.getLogger(Log.class);
		log.info(message);
		consoleLog(message);
	}
	
	public static void verify(String message)
	{
		Logger log = LogManager.getLogger(Log.class);
		if(message.contains("FAILED"))
		{
			log.error(message);
			consoleLog(message);
		}
		else
		{
			log.info(message);
			consoleLog(message);
		}
		
	}
	
	public static void consoleLog(String message)
	{
		System.out.println(message);
	}
}
