import java.util.*;
import java.io.*;
/**
* A program that searches for movies in a text file using movie class
* @author Jacob Robinson
*/
public class MovieSelector {
    /** Minimum year for movies **/
    public static final int YEARMIN = 1889;
    /** Maximum year for movies **/
    public static final int YEARMAX = 2021;
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
            System.out.println("\nMovie Selector - Please enter an option below.\n");
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
                System.out.print("\nYear (1890-2020): ");
                if (input.hasNextInt()) {
                    int year = input.nextInt();
                    if (year > YEARMIN && year < YEARMAX) {
                        System.out.println("\n" + searchByYear(year, movies));
                    } else {
                        System.out.println("Invalid year");
                    }
                } else {
                    input.next();
                    System.out.println("Invalid year");
                } 
            }
            else if (option.toUpperCase().equals("G")) {
                System.out.println("\nGenre Choices: Action, Adventure, Animation, "
                                    + "Biography, Comedy, Crime, Documentary, Drama, Family,");
                System.out.println("Fantasy, History, Horror, Musical, Mystery, "
                                    + "Romance, Sci-Fi, Sport, Thriller, War, Western");
                System.out.print("\nGenre: ");
                String genre = input.next();
                boolean valid = false;
                for (int i = 0; i < GENRES.length; i++) {
                    if (genre.toUpperCase().equals(GENRES[i].toUpperCase())) {
                        valid = true;
                    }
                }
                if (valid) {
                    System.out.println("\n" + searchByGenre(genre, movies));
                } else {
                    System.out.println("Invalid genre\n");
                }
                
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
    * Gets list of movies from input file
    * @param filename file where movies are stored
    * @return movies in an array
    */ 
    public static Movie[] getMovieList(String filename){
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
        return new Movie(lineScanner.next(), lineScanner.nextInt(), 
            lineScanner.nextInt(), lineScanner.next());
    }
    
    /**
    * Searches by title
    * @param title of movies
    * @param movies array of movies
    * @return string with movies with matching title
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
    * @return string with movies with matching year
    */
    public static String searchByYear(int year, Movie[] movies) {
        String matches = "";
        if (year < 0) {
            throw new IllegalArgumentException("Invalid year");
        }
        for (int i = 0; i < movies.length; i++) {
            if (movies[i].getYear() == year) {
                matches += movies[i].toString() + "\n";
            }
        }
        return matches;
    }
    
    /**
    * Searches by genre
    * @param genre of movie
    * @param movies array of movies
    * @return string with movies with matching genre
    */
    public static String searchByGenre(String genre, Movie[] movies) {
        String matches = "";
        for (int i = 0; i < movies.length; i++) {
            if (movies[i].getGenre().toUpperCase().indexOf(genre.toUpperCase()) != -1) {
                matches += movies[i].toString() + "\n";
            }
        }
        return matches;
    }
    
    /**
    * string array of possible genres
    */
    public static final String[] GENRES = {"Action", "Adventure", "Animation", "Biography", 
                                           "Comedy", "Crime", "Documentary", "Drama", "Family", 
                                           "Fantasy", "History", "Horror", "Musical",
                                           "Mystery", "Romance", "Sci-Fi", "Sport", "Thriller", 
                                           "War", "Western" };
                                       
}
