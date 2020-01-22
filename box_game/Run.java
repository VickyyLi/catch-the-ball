package box_game;

import java.awt.*;
import java.awt.Graphics;
import java.util.List;
import java.util.Random;

import org.json.JSONObject;

public class Run extends Thread {
	Graphics g;
	List<Ball> data;
	List<player> players;
	static int score;
	public Run(List<Ball> data,List<player> players, Graphics g,int score) {
		this.data = data;
		this.players = players;
		this.g = g;	
		this.score=score;
	}
    /**
     * get the scores of the player.
     * @return score: score of the player.
     */
	public static int getScore() {
		return score;
	}
    /**
     * paint the little man, balls, score and timer on the graphics, this method is extend from the thread, which cooperate with the multithreading.
     * @see Ball_fallen
     */
	public void run() {
		while (true) {
			g.setColor(new Color(0, 0, 0));
			g.fillRect(0, 0, 1920, 1060);
			data.removeIf(Ball -> Ball.getY() >= 1080);
			int pos = players.get(0).getHead_pos();	
			for(int i=0;i<data.size();i++) {
				if (data.get(i).getY()>750 && data.get(i).getY()<850 &&data.get(i).getX()>(pos-70)&&data.get(i).getX()<(pos+170)) {
					data.remove(i);
					score=score+data.get(i).getSize();
				}
			}
			for (int i = 0; i < data.size(); i++) {
				data.get(i).draw(g);
			}
			players.get(0).draw(g);
			g.setFont(new Font("TimesRoman", Font.BOLD, 40)); 
			g.setColor(Color.white);
			g.drawString("Score:"+String.valueOf(score), (int)50, (int)100);
			g.drawString("Timer:"+String.valueOf(Ball_fallen.getCount()/10), (int)1550, (int)100);
			try {
				sleep(50);//control each ball
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			if(Ball_fallen.getCount()>=300.0) {
				break;
			}

		}
	}
}