package box_game;
import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.*;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;

import javax.swing.*;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.sql.*;
import java.sql.*;

public class Get_answer_and_paint {
	public static String usename1="Player1";
    /**
     * Paint the button and text on the login page, and call the game_UI while click the Start Game button.
     * @param playground: the main JFrame of the Main_program
     * @param panel: the Jpanel of the main JFrame
     * @see Main_program
     */
	public static void placeComponents(JPanel panel,JFrame playground) {

        panel.setLayout(null);//clean default place and use customer set position for text and button

        JLabel userLabel1 = new JLabel("Player ID:");//users set
        userLabel1.setFont(new Font(Font.DIALOG_INPUT,Font.BOLD, 50));
        userLabel1.setBounds(550,370,400,65);
        panel.add(userLabel1);

        JTextField user1Text = new JTextField(20);
        user1Text.setFont(new Font(Font.DIALOG_INPUT,Font.BOLD, 50));
        user1Text.setBounds(900,370,450,65);
        panel.add(user1Text);
        
        JButton startButton = new JButton("Start Game");
        startButton.setFont(new Font(Font.DIALOG_INPUT,Font.BOLD, 50));
        startButton.setBounds(650, 600, 550, 165);
        panel.add(startButton);   
        playground.setVisible(true);
        startButton.addActionListener(e -> {
        	usename1=user1Text.getText();
        	Main_program.game_UI(usename1);
		});
        
        
    }
    /**
     * Paint the text on the game_over page.
     * @param score: the score of the player.
     * @param panel: the Jpanel of the main JFrame
     */
	public static void game_over(JPanel panel,Integer score) {
        panel.setLayout(null);//clean default place and use customer set position for text and button

        JLabel userLabel1 = new JLabel("Game Over");//users set
        userLabel1.setFont(new Font(Font.DIALOG_INPUT,Font.BOLD, 70));
        userLabel1.setBounds(750,370,400,65);
        panel.add(userLabel1);
        
        JLabel userLabel2 = new JLabel("Your score: "+String.valueOf(Run.getScore()));//users set
        userLabel2.setFont(new Font(Font.DIALOG_INPUT,Font.BOLD, 70));
        userLabel2.setBounds(650,500,1000,65);
        panel.add(userLabel2);

	}
    /**
     * Paint the score text on the review_sc page, and get the data from the database.
     * @param user_info: the ID of the player.
     * @param panel: the Jpanel of the main JFrame
     */
	public static void review_sc(JPanel panel,String user_info) {
        panel.setLayout(null);//clean default place and use customer set position for text and button
		int[] score=new int[3];
		String[] player_ID=new String[4];
        try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String dbName = "db19204246";
			String username = "u19204246";
			String password = "COMP20300";
			Connection con;
			con = DriverManager.getConnection("jdbc:mysql://folding03.ucd.ie:3306/"+dbName, username, password);
			Statement stmt=con.createStatement();
			
			stmt.executeUpdate("insert into Catch_the_ball (PlayerID, Score) values\n" +
					"('"+usename1+"', '"+String.valueOf(Run.getScore())+"');");
			int count=0;
			ResultSet rs = stmt.executeQuery("select * from Catch_the_ball;");
			while(rs.next()) {
				if (count<3) {
					score[count]=rs.getInt(2);
					player_ID[count]=rs.getString(1);
				}
				else {
					if(rs.getInt(2)>score[0]) {
						score[2]=score[1];
						score[1]=score[0];
						player_ID[2]=player_ID[1];
						player_ID[1]=player_ID[0];
						score[0]=rs.getInt(2);
						player_ID[0]=rs.getString(1);
					}
					else if(rs.getInt(2)>score[1]){
						score[1]=score[0];
						player_ID[1]=player_ID[0];
						score[1]=rs.getInt(2);
						player_ID[1]=rs.getString(1);
					}
					else if(rs.getInt(2)>score[2]) {
						score[2] = rs.getInt(2);
						player_ID[2] = rs.getString(1);
					}
				}
				count=count+1;
			}
			
		} catch (SQLException |ClassNotFoundException e) {
			e.printStackTrace();
		}		
		JLabel userLabel1 = new JLabel(player_ID[0]+": "+String.valueOf(score[0]));//users set
        userLabel1.setFont(new Font(Font.DIALOG_INPUT,Font.BOLD, 70));
        userLabel1.setBounds(650,370,1500,65);
        panel.add(userLabel1);
        
		JLabel userLabel2 = new JLabel(player_ID[1]+": "+String.valueOf(score[1]));//users set
        userLabel2.setFont(new Font(Font.DIALOG_INPUT,Font.BOLD, 70));
        userLabel2.setBounds(650,470,1500,65);
        panel.add(userLabel2);
        
		JLabel userLabel3 = new JLabel(player_ID[2]+": "+String.valueOf(score[2]));//users set
        userLabel3.setFont(new Font(Font.DIALOG_INPUT,Font.BOLD, 70));
        userLabel3.setBounds(650,570,1500,65);
        panel.add(userLabel3);
	}
}