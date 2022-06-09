package com.hcl.java8.part1n2;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class LogFileUtil {
        LogFileUtil() {
        }

        public static LocalDateTime convertStrToLocalDateTime(String dateTimeStr) {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMM dd, yyyy hh:mm:ss a");
            LocalDateTime dateTime = LocalDateTime.parse(dateTimeStr, formatter);
            return dateTime;
        }

        public static LocalDateTime convertIntegerHourToAmPmTime(String hour) {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH", Locale.US);
            LocalDateTime dateTime = LocalDateTime.parse(hour, formatter);
            return dateTime;
        }

        public static String convertHourToAmPm(Integer hour) {
            StringBuilder hourStr = new StringBuilder();
            if (hour > 23 || hour < 0) {
                hourStr.append("Error: Incorrect hour value");
            }

            if (hour == 0) {
                hourStr.append("12:00 AM to 1:00 AM");
            }

            if (hour == 23) {
                hourStr.append("11:00 PM to 12:00 AM");
            }

            if (hour >= 1 && hour <= 11) {
                hourStr.append(hour).append(" AM to ").append(hour + 1).append(" AM");
            }

            if (hour >= 13 && hour <= 23) {
                hourStr.append(hour - 12).append(" PM to ").append(hour - 11).append(" PM");
            }

            return hourStr.toString();
        }
}


