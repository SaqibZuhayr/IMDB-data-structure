package internetMovieDatabase;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import Actor.ActorNode;
import Actor.HashActorTable;
import Director.DirectorNode;
import Director.HashDirectorTable;
import Movie.HashMovieRatingTable;
import Movie.HashMovieTable;
import Movie.HashMovieYearTable;
import Movie.MovieNode;

public class Reader {
	

	HashDirectorTable director = new HashDirectorTable();
	HashMovieTable movie = new HashMovieTable();
	HashActorTable actor = new HashActorTable();
	HashMovieYearTable year = new HashMovieYearTable();
	HashMovieRatingTable rating = new HashMovieRatingTable();
    public Reader(){	
	}
	public HashDirectorTable getDirector() {
		return director;
	}

	public HashActorTable getActor() {
		return actor;
	}

	public HashMovieTable getMovie() {
		return movie;
	}

	public HashMovieYearTable getMovieYear() {
		return year;
	}

	public HashMovieRatingTable getMovieRate() {
		return rating;
	}

	public void reader() {

		String csvFile = "C:\\Users\\Noman Waris\\Downloads\\IMDB.csv";
		BufferedReader br = null;
		String line = "";
		String cvsSplitBy = ",";
		String[] abc = null;

		try {

			br = new BufferedReader(new FileReader(csvFile));
		
			while ((line = br.readLine()) != null) {

				// use comma as separator
				abc = line.split(cvsSplitBy);
		
				ActorNode[] actors = new ActorNode[3];
				String[] plotkeyword= new String[5];
				String out="";
				try {
					int index=0;
					for(int i=0;i<abc[16].length();i++){
						if(!(abc[16].charAt(i)=='|')){
							out+=abc[16].charAt(i);
						}
						else{
							plotkeyword[index++]=out;
							out="";
						}
					}
					plotkeyword[index]=out;

				} catch (Exception e) {
					// TODO Auto-generated catch block
					
				}



				DirectorNode d1 = new DirectorNode(abc[1], abc[4]);

				actors[0] = new ActorNode(abc[10], abc[7]);
				actors[1] = new ActorNode(abc[6], abc[24]);
				actors[2] = new ActorNode(abc[14], abc[5]);

				MovieNode m = new MovieNode(true, d1, abc[2], abc[3], actors, abc[8], abc[9], abc[11], abc[12], abc[13],
						abc[15],plotkeyword, abc[17], abc[18], abc[19], abc[20], abc[21], abc[22], abc[23], abc[25],
						abc[26], abc[27]);

				director.insertDirectors(d1, m);

				actor.insertActors(actors[0], actors[1], actors[2], m);
				actor.insertActors(actors[1], actors[0], actors[2], m);
				actor.insertActors(actors[2], actors[0], actors[1], m);

				movie.insertMovies(m);
				year.insertMovies(m);
				rating.insertMovies(m);

			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		
	}
	
}

