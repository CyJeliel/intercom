package com.intercom;

import static com.intercom.Constants.LAT_INTERCOM;
import static com.intercom.Constants.LON_INTERCOM;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class DistanceCalculatorTest {

	@Test
	public void invalidLatLon() {
		DistanceCalculator calculator = new DistanceCalculator();
		Double minusHundred = Double.valueOf(-100);
		Double hundred = Double.valueOf(-100);
		Double zero = Double.valueOf(0);
		Assertions.assertFalse(calculator.isWithin100km(null, null));
		Assertions.assertFalse(calculator.isWithin100km(minusHundred, zero));
		Assertions.assertFalse(calculator.isWithin100km(zero, minusHundred));
		Assertions.assertFalse(calculator.isWithin100km(hundred, zero));
		Assertions.assertFalse(calculator.isWithin100km(zero, hundred));
	}

	@Test
	public void sameLatLon() {
		DistanceCalculator calculator = new DistanceCalculator();
		Assertions.assertTrue(calculator.isWithin100km(LAT_INTERCOM, LON_INTERCOM));
	}

	@Test
	public void smallDeltaLatGreatDeltaLon() {
		DistanceCalculator calculator = new DistanceCalculator();
		Assertions.assertFalse(calculator.isWithin100km(LAT_INTERCOM+0.5, LON_INTERCOM-20));
	}

	@Test
	public void greatDeltaLatSmallDeltaLon() {
		DistanceCalculator calculator = new DistanceCalculator();
		Assertions.assertFalse(calculator.isWithin100km(LAT_INTERCOM+20, LON_INTERCOM-0.5));
	}

	/**
	 * In this method, the tests are for different points within 1km distance from Intercom.

	 * 
	 */
	@Test
	public void euroGiantCoordinates() {
		DistanceCalculator calculator = new DistanceCalculator();
		/**
		 * Eurogiant (53.339164, -6.256730)) is 67m away from Intercom
		 */
		Assertions.assertTrue(calculator.isWithin100km(Double.valueOf(53.339164), Double.valueOf(-6.256730)));
		
		/**
		 * Bank of Ireland (53.338553, -6.255170)) is 210m away from Intercom
		 */
		Assertions.assertTrue(calculator.isWithin100km(Double.valueOf(53.338553), Double.valueOf(-6.255170)));
		
		
		/**
		 * Londis Grafton Street (53.340309, -6.260609)) is 230m away from Intercom
		 */
		Assertions.assertTrue(calculator.isWithin100km(Double.valueOf(53.340309), Double.valueOf(-6.260609)));
		
		/**
		 * Fitzwilliam Hotel Dublin (53.339418, -6.261350)) is 280m away from Intercom
		 */
		Assertions.assertTrue(calculator.isWithin100km(Double.valueOf(53.339418), Double.valueOf(-6.261350)));
	}

	/**
	 * In this method, the tests are for cities within a distance of almost 100km.
	 * Google Maps was used to calculate the distance to travel by car, but it's not the minimum arc distance.
	 */
	@Test
	public void coordinatesWithin100km() {
		DistanceCalculator calculator = new DistanceCalculator();
		
		/**
		 * Durrow (52.846359, -7.396417) is 108km away from Intercom by car.
		 */
		Assertions.assertTrue(calculator.isWithin100km(Double.valueOf(52.846359), Double.valueOf(-7.396417)));
		
		/**
		 * Tullamore (53.299903, -7.492164) is 103km away from Intercom by car, 
		 */
		Assertions.assertTrue(calculator.isWithin100km(Double.valueOf(53.299903), Double.valueOf(-7.492164)));
		
		/**
		 * Gorteen (52.836359, -7.496417) is 117km away from Intercom by car, 
		 */
		Assertions.assertTrue(calculator.isWithin100km(Double.valueOf(52.836359), Double.valueOf(-7.496417)));
	}

	/**
	 * In this method, the tests are for points in the globe out of the distance of 100km.
	 * Google Maps was used to calculate the distance to travel by car, but it's not the minimum arc distance.
	 */
	@Test
	public void coordinatesOutOf100km() {
		DistanceCalculator calculator = new DistanceCalculator();
		
		/**
		 * Glasha (52.836359, -7.596417) is 121km away from Intercom by car.
		 */
		Assertions.assertFalse(calculator.isWithin100km(Double.valueOf(52.836359), Double.valueOf(-7.596417)));
		
		/**
		 * Loughdawan (53.899903, -7.492164) is 132km away from Intercom by car, 
		 */
		Assertions.assertFalse(calculator.isWithin100km(Double.valueOf(53.899903), Double.valueOf(-7.492164)));
		
		/**
		 * Rathfriland (54.255203, -6.165074) is 130km away from Intercom by car, 
		 */
		Assertions.assertFalse(calculator.isWithin100km(Double.valueOf(54.255203), Double.valueOf(-6.165074)));
	}
	


	/**
	 * In this method, the tests are for clients in different countries, outside the range of 100km.
	 * Google Maps was used to calculate the distance to travel by car, but it's not the minimum arc distance.
	 */
	@Test
	public void coordinatesDifferentCountries() {
		DistanceCalculator calculator = new DistanceCalculator();
		
		/**
		 * England (51.512279, -0.180788)
		 */
		Assertions.assertFalse(calculator.isWithin100km(Double.valueOf(51.512279), Double.valueOf(-0.180788)));
		
		/**
		 * Spain (41.099217, -3.496247) 
		 */
		Assertions.assertFalse(calculator.isWithin100km(Double.valueOf(41.099217), Double.valueOf(-3.496247)));
		
		/**
		 * Germany (52.491377, 13.341245) 
		 */
		Assertions.assertFalse(calculator.isWithin100km(Double.valueOf(52.491377), Double.valueOf(13.341245)));

		/**
		 * India (28.637763, 77.373328)
		 */
		Assertions.assertFalse(calculator.isWithin100km(Double.valueOf(28.637763), Double.valueOf(77.373328)));
		
		/**
		 * China (35.939859, 102.814747) 
		 */
		Assertions.assertFalse(calculator.isWithin100km(Double.valueOf(35.939859), Double.valueOf(102.814747)));
		
		/**
		 * Japan (36.798325, 140.075212) 
		 */
		Assertions.assertFalse(calculator.isWithin100km(Double.valueOf(36.798325), Double.valueOf(140.075212)));
		
		/**
		 * Australia (-25.073182, 133.727194)
		 */
		Assertions.assertFalse(calculator.isWithin100km(Double.valueOf(-25.073182), Double.valueOf(133.727194)));
		
		/**
		 * US (40.978344, -102.876450)
		 */
		Assertions.assertFalse(calculator.isWithin100km(Double.valueOf(40.978344), Double.valueOf(-102.876450)));
		
		/**
		 * Brazil (-20.648102, -46.812592) 
		 */
		Assertions.assertFalse(calculator.isWithin100km(Double.valueOf(-20.648102), Double.valueOf(-46.812592)));
		
		/**
		 * Argentina (-34.721800, -63.969453) 
		 */
		Assertions.assertFalse(calculator.isWithin100km(Double.valueOf(-34.721800), Double.valueOf(-63.969453)));
	}
}
