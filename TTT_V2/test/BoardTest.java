import org.junit.*;
import static org.junit.Assert.*;

/**
 * The class <code>BoardTest</code> contains tests for the class <code>{@link Board}</code>.
 *
 * @author      Dragoslav Vesic
 * @version     07/01/2018
 */
public class BoardTest {
    
    /**
     * Perform pre-test initialization.
     *
     * @throws Exception    if the initialization fails for some reason
     *
     */
    @Before
    public void setUp(){
        
        Board result = new Board();

    }

    /**
     * Perform post-test clean-up.
     *
     * @throws Exception    if the clean-up fails for some reason
     *
     */
    @After
    public void tearDown(){

    }

    /**
     * Launch the test.
     *
     * @param args the command line arguments
     *
     */
    public static void main(String[] args){
        
        new org.junit.runner.JUnitCore().run(BoardTest.class);
        
    }

    /**
     * Run the <code>Board()</code> constructor test.
     *
     * @throws Exception
     *
     */
    @Test
    public void testBoard_1()throws Exception{

        Board result = new Board();
        
        assertNotNull(result);
        assertEquals(false, result.isFull());

    }

    /**
     * Run the boolean <code>checkMove(int)<code> method test.
     *
     * @throws Exception
     *
     */
    @Test
    public void testCheckMove_1() throws Exception{
        
        Board result = new Board();
        int num = -1;
        boolean fixture = result.checkMove(num);

        assertEquals(false, fixture);
    }

    /**
     * Run the boolean <code>checkMove(int)</code> method test.
     *
     * @throws Exception
     *
     */
    @Test
    public void testCheckMove_2() throws Exception{
        
        Board result = new Board();
        int num = 9;
        boolean fixture = result.checkMove(num);

        assertEquals(false, fixture);
    }

    /**
     * Run the boolean <code>checkMove(int)</code> method test.
     *
     * @throws Exception
     *
     */
    @Test
    public void testCheckMove_3() throws Exception{
        
        Board result = new Board();
        int num = 0;
        boolean fixture = result.checkMove(num);

        assertEquals(true, fixture);
        
    }

    /**
     * Run the boolean <code>checkMove(int)</code> method test.
     *
     * @throws Exception
     *
     */
    @Test
    public void testCheckMove_4() throws Exception{
        
        Board result = new Board();
        int num = 8;
        boolean fixture = result.checkMove(num);

        assertEquals(true, fixture);
        
    }
    
    /**
     * Run the boolean <code>checkMove(int)</code> method test.
     *
     * @throws Exception
     *
     */
    @Test
    public void testCheckMove_5() throws Exception{
        
        Board result = new Board();
        int num = 9;
        boolean fixture = result.checkMove(num);

        assertEquals(false, fixture);
        
    }

    /**
     * Run the <code>char[][] getSquares()</code> method test.
     *
     * @throws Exception
     *
     */
    @Test
    public void testGetSquares_1() throws Exception{
        
        Board fixture = new Board();
        char[][] result = fixture.getSquares();

        assertNotNull(result);
        assertEquals(3, result.length);
        assertNotNull(result[0]);
        assertEquals(3, result[0].length);
        assertEquals('-', result[0][0]);
        assertEquals('-', result[0][1]);
        assertEquals('-', result[0][2]);
        assertNotNull(result[1]);
        assertEquals(3, result[1].length);
        assertEquals('-', result[1][0]);
        assertEquals('-', result[1][1]);
        assertEquals('-', result[1][2]);
        assertNotNull(result[2]);
        assertEquals(3, result[2].length);
        assertEquals('-', result[2][0]);
        assertEquals('-', result[2][1]);
        assertEquals('-', result[2][2]);
        
    }

    /**
     * Run the char <code>getWinner()</code> method test.
     *
     * @throws Exception
     *
     */
    @Test
    public void testGetWinner_1() throws Exception{
        
        Board result = new Board();
        char fixture = result.getWinner();

        assertEquals('-', fixture);
        
    }

    /**
     * Run the char <code>getWinner()</code> method test.
     *
     * @throws Exception
     *
     */
    @Test
    public void testGetWinner_2() throws Exception{
        
        Board fixture = new Board();
        fixture.setMove('X', 0);
        fixture.setMove('X', 1);
        fixture.setMove('X', 2);
        char result = fixture.getWinner();
            
        assertEquals('X', result);
    }

    /**
     * Run the boolean <code>isFull()</code> method test.
     *
     * @throws Exception
     *
     */
    @Test
    public void testIsFull_1() throws Exception{
        
        Board result = new Board();
        boolean fixture = result.isFull();

        assertEquals(false, fixture);
        
    }

    /**
     * Run the boolean <code>isFull()</code> method test.
     *
     * @throws Exception
     *
     */
    @Test
    public void testIsFull_2() throws Exception{
        
        Board fixture = new Board();
        fixture.setMove('X', 0);
        fixture.setMove('X', 1);
        fixture.setMove('X', 2);
        fixture.setMove('X', 3);
        fixture.setMove('X', 4);
        fixture.setMove('X', 5);
        fixture.setMove('X', 6);
        fixture.setMove('X', 7);
        fixture.setMove('X', 8);
        boolean result = fixture.isFull();

        assertEquals(true, result);
    }

    /**
     * Run the void <code>reset()</code> method test.
     *
     * @throws Exception
     *
     */
    @Test
    public void testReset_1() throws Exception{
        
        Board result = new Board();
        char[][] fixture = result.getSquares();
        
        result.setMove('X', 0);
        result.setMove('X', 1);
        result.setMove('X', 2);
        result.setMove('X', 3);
        result.reset();
        
        assertEquals('-', fixture[0][0]);
        assertEquals('-', fixture[0][1]);
        assertEquals('-', fixture[0][2]);
        assertEquals('-', fixture[1][0]);
        assertEquals('-', fixture[1][1]);
        assertEquals('-', fixture[1][2]);
        assertEquals('-', fixture[2][0]);
        assertEquals('-', fixture[2][1]);
        assertEquals('-', fixture[2][2]);

    }

    /**
     * Run the void <code>setMove(char,int)</code> method test.
     *
     * @throws Exception
     *
     */
    @Test
    public void testSetMove_1() throws Exception{
        
        Board result = new Board();
        char[][] fixture = result.getSquares();
        char player = 'X';
        int num = 0;
        result.setMove(player, num);
        
        assertEquals('X', fixture[0][0]);
        
    }
    
}