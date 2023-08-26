package com.coderscampus.domain;
import com.coderscampus.service.*;
import com.coderscampus.service.FileService;

import java.util.List;

public class SuspectLocationApp {

	public static void main(String[] args) {
		FileService service = new FileService();
		for(int week = 1; week <=3; week++) {
			String fileName = "InterpolWatchReport-Week" + week + ".csv";
            List<SuspectLocation> suspects = service.readCsvFile(fileName);
            service.findCarmenSandiego(suspects);
        }
    }
}

	