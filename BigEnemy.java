/**
 * This class inherits the class Enemy and implements the abstract methods it contains.
 */

import java.awt.Color;
import java.util.ArrayList;

public class BigEnemy extends Enemy {
	
	/**
	 * The default constructor to initialize the instance properties.
	 */
	public BigEnemy() {
		super(0, 10, 50, 50, 5);
		setColor();
	}

	/**
	 * This method is the implementation of the Enemy’s abstract setColor() method.
	 */
	@Override
	public void setColor() {
		Color color = new Color(130, 0, 130);
		super.setEnemyColor(color.RED);
	}
	
	/**
	 * This method is the implementation of the Enemy’s abstract move() method.
	 * It checks if BigEnemy has hit a wall or not, and then reverses the direction if it has.
	 */
	@Override
	public void move(int width, int height) {
		int x = super.getX();
		int y = super.getY();
		int dx = super.getEnemySpeed();

		if (x + super.getWidth() > width || x < 0) {
			dx *= -1;
		}
		x += dx;
		super.setBounds(x, y, super.getWidth(), super.getHeight());
		super.setEnemySpeed(dx);
	}
	
	/**
	 * This method is the implementation of the Enemy’s abstract processCollision() method.
	 * If this method is called, then a Missile hit a BigEnemy.
	 */
    @Override
    public void processCollision(ArrayList<Enemy> enemies, int bigEnemyIndex) {
	    int width = super.getWidth();
	    int height = super.getHeight();
	    if (width <= 0 || height <= 0) {
	    	enemies.remove(bigEnemyIndex);
	    } else {
	        int newSize = (int) (width * 0.9);
	        super.setBounds(super.getX(), super.getY(), newSize, newSize);
	    }
    }

}
