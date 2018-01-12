package Sides;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;

import javax.swing.*;

import Extern.SafeUser;
import Paket.StartLayout;
import Paket.User;

public class Layout_02Register implements ActionListener {

	private static JLabel Register_Picture = new JLabel();
	private JButton Register_OpenPic = new JButton();
	static private Icon Register_Picture_img = new ImageIcon("");
	public static String Pic_url = "";
	
	// Question
	private JLabel Register_Secondname = new JLabel();
	private JLabel Register_Firstname = new JLabel();
	
	private JLabel Register_Place = new JLabel();
	private JLabel Register_Town = new JLabel();
	
	private JLabel Register_Password = new JLabel();

	// Answere
	public static JTextField Register_Firstname_Tf = new JTextField();
	public static JTextField Register_Secondname_Tf = new JTextField();
	
	public static JTextField Register_Place_Tf = new JTextField();
	public static JTextField Register_Town_Tf = new JTextField();
	
	public static JPasswordField Register_Password_Tf = new JPasswordField();
	
	private JButton Register_Safe = new JButton();
	
	JFileChooser LoadPic = new JFileChooser();
	
	// Lines
	private JLabel Register_Line01 = new JLabel();
	private JLabel Register_Line02 = new JLabel();
		
	public Layout_02Register() {
		
		// Labels
		
		Font Font_label = new Font("Arial", Font.BOLD, 20);
		
		Register_Firstname.setText("Name:");
		Register_Firstname.setBounds(30,140,300,50);
		Register_Firstname.setFont(Font_label);
		
		Register_Secondname.setText("Nachname:");
		Register_Secondname.setBounds(30,90,300,50);
		Register_Secondname.setFont(Font_label);
		
		Register_Line01.setText("___________________________________________________");
		Register_Line01.setBounds(25,185,2000,30);
		Register_Line01.setFont(Font_label);

		Register_Place.setText("Postleitzahl:");
		Register_Place.setBounds(30,220,300,50);
		Register_Place.setFont(Font_label);

		Register_Town.setText("Stadt:");
		Register_Town.setBounds(30,270,300,50);
		Register_Town.setFont(Font_label);
		Register_Line02.setText("___________________________________________________");
		Register_Line02.setBounds(25,305,2000,30);
		Register_Line02.setFont(Font_label);
	
		Register_Password.setText("Passwort:");
		Register_Password.setBounds(30,340,300,50);
		Register_Password.setFont(Font_label);
		
		// Textfield
		
		Font Font_textfield = new Font("Arial", Font.BOLD, 18);

		Register_Firstname_Tf.setText("");
		Register_Firstname_Tf.setBounds(30+240,150,300,40);
		Register_Firstname_Tf.setFont(Font_textfield);

		Register_Secondname_Tf.setText("");
		Register_Secondname_Tf.setBounds(30+240,100,300,40);
		Register_Secondname_Tf.setFont(Font_textfield);

		Register_Place_Tf.setText("");
		Register_Place_Tf.setBounds(30+240,220,300,40);
		Register_Place_Tf.setFont(Font_textfield);

		Register_Town_Tf.setText("");
		Register_Town_Tf.setBounds(30+240,270,300,40);
		Register_Town_Tf.setFont(Font_textfield);

		Register_Password_Tf.setText("");
		Register_Password_Tf.setBounds(30+140,340,220,40);
		Register_Password_Tf.setFont(Font_textfield);

		// Chooser
		
		LoadPic.addActionListener(this);
		
		// Buttons
		
		Font Font_button = new Font("Arial", Font.BOLD, 18);

		Register_Safe.setText("Speichern");
		Register_Safe.addActionListener(this);
		Register_Safe.setBackground(new Color(167,210,168));
		Register_Safe.setBounds(30,410,170,40);
		Register_Safe.setFont(Font_button);
		
		Register_OpenPic.setOpaque(false);
		Register_OpenPic.setContentAreaFilled(false);
		Register_OpenPic.addActionListener(this);
		Register_OpenPic.setBounds(640, 30, 133*2, 350);
		Register_OpenPic.setFont(Font_button);

		// Image
		
		Register_Picture.setBounds(640, 30, 133*2, 350);
		Register_Picture.setIcon(Register_Picture_img);
		Register_Picture.setOpaque(true);
		Register_Picture.setBackground(new Color(255,255,255));
		
		// Laoyut 
		
		StartLayout.L_Register.add(Register_Firstname);
		StartLayout.L_Register.add(Register_Firstname_Tf);
		StartLayout.L_Register.add(Register_Secondname);
		StartLayout.L_Register.add(Register_Secondname_Tf);

		StartLayout.L_Register.add(Register_Line01);
		
		StartLayout.L_Register.add(Register_Place);
		StartLayout.L_Register.add(Register_Place_Tf);
		StartLayout.L_Register.add(Register_Town);
		StartLayout.L_Register.add(Register_Town_Tf);

		StartLayout.L_Register.add(Register_Line02);

		StartLayout.L_Register.add(Register_Password);
		StartLayout.L_Register.add(Register_Password_Tf);
		
		StartLayout.L_Register.add(Register_Safe);
	}
	
