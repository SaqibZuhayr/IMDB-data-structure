package Actor;

import Movie.MovieNode;

public class ActorNode {

	String name;
	String fblikes;
	ActorMoviesLinkedList movies;
	ActorNode left;
	ActorNode right;
	CoactorLinkedList coactorslist;
	
	public ActorNode(String name, String fbLikes) {
		
		this.name = name;
		this.fblikes = fbLikes;
		movies=new ActorMoviesLinkedList();
		coactorslist=new CoactorLinkedList();
	}
	public ActorNode() {
		// TODO Auto-generated constructor stub
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getFbLikes() {
		return fblikes;
	}
	public void setFbLikes(String fbLikes) {
		this.fblikes = fbLikes;
	}
	public void insertmovies(MovieNode movie) {
		
		movies.insertMovies(movie);
	}
	public void printActor(){
		System.out.print("Name : "+name+" || ");
		System.out.println("FbLikes : "+fblikes);
	}
	public void printCoactors(){
		coactorslist.printCoactors();
	}
	public String printCoactorsInMovie(String actor,String movie){
		String output="";
		ActorMovieNode loc = movies.Start;
		while(loc!=null&&!loc.movies.getTitle().equalsIgnoreCase(movie)){
			loc=loc.next;
		}
		if(loc==null){
			output="Actor is not present in the movie";
		}
		else{
			output="Name : "+actor+"\n"+"Co-Actors in "+movie+" are :\n";
			System.out.println("Co-Actors:");
			for(int i=0;i<3;i++){
				if(!actor.equalsIgnoreCase(loc.movies.getActors()[i].name)){
					output+=loc.movies.getActors()[i].name+"\n";
				}
			}
		}
		return output;
	}
	
	
	
}
