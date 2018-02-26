package Check;

import java.util.Scanner;

public class Check {

	public static Board board = new Board();
	public static Player player1 = new Player(Color.BLACK);
	public static Player player2 = new Player(Color.WHITE);
	public static Position oldPosition = new Position(0, 0);
	public static Position newPosition = new Position(0, 0);
	public static Scanner input = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		while(true)
		{
			turnOfPlayer(player1);
			turnOfPlayer(player2);
		}
		
	}
	
	public static void turnOfPlayer(Player p) {
		board.draw();
		inputOldPosition(p);
		while(!(board.getPiece(oldPosition).moveFrom() & board.moveFrom(oldPosition, p.getColor()))){
			System.out.println("Wrong!Decide again!");
			board.draw();
			inputOldPosition(p);
		}
		inputNewPosition(p);
		while(!(board.moveTo(oldPosition, newPosition) & board.getPiece(oldPosition).moveTo(newPosition))) {
			System.out.println("Wrong!Decide again!");
			board.draw();
			inputNewPosition(p);    
		}
		board.getPiece(oldPosition).move(newPosition);
	}
	
	public static void inputOldPosition(Player p) {
		System.out.printf("Turn of player no. " + p.getColor().getPlayerNum() + "\n" +
				"Coordinate of piece to move\n");
		System.out.print("Enter x:");
		oldPosition.setX(input.nextInt());
		System.out.print("Enter y:");
		oldPosition.setY(input.nextInt());
	}
	
	public static void inputNewPosition(Player p) {
		System.out.println("Coordinate of new position");
		System.out.print("Enter x:");
		newPosition.setX(input.nextInt());
		System.out.print("Enter y:");
		newPosition.setY(input.nextInt());
	}

}
