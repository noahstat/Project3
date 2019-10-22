import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.TimeZone;

@SuppressWarnings("deprecation")
public class DateTimeOne extends MesoDateTimeOneAbstract
{

	private Date date;
	
	public DateTimeOne()
	{
		//creates a new date
		this.date = new Date();
	}
	
	@Override
	int getValueOfSecond() {
		//returns the seconds from the date created 
		return date.getSeconds();
	}

	@Override
	void dateTimeNow() {
		//Current Date/Time: 10/10/2019 06:24 PM
		//month/day/year hour:minute am/pm
		SimpleDateFormat form = new SimpleDateFormat("MM/dd/yyyy HH:mm a");
		String output = "Current Date/Time: " + form.format(date);
		System.out.println(output);
		
	}

	@Override
	void sleepForFiveSec() {
		//waits for 5_000 milliseconds or five seconds
		try {
			date.wait(5_000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	/* The output is here (pls look at the text sample, if needed).
	Time on Server: 15:14
	GMT: 20:14
	BST (90E): 2:14
	CST (90W): 15:14
 */
	
	@Override
	void dateTimeOfOtherCity() {
		SimpleDateFormat time = new SimpleDateFormat("HH:mm");
		String server = time.format(date);
		System.out.println(server);
		
		time.setTimeZone(TimeZone.getTimeZone("GMT"));
		String gmt = "GMT: " + time.format(date);
		System.out.println(gmt);
		
		time.setTimeZone(TimeZone.getTimeZone("BST"));
		String bst = "BST (90E): " + time.format(date);
		System.out.println(bst);
		
		time.setTimeZone(TimeZone.getTimeZone("CST"));
		String cst = "CST (90W): " + time.format(date);
		System.out.println(cst);
		
		//.setTimeZone(TimeZone.getTimeZone("GMT"));
	}

	@Override
	void dateTimeDifferentZone() {
		SimpleDateFormat time = new SimpleDateFormat("MM/dd/yyyy HH:mm");
		
		time.setTimeZone(TimeZone.getTimeZone("GMT"));
		String gmt = "GMT: " + time.format(date);
		System.out.println(gmt);
		
		time.setTimeZone(TimeZone.getTimeZone("BST"));
		String bst = "BST (90E): " + time.format(date);
		System.out.println(bst);
		
		time.setTimeZone(TimeZone.getTimeZone("CST"));
		String cst = "CST (90W): " + time.format(date);
		System.out.println(cst);
		
	}

	@Override
	void timeZoneHashMap() {
		HashMap<String, String> timeZones = new HashMap<String, String>(3);
	}
   
}