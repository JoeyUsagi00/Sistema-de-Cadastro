package entities;

import java.beans.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import javax.sql.DataSource;

import org.hibernate.engine.jdbc.connections.internal.DriverManagerConnectionCreator;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

public class JDBC {
	
	
		
	
	
	

	private static Connection conn;

	// CONECTAR O BANCO DE DADOS AO PROGRAMA
	public static Connection connect() throws SQLException {
		try {
			// DEFINE O CAMINHO DO BANCO DE DADOS SQLite
			String url = "jdbc:sqlite:cadastro.db";

			// CONECTA COM O BANCO DE DADOS
			conn = DriverManager.getConnection(url);

			System.out.println("Conexão bem sucedida com o banco de dados MYSQLITE!");

		} catch (SQLException e) {
			// TODO: handle exception
			System.out.println("Erro ao conectar ao banco de dados");
			e.printStackTrace();
		}
		return conn;

	}

	// DESCONECTAR O BANCO DE DADOS AO PROGRAMA
	public static void disconnect() throws SQLException {
		conn.close();
		System.out.println("Conexão fechada!");

	}

	public void createTable() throws SQLException {
		// CRIA UMA DECLARAÇÃO SQL PARA CRIAR UMA TABELA
		String sql = "CREATE TABLE IF NOT EXIST pessoas(" + "id INTEGER PRIMARY KEY AUTOINCREMENT,"
				+ "nome TEXT NOT NULL," + "idade INTEGER NOT NULL" + ")";

		// CRIA UM OBJETO STATEMENT
		java.sql.Statement statement = conn.createStatement();

		// EXECUTA A DECLARAÇÃO SQL
		statement.execute(sql);

		System.out.println("Tabela criada com sucesso");
	}

	public void insert(String nome, int idade) throws SQLException {
		// CRIA UMA DECLARAÇÃO SQL PARA INSERIR UM REGISTRO NA TABELA
		String sql = "INSERT INTO pessoas (nome, idade) VALUES (?, ?)";

		// CRIA UM OBJETO PREPAREDSTATEMENT
		PreparedStatement statement = conn.prepareStatement(sql);

		// DEFINE OS PARAMENTROS DO COMANDO SQL
		statement.setString(1, nome);
		statement.setInt(2, idade);

		// EXECUTA O COMANDO SQL
		statement.executeUpdate();

		System.out.println("Registro inserido com sucesso");
	}

	public  void printUsers() {
		try {
				Connection conn = JDBC.connect();
				Statement stmt = (Statement) conn.createStatement();
				ResultSet rs = ((java.sql.Statement) stmt).executeQuery("Select * FROM users");
				while(rs.next()) {
					String nome = rs.getString("nome");
					String email = rs.getString("email");
					System.out.println("Nome: " + nome + ", Email" + email);
				}
				rs.close();
				((Connection) stmt).close();
				JDBC.disconnect();
		} catch (SQLException e) {
			// TODO: handle exception
			System.err.println("Error retrieving users  from database: " + e.getMessage());
			 
		}
	}
	
	
}
