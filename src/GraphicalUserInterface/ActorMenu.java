package GraphicalUserInterface;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import internetMovieDatabase.Reader;

import javax.swing.JTextField;
import java.awt.Font;
import java.awt.TextArea;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import java.awt.Color;

public class ActorMenu extends JFrame {
	private JTextField textField;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JTextField textField_1;
	private JTextField textField_2;
	Reader r=new Reader();
	String check="";
	public ActorMenu() {
		getContentPane().setBackground(new Color(169, 169, 169));
		r.reader();
		setVisible(true);
		getContentPane().setFont(new Font("Castellar", Font.PLAIN, 12));
		getContentPane().setLayout(null);
		setExtendedState(MAXIMIZED_BOTH);
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textField.setBounds(647, 136, 162, 29);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(10, 11, 363, 419);
		getContentPane().add(textArea);
		
		JScrollPane scrollPane = new JScrollPane(textArea);
	    scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setVisible(true);
		scrollPane.setBounds(131, 201, 330,400 );
		getContentPane().add(scrollPane);
		
		JButton btnNewButton = new JButton("Search");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(arg0.getSource()==btnNewButton){
					if(check.equals("Movies")){
						String txt=r.getActor().searchActors(textField.getText());
						textArea.setText(txt);
					}
					else if(check.equals("Coactors")){
						String txt=r.getActor().printCoactors(textField.getText());
						textArea.setText(txt);
					}
				}
				
			}
		});
		btnNewButton.setFont(new Font("Castellar", Font.PLAIN, 12));
		btnNewButton.setBounds(841, 136, 113, 30);
		getContentPane().add(btnNewButton);
		
		JLabel lblEnterHere = new JLabel("Enter Here");
		lblEnterHere.setFont(new Font("Castellar", Font.PLAIN, 12));
		lblEnterHere.setBounds(530, 137, 95, 29);
		getContentPane().add(lblEnterHere);
		
		JRadioButton rdbtnCoActors = new JRadioButton("Co Actors");
		rdbtnCoActors.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(arg0.getSource()==rdbtnCoActors){
					check="Coactors";
				}
			}
		});
		buttonGroup.add(rdbtnCoActors);
		rdbtnCoActors.setFont(new Font("Castellar", Font.PLAIN, 12));
		rdbtnCoActors.setBounds(683, 183, 109, 23);
		getContentPane().add(rdbtnCoActors);
		
		JRadioButton rdbtnMovies = new JRadioButton("Movies");
		rdbtnMovies.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(arg0.getSource()==rdbtnMovies){
					check="Movies";
				}
			}
		});
		buttonGroup.add(rdbtnMovies);
		rdbtnMovies.setFont(new Font("Castellar", Font.PLAIN, 12));
		rdbtnMovies.setBounds(683, 221, 109, 23);
		getContentPane().add(rdbtnMovies);
		
		JLabel lblForSearchingCoactor = new JLabel("For Searching Coactors in a specific movie :");
		lblForSearchingCoactor.setFont(new Font("Castellar", Font.PLAIN, 14));
		lblForSearchingCoactor.setBounds(530, 284, 402, 29);
		getContentPane().add(lblForSearchingCoactor);
		
		JLabel lblActorName = new JLabel("Actor Name");
		lblActorName.setFont(new Font("Castellar", Font.PLAIN, 12));
		lblActorName.setBounds(530, 333, 95, 15);
		getContentPane().add(lblActorName);
		
		JLabel lblMovieName = new JLabel("Movie name");
		lblMovieName.setFont(new Font("Castellar", Font.PLAIN, 12));
		lblMovieName.setBounds(530, 388, 95, 15);
		getContentPane().add(lblMovieName);
		
		textField_1 = new JTextField();
		textField_1.setBounds(647, 326, 162, 29);
		getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(647, 381, 162, 29);
		getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		JButton btnNewButton_1 = new JButton("Search");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(arg0.getSource()==btnNewButton_1){
					String txt=r.getActor().printCoactorsInMovie(textField_1.getText(), textField_2.getText());
					textArea.setText(txt);
				}
			}
		});
		btnNewButton_1.setFont(new Font("Castellar", Font.PLAIN, 12));
		btnNewButton_1.setBounds(841, 349, 113, 40);
		getContentPane().add(btnNewButton_1);
		
		JLabel lblActorMenu = new JLabel("Actor Menu");
		lblActorMenu.setFont(new Font("Castellar", Font.PLAIN, 16));
		lblActorMenu.setBounds(669, 56, 168, 29);
		getContentPane().add(lblActorMenu);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource()==btnBack){
					new MainMenu();
					dispose();
				}
			}
		});
		btnBack.setFont(new Font("Castellar", Font.PLAIN, 12));
		btnBack.setBounds(79, 51, 102, 40);
		getContentPane().add(btnBack);
		
		JLabel lblNewLabel = new JLabel("Search Results :");
		lblNewLabel.setFont(new Font("Castellar", Font.PLAIN, 12));
		lblNewLabel.setBounds(55, 142, 152, 29);
		getContentPane().add(lblNewLabel);
		
		
	}
}
