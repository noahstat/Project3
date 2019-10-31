# Project3

DateSortingUsingAlgorithm
  dateHashMapSortedDescending()
    This method reads in the given file parsing the date into it's components and then stores
    them in a TreeMap that has the reverse sorting order and then prints out all of the 
    elements in the map on their own line
    
  dateHashMapSorted()
    This method reads in the given file parsing the date into it's components and then stores
    them in a TreeMap and then prints out all of the elements in the map on their own line
    
DateTimeOne
  private Date date
    this variable stores the current date
    
  DateTimeOne()
    sets date to the current date
    
  getValueOfSecond()
    returns the value of the current dates' seconds
    
  dateTimeNow()
    prints out the current time in format "Current Date/Time: MM/dd/yyyy hh:mm a"
    
  sleepForFiveSec()
    if we are too close to the next minute we wait for five seconds(5_000 milliseconds)
    
DateTimeTwo
  DateTimeTwo()
    Blank default constructor
  
  daysOfCurrentMonth()
    finds the tenth and eighteenth day by setting the current day to that and formatting the 
    resulting date
    
  daysOfAnyMonth(int i, int j)
    finds the last and fifteenth day by setting the current date to the given integers and 
    the day wanted. For the last day we check if it is a month with 30 days, 28 days or 
    29 days(Leap years) and then formatting the resulting date
    
  compareYear()
    This method reads in the given file parsing the date into it's components and then stores
    them in a HashMap<LocalDate, Integer>. Then we iterate over the elements in the map and 
    subtract the miliseconds and if it is a leap year it prints out that it is and then the 
    difference in millis as a new date with that many milliseconds
    
  dateHashMap()
    This method reads in the given file parsing the date into it's components and then stores
    them in a HashMap<LocalDate, Integer>. Then it iterates over the map printing out in the
    format "key:Value"
    
  dateHashMapSorted()
    This method reads in the given file parsing the date into it's components and then stores
    them in a HashMap<LocalDate, Integer>. Then it puts all of the elements into a TreeMap then 
    iterates over the map printing out in the format "key:Value"
    
Main
  Given, runs the program
  
MesoAsciiAbstract
  calAverage()
    Abstract method
   
MesoAsciiCal extends MesoAsciiAbstract
  private String STID
    this holds the ID of the station
    
	private String NRMN
    stores the constant NRMN for the default constructor
    
  MesoAsciiCal(MesoStation mesoStation)
    sets STID to the ID of the given MesoStation
    
  MesoAsciiCal(String stId2)
    Sets STID to the given string
    
  MesoAsciiCal()
    sets STID to NRMN
    
  calAsciiEqual()
    Reads in the given file checking to see if there are any integers in the read in 
    protion and if not it finds the average of the chars and compares it to the average
    of the station ID and if it is equal adds it to a hashmap
    
    calAverage()
      finds the three averages and then averages them to return the average
      
MesoDateTimeOneAbstract
  getValueOfSecond();
    Abstract method
    
	dateTimeNow();
    Abstract method
    
	sleepForFiveSec();
    Abstract method
    
	dateTimeOfOtherCity();
    Abstract method
    
	dateTimeDifferentZone();
    Abstract method
    
	timeZoneHashMap();
    Abstract method

MesoEquivialent
  private String stId
    Holds the current station ID
    
  MesoEquivalent(String stId)
    sets stid to the given stid
    
  calAsciiEqual()
    Reads in the given file checking to see if there are any integers in the read in 
    protion and if not it finds the average of the chars and compares it to the average
    of the station ID and if it is equal adds it to a hashmap
    
MesoLexicographical extends MesoSortedAbstract
  private HashMap<String, Integer> map
    holds the given map and sorts it using TreeMap and then prints it out

  sortedMap(HashMap<String, Integer> unsorted) 
    takes the given map and sorts it using TreeMap and then prints it out

MesoSortedAbstract
  sortedMap(HashMap<String, Integer> unsorted)
    abstract method
    
MesoStation
  private String stID
    Holds the current station ID
  
  MesoStation(String stId)
    Holds the current station ID
    
  getStID()
    returns the stId
