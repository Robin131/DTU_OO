package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Test;

import Check.Board;
import Check.Color;
import Check.Player;
import Check.Position;

public class CheckTest {
	
	static private Board board = new Board();
	static private Player player1 = new Player(Color.BLACK);
	static private Position oldPosition = new Position(0, 0);
	static private Position newPosition = new Position(0, 0);
	
	// test the piece in the corner for BLACK
	// first test from
	@Test
	public void testFrom1() {
		oldPosition.setX(1);
		oldPosition.setY(2);
		assertTrue(board.moveFrom(oldPosition, player1.getColor()));
	}
	
	@Test
	public void testFrom2() {
		oldPosition.setX(1);
		oldPosition.setY(2);
		assertTrue(board.getPiece(oldPosition).moveFrom());
	}
	
	// Then test to
	@Test
	public void testTo1() {
		oldPosition.setX(1);
		oldPosition.setY(2);
		newPosition.setX(0);
		newPosition.setY(3);
		assertTrue(board.moveFrom(oldPosition, player1.getColor()));
	}
	
	@Test
	public void testTo2() {
		oldPosition.setX(1);
		oldPosition.setY(2);
		newPosition.setX(0);
		newPosition.setY(3);
		assertTrue(board.getPiece(oldPosition).moveTo(newPosition));
	}
	
	// test jump for a BLACK piece
	@Test
	public void testFrom3() {
		board = new Board();
		board.getPiece(new Position(1, 2)).move(new Position(0, 3));
		board.getPiece(new Position(2, 5)).move(new Position(1, 4));
		
		assertTrue(board.getPiece(new Position(0, 3)).moveFrom());
	}
	
	@Test
	public void testTo3() {
		board = new Board();
		board.getPiece(new Position(1, 2)).move(new Position(0, 3));
		board.getPiece(new Position(2, 5)).move(new Position(1, 4));
		
		assertTrue(board.moveTo(new Position(0, 3), new Position(2, 5)));
		assertTrue(board.getPiece(new Position(0, 3)).moveTo(new Position(2, 5)));
		board.getPiece(new Position(0, 3)).move(new Position(2, 5));
	}
	
	// test a wrong choice for place for WHITE piece
	@Test
	public void testFrom4() {
		board = new Board();
		assertFalse(board.getPiece(new Position(1, 6)).moveFrom());
	}
	
	@Test (expected = IndexOutOfBoundsException.class)
	public void testFrom5() {
		board = new Board();
		board.getPiece(new Position(1, 4)).moveFrom();
	}
	
	// test wrong choice for new position
	@Test
	public void testTo4() {
		board = new Board();
		assertTrue(board.moveTo(new Position(1, 2), new Position(1, 3)));
		assertFalse(board.getPiece(new Position(1, 2)).moveTo(new Position(1, 3)));
	}
	
	@Test
	public void testTo5() {
		board = new Board();
		assertFalse(board.getPiece(new Position(2, 1)).moveTo(new Position(0, 3)));
	}
	
	
	
	
	
	
	
	
	
}