package BMMI_System;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.WindowConstants;

public class Function_win1 extends JFrame{//����ѡ����
	public Function_win1() {
		JButton jbt1,jbt2,jbt3;
		setTitle("����ѡ��");
		setBounds(400,200,600,400);
		setLayout(null);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		jbt1=new JButton("��Ϣ��ѯ");
		jbt1.setBounds(new Rectangle(175, 50, 250, 50));
		add(jbt1);
		jbt1.addActionListener(new ActionListener(){//��Ӽ����¼�
				public void actionPerformed(ActionEvent e) {
					setVisible(false);	//�ر���һ������
					new Information_Search_win().setVisible(true);
				}
			});
		
    	jbt2=new JButton("���ʳ����");
		jbt2.setBounds(new Rectangle(175, 150, 250, 50));
		jbt2.setLayout(null);
		add(jbt2);
		jbt2.addActionListener(new ActionListener(){//��Ӽ����¼�
			public void actionPerformed(ActionEvent e) {
				setVisible(false);	//�ر���һ������
				new materals_Warehouse_win().setVisible(true);
			}
		});
		
		jbt3=new JButton("��Ϣ����");
		jbt3.setBounds(new Rectangle(175, 250, 250, 50));
		add(jbt3);
		jbt3.addActionListener(new ActionListener(){//��Ӽ����¼�
			public void actionPerformed(ActionEvent e) {
				setVisible(false);	//�ر���һ������
				new information_Management_win().setVisible(true);
			}
		});    
	}
/*	public static void main(String[] args) {
		new Function_win1();  
	}*/
}
