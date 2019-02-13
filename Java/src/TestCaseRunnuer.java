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
    public void multiplicationOfZeroIntegersShouldReturnZero4() {
//Trying to find how can we compare map in JUnit.
		try {
			Map<String, String> local_map = new HashMap<String, String>();
//			local_map.put("sunil","book4");
//			local_map.put("bapi","book2");
//			local_map.put("pallav","book3");
//			local_map.put("anchal","book3");
			
			DictionaryClass dao = new DictionaryClass();
			dao.openDBConnection();
			//assertEquals(local_map, dao.GetDictionary("TraderBookMapping"));
			local_map = dao.GetDictionaryFromType("TraderBookMapping");
			 //assertThat(local_map, IsMapContaining.hasEntry("sunil","book4"));
			//assertEquals( local_map, setB );
	    
		} catch (Exception e) {
			e.printStackTrace();
		}
    }

}
