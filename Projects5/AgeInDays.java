// Eric Tsai
// etsai7
// CS 107
// Hw 5 Task2

import java.util.Scanner;

public class AgeInDays{
   
   public static void main(String [] args){
      
      int daysSince = 0;
      
      System.out.println("This program will tell you your age in days.");
      System.out.println("Please enter today's date: ");
      Scanner keyboard = new Scanner(System.in);
      int year = 0;
      int month = 0;
      int day = 0;
      while(year < 1582){//User year input
         System.out.print("What is the year (1582 or higher)? ");
         year = keyboard.nextInt();
      }
      while(month < 1 || month > 12){
         System.out.print("What is the month (1-12)? ");
         month = keyboard.nextInt();
      }
//Different prints due to different months
      day = getDays(month,year);
      
      System.out.printf("%02d/%02d/" + year + " is day #" + getAbsoluteDayNumber(year, month,day) + " of 365\n", month, day);
      
//--------------------------------------------------------- Birthdate
      int birthYear = 0;
      int birthMonth = 0;
      int birthDate = 0;
      int daysSinceBirth = 0;
      
      System.out.println("\nPlease enter your date of birth: ");
      if(((month == 1) && (day == 1))){
         while(birthYear < 1582 || birthYear >= year ){//User year input
            System.out.print("What is the year (1582-" + year +")?");
            birthYear = keyboard.nextInt();
         }
      }
      else{
         while(birthYear < 1582 || birthYear > year ){//User year input
            System.out.print("What is the year (1582-" + year +")?");
            birthYear = keyboard.nextInt();
         }
      }
      if(birthYear == year){
         while((((month == 1) && (day == 1))|| birthMonth < 1 || birthMonth > 12) || (birthMonth > month)){
            System.out.print("What is the month (1-" + month+")?");
            birthMonth = keyboard.nextInt();
         }
      }
      else{
         while((birthMonth < 1 || birthMonth > 12)){
            System.out.print("What is the month (1-12)? ");
            birthMonth = keyboard.nextInt();
         }
      }
      if(birthMonth == month){
         birthDate = getBirthDays(birthMonth,birthYear, day);
      }
      else{
         birthDate = getDays(birthMonth,birthYear);
      }
      
      System.out.printf("%02d/%02d/" + birthYear + " is day #" + getAbsoluteDayNumber(birthYear, birthMonth,birthDate) + " of 365", birthMonth, birthDate);
      
      System.out.println("\nYour age is "+ getAgeInDays(year, birthYear, month, birthMonth, getAbsoluteDayNumber(year, month,day), getAbsoluteDayNumber(birthYear, birthMonth,birthDate)) + " day(s)");

   }
//---------------------------------------------------------  
   /**
      Check if a given year contains a date called February 29th.
      If the specified year is earlier than 1582, the behavior of this
      method is undefined (so there is no need to check for this).
      @param year the year, an integer from 1582 onward
      @return true exactly if the year contains February 29th
   */ 
   public static boolean isLeapYear(int year){
   
      if(year % 400 == 0){ //divisible by 400
         return true;
      }else if (year % 100 == 0){ //divisible by by 100 but not 100.
         return false;
      }else if (year % 4 == 0){ // divisible b 4 and not 100 or 400.
         return true;
      }else{//not divisible to 400, 100, or 4.
         return false;
      }
   }
//---------------------------------------------------------   
   /**
      Return the number of days in a specified month for a specified year.
      @param year the year, an integer from 1582 onward
      @param month the number of the month, between 1 and 12 inclusive
      @return the number of days in that month during that year
   */
   
