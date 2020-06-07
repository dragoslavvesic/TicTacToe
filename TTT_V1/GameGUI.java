import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import javax.swing.*;

/**
 * <p>The class configures the game GUI and handles all events occuring in the GUI.
 * It extends <>code>JFrame</code> and implemets <code>ActionListener</code>.</p>
 * 
 * @author Dragoslav Vesic
 * @version 30/12/2017
 */
class GameGUI extends JFrame implements ActionListener{
    /** Objects used for clicking board matrix and function buttons. */
    JButton[] buttons = new JButton[10];
    /** <code>JLabel</code> objects for displaying current score - Human. */
    JLabel humanLabel = new JLabel("  Human:  0");
    /** <code>JLabel</code> objects for displaying current score - Computer. */
    JLabel computerLabel = new JLabel("  Computer:  0");
    /** <code>JLabel</code> objects for displaying current score - Game number played. */
    JLabel gamesLabel = new JLabel("  Games:  0");
    /** <code>ComputerPlayer</code> object participating in the game */
    ComputerPlayer computer;
    /** <code>Board</code> object used for reserving the state of game board at each clicking of token */
    Board gameBoard;
    /** <code>Result</code> object used for registering the game data */
    Result score = new Result(); 
    /** whether <code>player1</code> may move token or not at current moving of token */   
    boolean player1 = false;
    /** whether <code>player2</code> may move token or not at current moving of token */   
    boolean player2 = false;
    /** whether state of the game is the game start */   
    boolean startPlayer = false; 
    int pressCount = 0;
    /** width of the game board */
    int Xsize = 300;
    /** height of the game board */
    int Ysize = 400;

    /**
     * <p>Constructor configures the game GUI setup. Frame properties are determined and 
     * 9 tolen buttons are added to the frame. Three function buttons: Start, New Game 
     * and Exit and three label objects are also added to the frame. 
     * All buttons declare their <code>ActionListener</code>.
     * Game <code>Board</code> object is then created.</p>
     */
    public GameGUI(){
        
        super ("Tic-Tac-Toe");
        setSize (Xsize, Ysize);
        setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
        setLayout (new GridLayout (5, 3));
        setVisible(true);
        add(humanLabel);
        add(computerLabel);
        add(gamesLabel);
        
        //game buttons setup
        for(int i = 0; i < 9; i++){
            buttons[i] = new JButton("");
            buttons[i].addActionListener(this);
            add(buttons[i]);
            setVisible(true);
        }

        //game control buttons
        JButton startButton = new JButton("Start");
        startButton.addActionListener(this);        
        JButton newGameButton = new JButton("New Game");
        newGameButton.addActionListener(this);        
        JButton exitButton = new JButton("Exit");
        exitButton.addActionListener(this);        
        
        //add objects to frame
        add(startButton);
        add(newGameButton);
        add(exitButton);
        setVisible(true); 
        
        gameBoard = new Board();
    }
    
    /**
     * <p>This method implements the basic process of the game.
     * Before the game starts, it determines who will make the first
     * move (be player 1). If player 1 is Computer, it sets the player 2 
     * to <code>true</code>. Computer turn sets the evaluation of next 
     * move corresponding to current board setup, and consequent press
     * of the button.</p>
     */
    public void gamePlay(){
        
        while(!startPlayer){
            pressCount = 0;
            Object[] possibleValues = {"Player", "Computer"};
            Object selectedValue = possibleValues[0]; //default setting
                selectedValue = JOptionPane.showInputDialog(null, 
                "Who is first?", "Input",
                JOptionPane.INFORMATION_MESSAGE, null,
                possibleValues, possibleValues[0]);
                
                if(selectedValue != null){
                    if(selectedValue.equals(possibleValues[0])){//human starts
                        player1 = true;                
                        startPlayer = true;
                    } else if (selectedValue.equals(possibleValues[1])){//computer starts
                        player2 = true;
                        startPlayer = true;
                    }                                       
                } else{
                    player1 = false;
                    player2 = false;
                    startPlayer = true;
                }
        }
        
        if((player1 == false) && (player2 == false)){
            startPlayer = false;
        }
        
        if (player2){
            
            int nextnum = 0;
            nextnum = computer.evalAllMoves(gameBoard.getSquares());// decide the next move
            buttons[nextnum].doClick();

            player2 = false;
            player1 = true;

        }
    }

