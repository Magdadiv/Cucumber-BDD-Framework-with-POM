package Utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
	
	/**
	 * This method will load properties from config.properties file
	 * @return it returns properties prop object
	 */

	public Properties loadproperties() {
		Properties prop = new Properties();
		
		try {
			
			FileInputStream input = new FileInputStream("./src/test/resources/config/config.properties");
			try {
				prop.load(input);
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		}
		return prop;
	}
}
