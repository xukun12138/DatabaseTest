package BMMI_System;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.WindowConstants;
import javax.swing.border.EmptyBorder;

public class information_Management_win extends JFrame{
	private JPanel contentPane;
	String gcbox1=null;
	String gcbox2=null;
	private JComboBox comboBox1;
	private JComboBox comboBox2;
	/**
	 * Launch the application.
	 */
/*	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					information_Management_win frame = new information_Management_win();
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
	public information_Management_win() {
		setTitle("��Ϣ����");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(400, 200, 600, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("��ѡ��������ͣ�");
		lblNewLabel.setBounds(81, 42, 104, 27);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("��ѡ���������");
		lblNewLabel_1.setBounds(81, 166, 104, 27);
		contentPane.add(lblNewLabel_1);
		
		comboBox1 = new JComboBox();
		comboBox1.setModel(new DefaultComboBoxModel(new String[] {"��������", "�޸�����", "ɾ������"}));
		comboBox1.setBounds(309, 42, 208, 27);
		contentPane.add(comboBox1);
		
		comboBox2 = new JComboBox();
		comboBox2.setModel(new DefaultComboBoxModel(new String[] {"��Ӧ��", "����"}));
		comboBox2.setBounds(309, 166, 208, 27);
		contentPane.add(comboBox2);
		
		JButton bcakButton = new JButton("<����");
		bcakButton.addActionListener(new ActionListener() {//��Ӽ�������
			public void actionPerformed(ActionEvent e) {
					setVisible(false);	//�ر���һ������
					new Function_win1().setVisible(true);
				}
		});
		bcakButton.setBounds(111, 263, 93, 44);
		contentPane.add(bcakButton);
		
		JButton sureButton = new JButton("ȷ��>");
		sureButton.addActionListener(new ActionListener() {//��ȷ����ť��Ӽ���
			public void actionPerformed(ActionEvent e) {
				new getcombobox1();
				new getcombobox2();
				String type1="��������";
				String type2="�޸�����";
				String type3="ɾ������";
				String p="��Ӧ��";
				String m="����";
				if(gcbox1.equals("")) {
					JOptionPane.showMessageDialog(null, "��ѡ��������ͣ�");
				}
				if(!(gcbox1.equals("")) && gcbox2.equals("")) {
					JOptionPane.showMessageDialog(null, "��ѡ���������");
				}
				//��ֵ���
				//ѡ��
				if(!(gcbox1.equals("")) && !(gcbox2.equals(""))) {
					if(gcbox1.equals(type1) && gcbox2.equals(p)) {//��������-->��Ӧ��
						setVisible(false);	//�ر���һ������
						new IM_Insert_Provider().setVisible(true);
					}
					else if(gcbox1.equals(type1) && gcbox2.equals(m)) {//��������-->����
						setVisible(false);	//�ر���һ������
						new IM_Insert_Materals().setVisible(true);
					}
					else if(gcbox1.equals(type2) && gcbox2.equals(p)) {//�޸�����-->��Ӧ��
						setVisible(false);	//�ر���һ������
						new IM_Alter_Provider().setVisible(true);
					}
					else if(gcbox1.equals(type2) && gcbox2.equals(m)) {//�޸�����-->����
						setVisible(false);	//�ر���һ������
						new IM_Alter_Materals().setVisible(true);
					}
					else if(gcbox1.equals(type3) && gcbox2.equals(p)) {//ɾ������-->��Ӧ�� ����
						setVisible(false);	//�ر���һ������
						new IM_Delete_Provider().setVisible(true);
					}
					else if(gcbox1.equals(type3) && gcbox2.equals(m)) {//ɾ������-->����
						setVisible(false);	//�ر���һ������
						new IM_Delete_Materals().setVisible(true);
					}
				
			  }
			}
		});
		sureButton.setBounds(391, 263, 93, 44);
		contentPane.add(sureButton);
	}
	public class getcombobox1 {
		public getcombobox1() {
			gcbox1=comboBox1.getSelectedItem().toString();//��ȡѡ�е�������ֵ
		}
	}
	public class getcombobox2 {
		public getcombobox2() {
			gcbox2=comboBox2.getSelectedItem().toString();//��ȡѡ�е�������ֵ
		}
	}
	
}
