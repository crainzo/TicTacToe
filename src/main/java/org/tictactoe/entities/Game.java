package org.tictactoe.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.tictactoe.enumerations.CellChar;
import org.tictactoe.enumerations.GameStatus;
import org.tictactoe.interfaces.GameMovementChecks;

import java.util.Queue;
import java.util.Scanner;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Game {
    private Board board;
    private Queue<Player> players;
    private GameMovementChecks moveChecker;
    private GameStatus gameStaus;
    public void startGame(){
        System.out.println("Lets Start the Game....");
        board.printBoard();
        while(gameStaus.equals(GameStatus.IN_PROGRESS)){
            Player currentPlayer = players.poll();
            int row=-1;
            int col = -1;
            boolean firstTimeInputTaken = false;
            Scanner sc = new Scanner(System.in);
            do{
                if(firstTimeInputTaken){
                    System.out.println(String.format("Oops.... you have entered incorrect cell please enter a valid cell"));
                } else{
                    System.out.println(String.format("It's %s turn",currentPlayer.getPlayerName()));
                }
                row = sc.nextInt();
                col = sc.nextInt();
                firstTimeInputTaken = true;
            }while(!(isValidInput(row,col) && isCellEmpty(row,col)));
            board.getCells()[row][col].setCharacter(currentPlayer.getPlayerCharacterLogo());
            board.printBoard();
            if(isCurrentPlayerWon()){
                System.out.println(String.format("Congratulation %s won the Game",currentPlayer.getPlayerName()));
                gameStaus = GameStatus.GAME_OVER;
                return;
            }else if(isGameDraw()){
                System.out.println(String.format("Oops! match is draw"));
            }

            players.add(currentPlayer);
        }
    }
    public void resetGame(){
      board.resetBoard();
      startGame();
    }
    private boolean isValidInput(int row,int col){
        if(row < board.getBoardSize() && row>=0 && col< board.getBoardSize() && col>=0)
            return true;
        return false;
    }
    private boolean isCellEmpty(int row,int col){
        if(board.getCells()[row][col].getCharacter().equals(CellChar.EMPTY.toString()))
            return true;
        return false;
    }

    private boolean isCurrentPlayerWon(){
        if(moveChecker.columnChecks(board) || moveChecker.rowChecks(board) || moveChecker.diagonalCheks(board))
            return true;
        return false;
    }

    private boolean isGameDraw(){
        for(int i=0;i<board.getBoardSize();i++){
            for(int j=0;j<board.getBoardSize();j++){
                if(board.getCells()[i][j].getCharacter().equals(CellChar.EMPTY.toString()))
                    return false;
            }
        }
        return true;
    }
}
