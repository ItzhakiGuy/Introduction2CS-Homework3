/**
* Course: Intro To Computer Science
* Homework: 3
* Task: 1
* Name: Guy Itzhaki
* E-mail: itzhaki1234@gmail.com
*/

/** Handles calendars and calendric calculations. */
public class Calendar 
{	
	// Starting the calendar on 1/1/1900
	static int dayOfMonth = 1; 
	static int month = 1;
	static int year = 1900;
	static int dayOfWeek = 2;     // 1.1.1900 was a Monday
	static int nDaysInMonth = 31; // Number of days on January
	
	/** Prints the calendar and the number of Sundays that fell on the first day of the month
	 * during the 20th century (from 1/1/1901 till 31/12/2000)
	 */
    public static void main(String args[])
    {
		// Advances the date and the day-of-the-week from 1.1.1900 till 31.12.1900 (inclusive).
		while (year < 1901)
		{
			advance();
		}
		int nSundaysOnFirstOfMonth=0;
		
		// Advances the date and the day-of-the-week throughout the 20th century.
	    // Prints each date in a separate row. If the day is a Sunday, prints "Sunday".
	    // Counts Sundays that fell of the first of the month.
		while (year < 2001)
		{
			if (dayOfMonth==1 && dayOfWeek==1) //Check if the first day of the month is Sunday 
				nSundaysOnFirstOfMonth++;
			advance();
		}
		// Implementation tip: except for nSundaysOnFirstOfMonth, this function has no local variables.
		// All the variables that it uses are the static variables defined at the class level.  
				
		System.out.println("The number of times that was the special Sunday is:"+nSundaysOnFirstOfMonth);
	 }
	
	 // Advances the date and the day-of-the-week.
	 // If the month changes, sets the number of days in this month.
	 // Side effects: changes the static variables dayOfMonth, month, year, dayOfWeek, nDaysInMonth.
	 private static void advance() 
	 {
	 	for (int i=1; i<=nDaysInMonth; i++) //Advance the month
		{
			dayOfMonth++;
			if (dayOfWeek!=7)
				dayOfWeek++;
			else
				dayOfWeek=1;
		}
		if (month==12) //If the year finished
		{
			year++;
			month=1;
			dayOfMonth=1;
			if (dayOfWeek!=7)
				dayOfWeek++;
			else
				dayOfWeek=1;
			nDaysInMonth=nDaysInMonth(month, year);
		}
		else
		{
			month++;
			dayOfMonth=1;
			if (dayOfWeek!=7)
				dayOfWeek++;
			else
				dayOfWeek=1;
			nDaysInMonth=nDaysInMonth(month, year);
		}
	 }

	 /** Returns true if the given year is a leap year, false otherwise. */
	 public static boolean isLeapYear(int year) 
	 {
		boolean isLeap;
		isLeap = ((year % 4) == 0) && ((year % 100) != 0);
		isLeap = isLeap || ((year % 400) == 0);
		return isLeap;
	 }
		 
	 /** Returns the number of days in the given month, in the given year. */
	 public static int nDaysInMonth(int month, int year) 
	 {
		 switch (month)
		{	
			case 1: return 31;
          	case 2: if (isLeapYear(year))
				return 29;
			else
				return 28;
           	case 3: return 31;
         	case 4: return 30;		
         	case 5: return 31;	
          	case 6: return 30;	
        	case 7: return 31;
         	case 8: return 31;		
       		case 9: return 30;
			case 10: return 31;
			case 11: return 30;
			case 12: return 31;	
		}	
		 return 0;
	 }
}
