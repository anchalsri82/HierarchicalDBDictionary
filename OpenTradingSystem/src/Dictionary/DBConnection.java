package Dictionary;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

class DBConnection {
	  protected Connection connect = null;
	  protected Statement statement = null;
	  protected PreparedStatement preparedStatement = null;
	  protected ResultSet resultSet = null;


	  public DBConnection() throws Exception {
	    try {
			System.out.println("Hello World from OTS-connectDB");

	      // This will load the Oracle driver, each DB has its own driver
	      Class.forName("oracle.jdbc.OracleDriver");
	      
	      // Setup the connection with the DB
//	      connect = DriverManager
//	              .getConnection("jdbc:oracle:thin:@192.168.56.3:1521:orclcdb", "system", "oracle");
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
	  
	  public void closeDBConnection() throws Exception {

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
	  

