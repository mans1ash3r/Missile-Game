/**
 * Project 4
 * 
 * This class contains the paintable objects such as the enemies,
 * turret, and missile. It also keeps track of the 
 * 
 * @author Mansi Asher
 */

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.ArrayList;
import javax.swing.JPanel;

public class GamePanel extends JPanel {
    
	/**
	 * Instance Properties
	 */
	private int totalScore;
	private boolean isNextEnemyBig;
	private Turret turret;
	private ArrayList<Enemy> enemies;
	private ArrayList<Missile> missiles;
	
	/**
	 * The default constructor to initialize the instance properties. 
	 * It also adds a new BigEnemy and a new SmallEnemy to the Enemy ArrayList to start the game.
	 */
	public GamePanel() {
		this.totalScore = 0;
		this.isNextEnemyBig = false;
		this.turret = new Turret();
		this.enemies = new ArrayList<>();
		this.missiles = new ArrayList<>();
		enemies.add(new BigEnemy());
		enemies.add(new SmallEnemy());
	}
	
	/**
	 * Paints the enemies and missiles when called and also paints
	 * the background of the panel blue.
	 */
	@Override
	public void paintComponent(Graphics g) { 
		super.paintComponent(g);
		g.setColor(Color.cyan); 
		g.fillRect(0, 0, this.getWidth(), this.getHeight()); 
		for (Enemy enemy : enemies) {
		      enemy.paintComponent(g);
		}
		for (Missile missile : missiles) {
		      missile.paintComponent(g);
		}
		    turret.paintComponent(g);
	}
	
	/**
	 * For every Enemy and every Missile, calls the corresponding Enemy and Missile move() methods in their respective classes.
	 */
	public void move() {
		for (Enemy enemy : enemies) {
	      enemy.move(super.getWidth(), super.getHeight());
	    }
	   
	    for (int i=0; i< missiles.size();i++) {
	      missiles.get(i).move( super.getWidth(),  super.getHeight(),missiles, i);
	    }
	}
	
	/**
	 * Adds a new Missile to the Missile ArrayList
	 */
	public void addMissile() {
		missiles.add(new Missile()); 
	}
	
	/**
	 * Adds a new BigEnemy or SmallEnemy to the Enemy ArrayList depending on the isNextEnemyBig boolean instance property.
	 */
	public void addEnemy() {
		if (isNextEnemyBig) {
		    enemies.add(new BigEnemy());
		} else {
			enemies.add(new SmallEnemy());
		}
		isNextEnemyBig = !isNextEnemyBig; 
	}

	/**
	 * Returns the totalScore instance property.
	 * @return totalScore as an int
	 */
	public int getTotalScore() {
		return totalScore;
	}

	/**
	 * Method detects the collision of the missile and all the enemies. This is done by
	 * drawing invisible rectangles around the enemies and missiles, if they intersect, then 
	 * they collide.
	 */
	public void detectCollision() {
		// Create temporary rectangles for every enemy and missile on the screen currently       
		for(int i = 0; i < enemies.size(); i++) {
			Rectangle enemyRec = enemies.get(i).getBounds();
			for(int j = 0; j < missiles.size(); j++) {
				Rectangle missileRec = missiles.get(j).getBounds();
				if(missileRec.intersects(enemyRec)) {
					(enemies.get(i)).processCollision(enemies, i);
					missiles.remove(j); 
					if(enemies.get(i) instanceof BigEnemy) {
						totalScore += 100;
					} else {
						totalScore += 150;
					}
				}
			}
		}
	}

}