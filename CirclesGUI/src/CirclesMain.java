/**
 * Main program for the visualisation of circles in a window
 * @author Programming Methodology Professors
 * @version 1.0
 *
 */



public class CirclesMain {

	// Window where to show the circles
	private static MyWindow w = null;

	/**
	 * Program's main function
	 * @param args
	 */
	public static void main(String[] args) {

		// total number of circles to show
		final int TOTAL = 10;
		// array of circles with centre
		CircleWithCentre[] circles = new CircleWithCentre[TOTAL];

		// Create and show the application's window
		// (initially without circles)
		initializeWindow();
		
		for(int x = 0; x < TOTAL; x++)
			circles[x] = new CircleWithCentre(Dice.roll(250),Dice.roll(250),Dice.roll(50));
		
		for (int i=0;i<11;i++) {
			// Generate circles
			// centre with coordinates X and Y in the range [1..250]
			// and radius [1..50]
			
			/*
			 * ORIGINAL CODE
			for(int x = 0; x < TOTAL; x++)
				circles[x] = new CircleWithCentre(Dice.roll(250),Dice.roll(250),Dice.roll(50));
			*/

			// CONSOLE: show circles in text format
			for(CircleWithCentre c: circles)
				System.out.println(c);	

			// WINDOW: show circles (in the window)
			showCircles(circles);

			// We wait until the Enter key is pressed
			// MyKeyboard is a static class defined in MyWindow.java
			MyKeyboard.pressEnter();	
			moveCircles(circles,15);
		}
		// close and frees the resources used by the window
		closeWindow();
	}

	/**
	 * Randomly offsets either the x, y coordinates or the radius of all the circles from a given vector by an int from the interval [-k,k]
	 * 
	 * @param vector	- Contains all the circles to offset
	 * @param k			- Interval value
	 */
	private static void moveCircles(CircleWithCentre[] vector, int k) {
		for (int i=0;i<vector.length;i++) {
			int random = Dice.roll(3);
			if (random==1) {
				//Change x 
				if (Dice.roll(2)==1) {
					//Positive
					vector[i].offsetX(Dice.roll(k+1)-1);
				} else {
					//Negative
					vector[i].offsetX(-Dice.roll(k+1)-1);
				}
				vector[i].getCentre().setX(Math.max(vector[i].getCentre().getX(), 0));		//Check
			} else {
				if (random==2) {
					//Change y 
					if (Dice.roll(2)==1) {
						//Positive
						vector[i].offsetY(Dice.roll(k+1)-1);
					} else {
						//Negative
						vector[i].offsetY(-Dice.roll(k+1)-1);
					}
					vector[i].getCentre().setY(Math.max(vector[i].getCentre().getY(), 0));			//Check
				} else {
					//Change radius
					if (Dice.roll(2)==1) {
						//Positive
						vector[i].offsetRad(Dice.roll(k+1)-1);
					} else {
						//Negative
						vector[i].offsetRad(-Dice.roll(k+1)-1);
					}
					vector[i].setRadius(Math.max(vector[i].getRadius(), 0));			//Check
				}
			} 
		}
	}
	
	/**
	 * Creates and show the window with the title "Circles"
	 */
	private static void initializeWindow()
	{
		w = new MyWindow("Circles"); 
	}

	/**
	 * Closes the window 
	 */
	private static void closeWindow()
	{
		w.close();
	}

	/**
	 * Updates the array of circles to show in the window
	 * and repaint them
	 * @param circles array of circles to show
	 */
	private static void showCircles(CircleWithCentre[] circles)
	{
		// Show the circles in the window
		w.showCircles(circles);
	}
}
