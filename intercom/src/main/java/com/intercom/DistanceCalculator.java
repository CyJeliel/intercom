package com.intercom;

public class DistanceCalculator {
	
	/**
	 * One minute of longitude along the 53rd parallel is approximately 1.119 km, 
	 * therefore it's possible to discard all longitudes farther than 2 degrees (134.28km).
	 * The distance of each degree of latitude is approximately 111 km,
	 * therefore it's possible to discard all latitudes farther than 1 degree.
	 * @param lat
	 * @param lon
	 */
	public boolean isWithin100km(Double lat, Double lon) {
		if (lat == null || lon == null) return false;
		if (lat < Constants.LAT_INTERCOM-1 || lat > Constants.LAT_INTERCOM+1) return false;
		if (lon < Constants.LON_INTERCOM-2 || lon > Constants.LON_INTERCOM+2) return false;
		return calculateDistance(Math.toRadians(lat), Math.toRadians(lon)) <= 100;
	}

	/**
	 * This method uses the haversin formula to calculate the distance.
	 * It's safe to use the haversin formula for small distances,  
	 * because the case of antipodal points was discarded
	 * @param lat
	 * @param lon
	 * @return the distance in km between Intercom and the given coordinate
	 */
	public double calculateDistance(Double lat, Double lon) {
		
		double latIntercom = Math.toRadians(Constants.LAT_INTERCOM);
		double lonIntercom = Math.toRadians(Constants.LON_INTERCOM);

		double deltaLat = Math.abs(latIntercom - lat);
		double deltaLon = Math.abs(lonIntercom - lon);
		
		double firstTerm = hav(deltaLat);
		double secondTerm = Math.cos(latIntercom) * Math.cos(lat) * hav(deltaLon);
		
		double centralAngle = 2 * Math.asin(Math.sqrt(firstTerm + secondTerm));
		
		return Constants.EARTH_RADIUS * centralAngle;
	}

	/**
	 * Calculates de haversine of the given angle 
	 * @param angle
	 * @return the haversine of the angle
	 */
	public double hav(double angle) {
		return Math.pow(Math.sin(angle/2), 2);
	}
}

