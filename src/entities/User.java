package entities;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class User {

	private int id;
	private String nome;
	private int idade;

	public User(int id, String nome, int idade) {
		this.id = id;
		this.nome = nome;
		this.idade = idade;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}

	public void inserirNoBanco() {
		try (Connection connection = Database.getInstance().getConnection();
				PreparedStatement stmt = connection
						.prepareStatement("INSERT INTO pessoas (nome, idade) VALUES (?, ?)")) {

			stmt.setString(1, this.nome);
			stmt.setInt(2, this.idade);

			stmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("Houve um erro ao inserir o usuário no banco de dados!");
			e.printStackTrace();
		}
	}

	@Override
	public String toString() {
		return "Usuario [id=" + id + ", nome=" + nome + ", idade=" + idade + "]";
	}
}
