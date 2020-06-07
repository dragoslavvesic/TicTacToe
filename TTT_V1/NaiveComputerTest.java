import org.junit.*;
import static org.junit.Assert.*;

/**
 * The class <code>NaiveComputerTest</code> contains tests for the class <code>{@link NaiveComputer}</code>.
 *
 * @author      Dragoslav Vesic
 * @version     07/01/2018
 */
public class NaiveComputerTest {
        
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
     * @param args      the command line arguments
     *
     */
    public static void main(String[] args){
        
        new org.junit.runner.JUnitCore().run(NaiveComputerTest.class);
        
    }
    
    /**
     * Run the <code>NaiveComputer(char)</code> constructor test.
     *
     * @throws Exception
     *
     */
    @Test
    public void testNaiveComputer_1()throws Exception{
        
        char mark = 'X';
        NaiveComputer naiComputer = new NaiveComputer(mark);

        assertNotNull(naiComputer);
        assertEquals('X', naiComputer.getPlayer());
    }

}