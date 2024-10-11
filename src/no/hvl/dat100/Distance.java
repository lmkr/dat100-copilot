package no.hvl.dat100;

import static java.lang.Math.*;

public class Distance {

	
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

		double a = sin(deltaphi / 2) * sin(deltaphi / 2)
				+ cos(phi1) * cos(phi2) * (sin(deltadelta / 2) * sin(deltadelta / 2));

		double c = 2 * atan2(sqrt(a), sqrt(1 - a));

		d = 6371000 * c;

		return d;
	}
	
}
	

