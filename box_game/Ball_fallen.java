package box_game;
import java.io.IOException;
import java.text.SimpleDateFormat;

import com.github.sarxos.webcam.*;

import java.awt.Color;
import java.awt.Graphics;
import java.io.File;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;

import org.json.JSONArray;
import org.json.JSONObject;

import com.github.sarxos.webcam.Webcam;

import java.io.File;
public class Ball_fallen{
	public Random rand = new Random();
	public int x, y;
	final Timer timer = new Timer();
	boolean flag=true;
	boolean first_time=true;
	Graphics g;
	List<Ball> data;
	List<player> players;
	static double count;
	static int score;
	public Ball_fallen(List<Ball> data,List<player> players, Graphics g, Integer score,Double count) {
		this.data = data;
		this.g = g;
		this.players=players;
		this.score=score;
		this.count=count;
	}
	public static double getCount() {
		return count;
	}
	public static int getScore() {
		return score;
	}
    /**
     * paint the little man, balls, score and timer on the graphics, and stop the thread 1 while the counter(timer*10) equals to 275,
     *  and other two thread counter(timer*10) equals to 300.
     * @return score: get the score of the player.
     */
	public int fallen_ball() {
		timer.schedule(new TimerTask() {
		    public void run(){
				if(count>=275.0) {
					this.cancel();
				}
		    	int number = rand.nextInt(10);
		    	if(number>=0 && number<=2){number=0;}
		    	else if(number >=3 && number <=6) {number = 1;}
		    	else if(number >=7 && number <=9) {number = 2;}
		    	else {number = 3;}
				for(int i=0;i<number;i++) {
					x = rand.nextInt(1860)+30;
					y = 0;
					Ball b = new Ball(x,y);
					data.add(b);
					if(flag==true) {
						Run r  = new Run(data,players,g,score);
						r.start();
						flag=false;
					}
				}
		    }
	      }, 100, 100);
		timer.schedule(new TimerTask() {

	    	String path="C:\\Users\\vicky\\Desktop\\java project\\camera_pics\\camera.png";
	    	File file1=new File(path);
	    	public void run(){
				if(count>=300.0) {
					timer.cancel();
					this.cancel();
		            System.gc();
		            cancel();
				}
		    	try {
		    		/*BufferedImage bi = ImageIO.read(file1);
					int width = bi.getWidth();
					int height = bi.getHeight();
					System.out.print(width);
					System.out.println(height);*/
					
					String player_pos = Get_api.get_player_pos(file1);
					if(!player_pos.contains("error_message")) {
						JSONObject jsonobj = new JSONObject(player_pos);
						JSONArray jsonary = (JSONArray) jsonobj.get("skeletons");
						for (int i = 0; i < Math.min(jsonary.length(),2); i++) {  
							JSONObject object = jsonary.getJSONObject(i);
				            //System.out.println(object);
				            JSONObject body_landmark = object.getJSONObject("landmark");
				    		JSONObject head = body_landmark.getJSONObject("head");
				    		int head_pos=(1920-(head.getInt("x")*(1920/80)));
				    		//System.out.println("headpos");
				    		//System.out.println(head_pos);
				    		if(head_pos<0) {
				    			head_pos=0;
				    		}
				    		else if(head_pos>1920) {
				    			head_pos=1920;
				    		}				            
				            
				            player person = new player(head_pos,body_landmark);
				            if(first_time==true) {
				            	players.add(person);
				            	first_time=false;
				            }
				            else {
				            	players.set(0, person);
				            }
				            //System.out.println(body_pos);
				            //System.out.println(body_landmark);
				        }
					}
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
		    }
	    }, 5, 100);
	    timer.schedule(new TimerTask() {
	    	public void run(){
	    		count=count+1;
	    		Webcam webcam = Webcam.getDefault();
	    		webcam.open();
	    		Date date = new Date();
	    		SimpleDateFormat sdf4 = new SimpleDateFormat("yyyyMMddHHmmssSSSS");
	    		String dateNowStr = sdf4.format(date);
	    		try {
					ImageIO.write(webcam.getImage(),"PNG",new File("C:\\Users\\vicky\\Desktop\\java project\\camera_pics\\camera.png"));
				} catch (IOException e) {
					e.printStackTrace();
				}
				if(count>=300.0) {
					webcam.close();
					timer.cancel();
					Main_program.game_over();
				}
	    	}
	    }, 0, 100);
	    return score;
	}
}