package DataDrivenTesting;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ReadingDataFrompropertiesFile {
	public static void main(String[] args) throws IOException {
		//step 1:convert the file into object
		FileInputStream fis=new FileInputStream("./src/test/resources/propertyfile.properties");
		
		//step 2:create instance for properties file
		Properties property=new Properties();
		
		//step 3: load file into properties file
		property.load(fis);
		
		//step 4:fetch the data from the properties file
		System.out.println(property.getProperty("URL"));
		System.out.println(property.getProperty("Password"));
		System.out.println(property.getProperty("UserName"));
		System.out.println(property.getProperty("Timeouts"));
		System.out.println(property.getProperty("Website"));
	

}
}
