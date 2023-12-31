package Asteroids2;
import javafx.scene.shape.Polygon;
import javafx.geometry.Point2D;

import static Asteroids2.Asteroids.PANE_HEIGHT;
import static Asteroids2.Asteroids.PANE_WIDTH;


public class Ship extends Character{
	public Long elapsedTime;
    public Double jumps;
    private Point2D movement;
    public boolean isInvincible;
    public int lives;
    public long collisionCooldown;
	public long lastCollisionTime;
	public static final int PANE_WIDTH = 1200;
	public static final int PANE_HEIGHT = 800;
    
	public Ship(int x, int y) {
        super(new Polygon(-10, -10, 20, 0, -10, 10), x, y);
		this.elapsedTime = (long) 0;
        this.jumps = 0.0;
        this.movement = new Point2D(0, 0);
        this.isInvincible = false;
        this.lives = 3;
        this.collisionCooldown = 1000000000L; // 1 second cooldown
		this.lastCollisionTime = 0L;
	}
	/*
	 * public void setMovement(Point2D movement) { this.movement = movement; }
	 */
	
	
	private int hyperJumpTimer = 0;
	public void hyperspaceJump(Ship dummyShip) {
	    // Get the new position from the dummyShip's position
	    double newX = dummyShip.getCharacter().getTranslateX();
	    double newY = dummyShip.getCharacter().getTranslateY();

	    // Set the new position and reset the movement vector
	    this.getCharacter().setTranslateX(newX);
	    this.getCharacter().setTranslateY(newY);
	    this.setMovement(new Point2D(0,0));
	}

	public void resetShip() {
		this.lives--;
		this.isInvincible = true;
		this.getCharacter().setTranslateX(PANE_WIDTH / 2);
		this.getCharacter().setTranslateY(PANE_HEIGHT / 2);
		this.lastCollisionTime = System.nanoTime();
	}

	
	
	
	
	/*
	 * public void update(double deltaTime) { this.elapsedTime += deltaTime;
	 * this.position.add(this.getMovement().getX()*deltaTime,
	 * this.getMovement().getY()*deltaTime); this.move(); }
	 */
}
