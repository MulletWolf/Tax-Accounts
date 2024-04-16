import java.util.Arrays;//package for arrays

import javax.swing.JOptionPane;//package for JOptionPane
//All code except some was written by Sofia Fedchuk

public class TaxAccount {//class
	    static double[] revenueArray;//written by Diana Ogualiri-to make sure this variable is visible in all methods(global scope)
	public static void main(String[] args) {//main method
	String yearPrompt = "Enter the year , please";
	String year = JOptionPane.showInputDialog(null, yearPrompt);
	
	fillArray();//calls method for filling the array
	printArray();//calls method for printing the array
	
	String description="Calculate a user’s tax liability for one year, January to December for the year: "+year;//Description of our program
	JOptionPane.showMessageDialog(null, description );
	double average = calculateAverage();//value of average
	double min_tax=getLowestTax();//value of lowest tax
	double max_tax=getHighestTax();//value of highest tax
	double sum=calculateTotalRevenue();//value of total revenue for the year
	String average_prompt = "The average revenue intake per month across the year is "+average;//prompt for average revenue
	String minAndmaxtax_prompt = "The highest tax of the year is "+max_tax+"\n"+"The lowest tax of the year is "+min_tax;//prompt for lowest and highest tax
	String sum_prompt = "The revenue in total for the year is "+sum;//prompt for total revenue
	String warning= "You should pay taxes before the deadline of January 31";//warning for business owners

	JOptionPane.showMessageDialog(null, minAndmaxtax_prompt);
	JOptionPane.showMessageDialog(null, average_prompt);
	JOptionPane.showMessageDialog(null, sum_prompt);
	JOptionPane.showMessageDialog(null, warning);
		}//end main method
	public static void fillArray() {//to fill up array to call in the static main
		
		//prompt the user to tell us how much revenue we want each month 
	String revenue_prompt= "Enter sale figure for this month, please: ";
	
	double nextRevenue=0.0;//double because revenue could be double digits
	 revenueArray= new double[12];//size of months is 12
	 
	 for(int i=0; i<revenueArray.length; i++) {//iterative=repeat multiple times array and filling up each space of revenue
	
		 nextRevenue=Double.parseDouble(JOptionPane.showInputDialog(null, revenue_prompt));//allows user to input the next revenue for each month
		 revenueArray[i]=nextRevenue;//next height value to slot in the next available space, i=index value in array
		
	  }//end for
	}//end fillArray

	public static void printArray(){// method for printing the array

	String printString ="";//declares that you have a string-empty string
	for(int i=0; i<revenueArray.length; i++) {// for loop-iterative-repeats code multiple times for print array
		
		printString ="Revenue for month "+i+" values is "+revenueArray[i]+"\n";//allows u to move on to the next line
    	JOptionPane.showMessageDialog(null, printString);//shows message of printString

	   }//end for
	}//end printArray

	public static double calculateAverage() {//method that allows user to calculate the average
		 double average = 0.0;//to fill average in double digits
	     double sum=0.0;//to fill sum in double digits
	     for(int i=0; i<revenueArray.length; i++) {
	    	sum+=revenueArray[i];
	    	  
	    }//end for
	    average=sum/12;//formula for average
	    return average;
	}//end calculateAverage
	
	public static double getLowestTax()	{//written by Diana Ogualiri. method for finding the lowest tax
		Arrays.sort(revenueArray);//sort array from smallest value  to largest 
		return revenueArray[0]*0.125;//return value 
	}//end getLowestTax

	public static double getHighestTax() {//written by Diana Ogualiri.method for finding the highest tax
		Arrays.sort(revenueArray);//sorts array from largest to smallest
	      return revenueArray[revenueArray.length-1]*0.125;

	}//end getHighestTax
 
	
	public static double calculateTotalRevenue(){//method for finding the total revenue
		double sum=0.0;
	for(int i=0; i<revenueArray.length; i++){//for loop for calculating total revenue
	sum+=revenueArray[i];
	}//end for

	return sum;

	}//end calculateTotalRevenue

}//end class
