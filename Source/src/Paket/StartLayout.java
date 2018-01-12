package Paket;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import javax.swing.*;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPFile;

import Sides.Layout_01Login;

public class StartLayout implements WindowListener, ComponentListener {

	public static String server = "";
	public static int port = 21;
	public static String user = "isc_auto";
	public static String pw = "1234";

	private static JFrame f = new JFrame("Indoor Soccer Club");
	private JLabel IMG = new JLabel();
	
	public static JLabel Header = new JLabel();
	public static JLabel Header_logo = new JLabel();
	public static JLabel IconHeader = new JLabel();
	public static JLabel Divider = new JLabel();
	public static JLabel Footer = new JLabel();
	public static JLabel RightBar = new JLabel();
	public static JLabel SideBar = new JLabel();
	public static JLabel Mainground = new JLabel();
	
	public static JLabel Background = new JLabel();	
	
	public static JLabel Headline = new JLabel();

	public static JLabel L_Login = new JLabel();
	public static JLabel L_Register = new JLabel();
	public static JLabel L_Start = new JLabel();
	public static JLabel L_Profile = new JLabel();
	public static JLabel L_Group = new JLabel();
	public static JLabel L_Games = new JLabel();
	public static JLabel L_Overview = new JLabel();

	Icon Logo = new ImageIcon(getClass().getResource("/_drawable/Logo.png"));
	
	Icon SideBar_img = new ImageIcon(getClass().getResource("/_drawable/Sidebar.png"));
	Icon Header_img = new ImageIcon(getClass().getResource("/_drawable/Header.png"));
	Icon Footer_img = new ImageIcon(getClass().getResource("/_drawable/Footer.png"));
	
	public static String IP_Adress = "";
			
	public StartLayout() {
		
		new User();
				
		new SideBar.SideBar_Layout();
		new GroupBar.GroupBar_Layout();
		
		new IconBar.IconBar_Layout();
		
		new Sides.Layout_01Login();
		new Sides.Layout_02Register();
		new Sides.Layout_03Start();

		new Sides.Layout_11Profile();
		new Sides.Layout_12Games();
		new Sides.Layout_13Overview();
				
		// Labels
		
		// Layout-Objects
		Header.setBounds(0,0,2000,60);
		Header.setBackground(new Color(69,165,71));
		Header.setOpaque(true);
	
		Header_logo.setBounds(0,0,500,60);
		Header_logo.setIcon(Logo);
		
		IconHeader.setBounds(180,70,2000,30);
		IconHeader.setBackground(new Color(123,191,113));
		IconHeader.setOpaque(true);
	
		Divider.setBounds(0,0,2000,10);
		Divider.setBackground(new Color(240,240,240));
		Divider.setOpaque(true);
		
		Footer.setBackground(new Color(192,212,190));
		Footer.setOpaque(true);

		RightBar.setBackground(new Color(192,212,190));
		RightBar.setOpaque(true);
		
		SideBar.setBounds(0,70,180,2000);
		SideBar.setBackground(new Color(69,165,71));
		SideBar.setOpaque(true);
		
		Mainground.setBounds(180,100,2000,2000);		
		Mainground.setBackground(new Color(204,227,204));
		Mainground.setOpaque(true);
		
		Background.setBounds(0,0,2000,2000);
		
		// Sides
		
		L_Login.setBounds(0,0,2000,2000);
		L_Login.setVisible(true);

		L_Register.setBounds(0,0,2000,2000);
		L_Register.setVisible(false);

		L_Start.setBounds(0,0,2000,2000);
		L_Start.setVisible(false);

		L_Profile.setBounds(0,0,2000,2000);
		L_Profile.setVisible(false);

		L_Group.setBounds(0,0,2000,2000);
		L_Group.setVisible(false);

		L_Games.setBounds(0,0,2000,2000);
		L_Games.setVisible(false);

		L_Overview.setBounds(0,0,2000,2000);
		L_Overview.setVisible(false);
		
		// Inside Labels
		Headline.setText("Headline");
		Headline.setFont(new Font("Arial", Font.BOLD, 35));
		Headline.setBounds(30,15,800,50);		
	
		// Layout
		
		//Icon
	 	ImageIcon icon1 = new ImageIcon(getClass().getResource("/_drawable/Icon.png")); 
	 	f.setIconImage(icon1.getImage());
    	
    	// Layout
		
        f.setLayout(new BorderLayout());
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
		f.setBounds(0,0,800,600);
		f.setExtendedState(JFrame.MAXIMIZED_BOTH); 
		f.addWindowListener(this);
		f.addComponentListener(this);
		
		f.add(IMG);	
		IMG.setLayout( new BorderLayout());
		IMG.add(Background);
		
		Background.add(Header);
		Background.add(IconHeader);
		Background.add(Divider);
		Background.add(Footer);
		Background.add(RightBar);
		Background.add(SideBar);
		
		Background.add(Mainground);
			Mainground.add(L_Login);
			Mainground.add(L_Register);
			Mainground.add(L_Start);
			Mainground.add(L_Profile);
			Mainground.add(L_Group);
			Mainground.add(L_Games);
			Mainground.add(L_Overview);
		
			Header.add(Header_logo);

		f.setVisible(true);
		
		CheckDirs();
		setImages();
		Sides.Layout_01Login.OpenSide();
	}
	
