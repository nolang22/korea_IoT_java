package org.example.yello.code3.util;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateUtil {
    //   private static final String PATTERN = "yyyy-MM-dd HH:mm:ss";
//
//   private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern(PATTERN);
//
//   public static String now() {
//
//       return LocalDateTime.now().format(FORMATTER);
//  }
//    public static String format(LocalDateTime dateTime) {
//        return dateTime.format(FORMATTER);
//    }
//    public static LocalDateTime parse(String datetimeStr) {
//        return LocalDateTime.parse(datetimeStr, FORMATTER);
//    }
    private static final String PATTERN = "yyyy-MM-dd HH:mm:ss";

    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern(PATTERN);

    public static String now() {
        return LocalDateTime.now().format(FORMATTER);
    }

    public static String format(LocalDateTime dateTime) {
        return dateTime.format(FORMATTER);
    }

}
