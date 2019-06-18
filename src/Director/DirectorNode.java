package Director;

import Movie.MovieNode;

public class DirectorNode {
 
	private String name;
	String fbLikes;
	DirectorNode left;
	DirectorNode right;
	DirectorMovieLinkedList Directormovies;

	public DirectorNode(String name, String fbLikes) {
		super();
		this.setName(name);
		this.fbLikes = fbLikes;
		Directormovies=new DirectorMovieLinkedList();
		
		
	}
	
	public DirectorNode() {
		// TODO Auto-generated constructor stub
	}

	public void insertMovies(MovieNode a){
		
		Directormovies.insertMovies(a);
	
	}
	
	public String print(){
		String output="";
		output+="Name : "+getName()+"\n";
		output+="Fblikes : "+fbLikes+"\n";
		output+=" Filmography : \n\n";
		output+=Directormovies.print();
		return output;
		
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	

	
	
	
		
}

