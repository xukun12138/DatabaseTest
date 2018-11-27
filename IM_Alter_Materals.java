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

import BMMI_System.IM_Alter_Provider.do_im_ap;
import BMMI_System.IM_Alter_Provider.getcombobox;
import BMMI_System.IM_Alter_Provider.gettext_AP1;
import BMMI_System.IM_Alter_Provider.gettext_AP2;
import BMMI_System.jdbcUtil.GetConn;

public class IM_Alter_Materals extends JFrame{
	private JPanel contentPane;
	private JTextField textField1;
	private JTextField textField2;
	private JComboBox comboBox;
	String gcbox;
	String text1;
	String text2;

	/**
	 * Launch the application.
	 */
/*	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					IM_Alter_Materals frame = new IM_Alter_Materals();
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
	public IM_Alter_Materals() {
		setTitle("��Ϣ����->�޸���Ϣ->����");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(400, 200, 600, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("�޸�������Ϣ");
		lblNewLabel.setBounds(228, 21, 117, 25);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("��ѡ����Ҫ�޸ĵ���Ŀ��");
		lblNewLabel_1.setBounds(93, 74, 150, 25);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("��������Ҫ�޸ĵ�ֵ��");
		lblNewLabel_2.setBounds(93, 141, 140, 25);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("�������޸ĺ��ֵ��");
		lblNewLabel_3.setBounds(93, 210, 140, 25);
		contentPane.add(lblNewLabel_3);
		
		comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"���ʺ�", "��������", "�������"}));
		comboBox.setBounds(313, 71, 185, 25);
		contentPane.add(comboBox);
		
		textField1 = new JTextField();
		textField1.setBounds(313, 143, 185, 25);
		contentPane.add(textField1);
		textField1.setColumns(10);
		
		textField2 = new JTextField();
		textField2.setBounds(313, 207, 185, 25);
		contentPane.add(textField2);
		textField2.setColumns(10);
		
		JButton backButton = new JButton("<����");
		backButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);	//�ر���һ������
				new information_Management_win().setVisible(true);
			}
		});
		backButton.setBounds(99, 277, 93, 50);
		contentPane.add(backButton);
		
		JButton sureButton = new JButton("ȷ��>");
		sureButton.setBounds(397, 277, 93, 50);
		contentPane.add(sureButton);
		sureButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//setVisible(false);	//�ر���һ������
				//new information_Management_win().setVisible(true);
				new getcombobox_AM();
				new gettext_AM1();
				new gettext_AM2();
				//ִ��
				if(gcbox.equals("")) {
					JOptionPane.showMessageDialog(null, "��ѡ����Ҫ�޸ĵ���Ŀ��");
				}
				else if(!(gcbox.equals("")) && text1.equals("")) {
					JOptionPane.showMessageDialog(null, "��������Ҫ�޸ĵ�ֵ��");
				}
				else if(!(gcbox.equals("")) && !(text1.equals("")) && text2.equals("")) {
					JOptionPane.showMessageDialog(null, "�������޸ĺ��ֵ��");
				}
				else if(!(gcbox.equals("")) && !(text1.equals("")) && !(text2.equals(""))) {
					try {
						new do_im_am(gcbox,text1,text2);
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				
				
			}
		});
	}
	public class getcombobox_AM{
		public getcombobox_AM() {
			gcbox=comboBox.getSelectedItem().toString();//��ȡѡ�е�������ֵ
		}
	}
	
	public class gettext_AM1 {
		public gettext_AM1() {
		   text1=textField1.getText().toString();//��ȡ�ı����ֵ
		} 
	   }
	public class gettext_AM2 {
		public gettext_AM2() {
		   text2=textField2.getText().toString();//��ȡ�ı����ֵ
		} 
	   }
	public class do_im_am{
		public do_im_am(String gcb,String tx1,String tx2) throws SQLException{//��Ӧ��ִ�в���
			String gc1="���ʺ�";
			String gc2="��������";
			String gc3="�������";
			Connection conn=null;
			Statement sm=null;
			GetConn c=new GetConn();
			conn=c.getConnection();	
			try {
				int i = 0;
				sm=conn.createStatement();
				if(gcb.equals(gc1)) {
					i=sm.executeUpdate("UPDATE Goods SET GId="+"'"+tx2+"' WHERE GId="+"'"+tx1+"'");//���ʺ�  
					if(i==1){  
						JOptionPane.showMessageDialog(null, "���ʺ��޸ĳɹ���");
						setVisible(false);
						//new IM_Delete_Materals().setVisible(true);
						new information_Management_win().setVisible(true);
					}
					else{  
						JOptionPane.showMessageDialog(null, "���ʺ��޸�ʧ�ܣ�");
					}
				}
				else if(gcb.equals(gc2)) {
					i=sm.executeUpdate("UPDATE Goods SET GName="+"'"+tx2+"' WHERE GName="+"'"+tx1+"'");//��������  
					if(i==1){  
						JOptionPane.showMessageDialog(null, "���������޸ĳɹ���");
						setVisible(false);
						//new IM_Delete_Materals().setVisible(true);
						new information_Management_win().setVisible(true);
					}
					else{  
						JOptionPane.showMessageDialog(null, "���������޸�ʧ�ܣ�");
					}
				}
				else if(gcb.equals(gc3)) {
					i=sm.executeUpdate("UPDATE Goods SET GKind="+"'"+tx2+"' WHERE GKind="+"'"+tx1+"'");//�������  
					if(i==1){  
						JOptionPane.showMessageDialog(null, "��������޸ĳɹ���");
						setVisible(false);
						//new IM_Delete_Materals().setVisible(true);
						new information_Management_win().setVisible(true);
					}
					else{  
						JOptionPane.showMessageDialog(null, "��������޸�ʧ�ܣ�");
					}
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
