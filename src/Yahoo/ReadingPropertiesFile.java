package Yahoo;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ReadingPropertiesFile {
	public static void main(String[] args) {
		

		try {
			
			Properties prop = new Properties();
			
			
			InputStream input = new FileInputStream("config.properties");
			prop.load(input);
			
			String val = prop.getProperty("key111");
			System.out.println(val);

		} catch (IOException ex) {
			ex.printStackTrace();
		} finally {
		
		}
	}
}
