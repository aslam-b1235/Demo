package testUtility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class DempPropertiesClass {
	public static String readDataFromPropertiesFile(String key) throws IOException
	{
		FileInputStream myFile= new FileInputStream("C:\\Users\\91935\\git\\Demo\\demo.properties"); 
	     Properties prop=new Properties();
	     prop.load(myFile);
	     String value=prop.getProperty(key);
	     System.out.println(value);
	    return value;
	}

}
