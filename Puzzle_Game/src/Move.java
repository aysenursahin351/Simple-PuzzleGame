
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import enigma.console.TextWindow;
import enigma.core.Enigma;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.io.Reader;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

import enigma.core.Enigma;
public class Move {
	
	public static enigma.console.Console cn = Enigma.getConsole("Game", 150, 45);
	public KeyListener klis;
	public int keypr;
	public int rkey;
	public static int px = 1;
	public static int py = 3;
	int first = 65;
	int last = 90;
	Game game1 = new Game();
	
	public void MovementSettings() { // MOVEMENTS INFO SECTION
		cn.getTextWindow().setCursorPosition(px, py);
		cn.getTextWindow().setCursorType(1);
		klis = new KeyListener() {
			public void keyTyped(KeyEvent e) {
			}

			public void keyPressed(KeyEvent e) {
				if (keypr == 0) {
					keypr = 1;
					rkey = e.getKeyCode();
				}
			}

			public void keyReleased(KeyEvent e) {
			}
		};
		cn.getTextWindow().addKeyListener(klis);
	}
	public void MoveKeys() throws InterruptedException { // MOVEMENT CONTROLLLER
		if (keypr == 1) { // if keyboard button pressed
			if (rkey == KeyEvent.VK_LEFT)
				px--;
			if (rkey == KeyEvent.VK_RIGHT)
				px++;
			if (rkey == KeyEvent.VK_UP)
				py--;
			if (rkey == KeyEvent.VK_DOWN)
				py++;
			String harf="";
			
			if(rkey >= first && rkey < last) {
			
				harf = (String.valueOf(Character.toChars(rkey)));
				System.out.println(harf.toLowerCase());
				
			}
			if (rkey==KeyEvent.VK_SPACE) {
                game1.dll1.sortedInsert2(game1.player1Score, "player1");
                game1.dll1.sortedInsert2(game1.player2Score, "player2");
                game1.fordll(game1.dll1);
                game1.dll2.printList(game1.dll2.head);
             }
				
				
			if (px == 0)
				px = 1;
			if (px == 17)
				px = 16; // sınırar
			if (py == 2)
				py = 3;
			if (py == 18)
				py = 17;
			keypr = 0; // last action
		}

		Thread.sleep(20);
	}
	
}
