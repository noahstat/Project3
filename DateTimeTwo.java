import java.text.SimpleDateFormat;
import java.util.Date;

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
		// TODO Auto-generated method stub
		
	}

	public void dateHashMap() {
		// TODO Auto-generated method stub
		
	}

}
