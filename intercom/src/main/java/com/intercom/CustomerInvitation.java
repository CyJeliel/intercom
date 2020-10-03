package com.intercom;

import static com.intercom.Constants.FILE_DIR;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;

public class CustomerInvitation {

	private static final Logger logger = Logger.getLogger(CustomerInvitation.class.getName());

	public static void main(String[] args) {
		CustomerInvitation invitation = new CustomerInvitation();
		String inputFile = FILE_DIR + "customers.txt";
		String outputFile = FILE_DIR + "output.txt";
		if (args.length >= 3) {
			inputFile = args[1];
			outputFile = args[2];
		}
		invitation.inviteCustomers(inputFile, outputFile);
	}

	/**
	 * Reads customers from inputFile, checks which customers are within the range of 100km and writes them to outputFile
	 * @param inputFile
	 * @param outputFile
	 */
	public void inviteCustomers(String inputFile, String outputFile) {
		CustomerReader reader = new CustomerReader();
		List<Customer> customers = reader.read(inputFile);
		List<Customer> invitedCustomers = new ArrayList<>();
		if (customers != null && !customers.isEmpty()) {
			final DistanceCalculator calculator = new DistanceCalculator();
			invitedCustomers = customers.stream().filter(c -> {
				return calculator.isWithin100km(c.getLatitude(), c.getLongitude());
			}).collect(Collectors.toList());
			try (FileWriter writer = new FileWriter(outputFile)) {
				for (Customer customer : invitedCustomers) {
					writer.write(customer.getUser_id() + " " + customer.getName() + "\n");
				}
			} catch (IOException e) {
				logger.severe("There was a problem writing to the output file. Aborting proccess. " + e.getMessage());
				logger.log(Level.FINEST, e.getMessage(), e);
				return;
			}
			logger.info("There were " + invitedCustomers.size()
					+ " customers within the 100km range. You can find the description in the file: " + outputFile);
		} else {
			logger.info("There were no customers within the 100km range.");
		}
	}

}
