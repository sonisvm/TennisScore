
public class TennisScoreBoard {

	private final int[] GAME_POINTS = {0,15,30,40};
	private int[] player1Score;
	private int[] player2Score;
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
	
}
