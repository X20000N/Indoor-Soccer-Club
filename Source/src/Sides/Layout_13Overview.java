package Sides;

import Paket.StartLayout;
import Paket.User;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.*;

public class Layout_13Overview implements ActionListener {

	private JLabel Image = new JLabel();
	private Icon Image_pic = new ImageIcon(getClass().getResource("/_drawable/Place.png"));
	
	private JLabel Overview_Date = new JLabel();
	private JLabel Overview_Clock = new JLabel();

	private JLabel Overview_Hall = new JLabel();
	private JLabel Overview_Street = new JLabel();
	private JLabel Overview_Adress = new JLabel();
	private JLabel Overview_Place = new JLabel();

	static JLabel Overview_Date_2 = new JLabel();
	static JLabel Overview_Clock_2 = new JLabel();

	static JLabel Overview_Hall_2 = new JLabel();
	static JLabel Overview_Street_2 = new JLabel();
	static JLabel Overview_Adress_2 = new JLabel();
	static JLabel Overview_Place_2 = new JLabel();
	
	static JButton Overview_Cancel = new JButton();
	static JButton Overview_Accept = new JButton();
	static JButton Overview_Previous = new JButton();
	static JButton Overview_Next = new JButton();
	
	static JLabel Overview_FoundInfos = new JLabel();
	
	static int Place = 0;
	
	public Layout_13Overview() {
		
		// Labels
		
		Font Font_label = new Font("Arial", Font.BOLD, 20);

		// Left
		Overview_Hall.setText("Halle:");
		Overview_Hall.setBounds(200,90,350,50);
		Overview_Hall.setFont(Font_label);

		Overview_Hall_2.setBounds(320,90,400,50);
		Overview_Hall_2.setFont(Font_label);

		Overview_Street.setText("Straße:");
		Overview_Street.setBounds(200,140,350,50);
		Overview_Street.setFont(Font_label);

		Overview_Street_2.setBounds(320,140,400,50);
		Overview_Street_2.setFont(Font_label);

		Overview_Adress.setText("Adresse:");
		Overview_Adress.setBounds(200,190,350,50);
		Overview_Adress.setFont(Font_label);

		Overview_Adress_2.setBounds(320,190,400,50);
		Overview_Adress_2.setFont(Font_label);
		
		Overview_Place.setText("Platz:");
		Overview_Place.setForeground(new Color(0,148,255));
		Overview_Place.setBounds(200,240,350,50);
		Overview_Place.setFont(Font_label);

		Overview_Place_2.setForeground(new Color(0,148,255));
		Overview_Place_2.setBounds(320,240,400,50);
		Overview_Place_2.setFont(Font_label);
		
		// Right
		Overview_Date.setText("Datum:");
		Overview_Date.setBounds(620,190,350,50);
		Overview_Date.setFont(Font_label);

		Overview_Date_2.setText("01.01.2020");
		Overview_Date_2.setBounds(740,190,285,50);
		Overview_Date_2.setFont(Font_label);
		
		Overview_Clock.setText("Uhrzeit:");
		Overview_Clock.setBounds(620,240,350,50);
		Overview_Clock.setFont(Font_label);
		
		Overview_Clock_2.setText("00.00 Uhr");
		Overview_Clock_2.setBounds(740,240,285,50);
		Overview_Clock_2.setFont(Font_label);

		Overview_FoundInfos.setText("Ergebnis 1 / 3");
		Overview_FoundInfos.setBounds(645,345,285,50);
		Overview_FoundInfos.setFont(new Font("Arial", Font.ITALIC, 20));
		
		// Image
		Image.setBounds(32,100,135,180);
		Image.setIcon(Image_pic);
		
		// Buttons

		Font Font_button = new Font("Arial", Font.BOLD, 18);

		Overview_Cancel.setText("Abbrechen");
		Overview_Cancel.addActionListener(this);
		Overview_Cancel.setBackground(new Color(167,210,168));
		Overview_Cancel.setBounds(30,350,140,40);
		Overview_Cancel.setFont(Font_button);

		Overview_Previous.setText("Vorherige Platz");
		Overview_Previous.addActionListener(this);
		Overview_Previous.setBackground(new Color(167,210,168));
		Overview_Previous.setBounds(200,350,190,40);
		Overview_Previous.setFont(Font_button);

		Overview_Next.setText("Nächster Platz");
		Overview_Next.addActionListener(this);
		Overview_Next.setBackground(new Color(167,210,168));
		Overview_Next.setBounds(420,350,190,40);
		Overview_Next.setFont(Font_button);

		Overview_Accept.setText("Belegen");
		Overview_Accept.addActionListener(this);
		Overview_Accept.setBackground(new Color(167,210,168));
		Overview_Accept.setBounds(30,410,140,40);
		Overview_Accept.setFont(Font_button);

		// Layout
		
		StartLayout.L_Overview.add(Image);		

		StartLayout.L_Overview.add(Overview_Hall);		
		StartLayout.L_Overview.add(Overview_Street);		
		StartLayout.L_Overview.add(Overview_Adress);		
		StartLayout.L_Overview.add(Overview_Place);		
		StartLayout.L_Overview.add(Overview_Date);
		StartLayout.L_Overview.add(Overview_Clock);
		
		StartLayout.L_Overview.add(Overview_Hall_2);		
		StartLayout.L_Overview.add(Overview_Street_2);		
		StartLayout.L_Overview.add(Overview_Adress_2);		
		StartLayout.L_Overview.add(Overview_Place_2);		
		StartLayout.L_Overview.add(Overview_Date_2);
		StartLayout.L_Overview.add(Overview_Clock_2);
		StartLayout.L_Overview.add(Overview_FoundInfos);

		StartLayout.L_Overview.add(Overview_Cancel);
		StartLayout.L_Overview.add(Overview_Previous);
		StartLayout.L_Overview.add(Overview_Next);
		StartLayout.L_Overview.add(Overview_Accept);
	}
	
