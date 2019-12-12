import java.awt.Graphics;
import java.util.Random;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.io.IOException;


import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
public class Frame extends javax.swing.JFrame implements KeyListener {
	
	
	ImageIcon aa = new ImageIcon( System.getProperty("user.dir")+"/src/background.png");
	Image background = aa.getImage();
	ImageIcon ab = new ImageIcon( System.getProperty("user.dir")+"/src/bullet.png");
	Image bulletImage = ab.getImage();
	ImageIcon enemyBulletIcon = new ImageIcon( System.getProperty("user.dir")+"/src/EnemyBullet.png");
	Image enemyBulletImage = enemyBulletIcon.getImage();
	ImageIcon playerIcon = new ImageIcon(System.getProperty("user.dir")+"/src/BattleShipImg.png");
	Image playerImage = playerIcon.getImage();
	ImageIcon victoryIcon = new ImageIcon(System.getProperty("user.dir")+"/src/Victory.png");
	ImageIcon gameOverIcon = new ImageIcon(System.getProperty("user.dir")+"/src/GameOver.png");
	Image gameOverImage = gameOverIcon.getImage();
	Image VictoryImage = victoryIcon.getImage();
	int WIDTH = background.getWidth(null) - 30;
	int HEIGHT = background.getHeight(null);
	public  int posX = 350 ;
	public  int posY =450;
	public static int bulletPosX    ;
	public static int bulletPosY    ;
	public static int enemyBulletPosX    ;
	public static int enemyBulletPosY    ;
	public boolean bulletFired = false;
	public boolean enemyBulletFired = false;
	BattleshipLine line;
	BigShip player;
	static Random rand;
	int n;
   //only 1 type of ships are present in this demo
   public Frame(BattleshipLine line, BigShip player) throws IOException {
	   this.line = line;
	   this.player = player;
	   setLayout(null);
	   setBounds(0, 0, WIDTH, HEIGHT);
	  // setResizable(false);
	   try {
           setContentPane(new JLabel(new ImageIcon(ImageIO.read(new File(System.getProperty("user.dir")+"/src/background.png")))));
       } catch (IOException e) {
           e.printStackTrace();
       }
       pack();
       setVisible(true);
       this.addKeyListener(this);
       setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
   }
   
 

@Override
   public void paint(Graphics g) {
	int random = (int)(Math.random() * 50 + 1);
	   try {
		  
		Thread.sleep(40);//remove flashing images
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	   
	   System.out.println(player.health);
	   g.drawImage(background,10,30 ,this);
	   g.drawImage(playerImage,posX,posY ,this);
	   Node curr = line.first;
	   if(player.health <= 0) {
		   g.drawImage(gameOverImage,300,250 ,this);
		}else if(line.lineDestroyed()) {
		   System.out.println("VICOTRY!");
		   g.drawImage(VictoryImage,300,250 ,this);
	   }else {
		   while(curr != line.last.next) {
				  if(!curr.isDestroyed()) {
					  /*if(curr.next == line.last.next) {
						  if((bulletPosX  >= (line.last.getX() - 20) && bulletPosX  <= (line.last.getX() + 20)) && bulletPosY == line.last.posY ) {
							 player.Attack(line.last.ship);
							 g.drawImage(line.last.ship.getHitImage(),line.last.getX(),line.last.posY ,this);
							 try {
								Thread.sleep(50);
							} catch (InterruptedException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						  }
						  g.drawImage(line.last.ship.getImage(),line.last.getX(),line.last.posY ,this);
						  //System.out.println("LAST");
					  }*/if(!enemyBulletFired) { 
						  if(curr.toFireBullet == random) {
						  System.out.println("Enemby");
						  enemyBulletFired = true;
						  enemyBulletPosX = curr.getX();
						  enemyBulletPosY = curr.getY();
						  }
						 }
					  if((enemyBulletPosX  >= (posX - 10) && enemyBulletPosX  <= (posX + 30)) && enemyBulletPosY == posY ) {
							 g.drawImage(player.playerGetHitImage(),posX,posY  ,this);
							 curr.ship.Attack(player);
							 System.out.println("PLAYER HIT");
						 }
						  g.drawImage(curr.ship.getImage(),curr.getX(),curr.posY ,this);
						  if((bulletPosX  >= (curr.getX() - 20) && bulletPosX  <= (curr.getX() + 40)) && bulletPosY == curr.posY ) {
							  player.Attack(curr.ship);
							  g.drawImage(curr.ship.getHitImage(),curr.getX(),curr.posY ,this);
							  try {
								Thread.sleep(40);
							} catch (InterruptedException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						  }
					  
					 
				  }
				  
				  curr = curr.next;
			  }
	   }
	 
		//if bool fired, bul travels up until it hits a target or reach top of the map
		 if(bulletFired) {
			 g.drawImage(bulletImage,bulletPosX,bulletPosY - 10 ,this);
				bulletPosY -= 10;
				if(bulletPosY <= 0) {
					bulletFired = false;
					bulletPosY =posY;
					bulletPosX =posX;
					
				}
		 }
		 if(enemyBulletFired) {
			 g.drawImage(enemyBulletImage,enemyBulletPosX,enemyBulletPosY  ,this);
				enemyBulletPosY += 10;
				if(enemyBulletPosY >= HEIGHT-2) {
					enemyBulletFired = false;
					enemyBulletPosX =10;
					enemyBulletPosY =10;
					
				}
				
		 }
	  
		 
	   repaint();
   }

@Override
public void keyTyped(KeyEvent e) {
	// TODO Auto-generated method stub
	
}

@Override
public void keyPressed(KeyEvent e) {
	// TODO Auto-generated method stub
	int key = e.getKeyCode();
	
	if(key == KeyEvent.VK_LEFT) {
		playerLeft();
		
		//repaint();
	}
	if(key == KeyEvent.VK_RIGHT) {
		playerRight();
		
		//repaint();
	}
	if(key == KeyEvent.VK_SPACE) {
		if(bulletFired == false) {
			
			bulletFired = true;
		}
			
		
		//repaint();
	}
	
	repaint();
}


	// TODO Auto-generated method stub
	
	


@Override
public void keyReleased(KeyEvent e) {
	// TODO Auto-generated method stub
	
}



void playerLeft() {
	if(posX<= 0) {
		return;
	}else {			
		posX-=10;
	
	}
}

void playerRight() {
	if(posX >= WIDTH-10) {
		return;
	}else {			
		posX+=10;		
	}		
}


}
