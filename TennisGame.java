package TennisScore;

/**
 * Created by test on 7/27/2015.
 */
public class TennisGame {
    int[] score_player1;
    int[] score_player2;
    int adv_pl, adv_p2;
    private String winningPlayer;

    private boolean isDeuce(int time){
        return (score_player1[time] == 40 && score_player2[time] == 40);
    }

    private void updateAdvantageCounter(char player, int time){
        if (adv_pl == 1 && adv_p2 == 1){
            adv_pl = 0;
            adv_p2 = 0;
        }
        else
            switch (player){
                case 'd' : adv_pl++;
                    break;
                case 'f' : adv_p2++;
                    break;
            }

        score_player1[time] = adv_pl;
        score_player2[time] = adv_p2;
    }

    public String getScoreAt(int time){
        return score_player1[time] + " " + score_player2[time];
    }

    public boolean gameOver(char playerId){
        if (adv_p2 == 2 || (playerId == 'f' && adv_p2 == 40 && adv_pl != 40)){
            winningPlayer = "player 2";
            return true;
        }

        if (adv_pl == 2 || (playerId == 'd' && adv_pl == 40 && adv_p2 != 40)){
            winningPlayer = "player 1";
            return true;
        }

        return false;
    }
}
