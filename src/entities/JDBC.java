package entities;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBC {

	private Connection conn = null;

	public void connect() throws SQLException {
		try {
			// REGISTRA O DRIVER JDBC
			Class.forName("org.sqlite.JDBC");

			// ABRE UMA CONEXÃO COM O BANCO DE DADOS
			conn = DriverManager.getConnection("jdbc:sqlite:/path/to/database.db");

			System.out.println("Conexão bem sucedida com o banco de dados MYSQLITE!");

		} catch (ClassNotFoundException e) {
			// TODO: handle exception
			System.out.println("Erro ao carregar o Driver JDBC");
			e.printStackTrace();
		}catch (SQLException e) {
			// TODO: handle exception
			System.out.println("Erro ao conectar ao banco de dados");
			e.printStackTrace();
		}
		
	}
	
	public void close() {
		try {
			if(conn != null) {
				conn.close();
				System.out.println("Conexão fechada com sucesso!");
				
			}
		}catch (SQLException e) {
			// TODO: handle exception
			System.err.println("Erro ao fechar conexão com o banco de dados");
			e.printStackTrace();
			
		}
	}

}