	private void CheckDirs() {
		
		File fdir1 = new File("Users");
		if ( !fdir1.exists() ) { fdir1.mkdir(); }
		
		File fdir2 = new File("Groups");
		if ( !fdir2.exists() ) { fdir2.mkdir(); }

		File fdir3 = new File("dir");
		if ( !fdir3.exists() ) { fdir3.mkdir(); }

		File fdir4 = new File("Places");
		if ( !fdir4.exists() ) { fdir4.mkdir(); }
	}
	
	private void setImages() {
		
		// SideBar
		((ImageIcon) SideBar_img).setImage(((ImageIcon) SideBar_img).getImage().
				getScaledInstance(180, 2000, Image.SCALE_DEFAULT));
		SideBar.setIcon(SideBar_img);

		// Footer
		((ImageIcon) Footer_img).setImage(((ImageIcon) Footer_img).getImage().
				getScaledInstance(2000, 80, Image.SCALE_DEFAULT));
		Footer.setIcon(Footer_img);

		// Header
		((ImageIcon) Header_img).setImage(((ImageIcon) Header_img).getImage().
				getScaledInstance(2000, 60, Image.SCALE_DEFAULT));
		Header.setIcon(Header_img);	
	}
	
	public static void CloseAllSides() {
		
		L_Login.setVisible(false);
		L_Register.setVisible(false);
		L_Start.setVisible(false);
		
		L_Profile.setVisible(false);
		L_Group.setVisible(false);
		L_Games.setVisible(false);
		L_Overview.setVisible(false);
	}
	
	public static void ReloadFrame() {
		
		Mainground.setVisible(false);
		Mainground.setVisible(true);
	}
	
	private void CalculateLayout() {
		
		Footer.setBounds(0, f.getHeight()-80, f.getWidth(), 80);
		RightBar.setBounds(f.getWidth()-180, 100, 180, f.getHeight()-160-20);		
	}
	
	public static void setIP_Adress(String Adress) {
		
		IP_Adress = Adress;
	}
	
	public static String getIP_Adress() {
		
		return IP_Adress;
	}
	
	public static void ConnectingServer(String IP) {
		
		FTPClient ftpClient = new FTPClient();
				
		try {
		
			ftpClient.connect(IP);
			ftpClient.login(user, pw);
			ftpClient.enterLocalActiveMode();
					
			ftpClient.logout();
			ftpClient.disconnect();
		
			// Save IP
			StartLayout.setIP_Adress(IP);
			
		} catch (Exception e) { 
			
			System.out.println("Error by FTP Connection 1"); 
			
			if ( User.Login == false ) {	
				
				Layout_01Login.Login_ErrorInfo.setText("Keine Verbindung gefunden.");
			}
		}
	}
	
