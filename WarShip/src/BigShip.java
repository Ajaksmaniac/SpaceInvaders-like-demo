import java.awt.Image;

import javax.swing.ImageIcon;

public class BigShip extends BattleShip {
	ImageIcon playerIcon = new ImageIcon(System.getProperty("user.dir")+"/src/EnemyBattleShipImg.png");
	public Image enemyImage = playerIcon.getImage();
	ImageIcon hitIcon = new ImageIcon(System.getProperty("user.dir")+"/src/EnemyBattleShipHit.png");
	public Image enemyHitImage = hitIcon.getImage();
	ImageIcon playerhitIcon = new ImageIcon(System.getProperty("user.dir")+"/src/playerHit.png");
	public Image playerHitImage = playerhitIcon.getImage();
	
	public BigShip() {
		
		
		this.damage = 100;
		this.health = 500;
	}
	
	public Image getImage() {
		return this.enemyImage;
	}
	public Image getHitImage() {
		return this.enemyHitImage;
	}
	public Image playerGetHitImage() {
		return this.playerHitImage;
	}

}
