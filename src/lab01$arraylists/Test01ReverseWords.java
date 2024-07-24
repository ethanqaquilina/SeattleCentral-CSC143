package lab01$arraylists;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author A. Ford and You
 * Create a runnable program with output as described in the .
 */

public class Test01ReverseWords {

    /**
     * reads in an empty list and file location and populates list with
     * the lines and words reversed.
     * @param inputLocation for reading in the file information
     * @param list to be populated
     * @throws FileNotFoundException if file location not found
     */
    public static void read(String inputLocation, List<String> list) throws FileNotFoundException{

        //TODO: check if input location exists
        validateInputLocation(inputLocation);

        //TODO: Create a File Object
        File inputFile = new File(inputLocation);


        //TODO: Opens up a file input stream
        Scanner input = new Scanner(inputFile);

        //TODO: store words in reverse in a list from each line


        //TODO: read in the data using input scanner
        if(inputFile.exists()){

            //TODO: read in next line and store as a string
            while (input.hasNextLine()){
                String line = input.nextLine();
                Scanner input2 = new Scanner(line);
                List<String> tempList = new ArrayList<>();

                    //TODO: get each word on each line using a delimiter and store in index location
                    while (input2.hasNext()) {

                        //TODO: store words in reverse
                        tempList.addFirst(input2.next());
                    }
                    //TODO: use string builder to build out lines with space
                    StringBuilder reversedLine = new StringBuilder();
                for (String Word : tempList) {
                    reversedLine.append(Word);
                    reversedLine.append(" ");
                }
                    //TODO: add each reversed line to list as a string
                    list.addFirst(reversedLine.toString());

            }
            input.close();
        }


    }

    /**
     * checks whether the file exists
     * @param location of file is checked
     * @throws FileNotFoundException if file does not exist
     */
    public static void validateInputLocation(String location) throws FileNotFoundException{

        File inputFile = new File(location);

        if (!inputFile.exists()) {
            throw new FileNotFoundException("File at " + location + " does not exist.");
        }

        System.out.println("Processing \t" + location + "...");
        
    }

    /**
     * checks whether the output directory exists
     * @param directory folder to place output
     * @param location for output file
     */
    public static void validateOutputFolder(String directory, String location) {

        File outputFile = new File(location);

        if (!outputFile.exists()) {

            boolean hasCreatedDirectory = new File(directory).mkdir();
            System.out.println("Has the directory been created? " + hasCreatedDirectory);
            System.out.println();

            if (hasCreatedDirectory) {
                System.out.println("Processing \t" + directory + "...");
            }else {
                System.out.println("something went wrong.");
            }
        }
        
    }

    /**
     * writes to an output file
     * @param outputLocation to where output file exists
     * @param list containing reversed words
     * @throws FileNotFoundException when cannot write to output location
     */
    public static void write(String outputLocation, List<String> list) throws FileNotFoundException{

        File outputFile = new File(outputLocation);

        //TODO: Open up a file output stream
        PrintStream output = new PrintStream(outputFile);

        // TODO: write out lines using  Print Stream -> write
        for (String line: list){
            output.println(line);
        }

        //TODO: close output stream
        output.close();
    }


    public static void main(String[] args) throws FileNotFoundException {
        String inputLocation    = "." + File.separator + "data"
                                      + File.separator + "words.txt";

        String outputFolder     = "." + File.separator + "results";

        String outputLocation   = "." + File.separator + "results"
                                      + File.separator + "reverse_words.txt";

        // TODO: update program to use an Array List
        List<String> list       = new ArrayList<>();

        // TODO: process items in file (REVERSALS, can be done either in main or in read)
        Test01ReverseWords.read(inputLocation, list);

        //TODO: Validate Output Directory Exists
        Test01ReverseWords.validateOutputFolder(outputFolder, outputLocation);
        Test01ReverseWords.write(outputLocation, list);

    }

}
