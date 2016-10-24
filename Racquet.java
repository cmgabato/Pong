import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;

public class Racquet {																		//racquet's "Sprite" class
	int y = 0;																				//position in the y-axis
	int width = 0;																			//racquet's length
	int height = 0;																			//racquet's thickness
																							
	int x = 0;																				//position in the x-axis
	int xa = 0;																				//speed in the x-axis
	int score = 0;																			//score when racquet hits the ball
	private Game game;																		//the game

	public Racquet(Game game, int x, int y, int width, int height) {						//Racquet's overloaded constructor
		this.game = game;																	//'the' game
		this.x = x;																			//setting the position in the x-axis	
		this.y = y;																			//setting the position in the y-axis
		this.width = width;																	//setting the length to a certain number of pixels
		this.height = height;																//setting the thickness to a certain number of pixels
	}

	public void setScore() {																//adding the score by 1 if there is a collision
		score += 1;
	}

	public int getScore() {																	//getting the sore to be printed on the game
		return score;
	}

	public void move() {																	//the racquet's move method
		if (x + xa > 0 && x + xa < game.getWidth() - width)									//conditions for racquets not to surpass the alloted pixels of the frame
			x = x + xa;																		//displaces the racquet
	}

	public void paint(Graphics2D g) {														//paints the racquet
		g.fillRect(x, y, width, height);
	}

	public void keyReleased(KeyEvent e) {													//for moving along the x-axis; key released
		xa = 0;
	}

	public Rectangle getBounds() {															//the bounds of the racquet
		return new Rectangle(x, y, width, height);											//important when the ball and a racquet collides
	}

	public int getTopY() {																	//gets the top y-axis; for the racquet located at the bottom
		return y - height;
	}

	public int getBottomY() {																//gets the bottom y-axis; for the racquet located at the top
		return y;
	}
}