	@SuppressWarnings("deprecation")
	private void CheckFields() {
		
		ResetAll();

		boolean CreateUser = true;
		
		if ( Register_Firstname_Tf.getText().equals("") ) { 	
			
			CreateUser = false; 
			Register_Firstname_Tf.setBackground(new Color(200,0,10)); 
		}
		
		if ( Register_Secondname_Tf.getText().equals("") ) {
			
			CreateUser = false; 
			Register_Secondname_Tf.setBackground(new Color(200,0,10));
		}
		
		if ( Register_Place_Tf.getText().equals("") ) { 		
			
			CreateUser = false; 
			Register_Place_Tf.setBackground(new Color(200,0,10)); 
		}
		
		if ( Register_Town_Tf.getText().equals("") ) { 			CreateUser = false; Register_Town_Tf.setBackground(new Color(200,0,10)); }
		if ( Register_Password_Tf.getText().equals("") ) {		CreateUser = false; Register_Password_Tf.setBackground(new Color(200,0,10)); }
				
		try { Integer.parseInt(Register_Place_Tf.getText()); } catch (Exception e) { CreateUser = false; Register_Place_Tf.setBackground(new Color(200,0,10)); }

		if ( CreateUser == true ) {
			
			SafeUser.SafeUserFromRegister(Register_Secondname_Tf.getText(), getHighestID());
			Sides.Layout_01Login.OpenSide();
		}
		
	}
	
	private int getHighestID() {
		
		StartLayout.DownloadFile("Material/NumberID.txt", "dir/NumberID.txt");
		
		int HighestID = 1700;
		
		try {

			FileReader fr = new FileReader("dir/NumberID.txt");
			BufferedReader br = new BufferedReader(fr);
			
			HighestID = Integer.parseInt(br.readLine());
			
			System.out.println("HighestID:1 " + HighestID);
			
			fr.close();
			
			FileWriter fw = new FileWriter("dir/NumberID.txt");
			
			HighestID++;
			fw.write(HighestID + "");

			System.out.println("HighestID:2 " + HighestID);

			fw.close();
			
		} catch (Exception e) { 
		
			System.out.println("Error by ID"); 
		}
		
		StartLayout.UploadFile("Material/NumberID.txt", "dir/NumberID.txt");
		
		return HighestID;	
	}
	
	public static void getPictureUrl(String url) {
		
		Pic_url = url;
		
		Register_Picture_img = new ImageIcon(Pic_url + "");
		
		((ImageIcon) Register_Picture_img).setImage(((ImageIcon) Register_Picture_img).getImage().
				getScaledInstance(Register_Picture.getWidth(), Register_Picture.getHeight(), Image.SCALE_DEFAULT));
		Register_Picture.setIcon(Register_Picture_img);
	}
	
	private static void ResetAll() {

		Register_Firstname_Tf.setBackground(new Color(255,255,255));
		Register_Secondname_Tf.setBackground(new Color(255,255,255));
		Register_Place_Tf.setBackground(new Color(255,255,255));
		Register_Town_Tf.setBackground(new Color(255,255,255));
		Register_Password_Tf.setBackground(new Color(255,255,255));
	}

	public static void OpenSide() {
		
		StartLayout.CloseAllSides();

		Paket.User.Side_ID = 1002;
		User.SetNewSide(Paket.User.Side_ID);
		
		StartLayout.L_Register.add(StartLayout.Headline);
		StartLayout.Headline.setText("Registrieren");
		
		StartLayout.L_Register.setVisible(true);
		StartLayout.ReloadFrame();
		ResetAll();
	}

	public void actionPerformed(ActionEvent e) {

		if ( e.getSource() == Register_Safe ) {
			
			CheckFields();
		}
		
		if ( e.getSource() == Register_OpenPic ) {
			
			if ( !Register_Secondname_Tf.getText().equals("") ) {
				LoadPic.showOpenDialog(null);
			}
		}
	}
}
