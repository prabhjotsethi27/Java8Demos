package com.hcl.java8.part1n2;

import com.hcl.java8.part1n2.model.LogLine;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Part1And2Main {

    public static void main(String[] args) {
        //1. Combine a list of Strings using comma separator.
        //Input: String[] with values "Mercury", "Venus", "Mars"
        //Output: Single String "Planets: Mercury, Venus, Mars"
        //
        //2. Unique user activity
        //Input: Log file with user activity information during a day
        //
        //Output:
        //Time range (hour) during which number of unique users logged in is maximum
        //
        //Sample log entry:
        //Apr 7, 2022 12:03:17 AM USER1 Login
        //Apr 7, 2022 12:04:20 AM USER1 Search
        //Apr 7, 2022 12:05:32 AM USER2 Login
        //Apr 7, 2022 12:08:00 AM USER3 Login
        //Apr 7, 2022 12:12:12 AM USER1 Order

        Part1And2Main java8Demo = new Part1And2Main();
        java8Demo.readStringArrayWithCommas();
        java8Demo.callFindTimeHourWithMaxUsersLogFile();
    }

    private void readStringArrayWithCommas() {
        String[] planetsArr = new String[]{"Mercury", "Venus", "Mars", "Earth"};
        String streamOutput = Arrays.stream(planetsArr).collect(Collectors.joining(","));
        System.out.println("\n Task 1.....");
        System.out.println("Planets: " + streamOutput);
    }

    private void callFindTimeHourWithMaxUsersLogFile() {
        System.out.println("\n\n Task 2.....");
        System.out.println("Time range (hour) during which number of unique users logged in is maximum: " + this.findTimeHourWithMaxUsersLogFile());
    }

    private String findTimeHourWithMaxUsersLogFile() {
        try {
            Path path = Paths.get(this.getClass().getClassLoader().getResource("test.log").toURI());
            Stream<String> logFilesData = Files.lines(path);

            Integer maxUsersHour = logFilesData.map(x-> {
                        return LogLine.builder()
                        .accessDateTime(LogFileUtil.convertStrToLocalDateTime(x.substring(0, 24)))
                        .userName(x.substring(25, 30))
                        .operation(x.substring(31))
                        .build();
                    })
                    .collect(Collectors.groupingBy(log->log.getAccessDateTime().getHour(), Collectors.mapping(LogLine::getUserName, Collectors.toSet())))
                    .entrySet()
                    .stream()
                    .max(Comparator.comparing(temp-> temp.getValue().size()))
                    .get()
                    .getKey();

            logFilesData.close();
            return LogFileUtil.convertHourToAmPm(maxUsersHour);
        } catch (Exception e) {
            System.out.println("Error while reading log file: " + e.getMessage());
            return null;
        }
    }
}
