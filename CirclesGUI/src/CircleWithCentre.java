
public class CircleWithCentre extends Circle{
	
	private Point centre;
	
	public CircleWithCentre(int x, int y, double r) {
		super(r);
		centre=new Point (x,y);
	}
	
	public double getRadius () {
		return super.getRadius();
	}
	
	public void setRadius (double r) {
		super.setRadius(r);
	}
	
	public Point getCentre () {
		return centre;
	}
	public void setCentre (int x, int y) {
		centre.setX(x);
		centre.setY(y);
	}
	
	public void setCentre (Point c) {
		setCentre(c.getX(),c.getY());
	}
	
	public double perimeter () {
		return 2*Math.PI*getRadius();
	}
	
	public double area () {
		return Math.PI*Math.pow(getRadius(), 2);
	}
	
	public static boolean overlaps (CircleWithCentre c, CircleWithCentre d) {
		return ((d.getRadius()+c.getRadius())>(Point.distance(c.getCentre(),d.getCentre())));
	}
	@Override
	public String toString() {
		return String.format("Circle With Centre: \n \t Centre: (%d,%d) \n \t Radius: %.3f. \n \t Perimeter: %.3f. \t Area: %.3f.",
											centre.getX(),centre.getY(),		getRadius(),			perimeter(),		area());
	}
	
	/**
	 * Offsets the x coordinate of the center by an integer
	 * @param x - offset
	 */
	public void offsetX(int x) {
		getCentre().setX(getCentre().getX()+x);
	}
	
	/**
	 * Offsets the y coordinate of the center by an integer
	 * @param y - offset
	 */
	public void offsetY(int y) {
		getCentre().setY(getCentre().getY()+y);
	}
	
	/**
	 * Offsets the radius of the circle by an integer
	 * @param r - offset
	 */
	public void offsetRad(int r) {
		setRadius(getRadius()+r);
	}
	
	/**
	 * Offsets the radius of the circle by a double
	 * @param r - offset
	 */
	public void offsetRad(double r) {
		setRadius(getRadius()+r);
	}
	
	/**
	 * Sets all attributes of given CircleWithCentre to 0
	 */
	public void nullify () {
		setRadius(0);
		setCentre(0,0);
	}
	
	/**
	 * Verifies wether a given CircleWithCentre is null or not
	 * @return boolean - True if not null
	 */
	public boolean notNull() {
		return (getRadius()!=0 || getCentre().getX()!=0 || getCentre().getY()!=0);
	}
	
	public void absorb(CircleWithCentre c) {
		setRadius(Math.sqrt(Math.pow(getRadius(),2)+Math.pow(c.getRadius(), 2)));
		setCentre((int) ((area()*Point.distance(getCentre(), c.getCentre()))/(area()+c.area())/Point.distance(getCentre(), c.getCentre())*(getCentre().getX()-c.getCentre().getX())+c.getCentre().getX()),
				  (int) ((area()*Point.distance(getCentre(), c.getCentre()))/(area()+c.area())/Point.distance(getCentre(), c.getCentre())*(getCentre().getY()-c.getCentre().getY())+c.getCentre().getY()));
		c.nullify();
	}
	
}
