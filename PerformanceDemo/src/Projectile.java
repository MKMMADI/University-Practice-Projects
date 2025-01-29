import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class Projectile {
	//Track the object
	private boolean isActive;
	private Circle body;
	
	public Projectile() {
		body = new Circle(10, Color.RED);
		isActive=true;
		
		//simulate a heavy object
		try {
			Thread.sleep(10);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//facade methods to make it easier
	public void updateBody(double x, double y) {
		body.setCenterX(x);
		body.setCenterY(y);
	}
	
	public void moveVertically(double velocity) {
		double newLocation = velocity + body.getCenterY();
		body.setCenterY(newLocation);
	}
	
	public double getBodyX() {
		return body.getCenterX();
	}
	
	public double getBodyY() {
		return body.getCenterY();
	}
	
	public boolean isActive() {
		return isActive;
	}
	
	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}
	
	public Circle getBody() {
		return body;
	}
	
	public void setBody(Circle body) {
		this.body = body;
	}
	
	
}
