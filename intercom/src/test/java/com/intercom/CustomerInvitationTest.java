package com.intercom;

import static com.intercom.Constants.FILE_DIR;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CustomerInvitationTest {

	CustomerInvitation invitation = new CustomerInvitation();

	@Test
	public void fileDoesNotExist() {
		String output = FILE_DIR + "outputFileDoesNotExist.txt";
		invitation.inviteCustomers(FILE_DIR + "customersFileDoesNotExist.txt", output);
		File file = new File(output);
		Assertions.assertFalse(file.exists());
	}

	@Test
	public void emptyFile() {
		String output = FILE_DIR + "outputCustomersBlank.txt";
		invitation.inviteCustomers(FILE_DIR + "customersBlank.txt", output);
		File file = new File(output);
		Assertions.assertFalse(file.exists());
	}

	@Test
	public void notJSONFormat() {
		String output = FILE_DIR + "outputInvalidFileNotJSON.txt";
		invitation.inviteCustomers(FILE_DIR + "invalidFileNotJSON.txt", output);
		File file = new File(output);
		Assertions.assertFalse(file.exists());
	}

	@Test
	public void invalidFileWrongLine() {
		String output = FILE_DIR + "outputInvalidFileWrongLine.txt";
		invitation.inviteCustomers(FILE_DIR + "invalidFileWrongLine.txt", output);
		File file = new File(output);
		Assertions.assertFalse(file.exists());
	}

	@Test
	public void invalidLatLon() {
		String output = FILE_DIR + "outputInvalidLatLon.txt";
		invitation.inviteCustomers(FILE_DIR + "invalidLatLon.txt", output);
		File file = new File(output);
		Assertions.assertFalse(file.exists());
	}

	@Test
	public void validFileWithWrongField() throws IOException {
		String output = FILE_DIR + "outputValidFileWrongField.txt";
		invitation.inviteCustomers(FILE_DIR + "validFileWrongField.txt", output);
		try (Stream<String> fileStream = Files.lines(Paths.get(output))) {
			int numberOfLines = (int) fileStream.count();
			assertEquals(13, numberOfLines);
			Files.delete(Paths.get(output));
		}
	}

	@Test
	public void validFileWithMissingField() throws IOException {
		String output = FILE_DIR + "outputValidFileMissingFields.txt";
		invitation.inviteCustomers(FILE_DIR + "validFileMissingFields.txt", output);
		try (Stream<String> fileStream = Files.lines(Paths.get(output))) {
			int numberOfLines = (int) fileStream.count();
			assertEquals(16, numberOfLines);
			Files.delete(Paths.get(output));
		}
	}

	@Test
	public void validFilesWithMoreFields() throws IOException {
		String output = FILE_DIR + "outputValidFileMoreFields.txt";
		invitation.inviteCustomers(FILE_DIR + "validFileMoreFields.txt", output);
		try (Stream<String> fileStream = Files.lines(Paths.get(output))) {
			int numberOfLines = (int) fileStream.count();
			assertEquals(16, numberOfLines);
			Files.delete(Paths.get(output));
		}
	}

	@Test
	public void validFilesWithExtraLines() throws IOException {
		String output = FILE_DIR + "outputValidExtraLines.txt";
		invitation.inviteCustomers(FILE_DIR + "validExtraLines.txt", output);
		try (Stream<String> fileStream = Files.lines(Paths.get(output))) {
			int numberOfLines = (int) fileStream.count();
			assertEquals(16, numberOfLines);
			Files.delete(Paths.get(output));
		}
	}

	@Test
	public void validFile() throws IOException {
		String output = FILE_DIR + "output.txt";
		invitation.inviteCustomers(FILE_DIR + "customers.txt", output);
		try (Stream<String> fileStream = Files.lines(Paths.get(output))) {
			int numberOfLines = (int) fileStream.count();
			assertEquals(16, numberOfLines);
			Files.delete(Paths.get(output));
		}
	}
}
