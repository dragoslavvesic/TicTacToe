
/**
 * <p>Class handles the result data for the games played between human
 * and computer player. The result increments until new game starts.</p>
 * 
 * @author      Dragoslav Vesic 
 * @version     30/12/2017
 */
public class Result{
    /** The number of times computer player wins.*/
    private int comWinNum;
    /** The number of times human player wins.*/
    private int humanWinNum;
    /** The number of games played until game is restarted.*/
    private int games;
    
    /**
     * <p>Constructor initialises the object and sets all the game variables
     * related to result at value 0</p> 
     */
    public Result(){
        
        comWinNum = 0;
        humanWinNum = 0;
        games = 0;
    }
    
    /**
     * <p>Increases the number of times computer player won, one for each call.</p>
     */
    public void comWin(){
        comWinNum++;
    }
    
    /**
     * <p>Increases the number of times human player won, one for each call.</p>
     */
    public void humanWin(){
        humanWinNum++;
    }
    
    /**
     * <p>Increases the number of games played, one for each call.</p>
     */
    public void gamesPlus(){
        games++;
    }
    
    /**
     * <p>Provides current number of games that computer player won.</p>
     * 
     * @return      number of times the computer player won.
     */
    public int getComWinNum(){
        return comWinNum;
    }
    
    /**
     * <p>Provides current number of games that human player won.</p>
     * 
     * @return      number of times the human player won.
     */
    public int getHumanWinNum(){
        return humanWinNum;
    }
    
    /**
     * <p>Provides current number of games played.</p>
     * 
     * @return      number of times the game was played.
     */
    public int getGameTimes(){
        return games;
    }
    
    /**
     * <p>Sets all game variables related to result to value 0.</p>
     */
    public void clearScore(){
        
        comWinNum = 0;
        humanWinNum = 0;
        games = 0;
    }
}
