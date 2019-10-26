import java.io.File;
import java.io.FileNotFoundException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Scanner;
import java.util.TreeMap;

@SuppressWarnings("deprecation")
public class DateTimeTwo {
	
	public DateTimeTwo()
	{
		
	}
	
	public void daysOfCurrentMonth() {
		
		String tenthDay;
		String eighteenthtDay;
		
		Date tenth = new Date();
		tenth.setDate(10);//set the day to the 10th
		
		Date eighteenth = new Date();
		eighteenth.setDate(18);//set the day to the 18th
		
		SimpleDateFormat day = new SimpleDateFormat("EEEEEEEEE");
		
		tenthDay = (day.format(tenth)).toUpperCase();
		eighteenthtDay = (day.format(eighteenth).toUpperCase());
		
		System.out.println("The tenth day of this month is " + tenthDay + " and eighteenth is " + eighteenthtDay);
	}

	public void daysOfAnyMonth(int i, int j) {
		Date givenDate = new Date();
		givenDate.setDate(15);//since we want to find the fifteenth day
		givenDate.setMonth(i - 1);
		givenDate.setYear(j - 1900);
		
		SimpleDateFormat day = new SimpleDateFormat("EEEEEEEEE");
		
		String fifteenthDay = (day.format(givenDate)).toUpperCase();
		
		//the months that have 31: september, april, june, november, and fubruary
		if(givenDate.getMonth() != 1 || givenDate.getMonth() != 8 || givenDate.getMonth() != 3
				|| givenDate.getMonth() != 5 || givenDate.getMonth() != 10)
			givenDate.setDate(31);
		else if(givenDate.getMonth() == 1) // make sure its not febuary (we're gonna act like leap year is fake)
			givenDate.setDate(28);
		else
			givenDate.setDate(30);
		
		String lastDay = (day.format(givenDate)).toUpperCase();
		
		System.out.println("For the year (" + (givenDate.getYear() + 1900) + ") and month (" 
				+ (givenDate.getMonth() + 1) + "), the fifteenth day is " + 
				fifteenthDay + " and the last day is " + lastDay);
	}

	public void compareYear() {
		Date today = new Date();
//		ArrayList<String> dates = new ArrayList<String>();
//		ArrayList<String> years = new ArrayList<String>();
//		SimpleDateFormat year = new SimpleDateFormat("yyyy");
		HashMap<LocalDate, Integer> dates = new HashMap<LocalDate, Integer>();
		
		//read in the file and put it in an array list so I don't have to deal with resizing
		try {
			File given = new File("Dates.txt");
			Scanner in = new Scanner(given);
			boolean hasNext = in.hasNext();
			int i = 0;
			
			while(hasNext)
			{
				//get the whole string
				String whole = in.next();//as in the whole enchilada
				//split it into its components
				String[] parts = whole.split("\\.");
				
				//store those components as integers for the local date constructor
				int month = Integer.parseInt(parts[0]);
				int day = Integer.parseInt(parts[1]);
				int year = Integer.parseInt(parts[2]);
				
				//make the date from the read in integers
				LocalDate huh = LocalDate.of(year, month, day);
				
				//add them to the Hashmap
				dates.put(huh, i);
				
				//find out if theres more to be read
				hasNext = in.hasNext();
				//increase the counter for key
				++i;
			}
			
			in.close();
			
			for (LocalDate key : dates.keySet()) 
			{
			    System.out.println(key.toString() + ":" + dates.get(key));
			}
			
		} catch (FileNotFoundException e) {
			System.out.println("Something went wrong reading the file....");
		}
	}

	public void dateHashMap() {
		
		Date today = new Date();
		HashMap<LocalDate, Integer> dates = new HashMap<LocalDate, Integer>();
		
		//read in the file and put it in an array list so I don't have to deal with resizing
		try {
			File given = new File("Dates.txt");
			Scanner in = new Scanner(given);
			boolean hasNext = in.hasNext();
			int i = 0;
			
			while(hasNext)
			{
				//get the whole string
				String whole = in.next();//as in the whole enchilada
				//split it into its components
				String[] parts = whole.split("\\.");
				
				//store those components as integers for the local date constructor
				int month = Integer.parseInt(parts[0]);
				int day = Integer.parseInt(parts[1]);
				int year = Integer.parseInt(parts[2]);
				
				//make the date from the read in integers
				LocalDate huh = LocalDate.of(year, month, day);
				
				//add them to the Hashmap
				dates.put(huh, i);
				
				//find out if theres more to be read
				hasNext = in.hasNext();
				//increase the counter for key
				++i;
			}
			
			in.close();
			
			//this will sort it based on the keys
			TreeMap<LocalDate, Integer> sorted = new TreeMap<LocalDate, Integer>(dates);
			
			
			
			for (LocalDate key : sorted.keySet()) 
			{
			    System.out.println(key.toString() + ":" + sorted.get(key));
			}
			
		} catch (FileNotFoundException e) {
			System.out.println("Something went wrong reading the file....");
		}
		
	}

}
