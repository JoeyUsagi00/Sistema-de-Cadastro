package GUI;
import java.awt.Color;
import java.sql.*;
import javax.swing.*;
import javax.swing.table.*;

public class MyWindowDatabase extends JFrame {

	private JTable table;

	
	
	
	
	public MyWindowDatabase() {
	
		ImageIcon image = new ImageIcon("banana (1).png");
		this.setIconImage(image.getImage());
		
		
		this.setResizable(false);
		this.setSize(400,300);
		this.getContentPane().setBackground(new Color(230,90,0));
		this.setTitle("BANCO DE DADOS");
	
		
		// ...
		try {
			// Conexão com o banco de dados
			Connection conn = DriverManager.getConnection("jdbc:sqlite:/C:/Users/jd809/Desktop/Arquivos java/CadastroPessoass/CadastroPessoas/src/entities/res/pessoas.db");

			// Consulta ao banco de dados
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM pessoas");

			// Modelo da tabela
			DefaultTableModel model = new DefaultTableModel();
			model.addColumn("ID");
			model.addColumn("Nome");
			model.addColumn("Idade");

			// Adicionando os dados ao modelo
			while (rs.next()) {
				Object[] row = new Object[3];
				row[0] = rs.getInt("id");
				row[1] = rs.getString("nome");
				row[2] = rs.getInt("idade");
				model.addRow(row);
			}

			// Criando a tabela
			table = new JTable(model);

			// Adicionando a tabela à janela
			JScrollPane scrollPane = new JScrollPane(table);
			this.add(scrollPane);

			// Fechando a conexão com o banco de dados
			rs.close();
			stmt.close();
			conn.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
