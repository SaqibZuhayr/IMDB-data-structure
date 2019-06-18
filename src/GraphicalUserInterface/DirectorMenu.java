package GraphicalUserInterface;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import internetMovieDatabase.Reader;

import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import javax.swing.JScrollBar;
import java.awt.Color;

public class DirectorMenu extends JFrame {
	private JTextField textField;
	Reader r=new Reader();
	public DirectorMenu() {
		r.reader();
		getContentPane().setBackground(new Color(169, 169, 169));
		setVisible(true);
		getContentPane().setFont(new Font("Tahoma", Font.PLAIN, 13));
		getContentPane().setLayout(null);
		setExtendedState(MAXIMIZED_BOTH);
		textField = new JTextField();
		textField.setBounds(597, 253, 209, 31);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(538, 346, 348, 329);
		getContentPane().add(textArea);
		
		JScrollBar scrollBar = new JScrollBar();
		scrollBar.setBounds(869, 346, 17, 329);
		getContentPane().add(scrollBar);
		
		JLabel lblDirectorName = new JLabel("Director Name");
		lblDirectorName.setFont(new Font("Castellar", Font.PLAIN, 12));
		lblDirectorName.setBounds(434, 253, 137, 31);
		getContentPane().add(lblDirectorName);
		
		JButton btnNewButton = new JButton("Search");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource()==btnNewButton){
					String txt=r.getDirector().searchDirectors(textField.getText());
					textArea.setText(txt);
				}
			}
		});
		btnNewButton.setFont(new Font("Castellar", Font.PLAIN, 12));
		btnNewButton.setBounds(838, 251, 115, 34);
		getContentPane().add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("Director Menu");
		lblNewLabel.setFont(new Font("Castellar", Font.PLAIN, 18));
		lblNewLabel.setBounds(623, 76, 209, 31);
		getContentPane().add(lblNewLabel);
		
		JButton btnBack = new JButton("back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource()==btnBack){
					new MainMenu();
					dispose();
				}
			}
		});
		btnBack.setFont(new Font("Castellar", Font.PLAIN, 12));
		btnBack.setBounds(35, 32, 98, 50);
		getContentPane().add(btnBack);
		
		JLabel lblSearchResults = new JLabel("Search Results :");
		lblSearchResults.setFont(new Font("Castellar", Font.PLAIN, 12));
		lblSearchResults.setBounds(538, 321, 137, 22);
		getContentPane().add(lblSearchResults);
	}

	

}
