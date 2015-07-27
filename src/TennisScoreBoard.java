
public class TennisScoreBoard {


	private static int[] player1Score;
	private static int[] player2Score;
	private int player1Advantage, player2Advantage;
	private String winningPlayer;
	public TennisScoreBoard(String gameString)
	{
		player1Score = new int[gameString.length()];
		player2Score = new int[gameString.length()];
		player1Score[0] = 0;
		player2Score[0] = 0;
		calculateScore(gameString);
	}
	
	private void calculateScore(String gameString)
	{
		for(int i=0; i<gameString.length(); i++)
		{
			addUpdatedScore(gameString.charAt(i), i+1);
		}
	}
	
	private void addUpdatedScore(char playerId, int index)
	{
		if(gameOver()){
			System.out.println("Player "+ winningPlayer + " wins!");
		}
		else
		{
			if(isADeuce())
			{
			updateAdvantageCounter(playerId, index);	
			}
			else
			{
				setNextScore(playerId, index);
			}
		}
	}
	
	private static void setNextScore(char playerId, int index)
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

	private static int getNextScore(int score){
		if(score == 30){
			return 40;
		}
		return score + 15;
	}
	
}
