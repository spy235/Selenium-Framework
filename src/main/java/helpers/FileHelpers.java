package helpers;

import java.io.*;
import java.nio.file.Files;
import java.util.List;

/**
 * Utility class for working with text files.
 * 
 * <p>
 * This class provides methods for writing to, reading from, and reading
 * specific lines from text files.
 * </p>
 */
public class FileHelpers {
	/**
	 * Constructs a new FileHelpers instance.
	 */
	public FileHelpers() {
		super();
	}

	/**
	 * Writes the specified text to a file.
	 * 
	 * @param filepath The path to the file.
	 * @param text     The text to write to the file.
	 */
	public static void writeTxtFile(String filepath, String text) {
		try {
			File file = new File(filepath);
			while (!file.exists()) {
				file.createNewFile();
			}
			FileWriter fw = new FileWriter(file, true);
			BufferedWriter bw = new BufferedWriter(fw);
			bw.write(text + "\n" + "\n");
			bw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Reads and prints the content of a text file.
	 * 
	 * @param filepath The path to the file.
	 */
	public static void readTxtFile(String filepath) {
		try {
			File f = new File(filepath);
			FileReader fr = new FileReader(f);
			BufferedReader br = new BufferedReader(fr);
			String line;
			while ((line = br.readLine()) != null) {
				System.out.println(line);
			}
			fr.close();
			br.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Reads a specific line from a text file.
	 * 
	 * @param filepath The path to the file.
	 * @param line     The line number to read.
	 * @return The content of the specified line.
	 */
	public static String readLineTxtFile(String filepath, int line) {
		List<String> lines;
		String value;
		try {
			lines = Files.readAllLines(new File(filepath).toPath());
			value = lines.get(line);
			return value;
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

}
