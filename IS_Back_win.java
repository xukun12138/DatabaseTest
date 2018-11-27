package BMMI_System;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.ListSelectionModel;
import javax.swing.WindowConstants;
import javax.swing.table.DefaultTableModel;

import BMMI_System.jdbcUtil.GetConn;

public class IS_Back_win{
	private JFrame frame;
	public Statement stat=null;
	public ResultSet res=null;
	public Connection conn=null;
	private String s1="出库量查询";
	private String s2="入库量查询";
	private String s3="库存查询";
	String b1;
	String b2;
	String t1;
	String t2;
public IS_Back_win(String box1,String box2,String time1,String time2) {
		   b1=box1;
		   b2=box2;
		   t1=time1;
		   t2=time2;
		   String regex="((\\d{2}(([02468][048])|([13579][26]))[\\-]((((0?[13578])|(1[02]))"
		   		+ "[\\-]((0?[1-9])|([1-2][0-9])|(3[01])))|(((0?[469])|(11))[\\-]((0?[1-9])|"
		   		+ "([1-2][0-9])|(30)))|(0?2[\\-]((0?[1-9])|([1-2][0-9])))))|(\\d{2}(([02468]"
		   		+ "[1235679])|([13579][01345789]))[\\-]((((0?[13578])|(1[02]))[\\-]((0?[1-9])"
		   		+ "|([1-2][0-9])|(3[01])))|(((0?[469])|(11))[\\-]((0?[1-9])|([1-2][0-9])|(30)))"
		   		+ "|(0?2[\\-]((0?[1-9])|(1[0-9])|(2[0-8]))))))";//定义时间正则表达式
		   
	if(box1.equals(s1) || box1.equals(s2)) {
  	    if(box1.equals("") || box2.equals("")) {
    		JOptionPane.showMessageDialog(null, "请正确选择和输入所需查询的信息！");
    	  }
  	    else if(time1.equals("") && !(time2.equals("")) || !(time1.equals("")) && time2.equals("")){
  	    	JOptionPane.showMessageDialog(null, "请输入完整的时间段！");
  	    }
 	    else if(time1.equals("") || time2.equals("")) {
  	    	JOptionPane.showMessageDialog(null, "请输入时间段！");
  	    }
  	    else if(!(time1.matches(regex)) || !(time2.matches(regex))) {
  	    	JOptionPane.showMessageDialog(null, "时间段不符合规范！请重新输入");
  	    }
  	    
  	    else if(box1.equals(s1)) {//出库查询
		try {
            new information1();
		}catch(Exception e) {
			e.printStackTrace();
		}
	  }
  	    
  	  else if(box1.equals(s2)) {//入库量
  		try {
            new information2();
		}catch(Exception e) {
			e.printStackTrace();
		}
  	  }
  	    
  	    
	}
	
  	  else if(box1.equals(s3)) {
  		  if(!(time1.equals("")) || !(time2.equals(""))) {
  			JOptionPane.showMessageDialog(null, "在选择库存查询时不需要输入时间段！");
  			
  		  }
  		  else if(time1.equals("") || time2.equals("")) {//
  			  try {
  				  new information3();
  			  }catch(Exception e) {
  				  e.printStackTrace();
  			  }
  		  }
  	  }
  		
	}

public class information1{
	    public information1() { 
			initialize1();
		}
		private void initialize1() {//出库量查询的返回方法
			frame = new JFrame("出库量查询结果");
			frame.setLayout(null);
			JLabel a=new JLabel("数量：");
			a.setBounds(250, 10, 50, 20);
			frame.getContentPane().add(a);
			Vector<String> v_test1 = new Vector<String>();
			
			try {
				GetConn c=new GetConn();
				conn=c.getConnection();
				Statement st=conn.createStatement();
				ResultSet res=st.executeQuery("SELECT [OutNumber] FROM Sale,Goods WHERE Goods.GId=Sale.GId AND OutDate>"+"'"+t1+"'"+" AND OutDate<"+"'"+t2+"'"+" AND GName="+"'"+b2+"'");
				while(res.next()) {
					v_test1.addElement(res.getString("OutNumber"));
					v_test1.add("\n");
				}
				st.close();
				res.close();
				conn.close();
				
			   }catch(Exception e) {
				e.printStackTrace();
			 }

			JList<Object> list_test1=new JList<Object>(v_test1);
			list_test1.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
			list_test1.setBounds(250, 50, 200, 250);
			frame.getContentPane().add(list_test1);   
			frame.setBounds(400, 200, 600, 400);
			frame.setVisible(true);
		}
}

public class information2 extends JFrame{
    public information2() { 
			initialize2();
		}
    private void initialize2() {//入库量查询返回方法
		frame = new JFrame("入库量查询结果");
		frame.setLayout(null);
		JLabel a=new JLabel("数量：");
		a.setBounds(250, 10, 50, 20);
		frame.getContentPane().add(a);
		Vector<String> v_test2 = new Vector<String>();
		try {
			GetConn c=new GetConn();
			conn=c.getConnection();
			Statement st=conn.createStatement();
			ResultSet res=st.executeQuery("SELECT InNumber FROM [In],Goods WHERE Goods.GId=[In].GId AND InDate>"+"'"+t1+"'"+" AND InDate<"+"'"+t2+"'"+" AND GName="+"'"+b2+"'");
			while(res.next()) {
				v_test2.addElement(res.getString("InNumber"));
				v_test2.add("\n");
			}
			st.close();
			res.close();
			conn.close();
			
		   }catch(Exception e) {
			e.printStackTrace();
		 }

		JList<Object> list_test2=new JList<Object>(v_test2);
		list_test2.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		list_test2.setBounds(250, 50, 200, 250);
		frame.getContentPane().add(list_test2);   
		frame.setBounds(400, 200, 600, 400);
		frame.setVisible(true);
		
    }
}

public class information3 extends JFrame{
	   public information3() { 
				initialize3();
			}
	    private void initialize3() {//库存查询返回方法
	    	frame = new JFrame("库存查询结果");
			frame.setLayout(null);
			JLabel a=new JLabel("数量：");
			a.setBounds(250, 10, 50, 20);
			frame.getContentPane().add(a);
			Vector<String> v_test3 = new Vector<String>();
			try {
				GetConn c=new GetConn();
				conn=c.getConnection();
				Statement st=conn.createStatement();
				ResultSet res=st.executeQuery("SELECT GNum FROM Warehouse,Goods WHERE Goods.GId=Warehouse.GId AND GName="+"'"+b2+"'");
				while(res.next()) {
					v_test3.addElement(res.getString("GNum"));
					v_test3.add("\n");
				}
				st.close();
				res.close();
				conn.close();
				
			   }catch(Exception e) {
				e.printStackTrace();
			 }

			JList<Object> list_test3=new JList<Object>(v_test3);
			list_test3.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
			list_test3.setBounds(250, 50, 200, 250);
			frame.getContentPane().add(list_test3);   
			frame.setBounds(400, 200, 600, 400);
			frame.setVisible(true);
	    }
   }

}
