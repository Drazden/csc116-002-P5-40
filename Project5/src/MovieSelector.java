import java.util.*;
import java.io.*;
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
        Movie[] movies = null;
        //Checks if correct number of arguments is used, passes to getmovielist
        if (args.length != 1) {
            System.out.println("Usage: java -cp bin MovieSelector filename");
            System.exit(1);
        }
        try {
            movies = getMovieList(args[0]);  
        }
        catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            System.exit(1);
        }
        Scanner input = new Scanner(System.in);
        boolean running = true;
        while (running) {
            System.out.println("\nMovie Selector - Please enter an option below\n");
            System.out.println("T - Search by title");
            System.out.println("Y - Search by year");
            System.out.println("G - Search by genre");
            System.out.println("Q - Quit the Program");
            System.out.print("\nOption:");            
            String option = input.next();
            if (option.toUpperCase().equals("T")) {
                System.out.print("\nTitle (is/contains): ");
                String title = input.next();
                System.out.println("\n" + searchByTitle(title, movies));
            }
            else if (option.toUpperCase().equals("Y")) {
            }
            else if (option.toUpperCase().equals("G")) {
            }
            else if (option.toUpperCase().equals("Q")) {
                running = false;
            }
            else {
                System.out.println("Invalid Option");
            }
            
        }
        System.out.println("\nGoodbye!");
    }
    
    /**
    * Gets list of movies
    * @param filename file where movies are stored
    * @return movies in an array
    */ 
    public static Movie[] getMovieList(String filename){
        //Creates scanner and counts movies
        Scanner inputScanner = null;
        File inputFile = new File(filename);
        try {
            inputScanner = new Scanner(inputFile);
        }
        catch (FileNotFoundException e) {
            throw new IllegalArgumentException("Unable to access input file: " + filename);
        }
        inputScanner.nextLine();
        int counter = 0;
        while (inputScanner.hasNextLine()) {
            inputScanner.nextLine();
            counter++;
        }
        
        //Adds movies to array
        try {
            inputScanner = new Scanner(inputFile);
        }
        catch (FileNotFoundException e) {
            throw new IllegalArgumentException("Unable to access input file: " + filename);
        }
        inputScanner.nextLine();
        Movie[] movies = new Movie[counter];
        for (int i = 0; i < movies.length; i++) {
            movies[i] = lineSetter(inputScanner.nextLine());
        }
        return movies;
    }
    
    /**
    * Creates a movie object from a line of the input file
    * @param line of input file from for loop
    * @return Movie created from line
    */
    public static Movie lineSetter(String line) {
        Scanner lineScanner = new Scanner(line);
        lineScanner.useDelimiter("\t");
        return new Movie(lineScanner.next(), lineScanner.nextInt(), lineScanner.nextInt(), lineScanner.next());
    }
    
    /**
    * Searches by title
    * @param title of movies
    * @param movies array of movies
    * @return string
    */
    public static String searchByTitle(String title, Movie[] movies) {
        String matches = "";
        for (int i = 0; i < movies.length; i++) {
            if (movies[i].getTitle().toUpperCase().indexOf(title.toUpperCase()) != -1) {
                matches += movies[i].toString() + "\n";
            }
        }
        return matches;
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
