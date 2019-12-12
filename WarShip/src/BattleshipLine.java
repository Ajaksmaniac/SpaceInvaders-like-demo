
public class BattleshipLine {
 Node first, last;
 public int posX = 150;
 public int posY =100; 
 public BattleshipLine() {
	Node one = new Node(new BigShip(),null,null,posX,posY, 20);
	Node two = new Node(new BigShip(),null,null,posX+200,posY,30);
	Node three = new Node(new BigShip(),null,null,posX+400,posY,40);
	first = one;
	one.next = two;
	two.prev = one;
	two.next = three;
	three.prev = two;
	three.next = null;
	last = three;
			
	 
}
 //fix this
  public boolean lineDestroyed() {
	  Node curr = first;
	  while(curr != last.next) {
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
