package Main;

import java.sql.SQLException;

import GUI.MyFrame;
import entities.JDBC;

public class Program {
	public static void main(String[] args) throws SQLException {

		 MyFrame myFrame = new MyFrame();
		
		 JDBC jdbc = new JDBC();
		
		 jdbc.connect();
		 
		 
		
	}
}
