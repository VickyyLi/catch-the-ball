package box_game;

import java.awt.Color;
import java.awt.Graphics;
import java.util.List;
import java.util.Random;

import org.json.JSONObject;

public class Run extends Thread {
	Graphics g;
	List<Ball> data;
	List<player> players;
	Color color_player;
	
	public Run(List<Ball> data,List<player> players, Graphics g,Color color_player) {
		this.data = data;
		this.players = players;
		this.g = g;	
		this.color_player=color_player;
	}
 
	public void run() {
		while (true) {
			g.setColor(new Color(0, 0, 0));
			g.fillRect(0, 0, 1920, 1060);
			data.removeIf(Ball -> Ball.getY() >= 1080);
			int pos = players.get(0).getHead_pos();		
			data.removeIf(Ball -> (Ball.getY()>750 && Ball.getY()<850 &&Ball.getX()>(pos-70)&&Ball.getX()<(pos+170)));
			for (int i = 0; i < data.size(); i++) {
				data.get(i).draw(g);
			}
			players.get(0).draw(g);
			try {
				sleep(50);//control each ball
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

		}
	}
}