package Actor;

import Movie.MovieNode;

public class ActorMoviesLinkedList {
	ActorMovieNode Start;
	int numberofmovies;
	
	
	public boolean isEmpty(){
	
		return Start==null;
	}

	public void insertMovies(MovieNode movies) {
		
		 ActorMovieNode newnode = new ActorMovieNode();
		 newnode.movies=movies;
		  
		   ActorMovieNode loc=Start;
		   if(isEmpty()){
			   Start=newnode;
			   newnode.next= Start.next;
			   numberofmovies++;
		   }
		   else{
			   while(loc.next!=null){
				   loc=loc.next;
			   }
			   newnode.next=null;
			   loc.next=newnode;
			   
			   numberofmovies++;
		   }
	}
	
	public String print(){
		String output="";
		while(Start!=null){
			output=output+"\n"+Start.movies.getTitle()+"\n"+Start.movies.getYear();
			Start=Start.next;
		}
		return output;
	}

}
