import org.junit.*;
import static org.junit.Assert.*;

/**
 * The class <code>GameDriveTest</code> contains tests for the class <code>{@link GameDrive}</code>.
 *
 * @author      Dragoslav Vesic
 * @version     07/01/2018
 */
public class GameDriveTest{

    /**
     * Perform pre-test initialization.
     *
     * @throws Exception        if the initialization fails for some reason
     *
     */
    @Before
    public void setUp() throws Exception{

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
        
        new org.junit.runner.JUnitCore().run(GameDriveTest.class);
        
    }
    
    /**
     * Run the void main(String[]) method test.
     *
     * @throws Exception
     *
     */
    @Test
    public void testMain_1() throws Exception{
        
        String[] args = new String[] {};

        GameDrive.main(args);
        
        assertNotNull(args);

    }
}