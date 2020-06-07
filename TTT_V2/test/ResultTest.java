import org.junit.*;
import static org.junit.Assert.*;

/**
 * The class <code>ResultTest</code> contains tests for the class <code>{@link Result}</code>.
 *
 * @author      Dragoslav Vesic
 * @version     07/01/2018
 */
public class ResultTest {
    
    /**
     * Perform pre-test initialization.
     *
     * @throws Exception        if the initialization fails for some reason
     *
     */
    @Before
    public void setUp() throws Exception{
        
        Result result = new Result();

    }

    /**
     * Perform post-test clean-up.
     *
     * @throws Exception        if the clean-up fails for some reason
     *
     */
    @After
    public void tearDown() throws Exception{

    }

    /**
     * Launch the test.
     *
     * @param args      the command line arguments
     *
     */
    public static void main(String[] args){
        
        new org.junit.runner.JUnitCore().run(ResultTest.class);
        
    }

    /**
     * Run the <code>Result()</code> constructor test.
     *
     * @throws Exception
     *
     */
    @Test
    public void testResult_1() throws Exception{

        Result result = new Result();
        
        assertNotNull(result);
        assertEquals(0, result.getGameTimes());
        assertEquals(0, result.getComWinNum());
        assertEquals(0, result.getHumanWinNum());
    }

    /**
     * Run the void <code>clearScore()</code> method test.
     *
     * @throws Exception
     *
     */
    @Test
    public void testClearScore_1() throws Exception{
        
        Result result = new Result();
        result.comWin();
        result.humanWin();
        result.gamesPlus();

        result.clearScore();

        assertEquals(0, result.getGameTimes());
        assertEquals(0, result.getComWinNum());
        assertEquals(0, result.getHumanWinNum());
    }

    /**
     * Run the void <code>comWin()</code> method test.
     *
     * @throws Exception
     *
     */
    @Test
    public void testComWin_1() throws Exception{
        
        Result result = new Result();
        result.comWin();
        result.humanWin();
        result.gamesPlus();
        result.comWin();
        
        assertEquals(2, result.getComWinNum());
        
    }

    /**
     * Run the void <code>gamesPlus()</code> method test.
     *
     * @throws Exception
     *
     */
    @Test
    public void testGamesPlus_1() throws Exception{
        
        Result result = new Result();
        result.comWin();
        result.humanWin();
        result.gamesPlus();
        result.gamesPlus();
        
        assertEquals(2,result.getGameTimes());

    }

    /**
     * Run the int <code>getComWinNum()</code> method test.
     *
     * @throws Exception
     *
     */
    @Test
    public void testGetComWinNum_1() throws Exception{
        
        Result result = new Result();
        result.comWin();
        result.humanWin();
        result.gamesPlus();

        int fixture = result.getComWinNum();
        
        assertEquals(1, fixture);
        
    }

    /**
     * Run the int <code>getGameTimes()</code> method test.
     *
     * @throws Exception
     *
     */
    @Test
    public void testGetGameTimes_1() throws Exception{
        
        Result result = new Result();
        result.comWin();
        result.humanWin();
        result.gamesPlus();

        int fixture = result.getGameTimes();
        
        assertEquals(1, fixture);
        
    }

    /**
     * Run the int <code>getHumanWinNum()</code> method test.
     *
     * @throws Exception
     *
     */
    @Test
    public void testGetHumanWinNum_1() throws Exception{
        
        Result result = new Result();
        result.comWin();
        result.humanWin();
        result.gamesPlus();

        int fixture = result.getHumanWinNum();
        
        assertEquals(1, fixture);
        
    }

    /**
     * Run the void <code>humanWin()</code> method test.
     *
     * @throws Exception
     *
     */
    @Test
    public void testHumanWin_1() throws Exception{
        
        Result result = new Result();
        result.comWin();
        result.humanWin();
        result.gamesPlus();
        result.humanWin();

        assertEquals(2, result.getHumanWinNum());
    }
    
}