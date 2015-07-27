package TennisScore.src;

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
		if(gameOver(playerId)){
			System.out.println("Player "+ winningPlayer + " wins!");
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
		return (player1Score[time] == 40 && player2Score[time] == 40);
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
		return player1Score[time] + " " + player2Score[time];
	}

	public boolean gameOver(char playerId){
		if (player2Advantage == 2 || (playerId == 'f' && player2Advantage == 40 && player1Advantage != 40)){
			winningPlayer = "player 2";
			return true;
		}

		if (player1Advantage == 2 || (playerId == 'd' && player1Advantage == 40 && player2Advantage != 40)){
			winningPlayer = "player 1";
			return true;
		}

		return false;
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
