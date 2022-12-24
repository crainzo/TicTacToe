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
public class Cells {
    private Integer xPosition;
    private Integer yPosition;
    private String  character;

    public void resetCell(){
        this.character = CellChar.EMPTY.toString();
    }


}
