package Sides;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.*;

import Extern.SafeUser;
import Paket.StartLayout;
import Paket.User;

public class Layout_01Login implements ActionListener, KeyListener {
		
	private static JButton Login_IP_Connect = new JButton();
	private static JLabel Login_IP = new JLabel();
	private static JTextField Login_IP_Tf = new JTextField();
	
	private static JLabel Login_Name = new JLabel();
	private static JLabel Login_Keyword = new JLabel();
	
	public static JLabel Login_ErrorInfo = new JLabel();
	
	private static JTextField Login_Name_Tf = new JTextField();
	private static JPasswordField Login_Keyword_Tf = new JPasswordField();
	
	private static JLabel Login_NewPassword = new JLabel();
	private static JButton Login_NewPassword_but = new JButton();
	
	private static JButton Login_Login = new JButton();
	
	// InternalFrame
	
	private static  JInternalFrame Login_CreateNewPassword = new JInternalFrame("Passwort zurücksetzen", false, true, false, false);
	private JLabel Login_Internal_Background = new JLabel();

	private JLabel Login_Internal_Name = new JLabel();
	private JTextField Login_Internal_Name_Tf = new JTextField();
	
	private JLabel Login_Internal_Keyword = new JLabel();
	private JPasswordField Login_Internal_Keyword_Tf = new JPasswordField();

	private JButton Login_Internal_NewKeyword = new JButton();

