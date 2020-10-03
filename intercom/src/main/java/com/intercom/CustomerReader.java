package com.intercom;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;

public class CustomerReader {
	
	private static final Logger logger = Logger.getLogger(CustomerInvitation.class.getName());

	/**
	 * Reads the customers from the given JSON file and returns them as a sorted list by user_id
	 * @param fileName
	 * @return the sorted list of customers by user_id
	 * @throws FileNotFoundException
	 */
	public List<Customer> read(String fileName) {
		if (fileName == null || fileName.isEmpty()) {
			logger.severe("File not found. Aborting proccess. ");
			return null;
		}

		List<Customer> customers = new ArrayList<>();
		Gson gson = new Gson();

		try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {

			// Convert JSON File to Java Objects
			String line = reader.readLine();
			while (line != null) {
				Customer customer = gson.fromJson(line, Customer.class);
				if (customer != null) {
					customers.add(customer);
				}
				line = reader.readLine();
			}
		
		} catch (IOException e) {
			logger.severe("File not found. Aborting proccess. " + e.getMessage());
			logger.log(Level.FINEST, e.getMessage(), e);
			return null;
		} catch (NumberFormatException e) {
			logger.severe(
					"Invalid format for latitude or longitude. This program expects a number and got a different input. Aborting proccess. "
							+ e.getMessage());
			logger.log(Level.FINEST, e.getMessage(), e);
			return null;
		} catch (JsonSyntaxException e) {
			logger.severe(
					"Invalid file format. This program expects a well formed JSON file and got a different input. Aborting proccess. "
							+ e.getMessage());
			logger.log(Level.FINEST, e.getMessage(), e);
			return null;
		}

		// Sort by User_id
		Collections.sort(customers, (o1, o2) -> {
			return o1.getUser_id() - o2.getUser_id();
		});
		
		return customers;
	}
	
}
