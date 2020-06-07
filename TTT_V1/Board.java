
/**
 * <p>This class manages board game data.</p>
 * 
 * @author       Dragoslav Vesic
 * @version      30/12/2017
 */
public class Board {
    /** 3 x 3 <code>char</code> type array that is the board data.*/
    private char[][] gameSquares = new char[3][3];
    
    /**
     * <p>Initialises the game squares to 0.</p>
     * 
     * @see         #reset()
     */
    public Board(){
        reset();//resets the board to blank status
    }
    
    /**
     * <p>This function sets the token to the Nth position on the board.</p>
     * 
     * @param player    player character that is set in the board (<code>X</code>
     *                  or <code>O</code>).
     * @param num       position of set token (0 to 8)
     */
    public void setMove(char player, int num){
               
        if(checkMove(num)){//checks if legal move
            int row = Math.round(num/3);
            int col = num%3;
            gameSquares[row][col] = player;//sets the move to button location
        }
        
    }
    
    /**
     * <p>Sets the elements of the board to blank ('-').</p>
     */
    public void reset(){
        for (int row = 0; row < 3; row++ ){
            for(int col = 0; col < 3; col++){
                gameSquares[row][col] = '-';
            }
        }         
    }
    
    /**
     * <p>Standard getter method that returns the board data of
     * the current <code>Board</code> object.
     * 
     * @return      returns the board data of the current <code>Board</code> 
     *              object.
     */
    public char[][] getSquares(){
        return gameSquares;
    }
    
    /**
     * <p>Checks if the board is full or not.</p>
     * 
     * @return      <code>true</code> if board is full
     */
    public boolean isFull(){//confirms if board is full
        
        for (int row = 0; row < 3; row++ ){
            for(int col = 0; col < 3; col++){
                if(gameSquares[row][col] == '-')
                return false;
            }
        }                        
        return true;
    }
    
    /**
     * Checks the correctness of the game move.
     * 
     * @param num       position to check
     * @return          <code>true</code> if param set marks the correct move,
     *                  otherwise <code>false</code>
     */
    public boolean checkMove(int num){
        //if outside of legal column and row values, return false
        if (num < 0 || num > 8){
            return false;
        }
        //if cell is already set, return false
        int row = Math.round(num/3);
        int col = num%3;
        if (gameSquares[row][col] != '-')
            return false;
        //otherwise, it's ok
        return true;
    }
    
    /**
     * <p>Confirms if there is a winner in the game. It stores the possible cases
     * in <code>win[]</code> (8 of them) and checking if they are 'XXX' or 'OOO'.</p>
     * 
     * @return          <code>char</code> of the winner if there is one, otherwise
     *                  returns blank ('-').
     */
    public char getWinner(){
        
        String[] win = new String[8]; //array for button text check
        int x = 0;
        
        for(int i = 0; i < 8; i++){
            win[i] = "";
        }

        for(int row = 0; row < 3; row++){//horizontal run            
            for (int col = 0; col < 3; col++){
                win[x] += gameSquares[row][col];
            }
            x++;
        }

        for(int col = 0; col < 3; col++){//vertical run
            for (int row = 0; row < 3; row++){
                win[x] += gameSquares[row][col];
            }
            x++;
        }
        
        //diagonale run
        win[x] += gameSquares[0][2];
        win[x] += gameSquares[1][1];
        win[x] += gameSquares[2][0];
        x++;
        win[x] += gameSquares[0][0];
        win[x] += gameSquares[1][1];
        win[x] += gameSquares[2][2];

        char winner = '-';
        for(int i = 0; i < 8; i++){
            if (win[i].equals("XXX")){
                winner = 'X';
            }
            if(win[i].equals("OOO")){
                winner = 'O';
            }
        }
        return winner;
    }
}