	public static void CreateDir(String dir) {
		
		FTPClient ftp = new FTPClient();
				
		try {
		
			ftp.connect(getIP_Adress());
			ftp.login(user, pw);
			ftp.enterLocalActiveMode();
			
			ftp.makeDirectory(dir);
			
			ftp.logout();
			ftp.disconnect();			
		
		} catch (Exception e) { System.out.println("Error by FTP Connection 2"); }
	}

	public static void DeleteDir(String dir) {
		
		FTPClient ftp = new FTPClient();
				
		try {
		
			ftp.connect(getIP_Adress());
			ftp.login(user, pw);
			ftp.enterLocalActiveMode();
			
			ftp.deleteFile(dir);
			
			ftp.logout();
			ftp.disconnect();			
		
		} catch (Exception e) { 
			
			System.out.println("Error by FTP Connection 3"); 
		}
	}
	
	public static void UploadFile(String Uploadfile, String NewFilePath) {
		
		FTPClient ftp = new FTPClient();
		FileInputStream fis = null;
				
		try {
		
			ftp.connect(getIP_Adress());
			ftp.login(user, pw);
			ftp.enterLocalActiveMode();
			
			fis = new FileInputStream(NewFilePath);
			ftp.storeFile(Uploadfile, fis);
			
			ftp.logout();
			ftp.disconnect();			
					
		} catch (Exception e) { System.out.println("Error by FTP Connection 4"); }
	}

	public static void DownloadFile(String Downloadfile, String NewFilePath) {
		
		FTPClient ftp = new FTPClient();
		FileOutputStream fos = null;
				
		try {
		
			ftp.connect(getIP_Adress());
			ftp.login(user, pw);
			ftp.enterLocalActiveMode();
			
			fos = new FileOutputStream(NewFilePath);
			ftp.retrieveFile(Downloadfile, fos);
			
			ftp.logout();
			ftp.disconnect();
		
		} catch (Exception e) { System.out.println("Error by FTP Connection 5"); }
	}
	
	public static String[] getFiles(String FilePath, String[] List, int DeleteLetter) {
		
		FTPClient ftp = new FTPClient();
		
		try { 
			
			ftp.connect(getIP_Adress());
			ftp.login(user, pw);
			ftp.enterLocalActiveMode();

			FTPFile[] files = ftp.listFiles(FilePath);
					 
			List = new String[files.length];
			int count = 0;
			
			for (FTPFile file : files) {
		    
				String details = file.getName().substring(0,file.getName().length()-DeleteLetter);
		    	
				List[count] = details;
				count++;
			}
			
			ftp.logout();
			ftp.disconnect();

		} catch (Exception e) { System.out.println("Error by FTP Connection 6"); e.getStackTrace(); }
		
		return List;

	}

	public void windowActivated(WindowEvent arg0) {
		
	}

	public void windowClosed(WindowEvent arg0) { }

	public void windowClosing(WindowEvent arg0) {
			
		if ( User.InGroup == true ) {
			
			System.out.println("Delete User form Group:");
			System.out.println("Groupsﬂ/" + User.User_Group[0] + "/" + User.User_Data[2] + ".txt");
			DeleteDir("Groups/" + User.User_Group[0] + "/" + User.User_Data[2] + ".txt");
		}
	
		System.out.println("System Closed");
	}

	// WindowListener
	public void windowDeactivated(WindowEvent arg0) {
	}

	public void windowDeiconified(WindowEvent arg0) {
	}

	public void windowIconified(WindowEvent arg0) {
	}

	public void windowOpened(WindowEvent arg0) {
	}

	// ComponentListener
	public void componentHidden(ComponentEvent arg0) {
	}

	public void componentMoved(ComponentEvent arg0) {
	}

	public void componentResized(ComponentEvent arg0) {
		CalculateLayout();
	}

	public void componentShown(ComponentEvent arg0) {
	}
	
}