   public static int numDaysInMonth(int year, int month){
      if(isLeapYear(year)){
         switch(month){
         case 1:
         return 31;
         
         case 2:
         return 29;
         
         case 3:
         return 31;
         
         case 4:
         return 30;
         
         case 5:
         return 31;
         
         case 6: 
         return 30;
         
         case 7:
         return 31;
         
         case 8:
         return 31;
         
         case 9:
         return 30;
         
         case 10:
         return 31;
         
         case 11:
         return 30;
         
         case 12:
         return 31;
       }

      }
      else{
         switch(month){
         case 1:
         return 31;
         
         case 2:
         return 28;
         
         case 3:
         return 31;
         
         case 4:
         return 30;
         
         case 5:
         return 31;
         
         case 6: 
         return 30;
         
         case 7:
         return 31;
         
         case 8:
         return 31;
         
         case 9:
         return 30;
         
         case 10:
         return 31;
         
         case 11:
         return 30;
         
         case 12:
         return 31;
       }

      }
      return 0;
   }

//---------------------------------------------------------     
   public static int getDays(int month, int year){
      Scanner keyboard= new Scanner(System.in);
      int day = 0;
      switch(month){
         case 1: 
          while(day < 1 || day > 31){
             System.out.print("What is the day (1-31)? ");
              day = keyboard.nextInt();
             //return day;
         }
         break;
         
         case 3: 
         while(day < 1 || day > 31){
             System.out.print("What is the day (1-31)? ");
              day = keyboard.nextInt();
         }
         break;
         
         case 4: 
         while(day < 1 || day > 30){
             System.out.print("What is the day (1-30)? ");
              day = keyboard.nextInt();
         }
         break;
         
         case 5: 
         while(day < 1 || day > 31){
             System.out.print("What is the day (1-31)? ");
              day = keyboard.nextInt();
         }
         break;
         
         case 6: 
         while(day < 1 || day > 30){
             System.out.print("What is the day (1-30)? ");
              day = keyboard.nextInt();
         }
         break;
         
         case 7: 
         while(day < 1 || day > 31){
             System.out.print("What is the day (1-31)? ");
             day = keyboard.nextInt();
         }
         break;
         
         case 8: 
         while(day < 1 || day > 31){
             System.out.print("What is the day (1-31)? ");
             day = keyboard.nextInt();
         }
         break;
         
         case 9: 
         while(day < 1 || day > 30){
             System.out.print("What is the day (1-30)? ");
             day = keyboard.nextInt();
         }
         break;
         
         case 10: 
         while(day < 1 || day > 31){
             System.out.print("What is the day (1-31)? ");
             day = keyboard.nextInt();
         }
         break;
         
         case 11: 
         while(day < 1 || day > 30){
             System.out.print("What is the day (1-30)? ");
             day = keyboard.nextInt();
         }
         break;
         
         case 12: 
         while(day < 1 || day > 31){
             System.out.print("What is the day (1-31)? ");
             day = keyboard.nextInt();
         }
         break;
      }
      
      if(isLeapYear(year) && month == 2){
         while(day < 1 || day > 29){
             System.out.print("What is the day (1-29)? ");
              day = keyboard.nextInt();
         }
      }
      else if(month == 2){
         while(day < 1 || day > 28){
            System.out.print("What is the day (1-28)? ");
             day = keyboard.nextInt();
         }
      }
      
      return day;
   }
//---------------------------------------------------------    
   public static int getBirthDays(int month, int year,int today){
      Scanner keyboard= new Scanner(System.in);
      int day = 0;
      switch(month){
         case 1: 
          while((day < 1 || day > 31) || (day >= today)){
             System.out.print("What is the day (1-" + (today-1) + ")? ");
              day = keyboard.nextInt();
             //return day;
         }
         break;
         
         case 3: 
         while((day < 1 || day > 31) || (day >= today)){
             System.out.print("What is the day (1-" + (today-1) +")? ");
              day = keyboard.nextInt();
         }
         break;
         
         case 4: 
         while((day < 1 || day > 30) || (day >= today)){
             System.out.print("What is the day (1-" + (today-1)+")? ");
              day = keyboard.nextInt();
         }
         break;
         
         case 5: 
         while((day < 1 || day > 31) || (day >= today)){
             System.out.print("What is the day (1-" + (today-1)+")? ");
              day = keyboard.nextInt();
         }
         break;
         
         case 6: 
         while((day < 1 || day > 30) || (day >= today)){
             System.out.print("What is the day (1-" + (today-1)+")? ");
              day = keyboard.nextInt();
         }
         break;
         
         case 7: 
         while((day < 1 || day > 31) || (day >= today)){
             System.out.print("What is the day (1-" + (today-1)+")? ");
             day = keyboard.nextInt();
         }
         break;
         
         case 8: 
         while((day < 1 || day > 31) || (day >= today)){
             System.out.print("What is the day (1-" + (today-1)+")? ");
             day = keyboard.nextInt();
         }
         break;
         
         case 9: 
         while((day < 1 || day > 30) || (day >= today)){
             System.out.print("What is the day (1-" + (today-1)+")? ");
             day = keyboard.nextInt();
         }
         break;
         
         case 10: 
         while((day < 1 || day > 31) || (day >= today)){
             System.out.print("What is the day (1-" + (today-1)+")? ");
             day = keyboard.nextInt();
         }
         break;
         
         case 11: 
         while((day < 1 || day > 30) || (day >= today)){
             System.out.print("What is the day (1-" + (today-1)+")? ");
             day = keyboard.nextInt();
         }
         break;
         
         case 12: 
         while((day < 1 || day > 31) || (day >= today)){
             System.out.print("What is the day (1-" + (today-1)+")? ");
             day = keyboard.nextInt();
         }
         break;
      }
      
      if(isLeapYear(year) && month == 2){
         while((day < 1 || day > 29) || (day >= today)){
             System.out.print("What is the day (1-" + (today-1)+")? ");
              day = keyboard.nextInt();
         }
      }
      else if(month == 2){
         while((day < 1 || day > 28) || (day >= today)){
            System.out.print("What is the day (1-" + (today-1)+")? ");
             day = keyboard.nextInt();
         }
      }
      
      return day;
   }
   /**
      Check if the specified candidate String contains only symbols
      that appear in the specified base String.
      @param year the year, an integer from 1582 onward
      @param month the number of the month, between 1 and 12 inclusive
      @param day the day of the month, between 1 and 31 inclusive
      @return the absolute day number of this date within the
      specified year
   */
   public static int getAbsoluteDayNumber(int year, int month, int day){
        int daysSince = 0;
      if(isLeapYear(year)){
         for(int i = 1; i < month; i++){
            daysSince = daysSince + numDaysInMonth(year,i);
         }
         daysSince = daysSince + day;
         //System.out.printf("%02d/%02d/" + year + " is day #" + daysSince + " of 366", month,day);
      }
      else{
         for(int i = 1; i < month; i++){
            daysSince = daysSince + numDaysInMonth(year,i);
         }
         daysSince = daysSince + day;
         //System.out.printf("%02d/%02d/" + year + " is day #" + daysSince + " of 365", month,day);
         //System.out.println();
      }
      return daysSince;
   }
   
//---------------------------------------------------------  
   /**
      Compute a personÕs age in days.
      @param todayYear todayÕs year
      @param todayMonth todayÕs month
      @param todayDay todayÕs day of the month
      @param birthYear year of birth date
      @param birthMonth month of birth date
      @param birthDay day of the month of birth date
      @return the number of days from the date of birth to today
   */

   public static long getAgeInDays(int todayYear,int birthYear, int todayMonth,int birthMonth, int todayDay, int birthDay){
      int days = 0;
      for(int i = birthYear; i < todayYear; i++){
         
         if(isLeapYear(i)){
            days = days + 366;
         }
         else{
            days = days + 365;
         }
      }
      
      days = days - birthDay + todayDay;
      
      return days;
      

   }   

}