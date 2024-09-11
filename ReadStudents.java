package project;
import java.io.File;
import java.util.Scanner;

public final class ReadStudents {

	/*
	 * The purpose of this class is to read the random_students_data.csv file
	 * The format of the file is text with comma-separated fields.
	 * 
	 * Description of the fields:
	 * Student Id (integer),First Name (string),Last Name (string),Score in Science (integer),Score in History (integer),Score in Mathematics (integer),Score in English (integer)
	 * 
	 * Each column will be stored into a separate array
	 */

	private static int[] studentId = new int[200];
	private static String[] firstName = new String[200];
	private static String[] lastName = new String[200];
	private static int[] scienceScore = new int[200];
	private static int[] historyScore = new int[200];
	private static int[] mathematicsScore = new int[200];
	private static int[] englishScore = new int[200];

	public ReadStudents() {
		
		// Scanner to read each token of a line
		Scanner rowScanner;

		// Trying to open the file
		try (Scanner scanner = new Scanner(new File("src/random_students_data.csv"));) {

			int i = 0;

			// Read line by line
			while (scanner.hasNextLine()) {

				rowScanner = new Scanner(scanner.nextLine());
				rowScanner.useDelimiter(",");

				// Parsing each token and storing them into respective arrays
				studentId[i] = Integer.parseInt(rowScanner.next());
				firstName[i] = rowScanner.next();
				lastName[i] = rowScanner.next();
				scienceScore[i] = Integer.parseInt(rowScanner.next());
				historyScore[i] = Integer.parseInt(rowScanner.next());
				mathematicsScore[i] = Integer.parseInt(rowScanner.next());
				englishScore[i] = Integer.parseInt(rowScanner.next());

				i++;

			}
		} catch (Exception e) {
			// Handling file not found or other exceptions
			System.out.println("Not sure where the file is ...");
		}

	}

	/*
	 * Returns array of student IDs
	 */
	public static int[] getStudentId() {
		return studentId;
	}

	/*
	 * Returns array of student first names
	 */
	public static String[] getFirstName() {
		return firstName;
	}

	/*
	 * Returns array of student last names
	 */
	public static String[] getLastName() {
		return lastName;
	}

	/*
	 * Returns an array of student scores in science
	 */
	public static int[] getScienceScore() {
		return scienceScore;
	}

	/*
	 * Returns an array of student score in history
	 */
	public static int[] getHistoryScore() {
		return historyScore;
	}

	/*
	 * Returns an array of student scores in mathematics
	 */
	public static int[] getMathematicsScore() {
		return mathematicsScore;
	}

	/*
	 * Returns array of student score in English
	 */
	public static int[] getEnglishScore() {
		return englishScore;
	}
	public static void main(String[] args) {
		System.out.print(studentId[4]);
	}
}