package GUI;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.Scanner;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.websocket.Decoder.Text;

import org.apache.catalina.valves.rewrite.InternalRewriteMap.UpperCase;

import entities.JDBC;

public class NewWindow extends JFrame implements ActionListener {
	Scanner sc = new Scanner(System.in);
	
	 JDBC jdbc = new JDBC();
		
	 
	
	
	JFrame frame = new JFrame();
	JButton button = new JButton("CADASTRAR USUÁRIO");
	JButton button2 = new  JButton ("Abrir informações do banco de dados");
	JLabel label = new JLabel("Hello");

	NewWindow() {

		label.setBounds(100, 300, 300, 50);
		label.setFont(new Font(null, Font.PLAIN, 25));
		label.setForeground(Color.BLACK);
		label.setVisible(true);

		frame.add(label);
		frame.setTitle("Nome do PROGRAMA");
		frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
		frame.setVisible(true);
		frame.setSize(350, 500);
		frame.setLayout(null);
		frame.setResizable(false);

		ImageIcon image = new ImageIcon("estrela.png");
		frame.setIconImage(image.getImage());

		frame.getContentPane().setBackground(new Color(50, 153, 200));

		// BOTAO 1

		button.setBounds(40, 50, 250, 50); // X / Y / Largura / Altura
		button.addActionListener(this);
		frame.add(button);

		// BOTAO 2
		button2.setBounds(40, 200, 250, 50);
		button2.addActionListener(this);
		frame.add(button2);

	}

	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

		if (e.getSource() == button2) {
			//JOptionPane.showMessageDialog(frame, "OI", "Janela", JOptionPane.PLAIN_MESSAGE);
			MyWindowDatabase MDB = new MyWindowDatabase();
			
			
		}

		if (e.getSource() == button) {
		//	NewWindow myWindow = new NewWindow();
			
			String nome = JOptionPane.showInputDialog("Digite o nome:");
			String idade = JOptionPane.showInputDialog("Digite a Idade");
			JOptionPane.showMessageDialog(null,"Usuário Cadastrado: " + nome + "\n "+ "idade: " + idade);
			frame.setVisible(false);
			
			try {
				jdbc.connect();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
		}

	}
}
