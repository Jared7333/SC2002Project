package MOBLIMA;

import java.io.*;
import java.util.ArrayList;

public class mainApp {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        String name = "name";
        int movieId = 1;
        String status = "status";
        String synopsis = "synopsis";
        String director = "director";

        ArrayList<String> casts = new ArrayList<String>();
        casts.add("actor1");
        casts.add("actor2");

        String ageRating = "ageRating";

        ArrayList<Integer> pastReview = new ArrayList<Integer>();
        pastReview.add(1);
        pastReview.add(2);

        int ticketSales = 500;

        ArrayList<Integer> showTimes = new ArrayList<Integer>();
        showTimes.add(1);
        showTimes.add(2);

        int cinema = 1;

//        Movie m = new Movie(name, 1, status, synopsis, director, casts, ageRating, pastReview, ticketSales, showTimes, cinema);
//        Movie m2 = new Movie(name, 100, status, synopsis, director, casts, ageRating, pastReview, ticketSales, showTimes, cinema);
//
//        ArrayList<Movie> movieList = new ArrayList<Movie>();
//        movieList.add(m);
//        movieList.add(m2);
//        System.out.println(m.getMovieId());
//        System.out.println(m2.getMovieId());
//        System.out.println();

        ArrayList<Admin> adminList = new ArrayList<Admin>();


        //m.printInfo();

        String filenameMovie = "movie.txt";
        String filenameAdmin = "admin.txt";

        serialise s = new serialise();
//        s.exportMovie(filenameMovie, movieList);

        ArrayList<Movie> newMovieList =  new ArrayList<Movie>();

        newMovieList = s.importMovie(filenameMovie);

        for(int i = 0; i < newMovieList.size(); i++){
            newMovieList.get(i).printInfo();
        }
    }
}
