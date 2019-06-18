package Movie;

import Actor.ActorNode;
import Director.DirectorNode;

public class MovieNode {

	boolean color;
	DirectorNode director;
	String numOfCritics;
	String duration;
	private ActorNode actors [];
	String gross;
	String genre;
	private String title;
	String numOfVotedUsers;
	String castTotalFbLikes;
	String faceNumberInPoster;
	String [] plotKeywords;
	String movieLink;
	String numUserForReviews;
	String language;
	String country;
	String contentRating;
	String budget;
	private String year;
	String imdbScore;
	String aspectRatio;
	String movieFbLikes;
	MovieNode left;
	MovieNode right;
	
	
	public MovieNode(boolean color, DirectorNode director, String numOfCritics,
			String duration, ActorNode actors [], String gross, String genre,
			String title, String numOfVotedUsers, String castTotalFbLikes,
			String faceNumberInPoster, String [] plotKeywords, String movieLink,
			String numUserForReviews, String language, String country,
			String contentRating, String budget, String year, String imdbScore,
			String aspectRatio, String movieFbLikes) {
		super();
		this.color = color;
		this.director = director;
		this.numOfCritics = numOfCritics;
		this.duration = duration;
		this.setActors(actors);
		this.gross = gross;
		this.genre = genre;
		this.setTitle(title);
		this.numOfVotedUsers = numOfVotedUsers;
		this.castTotalFbLikes = castTotalFbLikes;
		this.faceNumberInPoster = faceNumberInPoster;
		this.plotKeywords = plotKeywords;
		this.movieLink = movieLink;
		this.numUserForReviews = numUserForReviews;
		this.language = language;
		this.country = country;
		this.contentRating = contentRating;
		this.budget = budget;
		this.setYear(year);
		this.imdbScore = imdbScore;
		this.aspectRatio = aspectRatio;
		this.movieFbLikes = movieFbLikes;
	}


	public MovieNode() {
		// TODO Auto-generated constructor stub
	}
	public String printMovie(){
		String output="";
		output=output+"Title :"+getTitle()+"\n";
	    output+="Director : "+director.getName()+"\n";
	    output+="Actors : \n";
	    output+="    "+getActors()[0].getName()+"\n";
	    output+="    "+getActors()[1].getName()+"\n";
	    output+="    "+getActors()[2].getName()+"\n";
	    output+="IMDb Rating : "+imdbScore+"\n"+"Year : "+getYear()+"\n";
	    output+="Genre : "+genre+"\n";
	    output+="Country : "+country+"\n";
//		for(int i=0;i<plotKeywords.length;i++){
//			System.out.print(plotKeywords[i]+" | ");
//		}
		return output;
	}


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public String getYear() {
		return year;
	}


	public void setYear(String year) {
		this.year = year;
	}


	public ActorNode[] getActors() {
		return actors;
	}


	public void setActors(ActorNode actors[]) {
		this.actors = actors;
	}
	
	
		
	
}
