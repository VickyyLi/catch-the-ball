package box_game;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.swing.*;

public class Main_program {
	JFrame playground = new JFrame("Login Example");
    public static void main(String[] args) throws Exception{
    	Main_program fallen_ball_game = new Main_program();
    	fallen_ball_game.paint_main();
    }
   
    
    public void paint_main() {
    	//login_in page design,get username
    	Get_answer_and_paint login_page= new Get_answer_and_paint();
    	playground.setSize(1920, 1060);
    	playground.setTitle("login");
    	playground.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//set if the window can be closed
        JPanel panel = new JPanel();    
        playground.add(panel);//add panel
        //all the information get from player, name and color
        Two_tuple<String,Color>user_info= login_page.placeComponents(panel);
        System.out.println(user_info);
        JButton startButton = new JButton("Start Game");
        startButton.setFont(new Font(Font.DIALOG_INPUT,Font.BOLD, 50));
        startButton.setBounds(1300, 350, 350, 405);
        panel.add(startButton);   
        playground.setVisible(true);
        startButton.addActionListener(e -> {
        	game_UI(user_info);
		});
    }

	public void game_UI(Two_tuple<String, Color> user_info) {
		playground.setTitle("Use head to catch the ball");
		playground.setSize(1920, 1060);
		playground.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		playground.setVisible(true);
		playground.setLocationRelativeTo(null);
		playground.setBackground(new Color(0, 0, 0));
		playground.getContentPane().setVisible(false);
		
		Graphics g = playground.getGraphics();
		List<Ball> data = new ArrayList();//add data of all balls
		List<player> players = new ArrayList();
		Ball_fallen bl = new Ball_fallen(data,players, g,user_info.getC());
		bl.fallen_ball();
	}
    
}
