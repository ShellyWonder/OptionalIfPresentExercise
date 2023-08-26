package com.coderscampus.service;

import java.util.ArrayList;
import java.util.List;

import java.io.FileReader;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.util.Optional;

import com.coderscampus.domain.SuspectLocation;

public class FileService {
	public List<SuspectLocation> readCsvFile(String fileName) {
		List<SuspectLocation> suspectLocations = new ArrayList<SuspectLocation>();
		try (BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName))) {
			bufferedReader.readLine();
	        String line;
	        while ((line = bufferedReader.readLine()) != null) {
	            Optional<SuspectLocation> suspectLocationOpt = parseLine(line);
	            suspectLocationOpt.ifPresent(suspectLocations::add);
	        }
	    } catch (FileNotFoundException e) {
	        e.printStackTrace();
	        System.out.println("File not found");
	    } catch (IOException e) {
	        e.printStackTrace();
	        System.out.println("IOException found");
	    }

		
		return suspectLocations;
	}
	private Optional<SuspectLocation> parseLine(String line) {
	    String[] values = line.split(",");
	    if (values.length >= 2) {
	        String city = values[0].trim();
	        String name = values[1].trim();
	        return Optional.of(new SuspectLocation(city, name));
	    }
	    return Optional.empty();
	}

	
	public void findCarmenSandiego(List<SuspectLocation> suspectLocations) {
	    Optional<SuspectLocation> carmenLocation = suspectLocations.stream()
	        .filter(suspect -> "CARMEN SANDIEGO".equals(suspect.getName()))
	        .findFirst();
	    long count = suspectLocations.stream()
	              .filter(suspect -> "CARMEN SANDIEGO".equals(suspect.getName()))
	              .count();
	System.out.println("Found Carmen Sandiego " + count + " times.");

	    carmenLocation.ifPresent(location -> System.out.println("Carmen Sandiego is in " + location.getCity()));
	}


}