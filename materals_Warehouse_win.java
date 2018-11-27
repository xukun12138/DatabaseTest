package BMMI_System;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.AbstractListModel;
import javax.swing.ButtonGroup;
import javax.swing.ComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.regex.Pattern;

import javax.swing.WindowConstants;

import BMMI_System.jdbcUtil.GetConn;

public class materals_Warehouse_win extends JFrame{
	  public String t_mw=null;
	  public String arr_mw=null;
	  public String radio=null;
	  int num;
	  ButtonGroup group=new ButtonGroup();
	  JTextField jt2=new JTextField();//文本框
	  JComboBox jcb2=null;//下拉框
	  JRadioButton outRadioButton;
	  JRadioButton entRadioButton;
	public materals_Warehouse_win() {
		super.setTitle("物资出入库");
  		super.setBounds(400,200,600,400);
  		setLayout(null);
  		super.setVisible(true);
  		super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  		
  		Container ct2=getContentPane();//容器
  		
  		outRadioButton=new JRadioButton("出库");//单选按钮
  		entRadioButton=new JRadioButton("入库");
  		ct2.add(outRadioButton);
  		outRadioButton.setBounds(340, 110, 60, 20);  		
  		ct2.add(entRadioButton);
  		entRadioButton.setBounds(420, 110, 60, 20);
  		group=new ButtonGroup();
  		group.add(outRadioButton);
  		group.add(entRadioButton);
  		
  		
  		String s_IS[]={"钢筋","水泥","空心砖","钢化玻璃","水管","木材"};//下拉框
  	    jcb2=new JComboBox(s_IS);
  		jcb2.setBounds(300, 20, 200, 30);
  	    ct2.add(jcb2);
  		
  		JLabel j1=new JLabel("请选择需要的物资：");//标签
  	    j1.setBounds(80, 20, 200, 20);
  	    ct2.add(j1);
  	    
  	    JLabel j2=new JLabel("请选择操作类型：");//标签
	    j2.setBounds(80, 110, 200, 20);
	    ct2.add(j2);
	    
	    JLabel j3=new JLabel("请输入数量：");//标签
	    j3.setBounds(80, 200, 200, 20);
	    ct2.add(j3);
	    
  	    jt2.setBounds(300, 200, 200, 30);//设置文本框位置
        ct2.add(jt2);
  	    
  		
  		JButton sureButton=new JButton("确定>");//确定按钮
  	    sureButton.setBounds(450, 300, 80, 40);
  	    ct2.add(sureButton);
  	    sureButton.addActionListener(new ActionListener(){//添加监听
			public void actionPerformed(ActionEvent e) {
			//	setVisible(false);	//关闭上一个窗体
				new comboboxRead2();
				new textRead2();
				new radioRead();
				if(arr_mw.equals("")) {
					JOptionPane.showMessageDialog(null, "请选择物资类型！");
				}
				else if(radio.equals("")) {
					JOptionPane.showMessageDialog(null, "请选择出库还是入库！");
				}
				if(!(radio.equals("")) && t_mw.equals("")) {
					JOptionPane.showMessageDialog(null, "请输入出库或入库的数量！");
				}
				if(!(isNumeric(t_mw))) {
					JOptionPane.showMessageDialog(null, "出入库的数量必须为数字，请输入数字！");
				}
				if(!(t_mw.equals("")) && isNumeric(t_mw)) {
					num=Integer.parseInt(t_mw);
					try {
						new mat_ware(arr_mw, radio, num);
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}
		});
  		
  	    JButton backButton=new JButton("<返回");//返回按钮
  		backButton.setBounds(new Rectangle(50, 300, 80, 40));
  		ct2.add(backButton);
  		backButton.addActionListener(new ActionListener(){//添加监听
			public void actionPerformed(ActionEvent e) {
				setVisible(false);	//关闭上一个窗体
				new Function_win1().setVisible(true);
			}
		});
	}
	
	
	public class textRead2 {
		public textRead2() {
		   t_mw=jt2.getText().toString();//获取文本框的值
		 } 
	   }
	public boolean isNumeric(String str) {//判断文本框获取的值是否为数字
		Pattern pat=Pattern.compile("[0-9]*");
		return pat.matcher(str).matches();
	  }
	
	public class comboboxRead2 {
		public comboboxRead2() {
			arr_mw=jcb2.getSelectedItem().toString();//获取选中的下拉框值
		}
	}
	public class radioRead {
		public radioRead() {
			if(outRadioButton.isSelected()) {
				radio=outRadioButton.getText();//获取单选框的值
			}
			else if(entRadioButton.isSelected()) {
				radio=entRadioButton.getText();
			}
			else {
				radio="";
			}
		}
	}

	public class mat_ware{//执行操作
		public mat_ware(String box,String rad,int text) throws SQLException {
			Connection conn=null;
			GetConn c=new GetConn();
			conn=c.getConnection();
			Statement st=conn.createStatement();
			if(rad=="出库" && text>0) {//执行出库操作
				int i=st.executeUpdate("UPDATE Warehouse SET GNum=GNum-"+"'"+text+"'"+" WHERE GId=(SELECT GId FROM Goods WHERE GName="+"'"+box+"')");
				if(i==1) {
					JOptionPane.showMessageDialog(null, "出库成功！");
				}
				else {
					JOptionPane.showMessageDialog(null, "出库失败！");
				}
			}
			else if(rad=="入库" && text>0) {//执行入库操作
				int i=st.executeUpdate("UPDATE Warehouse SET GNum=GNum+"+"'"+text+"'"+" WHERE GId=(SELECT GId FROM Goods WHERE GName="+"'"+box+"')");
				if(i==1) {
					JOptionPane.showMessageDialog(null, "入库成功！");
				}
				else {
					JOptionPane.showMessageDialog(null, "入库失败！");
				}
			}
			else {
				JOptionPane.showMessageDialog(null, "错误操作，请重试！");
			}
			st.close();
			conn.close();
		}
	}
	
/*	public static void main(String[] args) {
		new materals_Warehouse_win();  
	}*/

}
