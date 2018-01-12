package Sides;

import Paket.StartLayout;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

import javax.swing.*;
import Paket.User;

public class Layout_12Games implements ActionListener {
	
	private JLabel Games_Teamsize = new JLabel();
	private JLabel Games_Clock = new JLabel();
	private JLabel Games_Clock_2 = new JLabel();
	private JLabel Games_Distance = new JLabel();

	private JButton Games_Teamsize01_But = new JButton();
	private JButton Games_Teamsize02_But = new JButton();
	private JButton Games_Teamsize03_But = new JButton();

	static JTextField Games_Clock_Tf = new JTextField();
	static JTextField Games_Distance_Tf = new JTextField();

	private JLabel Games_Clock_Struct = new JLabel();
	
	private JButton Games_Search = new JButton();
	
	static String[][] Hall = null;
	// [Hall][Information]
	
	static String[][][] Place = null;
	// [Hall][Place Number][Information]

	static int[][] PlaceSearchFound = null;
	// [Number][Information]
	
	static int Size_index = 1;
	static int Hall_Numbers = 1;
	static int ViewPlaceOverview = 1;
	static int MaxPlace = 0;
	
	public Layout_12Games() {
		
		// Labels
	
		Font Font_label = new Font("Arial", Font.BOLD, 20);
		
		Games_Teamsize.setText("Mannschaftsgröße:");
		Games_Teamsize.setBounds(30,90,350,50);
		Games_Teamsize.setFont(Font_label);

		Games_Clock.setText("Uhrzeit:");
		Games_Clock.setBounds(30,140,300,50);
		Games_Clock.setFont(Font_label);

		Games_Clock_2.setText("Uhr");
		Games_Clock_2.setBounds(530,140,100,50);
		Games_Clock_2.setFont(Font_label);

		Games_Distance.setText("Im Umkreis (in km):");
		Games_Distance.setBounds(30,190,350,50);
		Games_Distance.setFont(Font_label);
		
		Games_Clock_Struct.setText("(z.B. 15:00)");
		Games_Clock_Struct.setForeground(new Color(120,120,120));
		Games_Clock_Struct.setBounds(575,140,350,50);
		Games_Clock_Struct.setFont(Font_label);
		
		// TextFields
		
		Font Font_textfield = new Font("Arial", Font.BOLD, 18);

		Games_Clock_Tf.setBounds(240,145,280,40);
		Games_Clock_Tf.setFont(Font_textfield);

		Games_Distance_Tf.setBounds(240,195,280,40);
		Games_Distance_Tf.setFont(Font_textfield);

		// Buttons
		
		Font Font_button = new Font("Arial", Font.BOLD, 18);

		Games_Teamsize01_But.setText("3 vs 3");
		Games_Teamsize01_But.addActionListener(this);
		Games_Teamsize01_But.setBackground(new Color(175,196,216));
		Games_Teamsize01_But.setBounds(240,95,110,40);
		Games_Teamsize01_But.setFont(Font_button);

		Games_Teamsize02_But.setText("4 vs 4");
		Games_Teamsize02_But.addActionListener(this);
		Games_Teamsize02_But.setBackground(new Color(167,210,168));
		Games_Teamsize02_But.setBounds(380,95,110,40);
		Games_Teamsize02_But.setFont(Font_button);

		Games_Teamsize03_But.setText("5 vs 5");
		Games_Teamsize03_But.addActionListener(this);
		Games_Teamsize03_But.setBackground(new Color(167,210,168));
		Games_Teamsize03_But.setBounds(520,95,110,40);
		Games_Teamsize03_But.setFont(Font_button);

		Games_Search.setText("Suchen");
		Games_Search.addActionListener(this);
		Games_Search.setBackground(new Color(167,210,168));
		Games_Search.setBounds(30,255,110,40);
		Games_Search.setFont(Font_button);
		
		// Layout

		StartLayout.L_Games.add(Games_Teamsize);
		StartLayout.L_Games.add(Games_Clock);
		StartLayout.L_Games.add(Games_Clock_2);
		StartLayout.L_Games.add(Games_Distance);

		StartLayout.L_Games.add(Games_Teamsize01_But);
		StartLayout.L_Games.add(Games_Teamsize02_But);
		StartLayout.L_Games.add(Games_Teamsize03_But);
		StartLayout.L_Games.add(Games_Clock_Tf);
		StartLayout.L_Games.add(Games_Clock_Struct);
		StartLayout.L_Games.add(Games_Distance_Tf);

		StartLayout.L_Games.add(Games_Search);
	
	}

	public static void OpenSide() {
		
		StartLayout.CloseAllSides();

		Paket.User.Side_ID = 1005;
		User.SetNewSide(Paket.User.Side_ID);

		StartLayout.L_Games.add(StartLayout.Headline);
		StartLayout.Headline.setText("Spiele");
		
		StartLayout.L_Games.setVisible(true);
		StartLayout.ReloadFrame();
	}
	
