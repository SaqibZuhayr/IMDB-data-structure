package Movie;

public class HashMovieRatingTable {
	MovieRatingLinkList[] movies;
	   
	public HashMovieRatingTable() {
		movies = new MovieRatingLinkList[10];
		for (int i = 0; i<movies.length; i++) {
			movies[i] = new MovieRatingLinkList();
		}
	}

	public int hashKey(String rate){
	  double y=Double.parseDouble(rate);
	  int x=(int)y;
	  return x;
  }
	public void insertMovies(MovieNode movie){	
	    movies[hashKey(movie.imdbScore)].addAtfirst(movie);
	}
	
	public String searchByRating(String rating){
		String output="";
		for(int i=hashKey(rating);i<movies.length;i++){
			output+=movies[i].print();
		}
		return output;
	}

}
