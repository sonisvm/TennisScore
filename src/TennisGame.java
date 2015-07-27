
public class TennisGame {
	 
	 public static void main(String[] args){
		
		 TennisScoreBoard scoreBoard = new TennisScoreBoard(args[0]);
		 System.out.println(TennisScoreBoard.getScoreAt(Integer.parseInt(args[1])));
	 }
}
