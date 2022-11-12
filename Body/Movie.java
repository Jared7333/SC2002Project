package Body;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Comparator;

/**
 * Contains a movie's information. Can update its own rating,
 * and contains comparison functions for sorting.
 */
public class Movie implements Serializable {
    /**
     * The movie's name.
     */
    private String name;
    /**
     * The movie's ID.
     */
    private int movieId;
    /**
     * Whether the movie is a 3D movie.
     */
    private boolean threeD;
    /**
     * Whether the movie is a blockbuster movie.
     */
    private boolean blockbuster;
    /**
     * The movie's showing status.
     */
    private String status;
    /**
     * The movie's synopsis.
     */
    private String synopsis;
    /**
     * The movie's director.
     */
    private String director;
    /**
     * List of the movie's cast members.
     */
    private ArrayList<String> casts; 
    /**
     * The movie's age rating.
     */
    private String ageRating;
    /**
     * The movie's rating score.
     */
    private double overallRating;
    /**
     * List of all the ratings cutomers have given the movie.
     */
    private ArrayList<Integer> pastReview;
    /**
     * Number of ticket sales.
     */
    private int ticketSales; 
    /**
     * List of the movie's show times.
     */
    private ArrayList<Integer> showTimes;
    /**
     * Which cinema the movie is showing in. 
     */
    private int cinema;
    /**
     * Creates a movie with all attributes filled.
     * @param name Movie's name.
     * @param movieId Movie's ID.
     * @param threeD Whether a movie is 3D.
     * @param blockbuster Whether a movie is blockbuster.
     * @param status Movie's showing status.
     * @param synopsis Movie's synopsis.
     * @param director Movie's director.
     * @param casts List of cast members.
     * @param ageRating Movie's age rating.
     * @param pastReview List of all rating scores.
     * @param ticketSales Number of sales.
     * @param showTimes Movie's show times.
     * @param cinema Viewing cinema.
     */
    public Movie(String name, int movieId, boolean threeD, boolean blockbuster, String status, String synopsis, String director, ArrayList<String> casts, String ageRating,
                 ArrayList<Integer> pastReview, int ticketSales, ArrayList<Integer> showTimes, int cinema){
        this.name = name;
        this.movieId = movieId;
        this.threeD = threeD;
        this.blockbuster = blockbuster;
        this.status = status;
        this.synopsis = synopsis;
        this.director = director;
        this.casts = casts;
        this.ageRating = ageRating;
        this.overallRating = 0.0;
        this.pastReview = pastReview;
        this.ticketSales = ticketSales;
        this.showTimes = showTimes;
        this.cinema = cinema;
    }

    
    /** 
     * Set the movie's name.
     * @param name Movie's name.
     */
    public void setName(String name){
        this.name = name;
    }

    
    /** 
     * Get the movie's name.
     * @return the movie's name.
     */
    public String getName(){
        return name;
    }

    
    /** 
     * Set the movie ID.
     * @param movieId the movie's ID.
     */
    public void setMovieId(int movieId){
        this.movieId = movieId;
    }

    
    /** 
     * Get the movie ID.
     * @return the movie's ID.
     */
    public int getMovieId(){
        return movieId;
    }

    /**
     * Get the movie's 3D status.
     * @return movie's 3D status.
     */
    public boolean getThreeD() { return threeD; }

    /**
     * Set the movie's 3D status.
     * @param threeD Movie's 3D status.
     */
    public void setThreeD(boolean threeD) { this.threeD = threeD; }

    /**
     * Get the movie's blockbuster status.
     * @return movie's blockbuster status.
     */
    public boolean getBlockbuster() { return blockbuster; }

    /**
     * Set the movie's blockbuster status.
     * @param blockbuster movie's blockbuster status.
     */
    public void setBlockbuster(boolean blockbuster) { this.blockbuster = blockbuster; }

    
    /** 
     * Set movie's showing status.
     * @param status movie's showing status.
     */
    public void setStatus(String status){
        this.status = status;
    }

    
    /** 
     * Get movie's showing status.
     * @return movie's showing status.
     */
    public String getStatus(){
        return status;
    }

    
    /** 
     * Set movie's synopsis.
     * @param synopsis movie's synopsis.
     */
    public void setSynopsis(String synopsis){
        this.synopsis = synopsis;
    }

    
    /** 
     * Get movie's synopsis.
     * @return String movie's synopsis.
     */
    public String getSynopsis(){
        return synopsis;
    }

    
    /** 
     * Set movie's director.
     * @param director movie's director.
     */
    public void setDirector(String director){
        this.director = director;
    }

    
    /** 
     * Get movie's director.
     * @return movie's director.
     */
    public String getDirector(){
        return director;
    }

