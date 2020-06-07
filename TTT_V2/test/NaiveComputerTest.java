import org.junit.*;
import static org.junit.Assert.*;

/**
 * The class <code>NaiveComputerTest</code> contains tests for the class <code>{@link NaiveComputer}</code>.
 *
 * @generatedBy CodePro at 1/6/18 3:28 PM
 * @author Gile
 * @version $Revision: 1.0 $
 */
public class NaiveComputerTest {
	/**
	 * Initialize a newly create test instance to have the given name.
	 *
	 * @param name the name of the test
	 *
	 * @generatedBy CodePro at 1/6/18 3:28 PM
	 */
	public NaiveComputerTest(String name) {
	}

	/**
	 * Run the NaiveComputer(char) constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 1/6/18 3:28 PM
	 */
	@Test
	public void testNaiveComputer_1()
		throws Exception {
		char mark = '';

		NaiveComputer result = new NaiveComputer(mark);

		// add additional test code here
		assertNotNull(result);
		assertEquals('', result.getPlayer());
	}

	/**
	 * Run the int evalAllMoves(char[][]) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 1/6/18 3:28 PM
	 */
	@Test
	public void testEvalAllMoves_1()
		throws Exception {
		NaiveComputer fixture = new NaiveComputer('');
		char[][] squares = new char[][] {};

		int result = fixture.evalAllMoves(squares);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.IllegalArgumentException: argument type mismatch
		assertEquals(0, result);
	}

	/**
	 * Run the int evalAllMoves(char[][]) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 1/6/18 3:28 PM
	 */
	@Test
	public void testEvalAllMoves_2()
		throws Exception {
		NaiveComputer fixture = new NaiveComputer('');
		char[][] squares = new char[][] {};

		int result = fixture.evalAllMoves(squares);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.IllegalArgumentException: argument type mismatch
		assertEquals(0, result);
	}

	/**
	 * Run the int evalAllMoves(char[][]) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 1/6/18 3:28 PM
	 */
	@Test
	public void testEvalAllMoves_3()
		throws Exception {
		NaiveComputer fixture = new NaiveComputer('');
		char[][] squares = new char[][] {};

		int result = fixture.evalAllMoves(squares);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.IllegalArgumentException: argument type mismatch
		assertEquals(0, result);
	}

	/**
	 * Perform pre-test initialization.
	 *
	 * @throws Exception
	 *         if the initialization fails for some reason
	 *
	 * @generatedBy CodePro at 1/6/18 3:28 PM
	 */
	@Before
	public void setUp()
		throws Exception {
		// add additional set up code here
	}

	/**
	 * Perform post-test clean-up.
	 *
	 * @throws Exception
	 *         if the clean-up fails for some reason
	 *
	 * @generatedBy CodePro at 1/6/18 3:28 PM
	 */
	@After
	public void tearDown()
		throws Exception {
		// Add additional tear down code here
	}

	/**
	 * Launch the test.
	 *
	 * @param args the command line arguments
	 *
	 * @generatedBy CodePro at 1/6/18 3:28 PM
	 */
	public static void main(String[] args) {
		new org.junit.runner.JUnitCore().run(NaiveComputerTest.class);
	}
}