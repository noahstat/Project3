import java.io.File;
import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Scanner;
import java.util.TreeMap;

public class DateSortingUsingAlgorithm {

	private TreeMap<LocalDate, Integer> holding;
	
	public void dateHashMapSortedDescending() {
		//new TreeMap<String, String>(Collections.reverseOrder())
		
		try {
			Scanner in = new Scanner(new File("SortingDates.txt"));
			//I made a linked hashmap to preserve the order that I put them in
			holding = new TreeMap<LocalDate, Integer>(Collections.reverseOrder());
			String whole = "";
			Integer i = 0;
			
			while(in.hasNext())
			{
				//get the whole string
				whole = in.next();//as in the whole enchilada
				
				if(!whole.isBlank())//make sure it is not just whitespace
				{
					//split it into its components
					String[] parts = whole.split("-");
					
					//store those components as integers for the local date constructor
					int month = Integer.parseInt(parts[1]);
					int day = Integer.parseInt(parts[2]);
					int year = Integer.parseInt(parts[0]);
					
					//make the date from the read in integers
					LocalDate huh = LocalDate.of(year, month, day);
					
					//add them to the Arraylist
					holding.put(huh, i);
					++i;
				}
			}
			
			for (LocalDate stIds : holding.keySet())
			{
			    System.out.println(stIds + " " + holding.get(stIds));		    
			}
			
			in.close();
		} catch (FileNotFoundException e) {
			System.out.println("Whoops! You suck!! But don't worry it'll be okay!");
		}
		
	}

	public void dateHashMapSorted() {
		try {
			Scanner in = new Scanner(new File("SortingDates.txt"));
			//I made a linked hashmap to preserve the order that I put them in
			holding = new TreeMap<LocalDate, Integer>();
			String whole = "";
			Integer i = 0;
			
			while(in.hasNext())
			{
				//get the whole string
				whole = in.next();//as in the whole enchilada
				
				if(!whole.isBlank())//make sure it is not just whitespace
				{
					//split it into its components
					String[] parts = whole.split("-");
					
					//store those components as integers for the local date constructor
					int month = Integer.parseInt(parts[1]);
					int day = Integer.parseInt(parts[2]);
					int year = Integer.parseInt(parts[0]);
					
					//make the date from the read in integers
					LocalDate huh = LocalDate.of(year, month, day);
					
					//add them to the Arraylist
					holding.put(huh, i);
					++i;
				}
			}
			
			for (LocalDate stIds : holding.keySet())
			{
			    System.out.println(stIds + " " + holding.get(stIds));		    
			}
			
			in.close();
		} catch (FileNotFoundException e) {
			System.out.println("Whoops! You suck!! But don't worry it'll be okay!");
		}

	}
	
//	private void quicksort(int lowerIndex, int higherIndex)
//		{
//		int i = lowerIndex;
//        int j = higherIndex;
//        // calculate pivot number, I am taking pivot as middle index number
//        int pivot = holding.get(lowerIndex+(higherIndex-lowerIndex)/2).getYear();
//        // Divide into two arrays
//        while (i <= j) {
//            
//            //find a number from left side bigger than the pivot value
//            //and find a number 
//            //from right side which is less then the pivot value
//        	
//            while (holding.get(i).getYear() < pivot) {
//                i++;
//            }
//            while (holding.get(j).getYear() > pivot) {
//                j--;
//            }
//            if (i <= j) {
//                
//            	//switch the numbers
//                int temp = i;
//                i = j;
//                j = temp;
//                
//                //move index to next position on both sides
//                i++;
//                j--;
//            }
//        }
//        // call quickSort() method recursively
//        if (lowerIndex < j)
//            quicksort(lowerIndex, j);
//        if (i < higherIndex)
//            quicksort(i, higherIndex);
//		}
}
