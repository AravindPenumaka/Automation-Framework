package utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import org.testng.annotations.Test;

public class DBConnection {
	
	private Connection con = null;
	private Statement stmt;
	private ResultSet rs;
	
	/***
	 * @author Brahma
	 * @return Connection
	 * @description To connect to the oracle database
	 */
	public Connection getDBConnection() {
		try {
			Properties prop = new Properties();
			prop.load(new FileInputStream("DBConfig.properties"));
			Class.forName(prop.getProperty("driver")); // Load the JDBC driver class
			System.out.println("Driver Loaded");

			// To create the connection object
			String connectionURL = "jdbc:oracle:thin:@(DESCRIPTION=(ADDRESS=(PROTOCOL=TCP)(HOST="
					+ prop.getProperty("hostName") + ")(PORT=" + prop.getProperty("port")
					+ "))(CONNECT_DATA=(SERVICE_NAME=" + prop.getProperty("serviceName") + ")))";
			con = DriverManager.getConnection(connectionURL, prop.getProperty("username"),
					prop.getProperty("password"));
			System.out.println("Connection Created");
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return con;
	}
	
	/***
	 * @author Barhma
	 * @description To close DBconnection
	 */
	public void closeDBConnection(){
		try {
			rs.close();
			stmt.close();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	/***
	 * @author Brahma
	 * @param query
	 * @param colmIndex
	 * @description Retrive the value from query with given columnIndex 
	 */
	public void executeSQLQuery(Connection con, String query, int colmIndex){
		try {
			stmt = con.createStatement(); // Create the statement object
			rs = stmt.executeQuery(query); // Execute query
			while (rs.next()){
				
				String result = rs.getString(colmIndex);
				System.out.println(result);
				System.out.println("1stColumnValue::" + rs.getString(1) + "  " + "2ndColumnValue::" + rs.getString(2) + "  " + "3rdColumnValue::" + rs.getString(3) + "  " + "4thColumnValue::" + rs.getString(4));
				System.out.println("******************");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	/***
	 * @author Brahma
	 * @param query
	 * @param colmIndex
	 * @description Retrive the value from query with given columnIndex 
	 */
	public void executeSQLQuery(Connection con, String query, String colmName1, String colmName2){
		try {
			stmt = con.createStatement(); // Create the statement object
			rs = stmt.executeQuery(query); // Execute query
			while (rs.next()){
				
				String result1 = rs.getString(colmName1);
				String result2 = rs.getString(colmName2);
				System.out.println(result1 + " ----- " + result2);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	/***
	 * @author Brahma
	 * @param query
	 * @param colmIndex
	 * @description Retrive the value with given query 
	 */
	public void executeSQLQuery(Connection con, String query){
		try {
			stmt = con.createStatement(); // Create the statement object
			rs = stmt.executeQuery(query); // Execute query
			
			//ResultSet rs = stmt.executeQuery("SELECT a, b, c FROM TABLE2");
			 ResultSetMetaData rsmd = rs.getMetaData();
			 
			 
			while (rs.next()){
				String name = rsmd.getColumnName(1);
				System.out.println("1stColumnValue::" + rs.getString(1) + "  " + "2ndColumnValue::" + rs.getString(2)
						+ "  " + "3rdColumnValue::" + rs.getString(3) + "  " + "4thColumnValue::" + rs.getString(4));
				System.out.println("---------------------------");
				
			}
			System.out.println("Successfully Retrieved Data");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	/***
	 * @author Brahma
	 * @param query
	 * @param colmIndex
	 * @description Retrive the column names of given query table 
	 */
	public void getColumnNameByExecuteSQLQuery(Connection con, String query){
		try {
			stmt = con.createStatement(); // Create the statement object
			rs = stmt.executeQuery(query); // Execute query
			
			 ResultSetMetaData rsmd = rs.getMetaData();
			 int columnCount = rsmd.getColumnCount();
			 System.out.println(columnCount);
			 
			 for (int i = 1; i <= columnCount; i++ ) {
				  String name = rsmd.getColumnName(i);
				  System.out.println(name);
				}
			 
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	//@Test
	public void test(){
		Connection getCon = getDBConnection();
		executeSQLQuery(getCon , "select * from dossier");
		closeDBConnection();
	}
	
	@Test
	public void getDBData(){
		Connection getCon = getDBConnection();
		executeSQLQuery(getCon , "select * from dossier WHERE dosid='4445536'");
		closeDBConnection();
	}
}
