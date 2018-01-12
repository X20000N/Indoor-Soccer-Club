package SideBar;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import GroupBar.GroupBar_Layout;
import Paket.StartLayout;
import Paket.User;
import Sides.Layout_02Register;
import Sides.Layout_11Profile;
import Sides.Layout_12Games;
import Sides.Layout_13Overview;

public class SideBar_Layout implements ActionListener {
		
	private static JButton Menu_Profile = new JButton();
	private static JButton Menu_Games = new JButton();
	public static JButton Menu_Overview = new JButton();
	
	private static JButton Menu_Register = new JButton(); 
	
	public SideBar_Layout() {
					
		// Buttons
		
		Font Font_button = new Font("Arial", Font.BOLD, 18);
		
		Menu_Profile.setText("Profil");
		Menu_Profile.addActionListener(this);
		Menu_Profile.setBackground(new Color(167,210,168));
		Menu_Profile.setFont(Font_button);
		Menu_Profile.setBounds(15,30+60*0,147,35);

		Menu_Games.setText("Spiele");
		Menu_Games.addActionListener(this);
		Menu_Games.setBackground(new Color(167,210,168));
		Menu_Games.setFont(Font_button);
		Menu_Games.setBounds(15,30+60*1,147,35);

		Menu_Overview.setText("Übersicht");
		Menu_Overview.addActionListener(this);
		Menu_Overview.setBackground(new Color(200,200,200));
		Menu_Overview.setFont(Font_button);
		Menu_Overview.setBounds(15,30+60*2,147,35);

		Menu_Register.setText("Registrieren");
		Menu_Register.addActionListener(this);
		Menu_Register.setBackground(new Color(167,210,168));
		Menu_Register.setBounds(15,30+60*0,147,35);
		Menu_Register.setFont(Font_button);
		
		// Layout 
		
		StartLayout.SideBar.add(Menu_Profile);
		StartLayout.SideBar.add(Menu_Games);
		StartLayout.SideBar.add(Menu_Overview);
		
		StartLayout.SideBar.add(Menu_Register);
		
		InvisibleAllButtons();
	}
	
	public static void InvisibleAllButtons() {
		
		Menu_Register.setVisible(false);
		
		Menu_Profile.setVisible(false);
		Menu_Games.setVisible(false);
		Menu_Overview.setVisible(false);
	}
	
	public static void InvisibleButtons() {
		
		Menu_Register.setVisible(true);
		
		Menu_Profile.setVisible(false);
		Menu_Games.setVisible(false);
		Menu_Overview.setVisible(false);
		
		GroupBar_Layout.CloseSide();
	}
	
	public static void VisibleButtons() {
		
		Menu_Register.setVisible(false);
		
		Menu_Profile.setVisible(true);
		Menu_Games.setVisible(true);
		Menu_Overview.setVisible(true);
		
		GroupBar_Layout.OpenSide();
	}

	public void actionPerformed(ActionEvent e) {

		if ( e.getSource() == Menu_Profile && Paket.User.Login == true ) {
			
			Layout_11Profile.OpenSide();
		}

		if ( e.getSource() == Menu_Games && Paket.User.Login == true ) {
						
			Layout_12Games.OpenSide();
		}

		if ( e.getSource() == Menu_Overview && Paket.User.Login == true ) {
						
			if ( User.PlayGame == true ) {
				
				Layout_13Overview.OpenSide(false);
			}
		}

		if ( e.getSource() == Menu_Register ) {
			
			Layout_02Register.OpenSide();
		}
		
	}

}
