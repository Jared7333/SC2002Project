import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Admin {
    private String name;
    private String loginID;
    private String password;

    public Admin(String name, String loginID, String password){
        this.name = name;
        this.loginID = loginID;
        this.password = password;
    }

    public void createAdmin(String name, String loginID, String password, ArrayList allAdmin){
        allAdmin.add(new Admin(name, loginID, password));
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

    public void createMovie(ArrayList<Movie> allMovies) throws Exception {
        //reads csv and import movies
        String path = System.getProperty("user.dir") + "\\src\\" + "movieData.txt";
        Scanner file = new Scanner(new File(path));
        while (file.hasNextLine()) {
            String str = file.nextLine();
//            System.out.println(str);
            String[] info = str.split(",");
//            System.out.println(info[0] + info[1] + info[2]);
            double rating = Double.parseDouble(info[2]);
            allMovies.add(new Movie(info[0], info[1], rating));
        }
    }

    public void printMovies(ArrayList<Movie> allMovies){
        System.out.println("List of Movies:");
        for(int i = 0; i < allMovies.size(); i++){
            String name = allMovies.get(i).getName();
            String contentRating = allMovies.get(i).getContentRating();
            double ratingStar = allMovies.get(i).getRatingStar();
            int cinemaNo = allMovies.get(i).getCinemaNo();
            System.out.printf("|(%d) | Name: %s | Content Rating: %s | Rating: %,.2f | Cinema Number: %d |\n", i+1, name, contentRating, ratingStar, cinemaNo);
        }
    }

    public void updateMovie(ArrayList<Movie> allMovies){
        Scanner sc = new Scanner(System.in);
        printMovies(allMovies);
        System.out.println("Enter Row ID to Update: ");
        int rowID = sc.nextInt(); sc.nextLine();
        System.out.println("Select Info to Update:\n(1)Content Rating\n(2)Cinema Number");
        int header = sc.nextInt(); sc.nextLine();
        if(header == 1){
            System.out.println("Update Content Rating to:");
            String toUpdate = sc.nextLine();
            allMovies.get(rowID-1).setContentRating(toUpdate);
            System.out.println("Updated Successfully");
        } else if (header == 2) {
            System.out.println("Update Cinema Number to:");
            int toUpdate = sc.nextInt(); sc.nextLine();
            allMovies.get(rowID-1).setCinemaNo(toUpdate);
            System.out.println("Updated Successfully");
        }
        printMovies(allMovies);
    }

    public void removeMovie(ArrayList<Movie> allMovies){
        Scanner sc = new Scanner(System.in);
        printMovies(allMovies);
        System.out.println("Enter Row ID to Remove: ");
        int rowID = sc.nextInt(); sc.nextLine();
        allMovies.remove(rowID-1);
        System.out.println("Deleted Successfully");
        printMovies(allMovies);
    }

    public void configureSettings(){
        Scanner sc = new Scanner(System.in);
        System.out.println("System Settings");
        System.out.println("Select Settings to Update: \n(1) Login ID \n(2) Password");
        int setting = sc.nextInt(); sc.nextLine();
        if(setting == 1){
            System.out.printf("Current Login ID: %s \n", getLoginID());
            System.out.println("Enter New Login ID:");
            String toUpdate = sc.nextLine();
            setLoginID(toUpdate);
            System.out.printf("New Login ID: %s \n", getLoginID());
        } else if (setting == 2) {
            System.out.printf("Current Password: %s \n", getPassword());
            System.out.println("Enter New Password:");
            String toUpdate = sc.nextLine();
            setPassword(toUpdate);
            System.out.printf("New Password: %s \n", getPassword());
        }
    }
}
