package Body;

import java.util.ArrayList;
import java.util.Scanner;
/**
 * Utility methods for the Admin class.
 */
public class adminMethods {
    /**
     * Creates a new Admin with a given name, ID, and password, and 
     * updates the list of admins with the new Admin. 
     * @param name the new Admin's name.
     * @param loginID the new Admin's ID.
     * @param password the password the new Admin uses to login.
     * @param adminList the list of admins to be updated.
     */
    public static void newAdmin(String name, String loginID, String password, ArrayList<Admin> adminList){
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
    /**
     * Changes the password of an existing Admin.
     * @param adminList list of current admins.
     * @param current admin whose password is to be changed.
     */
    public static void changePassword(ArrayList<Admin> adminList, Admin current){
        Scanner sc = new Scanner(System.in);
        System.out.printf("Current Password: %s \n", current.getPassword());
        System.out.println("Enter New Password:");
        String toUpdate = sc.nextLine();
        int index = 0;
        for (Admin a : adminList) {
            if (a.getLoginID() != null && a.getLoginID().matches(current.getName())) {
                adminList.get(index).setPassword(toUpdate);
                System.out.printf("New Password: %s \n", a.getPassword());
            }
            index++;
        }
    }
}
