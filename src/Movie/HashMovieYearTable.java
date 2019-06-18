package Movie;

public class HashMovieYearTable {
	MovieYearLinkList[] movies;
   
	public HashMovieYearTable() {
		movies = new MovieYearLinkList[92];
		for (int i = 0; i<movies.length; i++) {
			movies[i] = new MovieYearLinkList();
		}
	}

	public int hashKey(String year){
		double y= Double.parseDouble(year);
		int x=(int)y;
	  try {
		if(x<=1931){
			  switch(x){
			  case 1916: return 1;
			  case 1920: return 2;
			  case 1925: return 3;
			  case 1926: return 4;
			  case 1927: return 5;
			  case 1930: return 6;
			  default : return 0;
			  }
		}
		  else{
			  return (x-1916)-9;		
			  }
	} catch (Exception e) {
		// TODO Auto-generated catch block
		return 0;
	}
  }
	
	public void insertMovies(MovieNode movie){
		
	    movies[hashKey(movie.getYear())].addAtfirst(movie);
	}
	
	public String searchByYear(String year){
		return movies[hashKey(year)].print();
	}
}