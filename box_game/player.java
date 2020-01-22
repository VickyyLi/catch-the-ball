package box_game;

import java.awt.Color;
import java.awt.Graphics;
import org.json.JSONObject;
public class player {
	private JSONObject body_landmark;
	private int head_pos;
	public player(int head_pos, JSONObject body_landmark) {
		this.head_pos = head_pos;
		this.body_landmark = body_landmark;
	}
    /**
     * draw the little man on the graphics.
     * @param g: the graphics to paint on.
     */
	public void draw(Graphics g) {
		JSONObject head = getBody_landmark().getJSONObject("head");
		g.setColor(Color.white);
		g.drawOval(getHead_pos(), 800, 100, 100);	
		g.drawLine(getHead_pos()+70,900, getHead_pos()+170,800 );
		g.drawLine(getHead_pos()+30,900, getHead_pos()-70,800 );
		g.drawRect(getHead_pos()+30,900,40,100);
		g.drawLine(getHead_pos()+30,1000,getHead_pos()+20,1080);
		g.drawLine(getHead_pos()+70,1000,getHead_pos()+80,1080);		
	}
    /**
     * return the body_landmark of the image.
     * @return body_landmark: the json format of the body_landmark by little man.
     */
	public JSONObject getBody_landmark() {
		return body_landmark;
	}
    /**
     * return the head_pos of little man in int format.
     * @return head_pos: the position of head in the image.
     */
	public int getHead_pos() {
		return head_pos;
	}
}