	public Layout_01Login() {
		
		// Labels
		
		Font Font_label = new Font("Arial", Font.BOLD, 20);
		
		Login_Name.setText("Nachname: ");
		Login_Name.setBounds(30,90,150,50);
		Login_Name.setFont(Font_label);
		Login_Name.setVisible(false);
		
		Login_Keyword.setText("Passwort: ");
		Login_Keyword.setBounds(30,140,150,50);
		Login_Keyword.setFont(Font_label);
		Login_Keyword.setVisible(false);
		
		Login_IP.setText("IP - Adresse: ");
		Login_IP.setBounds(30,90,150,50);
		Login_IP.setFont(Font_label);
		
		Login_ErrorInfo.setForeground(new Color(200,0,10));
		Login_ErrorInfo.setFont(new Font("Arial", Font.BOLD, 18));
		Login_ErrorInfo.setBounds(250,215,450,40);
		
		Login_NewPassword.setText("Passwort vergessen");
		Login_NewPassword.setBounds(460,140,200,50);
		Login_NewPassword.setFont(new Font("Arial", Font.BOLD, 16));

		Login_Internal_Background.setBounds(0,0,2000,2000);
		Login_Internal_Background.setOpaque(true);
		Login_Internal_Background.setBackground(new Color(204,227,204));

		Login_Internal_Name.setText("Nachname:");
		Login_Internal_Name.setBounds(10,10,250,50);
		Login_Internal_Name.setFont(Font_label);

		Login_Internal_Keyword.setText("Neues Passwort:");
		Login_Internal_Keyword.setBounds(10,60,250,50);
		Login_Internal_Keyword.setFont(Font_label);

		// TextField
		
		Font Font_textfield = new Font("Arial", Font.BOLD, 18);

		Login_Name_Tf.setText("");
		Login_Name_Tf.addKeyListener(this);
		Login_Name_Tf.setBounds(150,95,300,40);
		Login_Name_Tf.setFont(Font_textfield);
		Login_Name_Tf.setVisible(false);
		
		Login_Keyword_Tf.setText("");
		Login_Keyword_Tf.addKeyListener(this);
		Login_Keyword_Tf.setBounds(150,145,300,40);
		Login_Keyword_Tf.setFont(Font_textfield);
		Login_Keyword_Tf.setVisible(false);
		
		Login_IP_Tf.setText("144.76.167.70"); // 10.141.66.73 // 192.168.2.120
		Login_IP_Tf.addKeyListener(this);
		Login_IP_Tf.setBounds(200,95,250,40);
		Login_IP_Tf.setFont(Font_textfield);
		
		Login_Internal_Name_Tf.setBounds(180,15,220,40);
		Login_Internal_Name_Tf.setFont(Font_textfield);
		
		Login_Internal_Keyword_Tf.setBounds(180,65,220,40);
		Login_Internal_Keyword_Tf.setFont(Font_textfield);
	
		// InternalFrame
		
		Login_CreateNewPassword.setBounds(30,30,420,200);
		Login_CreateNewPassword.setVisible(false);
		
		// Buttons
		
		Font Font_button = new Font("Arial", Font.BOLD, 18);

		Login_Login.setText("Einloggen");
		Login_Login.addActionListener(this);
		Login_Login.setBackground(new Color(167,210,168));
		Login_Login.setBounds(30,215,180,40);
		Login_Login.setFont(Font_button);
		Login_Login.setVisible(false);
		
		Login_IP_Connect.setText("Verbinden");
		Login_IP_Connect.addActionListener(this);
		Login_IP_Connect.setBackground(new Color(167,210,168));
		Login_IP_Connect.setBounds(267,155,180,40);
		Login_IP_Connect.setFont(Font_button);

		Login_NewPassword_but.setOpaque(false);
		Login_NewPassword_but.setContentAreaFilled(false);
		Login_NewPassword_but.setBorderPainted(false);
		Login_NewPassword_but.addActionListener(this);
		Login_NewPassword_but.setBounds(455,150,170,30);

		Login_Internal_NewKeyword.setText("Annehmen");
		Login_Internal_NewKeyword.addActionListener(this);
		Login_Internal_NewKeyword.setBackground(new Color(167,210,168));
		Login_Internal_NewKeyword.setBounds(10, 115, 230, 35);
		Login_Internal_NewKeyword.setFont(Font_button);
		
		// Layout		

		StartLayout.L_Login.add(Login_IP);
		StartLayout.L_Login.add(Login_IP_Tf);
		StartLayout.L_Login.add(Login_IP_Connect);

		StartLayout.L_Login.add(Login_Name);
		StartLayout.L_Login.add(Login_Keyword);
		StartLayout.L_Login.add(Login_Name_Tf);
		StartLayout.L_Login.add(Login_Keyword_Tf);
		StartLayout.L_Login.add(Login_ErrorInfo);
		StartLayout.L_Login.add(Login_NewPassword);
		StartLayout.L_Login.add(Login_NewPassword_but);
		
		StartLayout.L_Login.add(Login_Login);

		// Internalframe - Layout
		
		StartLayout.Mainground.add(Login_CreateNewPassword);
		Login_CreateNewPassword.add(Login_Internal_Background);

		Login_Internal_Background.add(Login_Internal_Name);
		Login_Internal_Background.add(Login_Internal_Name_Tf);

		Login_Internal_Background.add(Login_Internal_Keyword);
		Login_Internal_Background.add(Login_Internal_Keyword_Tf);
	
		Login_Internal_Background.add(Login_Internal_NewKeyword);
	}
	
	private static void ResetAll() {

		Login_Name_Tf.setBackground(new Color(255,255,255));
		Login_Keyword_Tf.setBackground(new Color(255,255,255));

		Login_Name.setVisible(false);
		Login_Keyword.setVisible(false);
		Login_Name_Tf.setVisible(false);
		Login_Keyword_Tf.setVisible(false);
		Login_ErrorInfo.setVisible(false);
		Login_Login.setVisible(false);
		Login_NewPassword.setVisible(false);
		Login_NewPassword_but.setVisible(false);
			
		Login_IP.setVisible(true);
		Login_IP_Tf.setVisible(true);
		Login_IP_Connect.setVisible(true);
	}
	
	public static void OpenSide() {
		
		StartLayout.CloseAllSides();

		Paket.User.Side_ID = 1001;
		User.SetNewSide(Paket.User.Side_ID);
		
		StartLayout.L_Login.add(StartLayout.Headline);
		StartLayout.Headline.setText("Mit Server verbinden");
		
		StartLayout.L_Login.setVisible(true);
		StartLayout.ReloadFrame();
		ResetAll();
	}
	
