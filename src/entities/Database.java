package entities;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Main.Program;

public class Database {

	private static Database INSTANCE = null;

	private Connection connection = null;

	public static Connection getConnection1() throws SQLException{
		String url = "jdbc:sqlite:src/entities/pessoas.db";
		return DriverManager.getConnection(url);
	}
	
	
	private Database() {

		try {
			connection = DriverManager.getConnection("jdbc:sqlite:/C:/Users/jd809/Desktop/Arquivos java/CadastroPessoass/CadastroPessoas/src/entities/res/pessoas.db");
		} catch (SQLException e) {
			System.out.println("Houve um problema ao criar o arquivo do banco!");
			e.printStackTrace();
		}

	}
	
	
	public static Database getInstance() {
		if(INSTANCE ==  null) {
			INSTANCE = new Database();
		}else {
			return INSTANCE;
		}
		return INSTANCE;
		
	}
	
	
	

	public Connection getConnection() {
		try {
			//VERIFICA SE A TABELA "PESSOAS" JA EXISTE NO BANCO
			PreparedStatement statement = connection.prepareStatement("SELECT name FROM sqlite_master WHERE type='table' AND name='pessoas'");
			ResultSet resultSet = statement.executeQuery();
			
			//SE A TABELA NÃO EXISTE, CRIA UMA TABELA COM AS COLUNAS NECESSÁRIAS
			if(!resultSet.next()) {
				statement = connection.prepareStatement("CREATE TABLE pessoas (id INTEGER PRIMARY KEY AUTOINCREMENT, nome TEXT, idade INTEGER)");
				statement.executeUpdate();
			}
			
		} catch (SQLException e) {
			// TODO: handle exception
			System.out.println("Houve um problema ao criar a tabela pessoas!");
			e.printStackTrace();
		}
		return this.connection;
	}

	public void closeConnection() {
		try {
			this.connection.close();
		} catch (SQLException e) {
			System.out.println("Houve um erro ao fechar a conexão com o banco!");
			e.printStackTrace();
		}
	}
}
