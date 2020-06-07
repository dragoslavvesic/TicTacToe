
/**
 * <p>This class manages the selection method of the Computer player. 
 * It is an abstract class from which classes <code>SmartComputer</code>
 * and <code>NaiveComputer</code> derive from.</p>
 * 
 * @author       Dragoslav Vesic
 * @version      30/12/2017
 */
abstract class ComputerPlayer{
    /** Static variable that represents column number in the game board. */
    static int COLS = 3;
    /** Static variable that represents row number in the game board. */
    static int ROWS = 3;
    /** Variable that represents the mark of the player. */
    public char player;
    
    /**
     * <p>Evaluates the best move among options.</p>
     * 
     * @param score[]       array of int type
     * @return              returns the index of highest value among the 
     *                      <code>score[]</code>
     */
    public int bestMove(int score[]){
        
        int maxScore = score[0];
        int maxCol = 0;
    
        for (int j = 1; j < 9; j++) {
            if (maxScore < score[j]) {
                maxScore = score[j];
                maxCol = j;
            }
        }
        return maxCol;
    }
    
    /**
     * <p>The method determines the gain of the computer move at 
     * <code>num</code> position in the current squares. The evaluation gives 
     * better value for better position and position is evaluated 
     * by calculating a score the following way: increase the score
     * for desirable configurations/events and decrease it for 
     * undesirable ones. The feature focuses on the number of threats.
     * </p>
     * 
     * @param num           position to set next token
     * @param squares[]     current data of the <code>Board</code> object
     * @return              gain of putting token to <code>num</code>
     *                      position in the current board
     */
    public int evalMove(int num, char squares[][]){
        
        char[][] tempBrd = new char[3][3];        
        char player1 = '-';
        int gain = 0;
    
        for (int i = 0; i < COLS; i++){
            for (int j = 0; j < ROWS; j++){
                tempBrd[j][i] = squares[j][i];
            }
        }

        if (checkMove(num, tempBrd)) {
            int row = Math.round(num/3);
            int col = num%3;
            tempBrd[row][col] = player;//assign char to board array
        } else{
            return -2000;
        }

        gain = scoreBoard(tempBrd, player);
        char[][] tempBrd1 = new char[3][3]; 
        int[] tempGain1 = new int[9];
        int maxGain1 = 0;

        for (int i = 0; i < COLS; i++){
            for (int j = 0; j < ROWS; j++){
                tempBrd1[j][i] = tempBrd[j][i];
            }
        }

        if (player == 'X')
            player1 = 'O';
        else if (player == 'O')
            player1 = 'X';

        for (int m = 0; m < 9; m++) {
                int row = 0;
                int col = 0;
                if (checkMove(m, tempBrd1)) {
                    row = Math.round(m/3);
                    col = m%3;
                    tempBrd1[row][col] = player1;
                }
    
                tempGain1[m] = scoreBoard(tempBrd1, player1);    
                tempBrd1[row][col] = '-';
        }

        maxGain1 = tempGain1[0];
        for (int j = 0; j < 9; j++) {
            if (maxGain1 < tempGain1[j]){
                maxGain1 = tempGain1[j];
            }
        }
    
        gain = gain - maxGain1;
        //final estimation
        return gain;
    }
    
    /**
     * <p>Evaluates the score of the player for the current board
     * by applying method <code>scoreToken()</code> to every position of squares 
     * and returns the result.</p>
     * 
     * @param squares[][]       board data for estimation
     * @param player            mark of the player to be estimated
     * @return                  gain of the player for the current board
     * @see                     #scoreToken()
     */
    public int scoreBoard(char squares[][], char player){
        
        int score = 0;

        for (int r = 0; r < ROWS; r++) {
            if (r <= ROWS - 3){
                for (int c = 0; c < COLS; c++){
                    score += scoreToken(squares, r, c, player);
                }
            } else{
                for (int c = 0; c <= COLS - 3; c++){
                    score += scoreToken(squares, r, c, player);
                }
            }
        }

        return score;
    }
    
