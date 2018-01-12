package Extern;

import java.io.File;
import java.io.FileWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import Paket.StartLayout;
import Paket.User;
import Sides.Layout_02Register;

public class SafeUser {
	
	public static void SafeUserFromRegister(String Name, int ID) {

		DateFormat formatter = new SimpleDateFormat("dd.MM.yyyy");
        String data = formatter.format(new Date());
        
		@SuppressWarnings("deprecation")
		String pw = Layout_02Register.Register_Password_Tf.getText();
		
		try {
						
			FileWriter fw = new FileWriter("Users/" + Name + ".usr");
			
			fw.write(pw + "\n");

			fw.write(ID + "\n");
			
			fw.write(Layout_02Register.Register_Secondname_Tf.getText() + "\n");
			fw.write(Layout_02Register.Register_Firstname_Tf.getText() + "\n");

			fw.write(Layout_02Register.Register_Place_Tf.getText() + "\n");
			fw.write(Layout_02Register.Register_Town_Tf.getText() + "\n");

			fw.write(data + "\n");
			fw.write("0" + "\n");
			
			fw.close();
			
		} catch (Exception e) { System.out.println("Error"); }
		
		// Upload
		String file = "Users/" + Name + ".usr";
		String picture = "Users/" + Name + ".png";
		
		StartLayout.UploadFile(file, file);
	
		// Delete
		File f1 = new File(file); 
		f1.delete();
		
		File f2 = new File(picture); 
		f2.delete();
	}
	
	public static void SafeUserFromEdit() {
		
		try {
			
			FileWriter fw = new FileWriter("Users/" + User.User_Data[2] + ".usr");
						
			fw.write(User.User_Data[0] + "\n");

			fw.write(User.User_Data[1] + "\n");
			fw.write(User.User_Data[2] + "\n");
			fw.write(User.User_Data[3] + "\n");
			fw.write(User.User_Data[4] + "\n");
			fw.write(User.User_Data[5] + "\n");
			fw.write(User.User_Data[6] + "\n");
			fw.write(User.User_Data[7] + "\n");
			
			fw.close();
			
			System.out.println("Safe User");
			
		} catch (Exception e) { System.out.println("Error"); }
	}

}
