import java.util.ArrayList;

public class Movie{
    /*
        enum Status{
        COMING_SOON,
        PREVIEW,
        NOW_SHOWING, 
        END_OF_SHOWING
    }

    enum  AgeRating{
        PG, 
        M18, 
        R21
    }

     */
   
    private String name;
    private int movieId;
    private String status;
    private String synopsis;
    private String director;
    private ArrayList<String> casts; //not used yet
    private String ageRating;
    private double overallRating;
    private ArrayList<Integer> pastReview;
    private int ticketSales; 
    private int[] showTimes;
    private int cinema;

    public void setName(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }

    public void setMovieId(int movieId){
        this.movieId = movieId;
    }

    public int getMovieId(){
        return movieId;
    }

    public void setStatus(String status){
        this.status = status;
    }

    public String getStatus(){
        return status;
    }

    public void setSynopsis(String synopsis){
        this.synopsis = synopsis;
    }

    public String getSynopsis(){
        return synopsis;
    }

    public void setDirector(String director){
        this.director = director;
    }

    public String getDirector(){
        return director;
    }

    public void setAgerating(String ageRating){
        this.ageRating = ageRating;
    }

    public String getAgeRating(){
        return ageRating;
    }

    public void setShowTimes(int[] showTimes){
        this.showTimes = showTimes; //is it okay to so this with arrays?
    }

    public int[] getShowtimes(){
        return showTimes;
    }

    public void setTicketSales(int ticketSales){
        this.ticketSales = ticketSales;
    }

    public int getTicketSales(){
        return ticketSales;
    }

    public double getRatingStar(){
        return overallRating;
    }

    public int getCinemaNo(){
        return cinema;
    }

    public void setCinemaNo(int cinema){
        this.cinema = cinema;
    }

    public void calOverallRating(int customerRating){
        pastReview.add(customerRating);
        if (overallRating == 0)
            overallRating = customerRating;
        else{
            overallRating = (overallRating * (pastReview.size() - 1) + customerRating) / pastReview.size();
        }
    }
}