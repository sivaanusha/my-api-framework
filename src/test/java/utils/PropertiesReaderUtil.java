package utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.InvalidPropertiesFormatException;
import java.util.Properties;

public class PropertiesReaderUtil {

	private static PropertiesReaderUtil propertiesReaderUtil;
	
	private PropertiesReaderUtil() throws InvalidPropertiesFormatException, FileNotFoundException, IOException {
		
		Properties props = new Properties();
		props.load(new FileInputStream("config/config.properties"));
		System.getProperties().putAll(props);
		
	}
	
	
	public static PropertiesReaderUtil getInstance() throws InvalidPropertiesFormatException, FileNotFoundException, IOException {
		if(propertiesReaderUtil==null) {
			propertiesReaderUtil = new PropertiesReaderUtil();
		}
		return propertiesReaderUtil;
	}
}
