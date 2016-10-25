# Pong

                                         d8b                                                 
                                         Y8P                                                 

                                 88888b. 88888888b.  .d88b. 88888b.  .d88b. 88888b.  .d88b.  
                                 888 "88b888888 "88bd88P"88b888 "88bd88""88b888 "88bd88P"88b 
                                 888  888888888  888888  888888  888888  888888  888888  888 
                                 888 d88P888888  888Y88b 888888 d88PY88..88P888  888Y88b 888 
                                 88888P" 888888  888 "Y8888888888P"  "Y88P" 888  888 "Y88888 
                                 888                     888888                          888 
                                 888                Y8b d88P888                     Y8b d88P 
                                 888                 "Y88P" 888                      "Y88P"  

                                                      ,;;;!!!!!;;.
                                                    :!!!!!!!!!!!!!!;
                                                  :!!!!!!!!!!!!!!!!!;
                                                 ;!!!!!!!!!!!!!!!!!!!;
                                                ;!!!!!!!!!!!!!!!!!!!!!
                                                ;!!!!!!!!!!!!!!!!!!!!'
                                                ;!!!!!!!!!!!!!!!!!!!'
                                                 :!!!!!!!!!!!!!!!!'
                                                  ,!!!!!!!!!!!!!''
                                               ,;!!!''''''''''
                                             .!!!!'
                                            !!!!`
PINGPONG ASCII Arts from http://ascii.co.uk/art/pingpong

This repository contains a series of codes and files that made up the game Pong. The codes or .java files have classes that explains java concepts and other comcepts of game programming. The consists of exactly four .java files (Game.java, Sound.java, Ball.java && Racquet.java) with three .wav files (fx.java, Ball.java, gameover.java).

These codes were implemented using a Sublime Text, and not an IDE. I highly suggests to download an IDE if you want to spare yourself from too much trouble. My recommendations are IntelliJ, Eclipse and NetBeans, and you may find the sites where to download them by asking or through Google or other search engines.

IMPLEMENTATION:

First, create a JFrame or the window:

      import javax.swing.JFrame;
      ...
      JFrame frame = new JFrame("Mini Tennis");
      frame.setSize(300, 300);
      frame.setVisible(true);
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      ...

Second, create a canvas of the game:

      import java.awt.Color;
      import java.awt.Graphics;
      import java.awt.Graphics2D;
      import java.awt.RenderingHints;
      import java.awt.geom.Ellipse2D;
      ...
      public void paint(Graphics g) {
      Graphics2D g2d = (Graphics2D) g;
      g2d.setColor(Color.RED);
      g2d.fillOval(0, 0, 30, 30);
      g2d.drawOval(0, 50, 30, 30);		
      g2d.fillRect(50, 0, 30, 30);
      g2d.drawRect(50, 50, 30, 30);

      g2d.draw(new Ellipse2D.Double(0, 100, 30, 30));
      }
      ...
      
Third, create a sprite class:

    import java.awt.Graphics2D;

    public class Ball {
    ...
    }
    
Fourth, implement what will happen when there are keyboard events:  

    import java.awt.event.KeyEvent;
    import java.awt.event.KeyListener;
    ...
    @Override
		public void keyTyped(KeyEvent e) {
		}

		@Override
		public void keyPressed(KeyEvent e) {
			System.out.println("keyPressed="+KeyEvent.getKeyText(e.getKeyCode()));
		}

		@Override
		public void keyReleased(KeyEvent e) {
			System.out.println("keyReleased="+KeyEvent.getKeyText(e.getKeyCode()));
		}
    ...

Fifth, adding other rules and functions to the game:

    import java.awt.Rectangle;
    ...
    private boolean collision() {
      return game.racquet.getBounds().intersects(getBounds());
    }

    public Rectangle getBounds() {
      return new Rectangle(x, y, DIAMETER, DIAMETER);
    }
    ...

Sixth, adding sounds: 

    import java.applet.Applet;
    import java.applet.AudioClip;
    import java.net.URL;
    ...
    
Laslty, add your modifications.

Instructions and Implementations from http://www.edu4java.com/en/game/game0-en.html

Documentations are printed or written with the codes but they are commented out. 

