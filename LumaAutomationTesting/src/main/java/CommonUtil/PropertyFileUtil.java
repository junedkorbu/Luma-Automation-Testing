package CommonUtil;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertyFileUtil {

	public String getDataFromPropertyFile(String Keyname) throws IOException
	{
		FileInputStream fis = new FileInputStream("src/test/resources/LumaDDT.properties");
		
		Properties p = new Properties();
		
		p.load(fis);
		
		return p.getProperty(Keyname);
	}
}
