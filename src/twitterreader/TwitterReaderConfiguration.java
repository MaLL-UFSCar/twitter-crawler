package twitterreader;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import utils.Log;
import utils.Symbol;

/**
 * Reads a configuration file to handle  the behavior of TwitterReader
 * @author Saulo Domingos de Souza Pedro
 * @version 1.0
 */
public class TwitterReaderConfiguration {
	
	private String[] userList;
	private String[] paramList;
	private int readMethod;
	private String twitterAuthConfigurationPath;
	
	public String[] getUserList() {
		return userList;
	}

	public void setUserList(String[] userList) {
		this.userList = userList;
	}

	public String[] getParamList() {
		return paramList;
	}

	public void setParamList(String[] paramList) {
		this.paramList = paramList;
	}

	public int getReadMethod() {
		return readMethod;
	}

	public void setReadMethod(int readMethod) {
		this.readMethod = readMethod;
	}

	public String getTwitterAuthConfigurationPath() {
		return twitterAuthConfigurationPath;
	}

	public void setTwitterAuthConfigurationPath(String twitterAuthConfigurationPath) {
		this.twitterAuthConfigurationPath = twitterAuthConfigurationPath;
	}

	/**
	 * Builds TwitterReaderConfiguration
	 * 
	 * It necessarily needs a configuration file named twitterreader.conf
	 * @param confFilePath Path to the configuration file for TwitterReader
	 */
	public TwitterReaderConfiguration(String confFilePath) {
		
		Log log = new Log();

		Properties properties = new Properties();
		InputStream inputStream;
		
		try {
			inputStream = new FileInputStream(confFilePath);
			properties.load(inputStream);
		} catch (FileNotFoundException e) {
			log.error("File "+confFilePath+ "not found!");
		} catch (IOException e) {
			e.printStackTrace();
		}

		//splits the users with the regular expression (colon)
		String[] splitUser = properties.getProperty("tr.userlist").split(";");
		String[] splitParam = properties.getProperty("tr.paramlist").split(";");
		this.setUserList(splitUser);
		this.setParamList(splitParam);
		
		if(properties.getProperty("tr.readMethod").equals("paramlist")){
			this.setReadMethod(Symbol.READ_FROM_PARAMLIST);
		} 
		else if(properties.getProperty("tr.readMethod").equals("userlist")){
			this.setReadMethod(Symbol.READ_FROM_USERLIST);
		}
		
		this.setTwitterAuthConfigurationPath(properties.getProperty("tr.twitterAuthFilePath"));

	}

}