	static void calculateButton() {
		
		int current = Layout_12Games.ViewPlaceOverview;
		int max = Layout_12Games.MaxPlace;

		Overview_FoundInfos.setText("Ergebnis " + current + " / " + max);
		
		Overview_Previous.setBackground(new Color(200,200,200));
		Overview_Next.setBackground(new Color(200,200,200));

		if ( current > 1 ) {

			Overview_Previous.setBackground(new Color(167,210,168));
		}
		
		if ( current < max ) {
			
			Overview_Next.setBackground(new Color(167,210,168));
		}
		
	}
	
	static void setOverviewPlaces(int Placenumber, String Clock) {
		
		Placenumber--;
		
		String hall = Layout_12Games.Hall[Layout_12Games.PlaceSearchFound[Placenumber][0]][1];
		String street1 = Layout_12Games.Hall[Layout_12Games.PlaceSearchFound[Placenumber][0]][2];
		String street2 = Layout_12Games.Hall[Layout_12Games.PlaceSearchFound[Placenumber][0]][3];

		String adress1 = Layout_12Games.Hall[Layout_12Games.PlaceSearchFound[Placenumber][0]][4];
		String adress2 = Layout_12Games.Hall[Layout_12Games.PlaceSearchFound[Placenumber][0]][5];

		String place = Layout_12Games.Place[
		                                    Layout_12Games.PlaceSearchFound[Placenumber][0]][
		                                    Layout_12Games.PlaceSearchFound[Placenumber][1]][
		                                    0];
		
		String placeSize = Layout_12Games.Place[
			                                    Layout_12Games.PlaceSearchFound[Placenumber][0]][
			                                    Layout_12Games.PlaceSearchFound[Placenumber][1]][
			                                    1];
		
		Overview_Hall_2.setText(hall);
		Overview_Street_2.setText(street1 + " " + street2);
		Overview_Adress_2.setText(adress2 + " " + adress1);
		Overview_Place_2.setText(place + " / " + placeSize);
		
		Overview_Clock_2.setText(Clock + " Uhr");
		
		DateFormat formatter = new SimpleDateFormat("dd.MM.yyyy");
        String Date = formatter.format(new Date());
        
        Overview_Date_2.setText(Date);

		OpenSide(true);
	}

	public static void OpenSide(boolean Editable) {

		Overview_Cancel.setVisible(Editable);
		Overview_Previous.setVisible(Editable);
		Overview_Next.setVisible(Editable);
		Overview_Accept.setVisible(Editable);
		Overview_FoundInfos.setVisible(Editable);
		
		if ( Editable == true ) {
			
			calculateButton();
		}

		StartLayout.CloseAllSides();

		Paket.User.Side_ID = 1006;
		User.SetNewSide(Paket.User.Side_ID);

		StartLayout.L_Overview.add(StartLayout.Headline);
		StartLayout.Headline.setText("Übersicht");
		
		StartLayout.L_Overview.setVisible(true);
		StartLayout.ReloadFrame();	
	}
	
	public void actionPerformed(ActionEvent e) {
		
		if ( e.getSource() == Overview_Accept ) {
			
			OpenSide(false);
			User.UpdatePlayGames();
		
			User.PlayGame = true;
			SideBar.SideBar_Layout.Menu_Overview.setBackground(new Color(167,210,168));
		}
		
		if ( e.getSource() == Overview_Previous ) {
			
			if ( Layout_12Games.ViewPlaceOverview > 1 ) {

				Layout_12Games.ViewPlaceOverview--;
				Layout_13Overview.setOverviewPlaces(Layout_12Games.ViewPlaceOverview,Layout_12Games.Games_Clock_Tf.getText());
			}
			
			calculateButton();
		}

		if ( e.getSource() == Overview_Next ) {

			if ( Layout_12Games.ViewPlaceOverview < Layout_12Games.MaxPlace ) {

				Layout_12Games.ViewPlaceOverview++;
				Layout_13Overview.setOverviewPlaces(Layout_12Games.ViewPlaceOverview,Layout_12Games.Games_Clock_Tf.getText());
			}
			
			calculateButton();
		}
		
		if ( e.getSource() == Overview_Cancel ) {
			
			User.PlayGame = false;
			SideBar.SideBar_Layout.Menu_Overview.setBackground(new Color(200,200,200));

			Layout_12Games.OpenSide();
		}
		
	}

}