import java.io.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

public class Admin implements Serializable{
    private String name;
    private String loginID;
    private String password;

    public Admin(String name, String loginID, String password){
        this.name = name;
        this.loginID = loginID;
        this.password = password;
    }

//    public void createAdmin(String name, String loginID, String password, ArrayList allAdmin){
//        allAdmin.add(new Admin(name, loginID, password));
//    }

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

    public void createMovie(ArrayList<Movie> movieList) throws FileNotFoundException {
        //reads csv and import movies
        String path = System.getProperty("user.dir") + "\\src\\" + "newMovies.txt";
        Scanner file = new Scanner(new File(path));
        while (file.hasNextLine()) {
            String str = file.nextLine();
            String[] info = str.split(":");
//            System.out.println(str);
//            for(int i = 0; i < info.length; i++){
//                System.out.println(info[i]);
//            }
            String[] casts1 = info[5].split(",");
            ArrayList<String> casts2 = new ArrayList<String>();
            for(int i = 0; i < casts1.length; i++){
                casts2.add(casts1[i]);
            }
            String[] pastReview1 = info[7].split(",");
            ArrayList<Integer> pastReview2 = new ArrayList<Integer>();
            for(int i = 0; i < pastReview1.length; i++) {
                pastReview2.add(Integer.parseInt(pastReview1[i]));
            }
            String[] showTimes1 = info[9].split(",");
            ArrayList<Integer> showTimes2 = new ArrayList<Integer>();
            for(int i = 0; i < showTimes1.length; i++){
                showTimes2.add(Integer.parseInt(showTimes1[i]));
            }
            movieList.add(new Movie(info[0],
                    Integer.parseInt(info[1]),
                    info[2],
                    info[3],
                    info[4],
                    casts2,
                    info[6],
                    pastReview2,
                    Integer.parseInt(info[8]),
                    showTimes2,
                    Integer.parseInt(info[10])
                    ));
        }
    }

    public void printMovies(ArrayList<Movie> movieList){
        System.out.println("List of Movies:");
        for(int i = 0; i < movieList.size(); i++){
            movieList.get(i).getName();
        }
    }

    public void updateMovie(ArrayList<Movie> movieList){
        Scanner sc = new Scanner(System.in);
        printMovies(movieList);
        System.out.println("Enter Row ID to Update: ");
        int rowID = sc.nextInt(); sc.nextLine();
    }

    public void removeMovie(ArrayList<Movie> movieList){
        Scanner sc = new Scanner(System.in);
        printMovies(movieList);
        System.out.println("Enter Row ID to Remove: ");
        int rowID = sc.nextInt(); sc.nextLine();
        movieList.remove(rowID-1);
        System.out.println("Deleted Successfully");
        printMovies(movieList);
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
        } else if (setting == 2){
            System.out.printf("Current Password: %s \n", getPassword());
            System.out.println("Enter New Password:");
            String toUpdate = sc.nextLine();
            setPassword(toUpdate);
            System.out.printf("New Password: %s \n", getPassword());
        }
    }

    public static void main(String[] args) throws FileNotFoundException {
        ArrayList<Movie> testMovie = new ArrayList<Movie>();
        Admin a = new Admin("admin", "test", "password");
        a.createMovie(testMovie);
        for(int i = 0; i < testMovie.size(); i++){
            testMovie.get(i).printInfo();
        }
    }
}


