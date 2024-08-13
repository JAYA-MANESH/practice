package DataDrivenTesting;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class WriteToPropertiesFile {
	public static void main(String[] args) throws IOException {
		//step 1:convert the file to properties file
		FileInputStream fis=new FileInputStream("./src/test/resources/propertyfile.properties");
		
		//step 2:create instance to properties file
		Properties property=new Properties();
		
		//step 3:load the file into properties file
		property.load(fis);
		
		//step 4:write into properties file
		property.put("Website", "vTiger");
		
		//step 5:save the changes
		FileOutputStream fos=new FileOutputStream("./src/test/resources/propertyfile.properties");
		property.store(fos, "Update is successfull");
		}
}