    /**
     * <p>This method generates random number between 0 and 100.</p>
     * 
     * @return      integer between 0 and 100
     */
    public int randomGenerator(){
        
        int randNumber;
        Random random = new Random();
        randNumber = random.nextInt(100);
        return randNumber;
    }
    
    /**
     * <p>This method clears all markers on the game board GUI.
     * It's called when game starts.</p>
     */
    public void clearButtons(){
        
        for(int i = 0; i < 9; i++){
            buttons[i].setText("");
        }
    }
    
    /**
     * <p>This method updates the result data in the game board GUI.</p>
     */
    public void labelUpdate(){
        
        humanLabel.setText("  Human:  " + score.getHumanWinNum());
        computerLabel.setText("  Computer:  " + score.getComWinNum());
        gamesLabel.setText("  Games:  "+ score.getGameTimes());
    }
    
    /**
     * <p>This is a redefinition of the ActionPerformed method of the 
     * JFrame class. The button click event occurs in the method.</p>
     * <p>Start Button Press</p>
     * <p>If the game is in progress, no action is taken. 
     * Selects the shape of the <code>Computer</code> player and generates the 
     * corresponding object by the number generator. Initialize the
     * <code>gameBoard</code> object that handles the <code>Board</code> data. 
     * Initialize the game progressive elements <code>startplayer, player1</code> and
     * <code>player2</code> to <code>false</code>. Lastly, we invoke method 
     * <code>gameplay()</code>, the basic process of the game.</p>
     * <p>New Game Button Press</p>
     * <p>At this stage, a selection window will appear asking whether you want
     * to cancel the current match and proceed with the new match. Press 'YES' 
     * to initialize the current board data, score results and GUI display. 
     * Next, we call <code>gameplay()</code>, the basic process of the game.</p>
     * <p>Exit Butoon Press</p>
     * <p>Exit the game and close the GUI</p>
     * <p>Human Player Move</p>
     * <p>Marks the user on the pressed button and location of the pressed button 
     * is obtained, then updates the board data according to identifier. Control 
     * transfers to <code>Computer</code> player. It confirms the winner based 
     * on updated board data. Displays the winner notification and initialise the 
     * board markers, then update the result.</p>
     * <p>Computer Player Move</p>
     * <p>Same as above.</p>
     * <p>Human Player Illegal Move</p>
     * <p>Displays the error message dialogue.</p>
     * 
     * @param e         occured event object
     */    
    @Override
    public void actionPerformed(ActionEvent e){
        
        Object source = e.getSource();

        if(source instanceof JButton){
            
            JButton button = (JButton) source;           

            if ((button.getText() == "Start") && (!startPlayer))
            {
                int random = randomGenerator(); 
                
                if (random%2 == 0){ //if random number picked is even, smart computer starts
                    computer = new SmartComputer('O');
                }else if (random%2 == 1){
                    computer = new NaiveComputer('O');
                }
                
                gameBoard.reset();
                startPlayer = false;
                player1 = false;
                player2 = false;
                gamePlay();
                
            } else if (button.getText() == "New Game"){
                //decision to opt for new game clears current result
                Object[] options = {"OK", "CANCEL"}; 
                Object selectedValue = JOptionPane.showOptionDialog(null, "Do you want to clear gamescores?", "Warning", 
                JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE,
                null, options, options[0]);
                //selecting option OK in the JOptionPane, game data resets
                if(selectedValue.equals(0)){
                    clearButtons();
                    gameBoard.reset();
                    startPlayer = false;
                    player1 = false;
                    player2 = false;
                    score.clearScore();                    
                    labelUpdate();
                }
                
            } else if (button.getText() == "Exit"){
                Object[] options = {"OK", "CANCEL"};
                Object selectedValue = JOptionPane.showOptionDialog(null, "Do you want to exit the game?", "Warning", 
                JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE,
                null, options, options[0]);
                //if user opts for Exit option, game terminates 
                if(selectedValue.equals(0)){
                    System.exit(0);
                }
            }
            
            //sets the move and gets the location of the move, human player 
            if (button.getText() == "" && player1 && startPlayer){
                
                button.setText("X");
                //gets the location of button
                float x = button.getX() + 10;
                float y = button.getY() + 10;
                
                int col = Math.round(3*x/this.getWidth());
                int row = Math.round(5*y/this.getHeight()) - 1;//top row used for result display               
                int num = 3*row + col;
                gameBoard.setMove('X', num);
                pressCount += 1;
                //change player
                player1 = false;
                player2 = true;
                
                char result = gameBoard.getWinner(); //check for winner                
                if(result == 'X'){
                    JOptionPane.showMessageDialog(null, "Congratulation! You are a winner.\n" +  
                    "Click 'OK' button to begin next game.");
                    clearButtons();
                    startPlayer = false;
                    player1 = false;
                    player2 = false;
                    score.humanWin();
                    score.gamesPlus();
                    labelUpdate();
                } else if(result == 'O'){
                    JOptionPane.showMessageDialog(null, "Sorry, computer is a winner");
                    startPlayer = false;
                    player1 = false;
                    player2 = false;
                } else{
                    if(gameBoard.isFull()){
                        JOptionPane.showMessageDialog(null, "Ooops, the game was drawn! \n Click 'OK' button to begin next game.");
                        clearButtons();
                        startPlayer = false;
                        player1 = false;
                        player2 = false;
                        score.gamesPlus();
                        labelUpdate();
                    }else{
                        gamePlay();
                    }
                }
                
            }
            //sets the move and gets location of the move, computer player starts
            else if ((button.getText() == "") && player2 && startPlayer){
                
                button.setText("O");
                //getting the index of button
                float x = button.getX() + 10;
                float y = button.getY() + 10;
                
                int col = Math.round(3*x/this.getWidth());
                int row = Math.round(5*y/this.getHeight()) - 1;
                int num = 3*row + col;
                gameBoard.setMove('O', num);
                pressCount+=1;
                player2 = false;
                player1 = true;
                char result = gameBoard.getWinner();
                if(result == 'X'){
                    JOptionPane.showMessageDialog(null, "Congratulation! You are a winner.");
                    startPlayer = false;
                    player1 = false;
                    player2 = false;
                }else if(result == 'O'){
                    JOptionPane.showMessageDialog(null, "Sorry, computer is a winner! \n" + 
                    "Click 'OK' button to begin next game.");
                    clearButtons();
                    startPlayer = false;
                    player1 = false;
                    player2 = false;
                    score.comWin();
                    score.gamesPlus();
                    labelUpdate();
                } else{
                    if(gameBoard.isFull()){
                        JOptionPane.showMessageDialog(null, "Ooops, the game was drawn! \n Click 'OK' button to begin next game.");
                        clearButtons();
                        startPlayer = false;
                        player1 = false;
                        player2 = false;
                        score.gamesPlus();
                        labelUpdate();
                    } else{
                        gamePlay();
                    }
                }
            }
            //checking if correct choice
            else if ((button.getText() == "X" || button.getText() == "O") && startPlayer){
                
                if(player2 == true){
                    gamePlay();
                } else{
                    JOptionPane.showMessageDialog(null, "Invalid choice. Select" 
                     + " another square.");
                }
            }
        }
    }
}
