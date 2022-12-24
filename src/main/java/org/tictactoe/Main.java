package org.tictactoe;
import org.tictactoe.GameMovementChecks.SimpleGameMovementChecks;
import org.tictactoe.entities.Board;
import org.tictactoe.entities.Game;
import org.tictactoe.enumerations.CellChar;
import org.tictactoe.entities.Player;
import org.tictactoe.enumerations.GameStatus;
import org.tictactoe.interfaces.GameMovementChecks;

import java.util.LinkedList;
import java.util.Queue;
import java.util.SimpleTimeZone;
import java.util.UUID;
import java.util.regex.*;

public class Main {
    public static void main(String[] args) {
        System.out.println("Welcome to Tic Tac Toe Game");
        Player player1 = new Player("Rajesh",UUID.randomUUID().toString(), CellChar.X.toString());
        Player player2 = new Player("Divyanshu",UUID.randomUUID().toString(),CellChar.O.toString());
        Queue<Player> players = new LinkedList<>();
        players.add(player1);
        players.add(player2);
        Board board1 = new Board(3);
        GameMovementChecks moveChecker1 = new SimpleGameMovementChecks();
        Game game1 = new Game(board1,players,moveChecker1, GameStatus.IN_PROGRESS);
        game1.startGame();
    }
}