	void LoadPlaces() {
		
		String[] s = null;
		
		s = StartLayout.getFiles("Places", s, 0);
		System.out.println("Length: " + s.length);
		
		for(int i=2; i<s.length; i++) { 
			
			StartLayout.DownloadFile("Places/" + s[i], "Places/" + s[i]); 
		}	

		Hall = new String[s.length-2][100];		
		Place = new String[s.length-2][100][2];

		File f = new File("Places");		
		File[] fileArray = f.listFiles();
						
		for (int i=0; i < fileArray.length; i++) {
            
			Hall[i][0] = fileArray[i].getName();
       		
			try {
							
				FileReader fr = new FileReader("Places/" + Hall[i][0]);
				BufferedReader br = new BufferedReader(fr);
			
				String l = br.readLine();
				int line = 1;

				while(l != null) {

					Hall[i][line] = l;
					l = br.readLine();							
					line++;
				}
				
				br.close();
				fr.close();
				
			} catch (Exception e) { System.out.println("Error"); }
		}
		
		int count = 0;
		int place = 1;
		
		Hall_Numbers = s.length-2;
		
		for(int hall=0; hall<s.length-2; hall++) {
			
			for(int i=0; i<99; i++) {
			
				if ( Hall[hall][count] != null ) {
					if ( Hall[hall][count].equals("Place") ) {

						Place[hall][place][0] = Hall[hall][count+1];
						Place[hall][place][1] = Hall[hall][count+2];
						System.out.println("Place: " + Place[hall][place][0] + ", " + Place[hall][place][1]);
						place++;
					}

					count++;
					System.out.println("hall: " + hall);
					System.out.println("count: " + count);
				}
			}
			
			count = 0;
			place = 1;
		}
		
		SearchPlaces();
	}
	
	void SearchPlaces() {
		
		int Placesize = Size_index;
		PlaceSearchFound = new int[99][3];
		int placefound = 0;		
		
		int count = 1;
		String s = "";
			
		for(int hall=0; hall<Hall_Numbers; hall++) {
				
			count = 1;
			
			s = Place[hall][count][1];
				
			while(s != null) {
				
				if ( Placesize == 1 && s.equals("S") ) {
					
					PlaceSearchFound[placefound][0] = hall;
					PlaceSearchFound[placefound][1] = count;
					placefound++;
				} else 
					
				if ( Placesize == 2 && s.equals("M") ) {
						
					PlaceSearchFound[placefound][0] = hall;
					PlaceSearchFound[placefound][1] = count;
					placefound++;
				} else 
					
				if ( Placesize == 3 && s.equals("L") ) {
							
					PlaceSearchFound[placefound][0] = hall;
					PlaceSearchFound[placefound][1] = count;
					placefound++;
				}
				count++;
				s = Place[hall][count][1];
			}
		}
		
		System.out.println("placefound: " + placefound);
		
		MaxPlace = placefound;
		ViewPlaceOverview = 1;
		Layout_13Overview.setOverviewPlaces(ViewPlaceOverview,Games_Clock_Tf.getText());
	}
	
	void resetColor() {
		
		Games_Teamsize01_But.setBackground(new Color(167,210,168));
		Games_Teamsize02_But.setBackground(new Color(167,210,168));
		Games_Teamsize03_But.setBackground(new Color(167,210,168));
	}

	public void actionPerformed(ActionEvent e) {
		
		if ( e.getSource() == Games_Teamsize01_But ) {
			
			resetColor();
			Size_index = 1;
			Games_Teamsize01_But.setBackground(new Color(175,196,216));
		}
		
		if ( e.getSource() == Games_Teamsize02_But ) {
			
			resetColor();
			Size_index = 2;
			Games_Teamsize02_But.setBackground(new Color(175,196,216));
		}
		
		if ( e.getSource() == Games_Teamsize03_But ) {
			
			resetColor();
			Size_index = 3;
			Games_Teamsize03_But.setBackground(new Color(175,196,216));
		}
		
		if ( e.getSource() == Games_Search ) {
			
			Games_Clock_Tf.setBackground(new Color(255,255,255));
			Games_Distance_Tf.setBackground(new Color(255,255,255));
			
			boolean Check = true;
								
			if ( Games_Clock_Tf.getText().equals("") ) { 
				
				Check = false;
				Games_Clock_Tf.setBackground(new Color(200,0,10));
			}
			
			if ( Games_Distance_Tf.getText().equals("") ) { 
				
				Check = false; 
				Games_Distance_Tf.setBackground(new Color(200,0,10));
			}
			
			String s = Games_Clock_Tf.getText();
			
			// Check .
			if ( !s.substring(2, s.length()-2).equals(":") ) { 
				
				Check = false;
				Games_Clock_Tf.setBackground(new Color(200,0,10));
			}

			// Check first number
			try { Integer.parseInt(s.substring(0, s.length()-3)); } catch (Exception e1) { 
				
				Check = false;
				Games_Clock_Tf.setBackground(new Color(200,0,10));
			}
			
			// Check second number
			try { Integer.parseInt(s.substring(3)); } catch (Exception e1) { 
				
				Check = false;
				Games_Clock_Tf.setBackground(new Color(200,0,10));
			}
			
			// Check Distance
			try { Integer.parseInt(Games_Distance_Tf.getText()); } catch (Exception e1) { 
				
				Check = false;
				Games_Distance_Tf.setBackground(new Color(200,0,10));
			}

			
			if ( Check == true ) {
					
				LoadPlaces();				
			} 
		}
	}

}
