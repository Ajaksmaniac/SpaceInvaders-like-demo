
public abstract class Ship {
	int health;
	int speed;
	int damage;
	int shield = 0;
	
	
	
	void getDamage(int damage) {
		//System.out.println( this.health );
		int damageDealth = (damage-this.shield);
		this.health =this.health - damageDealth; 
		if(this.health <= 0) {
			System.out.println("Ship Destroyed");
		}else {
			
			System.out.println("Damage dealth to "+this.getClass()+" :" + damageDealth +" " +this.getClass() +" Has " + this.health + "Health");
		}
	}
	
	
	
}
