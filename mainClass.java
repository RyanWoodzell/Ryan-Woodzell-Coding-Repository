package project;
import java.util.Scanner;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class mainClass{
	static int y;
	private static final Logger logger = LogManager.getLogger(mainClass.class);
	public static void main(String[] args){
		logger.info("Starting application...");
		//import ReadStudents and establish Arrays within Main Class
		ReadStudents x = new ReadStudents();
		final int [] studentId = x.getStudentId();
	    final String [] firstName = x.getFirstName();
		final String [] lastName = x.getLastName();
		final int [] scienceScore = x.getScienceScore();
		final int [] historyScore = x.getHistoryScore();
		final int [] mathScore = x.getMathematicsScore();
		final int [] englishScore = x.getEnglishScore();
		//Call methods to determine total score and percentages
		double [] percentages = percentage(scienceScore, historyScore, mathScore, englishScore);
		int [] totalScore = totalScore(scienceScore, historyScore, mathScore, englishScore);
		//Call the interface
		Interface(firstName, lastName,studentId, percentages, totalScore,scienceScore, historyScore, mathScore, englishScore);
	}
	public static void Interface(String firstName[], String lastName[], int studentId[], double percentages[], int totalScore[],int scienceScore[],int  historyScore[], int mathScore[],int englishScore[]){
		Scanner scan = new Scanner(System.in);
		boolean again = true;
		//Instruct the users of their possible inputs and what each input returns
		while(again && true) {
		System.out.println("\nWelcome to the Grade Finder!");
		System.out.println("Press 1 to display all students");
		System.out.println("Press 2 to display the students with the top score in history");
		System.out.println("Press 3 to display the students with the top score in science");
		System.out.println("Press 4 to display the students with the top score in math");
		System.out.println("Press 5 to display the students with the top score in english");
		System.out.println("Press 6 to determine pass fail information");
		System.out.println("Press 7 to end program");
		System.out.print("Enter the digit coresponding to what you would like to see: ");
			try {
				y = scan.nextInt();
			
			}catch(Exception e) {
				scan.next();
				System.out.println("Answer must be a specified int.");
			}
		//Interface options. Calls specific methods based on what the user inputs. 
		if (y==1){
			printAll(firstName, lastName, studentId, percentages, totalScore);
				}
		else if (y==2){
			topTenHist(firstName, lastName,studentId, scienceScore, historyScore, mathScore, englishScore);
			} 
		else if (y==3) {
			topTenSci(firstName, lastName,studentId,scienceScore, historyScore,mathScore, englishScore);
		}
		else if (y==4) {
			topTenMath(firstName, lastName,studentId,scienceScore, historyScore,mathScore, englishScore);
		}
		else if (y==5) {
			topTenEng(firstName, lastName,studentId,scienceScore, historyScore,mathScore, englishScore);
		}else if (y==6) {
			passFailHist(historyScore);
			passFailSci(scienceScore);
			passFailMath(mathScore);
			passFailEng(englishScore);
			failTwo(scienceScore, historyScore, mathScore, englishScore);
			
		}
		else if (y==7) {
			System.out.println("Have a great Day!");
			again=false;
		}
		}scan.close();
		}
	
	public static void printAll(String firstName[], String lastName[], int studentId[], double percentage[], int totalScore[]) {
		//Prints all of the original arrays for each and every student. 
		for (int i=0; i<(studentId.length-1); i++) {
			System.out.println("Student ID: " + studentId[i]);
			System.out.println("First Name: " + firstName[i]);
			System.out.println("Last Name: " + lastName[i]);
			System.out.println("Average: " + percentage[i]);
			System.out.println("Total Score: " + totalScore[i]);
			System.out.println();
			}

		}
	public static double [] percentage(int scienceScore[], int historyScore[], int mathScore[], int englishScore[]) { 
	double [] percentages = new double [200];
		//Creates a new array for the percentages of each student. Returns the array
		for (int i=0; i<scienceScore.length; i++ ) {
		int x = scienceScore[i];
		int y = historyScore[i];
		int z = mathScore[i];
		int l = englishScore[i];
		double v = ((x+y+z+l)/4);
		percentages[i] = v;
	}return percentages;
	}
	public static int [] totalScore(int scienceScore[], int historyScore[], int mathScore[], int englishScore[]) { 
		int[] score = new int [200];
		//Creates a new array for the total score of each student
			for (int i=0; i<scienceScore.length; i++ ) {
			//Adds all the scores together
			int x = scienceScore[i];
			int y = historyScore[i];
			int z = mathScore[i];
			int l = englishScore[i];
			int v = ((x+y+z+l));
			score[i] = v;
			
		
		}return score;}
	public static void topTenHist(String firstName[], String lastName[], int studentId[], int scienceScore[], int historyScore[], int mathScore[], int englishScore[]) {
		//Clones the arrays to then bubble sort each array 
		int [] top = historyScore.clone();
		String [] topFName = firstName.clone();
		String [] topLName = lastName.clone();
		int [] topId = studentId.clone();
		int [] a1 = scienceScore.clone();
		int [] a2 = mathScore.clone();
		int [] a3 = englishScore.clone();
		
		
		
		// bubble sort the lists to determine the top ten in each class
		int n = top.length;
		int temp1 = 0;
		int otherScore1 =0;
		int otherScore2 = 0;
		int otherScore3 = 0;
		String first = "";
		String last= "";
		int id = 0;
		for(int i=0; i<n;i++) {
			for(int j =1; j<(n-i); j++) {
				if (top[j-1]<top[j]) {
					temp1 = top[j-1];
					top[j-1] = top[j];
					top[j]=temp1;
					//Sort names and ID's and other scores
					first = topFName[j-1];
					last = topLName[j-1];
					id= topId[j-1];
					otherScore1 = a1[j-1];
					otherScore2 = a2[j-1];
					otherScore3 = a3[j-1];
					//swap to order in order of history score
					topFName[j-1] =topFName[j];
					topLName[j-1] =topLName[j];
					topId[j-1] = topId[j];
					a1[j-1] = a1[j];
					a2[j-1] = a2[j];
					a3[j-1] = a3[j];
					topFName[j]=first;
					topLName[j]=last;
					topId[j]=id;
					a1[j]=otherScore1;
					a2[j]=otherScore2;
					a3[j]=otherScore3;
					
				}
		}
	}
		//Prints the top ten within sorted lists
		System.out.println("Top Ten in History Stats");
		for (int x=0; x<10; x++) {
		System.out.println(x+1+".");
		System.out.println("Student ID: " + topId[x]);
		System.out.println("First Name: " + topFName[x]);
		System.out.println("Last Name: " + topLName[x]);
		System.out.println("History Score: " + top[x]);
		System.out.println("Science Score: " + a1[x]);
		System.out.println("Math Score: " + a2[x]);
		System.out.println("English Score: " + a3[x]+"\n");
		}
		}	
	public static void topTenSci(String firstName[], String lastName[], int studentId[], int scienceScore[], int historyScore[], int mathScore[], int englishScore[]) {
	//Clone the arrays in order to sort
	int [] top = scienceScore.clone();
	String [] topFName = firstName.clone();
	String [] topLName = lastName.clone();
	int [] topId = studentId.clone();
	int [] a1 = historyScore.clone();
	int [] a2 = mathScore.clone();
	int [] a3 = englishScore.clone();
	
	
	
	// bubble sort the lists to determine the top ten in each class
	int n = top.length;
	int temp1 = 0;
	int otherScore1 =0;
	int otherScore2 = 0;
	int otherScore3 = 0;
	String first = "";
	String last= "";
	int id = 0;
	for(int i=0; i<n;i++) {
		for(int j =1; j<(n-i); j++) {
			if (top[j-1]<top[j]) {
				temp1 = top[j-1];
				top[j-1] = top[j];
				top[j]=temp1;
				//Sort names and ID's and other scores
				first = topFName[j-1];
				last = topLName[j-1];
				id= topId[j-1];
				otherScore1 = a1[j-1];
				otherScore2 = a2[j-1];
				otherScore3 = a3[j-1];
				//swap to order in order of history score
				topFName[j-1] =topFName[j];
				topLName[j-1] =topLName[j];
				topId[j-1] = topId[j];
				a1[j-1] = a1[j];
				a2[j-1] = a2[j];
				a3[j-1] = a3[j];
				topFName[j]=first;
				topLName[j]=last;
				topId[j]=id;
				a1[j]=otherScore1;
				a2[j]=otherScore2;
				a3[j]=otherScore3;
				
			}
	}
}	
	//Prints top ten of the sorted lists
	System.out.println("Top Ten in Science Stats");
	for (int x=0; x<10; x++) {
	System.out.println(x+1+".");
	System.out.println("Student ID: " + topId[x]);
	System.out.println("First Name: " + topFName[x]);
	System.out.println("Last Name: " + topLName[x]);
	System.out.println("Science Score: " + top[x]);
	System.out.println("History Score: " + a1[x]);
	System.out.println("Math Score: " + a2[x]);
	System.out.println("English Score: " + a3[x]+"\n");
	}
	}
	public static void topTenMath(String firstName[], String lastName[], int studentId[], int scienceScore[], int historyScore[], int mathScore[], int englishScore[]) {
	//Clones the arrays into new ones that I can sort.
	int [] top = mathScore.clone();
	String [] topFName = firstName.clone();
	String [] topLName = lastName.clone();
	int [] topId = studentId.clone();
	int [] a1 = historyScore.clone();
	int [] a2 = scienceScore.clone();
	int [] a3 = englishScore.clone();
	
	
	
	// bubble sort the lists to determine the top ten in each class
	int n = top.length;
	int temp1 = 0;
	int otherScore1 =0;
	int otherScore2 = 0;
	int otherScore3 = 0;
	String first = "";
	String last= "";
	int id = 0;
	for(int i=0; i<n;i++) {
		for(int j =1; j<(n-i); j++) {
			if (top[j-1]<top[j]) {
				temp1 = top[j-1];
				top[j-1] = top[j];
				top[j]=temp1;
				//Sort names and ID's and other scores
				first = topFName[j-1];
				last = topLName[j-1];
				id= topId[j-1];
				otherScore1 = a1[j-1];
				otherScore2 = a2[j-1];
				otherScore3 = a3[j-1];
				//swap to order in order of history score
				topFName[j-1] =topFName[j];
				topLName[j-1] =topLName[j];
				topId[j-1] = topId[j];
				a1[j-1] = a1[j];
				a2[j-1] = a2[j];
				a3[j-1] = a3[j];
				topFName[j]=first;
				topLName[j]=last;
				topId[j]=id;
				a1[j]=otherScore1;
				a2[j]=otherScore2;
				a3[j]=otherScore3;
				
			}
	}
}	
	//Prints the top ten in math from the sorted lists. 
	System.out.println("Top Ten in Math Stats");
	for (int x=0; x<10; x++) {
	System.out.println(x+1+".");
	System.out.println("Student ID: " + topId[x]);
	System.out.println("First Name: " + topFName[x]);
	System.out.println("Last Name: " + topLName[x]);
	System.out.println("Math Score: " + top[x]);
	System.out.println("History Score: " + a1[x]);
	System.out.println("Science Score: " + a2[x]);
	System.out.println("English Score: " + a3[x]+"\n");
	}
	}
	public static void topTenEng(String firstName[], String lastName[], int studentId[], int scienceScore[], int historyScore[], int mathScore[], int englishScore[]) {
	//Clones the arrays
	int [] top = englishScore.clone();
	String [] topFName = firstName.clone();
	String [] topLName = lastName.clone();
	int [] topId = studentId.clone();
	int [] a1 = historyScore.clone();
	int [] a2 = scienceScore.clone();
	int [] a3 = mathScore.clone();
	
	
	
	// bubble sort the lists to determine the top ten in each class
	int n = top.length;
	int temp1 = 0;
	int otherScore1 =0;
	int otherScore2 = 0;
	int otherScore3 = 0;
	String first = "";
	String last= "";
	int id = 0;
	for(int i=0; i<n;i++) {
		for(int j =1; j<(n-i); j++) {
			if (top[j-1]<top[j]) {
				temp1 = top[j-1];
				top[j-1] = top[j];
				top[j]=temp1;
				//Sort names and ID's and other scores
				first = topFName[j-1];
				last = topLName[j-1];
				id= topId[j-1];
				otherScore1 = a1[j-1];
				otherScore2 = a2[j-1];
				otherScore3 = a3[j-1];
				//swap to order in order of history score
				topFName[j-1] =topFName[j];
				topLName[j-1] =topLName[j];
				topId[j-1] = topId[j];
				a1[j-1] = a1[j];
				a2[j-1] = a2[j];
				a3[j-1] = a3[j];
				topFName[j]=first;
				topLName[j]=last;
				topId[j]=id;
				a1[j]=otherScore1;
				a2[j]=otherScore2;
				a3[j]=otherScore3;
				
			}
	}
}	System.out.println("Top Ten in Science Stats");
	for (int x=0; x<10; x++) {
	System.out.println(x+1+".");
	System.out.println("Student ID: " + topId[x]);
	System.out.println("First Name: " + topFName[x]);
	System.out.println("Last Name: " + topLName[x]);
	System.out.println("English Score: " + top[x]);
	System.out.println("History Score: " + a1[x]);
	System.out.println("Science Score: " + a2[x]);
	System.out.println("Math Score: " + a3[x]+"\n");
	}
	}
	public static void passFailHist(int [] Scores) {
	//establish variables
	double pass = 0;
	double fail = 0;
	int total=0;
	//enhanced for loop that checks if the student was above or below a 60, and sorts that student into fail or pass
	for ( int student:Scores) {
		total++;
		if(student>60.0) {
			pass++;
		}else {
			fail++;
		}
	
	}
	//Displays Pass fail Info
	double passP = ((pass)/(total))*100;
	System.out.println(pass + " Students have passed this History semster");
	System.out.println(fail + " Students have failed this History semester");
	System.out.println("The Pass Percentage is: " + passP);
}
	public static void passFailEng(int [] Scores) {
		//establish variables
		double pass = 0;
		double fail = 0;
		int total=0;
		//enhanced for loop that checks if the student was above or below a 60, and sorts that student into fail or pass
		for ( int student:Scores) {
			total++;
			if(student>60.0) {
				pass++;
			}else {
				fail++;
			}
		
		}
		//Displays Pass fail Info
		double passP = ((pass)/(total))*100;
		System.out.println(pass + " Students have passed this English semster");
		System.out.println(fail + " Students have failed this English semester");
		System.out.println("The Pass Percentage is: " + passP);
	}
	public static void passFailMath(int [] Scores) {
		//establish variables
		double pass = 0;
		double fail = 0;
		int total=0;
		//enhanced for loop that checks if the student was above or below a 60, and sorts that student into fail or pass
		for ( int student:Scores) {
			total++;
			if(student>60.0) {
				pass++;
			}else {
				fail++;
			}
		
		}
		//Displays Pass fail Info
		double passP = ((pass)/(total))*100;
		System.out.println(pass + " Students have passed this Math semster");
		System.out.println(fail + " Students have failed this Math semester");
		System.out.println("The Pass Percentage is: " + passP);
	}
	public static void passFailSci(int [] Scores) {
		//establish variables
		double pass = 0;
		double fail = 0;
		int total=0;
		//enhanced for loop that checks if the student was above or below a 60, and sorts that student into fail or pass
		for ( int student:Scores) {
			total++;
			if(student>60.0) {
				pass++;
			}else {
				fail++;
			}
		
		}
		//Displays Pass fail Info
		double passP = ((pass)/(total))*100;
		System.out.println(pass + " Students have passed this Science semster");
		System.out.println(fail + " Students have failed this Science semester");
		System.out.println("The Pass Percentage is: " + passP);
	}
	public static void failTwo(int scienceScore[], int historyScore[], int mathScore[], int englishScore[]) {
		int failed = 0;
		int totalFail=0;
		//Check if each class is failed for each student, and add one if they failed
		for(int i =0; i<scienceScore.length;i++) {
			if (scienceScore[i]<60) {
				failed+=1;
			}
			if(historyScore[i]<60) {
				failed+=1;
			}
			if(mathScore[i]<60) {
				failed+=1;
			}
			if(englishScore[i]<60) {
				failed+=1;
			}
			//if the students failed more than two classes, increase the counter of students failing more than two classes. 
			if (failed>=2) {
				totalFail+=1;
			}
			failed=0;
		}
		System.out.println("The Amount of students that have failed two classes is: " + totalFail);
	}
}


