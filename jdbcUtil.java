/**
 * 
 */
/**
 * @author Administrator
 *
 */
package BMMI_System;
import java.sql.*;

import javax.swing.JOptionPane;

import java.lang.Class;
public class jdbcUtil{
public static class GetConn{//����
	static Statement sql=null;
	static ResultSet res=null;
	static Connection conn=null;
	public Connection getConnection() {
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		}catch (Exception e) {
				e.printStackTrace();
			}
			String url="jdbc:sqlserver://localhost:1433;databaseName=myDB_test";
			String user="user1";//�û���
			String password="123456";//����
		try {
			conn=(Connection)DriverManager.getConnection(url,user,password);
			if(conn!=null) {
				JOptionPane.showMessageDialog(null, "���ݿ����ӳɹ������ȷ���鿴��Ϣ");
			   }
		  }catch (Exception e) { 
		     e.printStackTrace();
		}
		return conn;//����Connection����
	}
	
public void searchEmp() {//Emp_IS empIs
	GetConn c=new GetConn();
	conn=c.getConnection();
	try { 
		
	    sql=conn.createStatement();
		res=sql.executeQuery("select * from Sale");
		while(res.next()) {
			String a1=res.getString(1);  
            String a2=res.getString(2);  
            String a3=res.getString(3);
            String a4=res.getString(4); 
            System.out.println(a1+"\t"+a2+"\t"+a3+"\t"+a4);
		}
		
	}catch(Exception e) {
		e.printStackTrace();
	}
}
	

	public static void main(String[] args) {
		GetConn gc=new GetConn();
		gc.searchEmp();
	}
  } 
}
