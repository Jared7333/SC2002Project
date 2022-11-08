package Body;

import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class movieMethods {
    public static void create(ArrayList<Movie> movieList) throws FileNotFoundException {
        //reads csv and import movies
        String path = System.getProperty("user.dir") + "\\src\\" + "newMovies.txt";
        Scanner file = new Scanner(new File(path));
        while (file.hasNextLine()) {
            String str = file.nextLine();
            String[] info = str.split(":");
            System.out.println(str);
            for (String s : info) {
                System.out.println(s);
            }
            String[] casts1 = info[7].split(",");
            ArrayList<String> casts2 = new ArrayList<String>();
            for (String s : casts1) {
                casts2.add(s);
            }
            String[] pastReview1 = info[9].split(",");
            ArrayList<Integer> pastReview2 = new ArrayList<Integer>();
            for (String s : pastReview1) {
                if(!s.isEmpty()){
                    pastReview2.add(Integer.parseInt(s));
                }
            }
            String[] showTimes1 = info[11].split(",");
            ArrayList<Integer> showTimes2 = new ArrayList<Integer>();
            for (String s : showTimes1) {
                showTimes2.add(Integer.parseInt(s));
            }
            movieList.add(new Movie(info[0],
                    Integer.parseInt(info[1]),
                    Boolean.parseBoolean(info[2]),
                    Boolean.parseBoolean(info[3]),
                    info[4],
                    info[5],
                    info[6],
                    casts2,
                    info[8],
                    pastReview2,
                    Integer.parseInt(info[10]),
                    showTimes2,
                    Integer.parseInt(info[12])
            ));
        }
    }

    public static void printSummarised(ArrayList<Movie> movieList){
        System.out.println("List of Movies:");
        for(int i = 0; i < movieList.size(); i++){
            System.out.printf("(%d): %s \n", i+1, movieList.get(i).getName());
        }
        System.out.println();
    }

    public static void printDetailed(ArrayList<Movie> movieList){
        Scanner sc = new Scanner(System.in);
        printSummarised(movieList);
        boolean loop = true;
        while(loop){
            System.out.println("\nEnter '0' to Cancel\nSelect Row ID to Print Full Information: ");
            int rowID = sc.nextInt(); sc.nextLine();
            if(rowID == 0){
                loop = false;
            } else if (rowID < 0 || rowID > movieList.size()) {
                System.out.println("Invalid Row ID");
            } else {
                rowID--;
                movieList.get(rowID).printInfo();
            }
        }
    }

    public static void sortBySales(ArrayList<Movie> movieList){
        ArrayList<Movie> tempList = new ArrayList<>(movieList);
        System.out.println("Sorted by Ticket Sales:");
        Collections.sort(tempList, Movie.byTicketSales);
        int index = 1;
        for(Movie mov : tempList){
            System.out.printf("(%d) %s    | Sales: %d\n", index, mov.getName(), mov.getTicketSales());
            index++;
            if(index > 5){
                break;
            }
        }
    }

    public static void sortByRating(ArrayList<Movie> movieList){
        ArrayList<Movie> tempList = new ArrayList<>(movieList);
        System.out.println("Sorted by Rating:");
        Collections.sort(tempList, Movie.byRating);
        int index = 1;
        for(Movie mov : tempList){
            System.out.printf("(%d) %s    | Rating: %.2f\n", index, mov.getName(), mov.getRatingStar());
            index++;
            if(index > 5){
                break;
            }
        }
    }

    public static void deleteMovie(ArrayList<Movie> movieList){
        Scanner sc = new Scanner(System.in);
        boolean loop = true;
        printSummarised(movieList);
        while(loop){
            System.out.println("Enter '0' to Cancel\nEnter Row ID to Remove: ");
            int rowID = sc.nextInt(); sc.nextLine();
            if(rowID == 0){
                loop = false;
            } else if (rowID < 0 || rowID > movieList.size()) {
                System.out.println("Invalid Row ID");
            } else {
                movieList.remove(rowID-1);
                System.out.println("Deleted Successfully");
                printSummarised(movieList);
            }
        }
    }

    public static void updateInfo(ArrayList<Movie> movieList){
        Scanner sc = new Scanner(System.in);
        printSummarised(movieList);
        int rowID = 0;
        boolean loop = true;
        while(loop){
            System.out.println("Enter Row ID to Update: ");
            rowID = sc.nextInt(); sc.nextLine();
            if(rowID <= 0 || rowID > movieList.size()){
                System.out.println("Invalid Row ID");
            } else {
                rowID--;
                loop = false;
            }
        }
        System.out.println("""
                Enter Column to Update:
                (1)Movie Name
                (2)Movie ID
                (3)3D / Blockbuster
                (4)Movie Status
                (5)Synopsis
                (6)Director
                (7)Casts
                (8)Age Rating
                (9)Showtimes
                (10)Cinema Number
                (0)Exit""");
        String colName = sc.nextLine();
        switch(colName){
            case "1": //movie name
                System.out.println("Current Name: " + movieList.get(rowID).getName());
                System.out.println("Enter '0' to Cancel\nEnter New Name: ");
                String newName = sc.nextLine();
                if(newName.equals("0")){
                    break;
                }
                movieList.get(rowID).setName(newName);
                break;
            case "2": //movie id
                System.out.println("Current Movie ID: " + movieList.get(rowID).getMovieId());
                System.out.println("Enter '0' to Cancel\nEnter New Movie ID: ");
                int newID = sc.nextInt(); sc.nextLine();
                if(newID == 0){
                    break;
                }
                movieList.get(rowID).setMovieId(newID);
                break;
            case "3": //3D or blockbuster
                String newThreeD = null; String newBlockbuster = null;
                System.out.println("Current Movie Type:");
                if(movieList.get(rowID).getThreeD()){
                    System.out.print("3D");
                } else {
                    System.out.print("NOT 3D");
                }
                if(movieList.get(rowID).getBlockbuster()){
                    System.out.print(" and Blockbuster");
                } else {
                    System.out.print(" and NOT Blockbuster");
                }
                System.out.println("Enter New Movie Type: ");
                while(!newThreeD.matches("y") || !newThreeD.matches("n")){
                    System.out.println("Is Movie 3D? [Y/N]");
                    newThreeD = sc.nextLine();
                    newThreeD.toLowerCase();
                }
                while(!newBlockbuster.matches("y") || !newBlockbuster.matches("n")){
                    System.out.println("Is Movie Blockbuster? [Y/N]");
                    newBlockbuster = sc.nextLine();
                    newBlockbuster.toLowerCase();
                }
                if(newThreeD.matches("y")) { newThreeD = "true"; }
                else { newThreeD = "false"; }
                if(newBlockbuster.matches("y")) { newBlockbuster = "true"; }
                else { newBlockbuster = "false"; }
                movieList.get(rowID).setThreeD(Boolean.parseBoolean(newThreeD));
                movieList.get(rowID).setBlockbuster(Boolean.parseBoolean(newBlockbuster));
                break;
            case "4": //status
                System.out.println("Current Status: " + movieList.get(rowID).getStatus());
                System.out.println("Enter New Status: ");
                String newStatus = sc.nextLine();
                if(newStatus.equals("0")){
                    break;
                }
                movieList.get(rowID).setStatus(newStatus);
                break;
            case "5": //synopsis
                System.out.println("Current Synopsis: " + movieList.get(rowID).getSynopsis());
                System.out.println("Enter New Synopsis: ");
                String newSynopsis = sc.nextLine();
                if(newSynopsis.equals("0")){
                    break;
                }
                movieList.get(rowID).setSynopsis(newSynopsis);
                break;
            case "6": //director
                System.out.println("Current Director: " + movieList.get(rowID).getDirector());
                System.out.println("Enter New Director: ");
                String newDirector = sc.nextLine();
                if(newDirector.equals("0")){
                    break;
                }
                movieList.get(rowID).setDirector(newDirector);
                break;
            case "7": //casts
                ArrayList<String> currentCast;
                currentCast = movieList.get(rowID).getCasts();
                loop = true;
                while(loop){
                    System.out.printf("Current Cast:%s\n(1)Add\n(2)Remove\n(0)Exit\n", currentCast);
                    String choice = sc.nextLine();
                    choice.toLowerCase();
                    switch (choice) {
                        case "1", "add" -> {
                            System.out.println("Enter Cast Name:");
                            String newCast = sc.nextLine();
                            currentCast.add(newCast);
                        }
                        case "2", "remove" -> {
                            int removeCast = -1;
                            while (removeCast < 0 || removeCast > currentCast.size() - 1) {
                                for (int i = 0; i < currentCast.size(); i++) {
                                    System.out.printf("(%d) %s\n", i + 1, currentCast.get(i));
                                }
                                System.out.println("Enter Index of Cast to Remove:");
                                removeCast = sc.nextInt();
                                sc.nextLine();
                                removeCast--;
                            }
                            currentCast.remove(removeCast);
                        }
                        case "0", "exit" -> {
                            movieList.get(rowID).setCasts(currentCast);
                            loop = false;
                        }
                    }
                }
                break;
            case "8": //age rating
                System.out.println("Current Age Rating: " + movieList.get(rowID).getAgeRating());
                System.out.println("Enter New Age Rating: ");
                String newAgeRating = sc.nextLine();
                if(newAgeRating.equals("0")){
                    break;
                }
                movieList.get(rowID).setAgerating(newAgeRating);
                break;
            case "9": //showtimes
                ArrayList<Integer> currentTimes;
                currentTimes = movieList.get(rowID).getShowtimes();
                loop = true;
                while(loop){
                    System.out.printf("Current Cast:%s\n(1)Add\n(2)Remove\n(0)Exit\n", currentTimes);
                    String choice = sc.nextLine();
                    choice.toLowerCase();
                    switch (choice) {
                        case "1", "add" -> {
                            System.out.println("Enter New Showtime:");
                            int newTime = sc.nextInt();
                            sc.nextLine();
                            currentTimes.add(newTime);
                        }
                        case "2", "remove" -> {
                            int removeTime = -1;
                            while (removeTime < 0 || removeTime > currentTimes.size() - 1) {
                                for (int i = 0; i < currentTimes.size(); i++) {
                                    System.out.printf("(%d) %s\n", i + 1, currentTimes.get(i));
                                }
                                System.out.println("Enter Index of Showtime to Remove:");
                                removeTime = sc.nextInt();
                                sc.nextLine();
                                removeTime--;
                            }
                            currentTimes.remove(removeTime);
                        }
                        case "0", "exit" -> {
                            movieList.get(rowID).setShowTimes(currentTimes);
                            loop = false;
                        }
                    }
                }
                break;
            case "10": //cinema number
                System.out.println("Current Cinema No.: " + movieList.get(rowID).getCinemaNo());
                System.out.println("Enter '0' to Cancel\nEnter New Cinema No.: ");
                int newCinema = sc.nextInt(); sc.nextLine();
                if(newCinema == 0){
                    break;
                }
                movieList.get(rowID).setCinemaNo(newCinema);
                break;
            case "0": //exit
                break;
        }
    }
}
