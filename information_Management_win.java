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
		setTitle("信息管理");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(400, 200, 600, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("请选择操作类型：");
		lblNewLabel.setBounds(81, 42, 104, 27);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("请选择操作对象：");
		lblNewLabel_1.setBounds(81, 166, 104, 27);
		contentPane.add(lblNewLabel_1);
		
		comboBox1 = new JComboBox();
		comboBox1.setModel(new DefaultComboBoxModel(new String[] {"插入数据", "修改数据", "删除数据"}));
		comboBox1.setBounds(309, 42, 208, 27);
		contentPane.add(comboBox1);
		
		comboBox2 = new JComboBox();
		comboBox2.setModel(new DefaultComboBoxModel(new String[] {"供应商", "物资"}));
		comboBox2.setBounds(309, 166, 208, 27);
		contentPane.add(comboBox2);
		
		JButton bcakButton = new JButton("<返回");
		bcakButton.addActionListener(new ActionListener() {//添加监听返回
			public void actionPerformed(ActionEvent e) {
					setVisible(false);	//关闭上一个窗体
					new Function_win1().setVisible(true);
				}
		});
		bcakButton.setBounds(111, 263, 93, 44);
		contentPane.add(bcakButton);
		
		JButton sureButton = new JButton("确定>");
		sureButton.addActionListener(new ActionListener() {//对确定按钮添加监听
			public void actionPerformed(ActionEvent e) {
				new getcombobox1();
				new getcombobox2();
				String type1="插入数据";
				String type2="修改数据";
				String type3="删除数据";
				String p="供应商";
				String m="物资";
				if(gcbox1.equals("")) {
					JOptionPane.showMessageDialog(null, "请选择操作类型！");
				}
				if(!(gcbox1.equals("")) && gcbox2.equals("")) {
					JOptionPane.showMessageDialog(null, "请选择操作对象！");
				}
				//空值检查
				//选择
				if(!(gcbox1.equals("")) && !(gcbox2.equals(""))) {
					if(gcbox1.equals(type1) && gcbox2.equals(p)) {//插入数据-->供应商
						setVisible(false);	//关闭上一个窗体
						new IM_Insert_Provider().setVisible(true);
					}
					else if(gcbox1.equals(type1) && gcbox2.equals(m)) {//插入数据-->物资
						setVisible(false);	//关闭上一个窗体
						new IM_Insert_Materals().setVisible(true);
					}
					else if(gcbox1.equals(type2) && gcbox2.equals(p)) {//修改数据-->供应商
						setVisible(false);	//关闭上一个窗体
						new IM_Alter_Provider().setVisible(true);
					}
					else if(gcbox1.equals(type2) && gcbox2.equals(m)) {//修改数据-->物资
						setVisible(false);	//关闭上一个窗体
						new IM_Alter_Materals().setVisible(true);
					}
					else if(gcbox1.equals(type3) && gcbox2.equals(p)) {//删除数据-->供应商 物资
						setVisible(false);	//关闭上一个窗体
						new IM_Delete_Provider().setVisible(true);
					}
					else if(gcbox1.equals(type3) && gcbox2.equals(m)) {//删除数据-->物资
						setVisible(false);	//关闭上一个窗体
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
			gcbox1=comboBox1.getSelectedItem().toString();//获取选中的下拉框值
		}
	}
	public class getcombobox2 {
		public getcombobox2() {
			gcbox2=comboBox2.getSelectedItem().toString();//获取选中的下拉框值
		}
	}
	
}
