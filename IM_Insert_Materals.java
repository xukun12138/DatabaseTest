package BMMI_System;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import BMMI_System.jdbcUtil.GetConn;

public class IM_Insert_Materals extends JFrame{
	private JPanel contentPane;
	private JTextField textField1;
	private JTextField textField2;
	private JTextField textField3;
	String text1=null;
	String text2=null;
	String text3=null;
	/**
	 * Launch the application.
	 */
/*	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					IM_Insert_Materals frame = new IM_Insert_Materals();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/

	/**
	 * Create the frame.
	 */
	public IM_Insert_Materals() {
		setTitle("信息管理->插入数据->物资");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(400, 200, 600, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("请输入物资号：");
		lblNewLabel.setBounds(106, 61, 130, 30);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("请输入物资名称：");
		lblNewLabel_1.setBounds(106, 134, 130, 30);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("请输入物资类别：");
		lblNewLabel_2.setBounds(106, 201, 130, 30);
		contentPane.add(lblNewLabel_2);
		
		textField1 = new JTextField();
		textField1.setBounds(308, 66, 136, 25);
		contentPane.add(textField1);
		textField1.setColumns(10);
		
		textField2 = new JTextField();
		textField2.setBounds(308, 139, 136, 25);
		contentPane.add(textField2);
		textField2.setColumns(10);
		
		textField3 = new JTextField();
		textField3.setBounds(308, 206, 136, 25);
		contentPane.add(textField3);
		textField3.setColumns(10);
		
		JButton sureButton = new JButton("确定>");
		sureButton.setBounds(420, 270, 85, 50);
		contentPane.add(sureButton);
		sureButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);	//关闭上一个窗体
				//执行操作
				new gettext_im1();
				new gettext_im2();
				new gettext_im3();
				
				if(text1.equals("")) {
					JOptionPane.showMessageDialog(null, "请输入物资号！");
				}
				else if(!(text1.equals("")) && text2.equals("")) {
					JOptionPane.showMessageDialog(null, "请输入物资名称！");
				}
				else if(!(text1.equals("")) && !(text2.equals("")) && text3.equals("")) {
					JOptionPane.showMessageDialog(null, "请输入物资类别！");
				}
				else if(!(text1.equals("")) && !(text2.equals("")) && !(text3.equals(""))) {
					try {
						new do_im_im(text1,text2,text3);
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}//传参数
				}
			}
		});
		
		
		JButton backButton = new JButton("<返回");
		backButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);	//关闭上一个窗体
				new information_Management_win().setVisible(true);
			}
		});
		backButton.setBounds(73, 270, 85, 50);
		contentPane.add(backButton);
		
		JButton cancelButton = new JButton("取消");
		cancelButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);	//关闭上一个窗体
				new Function_win1().setVisible(true);
			}
		});
		cancelButton.setBounds(250, 270, 85, 50);
		contentPane.add(cancelButton);
		
		JLabel lblNewLabel_3 = new JLabel("添加新的物资信息");
		lblNewLabel_3.setBounds(235, 10, 130, 24);
		contentPane.add(lblNewLabel_3);
	}
	
	public class gettext_im1 {
		public gettext_im1() {
		   text1=textField1.getText().toString();//获取文本框的值
		} 
	   }
	public class gettext_im2 {
		public gettext_im2() {
		   text2=textField2.getText().toString();//获取文本框的值
		} 
	   }
	public class gettext_im3 {
		public gettext_im3() {
		   text3=textField3.getText().toString();//获取文本框的值
		} 
	   }
	
	public class do_im_im{//对应的执行操作
		public do_im_im(String tx1,String tx2,String tx3) throws SQLException {
			Connection conn=null;
			GetConn c=new GetConn();
			conn=c.getConnection();		
			try {
				PreparedStatement ps=conn.prepareStatement("INSERT INTO Goods VALUES(?,?,?)");//预编译
				ps.setString(1,text1);
				ps.setString(2,text2);
				ps.setString(3,text3);
				int i=ps.executeUpdate();//测试  
		          if(i==1){  
		        	  JOptionPane.showMessageDialog(null, "物资添加成功！"); 
		          }
		          else{  
		        	  JOptionPane.showMessageDialog(null, "物资添加失败！");
		       }
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			conn.close();
		}
	}
}
