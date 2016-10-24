import java.awt.Graphics2D;
import java.awt.Rectangle;

public class Ball {																		//Ball's "Sprite" class
	private static final int DIAMETER = 30;												//Ball's diameter set to constant
																							
	int x = 0;																			//position in the x-axis
	int y = 0;																			//position in the y-axis
	int xa = 1;																			//speed in the x-axis
	int ya = 1;																			//speed in the y-axis
	private Game game;																	//'the' game

	public Ball(Game game) {															//ball's overloaded constructor
		this.game = game;																//the game
	}

	void move() throws InterruptedException{											//The ball's move method
		boolean changeDirection = true;													//Setting the truth valuse if the ball changes direction
		if (x + xa < 0) xa = game.speed;												//if the ball's position is less than the right displacement in the x-axis, displace again
		else if (x + xa > game.getWidth() - DIAMETER) xa = -game.speed;					//if the ball's position is more than the right displacement in the x-axis, displace again
		else if (y + ya < 0) {															//If racquet 2 does not receive the ball, racquet 1 increments a point
			game.racquet1.setScore();
			ya = game.speed;
		}																									 
		else if (y + ya > game.getHeight() - DIAMETER) {
			game.racquet2.setScore();
			ya = -game.speed;
		}
		else if (collision1()){																				//if the ball collides with player 1's racquet
			ya = -game.speed;																				
			y = game.racquet1.getTopY() - DIAMETER;															//displace...
		} 
		else if (collision2()){																				//if the ball collides with player 2's racquet
			ya = game.speed;
			y = game.racquet2.getBottomY() + DIAMETER;														//displace...																		//ncrementing Player 2's score
			game.speed++;																					//incrementing speed
		}
		else if ((game.racquet1.getScore() >= 3) || (game.racquet2.getScore() >= 3)) game.gameOver();
		else changeDirection = false;																		//the ball continues to roll
		
		if (changeDirection) 
			Sound.BALL.play();															//if it hits one of the racquet, a sound will echo
		x += xa;																		//ball's new position in the x-axis
		y += ya;																		//ball's new position in the y-axis
	}

	private boolean collision1() {														//methos of collision with racquet no. 1
		return game.racquet1.getBounds().intersects(getBounds());						//returns true if they hit, otherwise false
	}

	private boolean collision2() {														//method of collision with racquet no. 2
		return game.racquet2.getBounds().intersects(getBounds());						//returns true if they hit, otherwise false
	}

	public void paint(Graphics2D g) {													//paints the ball
		g.fillOval(x, y, DIAMETER, DIAMETER);
	}

	public Rectangle getBounds() {														//the bounds of the ball
		return new Rectangle(x, y, DIAMETER, DIAMETER);									//important when the ball and a racquet collides
	}
}