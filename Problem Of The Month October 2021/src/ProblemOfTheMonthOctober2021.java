import java.io.*;
public class ProblemOfTheMonthOctober2021 
{
	public static void main(String args[])
	{
		/* This is declaration of variables to be used in the calculations. */
		double radius = 5;
		double xCenter = 14;
		double yCenter = -12;
		double observationLocationx = xCenter - radius;
		double observationLocationy;
		double observationAngle;
		double ax = 4;
		double ay = 0;
		double bx = -4;
		double by = 0;
		double sideAB = 8;
		double sideBP;
		double sidePA;
		double largestAngle = 0;
		double largestAnglex = 0;
		double largestAngley = 0;
		
		/* This is a loop to find the angle for all values on the circle from 9 to 19 incrementing by .00000000001 */
		while(observationLocationx <= (xCenter + radius))
		{
			for(int x = 0; x < 2; x++) /*For loop and if statement to go through each value of x twice because for a circle each x has two ys*/
			{
				if(x == 0) /*For when I take the square root giving me the positive answer on the first iteration*/
				{
					observationLocationy = Math.pow(25.0 - Math.pow(observationLocationx - xCenter, 2.0), .5) - yCenter; 
				}
				else /*For when I take the square root giving me the negative answer on the second iteration*/
				{
					observationLocationy = -Math.pow(25.0 - Math.pow(observationLocationx - xCenter, 2.0), .5) - yCenter;
				}
				
				/*Finding side BP using the pythagorean theorem*/
				sideBP = Math.pow(Math.pow(observationLocationx - bx, 2) + Math.pow(observationLocationy - by, 2), .5);
				/*Finding side PA using the pythagorean theorem*/
				sidePA = Math.pow(Math.pow(observationLocationx - ax, 2) + Math.pow(observationLocationy - ay, 2), .5);
				/*Finding angle APB using the law of cosines*/
				observationAngle = Math.acos((Math.pow(sideBP, 2) + Math.pow(sidePA, 2) - Math.pow(sideAB, 2)) / (2 * sideBP * sidePA));
				/*Converting from radians to degrees*/
				observationAngle = (observationAngle * 180) / Math.PI;
				/*Comparing the angle just calculated to the largest one found so far*/
				if(observationAngle >= largestAngle)
				{
					/*Stores the information regarding the largest angle found so far*/
					largestAngle = observationAngle;
					largestAnglex = observationLocationx;
					largestAngley = observationLocationy;
				}
				
			}
				/*Increments the loop for the next calculations*/
				observationLocationx = observationLocationx + .000001;
		}
		/*Prints the location and angle of the largestAngle APB on the given circle*/
		System.out.println("Winner!");
		System.out.println("The largest angle is:" + largestAngle + "at");
		System.out.println("x: " + largestAnglex);
		System.out.println("y: " + largestAngley);
		
	}

}
