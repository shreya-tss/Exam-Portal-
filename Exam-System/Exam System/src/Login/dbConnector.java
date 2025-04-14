package Login;
import java.sql.*;

public class dbConnector {
	static final String jdbc_driver = "com.mysql.cj.jdbc.Driver";
	//static final String db_url = "jdbc:mysql://localhost/examsystem";
	static final String db_url = "jdbc:mysql://localhost:3306/examsystems";
	static String user="root",pass="tomriddle@31";
//static String user="root",pass="mysql";
	public static Connection conn = null;
	public dbConnector()
	{
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver"); // Register JDBC driver
			conn = DriverManager.getConnection( db_url , user , pass ); // Connect to Database 
			//System.out.println("Database Selected ");
		}catch(SQLException e)
		{
			//Exceptions in JDBC
			System.err.println("Exception  "+e.getMessage());
		}
		catch(Exception e)
		{
			//Exceptions in Class.forName()
			System.err.println("Exception  "+e.getMessage());
		}
		finally
		{
			//Close all connections
			
		}
	}
	
	public ResultSet executeQuery(String qry)
	{
		ResultSet rs =null;
		Statement stmt = null;
		try{
			stmt = this.conn.createStatement();
			rs = stmt.executeQuery(qry);
			}
			catch(Exception exp)
			{
				System.err.println("In qry : " +qry);
			}
			finally
			{
				try {
					stmt.close();
				} catch (SQLException exp) {
					// TODO Auto-generated catch block
					exp.printStackTrace();
				}
			}
		return rs;
		
	}

}
