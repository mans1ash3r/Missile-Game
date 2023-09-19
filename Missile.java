/**
 * This class inherits JComponent and holds the information necessary to a Missile.
 */

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JComponent;
import java.util.ArrayList;

public class Missile extends JComponent {
	
	/**
	 * Instance Properties
	 */
	private int missileSpeed;
	private Color missileColor;
	
	/**
	 * The default constructor to initialize the instance properties 
	 * and sets the bounds of the JComponent’s Rectangle. 
	 */
	public Missile() { 
		super.setBounds(328, 380, 10, 20);
	    missileSpeed = 25;
	    missileColor = Color.BLACK;
	}
	
	/**
	 * The paintComponent() method that paints the Missile based on the current x and y coordinates.
	 */
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
	    g.setColor(missileColor);
	    g.fillOval(super.getX(), super.getY(), super.getWidth(), super.getHeight());
	}
	
	/**
	 * Determine if the missile is off the screen and remove it from the ArrayList if it is.
	 * @param width of JFrame
	 * @param height of JFrame
	 * @param missiles 
	 * @param missileIndex
	 */
	public void move(int width, int height, ArrayList<Missile> missiles, int missileIndex) {
		int newY = super.getY() - missileSpeed;
		if (newY < 0) {
		    missiles.remove(missileIndex);
		} else {
			super.setBounds(super.getX(), newY, super.getWidth(), super.getHeight());
		}
	}
	
	
}
