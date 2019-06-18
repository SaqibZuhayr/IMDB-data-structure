package GraphicalUserInterface;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import internetMovieDatabase.Reader;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class MainMenu extends JFrame {

	private JPanel contentPane;
	private ImageIcon back;
	private JLabel background;
	Reader r=new Reader();
	

	public MainMenu() {
		r.reader();
		setVisible(true);
		setBackground(Color.DARK_GRAY);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setExtendedState(MAXIMIZED_BOTH);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(169, 169, 169));

		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("Actor");
		btnNewButton.setForeground(new Color(0, 0, 0));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource()==btnNewButton){
					new ActorMenu();
					dispose();
				}
			}
		});
		btnNewButton.setFont(new Font("Castellar", Font.PLAIN, 16));
		btnNewButton.setBounds(467, 399, 156, 86);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Movie");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource()==btnNewButton_1){
					new MovieMenu();
					dispose();
				}
			}
		});
		btnNewButton_1.setFont(new Font("Castellar", Font.PLAIN, 16));
		btnNewButton_1.setBounds(633, 399, 124, 86);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Director");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource()==btnNewButton_2){
					new DirectorMenu();
					dispose();
				}
			}
		});
		btnNewButton_2.setFont(new Font("Castellar", Font.PLAIN, 16));
		btnNewButton_2.setBounds(767, 399, 156, 86);
		
		contentPane.add(btnNewButton_2);
		
		
		
		
		
		
	}
}
