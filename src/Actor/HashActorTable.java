package Actor;

import Movie.MovieNode;

public class HashActorTable {
	ActorAVLTree[] actors;

	public HashActorTable() {
		
		actors = new ActorAVLTree[27];
		for (int i = 0; i < 27; i++) {
			actors[i] = new ActorAVLTree();
		}
	}

	public int hashKey(String name) {
		char c = name.charAt(0);
		switch (c) {
		case 'A':
			return 1;
		case 'N':
			return 14;
		case 'B':
			return 2;
		case 'O':
			return 15;
		case 'C':
			return 3;
		case 'P':
			return 16;
		case 'D':
			return 4;
		case 'Q':
			return 17;
		case 'E':
			return 5;
		case 'R':
			return 18;
		case 'F':
			return 6;
		case 'S':
			return 19;
		case 'G':
			return 7;
		case 'T':
			return 20;
		case 'H':
			return 8;
		case 'U':
			return 21;
		case 'I':
			return 9;
		case 'V':
			return 22;
		case 'J':
			return 10;
		case 'W':
			return 23;
		case 'K':
			return 11;
		case 'X':
			return 24;
		case 'L':
			return 12;
		case 'Y':
			return 25;
		case 'M':
			return 13;
		case 'Z':
			return 26;
		default:
			return 0;
		}
	}

	public void insertActors(ActorNode actor, ActorNode coactor1, ActorNode coactor2, MovieNode movie) {
		
		actors[hashKey(actor.name)].Actors(actor, coactor1, coactor2, movie);
	}

	public String searchActors(String name) {

		return actors[hashKey(name)].searchActor(name);
	}

	public String printCoactors(String actor) {
		
		ActorNode node = actors[hashKey(actor)].actors;
		return actors[hashKey(actor)].printCoactors(node, actor);
	}

	public String printCoactorsInMovie(String actor, String movie) {
		
		return actors[hashKey(actor)].searchCoactorsInMovie(actor, movie);
	}
}
