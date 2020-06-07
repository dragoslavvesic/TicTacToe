import org.junit.*;
import static org.junit.Assert.*;

/**
 * The class <code>SmartComputerTest</code> contains tests for the class <code>{@link SmartComputer}</code>.
 *
 * @author      Dragoslav Vesic
 * @version     07/01/2018
 */
public class SmartComputerTest{
    
    /**
     * Perform pre-test initialization.
     *
     * @throws Exception        if the initialization fails for some reason
     *
     */
    @Before
    public void setUp() throws Exception {

    }

    /**
     * Perform post-test clean-up.
     *
     * @throws Exception        if the clean-up fails for some reason
     *
     */
    @After
    public void tearDown() throws Exception {

    }

    /**
     * Launch the test.
     *
     * @param args          the command line arguments
     *
     */
    public static void main(String[] args){
        
        new org.junit.runner.JUnitCore().run(SmartComputerTest.class);
        
    }

    /**
     * Run the <code>SmartComputer(char)</code> constructor test.
     *
     * @throws Exception
     *
     */
    @Test
    public void testSmartComputer_1() throws Exception{
        
        char mark = 'X';
        SmartComputer smaPlayer = new SmartComputer(mark);

        assertNotNull(smaPlayer);
        assertEquals('X', smaPlayer.getPlayer());
        
    }

    
    /**
     * Run the boolean <code>checkMove(int num, char squares[][])</code> method test.
     *
     * @throws Exception
     *
     */
    @Test
    public void checkMove_1() throws Exception{
        
        SmartComputer smaComputer = new SmartComputer('X');
        char[][] squares = new char[][] {};
        int num = -1;
        
        boolean result = smaComputer.checkMove(num, squares);
        
        assertEquals(false, result);        

    }
    
     
}