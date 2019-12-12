import java.io.IOException;

public class Main {

	
	
	/**
	 * 
	 * destroy all battleships in a level.
	 * Doubly linked list, every node will have one battleship in it, player can target and attack each battleship,
	 * once battleship on a chosen node is destroyed, its marked as destroyed.
	 * level is finished when all nodes are marked as destroyed.
	 * @throws IOException 
	 * 
	 * */
	
	
	
	
	public static void main(String[] args) throws IOException {
		BigShip ship1 = new BigShip();
		BigShip ship2 = new BigShip();
		CommandShip ship3 = new CommandShip();
		BattleshipLine line = new BattleshipLine();
		
		ship1.Attack(ship2);
		ship1.Attack(ship3);
		
		 new Frame(line, ship1);
		System.out.print(System.getProperty("user.dir"));
	}

}
