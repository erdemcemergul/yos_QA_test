package com.yos.baseMethods;

import com.yos.utilities.Driver;
import org.openqa.selenium.support.PageFactory;

import java.security.SecureRandom;


public class FakePasswordCreater {
    public FakePasswordCreater() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    private static final String SPECIAL_CHARACTERS = "!,?{}><%&$#£+-.";
    private static final String LOWERCASE_CHARACTERS = "abcdefghijklmnopqrstuvwxyz";
    private static final String UPPERCASE_CHARACTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String NUMERIC_CHARACTERS = "0123456789";

    private static final SecureRandom secureRandom = new SecureRandom();

    public static String
    generateText(boolean useSpecialCharacter, boolean useNumericCharacter, boolean useUppercaseCharacter, boolean useLowercaseCharacter, int minCharacterCount, int maxCharacterCount) {
        if (minCharacterCount < 0 || maxCharacterCount < 0 || minCharacterCount > maxCharacterCount) {
            return "";
        }
        String characters = "";
        StringBuilder password = new StringBuilder();

        if (useSpecialCharacter) {
            characters += SPECIAL_CHARACTERS;
        }
        if (useNumericCharacter) {
            characters += NUMERIC_CHARACTERS;
        }
        if (useUppercaseCharacter) {
            characters += UPPERCASE_CHARACTERS;
        }
        if (useLowercaseCharacter) {
            characters += LOWERCASE_CHARACTERS;
        }

        int passwordLength = minCharacterCount + secureRandom.nextInt(maxCharacterCount - minCharacterCount + 1);
        try {
            for (int i = 0; i < passwordLength; i++) {
                int randomIndex = secureRandom.nextInt(characters.length());
                char randomChar = characters.charAt(randomIndex);
                password.append(randomChar);
            }
        } catch (IllegalArgumentException e) {
            return "";
        }
        return password.toString();
    }

}
