/**
 * 
 */
package vtiger.GenericUtilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * @author Sushma Akki
 *
 */
public class PropertyfileUtility {

		/**
		 * This method will read data from property file 
		 * @param key
		 * @return
		 * @throws IOException 
		 * 
		 */
		public String readDataFromPropertyFile(String key) throws IOException
		{
			FileInputStream fisp = new FileInputStream(IContactUtility.propertyfilepath);
			Properties pObj = new Properties();
			pObj.load(fisp);
			String value = pObj.getProperty(key);
			return value;
		}

}
