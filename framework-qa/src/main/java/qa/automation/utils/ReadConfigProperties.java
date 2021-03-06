package qa.automation.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ReadConfigProperties {

	public static String getProperties(String properties) {
		String result = "";
		try (InputStream input = new FileInputStream("src/main/resources/config.properties")) {

			Properties prop = new Properties();

			// load a properties file
			prop.load(input);
			result = prop.getProperty(properties);

		} catch (IOException ex) {
			ex.printStackTrace();
		}
		return result;
	}
	
}
