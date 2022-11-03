package deonAssignment;
import java.util.*;

public class Cinema 
{
	private int cinemaId;
	private int status; // 1 means vacant, 0 means taken
	private int seatCount;
	//private int availSeats;
	//private int unavailSeats;
	//private String cinemaLocation;
	private String cinemaClass;
	
	
	public Cinema(int cinemaId)
	{
		this.cinemaId = cinemaId;
	}
	
	public int getCinemaId()
	{
		return cinemaId;
	}
	
	public void setCinemaId(int cinemaId) 
	{
		this.cinemaId = cinemaId;
	}
	
	public int getSeatCount()
	{
		return seatCount;
	}
	
	public void setSeatCount(int status) 
	{
		this.seatCount = seatCount;
	}
	
	public int getStatus()
	{
		return status;
	}
	
	public void setStatus(int status) 
	{
		this.status = status;
	}
	
	public String getCinemaClass()
	{
		return cinemaClass;
	}
	
	public void setCinemaClass(String cinemaClass) 
	{
		this.cinemaClass = cinemaClass;
	}
	
	public static void cinemaLayout()
	{
		int size=50; //seatCount
		int layout[]=new int[size];
		int s=1;
		int seatId=26; //get from ticket class
		//Assigning seat numbers
		for(int i=0;i<size;i++)
		{
				layout[i]=s++;
		}
		//Printing layout
		System.out.println("             Screen             ");
		System.out.println("--------------------------------");
		for(int i=0;i<size;i++)
		{
			if(layout[i]==seatId)
				layout[i]=00; //00 means taken
			if(layout[i]<10)
			{
				if(layout[i]==5)
					System.out.print("0"+layout[i]+"  ");
				else
					System.out.print("0"+layout[i]+"|");
			}
			else if(layout[i]%10==5||layout[i]==5)
				System.out.print(layout[i]+"  ");
			else
			{
				System.out.print(layout[i]+"|");
				if(layout[i]%10==0)
					System.out.print("\n");
			}
		}
		System.out.print("\n");
	}
	
	public static void main(String[] args) //For testing
	{
		cinemaLayout();
	}
}
