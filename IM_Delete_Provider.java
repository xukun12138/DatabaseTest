package BMMI_System;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import BMMI_System.IM_Insert_Provider.do_im_ip;
import BMMI_System.jdbcUtil.GetConn;

public class IM_Delete_Provider extends JFrame{
	private JPanel contentPane;
	private JTextField textField;
	String text=null;

	/**
	 * Launch the application.
	 */
/*	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					IM_Delete_Provider frame = new IM_Delete_Provider();
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
	public IM_Delete_Provider() {
		setTitle("信息管理->删除信息->供应商");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(400, 200, 600, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("请输入需要删除的内容：");
		lblNewLabel_2.setBounds(87, 110, 150, 30);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("删除供应商的信息");
		lblNewLabel_3.setBounds(230, 20, 150, 24);
		contentPane.add(lblNewLabel_3);
		
		textField = new JTextField();
		textField.setBounds(322, 110, 160, 25);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton backButton = new JButton("<返回");
		backButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);	//关闭上一个窗体
				new information_Management_win().setVisible(true);
			}
		});
		backButton.setBounds(74, 264, 93, 50);
		contentPane.add(backButton);
		
	/*	JButton cancelButton = new JButton("取消");
		cancelButton.setBounds(257, 264, 93, 50);
		contentPane.add(cancelButton);
		cancelButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);	//关闭上一个窗体
				new Function_win1().setVisible(true);
			}
		});*/
		
		JButton sureButton = new JButton("确定>");
		sureButton.setBounds(423, 264, 93, 50);
		contentPane.add(sureButton);
		sureButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//setVisible(false);
				//执行操作
				new gettext_DP();
				if(text.equals("")) {
					JOptionPane.showMessageDialog(null, "请输入需要删除的内容！");
				}
				else {
					try {
						new do_im_dp(text);
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}//传参数 执行
				}
			}
		});
	}
	
	public class gettext_DP {
		public gettext_DP() {
		   text=textField.getText().toString();//获取文本框的值
		} 
	   }
	public class do_im_dp{
		public do_im_dp(String str) throws SQLException {//对应的执行操作
			Connection conn=null;
			Statement sm=null;
			GetConn c=new GetConn();
			conn=c.getConnection();	
			try {
				int i = 0;
				sm=conn.createStatement();
				i=sm.executeUpdate("DELETE FROM Provider WHERE PName="+"'"+str+"'");//测试  
		          if(i==1){  
		        	  JOptionPane.showMessageDialog(null, "供应商删除成功！");
		        	  setVisible(false);
		        	  //new IM_Delete_Materals().setVisible(true);
		        	  new information_Management_win().setVisible(true);
		          }
		          else{  
		        	  JOptionPane.showMessageDialog(null, "供应商删除失败！");
		       }
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			sm.close();
			conn.close();
			
		}
	}
}
