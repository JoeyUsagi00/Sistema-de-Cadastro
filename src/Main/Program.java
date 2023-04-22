package Main;

import java.sql.SQLException;

import GUI.MyFrame;
import entities.JDBC;

public class Program {
	public static void main(String[] args) throws SQLException {

		MyFrame myFrame = new MyFrame();

		JDBC jdbc = new JDBC();

		jdbc.connect();
		// REGISTRAR OUTRAS OPERAÇÕES COM O BANCO DE DADOS
		registerShutdownHook(jdbc);

		jdbc.printUsers();
		
	}

	  private static void registerShutdownHook(JDBC jdbc) {
	        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
	            try {
					jdbc.disconnect();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	        }));
	    }
	  

}
