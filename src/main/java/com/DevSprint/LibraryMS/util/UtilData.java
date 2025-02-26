package com.DevSprint.LibraryMS.util;

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
}
