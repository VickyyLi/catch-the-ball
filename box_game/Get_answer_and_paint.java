package box_game;
import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.*;

public class Get_answer_and_paint {
	public static Color color1 = Color.white;
	public static String usename1="Player1";

	public static Two_tuple<String,Color> placeComponents(JPanel panel) {

        panel.setLayout(null);//clean default place and use customer set position for text and button

        JLabel userLabel1 = new JLabel("Player 1:");//users set
        userLabel1.setFont(new Font(Font.DIALOG_INPUT,Font.BOLD, 50));
        userLabel1.setBounds(400,320,290,65);
        panel.add(userLabel1);

        JTextField user1Text = new JTextField(20);
        user1Text.setFont(new Font(Font.DIALOG_INPUT,Font.BOLD, 50));
        user1Text.setBounds(700,320,450,65);
        panel.add(user1Text);
        usename1 = user1Text.getText();
        
        JButton choose1 = new JButton("choose color");
        choose1.setFont(new Font(Font.DIALOG_INPUT,Font.BOLD, 50));
        choose1.setBounds(690, 720, 460, 70);
        panel.add(choose1);
        choose1.addActionListener(e -> {
				color1 = JColorChooser.showDialog(panel, "choose color", color1);
		});
         
        return new Two_tuple<String,Color>(usename1,color1);
    }

}