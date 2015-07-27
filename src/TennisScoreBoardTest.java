package TennisScore.src;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by test on 7/27/2015.
 */
public class TennisScoreBoardTest {

    TennisScoreBoard scoreBoard;
    @Before
    public void setUp() throws Exception {
        scoreBoard = new TennisScoreBoard("dfdfdf");
    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void testGetScoreAt() throws Exception {
        assertEquals("30-30", scoreBoard.getScoreAt(4));
    }

}