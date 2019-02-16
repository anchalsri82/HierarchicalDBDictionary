package Dictionary;
import Dictionary.DBConnection;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;

public class DictionaryClass extends DBConnection{
	  
  
  public DictionaryClass() throws Exception {
		super();
		// TODO Auto-generated constructor stub
	}

//Write a method string GetValue(string type, string key) which will return value 
  //when dictionary Type and Key are passed to the method.
  
public String GetValueFromTypeAndKey(String type, String key) throws Exception {
	  
	  ResultSet rs = null;
	  try {

		  System.out.println("Hello World from OTS-GetValue");
		  System.out.println(type);
		  System.out.println(key);
		  preparedStatement = connect.prepareStatement("select VALUE from tbl_config where \n"
		  		+ "TYPE = ? AND KEY = ?");
		  preparedStatement.setString(1, type);
		  preparedStatement.setString(2, key);
		  
		 
		  rs = preparedStatement.executeQuery();
		  rs.next();
		  //System.out.println(rs.getString("VALUE"));

		  return rs.getString("VALUE");
		  
  } catch (Exception e) {
		  throw e;
	  }
	  finally {
		 // rs.beforeFirst();
		  rs.close();
	  }
  }
  
	//Write a method Dictionary<string,string> GetDictionary(string type) which will return complete dictionary (all key, value pairs) if passed a dictionary type.
  public Map<String, String> GetDictionaryFromType(String type) throws Exception
  {
	  Map<String, String> local_map = new HashMap<String, String>();
	  try {
		  System.out.println("Hello World from OTS-GetDictionary");
		  System.out.println(type);

		  preparedStatement = connect.prepareStatement("select KEY, VALUE from tbl_config where \n"
		  		+ "TYPE = ?");
		  preparedStatement.setString(1, type);		  
		  
		  ResultSet rs = preparedStatement.executeQuery();
		  while (rs.next())
		  {
			 local_map.put(rs.getString("KEY"),rs.getString("VALUE"));
		  }
		  for (Map.Entry<String, String> entry : local_map.entrySet())
		  {
		      System.out.println(entry.getKey() + "/" + entry.getValue());
		  }
		  return local_map;
	  }
	  catch (Exception e)
	  {
		  throw e;
	  }
  }
  
	//Write a method Dictionary<string,string> GetDictionary(string type) which will return complete dictionary (all key, value pairs) if passed a dictionary type.
  public Map<String, String> GetAllDictionaryAvailable() throws Exception
  {
	  Map<String, String> local_map = new HashMap<String, String>();
	  try {
		  System.out.println("Hello World from OTS-GetDictionary");

		  preparedStatement = connect.prepareStatement("select TYPE,KEY, VALUE from tbl_config");
		  
		  ResultSet rs = preparedStatement.executeQuery();
		  while (rs.next())
		  {
			 local_map.put(rs.getString("KEY"),rs.getString("VALUE"));
		  }
		  for (Map.Entry<String, String> entry : local_map.entrySet())
		  {
		      System.out.println(entry.getKey() + "/" + entry.getValue());
		  }
		  return local_map;
	  }
	  catch (Exception e)
	  {
		  throw e;
	  }
  }
  
  // You need to close the resultSet and DB Connection.
  public void closeDbConnection() {
    try {
      if (resultSet != null) {
        resultSet.close();
      }

      if (statement != null) {
        statement.close();
      }

      if (connect != null) {
        connect.close();
      }
      System.out.println("Connection closing...");
    } catch (Exception e) {

    }
  }

}