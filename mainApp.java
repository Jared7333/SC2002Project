import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class mainApp {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        //on start
        ArrayList<Movie> movieList;
        ArrayList<Admin> adminList;

        String filenameMovie = "movie.txt";
        String filenameAdmin = "admin.txt";

        //checks if file exits and if not create
        File f = new File(filenameMovie);
        f.createNewFile();
        File f2 =  new File(filenameAdmin);
        f2.createNewFile();

        serialise s = new serialise();
        movieList = s.importMovie(filenameMovie);
        adminList = s.importAdmin(filenameAdmin);

        //MainAdmin Creation
        Admin mainAdmin = new Admin("Main Admin", "mainADMIN", "adminPASSWORD");
        int count = 0;
        for(Admin a : adminList){
            if(a.getLoginID() != null){
                if(!a.getLoginID().matches(mainAdmin.getLoginID())){
                    count++;
                }
            }
        }
        if(count == adminList.size()){
            adminList.add(mainAdmin);
        }


        for (Movie movie : movieList) {
            movie.printInfo();
        }

        for (Admin admin : adminList) {
            System.out.println(admin.getLoginID());
            System.out.println(admin.getPassword());
        }

        //Program Start
        Scanner sc = new Scanner(System.in);
        boolean loop = true;
        String accType = null;
        while(loop){
            System.out.println("(1) Customer or (2) Admin:");
            accType = sc.nextLine();
            accType.toLowerCase();
            if(accType.equals("customer") || accType.equals("admin") || accType.equals("1") || accType.equals("2")){
                loop = false;
            }
        }

        if(accType.equals("1") || accType.equals("customer")){
            loop = true;
            while(loop){
                System.out.println("""
                Welcome To Movie.com
                Please Select Action:
                (1)Browse Movie
                (2)Book Movie
                (3)Check Past Booking
                (0)Exit""");
                String choice = sc.nextLine();
                switch(choice){
                    case "1":
                        break;
                    case "2":
                        break;
                    case "3":
                        break;
                    case "0":
                        loop = false;
                        break;
                }
            }
        } else {
            //Login logic
            Admin inUse = null;
            boolean login = false;
            while(!login){
                System.out.println("Enter Admin Username:");
                String username = sc.nextLine();
                for(Admin a : adminList){
                    if(a.getLoginID() != null && a.getLoginID().matches(username)){
                        System.out.println("Enter Admin Password:");
                        String password = sc.nextLine();
                        if(a.getPassword().matches(password)){
                            login = true;
                            inUse = a;
                        } else {
                            System.out.println("Invalid Password");
                        }
                    }
                }
            }

            loop = true;
            while (loop){
                System.out.println("""
                        Select Action
                        (1)Upload Movie
                        (2)See All Movies
                        (3)Update Movie Information
                        (4)Remove Movie
                        (5)Admin Account Related
                        (6)Delete Admin Account (ONLY FOR MAIN ADMIN)
                        (0)Exit""");
                String choice = sc.nextLine();
                switch(choice){
                    case "1": //Upload new movies via csv to simulate getting information from webscrapping
                        inUse.uploadMovie(movieList);
                        break;
                    case "2": //Printing of movie information in 2 ways
                        System.out.println("(1)Summarised\n(2)Detailed\n(3)Sorted by Ticket Sales\n(4)Sorted by Rating");
                        int printChoice = sc.nextInt(); sc.nextLine();
                        if(printChoice == 1){
                            inUse.printMovies(movieList);
                        } else if (printChoice == 2) {
                            inUse.printMovieDetailed(movieList);
                        } else if (printChoice == 3) {
                            inUse.printMovieSales(movieList);
                        } else if (printChoice == 4) {
                            inUse.printMovieRating(movieList);
                        } else {
                            System.out.println("Invalid Selection");
                        }
                        break;
                    case "3": //Update movie information
                        inUse.updateMovie(movieList);
                        break;
                    case "4": //Remove movie
                        inUse.removeMovie(movieList);
                        break;
                    case "5": //Change current account password or create new admin account
                        inUse.configureSettings(adminList);
                        break;
                    case "6": //Delete admin account but only possible with main admin account
                        if(inUse.getLoginID().matches(mainAdmin.getLoginID())) {
                            System.out.println("Main Admin Account Detected, Delete Other Admin Account? [Y/N]");
                            String delete = sc.nextLine();
                            delete.toLowerCase();
                            if (delete.matches("y") || delete.matches("yes")) {
                                for (Admin a : adminList) {
                                    if (a.getLoginID() != null && !a.getLoginID().matches(mainAdmin.getLoginID())) {
                                        a.printInfo();
                                    }
                                }
                                System.out.println("Enter Admin Username to be DELETED:");
                                String toDelete = sc.nextLine();
                                for (Admin a : adminList) {
                                    if (a.getLoginID() != null && a.getLoginID().matches(toDelete)) {
                                        adminList.remove(a);
                                        System.out.println("Successfully Deleted");
                                        break;
                                    }
                                }
                            } else {
                                System.out.println("Cancel Deletion of Admin Account");
                            }
                        } else {
                            System.out.println("Not Main Admin");
                        }
                        break;
                    case "0": //Exit
                        loop = false;
                        break;
                }
            }
        }

        //Only if the program terminates properly
        s.exportMovie(filenameMovie, movieList);
        s.exportAdmin(filenameAdmin, adminList);
    }
}
