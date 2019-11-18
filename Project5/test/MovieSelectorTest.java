import java.util.Arrays;

import org.junit.Test;

import junit.framework.TestCase;

/**
 * Program to test MovieSelector methods
 * @author Suzanne Balik
 * @author Jacob Robinson
 */
public class MovieSelectorTest extends TestCase {

    /** Sleeping Beauty Movie Information */
    public static final Movie SLEEPING_BEAUTY = new Movie("Sleeping Beauty", 1959, 75, 
                                                          "Animation,Family,Fantasy" );
    
    /** Snow White Movie Information */
    public static final Movie SNOW_WHITE = new Movie("Snow White and the Seven Dwarfs", 1937, 83,
                                                     "Animation,Family,Fantasy");    
    /** Pinocchio Movie Information */
    public static final Movie PINOCCHIO = new Movie("The Adventures of Pinocchio", 1936, 60,
                                                        "Animation,Fantasy");
    
    /** Disney movie array */
    public static final Movie[] THREE_MOVIES = { SLEEPING_BEAUTY, SNOW_WHITE, PINOCCHIO };
    
    /** Edge of tomorrow info **/
    public static final Movie EDGE = new Movie("Edge of Tomorrow", 2014, 113, "Action,Sci-Fi");
    
    /** Spiderverse info **/
    public static final Movie SPIDER = new Movie("Spider-Man: Into the Spider-Verse", 2018, 117,
                                                        "Animation,Action,Adventure");
    
    /** Your name info **/
    public static final Movie NAME = new Movie("Your Name.", 2016, 106, "Animation,Drama,Fantasy");
    
    /** Jacobs movies array */
    public static final Movie[] MY_MOVIES = { EDGE, SPIDER, NAME };
    
    @Test
    public void testGetMovieList1() {
        String filename = "test-files/three_movies.txt";
        Movie[] actual = MovieSelector.getMovieList(filename);
        assertTrue(filename, Arrays.equals(THREE_MOVIES, actual));
    }

    @Test
    public void testGetMovieList2() {
        String filename = "test-files/my_movies.txt";
        Movie[] actual = MovieSelector.getMovieList(filename);
        assertTrue(filename, Arrays.equals(MY_MOVIES, actual));  
    }

    @Test
    public void testSearchByTitle1() {
        String expected = "Snow White and the Seven Dwarfs          1937   83 min  " + 
                          "Animation,Family,Fantasy\n";
        String actual = MovieSelector.searchByTitle("and the", THREE_MOVIES);
        assertEquals("Three movies", expected, actual);
    }

    @Test
    public void testSearchByTitle2() {
        String expected = "Edge of Tomorrow                         2014  113 min  " + 
                          "Action,Sci-Fi\n";
        String actual = MovieSelector.searchByTitle("tom", MY_MOVIES);
        assertEquals("My movies", expected, actual);
    }
    
    @Test
    public void testSearchByTitle3() {
        String expected = "";
        String actual = MovieSelector.searchByTitle("FakeMovie", MY_MOVIES);
        assertEquals("My movies", expected, actual);
    }

    @Test
    public void testSearchByYear1() {
        String expected = "The Adventures of Pinocchio              1936   60 min  " +
                          "Animation,Fantasy\n";
        String actual = MovieSelector.searchByYear(1936, THREE_MOVIES);
        assertEquals("Three movies", expected, actual);
    }
    
    @Test
    public void testSearchByYear2() {
        String expected = "";
        String actual = MovieSelector.searchByYear(2020, MY_MOVIES);
        assertEquals("My Movies", expected, actual);
    }

    @Test
    public void testSearchByGenre() {
        String expected = "Sleeping Beauty                          1959   75 min  " +
                          "Animation,Family,Fantasy\n" +
                          "Snow White and the Seven Dwarfs          1937   83 min  " + 
                          "Animation,Family,Fantasy\n" +
                          "The Adventures of Pinocchio              1936   60 min  " +
                          "Animation,Fantasy\n";
        String actual = MovieSelector.searchByGenre("Fantasy", THREE_MOVIES);
        assertEquals("Three movies", expected, actual);
    }
    
    @Test
    public void testSearchByGenre2() {
        String expected = "";
        String actual = MovieSelector.searchByGenre("Documentary", MY_MOVIES);
        assertEquals("My Movies", expected, actual);
    }
    
    // TODO: Add 1 more test case here for searchByGenre method. The test should be
    // in its own method.

    /**
     * Test the MovieSelector methods with invalid values
     */ 
    @Test
    public void testSearchInvalid() {
        // Invalid test cases are provided for you below - You do NOT
        // need to add additional invalid tests. Just make sure this test
        // passes!
        try {
            MovieSelector.searchByYear(-5, THREE_MOVIES);
            fail();
        } catch (IllegalArgumentException e) {
            assertEquals("Invalid year", e.getMessage());
        }

    }
}
