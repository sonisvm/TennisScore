package TennisScore.src;

import TennisScore.src.TennisScoreBoard;

public class TennisGame {
	 
	 public static void main(String[] args){
		
		 TennisScoreBoard scoreBoard = new TennisScoreBoard(args[0]);
		 System.out.println(scoreBoard.getScoreAt(Integer.parseInt(args[1])));
	 }
}
