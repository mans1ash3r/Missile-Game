/**
 * This class is abstract, inherits JComponent, and holds the information necessary to an Enemy. 
 * The children to this class are BigEnemy and SmallEnemy.
 */

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import javax.swing.JComponent;

public abstract class Enemy extends JComponent {
    
	/**
	 * Instance Properties
	 */
    private int enemySpeed;
    private Color enemyColor;
    
    /**
     * An abstract method which determines what occurs when a Missile hits an Enemy.
     * @param enemies
     * @param enemyIndex
     */
    public abstract void processCollision(ArrayList<Enemy> enemies, int enemyIndex);
    
    /**
     * An abstract method which generates and sets the color of the Enemy.
     */
    public abstract void setColor();
    
    /**
     * An abstract method which computes and updates the next position of the Enemy with respect to the JFrame width and height.
     */
    public abstract void move(int width, int height);
    
    /**
     * A partial constructor that sets the coordinates, size, and speed of the Enemy and sets the bounds of the JComponent’s Rectangle.
     * @param enemyXCoord
     * @param enemyYCoord
     * @param enemyHeight
     * @param enemyWidth
     * @param enemySpeed
     */
    public Enemy(int enemyXCoord, int enemyYCoord, int enemyHeight, int enemyWidth, int enemySpeed) {
        super.setBounds(enemyXCoord, enemyYCoord, enemyWidth, enemyHeight);
        this.enemySpeed = enemySpeed;
        setColor();
    }
    
    /**
     * The paintComponent() method that paints the Enemy based on the current x and y coordinates.
     */
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(enemyColor);
        g.fillRect(super.getX(), super.getY(), super.getWidth(), super.getHeight());
    }
    
    /**
     * Gets the enemy's speed.
     * @return enemySpeed as an int
     */
    public int getEnemySpeed() {
        return enemySpeed;
    }
    
    /**
     * Sets the enemy speed.
     * @param enemySpeed speed at which enemy is travelling
     */
    public void setEnemySpeed(int enemySpeed) {
        this.enemySpeed = enemySpeed;
    }
    
    /**
     * Gets the enemy's color.
     * @return enemyColor as a Color
     */
    public Color getEnemyColor() {
        return enemyColor;
    }
    
    /**
     * Sets the enemy's color.
     * @param enemyColor
     */
    public void setEnemyColor(Color enemyColor) {
        this.enemyColor = enemyColor;
    }
    
}




