package box_game;

import static org.junit.jupiter.api.Assertions.*;

import java.io.File;

import org.junit.jupiter.api.Test;

class test_api {

	@Test
	void test() {
    	String path="C:\\Users\\vicky\\Desktop\\java project\\camera_pics\\camera.png";
    	File file1=new File(path);
		String player_pos = null;
    	try {
			player_pos = Get_api.get_player_pos(file1);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
    	assertNotEquals(player_pos, null);
	}

}
