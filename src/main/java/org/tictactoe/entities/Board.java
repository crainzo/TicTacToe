package org.tictactoe.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.tictactoe.enumerations.CellChar;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Board {
    private Integer boardSize;
    private Cells [][] cells;

    public Board(Integer boardSize){
        this.boardSize = boardSize;
        cells = new Cells[boardSize][boardSize];
        for(int i=0;i<boardSize;i++){
            for(int j=0;j<boardSize;j++){
                cells[i][j] = new Cells(i,j, CellChar.EMPTY.toString());
            }
        }
    }

    public void printBoard(){
        for(int i=0;i<boardSize;i++){
            System.out.print("|");
            for(int j=0;j<boardSize;j++){
                System.out.print(String.format(" %s |",cells[i][j].getCharacter()));
            }
            System.out.println();
        }
    }

    public void resetBoard(){
        for(int i=0;i<boardSize;i++){
            for(int j=0;j<boardSize;j++){
                cells[i][j] = new Cells(i,j,CellChar.EMPTY.toString());
            }
        }
    }


}
