package box_game;

import java.awt.Color;
import java.awt.Graphics;
import org.json.JSONObject;
public class player {
	private JSONObject body_landmark;
	private Color color;	
	private int head_pos;
	public player(int head_pos, JSONObject body_landmark,Color color) {
		this.head_pos = head_pos;
		this.body_landmark = body_landmark;
		this.color=color;
	}
	
	public void draw(Graphics g) {
		g.setColor(color);//given by player
		JSONObject head = getBody_landmark().getJSONObject("head");
		
		g.drawOval(getHead_pos(), 800, 100, 100);	
		g.drawLine(getHead_pos()+70,900, getHead_pos()+170,800 );
		g.drawLine(getHead_pos()+30,900, getHead_pos()-70,800 );
		g.drawRect(getHead_pos()+30,900,40,100);
		g.drawLine(getHead_pos()+30,1000,getHead_pos()+20,1080);
		g.drawLine(getHead_pos()+70,1000,getHead_pos()+80,1080);		
	}

	public JSONObject getBody_landmark() {
		return body_landmark;
	}

	public int getHead_pos() {
		return head_pos;
	}
}