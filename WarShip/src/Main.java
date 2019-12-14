import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

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
	
	
	static Frame f;
	
	public static void main(String[] args) throws IOException {
		BufferedImage bimg = ImageIO.read(new File( System.getProperty("user.dir")+"/src/background.png"));
		int WIDTH          = bimg.getWidth();
		BigShip ship1 = new BigShip();
		BigShip ship2 = new BigShip();
		CommandShip ship3 = new CommandShip();
		BattleshipLine line = new BattleshipLine(WIDTH);
		
		ship1.Attack(ship2);
		ship1.Attack(ship3);
		
		 Frame f= new Frame(line, ship1);
		while(true) {
			if(line.levelComplete()) {
				 line.destroyLine();
				 f.finishGame();
				 break;
			 }
			 if(line.lineDestroyed()) {
				 line.newWave();
			 }
			 
		 }
	
	}

	
}
