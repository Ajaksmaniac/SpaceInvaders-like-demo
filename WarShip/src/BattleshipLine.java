import java.awt.SecondaryLoop;

public class BattleshipLine {
 Node first, last;
 public int posX = 150;
 public int posY =100; 
 public int  numberOfShips  = 11;
 int WIDTH;
 int fireChance = 50;
 public BattleshipLine(int WIDTH) {
	
	this.WIDTH = WIDTH;
	
	newWave();
			
	 
}
 public boolean levelComplete() {
	 if(numberOfShips >= 13) {
		 this.numberOfShips = 0;
		 
		 return true;
	 }else {
		 return false;
	 }
 }
public void newWave() {
	first = null;
	last = null;
	Node newShip;
	int shipInLine = 0;
	Node prev = null;
	Node next;
	int adder =50 ;
	int temp = numberOfShips;
	int secondRow  = 1;
	
	//int adder = 50*numberOfShips;
	while(shipInLine <= this.numberOfShips ) {
		int random = (int)(Math.random() * fireChance + 1);
		
		
		
		 if(shipInLine >=8) {
				
				posY = 200;
				//numberOfShips = 0;
				
				 posX = (WIDTH / (secondRow + secondRow)) +adder -500 ;
					adder += 70;
				
			}else {
				
				 posX = (WIDTH / (numberOfShips + numberOfShips)) +adder  ;
					adder += 70;
			}
		
		 newShip = new Node(new BigShip(),null,null,posX,posY, random);
		if(first == null) {
			first = newShip;
			last = newShip;
			first.prev = null;
			last.next = null;
		}else {
			last.next = newShip;
			newShip.prev = last;
			last = newShip;
			last.next = null;
		}
		shipInLine++;
		secondRow ++;
	}
	this.numberOfShips++;
	fireChance -= 10;//lowers range of randoms
	
	
}
public void destroyLine() {
	this.first = null;
	this.last = null;
}
//fix this
public boolean lineDestroyed() {
	  Node curr = this.first;
	  while(curr != this.last.next) {
		  //System.out.print(curr.ship.health);
		  if(curr.isDestroyed()) {
			  curr = curr.next;  
			 
			  
		  }else {
			 return false;
		  }
		
	  }
	  return true;
}
}
