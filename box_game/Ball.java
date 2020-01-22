package box_game;

import java.awt.Color;
import java.awt.Graphics;
import java.text.DecimalFormat;
import java.util.Random;
public class Ball {
	private int size, x, y,speedy;
	private Color color;
	public Random rand = new Random();
	DecimalFormat df=new DecimalFormat("0.00");
	
	public Ball(int x, int y) {
		this.x = x;
		this.y = y;
		size = rand.nextInt(30)+30;//size(20+random(0-50))		
		speedy = size/6;
		color = new Color(rand.nextInt(226)+30, rand.nextInt(226)+30, rand.nextInt(226)+30);
	}
    /**
     * draw the ball on the graphics.
     * @param g: the graphics to paint on.
     */
	public void draw(Graphics g) {
		g.setColor(color);
		g.fillOval(x, getY(), size, size);
		y = getY() + speedy;//move down
	}
    /**
     * get the position on y.
     * @return the vertical ordinate of ball.
     */
	public int getY() {
		return y;
	}
    /**
     * get the position on x.
     * @return the horizontal ordinate of ball.
     */
	public int getX() {
		return x;
	}
    /**
     * get the size of the ball.
     * @return the random size of the ball.
     */
	public int getSize() {
		return size;
	}
}