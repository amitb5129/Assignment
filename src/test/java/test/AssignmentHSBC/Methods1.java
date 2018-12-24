package test.AssignmentHSBC;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;

public class Methods1 {
	// This Function reads the csv Line by Line.
	// The Second parameter is used to Match it to the Original CSV.
	public static boolean readCSV(File filename2, int param, String[] datatoMatch) throws IOException {
		CSVReader csvreader = new CSVReader(new FileReader(filename2));
		boolean flag = false;
		String[] data;
		while ((data = csvreader.readNext()) != null) {
			if (data[param].equals(datatoMatch[param])) {
				List<String> arr = Arrays.asList(data);
				 flag = mapBothFilesData(datatoMatch, data);
				break;
			}
		}
		return flag;
	}

	public static ArrayList<String> readappCSV(String filename1, String filename2,int index) throws IOException {
		CSVReader reader = new CSVReaderBuilder(new FileReader(filename1)).withSkipLines(1).build();
		List<String[]> alldata = reader.readAll();
		ArrayList<String> arr=new ArrayList<>();
		for (String[] s : alldata) {
		boolean flag=readCSV(new File(filename2), index, s);
		if(flag==false) {
			arr.add(s[index]);
		}
		}
		return arr;
	}

	public static boolean mapBothFilesData(String[] csv1, String[] csv2) {
		for (int i = 0; i < csv1.length; i++) {
			if (csv1[i].equals(csv2[i])) {
				continue;
			} else {
				return false;
			}
		}

		return true;

	}

}
