/**
* A program that searches for movies through various methods
* @author Jacob Robinson
*/
public class MovieSelector {
    
    /**
    * Main method and UI
    * @param args command line arguments
    */
    public static void main(String[] args) {
        System.out.println("");
    }
    
    /**
    * Gets list of movies
    * @param filename file where movies are stored
    * @return file
    */ 
    public static Movie[] getMovieList(String filename){
        return null;
    }
    
    /**
    * Searches by title
    * @param title of movies
    * @param movies array of movies
    * @return string
    */
    public static String searchByTitle(String title, Movie[] movies) {
        return "";
    }
    
    /**
    * Searches by year
    * @param year of release
    * @param movies array of movies
    * @return string
    */
    public static String searchByYear(int year, Movie[] movies) {
        return "";
    }
    
    /**
    * Searches by genre
    * @param genre of movie
    * @param movies array of movies
    * @return string
    */
    public static String searchByGenre(String genre, Movie[] movies) {
        return "";
    }
    
    /**
    * Genres
    */
    public static final String[] GENRES = {"Action", "Adventure", "Animation", "Biography", 
                                           "Comedy", "Crime", "Documentary", "Drama", "Family", 
                                           "Fantasy", "History", "Horror", "Musical",
                                           "Mystery", "Romance", "Sci-Fi", "Sport", "Thriller", 
                                           "War", "Western" };
                                       
}
