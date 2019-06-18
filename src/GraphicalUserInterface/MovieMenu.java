package GraphicalUserInterface;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import internetMovieDatabase.Reader;

import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;

import java.awt.Color;

public class MovieMenu extends JFrame {
	private JTextField txtEnterHere;
	Reader r=new Reader();
	String check="";
	private final ButtonGroup buttonGroup = new ButtonGroup();
	public MovieMenu() {
		setVisible(true);
		setExtendedState(MAXIMIZED_BOTH);
		r.reader();
		getContentPane().setBackground(new Color(169, 169, 169));
		getContentPane().setFont(new Font("Castellar", Font.PLAIN, 12));
		getContentPane().setLayout(null);
	
		txtEnterHere = new JTextField();
		txtEnterHere.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtEnterHere.setBounds(587, 229, 246, 29);
		getContentPane().add(txtEnterHere);
		txtEnterHere.setColumns(20);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(10, 11, 363, 419);
		getContentPane().add(textArea);
		
		JScrollPane scrollPane = new JScrollPane(textArea);
	    scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setVisible(true);
		scrollPane.setBounds(129, 200, 330,400 );
		getContentPane().add(scrollPane);
		
		JButton btnNewButton = new JButton("Search");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource()==btnNewButton){
					
					if(check.equals("title")){
						String txt=r.getMovie().searchByTitle(txtEnterHere.getText());
						textArea.setText(txt);
					}
					else if(check.equals("year")){
						String txt=r.getMovieYear().searchByYear(txtEnterHere.getText());
						textArea.setText(txt);
					}
					else if(check.equals("director")){
						String txt=r.getMovie().searchByDirector(txtEnterHere.getText());
						textArea.setText(txt);
					}
					else if(check.equals("actor")){
						String txt=r.getMovie().searchByActor(txtEnterHere.getText());
						textArea.setText(txt);
					}
					else if(check.equals("rating")){
						String txt=r.getMovieRate().searchByRating(txtEnterHere.getText());
						textArea.setText(txt);
					}
					else if(check.equals("genre")){
						String txt=r.getMovie().searchByGenre(txtEnterHere.getText());
						textArea.setText(txt);
					}
				}
			}
		});
		btnNewButton.setFont(new Font("Castellar", Font.PLAIN, 12));
		btnNewButton.setBounds(864, 230, 116, 28);
		getContentPane().add(btnNewButton);
		
		JLabel lblEnterHere = new JLabel("Enter Here");
		lblEnterHere.setFont(new Font("Castellar", Font.PLAIN, 12));
		lblEnterHere.setBounds(480, 231, 97, 27);
		getContentPane().add(lblEnterHere);
		
		JRadioButton rdbtnBytitle = new JRadioButton("By Title");
		rdbtnBytitle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(arg0.getSource()==rdbtnBytitle){
					check="title";
				}
			}
		});
		buttonGroup.add(rdbtnBytitle);
		rdbtnBytitle.setFont(new Font("Castellar", Font.PLAIN, 11));
		rdbtnBytitle.setBounds(586, 304, 109, 23);
		getContentPane().add(rdbtnBytitle);
		
		JRadioButton rdbtnByYear = new JRadioButton("By Year");
		rdbtnByYear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource()==rdbtnByYear){
					check="year";
				}
			}
		});
		buttonGroup.add(rdbtnByYear);
		rdbtnByYear.setFont(new Font("Castellar", Font.PLAIN, 11));
		rdbtnByYear.setBounds(724, 304, 109, 23);
		getContentPane().add(rdbtnByYear);
		
		JRadioButton rdbtnByActor = new JRadioButton("By Actor");
		rdbtnByActor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource()==rdbtnByActor){
					check="actor";
				}
			}
		});
		buttonGroup.add(rdbtnByActor);
		rdbtnByActor.setFont(new Font("Castellar", Font.PLAIN, 11));
		rdbtnByActor.setBounds(586, 360, 109, 23);
		getContentPane().add(rdbtnByActor);
		
		JRadioButton rdbtnByDirector = new JRadioButton("By Director");
		rdbtnByDirector.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource()==rdbtnByDirector){
					check="director";
				}
			}
		});
		buttonGroup.add(rdbtnByDirector);
		rdbtnByDirector.setFont(new Font("Castellar", Font.PLAIN, 11));
		rdbtnByDirector.setBounds(724, 360, 109, 23);
		getContentPane().add(rdbtnByDirector);
		
		JRadioButton rdbtnByRating = new JRadioButton("By rating");
		rdbtnByRating.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource()==rdbtnByRating){
					check="rating";
				}
			}
		});
		buttonGroup.add(rdbtnByRating);
		rdbtnByRating.setFont(new Font("Castellar", Font.PLAIN, 11));
		rdbtnByRating.setBounds(586, 418, 109, 23);
		getContentPane().add(rdbtnByRating);
		
		JRadioButton rdbtnByGenre = new JRadioButton("By Genre");
		rdbtnByGenre.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource()==rdbtnByGenre){
					check="genre";
				}
			}
		});
		buttonGroup.add(rdbtnByGenre);
		rdbtnByGenre.setFont(new Font("Castellar", Font.PLAIN, 11));
		rdbtnByGenre.setBounds(724, 418, 109, 23);
		getContentPane().add(rdbtnByGenre);
		
		JLabel lblMovieMenu = new JLabel("Movie Menu");
		lblMovieMenu.setFont(new Font("Castellar", Font.PLAIN, 17));
		lblMovieMenu.setBounds(651, 49, 157, 28);
		getContentPane().add(lblMovieMenu);
		
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
		btnBack.setBounds(46, 43, 102, 45);
		getContentPane().add(btnBack);
		
		JLabel lblSearchResults = new JLabel("Search Results :");
		lblSearchResults.setFont(new Font("Castellar", Font.PLAIN, 12));
		lblSearchResults.setBounds(58, 144, 142, 27);
		getContentPane().add(lblSearchResults);
	}
}
