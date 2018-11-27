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

public class Function_win1 extends JFrame{//功能选择窗体
	public Function_win1() {
		JButton jbt1,jbt2,jbt3;
		setTitle("功能选项");
		setBounds(400,200,600,400);
		setLayout(null);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		jbt1=new JButton("信息查询");
		jbt1.setBounds(new Rectangle(175, 50, 250, 50));
		add(jbt1);
		jbt1.addActionListener(new ActionListener(){//添加监听事件
				public void actionPerformed(ActionEvent e) {
					setVisible(false);	//关闭上一个窗体
					new Information_Search_win().setVisible(true);
				}
			});
		
    	jbt2=new JButton("物资出入库");
		jbt2.setBounds(new Rectangle(175, 150, 250, 50));
		jbt2.setLayout(null);
		add(jbt2);
		jbt2.addActionListener(new ActionListener(){//添加监听事件
			public void actionPerformed(ActionEvent e) {
				setVisible(false);	//关闭上一个窗体
				new materals_Warehouse_win().setVisible(true);
			}
		});
		
		jbt3=new JButton("信息管理");
		jbt3.setBounds(new Rectangle(175, 250, 250, 50));
		add(jbt3);
		jbt3.addActionListener(new ActionListener(){//添加监听事件
			public void actionPerformed(ActionEvent e) {
				setVisible(false);	//关闭上一个窗体
				new information_Management_win().setVisible(true);
			}
		});    
	}
/*	public static void main(String[] args) {
		new Function_win1();  
	}*/
}
