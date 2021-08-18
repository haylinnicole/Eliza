//  MAIN CLASS 


package project2;

import java.util.Scanner;


public class ProjectEliza {
	
	static Scanner scnr = new Scanner(System.in); //Assuming scnr will be used throughout various methods
	
	public static String returnFirst (String userResponse) { //Method to get first word
		String firstWordReturn= ""; //initialize the string i will return
		
		if(userResponse.contains(" ")) { //if user sentence is more than 1 word
		int firstSpace = userResponse.indexOf(" ");
		  
	  	String firstWord = userResponse.substring(0,firstSpace); 
	  	firstWordReturn = firstWord;
	  	}
		else { //if user response is only 1 word.
			firstWordReturn = userResponse.substring(0, (userResponse.length()-1)); //if one word input, return it and leave out period
		}
		return firstWordReturn;
	}
	
	public static String returnLast (String userResponse) {//Method to get last word
		String lastWordReturn ="";
		
		
		if (userResponse.contains(" ")) {
		int wordEnd = userResponse.length()-1;
		int lastSpace = userResponse.lastIndexOf(" ")+1;//Created these ints so subtring statement is not too crowded
		
	  	String lastWord = userResponse.substring(lastSpace, wordEnd); 
	  	lastWordReturn = lastWord; 
	}
		else {
			lastWordReturn = userResponse.substring(0, (userResponse.length()-1));} //returns only word and exlcudes the period
		return lastWordReturn;
	}		
			
			
	public static void main (String[] args ) {
		
		PromptBank dialog = new PromptBank();//creating object from PromptBank to call later in program
		
		boolean keepAsking = true;  //while loop to repeat dialogue 
		String userResponse = ""; //initialize user's response string
		
		String userName = "";
		System.out.print("Hello, my name is Eliza. What is your name?");
		userName = scnr.nextLine(); //stores user name as one line to distinguish from userResponse
		System.out.print("Hello, " + userName+ ". Tell me what is on your mind today in 1 sentence.");
		
		
		while (keepAsking) { //Dialogue loop
			userResponse = scnr.nextLine(); //User's response is apart of dialogue, so inside loop/ Input then response cycle
			
			if (userResponse.contains("?")) {
				dialog.populateQuestionsArray(returnFirst(userResponse), returnLast(userResponse));//Parameters Blank1 & 2 become first and last words
				System.out.println(dialog. getRandomQuestionTrunk()); //dialog object allows this class to call methods from PromptBank
			}
			else if (userResponse.contains("!")) {
				dialog.populateStatementsArray(returnFirst(userResponse), returnLast(userResponse)); //Plug in first and last word to statements in prompt bank
				System.out.println("WOW! SOUNDS CRAZY!" + dialog.getRandomStatementTrunk()); //Calls back to prompt bank to get a random statement
			}
			else if (userResponse.contains(".")) {
				dialog.populateStatementsArray(returnFirst(userResponse), returnLast(userResponse));
				System.out.println(dialog. getRandomStatementTrunk());
			}
			else {
				dialog.populateStatementsArray(returnFirst(userResponse), returnLast(userResponse)); //any other character at the end of input
				System.out.println(dialog. getRandomStatementTrunk());
			}
			if (userResponse.equalsIgnoreCase("EXIT")) { //if user types exit, case insensitive
				System.out.print("ELIZA: Do you want to run the session again?");
				
				userResponse = scnr.nextLine(); //Scans for yes or no
				
				if (userResponse.equalsIgnoreCase("yes")) {
				keepAsking = true;} //Takes program back to beginning of dialog loop, will scan again

				else if(userResponse.equalsIgnoreCase("no")) {
				System.out.print("ELIZA: Goodbye, until next time");
				keepAsking = false; }//False will end loop and end dialog
				
			}
			
		}
		
		
	}


}
