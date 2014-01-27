/**
 * 
 */
package ar.com.crupierlb.crupier;

import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author gvaldez
 * 
 */
public class Config
{
	private static Logger logger = LoggerFactory.getLogger(Config.class);

	private int localport;

	public Config()
	{
		PropertiesConfiguration pc = readPropertiesFile();
		this.localport = readPropertiesEntries(pc);
	}

	private int readPropertiesEntries(PropertiesConfiguration pc)
	{
		int localportpropertie = 0;
		try
		{
			localportpropertie = pc.getInt("listen.port");
		}
		catch (Exception e)
		{
			logger.error("Cant read listen.port - review config file, it have to be a valid int port", e);
			throw new RuntimeException(e);
		}
		return localportpropertie;
	}

	private PropertiesConfiguration readPropertiesFile()
	{
		PropertiesConfiguration pc = null;
		try
		{
			pc = new PropertiesConfiguration("crupier.properties");
		}
		catch (ConfigurationException e)
		{
			logger.error("Cant read crupier.properties file - review config file. is missing", e);
			throw new RuntimeException(e);
		}
		return pc;
	}

	public int getLocalport()
	{
		return localport;
	}

	public void setLocalport(int localport)
	{
		this.localport = localport;
	}

}
