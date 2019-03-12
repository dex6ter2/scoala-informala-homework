package Tema8;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * generates and file with the name outputFilePath after applying a filter based on month, sorting and excluding the date
 */
class NamesFromListBasedOnMonth {
    private String inputFilePath;
    private int month;
    private String outputFilePath;

    NamesFromListBasedOnMonth(String inputFilePath, int month, String outputFilePath) {
        this.inputFilePath = inputFilePath;
        this.month = month;
        this.outputFilePath = outputFilePath;
    }

    /**
     * validates if inputFilePath is valid
     *
     * @return
     */

    private Stream<String> verifyPath() {
        try {
            return Files.lines(Paths.get(this.inputFilePath));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Filters the file from the inputFilePath based on the month
     * excludes the date
     *
     * @return the values after the filter was applied
     */

    Map<String, String> sortFileByMonth() {
        Map<String, String> nameAndFirstName;
        nameAndFirstName = verifyPath()
                .map(x -> x.split(","))
                .filter(x -> LocalDate.parse(x[2]).getMonth().getValue() == (this.month))
                .collect(Collectors.toMap(x -> x[0], x -> x[1]));
        verifyPath().close();
        return nameAndFirstName;
    }

    /**
     * creates a file with the name of the object outputFilePath
     * sorts the Map received from sortFileByMonth method
     * writes the values in the file with the name outputFilePath
     */

    void writeFile() {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(this.outputFilePath))) {
            for (Map.Entry<String, String> entry : new TreeMap<>(sortFileByMonth()).entrySet()) {
                bufferedWriter.newLine();
                bufferedWriter.write(entry.getKey() + "," + entry.getValue());
            }
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("bla");
        }


    }
}
