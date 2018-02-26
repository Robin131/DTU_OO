package test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Scanner;

import org.junit.Before;
import org.junit.jupiter.api.Test;

import Check.Board;
import Check.Color;
import Check.Player;
import Check.Position;

class CheckTest {

	@Before
	public void initialTest() 
	{
		Board board = new Board();
		Player player1 = new Player(Color.BLACK);
		Player player2 = new Player(Color.WHITE);
		public static Position oldPosition = new Position(0, 0);
		public static Position newPosition = new Position(0, 0);
		public static Scanner input = new Scanner(System.in);
	}

}
