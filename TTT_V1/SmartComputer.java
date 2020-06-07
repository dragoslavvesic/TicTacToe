
/**
 * <p>Class extends the parent class <code>ComputerPlayer</code> and handles computer player
 * moves with suitable defensive strategy.<p>
 * 
 * @author      Dragoslav Vesic
 * @version     30/12/2017
 */
class SmartComputer extends ComputerPlayer{
    
    /**
     * <p>Initiates the object of the class <code>SmartComputer</code><p>
     * 
     * param mark       marks the current player move (X or O) to be set
     */
    public SmartComputer(char mark){
        
        player = mark;
    }
    
    /**
     * <p>The method evaluates the best possible move to be played.
     * It is inhereted from the parent class.</p>
     * 
     * @param squares       data of current Board object
     * @return              position that offers the best possible location
     */
    public int evalAllMoves(char squares[][]){
        
        int nextMakeNum = 0;
        char[][] boardArr = new char[3][3];
        int[] score = new int[9];   
        int num = 0;
        
        //assigns value from the parameter to the board array
        for (int i = 0; i < COLS; i++){
            for (int j = 0; j < ROWS; j++){
                boardArr[j][i] = squares[j][i];
            }
        }      
        
        for (num = 0; num < 9; num++){
            int row = Math.round(num/3);
            int col = num%3;            
            if (boardArr[row][col] != '-')
            break;
        } 
        
        //assigns to variable score the gain return from ComputerPlayer method
        for (int k = 0; k < 9; k++) {
            score[k] = evalMove(k, boardArr);       
        }

        if (num == 9){                   
            nextMakeNum = 4;
        } else{
            nextMakeNum = bestMove(score);
        }

        return nextMakeNum;
    } 
    
}
