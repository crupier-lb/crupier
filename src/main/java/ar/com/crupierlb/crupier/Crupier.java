/**
 * 
 */
package ar.com.crupierlb.crupier;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ar.com.crupierlb.crupier.server.CrupierServer;

/**
 * @author Gustavo
 * 
 */
public class Crupier
{
	private static Logger logger = LoggerFactory.getLogger(Crupier.class);

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		logger.info("Start reading config file");
		Config config = new Config();
		try
		{
			new CrupierServer(config.getLocalport()).start();
		}
		catch (Exception e)
		{
			logger.error("Can't start Crupier server, please review config file", e);
			throw new RuntimeException(e);
		}
	}

	
}
