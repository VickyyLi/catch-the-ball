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
	Color color;
	public Ball_fallen(List<Ball> data,List<player> players, Graphics g, Color color) {
		this.data = data;
		this.g = g;
		this.color=color;
		this.players=players;
	}
	public void fallen_ball() {//get fallen ball every 1000ms
		timer.schedule(new TimerTask() {
		    public void run(){
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
						Run r  = new Run(data,players,g,color);
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
				            System.out.println(object);
				            JSONObject body_landmark = object.getJSONObject("landmark");
				    		JSONObject head = body_landmark.getJSONObject("head");
				    		int head_pos=(1920-(head.getInt("x")*(1920/160))-(1920/2))*2;
				    		if(head_pos<0) {
				    			head_pos=0;
				    		}
				    		else if(head_pos>1920) {
				    			head_pos=1920;
				    		}				            
				            
				            player person = new player(head_pos,body_landmark,color);
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
	    	}
	    }, 0, 100);
	}
}