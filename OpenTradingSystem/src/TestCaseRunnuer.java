import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.Test;

public class TestCaseRunnuer {

    @Test
    public void test_GetValueFromTypeAndKey() {

    	DictionaryClass dao = new DictionaryClass();
		try {
			dao.openDBConnection();
			assertEquals("book3", dao.GetValueFromTypeAndKey("TraderBookMapping","anchal"));
			assertEquals("book3", dao.GetValueFromTypeAndKey("TraderBookMapping","anchal"));
			assertEquals("book3", dao.GetValueFromTypeAndKey("TraderBookMapping","anchal"));
		} catch (Exception e) {
			e.printStackTrace();
		}
    }
  
    @Test
    public void test_GetEntireDictionaryFromType() {
//Trying to find how can we compare map in JUnit.
		try {
			Map<String, String> local_map = new HashMap<String, String>();
			Map<String, String> local_map_2 = new HashMap<String, String>();
			local_map.put("sunil","book4");
			local_map.put("bapi","book2");
			local_map.put("pallav","book3");
			local_map.put("anchal","book3");
			
			DictionaryClass dao = new DictionaryClass();
			dao.openDBConnection();
			local_map_2 = dao.GetDictionaryFromType("TraderBookMapping");
			assertTrue(local_map.equals(local_map_2));
	    
		} catch (Exception e) {
			e.printStackTrace();
		}
    }

}