/**
 * 
 */
package ar.com.crupierlb.crupier;

import java.util.Locale;
import java.util.ResourceBundle;

import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ar.com.crupierlb.crupier.server.EchoServer;

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
		logger.info("Hello World");
		
		// TODO: mover a setup y validacion de configuration file
		PropertiesConfiguration pc = null;
		try
		{
			pc = new PropertiesConfiguration("crupier.properties");
		}
		catch (ConfigurationException e1)
		{
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		int port = pc.getInt("listen.port");
		
		try
		{
			new EchoServer(port).start();
		}
		catch (Exception e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
}
