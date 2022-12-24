package org.tictactoe.interfaces;

import org.tictactoe.entities.Board;

public interface GameMovementChecks {

    public boolean rowChecks(Board board);
    public boolean columnChecks(Board board);
    public boolean diagonalCheks(Board board);

}
