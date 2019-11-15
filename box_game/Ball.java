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
	
	public void draw(Graphics g) {
		g.setColor(color);
		g.fillOval(x, getY(), size, size);
		y = getY() + speedy;//move down
	}

	public int getY() {
		return y;
	}
	public int getX() {
		return x;
	}
}