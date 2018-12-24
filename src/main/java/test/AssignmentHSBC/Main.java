package test.AssignmentHSBC;

import java.io.IOException;
import java.util.ArrayList;
import test.AssignmentHSBC.Methods;

public class Main {
	public static void main(String[] args) throws IOException {

		ArrayList<String> arr = Methods.readappCSV("D:\\Data\\MyCSV1.csv", "D:\\Data\\MyCSV2.csv", 1);
		System.out.println(arr);
	}
}
