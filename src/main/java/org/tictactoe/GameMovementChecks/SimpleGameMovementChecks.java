package org.tictactoe.GameMovementChecks;

import org.tictactoe.entities.Board;
import org.tictactoe.enumerations.CellChar;
import org.tictactoe.interfaces.GameMovementChecks;

public class SimpleGameMovementChecks implements GameMovementChecks {
    @Override
    public boolean rowChecks(Board board) {
        boolean checkResult = false;
        for(int i=0;i<board.getBoardSize();i++){
            boolean rowCheckResult = true;
            for(int j=1;j<board.getBoardSize();j++) {
                if (!board.getCells()[i][j].getCharacter().equals(board.getCells()[i][j - 1].getCharacter()) || board.getCells()[i][j].getCharacter().equals(CellChar.EMPTY.toString()) || board.getCells()[i][j-1].getCharacter().equals(CellChar.EMPTY.toString())) {
                    rowCheckResult = false;
                }
            }
            checkResult|=rowCheckResult;
        }
        return checkResult;
    }

    @Override
    public boolean columnChecks(Board board) {

        boolean checkResults = false;
        for(int i=1;i<board.getBoardSize();i++){
            boolean columnCheckResult = true;
            for(int j=1;j<board.getBoardSize();j++){
                if(!board.getCells()[i][j].getCharacter().equals(board.getCells()[i-1][j].getCharacter()) || board.getCells()[i][j].getCharacter().equals(CellChar.EMPTY.toString()) || board.getCells()[i-1][j].getCharacter().equals(CellChar.EMPTY.toString())){
                    columnCheckResult = false;
                }
            }
            checkResults|=columnCheckResult;
        }
        return checkResults;
    }

    @Override
    public boolean diagonalCheks(Board board) {

        boolean checkResults = false;
        boolean diagonalResult = true;
        for(int i=1;i<board.getBoardSize();i++){
            if(!board.getCells()[i][i].getCharacter().equals(board.getCells()[i-1][i-1].getCharacter()) || board.getCells()[i][i].getCharacter().equals(CellChar.EMPTY.toString()) || board.getCells()[i-1][i-1].getCharacter().equals(CellChar.EMPTY.toString())){
                diagonalResult = false;
            }
        }
        checkResults|=diagonalResult;
        diagonalResult = true;
        for(int i=1;i<board.getBoardSize();i++){
            if(!board.getCells()[i][board.getBoardSize()-(i+1)].equals(board.getCells()[i][board.getBoardSize()-i]) || board.getCells()[i][board.getBoardSize()-(i+1)].equals(CellChar.EMPTY.toString()) || board.getCells()[i][board.getBoardSize()-i].equals(CellChar.EMPTY.toString())){
                diagonalResult = false;
            }
        }
        checkResults|=diagonalResult;
        return checkResults;
    }
}
