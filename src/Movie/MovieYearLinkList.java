package Movie;

public class MovieYearLinkList {

	MovieListNode start;
	int numberofmovies;

    public MovieYearLinkList(){
    	start=null;
    }

	public boolean isEmpty(){
		
		return start==null;
		}
	
	public void addAtfirst(MovieNode data){
		   MovieListNode newnode = new MovieListNode();
		   newnode.movies=data;
		   
		   if(start==null){
			   start=newnode;
			   newnode.next=start.next;
			   numberofmovies++;
		   }
		   else{
			   newnode.next=start;
			   start=newnode;
			   numberofmovies++;
		   }
	   }
	
	public String print(){
		String output="";
		if(!this.isEmpty()){
			MovieListNode loc=start;
			while(loc!=null){
				output+=loc.movies.printMovie()+"\n";
				loc=loc.next;
			}
		}
		return output;
	}
	
	
}
