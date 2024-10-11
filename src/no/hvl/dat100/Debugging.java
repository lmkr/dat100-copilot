package no.hvl.dat100;

public class Debugging {

	public static double findMax(double[] da) {

		double max; 
		
		max = da[0];
		
		for (double d : da) {
			if (d < max) {
				max = d;
			}
		}
		
		return max;
	}
	
}
