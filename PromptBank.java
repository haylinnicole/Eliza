//Stores and Generates Eliza's dialogue



package project2;

public class PromptBank {

	String [] questions;
	String [] statements;
	
	public PromptBank(){
		
		questions = new String[  4 ]; //initialize your array to the correct length to match your number of questions you populate it with
		statements = new String[  4 ];//initialize your array to the correct length to match your number of questions you populate it with
		
	}

	
	//String has Blanks as parameters to be called in other class
	
	public void populateStatementsArray(String BLANK1, String BLANK2){ //Plugs in user words into statements
		statements[0] = "ELIZA: Tell me more about  " +BLANK1+ " and " +BLANK2;
		statements[1] = "ELIZA: " +BLANK1+ " seems important to you, so does " +BLANK2+". Please tell me more.";
		statements[2] = "ELIZA: " +BLANK1+ " and "+BLANK2+ " seem to be on your mind. Let's talk about it.";
		statements[3] = "ELIZA: Tell me the purpose of "+BLANK1+ " and " +BLANK2 + ".";
	
	}
	public void populateQuestionsArray(String BLANK1, String BLANK2){ //Blank parameters are replaced by user's first and last words
		questions[0] = "ELIZA: Is there anything else about "+BLANK1+" and "+BLANK2+"?";
		questions[1] = "ELIZA: Does "+BLANK1+" bother you? How about "+BLANK2+"?";
		questions[2] = "ELIZA: How do "+BLANK1+" and "+BLANK2+" make you feel?";
		questions[3] = "ELIZA: What do you expect from "+BLANK1 +" and "+ BLANK2 +"?"; //2 given questions and 2 created ones
	
	
	}
	  
	public String getRandomStatementTrunk(){
	return statements [(int )(Math.random()*4)];//Generates random number 0-4 to get random element from statements array
		
	}
	
	public String getRandomQuestionTrunk(){
	return questions [(int )(Math.random()*4)]; //Generates random number 0-4 to get random element from questions array
	}
	
	
	
}