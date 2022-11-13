package Body;

import java.io.*;
import java.util.ArrayList;

/**
 * Allows for Movie and Admin Objects to be serialised and stored in a
 * flat file format (.txt) which then can be imported back as its
 * respecitve objects without losing any information.
 */

public class serialise{

    /**
     * Exports List of Movie Objects into a text file to be stored so that
     * it can be then imported the next time the program is executed.
     *
     * @param filename to dictate which file it is serialising the objects to.
     * @param movieList list of Movie Objects in the current program to be stored.
     * @throws IOException
     */
    public void exportMovie(String filename, ArrayList<Movie> movieList) throws IOException {
        FileOutputStream fileOutputStream = new FileOutputStream(filename);
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
        for (Movie movie : movieList) {
            objectOutputStream.writeObject(movie);
        }
        objectOutputStream.flush();
        objectOutputStream.close();
    }

    /**
     * Imports Movie Objects from text file created when program terminates which
     * contains existing Movie Objects to be used.
     *
     * @param filename to dictate where to import the Movie Objects from.
     * @return list of Movie Objects that are currently being used.
     * @throws IOException
     * @throws ClassNotFoundException
     */
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

    /**
     * Exports List of Admin Objects into a text file to be stored so that
     * it can be then imported the next time the program is executed.
     *
     * @param filename to dictate which file it is serialising the objects to.
     * @param adminList list of Admin Objects in the current program to be stored.
     * @throws IOException
     */
    public void exportAdmin(String filename, ArrayList<Admin> adminList) throws IOException{
        FileOutputStream fileOutputStream = new FileOutputStream(filename);
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
        for (Admin admin : adminList) {
            objectOutputStream.writeObject(admin);
        }
        objectOutputStream.flush();
        objectOutputStream.close();
    }

    /**
     * Imports Admin Objects from text file created when program terminates which
     * contains existing Movie Objects to be used.
     *
     * @param filename to dictate where to import the Admin Objects from.
     * @return list of Admin Objects that are currently being used.
     * @throws IOException
     * @throws ClassNotFoundException
     */
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
