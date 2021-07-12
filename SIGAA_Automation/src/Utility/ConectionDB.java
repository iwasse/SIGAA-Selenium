package Utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class ConectionDB {
	
	
	private static Connection connectToDatabaseOrDie()
	  {
	    Connection conn = null;
	    try
	    {
	      Class.forName("org.postgresql.Driver");
	      String url = "jdbc:postgresql://200.137.217.51:5432/testes_sigaa_201608132209";
	      conn = DriverManager.getConnection(url,"sigaa", "s1g@@s1g");
	    }
	    catch (ClassNotFoundException e)
	    {
	      e.printStackTrace();
	      System.exit(1);
	    }
	    catch (SQLException e)
	    {
	      e.printStackTrace();
	      System.exit(2);
	    }
	    return conn;
	  }

	
	
	  private static void populateListOfTopics(Connection conn)
	  {
	    try 
	    {
	      Statement st = conn.createStatement();
	      ResultSet rs = st.executeQuery("SELECT id_discente_graduacao,escola_conclusao_medio  FROM graduacao.discente_"
	      		+ "graduacao where escola_conclusao_medio like 'COLÉGIO VISÃO';");
	      while ( rs.next() )
	      {
	      
	        System.out.println("Matriculas:" + rs.getInt("id_discente_graduacao"));
	      }
	      rs.close();
	      st.close();
	    }
	    catch (SQLException se) {
	      System.err.println("Threw a SQLException creating the list of blogs.");
	      System.err.println(se.getMessage());
	    }
	 }
	  public static void main(String[] args)
	  {
	    TestPrintBlogs();
	  }

	  public static void TestPrintBlogs() 
	  {
	    Connection conn = null;

	    // connect to the database
	    conn = connectToDatabaseOrDie();

	    // get the data
	    populateListOfTopics(conn);
   
	 
	  }
	 
	  
/* Teste De Conexão	
	public static void main(String[] argv) {

		System.out.println("-------- PostgreSQL "
				+ "JDBC Connection Testing ------------");

		try {

			Class.forName("org.postgresql.Driver");

		} catch (ClassNotFoundException e) {

			System.out.println("Where is your PostgreSQL JDBC Driver? "
					+ "Include in your library path!");
			e.printStackTrace();
			return;

		}

		System.out.println("PostgreSQL JDBC Driver Registered!");

		Connection connection = null;

		try {

			connection = DriverManager.getConnection(
					"jdbc:postgresql://200.137.217.51:5432/testes_sigaa_201608132209", "sigaa",
					"s1g@@s1g");

		} catch (SQLException e) {

			System.out.println("Connection Failed! Check output console");
			e.printStackTrace();
			return;

		}

		if (connection != null) {
			System.out.println("You made it, take control your database now!");
		} else {
			System.out.println("Failed to make connection!");
		}
	}
*/
}	
	

