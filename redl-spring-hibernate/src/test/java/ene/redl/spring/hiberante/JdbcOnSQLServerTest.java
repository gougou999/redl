package ene.redl.spring.hiberante;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
@SuppressWarnings("unused")
public class JdbcOnSQLServerTest {
	public static void main(String[] args) {
		
		String connectionUrl = "jdbc:sqlserver://localhost:1433;"    
                + "databaseName=AdventureWorks;integratedSecurity=true;";    
    
        String url = "jdbc:sqlserver://localhost:1433;databaseName=redl;user=redl;password=redl";//sa身份连接    
    
        String url2 = "jdbc:sqlserver://127.0.0.1:1433;databaseName=redl;integratedSecurity=true;";//windows集成模式连接    
    
        // Declare the JDBC objects.    
        Connection con = null;    
        Statement stmt = null;    
        ResultSet rs = null;    
        String sql = "SELECT TOP 1000 [Id],[CookieId] ,[Title],[UserId]"
        		+ ",[BizName] FROM [redl].[dbo].[Lt_Stats201501]";
        try {    
            // Establish the connection.    
            System.out.println("begin.");    
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");    
            con = DriverManager.getConnection(url2);
            stmt = con.createStatement();
            rs = stmt.executeQuery(sql);
            if(rs.next()){
            	System.out.println(rs.getInt(1));
            }
        }catch(Exception e){
        	e.printStackTrace();
        }
	}
}
