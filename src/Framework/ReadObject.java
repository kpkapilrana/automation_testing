package Framework;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ReadObject {
	Properties p = new Properties();

	public Properties getObjectRepository() {
		
		try {
			// Read object repository file
			InputStream stream = new FileInputStream(
					new File("object.properties"));
			// load all objects
			p.load(stream);
		
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return p;
	}
}
