package Boundary;

//import Body.*;
import java.util.Scanner;

public class MainMenuUI {
	public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        boolean loop = true;
        String accType = null;
        System.out.println("MOBLIMA");
        LoginUI login= new LoginUI();
        while(loop){
            System.out.println("(1) Customer or (2) Admin:");
            accType = sc.nextLine();
            accType.toLowerCase();
            if(accType.equals("customer") || accType.equals("admin") || accType.equals("1") || accType.equals("2")){
                loop = false;
            }
        }
        
        if (accType.equals("1") || accType.equals("customer")) {
        	//call CustomerLogin?
        }
        else {
        	//call AdminLogin?
        }
	}
}
