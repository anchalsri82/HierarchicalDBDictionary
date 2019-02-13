import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;

public class DictionaryClass {
	
  private Connection connect = null;
  private Statement statement = null;
  private PreparedStatement preparedStatement = null;
  private ResultSet resultSet = null;


  public void openDBConnection() throws Exception {
    try {
		System.out.println("Hello World from OTS-connectDB");

      // This will load the Oracle driver, each DB has its own driver
      Class.forName("oracle.jdbc.OracleDriver");
      
      // Setup the connection with the DB
//      connect = DriverManager
//              .getConnection("jdbc:oracle:thin:@192.168.56.3:1521:orclcdb", "system", "oracle");
      connect = DriverManager
              .getConnection("jdbc:oracle:thin:@localhost:1521:orclcdb", "system", "oracle");

      System.out.println("Connection was :" + connect);
      // Statements allow to issue SQL queries to the database
      statement = connect.createStatement();
      // Result set get the result of the SQL query
    
      connect.setAutoCommit(true);
      
    } catch (Exception e) {
      throw e;
    } finally {

    }

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
  protected void closeDbConnection() {
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
