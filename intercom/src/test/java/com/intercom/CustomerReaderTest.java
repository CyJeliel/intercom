package com.intercom;

import static com.intercom.Constants.FILE_DIR;

import java.io.FileNotFoundException;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.google.gson.JsonSyntaxException;

public class CustomerReaderTest {

	CustomerReader reader = new CustomerReader();

	@Test
	public void fileNotFound() throws FileNotFoundException {
		Assertions.assertNull(reader.read(null));
		Assertions.assertNull(reader.read(""));
		Assertions.assertNull(reader.read("LOREM IPSUM"));
	}

	@Test
	public void emptyFile() throws FileNotFoundException {
		List<Customer> customers = reader.read(FILE_DIR + "customersBlank.txt");
		Assertions.assertNotNull(customers);
		Assertions.assertEquals(0, customers.size());
	}

	@Test
	public void invalidFile() throws JsonSyntaxException, FileNotFoundException {
		Assertions.assertNull(reader.read(FILE_DIR + "invalidFileNotJSON.txt"));
		Assertions.assertNull(reader.read(FILE_DIR + "invalidFileWrongLine.txt"));
		Assertions.assertNull(reader.read(FILE_DIR + "invalidLatLon.txt"));
	}

	@Test
	public void validFileWithWrongField() throws FileNotFoundException {
		List<Customer> customers = reader.read(FILE_DIR + "validFileWrongField.txt");
		Assertions.assertNotNull(customers);
		Assertions.assertEquals(32, customers.size());
		Assertions.assertNull(customers.get(5).getLatitude());
		Assertions.assertNull(customers.get(11).getLatitude());
		Assertions.assertNull(customers.get(12).getLatitude());
	}

	@Test
	public void validFileWithMissingField() throws FileNotFoundException {
		List<Customer> customers = reader.read(FILE_DIR + "validFileMissingFields.txt");
		Assertions.assertNotNull(customers);
		Assertions.assertEquals(32, customers.size());
		Assertions.assertNull(customers.get(0).getLatitude());
	}

	@Test
	public void validFilesWithMoreFields() throws FileNotFoundException {
		List<Customer> customers = reader.read(FILE_DIR + "validFileMoreFields.txt");
		Assertions.assertNotNull(customers);
		Assertions.assertEquals(32, customers.size());
		Assertions.assertEquals(51.92893, customers.get(0).getLatitude());
		Assertions.assertEquals(-10.27699, customers.get(0).getLongitude());
		Assertions.assertEquals(1, customers.get(0).getUser_id());
		Assertions.assertEquals("Alice Cahill", customers.get(0).getName());
	}

	@Test
	public void validFilesWithExtraLines() throws FileNotFoundException {
		List<Customer> customers = reader.read(FILE_DIR + "validExtraLines.txt");
		Assertions.assertNotNull(customers);
		Assertions.assertEquals(32, customers.size());
	}

	@Test
	public void validFile() throws FileNotFoundException {
		List<Customer> customers = reader.read(FILE_DIR + "customers.txt");
		Assertions.assertNotNull(customers);
		Assertions.assertEquals(32, customers.size());
		Assertions.assertEquals(1, customers.get(0).getUser_id());
		Assertions.assertEquals(39, customers.get(31).getUser_id());

	}
}
