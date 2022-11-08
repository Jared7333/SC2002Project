import java.io.*;
import java.util.ArrayList;

public class serialise{

    public void exportMovie(String filename, ArrayList<Movie> movieList) throws IOException {
        FileOutputStream fileOutputStream = new FileOutputStream(filename);
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
        for (Movie movie : movieList) {
            objectOutputStream.writeObject(movie);
        }
        objectOutputStream.flush();
        objectOutputStream.close();
    }

    public ArrayList<Movie> importMovie(String filename) throws IOException, ClassNotFoundException {
        ArrayList<Movie> movieList = new ArrayList<Movie>();
        FileInputStream fileInputStream = new FileInputStream(filename);
        if (fileInputStream.available() != 0){
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            Movie movie;
            boolean cont = true;
            while(cont){
                if(fileInputStream.available() != 0) {
                    movie = (Movie) objectInputStream.readObject();
                    movieList.add(movie);
                } else {
                    cont = false;
                }
            }
        }
        return movieList;
    }

    public void exportAdmin(String filename, ArrayList<Admin> adminList) throws IOException{
        FileOutputStream fileOutputStream = new FileOutputStream(filename);
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
        for (Admin admin : adminList) {
            objectOutputStream.writeObject(admin);
        }
        objectOutputStream.flush();
        objectOutputStream.close();
    }

    public ArrayList<Admin> importAdmin(String filename) throws IOException, ClassNotFoundException{
        ArrayList<Admin> adminList = new ArrayList<Admin>();
        FileInputStream fileInputStream = new FileInputStream(filename);
        if(fileInputStream.available() != 0) {
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            Admin admin;
            boolean cont = true;
            while (cont) {
                if (fileInputStream.available() != 0) {
                    admin = (Admin) objectInputStream.readObject();
                    adminList.add(admin);
                } else {
                    cont = false;
                }
            }
        }
        return adminList;
    }
}
