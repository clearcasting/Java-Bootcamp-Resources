public class Store {

    private Movie[] movies;

    public Store() {
        // TODO
        movies = new Movie[10];
    }

    public Movie getMovie(int index) {
        // TODO
        return new Movie(movies[index]);
    }

    public void setMovie(int index, Movie movie) {
        // TODO
        movies[index] = movie;
    }


    public String toString() {
        String temp = "";
        for (Movie movie : movies) {
            temp += movie.toString() + "\n";
        }
        return temp;
    }

}
