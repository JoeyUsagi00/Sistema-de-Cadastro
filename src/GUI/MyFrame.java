package GUI;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;

public class MyFrame extends JFrame implements ActionListener {

	
	JFrame frame;
	JButton MyButton = new JButton("Clique aqui para rodar o programa!");

	public MyFrame() {

		// BOTAO
		
		
		// JButton MyButton = new JButton("Nova Janela");
		MyButton.setBounds(40, 200, 400, 50);
		
		MyButton.addActionListener(this);

		// JANELA

		this.setTitle("Meu Programa");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		this.setSize(500, 500);
		this.setResizable(false);
		this.setLayout(null);
		this.add(MyButton);
		
		ImageIcon image = new ImageIcon("32(10).png");
		this.setIconImage(image.getImage());

		this.getContentPane().setBackground(new Color(255, 0, 110));

	}

	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == MyButton) {
			NewWindow myWindow = new NewWindow();
		}
		

	}
}
