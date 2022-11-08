import java.io.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

public class Admin implements Serializable{
    private String name;
    private String loginID;
    private String password;
    private boolean loop;

    public Admin(String name, String loginID, String password){
        this.name = name;
        this.loginID = loginID;
        this.password = password;
        this.loop = true;
    }

    public void createAdmin(String name, String loginID, String password, ArrayList<Admin> adminList){
        for(Admin a : adminList){
            if (a.getLoginID() != null && a.getLoginID().matches(loginID)) {
                System.out.println("Admin Username Already Exists");
                return;
            }
        }
        Admin create = new Admin(name, loginID, password);
        adminList.add(create);
        System.out.println("Admin Account Created Successfully");
    }

    public String getName(){
        return this.name;
    }

    public String getLoginID(){
        return this.loginID;
    }

    public void setLoginID(String loginID) {
        this.loginID = loginID;
    }

    public String getPassword(){
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void printInfo(){
        String info = "Name: "+name+"    | Username: "+loginID+"    | Password: "+password;
        System.out.println(info + '\n');
    }

    public void createMovie(ArrayList<Movie> movieList) throws FileNotFoundException {
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
            String[] casts1 = info[6].split(",");
            ArrayList<String> casts2 = new ArrayList<String>();
            for (String s : casts1) {
                casts2.add(s);
            }
            String[] pastReview1 = info[8].split(",");
            ArrayList<Integer> pastReview2 = new ArrayList<Integer>();
            for (String s : pastReview1) {
                pastReview2.add(Integer.parseInt(s));
            }
            String[] showTimes1 = info[10].split(",");
            ArrayList<Integer> showTimes2 = new ArrayList<Integer>();
            for (String s : showTimes1) {
                showTimes2.add(Integer.parseInt(s));
            }
            movieList.add(new Movie(info[0],
                    Integer.parseInt(info[1]),
                    info[2],
                    info[3],
                    info[4],
                    info[5],
                    casts2,
                    info[7],
                    pastReview2,
                    Integer.parseInt(info[9]),
                    showTimes2,
                    Integer.parseInt(info[11])
                    ));
        }
    }

    public void printMovies(ArrayList<Movie> movieList){
        System.out.println("List of Movies:");
        for(int i = 0; i < movieList.size(); i++){
            System.out.printf("(%d): %s \n", i+1, movieList.get(i).getName());
        }
        System.out.println();
    }
    
    public void printMovieDetailed(ArrayList<Movie> movieList){
        Scanner sc = new Scanner(System.in);
        printMovies(movieList);
        loop = true;
        while(loop){
            System.out.println("Enter '0' to Cancel\nSelect Row ID to Print Full Information: ");
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

    public void updateMovie(ArrayList<Movie> movieList){
        Scanner sc = new Scanner(System.in);
        printMovies(movieList);
        int rowID = 0;
        loop = true;
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
                (3)Movie Type
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
            case "3": //movie type
                System.out.println("Current Movie Type: " + movieList.get(rowID).getMovieType());
                System.out.println("Enter New Movie Type: ");
                String newType = sc.nextLine();
                if(newType.equals("0")){
                    break;
                }
                movieList.get(rowID).setMovieType(newType);
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

    public void removeMovie(ArrayList<Movie> movieList){
        Scanner sc = new Scanner(System.in);
        loop = true;
        printMovies(movieList);
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
                printMovies(movieList);
            }
        }



    }

    public void configureSettings(ArrayList<Admin> adminList){ //Change password or create new admin account
        Scanner sc = new Scanner(System.in);
        System.out.println("System Settings");
        String toUpdate;
        loop = true;
        int index = 0;
        while(loop){
            System.out.println("Select Action\n(1)Change Password\n(2)Add New Admin");
            int setting = sc.nextInt(); sc.nextLine();
            switch (setting) {
                case 1 -> { // Change Password
                    System.out.printf("Current Password: %s \n", getPassword());
                    System.out.println("Enter New Password:");
                    toUpdate = sc.nextLine();
                    for (Admin a : adminList) {
                        if (a.getLoginID() != null && a.getLoginID().matches(getName())) {
                            adminList.get(index).setPassword(toUpdate);
                            System.out.printf("New Password: %s \n", a.getPassword());
                        }
                        index++;
                    }
                    loop = false;
                }
                case 2 -> { //Create new admin account
                    System.out.println("Enter New Admin Name:");
                    String createName = sc.nextLine();
                    System.out.println("Enter New Admin Username:");
                    String createUsername = sc.nextLine();
                    System.out.println("Enter New Admin Password:");
                    String createPassword = sc.nextLine();
                    createAdmin(createName, createUsername, createPassword, adminList);
                    loop = false;
                }
                default -> {
                }
            }
        }
    }
}


