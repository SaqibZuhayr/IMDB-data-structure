package Director;

import Movie.MovieNode;

public class HashDirectorTable {
	DirectorAVLtree[] directors;
	public HashDirectorTable(){
		directors=new DirectorAVLtree[27];
		for(int i=0 ;i<27;i++){
			directors[i]=new DirectorAVLtree();
		}
	}
	public int hashKey(String name){
		char c=name.charAt(0);
		switch(c){
		case 'A': return 1; case 'N': return 14; 
		case 'B': return 2; case 'O': return 15; 
		case 'C': return 3; case 'P': return 16; 
		case 'D': return 4; case 'Q': return 17; 
		case 'E': return 5; case 'R': return 18; 
		case 'F': return 6; case 'S': return 19; 
		case 'G': return 7; case 'T': return 20; 
		case 'H': return 8; case 'U': return 21; 
		case 'I': return 9; case 'V': return 22; 
		case 'J': return 10; case 'W': return 23; 
		case 'K': return 11; case 'X': return 24; 
		case 'L': return 12; case 'Y': return 25; 
		case 'M': return 13; case 'Z': return 26; 
		default : return 0;		}
	}
	public void insertDirectors(DirectorNode director,MovieNode movie){
		directors[hashKey(director.getName())].Director(director,movie);
	}
	public String searchDirectors(String name){
		
		return directors[hashKey(name)].searchDirector(name);
	}
}