package BMMI_System;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;

public class last_Test_win {

	private JFrame frame;
	private JTextField textField_2;
	private JPasswordField passwordField;
    String name=null;
    String password=null;
    private String n="admin";
    private String p="dakang666";
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					last_Test_win window = new last_Test_win();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public last_Test_win() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("  ��¼    @Xukun & Hanzhuang");
		frame.setBounds(400, 200, 600, 400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lab = new JLabel("�������ʹ���ϵͳ");
		lab.setBounds(200, 20, 250, 20);
		lab.setFont(new Font("����",Font.PLAIN,25));
		frame.getContentPane().add(lab);
		
		textField_2 = new JTextField();//�û����ı���
		textField_2.setBounds(293, 75, 153, 21);
		frame.getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		passwordField = new JPasswordField();//�����
		passwordField.setBounds(293, 141, 153, 21);
		frame.getContentPane().add(passwordField);
		
		JLabel lblNewLabel = new JLabel("���룺");
		lblNewLabel.setBounds(121, 144, 54, 15);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("�û�����");
		lblNewLabel_1.setBounds(121, 78, 54, 15);
		frame.getContentPane().add(lblNewLabel_1);
		
		JButton sureButton = new JButton("ȷ��>");
		sureButton.setBounds(231, 238, 93, 46);
		frame.getContentPane().add(sureButton);
  	    sureButton.addActionListener(new ActionListener(){//��Ӽ���
			public void actionPerformed(ActionEvent e) {
				new getname();
				new getpassword();
				if(name.equals("")||password.equals("")) {
				if(name.equals("")) {
					JOptionPane.showMessageDialog(null, "�������û�����");
				 }
				else if(!(name.equals(""))&&password.equals("")) {
					JOptionPane.showMessageDialog(null, "���������룡");
				 }
				}
				else {
					if(!(name.equals(n))||!(password.equals(p))){
					    JOptionPane.showMessageDialog(null, "��������ȷ���û��������룡");
				   }
				    if(name.equals(n)&&password.equals(p)) {
				    	JOptionPane.showMessageDialog(null, "��ӭʹ�ã�");
				        frame.setVisible(false);
				        new Function_win1().setVisible(true);
				   }
			    }
		      }
  	  });
	}

public class getname {
	    public getname() {
		name=textField_2.getText().toString();//��ȡ�ı����ֵ
	} 
   }
public class getpassword{
	    public getpassword() {
		password=new String(passwordField.getPassword());//��ȡ����
	}
}


}