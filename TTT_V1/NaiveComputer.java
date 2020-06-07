import java.util.Random;

/**
 * <p>Class extends the parent class <code>ComputerPlayer</code> and handles computer player
 * moves without suitable defensive strategy.</p>
 * 
 * @author      Dragoslav Vesic
 * @version     30/12/2017
 */ 
public class NaiveComputer extends ComputerPlayer{
    
    /**
     * <p>Initiates the object of the class <code>NaiveComputer</code>.</p>
     * 
     * param mark       marks the current player move (X or O) to be set
     */
    public NaiveComputer(char mark){
        
        player = mark;
    }
    
    /**
     * <p>The method randomly picks any vacant location for the move.
     * It is inhereted from the parent class.</p>
     * 
     * @param squares       data of current Board object
     * @return              position randomly selected
     */
    int evalAllMoves(char squares[][]){
        
        int nextMakeNum = 0;
        char[][] boardArr = new char[3][3];         
        int num = 0;
        
        for (int i = 0; i < COLS; i++){
            for (int j = 0; j < ROWS; j++){
                boardArr[j][i] = squares[j][i];
            }
        }            
    
        for (num = 0; num < 9; num++){
            int row = Math.round(num/3);
            int col = num%3;            
            if (boardArr[row][col] != '-'){
                break;
            }
        }
    
        if (num == 9){
            int randomNum = 0;
            Random randomGenerator = new Random();
            randomNum = randomGenerator.nextInt(9);        
            nextMakeNum = randomNum;
        } else{
            int randomNum = 0;
            Random randomGenerator = new Random();
            do{
                randomNum = randomGenerator.nextInt(9);        
                nextMakeNum = randomNum;
            } while(!checkMove(randomNum, boardArr));            
        }   

        return nextMakeNum;
    } 
    
    
}
