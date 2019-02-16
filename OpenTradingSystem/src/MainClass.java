import Dictionary.DictionaryClass;;

public class MainClass {

	public static void main(String[] args) throws Exception {
		System.out.println("Hello World from OTS");
		
		//Connect Oracle DB.
		DictionaryClass dao = new DictionaryClass();
		//dao.openDBConnection();
		
		//Write a method string GetValue(string type, string key) which will return value 
		//when dictionary Type and Key are passed to the method.
		
		//Calling by hard-coded values.
		System.out.println(dao.GetValueFromTypeAndKey("TraderBookMapping", "anchal"));

		//Write a method Dictionary<string,string> GetDictionary(string type) which will return complete dictionary (all key, value pairs) if passed a dictionary type.
		dao.GetDictionaryFromType("TraderBookMapping");
		
		//Write a method Dictionary<string,Dictionary<string,string>> GetAllDictionaries(string type) which will return all dictionaries.		
		dao.GetAllDictionaryAvailable();
		
		//Close DB Connection
		dao.closeDbConnection();
	}
}
