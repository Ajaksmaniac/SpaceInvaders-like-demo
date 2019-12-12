
public class Node {
	Node prev,next;
	BigShip ship;
	boolean destroyed = false;
	int posX;
	int posY;
	public int toFireBullet ;
	//boolean targeted = false;
	//Ship shold have picture, range of being able to get hit, type of ship, position
	public Node(BigShip s, Node p, Node n, int posX, int posY, int toFireBullet) {
		this.ship = s;
		this.next = n;
		this.prev = p;
		this.posX = posX;
		this.posY = posY;
		this.toFireBullet = toFireBullet;
	}
	int getX() {
		return this.posX;
	}
	int getY() {
		return this.posY;
	}
	boolean isDestroyed() {
		if(ship.health <= 0) {
			return true;
		}
		return false;
	}
	
}