	static void Connecting() {

		try {
		
			StartLayout.ConnectingServer(Login_IP_Tf.getText());
						
			StartLayout.Headline.setText("Login");
		
			Login_Name.setVisible(true);
			Login_Keyword.setVisible(true);
			Login_Name_Tf.setVisible(true);
			Login_Keyword_Tf.setVisible(true);
			Login_ErrorInfo.setVisible(true);
			Login_Login.setVisible(true);
			Login_NewPassword.setVisible(true);
			Login_NewPassword_but.setVisible(true);

			Login_IP.setVisible(false);
			Login_IP_Tf.setVisible(false);
			Login_IP_Connect.setVisible(false);	
			
			SideBar.SideBar_Layout.InvisibleButtons();
	
		} catch (Exception e) { Login_ErrorInfo.setText("Warnung: Verbindung fehlgeschlagen"); }
	}
	
	@SuppressWarnings({ "deprecation" })
	private static void CheckLoginData() {
			
		Login_Name_Tf.setBackground(new Color(255,255,255));
		Login_Keyword_Tf.setBackground(new Color(255,255,255));

		StartLayout.DownloadFile("Users/" + Login_Name_Tf.getText() + ".usr", "Users/" + Login_Name_Tf.getText() + ".usr");
		
		Login_ErrorInfo.setText("");
		boolean Check = false;
		
		User.ReadUser(Login_Name_Tf.getText());
				
		if ( Login_Keyword_Tf.getText().equals(User.User_Data[0]) ) { Check = true; }
		
		if ( Check == true ) {
		
			Layout_03Start.OpenSide();

		} else {

			Login_Name_Tf.setBackground(new Color(200,0,10));
			Login_Keyword_Tf.setBackground(new Color(200,0,10));
			Login_ErrorInfo.setText("Benutzername oder Kennwort falsch");
		}
	}
	
	@SuppressWarnings("deprecation")
	private void checkFieldsInInternal() {
	
		Login_Internal_Name_Tf.setBackground(new Color(255,255,255));
		Login_Internal_Keyword_Tf.setBackground(new Color(255,255,255));

		User.ReadUser(Login_Internal_Name_Tf.getText());
		
		if ( !Login_Internal_Keyword_Tf.getText().isEmpty() ) {
		
			try {
		
				if ( !User.User_Data[0].isEmpty()) {
						
					User.User_Data[0] = Login_Internal_Keyword_Tf.getText();

					SafeUser.SafeUserFromEdit();
					StartLayout.UploadFile("Users/" + User.User_Data[2] + ".usr", "Users/" + User.User_Data[2] + ".usr");
		
					Login_CreateNewPassword.setVisible(false);
					
				} else { Login_Internal_Name_Tf.setBackground(new Color(200,10,10)); }
				
			} catch (Exception e1) { Login_Internal_Name_Tf.setBackground(new Color(200,10,10)); }
		
		} else { Login_Internal_Keyword_Tf.setBackground(new Color(200,10,10)); }	
	}

	public void actionPerformed(ActionEvent e) {

		if ( e.getSource() == Login_Login ) {
			
			CheckLoginData();
		}
		
		if ( e.getSource() == Login_IP_Connect ) {
			
			if ( !Login_IP_Tf.getText().equals("") ) {
				
				Connecting();
			}
		}
		
		if ( e.getSource() == Login_NewPassword_but ) {
			
			Login_CreateNewPassword.setVisible(true);
		}
		
		if ( e.getSource() == Login_Internal_NewKeyword ) {
			
			checkFieldsInInternal();
		}
	}

	public void keyPressed(KeyEvent e) {
	
		if ( e.getSource() == Login_Keyword_Tf && e.getKeyCode() == KeyEvent.VK_ENTER ) {
			
			CheckLoginData();
		}
	}

	public void keyReleased(KeyEvent e) {}

	public void keyTyped(KeyEvent e) {}

}