    /**
     * <p>The degree of setting the move is obtained by searching in up, 
     * up-diagonale, downward and downward-diagonale direction. If tripple-same set
     * is possible, it gives higher gain.</p>
     * 
     * @param squares[][]       board data to estimate
     * @param row               row of token position to be estimated
     * @param col               column of token position to be estimated
     * @param player            mark of the player to be estimated
     * @return                  <code>int</code> returns the gain given for the 
     *                          <code>row</code> and <code>col</code> position in
     *                          the board data
     */
    public int scoreToken(char squares[][], int row, int col, char player){
        
        int score = 0;

        if (player == 'X') {
            score = 0;
            boolean unblocked = true;
            int tally = 0;
    
            if (row < ROWS - 2) {
                //check up
                unblocked = true;
                tally = 0;
    
                for (int r = row; r < row + 3; r++) {
                    if (squares[r][col] == 'O'){
                        unblocked = false;
                    }
                    if (squares[r][col] == player){
                        tally++;
                    }
                }
    
                if (unblocked == true){
                    score = score + (tally*tally*tally);
                }
                if (col < COLS - 2){
                    //check up and to the right
                    unblocked = true;
                    tally = 0;
                    for (int r = row, c = col; r < row + 3; r++, c++) {
                        if (squares[r][c] == 'O'){
                            unblocked = false;
                        }
                        if (squares[r][c] == player){
                            tally++;
                        }
                    }
    
                    if (unblocked == true){
                        score = score + (tally*tally*tally);
                    }
                }
            }
    
            if (col < COLS - 2) {
                //check right
                unblocked = true;
                tally = 0;
    
                for (int c = col; c < col + 3; c++) {
                    if (squares[row][c] == 'O'){
                        unblocked = false;
                    }
                    if (squares[row][c] == player){
                        tally++;
                    }
                }
    
                if (unblocked == true){
                    score = score + (tally*tally*tally);
                }
                if (row > 1) {
                    //check down and to the right
                    unblocked = true;
                    tally = 0;
                    for (int r = row, c = col; c < col + 3; r--, c++) {
                        if (squares[r][c] == 'O'){
                            unblocked = false;
                        }
                        if (squares[r][c] == player){
                            tally++;
                        }
                    }
                    if (unblocked == true){
                        score = score + (tally*tally*tally);
                    }
                }
            }
        } else if (player == 'O') {
            boolean unblocked = true;
            int tally = 0;
    
            if (row < ROWS - 2) {
                //check up
                unblocked = true;
                tally = 0;
    
                for (int r = row; r < row + 3; r++) {
                    if (squares[r][col] == 'X'){
                        unblocked = false;
                    }
                    if (squares[r][col] == player){
                        tally++;
                    }
                }
    
                if (unblocked == true){
                    score = score + (tally*tally*tally);
                }
                if (col < COLS - 2){
                    //check up and to the right
                    unblocked = true;
                    tally = 0;
                    for (int r = row, c = col; r < row + 3; r++, c++) {
                        if (squares[r][c] == 'X'){
                            unblocked = false;
                        }
                        if (squares[r][c] == player){
                            tally++;
                        }
                    }
    
                    if (unblocked == true){
                        score = score + (tally*tally*tally);
                    }
                }
            }
    
            if (col < COLS - 2) {
                //check right
                unblocked = true;
                tally = 0;
                for (int c = col; c < col + 3; c++) {
                    if (squares[row][c] == 'X'){
                        unblocked = false;
                    }
                    if (squares[row][c] == player){
                        tally++;
                    }
                }
    
                if (unblocked == true){
                    score = score + (tally*tally*tally);
                }
                if (row > 1) {
                    //check down and to the right
                    unblocked = true;
                    tally = 0;
                    for (int r = row, c = col; c < col + 3; r--, c++) {
                        if (squares[r][c] == 'X'){
                            unblocked = false;
                        }
                        if (squares[r][c] == player){
                            tally++;
                        }                            
                    }
    
                    if (unblocked == true){
                        score = score + (tally*tally*tally);
                    }
                }
            }
        }
        return score;

    }
    
    /**
     * <p>The method determines if the move can be set at the <code>num</code>
     * position of 'squares'.</p>
     * 
     * @param num           position to check
     * @param squares[][]   <code>Board</code> data to be checked
     * @return              <code>true</code> if location is empty,
     *                      otherwise <code>false</code>
     * 
     */
    public boolean checkMove(int num, char squares[][]){
        // if outside of legal column and row values, return false
        if (num < 0 || num > 8){
            return false;
        }
        // if cell is set, return false
        int row = Math.round(num/3);
        int col = num%3;
        if (squares[row][col] != '-'){
            return false;
        }
        // otherwise, it's ok
        return true;
    }
    
    /**
     * <p>The abstract method that is implemented in child classes
     * <code>SmartComputer</code> and <code>NaiveComputer</code>.</p>
     * 
     * @param squares[][]      current <code>Board</code> data
     * @return                 position to place the next move 
     */
    abstract int evalAllMoves(char squares[][]);
    
    /**
     * <p>Standard getter method that returns the <code>char</code> of the player.</p>
     * 
     * @return                 <code>char</code> of the player 
     */
    public char getPlayer(){
        return player;
    }
    
    
}
