import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.TimeZone;
import java.util.TreeMap;

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
		SimpleDateFormat form = new SimpleDateFormat("MM/dd/yyyy kk:mm a");
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
		SimpleDateFormat time = new SimpleDateFormat("kk:mm");
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
		SimpleDateFormat time = new SimpleDateFormat("MM/dd/yyyy kk:mm");
		
		HashMap<String, String> timeZones = new HashMap<String, String>(5);
		
		//add all of the elements we needed
		timeZones.put("GMT", date.toString());//these use date and then we will change the 
		timeZones.put("BST", date.toString());//given time zone later
		timeZones.put("CST", date.toString());
		
		time.setTimeZone(TimeZone.getTimeZone("GMT"));
		String gmt = "GMT: " + time.format(new Date(timeZones.get("GMT")));
		System.out.println(gmt);
		
		time.setTimeZone(TimeZone.getTimeZone("BST"));
		String bst = "BST (90E): " + time.format(new Date(timeZones.get("BST")));
		System.out.println(bst);
		
		time.setTimeZone(TimeZone.getTimeZone("CST"));
		String cst = "CST (90W): " + time.format(new Date(timeZones.get("CST")));
		System.out.println(cst);
		
	}

	@Override
	void timeZoneHashMap() {
		//make the hashmap of string string
		HashMap<String, String> timeZones = new HashMap<String, String>(4);
		
		//add all of the elements we need
		
		timeZones.put("AMT", "10/01/2020 19:59");//given "Time zone"
		timeZones.put("BST", date.toString());//these use date and then we will change the 
		timeZones.put("CST", date.toString());//given time zone later
		timeZones.put("GMT", date.toString());
		timeZones.put("ZMT", "11/05/2018 19:59");//given "Time zone"
		
		//set up all of the formats that we need
		SimpleDateFormat style1 = new SimpleDateFormat("z MM/dd/yyyy kk:mm");
		SimpleDateFormat style3 = new SimpleDateFormat("MM/dd/yyyy kk:mm");
		SimpleDateFormat style5 = new SimpleDateFormat("yyyy-MM-dd'T'kk:mm");
		
		//we need to sort the array based on the first letter of the timeZone
		TreeMap<String, String> sorted = new TreeMap<>();
		sorted.putAll(timeZones);//fill with the data from timeZones

		//Style 1
		System.out.println("Print Style 1:");
		for(Map.Entry<String, String> entry : sorted.entrySet())
		{
			System.out.println(entry.getKey() + " " + style1.format(
					new Date(sorted.get(entry.getKey()))));
		}
		
		
		//Style3
		System.out.println("Print Style 3:");
		for(Map.Entry<String, String> entry : sorted.entrySet())
		{
			System.out.println(entry.getKey() + " " + style3.format(
					new Date(sorted.get(entry.getKey()))));
		}
		
		
		//Style5
		System.out.println("Print Style 5: Final sorted Array:");
		for(Map.Entry<String, String> entry : sorted.entrySet())
		{
			System.out.println(entry.getKey() + " " + style5.format(
					new Date(sorted.get(entry.getKey()))));
		}
	}
   
}