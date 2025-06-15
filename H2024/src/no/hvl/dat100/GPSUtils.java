package no.hvl.dat100;

import static java.lang.Math.*;

public class GPSUtils {

	public static double findMax(double[] da) {

		double max; 
		
		max = da[0];
		
		for (double d : da) {
			if (d > max) {
				max = d;
			}
		}
		
		return max;
	}

	public static double findMin(double[] da) {

		double min;
		
		min = da[0];

		for (double d : da) {
			if (d < min) {
				min = d;
			}
		}

		return min;
	}

	public static double[] getLatitudes(GPSPoint[] gpspoints) {

		
		double[] latitudes = new double[gpspoints.length];

		for (int i = 0; i < latitudes.length; i++) {
			latitudes[i] = gpspoints[i].getLatitude();
		}

		return latitudes;
		
	}

	public static double[] getLongitudes(GPSPoint[] gpspoints) {
		
		double[] longitudes = new double[gpspoints.length];

		for (int i = 0; i < longitudes.length; i++) {
			longitudes[i] = gpspoints[i].getLongitude();
		}

		return longitudes;

	}

	private static final int R = 6371000; // jordens radius

	public static double distance(GPSPoint gpspoint1, GPSPoint gpspoint2) {

		double d;
		double latitude1, longitude1, latitude2, longitude2;
		
		latitude1 = gpspoint1.getLatitude();
		longitude1 = gpspoint1.getLongitude();

		latitude2 = gpspoint2.getLatitude();
		longitude2 = gpspoint2.getLongitude();

		double phi1 = toRadians(latitude1);
		double phi2 = toRadians(latitude2);

		double deltaphi = toRadians(latitude2 - latitude1);
		double deltadelta = toRadians(longitude2 - longitude1);

		double a = compute_a(phi1, phi2, deltaphi, deltadelta);

		double c = compute_c(a);

		d = R * c;

		return d;
	}
	
	private static double compute_a(double phi1, double phi2, double deltaphi, double deltadelta) {
		
		
		return sin(deltaphi / 2) * sin(deltaphi / 2)
				+ cos(phi1) * cos(phi2) * (sin(deltadelta / 2) * sin(deltadelta / 2));

	}

	private static double compute_c(double a) {
		
		return 2 * atan2(sqrt(a), sqrt(1 - a));

	}

	
	public static double speed(GPSPoint gpspoint1, GPSPoint gpspoint2) {

		int secs;
		double speed;
		
		secs = gpspoint2.getTime() - gpspoint1.getTime();

		// m/s
		speed = distance(gpspoint1, gpspoint2) / secs;

		return speed;
	}

	public static String formatTime(int secs) {

		String timestr;
		String TIMESEP = ":";
		
		int ss = secs % 60;
		String ssstr = Integer.toString(ss);

		if (ss < 10) {
			ssstr = "0" + ssstr;

		}

		int mm = (secs / 60) % 60;
		String mmstr = Integer.toString(mm);

		if (mm < 10) {
			mmstr = "0" + mmstr;
		}

		int hh = (secs / (60 * 60));
		String hhstr = Integer.toString(hh);

		if (hh < 10) {
			hhstr = "0" + hhstr;
		}

		timestr = String.format("%10s",(hhstr + TIMESEP + mmstr + TIMESEP + ssstr));

		return timestr;
	}
	
	private static int TEXTWIDTH = 10;

	public static String formatDouble(double d) {

		String str;

		str = String.format("%10.2f",d);
		
		return str;
	}
}