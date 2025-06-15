package no.hvl.dat100;

public class Explain {

	public double totalElevation() {

		double elevation = 0;

		// TODO - START
		// throw new UnsupportedOperationException(TODO.method());
		
		for (int i = 0; i < gpspoints.length - 1; i++) {

			double diff = gpspoints[i + 1].getElevation() - gpspoints[i].getElevation();

			// sum only if we are going up between two points
			if (diff > 0) {
				elevation = elevation + diff;
			}
		}

		// OPPGAVE - SLUTT
		return elevation;
	}
}