    public void setCasts(ArrayList<String> casts) { this.casts = casts; }

    public ArrayList<String> getCasts() { return casts; }

    
    /** 
     * Set movie's age rating.
     * @param ageRating movie's age rating.
     */
    public void setAgerating(String ageRating){
        this.ageRating = ageRating;
    }

    
    /** 
     * Get movie's age rating.
     * @return movie's age rating.
     */
    public String getAgeRating(){
        return ageRating;
    }

    
    /** 
     * Set movie's show times.
     * @param showTimes list of show times.
     */
    public void setShowTimes(ArrayList<Integer> showTimes){
        this.showTimes = showTimes;
    }

    
    /** 
     * get movie's show times.
     * @return list of show times.
     */
    public ArrayList<Integer> getShowtimes(){
        return showTimes;
    }

    
    /** 
     * Set movie's sales.
     * @param ticketSales movie's sales.
     */
    public void setTicketSales(int ticketSales){
        this.ticketSales = ticketSales;
    }

    /**
     * Get the movie's past ratings.
     * @return list of movie's past ratings.
     */
    public ArrayList<Integer> getPastReview() { return pastReview; }

    
    /** 
     * Get movie's sales.
     * @return movie's sales.
     */
    public int getTicketSales(){
        return ticketSales;
    }

    
    /** 
     * Get movie's rating.
     * @return movie's rating.
     */
    public double getRatingStar(){
        return overallRating;
    }

    
    /** 
     * Get movie's cinema number.
     * @return movie's cinema number.
     */
    public int getCinemaNo(){
        return cinema;
    }

    
    /** 
     * Set movie's cinema number.
     * @param movie's cinema number.
     */
    public void setCinemaNo(int cinema){
        this.cinema = cinema;
    }

    
    /** 
     * Updates the movie's overall rating with a customer's rating.
     * The overall rating of a movie is the average of all customer ratings.
     * @param customerRating Rating newly given by a customer to the movie.
     */
    public void calOverallRating(int customerRating){
        pastReview.add(customerRating);
        if (overallRating == 0)
            overallRating = customerRating;
        else{
            overallRating = (overallRating * (pastReview.size() - 1) + customerRating) / pastReview.size();
        }
    }
    /**
     * Utility for a movie to print all of its own information.
     */
    public void printInfo(){
        System.out.println(
                "name: " + this.name
                + "\nmovieId: " + this.movieId
                + "\nthreeD: " + this.threeD
                + "\nblockbuster: " + this.blockbuster
                + "\nstatus: " + this.status
                + "\nsynopsis: " + this.synopsis
                + "\ndirector: " + this.director
                + "\ncasts: " + this.casts
                + "\nageRating: " + this.ageRating
                + "\noveralRating: " + this.overallRating
                + "\npastReview: " + this.pastReview
                + "\nticketSales: " + this.ticketSales
                + "\nshowTimes: " + this.showTimes
                + "\ncinema: " + this.cinema
        );
    }

    /**
     * Utility for sorting movies by ticket sales.
     */
    public static Comparator<Movie> byTicketSales = new Comparator<Movie>() {

        public int compare(Movie m1, Movie m2) {

            int ticketSales1 = m1.getTicketSales();
            int ticketSales2 = m2.getTicketSales();

            /*For ascending order*/
            //return ticketSales1-ticketSales2;

            /*For descending order*/
            return ticketSales2-ticketSales1;
        }
    };

    /**
     * Utility for sorting movies by rating.
     */
    public static Comparator<Movie> byRating = new Comparator<Movie>() {

        public int compare(Movie m1, Movie m2) {

            /*For ascending order*/
            //return Double.compare(m1.getRatingStar(), m2.getRatingStar());

            /*For descending order*/
            return Double.compare(m2.getRatingStar(), m1.getRatingStar());
        }
    };
}