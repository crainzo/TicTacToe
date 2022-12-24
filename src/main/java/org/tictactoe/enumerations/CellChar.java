package org.tictactoe.enumerations;

public enum CellChar {
       EMPTY,X,O;

    @Override
    public String toString(){
        return this == EMPTY ? " " : this.name();
    }
}
