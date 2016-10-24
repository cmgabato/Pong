import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

@SuppressWarnings("serial")																//instruct the compiler to ignore or suppress
public class Game extends JPanel {														//Helps in overwriting the paint method
																						
	Ball ball = new Ball(this);															//Creates a ball
	Racquet racquet1 = new Racquet(this, 0, 335, 60, 10);								//Creates a racquet for Player 1
	Racquet racquet2 = new Racquet(this, 220, 20, 60, 10);								//Creates a racquet for Player 2	
	int speed = 1;																		//Speed of the game, specifically the ball

	public Game() {
		addKeyListener(new KeyListener() {												//mehtod that accpets the key typed
			@Override
			public void keyTyped(KeyEvent e) {
			}

			@Override
			public void keyReleased(KeyEvent e) {										//Method that accept the key released
				racquet1.keyReleased(e);												//key released by Player 1	
				racquet2.keyReleased(e);												//key released by Player 2	
			}

			@Override
			public void keyPressed(KeyEvent e) {										//Method that accepts the key pressed
				if (e.getKeyCode() == KeyEvent.VK_LEFT) racquet1.xa = -speed;			//For PLayer 1: Left and Right respectively
				if (e.getKeyCode() == KeyEvent.VK_RIGHT) racquet1.xa = speed;
				if (e.getKeyCode() == KeyEvent.VK_A) racquet2.xa = -speed;				//For PLayer 2: Left and Right respectively
				if (e.getKeyCode() == KeyEvent.VK_D) racquet2.xa = speed;
			}
		});

		setFocusable(true);
		Sound.BACK.loop();																//Loops the background sound
	}

	private void move() throws InterruptedException {
		ball.move();																	//calling the method that moves the ball
		racquet1.move();																//calling the method that moves the racquet of Player 1
		racquet2.move();																//calling the method that moves the racquet of Player 2
	}

	@Override
	public void paint(Graphics g) {		
		Graphics2D g2d = (Graphics2D) g;												//provides control over geometry, coordinate transformation, color management and text layout
		super.paint(g);																								//cleans the game
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);					//creating a Graphics2D object by typecasting a Graphics object
		g2d.setFont(new Font("Verdana", Font.BOLD, 20));															//Setting the game's font (Font("Font type", Font typography, Font size))

		g2d.setColor(Color.BLACK);														//Setting the ball's color
		ball.paint(g2d);																//painting the ball with the set color

		g2d.setColor(Color.RED);														//Setting the Player 1 racquet's color
		racquet1.paint(g2d);															//painting...	
		g2d.drawString("P1:"+String.valueOf(racquet1.getScore()), 220, 350);			//Displaying the score of Player 1 on the game

		g2d.setColor(Color.BLUE); 														//Setting the Player 2 racquet's color
		racquet2.paint(g2d);															//painting...
		g2d.drawString("P2:"+String.valueOf(racquet2.getScore()), 10, 30);				//Displaying the score of Player 2 on the game

		g2d.setColor(Color.PINK);														//Adding a watermark (lol)
		g2d.drawString("PING!PONG!", 80, 180);											//Displaying... ("What to draw", x-axis, y-axis)
	}

	public void gameOver() throws InterruptedException{															//If the game is over 
		Sound.BACK.stop();																						//Stops the background music
		Sound.GAMEOVER.play();	
		if (racquet1.getScore() >= 3)																																//Plays the game over sound	
			JOptionPane.showMessageDialog(this, "PLAYER 1 WINS", "Game Over", JOptionPane.YES_NO_OPTION);		//Displays the status after the game is over	
		else
			JOptionPane.showMessageDialog(this, "PLAYER 2 WINS", "Game Over", JOptionPane.YES_NO_OPTION);
		int n = JOptionPane.showConfirmDialog(this, "CONTINUE?","",JOptionPane.YES_NO_OPTION);					//When you want to continue playing
		if(n == JOptionPane.YES_NO_OPTION){																		//If YES; creates a new game
			restart();
		}
		System.exit(ABORT);																//If NO; stops the game
	}

	public static void restart() throws InterruptedException{
		JFrame frame = new JFrame("Mini Tennis");										//creates a window that is named as "Mini Tennis"
		Game game = new Game();															//creates a game	
		frame.add(game);																//adds the game to the window
		frame.setSize(300, 400);														//set the game plane by pixels, in this case (x, y) == (300, 400)
		frame.setVisible(true);															//makes the window visible
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);							//Stops the program from runninf if closed	

		while(true){																	//loops the game
			game.move();																//calling the game's move method to start playing
			game.repaint();																//used to cause paint() to be invoked. paint() is a method supports painting via a Graphics object
			Thread.sleep(10);															////tells the processor that the thread which is being run must sleep for milliseconds, in this case 10 milliseconds
		}
	}

	public static void main(String[] args) throws InterruptedException{
		restart();
	}
}