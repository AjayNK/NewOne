package Generic_Component;
import java.io.*;
import java.util.*;

public class Utility {
	
	public String reading_Properties(String sKey) {
		try {
			FileInputStream fis = new FileInputStream("C:\\Users\\User\\eclipse-workspace_hybrid\\HybridFramework\\src\\test\\java\\browser.properties");
			Properties prop = new Properties();
			prop.load(fis);
			return prop.getProperty(sKey);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return sKey;
	}

}
