package com.gifmyneeds.utilities;

import com.gifmyneeds.R;

public class Validations {

    private static final int MIN_PASSWORD_LENGTH = 8;

    public static boolean isEmailValid(String email) {
        return !(email.isEmpty() || !android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches());
    }

    public static boolean isFullNameValid(String fullName) {
        return !fullName.isEmpty();
    }

    public static boolean isPasswordValid(String password) {
        return !(password.isEmpty() || password.length() < MIN_PASSWORD_LENGTH);
    }

    public static boolean isIdValid(String id) {
        if (id == null || id.isEmpty() || id.length() > 9 || id.length() < 8) {
            return false;
        }
        try {
            int intId = Integer.parseInt(id);
            int result = 0;
            boolean multiplyBy2 = false;
            while (intId != 0) {
                int currentDigit = intId % 10;
                if (multiplyBy2) {
                    currentDigit *= 2;
                    multiplyBy2 = false;
                }
                else {
                    multiplyBy2 = true;
                }
                result += currentDigit % 10 + currentDigit / 10;
                intId /= 10;
            }
            return result % 10 == 0;
        }
        catch (NumberFormatException e) {
            return false;
        }
    }

    public static boolean isAgeValid(String age) {
        try {
            int intAge = Integer.parseInt(age);
            return intAge > 0;
        }
        catch (NumberFormatException e) {
            return false;
        }
    }

    public static boolean isValidGender(String gender) {
        String[] genderArray =GifMyNeedsApplication.getAppContext().getResources().getStringArray(R.array.genderList);
        for (String g: genderArray) {
            if (g.equals(gender)) {
                return true;
            }
        }
        return false;
    }
}
