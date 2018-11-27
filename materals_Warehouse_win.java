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
	  JTextField jt2=new JTextField();//�ı���
	  JComboBox jcb2=null;//������
	  JRadioButton outRadioButton;
	  JRadioButton entRadioButton;
	public materals_Warehouse_win() {
		super.setTitle("���ʳ����");
  		super.setBounds(400,200,600,400);
  		setLayout(null);
  		super.setVisible(true);
  		super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  		
  		Container ct2=getContentPane();//����
  		
  		outRadioButton=new JRadioButton("����");//��ѡ��ť
  		entRadioButton=new JRadioButton("���");
  		ct2.add(outRadioButton);
  		outRadioButton.setBounds(340, 110, 60, 20);  		
  		ct2.add(entRadioButton);
  		entRadioButton.setBounds(420, 110, 60, 20);
  		group=new ButtonGroup();
  		group.add(outRadioButton);
  		group.add(entRadioButton);
  		
  		
  		String s_IS[]={"�ֽ�","ˮ��","����ש","�ֻ�����","ˮ��","ľ��"};//������
  	    jcb2=new JComboBox(s_IS);
  		jcb2.setBounds(300, 20, 200, 30);
  	    ct2.add(jcb2);
  		
  		JLabel j1=new JLabel("��ѡ����Ҫ�����ʣ�");//��ǩ
  	    j1.setBounds(80, 20, 200, 20);
  	    ct2.add(j1);
  	    
  	    JLabel j2=new JLabel("��ѡ��������ͣ�");//��ǩ
	    j2.setBounds(80, 110, 200, 20);
	    ct2.add(j2);
	    
	    JLabel j3=new JLabel("������������");//��ǩ
	    j3.setBounds(80, 200, 200, 20);
	    ct2.add(j3);
	    
  	    jt2.setBounds(300, 200, 200, 30);//�����ı���λ��
        ct2.add(jt2);
  	    
  		
  		JButton sureButton=new JButton("ȷ��>");//ȷ����ť
  	    sureButton.setBounds(450, 300, 80, 40);
  	    ct2.add(sureButton);
  	    sureButton.addActionListener(new ActionListener(){//��Ӽ���
			public void actionPerformed(ActionEvent e) {
			//	setVisible(false);	//�ر���һ������
				new comboboxRead2();
				new textRead2();
				new radioRead();
				if(arr_mw.equals("")) {
					JOptionPane.showMessageDialog(null, "��ѡ���������ͣ�");
				}
				else if(radio.equals("")) {
					JOptionPane.showMessageDialog(null, "��ѡ����⻹����⣡");
				}
				if(!(radio.equals("")) && t_mw.equals("")) {
					JOptionPane.showMessageDialog(null, "��������������������");
				}
				if(!(isNumeric(t_mw))) {
					JOptionPane.showMessageDialog(null, "��������������Ϊ���֣����������֣�");
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
  		
  	    JButton backButton=new JButton("<����");//���ذ�ť
  		backButton.setBounds(new Rectangle(50, 300, 80, 40));
  		ct2.add(backButton);
  		backButton.addActionListener(new ActionListener(){//��Ӽ���
			public void actionPerformed(ActionEvent e) {
				setVisible(false);	//�ر���һ������
				new Function_win1().setVisible(true);
			}
		});
	}
	
	
	public class textRead2 {
		public textRead2() {
		   t_mw=jt2.getText().toString();//��ȡ�ı����ֵ
		 } 
	   }
	public boolean isNumeric(String str) {//�ж��ı����ȡ��ֵ�Ƿ�Ϊ����
		Pattern pat=Pattern.compile("[0-9]*");
		return pat.matcher(str).matches();
	  }
	
	public class comboboxRead2 {
		public comboboxRead2() {
			arr_mw=jcb2.getSelectedItem().toString();//��ȡѡ�е�������ֵ
		}
	}
	public class radioRead {
		public radioRead() {
			if(outRadioButton.isSelected()) {
				radio=outRadioButton.getText();//��ȡ��ѡ���ֵ
			}
			else if(entRadioButton.isSelected()) {
				radio=entRadioButton.getText();
			}
			else {
				radio="";
			}
		}
	}

	public class mat_ware{//ִ�в���
		public mat_ware(String box,String rad,int text) throws SQLException {
			Connection conn=null;
			GetConn c=new GetConn();
			conn=c.getConnection();
			Statement st=conn.createStatement();
			if(rad=="����" && text>0) {//ִ�г������
				int i=st.executeUpdate("UPDATE Warehouse SET GNum=GNum-"+"'"+text+"'"+" WHERE GId=(SELECT GId FROM Goods WHERE GName="+"'"+box+"')");
				if(i==1) {
					JOptionPane.showMessageDialog(null, "����ɹ���");
				}
				else {
					JOptionPane.showMessageDialog(null, "����ʧ�ܣ�");
				}
			}
			else if(rad=="���" && text>0) {//ִ��������
				int i=st.executeUpdate("UPDATE Warehouse SET GNum=GNum+"+"'"+text+"'"+" WHERE GId=(SELECT GId FROM Goods WHERE GName="+"'"+box+"')");
				if(i==1) {
					JOptionPane.showMessageDialog(null, "���ɹ���");
				}
				else {
					JOptionPane.showMessageDialog(null, "���ʧ�ܣ�");
				}
			}
			else {
				JOptionPane.showMessageDialog(null, "��������������ԣ�");
			}
			st.close();
			conn.close();
		}
	}
	
/*	public static void main(String[] args) {
		new materals_Warehouse_win();  
	}*/

}
