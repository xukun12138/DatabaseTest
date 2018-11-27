package BMMI_System;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import BMMI_System.jdbcUtil.GetConn;

public class IM_Insert_Provider extends JFrame{
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
					IM_Insert_Provider frame = new IM_Insert_Provider();
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
	public IM_Insert_Provider() {
		setTitle("��Ϣ����->��������->��Ӧ��");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(400, 200, 600, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("�����빩Ӧ�̺ţ�");
		lblNewLabel.setBounds(106, 61, 130, 30);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("�����빩Ӧ�����ƣ�");
		lblNewLabel_1.setBounds(106, 134, 130, 30);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("�����빩Ӧ�̸����ˣ�");
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
		
		JButton sureButton = new JButton("ȷ��>");
		sureButton.setBounds(420, 270, 85, 50);
		contentPane.add(sureButton);
		sureButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//setVisible(false);	//�ر���һ������
				//new information_Management_win().setVisible(true);
				//ִ�в���
				new gettext1();
				new gettext2();
				new gettext3();
				
				if(text1.equals("")) {
					JOptionPane.showMessageDialog(null, "�����빩Ӧ�̺ţ�");
				}
				else if(!(text1.equals("")) && text2.equals("")) {
					JOptionPane.showMessageDialog(null, "�����빩Ӧ�����ƣ�");
				}
				else if(!(text1.equals("")) && !(text2.equals("")) && text3.equals("")) {
					JOptionPane.showMessageDialog(null, "�����빩Ӧ�̸����ˣ�");
				}
				else if(!(text1.equals("")) && !(text2.equals("")) && !(text3.equals(""))) {
					try {
						new do_im_ip(text1,text2,text3);
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}//������
				}
			}
		});
		
		
		JButton backButton = new JButton("<����");
		backButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);	//�ر���һ������
				new information_Management_win().setVisible(true);
			}
		});
		backButton.setBounds(73, 270, 85, 50);
		contentPane.add(backButton);
		
		JButton cancelButton = new JButton("ȡ��");
		cancelButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);	//�ر���һ������
				new Function_win1().setVisible(true);
			}
		});
		cancelButton.setBounds(250, 270, 85, 50);
		contentPane.add(cancelButton);
		
		JLabel lblNewLabel_3 = new JLabel("����µĹ�Ӧ����Ϣ");
		lblNewLabel_3.setBounds(235, 10, 130, 24);
		contentPane.add(lblNewLabel_3);
	}
	
	public class gettext1 {
		public gettext1() {
		   text1=textField1.getText().toString();//��ȡ�ı����ֵ
		} 
	   }
	public class gettext2 {
		public gettext2() {
		   text2=textField2.getText().toString();//��ȡ�ı����ֵ
		} 
	   }
	public class gettext3 {
		public gettext3() {
		   text3=textField3.getText().toString();//��ȡ�ı����ֵ
		} 
	   }
	
	public class do_im_ip{//��Ӧ��ִ�в���
		public do_im_ip(String tx1,String tx2,String tx3) throws SQLException {
			Connection conn=null;
			GetConn c=new GetConn();
			conn=c.getConnection();		
			try {
				PreparedStatement ps=conn.prepareStatement("INSERT INTO Provider VALUES(?,?,?)");//Ԥ����
				ps.setString(1,text1);
				ps.setString(2,text2);
				ps.setString(3,text3);
				int i=ps.executeUpdate();//����  
		          if(i==1){  
		        	  JOptionPane.showMessageDialog(null, "��Ӧ����ӳɹ���"); 
		          }
		          else{  
		        	  JOptionPane.showMessageDialog(null, "��Ӧ�����ʧ�ܣ�");
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
