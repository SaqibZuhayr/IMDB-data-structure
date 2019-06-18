package Director;

import Movie.MovieNode;

public class DirectorMovieLinkedList {

	DirectorMovieNode directorMovies;
	int numberofmovies;



	public boolean isEmpty(){
		
		return directorMovies==null;
		}
	
	public void insertMovies(MovieNode movies){
		
		 DirectorMovieNode newnode = new DirectorMovieNode();
		 newnode.movies=movies;
		  
		  DirectorMovieNode loc=directorMovies;
		   if(isEmpty()){
			   directorMovies=newnode;
			   newnode.next= directorMovies.next;
			   numberofmovies++;
		   }
		   else{
			   while(loc.next!=null){
				   loc=loc.next;
			   }
			   newnode.next=null;
			   loc.next=newnode;
			   ;
			   numberofmovies++;
		   }
	}
	
	public String print(){
		String output="";
		while(directorMovies!=null){
			output+=directorMovies.movies.getTitle()+" \n ";
			output+=directorMovies.movies.getYear()+" \n ";
			directorMovies=directorMovies.next;
		}
		return output;
	}
	
	
}
