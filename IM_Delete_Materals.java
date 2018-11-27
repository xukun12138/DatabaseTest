package BMMI_System;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import BMMI_System.IM_Delete_Provider.do_im_dp;
import BMMI_System.IM_Delete_Provider.gettext_DP;
import BMMI_System.jdbcUtil.GetConn;

public class IM_Delete_Materals extends JFrame{
	private JPanel contentPane;
	private JTextField textField;
	String text=null;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					IM_Delete_Materals frame = new IM_Delete_Materals();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public IM_Delete_Materals() {
		setTitle("��Ϣ����->ɾ����Ϣ->����");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(400, 200, 600, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("��������Ҫɾ�������ݣ�");
		lblNewLabel_2.setBounds(87, 110, 150, 30);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("ɾ�����ʵ���Ϣ");
		lblNewLabel_3.setBounds(230, 20, 150, 24);
		contentPane.add(lblNewLabel_3);
		
		textField = new JTextField();
		textField.setBounds(322, 110, 160, 25);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton backButton = new JButton("<����");
		backButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);	//�ر���һ������
				new information_Management_win().setVisible(true);
			}
		});
		backButton.setBounds(74, 264, 93, 50);
		contentPane.add(backButton);
		
		JButton sureButton = new JButton("ȷ��>");
		sureButton.setBounds(423, 264, 93, 50);
		contentPane.add(sureButton);
		sureButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//setVisible(false);
				//ִ�в���
				new gettext_DM();
				if(text.equals("")) {
					JOptionPane.showMessageDialog(null, "��������Ҫɾ�������ݣ�");
				}
				else {
					try {
						new do_im_dm(text);
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}//������ ִ��
				}
			}
		});
	}
	
	public class gettext_DM {
		public gettext_DM() {
		   text=textField.getText().toString();//��ȡ�ı����ֵ
		} 
	   }
	public class do_im_dm{
		public do_im_dm(String str) throws SQLException {//��Ӧ��ִ�в���
			Connection conn=null;
			Statement sm=null;
			GetConn c=new GetConn();
			conn=c.getConnection();	
			try {
				int i = 0;
				sm=conn.createStatement();
				i=sm.executeUpdate("DELETE FROM Goods WHERE GName="+"'"+str+"'");//����  
		          if(i==1){  
		        	  JOptionPane.showMessageDialog(null, "����ɾ���ɹ���");
		        	  setVisible(false);
		        	  //new IM_Delete_Materals().setVisible(true);
		        	  new information_Management_win().setVisible(true);
		        	  
		          }
		          else{  
		        	  JOptionPane.showMessageDialog(null, "����ɾ��ʧ�ܣ�");
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
