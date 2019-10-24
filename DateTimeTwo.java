import java.io.File;
import java.io.FileNotFoundException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Scanner;

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
		ArrayList<String> dates = new ArrayList<String>();
		ArrayList<String> years = new ArrayList<String>();
		SimpleDateFormat year = new SimpleDateFormat("yyyy");
		HashMap<LocalDate, Integer> toPrint = new HashMap<LocalDate, Integer>();//TODO haven't implemeted this part
		
		try {
			Scanner in = new Scanner(new File("Dates.txt"));
			boolean hasNext = in.hasNext();
			int i = 0;
			
			while(hasNext)
			{
				dates.add(in.next());
				years.add(year.format(dates.get(i)));
				
				hasNext = in.hasNext();
				++i;
			}
			
			in.close();
		} catch (FileNotFoundException e) {
			System.out.println("Something went wrong reading the file....");
		}
		
		for(int i = 0; i < years.size(); ++i)
		{
			String out = "";
			boolean isLeap = false;
			if(((Integer.parseInt(years.get(i))) % 4) == 0)// all leap years are evenly divisible by 4
			{
				isLeap = true;
			}
			
			
			Date given = new Date(years.get(i));
			long diff = today.getTime() - given.getTime();
			Date difference = new Date(diff);
			
			SimpleDateFormat leap = new SimpleDateFormat("' is a leap year, and Difference: 'yyyy' years, 'MM' months, and 'dd' days.'");
			SimpleDateFormat notLeap = new SimpleDateFormat("' is not a leap year, and Difference: 'yyyy' years, 'MM' months, and 'dd' days.'");
			
			if(isLeap)
				out = years.get(i) + leap.format(difference);
			else 
				out = years.get(i) + notLeap.format(difference);
			
			//now we need to use the HashMap to store the data
		}
		
	}

	public void dateHashMap() {
		
		
	}

}
