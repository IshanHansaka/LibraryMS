package com.DevSprint.LibraryMS.util;

import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.UUID;

public class UtilData {
    //Generate respective IDs
    public static String generateBookId() {
        return "B/" + UUID.randomUUID();
    }

    public static String generateMemberId() {
        return "M/" + UUID.randomUUID();
    }

    public static String generateStaffId() {
        return "S/" + UUID.randomUUID();
    }

    public static String generateLendingId() {
        return "L/" + UUID.randomUUID();
    }

    //Generate last update data & time
    public static LocalDate generateTodayDate() {
        return LocalDate.now();
    }

    public static Time generateCurrentTime() {
        return Time.valueOf(LocalTime.now());
    }

    //Generate return date of a lending
    public static LocalDate generateReturnDate() {
        return LocalDate.now().plusDays(7);
    }

    public static LocalDate generateReturnDateCalc() {
        return LocalDate.now().minusDays(7);
    }
}
