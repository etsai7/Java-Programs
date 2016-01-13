// Eric Tsai
// etsai7
// CS 107
// Hw 2 Task3

import java.util.Scanner;

public class MilitaryTime{

   public static void main(String [] args){
   
   Scanner keyboard = new Scanner(System.in);
   System.out.println("Please enter a time in 24-hour HH:MM format, e.g., 1:02 or 19:56.");
   String time = keyboard.next();
   System.out.println("Next, enter a duration to add to that time. Use HH:MM format.For example, to add two hours and five minutes, type 2:05.");
   String addTime = keyboard.next();
  
   //Converts the time String into Ints
   String hoursOfTime = time.substring(0,time.indexOf(":"));
   int hoursParsed = Integer.parseInt(hoursOfTime);                     
   
   String minutesOfTime = time.substring(time.indexOf(":") + 1);
   int minutesParsed = Integer.parseInt(minutesOfTime);
   
   String addHoursOfTime = addTime.substring(0,addTime.indexOf(":"));
   int addHoursParsed = Integer.parseInt(addHoursOfTime);
   
   String addMinutesOfTime = addTime.substring(addTime.indexOf(":") + 1);
   int addMinutesParsed = Integer.parseInt(addMinutesOfTime);
   
   int totalMinutes = minutesParsed + addMinutesParsed;
   int leftOverMinutes = totalMinutes % 60; //Print this for the minutes
   
   int addHour = totalMinutes / 60;
   int totalHours = addHour + hoursParsed + addHoursParsed;
   int reset = totalHours % 24; //Print this for the hours
   
   //output
   System.out.printf("Okay, the time " + addHoursParsed + " Hours " + addMinutesParsed + " Minutes past " + time + " will be: " +  "%02d" + ":" + "%02d", reset,leftOverMinutes);
   
   }
}