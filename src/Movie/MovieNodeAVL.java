package Movie;

public class MovieNodeAVL {

	MovieNode movies;

	public MovieNodeAVL() {
		super();
		this.movies = null;
	}

	public boolean isEmpty() {

		return movies == null;
	}

	public void insert(MovieNode data) {
		movies = insert(movies, data);
	}

	private MovieNode insert(MovieNode movies, MovieNode data) {
		if (movies == null) {
			movies = data;
		} else {
			if (data.getTitle().compareTo(movies.getTitle()) < 0)
				movies.left = insert(movies.left, data);
			else {
				movies.right = insert(movies.right, data);
			}
		}

		int balance = height(movies.left) - height(movies.right);

		if (balance > 1 && data.getTitle().compareTo(movies.getTitle()) < 0)
			return rightRotate(movies);

		if (balance < -1 && data.getTitle().compareTo(movies.getTitle()) > 0)
			return leftRotate(movies);

		if (balance > 1 && data.getTitle().compareTo(movies.getTitle()) > 0) {
			movies.left = leftRotate(movies.left);
			return rightRotate(movies);
		}

		if (balance < -1 && data.getTitle().compareTo(movies.getTitle()) < 0) {
			movies.right = rightRotate(movies.right);
			return leftRotate(movies);
		}
		return movies;

	}

	public int height(MovieNode movies) {
		if (movies == null) {
			return 0;
		}
		int left = height(movies.left);
		int right = height(movies.right);
		if (left > right) {
			return left + 1;
		} else {
			return right + 1;
		}

	}

	public MovieNode rightRotate(MovieNode x) {
		MovieNode y = x.left;

		x.left = y.right;
		y.right = x;

		return y;
	}

	public MovieNode leftRotate(MovieNode x) {
		MovieNode y = x.right;

		x.right = y.left;
		y.left = x;

		return y;
	}

	public void print(MovieNode movies) {
		if (movies == null) {
			return;
		}
		movies.printMovie();
		System.out.println();

		print(movies.left);
		print(movies.right);
	}

	public String searchByTitle(String t) {
		String output = "";
		if (movies == null) {
			output = "No Movie is present";
		} else {
			MovieNode loc = movies;

			while (loc != null && !loc.getTitle().equalsIgnoreCase(t)) {

				if (loc.getTitle().compareTo(t) >= 0) {
					loc = loc.left;
				} else {
					loc = loc.right;
				}
			}
			if (loc == null) {
				output = "Movie is not present";
			} else {
				output = loc.printMovie();

			}
		}
		return output;
	}
    String outputG="";
	public String searchByGenre(MovieNode movies, String t) {
		if (movies == null) {
			return "";
		} else {
			if (movies.genre.contains(t)) {
				outputG+=movies.printMovie();
				System.out.println();
			}
			searchByGenre(movies.left, t);
			searchByGenre(movies.right, t);

		}
		return outputG;
	}

	String outputD = "";

	public String searchByDirector(MovieNode movies, String t) {
		if (movies == null) {
			return "";
		} else {
			if (movies.director.getName().equalsIgnoreCase(t)) {
				outputD += movies.printMovie();
			}
			searchByDirector(movies.left, t);
			searchByDirector(movies.right, t);
		}
		return outputD;
	}

	String outputA = "";

	public String searchByActor(MovieNode movies, String t) {
		if (movies == null) {
			return "";
		} else {
			if (movies.getActors()[0].getName().equalsIgnoreCase(t)
					|| movies.getActors()[1].getName().equalsIgnoreCase(t)
					|| movies.getActors()[2].getName().equalsIgnoreCase(t)) {
				outputA += movies.printMovie();
			}
			searchByActor(movies.left, t);
			searchByActor(movies.right, t);
		}
		return outputA;
	}

}
