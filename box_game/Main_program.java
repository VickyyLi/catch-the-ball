package box_game;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.io.File;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;

import javax.swing.*;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.text.SimpleDateFormat;
public class Main_program {
	public static int score=0;  
	public static double count=0.0;
	public static String user_info;
	static JFrame playground = new JFrame("Login Example");
    public static void main(String[] args) throws Exception{
    	Main_program fallen_ball_game = new Main_program();
    	fallen_ball_game.paint_main();
    }
    /**
     * Set the property of the JFrame playground of login window, and call the placeComponents to paint on window
     * @see Get_answer_and_paint
     */
    public void paint_main() {
		playground.getContentPane().removeAll();
		playground.repaint();
        playground.setVisible(true);
		playground.setLocationRelativeTo(null);
		playground.setBackground(new Color(255, 255, 255));
		playground.getContentPane().setVisible(true);   	
    	//login_in page design,get username
    	Get_answer_and_paint login_page= new Get_answer_and_paint();
    	playground.setSize(1920, 1060);
    	playground.setTitle("login");
    	playground.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//set if the window can be closed
        JPanel panel = new JPanel();    
        playground.add(panel);//add panel
        Get_answer_and_paint.placeComponents(panel,playground);
    }
    /**
     * Set the property of the JFrame playground of game_UI, initilize parameters, and call the fallen_ball method to start the multithread.
     * @param user_info: the player_ID.
     * @see Get_answer_and_paint
     */
	public static void game_UI(String user_info) {
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
		Ball_fallen bl = new Ball_fallen(data,players, g,score,count);
		score=bl.fallen_ball();
	}
    /**
     * Set the property of the JFrame playground of game_over window, call the game_over method to paint the window, and paint the button on the window
     * @see Get_answer_and_paint
     */
	public static void game_over() {
		playground.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		playground.getContentPane().removeAll();
		playground.repaint();
    	Get_answer_and_paint game_over= new Get_answer_and_paint();
    	playground.setSize(1920, 1060);
    	playground.setTitle("game_over");
    	playground.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//set if the window can be closed
        playground.setVisible(true);
		playground.setLocationRelativeTo(null);
		playground.setBackground(new Color(255, 255, 255));
		playground.getContentPane().setVisible(true);
        playground.setVisible(true);

    	JPanel panel = new JPanel();    
        playground.add(panel);//add panel
        game_over.game_over(panel,score);
        JButton viewscore = new JButton("View Scores");
        viewscore.setFont(new Font(Font.DIALOG_INPUT,Font.BOLD, 40));
        viewscore.setBounds(550, 600, 350, 125);
        panel.add(viewscore);           
        
        JButton startButton = new JButton("Start Game");
        startButton.setFont(new Font(Font.DIALOG_INPUT,Font.BOLD, 40));
        startButton.setBounds(950, 600, 350, 125);
        panel.add(startButton);   
        viewscore.addActionListener(e -> {
        	view_scores();
		});
        startButton.addActionListener(e -> {
        	Main_program fallen_ball_game = new Main_program();
        	fallen_ball_game.paint_main();
		});
	}
    /**
     * Set the property of the JFrame playground of view_scores window, call the review_sc method to paint the window, and paint the button on the window
     * @see Get_answer_and_paint
     */
	public static void view_scores() {
		playground.getContentPane().removeAll();
		playground.repaint();
    	playground.setSize(1920, 1060);
    	playground.setTitle("game_over");
    	playground.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//set if the window can be closed
        playground.setVisible(true);
		playground.setLocationRelativeTo(null);
		playground.setBackground(new Color(255, 255, 255));
		playground.getContentPane().setVisible(true);
    	
    	JPanel panel = new JPanel();    
        playground.add(panel);//add panel        
        Get_answer_and_paint.review_sc(panel,user_info);
        
        
        JButton startButton = new JButton("Start Game");
        startButton.setFont(new Font(Font.DIALOG_INPUT,Font.BOLD, 40));
        startButton.setBounds(750, 700, 350, 125);
        panel.add(startButton);   
        playground.setVisible(true);
        startButton.addActionListener(e -> {
        	Main_program fallen_ball_game = new Main_program();
        	fallen_ball_game.paint_main();
		});
	}
    
}
