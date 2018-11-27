package BMMI_System;

import javax.swing.AbstractListModel;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import java.awt.Container;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.Vector;

import javax.swing.WindowConstants;
import javax.swing.border.EmptyBorder;

public class Information_Search_win extends JFrame{// ��Ϣ��ѯ���ܴ���
	private JPanel contentPane;
	public String arr1=null;
	public String arr2=null;
	public String t_IS1=null;
	public String t_IS2=null;
	private JTextField jt1=new JTextField();//�ı���
	private JTextField jt2=new JTextField();//�ı���
	private JComboBox jcb1=null;//������
	private JComboBox jcb2=null;//������
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Information_Search_win frame = new Information_Search_win();
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
	public Information_Search_win() {
		setTitle("��Ϣ��ѯ");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(400, 200, 600, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("��ѡ����Ҫ��ѯ����Ϣ��");
		lblNewLabel.setBounds(69, 38, 174, 26);
		contentPane.add(lblNewLabel);
		
		String s_IS[]={"��������ѯ","�������ѯ","����ѯ"};
		jcb1 = new JComboBox(s_IS);
		jcb1.setModel(new DefaultComboBoxModel(new String[] {"��������ѯ", "�������ѯ", "����ѯ"}));
		jcb1.setBounds(277, 40, 197, 23);
		contentPane.add(jcb1);
		
		JLabel lblNewLabel_1 = new JLabel("��ѡ����Ҫ��ѯ�����ʣ�");
		lblNewLabel_1.setBounds(69, 113, 174, 26);
		contentPane.add(lblNewLabel_1);
		
		jcb2 = new JComboBox();
		jcb2.setModel(new DefaultComboBoxModel(new String[] {"�ֽ�", "ˮ��", "����ש", "�ֻ�����", "ˮ��", "ľ��"}));
		jcb2.setBounds(277, 116, 197, 23);
		contentPane.add(jcb2);

		jt1.setBounds(191, 216, 132, 21);
		contentPane.add(jt1);
		jt1.setColumns(10);
		
		jt2.setBounds(352, 216, 132, 21);
		contentPane.add(jt2);
		jt2.setColumns(10);
		
		JLabel label = new JLabel("--");
		label.setBounds(333, 219, 12, 15);
		contentPane.add(label);
		
		JLabel lblNewLabel_2 = new JLabel("��ѡ��ʱ��Σ�");
		lblNewLabel_2.setBounds(69, 219, 180, 18);
		contentPane.add(lblNewLabel_2);
		
		JButton backButton = new JButton("<����");
		backButton.setBounds(70, 301, 93, 45);
		contentPane.add(backButton);
		backButton.addActionListener(new ActionListener(){//��Ӽ���
			public void actionPerformed(ActionEvent e) {
				setVisible(false);	//�ر���һ������
				new Function_win1().setVisible(true);
			}
		});
		
		JButton sureButton = new JButton("ȷ��>");
		sureButton.setBounds(419, 301, 93, 45);
		contentPane.add(sureButton);
    	sureButton.addActionListener(new ActionListener(){//��Ӽ���
			public void actionPerformed(ActionEvent e) {
				new comboboxRead1();
				new comboboxRead2();
				new textRead1();
				new textRead2();
				new IS_Back_win(arr1,arr2,t_IS1,t_IS2);
			}
    	  });
	}
	
public class comboboxRead1{
	public comboboxRead1() {
		arr1=jcb1.getSelectedItem().toString();//��ȡѡ�е�������1ֵ
	}
}
public class comboboxRead2{
	public comboboxRead2() {
		arr2=jcb2.getSelectedItem().toString();//��ȡѡ�е�������2ֵ
	}
}
public class textRead1 {
	public textRead1() {
	   t_IS1=jt1.getText().toString();//��ȡ�ı����ֵ
	} 
   }
public class textRead2 {
	public textRead2() {
	   t_IS2=jt2.getText().toString();//��ȡ�ı����ֵ
	} 
   }

}
