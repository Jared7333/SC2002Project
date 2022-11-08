import java.io.Serializable;
import java.util.ArrayList;

public class Movie implements Serializable {
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
	private boolean threeD;
	private boolean blockbuster;
    private String status;
    private String synopsis;
    private String director;
    private ArrayList<String> casts; //not used yet
    private String ageRating;
    private double overallRating;
    private ArrayList<Integer> pastReview;
    private int ticketSales; 
    private ArrayList<Integer> showTimes;
    private int cinema;

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

	public boolean isthreeD() {
		return threeD;
	}

	public void setthreeD(boolean threeD) {
		this.threeD = threeD;
	}

	public boolean isblockbuster() {
		return blockbuster;
	}

	public void setblockbuster(boolean blockbuster) { // Blockbuster, Normal
		this.blockbuster = blockbuster;
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

    public void setCasts(ArrayList<String> casts) { this.casts = casts; }

    public ArrayList<String> getCasts() { return casts; }

    public void setAgerating(String ageRating){
        this.ageRating = ageRating;
    }

    public String getAgeRating(){
        return ageRating;
    }

    public void setShowTimes(ArrayList<Integer> showTimes){
        this.showTimes = showTimes;
    }

    public ArrayList<Integer> getShowtimes(){
        return showTimes;
    }

    public void setTicketSales(int ticketSales){
        this.ticketSales = ticketSales;
    }

    public ArrayList<Integer> getPastReview() { return pastReview; }

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

    public void printInfo(){
        System.out.println(
                "name: " + this.name
                + "\nmovieId: " + this.movieId
                + "\n3D: " + this.threeD 
                + "\nBlockbuster: " + this.blockbuster
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
}