package TennisScore.src;

public class TennisScoreBoard {


	private int[] player1Score;
	private int[] player2Score;
	private int player1Advantage, player2Advantage;
	private String winningPlayer = "nobody";
	private boolean flagToStop = false;
	private int gameEndTime;
	private boolean deuceOccured;
	
	public TennisScoreBoard(String gameString)
	{
		player1Score = new int[gameString.length()+1];
		player2Score = new int[gameString.length()+1];
		player1Score[0] = 0;
		player2Score[0] = 0;
		calculateScore(gameString);
	}
	
	private void calculateScore(String gameString)
	{
		
		for(int i=0; i<gameString.length(); i++)
		{
			addUpdatedScore(gameString.charAt(i), i+1);
			if(flagToStop){
				break;
			}
		}
		gameEndTime = gameString.length();
	}
	
	private void addUpdatedScore(char playerId, int index)
	{
		if(gameOver(playerId, index-1)){
			
			gameEndTime = index;
			flagToStop = true;
		}
		else
		{
			if(isADeuce(index - 1))
			{
				updateAdvantageCounter(playerId, index);	
			}
			else
			{
				setNextScore(playerId, index);
			}
		}
	}

	private boolean isADeuce(int time){
		if (player1Score[time] == 40 && player2Score[time] == 40){
			deuceOccured = true;
		}
		
		return deuceOccured;
	}

	private void updateAdvantageCounter(char player, int time){
		if (player1Advantage == 1 && player2Advantage == 1){
			player1Advantage = 0;
			player2Advantage = 0;
		}
		else
			switch (player){
				case 'd' : player1Advantage++;
					break;
				case 'f' : player2Advantage++;
					break;
			}

		player1Score[time] = player1Advantage;
		player2Score[time] = player2Advantage;
	}

	public String getScoreAt(int time){
		
		if (time < gameEndTime){
			return player1Score[time] + "-" + player2Score[time];
		}
		
		return "Game ended before this point, " + winningPlayer + " wins!";
		
	}

	private boolean gameOver(char playerId, int index){
		if (playerId == 'f' && (player2Advantage == 2 || ( player2Score[index] == 40 && player1Score[index] != 40))){
			winningPlayer = "player 2";
			return true;
		}

		if (playerId == 'd' && (player1Advantage == 2 || ( player1Score[index] == 40 && player2Score[index] != 40))){
			winningPlayer = "player 1";
			return true;
		}

		return false;
	}

	private void setNextScore(char playerId, int index)
	{
		if(playerId == 'd'){
			player1Score[index] = getNextScore(player1Score[index - 1]);
			player2Score[index] = player2Score[index - 1];
		}
		else{
			player2Score[index] = getNextScore(player2Score[index - 1]);
			player1Score[index] = player1Score[index - 1];
		}
	}

	private int getNextScore(int score){
		if(score == 30){
			return 40;
		}
		return score + 15;
	}
	
	public void printScores(){
		for (int i = 0; i < gameEndTime ; i++){
		
				System.out.println(player1Score[i] + "-" + player2Score[i]);
						
		}
		System.out.println(winningPlayer + " wins!"); 
	}

}
