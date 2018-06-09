package zeldiablo;

public class Coordonnee {
	private int x,y;
	
	public Coordonnee(int cX, int cY) {
		this.x = cX;
		this.y = cY;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}
	
	public void incrementerX() {
		this.x+=1;
	}
	
	public void incrementerY() {
		this.y+=1;
	}
	
	public void decrementerX() {
		this.x-=1;
	}
	
	public void decrementerY() {
		this.y-=1;
	}
	
}
