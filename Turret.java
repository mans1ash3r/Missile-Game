/**
 * This class inherits JComponent and holds the information necessary for a Turret.
 */

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import javax.swing.JComponent;

public class Turret extends JComponent {
	
	/**
	 * Instance Properties
	 */
	private Rectangle base;
	private Rectangle turret;
	private Color turretColor;

	/**
	 * The default constructor to initialize the instance properties.
	 */
	public Turret() {
		base = new Rectangle(310, 400, 50, 10);
		turret = new Rectangle(327, 380, 15, 20); 
		turretColor = Color.BLACK;
	}
    
	/**
	 * The paintComponent() method that paints the Turret base and Turret barrel.
	 */
    @Override
  	public void paintComponent(Graphics g) {
	    super.paintComponent(g);
        g.setColor(Color.DARK_GRAY);
        g.fillRoundRect(base.x, base.y, base.width, base.height, 10, 10);
        g.setColor(turretColor);
        g.fillRect(turret.x, turret.y, turret.width, turret.height);
  	}

    public int getX() {
        return turret.x + turret.width / 2;
    }

    public int getY() {
        return turret.y;
    }

}