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
		givenDate.setDate(15);//since we want to find the last day
		givenDate.setMonth(i);
		givenDate.setYear(j);

		SimpleDateFormat day = new SimpleDateFormat("EEEEEEEEE");
		
		String fifteenthDay = (day.format(givenDate)).toUpperCase();
		
		if(givenDate.getMonth() != 2)
			givenDate.setDate(31);
		else
			givenDate.setDate(28);
		
		String lastDay = (day.format(givenDate)).toUpperCase();
		
		System.out.println("For the year (" + givenDate.getYear() + ") and month (" + givenDate.getMonth() + 
				"), the fifteenth day is " + fifteenthDay + " and the last day is " + lastDay);
	}

	public void compareYear() {
		// TODO Auto-generated method stub
		
	}

	public void dateHashMap() {
		// TODO Auto-generated method stub
		
	}

}
