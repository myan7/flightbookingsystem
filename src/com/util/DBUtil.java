/**
 * 
 */
package com.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author: Administrator
 * @date: Jan 3, 2018
 */
public class DBUtil {
	static
	{
//		1. load the driver
		try 
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
		}
		catch(ClassNotFoundException e)
		{
			e.printStackTrace();
		}
	}
	
	public static Connection getMeConnectionObj()
	{
		Connection con = null;

//		2. Establish the Connection
		try
		{
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521/orcl", "system", "oracle");
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		return con;
	}
}
