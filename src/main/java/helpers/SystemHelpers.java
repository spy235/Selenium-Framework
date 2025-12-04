package helpers;

import java.io.*;
import java.nio.charset.Charset;
import java.text.Normalizer;
import java.util.ArrayList;
import java.util.Locale;
import java.util.regex.Pattern;
/**
 * Utility class providing system-related helper methods.
 * 
 * <p>
 * This class includes methods for generating slugs, reading files, getting the current directory,
 * creating folders, and splitting strings.
 * </p>
 */
public final class SystemHelpers {

    public SystemHelpers() {
        super();
    }

    private static final Pattern NONLATIN = Pattern.compile("[^\\w-]");
    private static final Pattern WHITESPACE = Pattern.compile("[\\s]");
    /**
     * Generates a slug from the given input string.
     * 
     * @param input The input string.
     * @return The generated slug.
     * @throws IllegalArgumentException if the input string is null.
     */
    public static String makeSlug(String input) {
        if (input == null)
            throw new IllegalArgumentException();

        String noWhiteSpace = WHITESPACE.matcher(input).replaceAll("_");
        String normalized = Normalizer.normalize(noWhiteSpace, Normalizer.Form.NFD);
        String slug = NONLATIN.matcher(normalized).replaceAll("");
        return slug.toLowerCase(Locale.ENGLISH);
    }
    /**
     * Reads the content of a file and returns it as a string.
     * 
     * @param file The path to the file.
     * @return The content of the file as a string.
     * @throws IOException if an I/O error occurs.
     */
    public static String readFile(String file) throws IOException {
        Charset cs = Charset.forName("UTF-8");
        FileInputStream stream = new FileInputStream(file);
        try {
            Reader reader = new BufferedReader(new InputStreamReader(stream, cs));
            StringBuilder builder = new StringBuilder();
            char[] buffer = new char[8192];
            int read;
            while ((read = ((BufferedReader) reader).read(buffer, 0, buffer.length)) > 0) {
                builder.append(buffer, 0, read);
            }
            return builder.toString();
        } finally {
            stream.close();
        }
    }

    /**
     * Returns the current working directory.
     * 
     * @return The path to the current working directory with a trailing slash.
     */
    public static String getCurrentDir() {
        String current = System.getProperty("user.dir") + File.separator;
        return current;
    }

    /**
     * Creates a folder at the specified path if it does not already exist.
     * 
     * @param path The path to create the folder.
     */
    public static void createFolder(String path) {
        // File is a class inside java.io package
        File file = new File(path);

        String result = null;

        int lengthSum = path.length();
        int lengthSub = path.substring(0, path.lastIndexOf('/')).length();

        result = path.substring(lengthSub, lengthSum);

        if (!file.exists()) {
            file.mkdir();  // mkdir is used to create folder
            System.out.println("Folder " + file.getName() + " created: " + path);
        } else {
            System.out.println("Folder already created");
        }
    }

    /**
     * Splits a string into an array of values based on the specified delimiter.
     * 
     * @param str The string to be split.
     * @param valueSplit The character to split the string into an array of values.
     * @return An ArrayList of string values after splitting.
     */
    public static ArrayList<String> splitString(String str, String valueSplit) {
        ArrayList<String> arrayListString = new ArrayList<>();
        for (String s : str.split(valueSplit, 0)) {
            arrayListString.add(s);
        }
        return arrayListString;
    }

}