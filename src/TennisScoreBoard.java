
public class TennisScoreBoard {

	private final int[] GAME_POINTS = {0,15,30,40};
	private int[] player1Score;
	private int[] player2Score;
	private int[] player1Advantage, player2Advantage;
	private String winningPlayer;
	public TennisScoreBoard(String gameString)
	{
		calculateScore(gameString);
		player1Score = new int[gameString.length()];
		player2Score = new int[gameString.length()];
		setInitialScore();
	}
	
	private void setInitialScore()
	{
		player1Score[0] = 0;
		player2Score[0] = 0;
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
		if(gameOver())
			System.out.println("Player "+ winningPlayer + " wins!");
		if(isADeuce(index-1))
		{
			if(gameOver(1))
			{
				System.out.println("Game Over")
			}
			else
			{
				updateAdvantageCounter(playerId, index);
			}
		}
		else
		{
			if(gameOver(0))
			{
				if(player1Score[index-1]==40)
				{
					System.out.println("Player 1 wins");
				}
				else
				{
					System.out.println("Player 2 wins");
				}
			}
		}
	}
	
}
