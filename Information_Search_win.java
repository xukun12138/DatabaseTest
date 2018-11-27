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

public class Information_Search_win extends JFrame{// 信息查询功能窗体
	private JPanel contentPane;
	public String arr1=null;
	public String arr2=null;
	public String t_IS1=null;
	public String t_IS2=null;
	private JTextField jt1=new JTextField();//文本框
	private JTextField jt2=new JTextField();//文本框
	private JComboBox jcb1=null;//下拉框
	private JComboBox jcb2=null;//下拉框
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
		setTitle("信息查询");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(400, 200, 600, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("请选择需要查询的信息：");
		lblNewLabel.setBounds(69, 38, 174, 26);
		contentPane.add(lblNewLabel);
		
		String s_IS[]={"出库量查询","入库量查询","库存查询"};
		jcb1 = new JComboBox(s_IS);
		jcb1.setModel(new DefaultComboBoxModel(new String[] {"出库量查询", "入库量查询", "库存查询"}));
		jcb1.setBounds(277, 40, 197, 23);
		contentPane.add(jcb1);
		
		JLabel lblNewLabel_1 = new JLabel("请选择需要查询的物资：");
		lblNewLabel_1.setBounds(69, 113, 174, 26);
		contentPane.add(lblNewLabel_1);
		
		jcb2 = new JComboBox();
		jcb2.setModel(new DefaultComboBoxModel(new String[] {"钢筋", "水泥", "空心砖", "钢化玻璃", "水管", "木材"}));
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
		
		JLabel lblNewLabel_2 = new JLabel("请选择时间段：");
		lblNewLabel_2.setBounds(69, 219, 180, 18);
		contentPane.add(lblNewLabel_2);
		
		JButton backButton = new JButton("<返回");
		backButton.setBounds(70, 301, 93, 45);
		contentPane.add(backButton);
		backButton.addActionListener(new ActionListener(){//添加监听
			public void actionPerformed(ActionEvent e) {
				setVisible(false);	//关闭上一个窗体
				new Function_win1().setVisible(true);
			}
		});
		
		JButton sureButton = new JButton("确定>");
		sureButton.setBounds(419, 301, 93, 45);
		contentPane.add(sureButton);
    	sureButton.addActionListener(new ActionListener(){//添加监听
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
		arr1=jcb1.getSelectedItem().toString();//获取选中的下拉框1值
	}
}
public class comboboxRead2{
	public comboboxRead2() {
		arr2=jcb2.getSelectedItem().toString();//获取选中的下拉框2值
	}
}
public class textRead1 {
	public textRead1() {
	   t_IS1=jt1.getText().toString();//获取文本框的值
	} 
   }
public class textRead2 {
	public textRead2() {
	   t_IS2=jt2.getText().toString();//获取文本框的值
	} 
   }

}
