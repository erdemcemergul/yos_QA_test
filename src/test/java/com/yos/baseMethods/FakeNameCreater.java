package com.yos.baseMethods;

import com.github.javafaker.Faker;
import com.github.javafaker.Name;

import java.util.ArrayList;
import java.util.List;

import com.yos.utilities.Driver;
import org.openqa.selenium.support.PageFactory;


public class FakeNameCreater {
    private static final int MAX_NAME_LENGTH = 10;
    private static final List<String> fakeNames = createFakeNamesList();
    private static final Faker faker = new Faker();

    public FakeNameCreater() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    private static List<String> createFakeNamesList() {
        List<String> namesList = new ArrayList<>();
        Faker faker = new Faker();
        for (int i = 0; i < 100; i++) {
            Name name = faker.name();
            String firstName = name.firstName();
            if (firstName.length() <= MAX_NAME_LENGTH) {
                namesList.add(firstName);
            }
        }
        return namesList;
    }

    public static String fakerName(int maxWordCount) {
        String fakeName = "";
        while (true) {
            int randomIndex = faker.random().nextInt(fakeNames.size());
            String firstName = fakeNames.get(randomIndex);
            if (maxWordCount > MAX_NAME_LENGTH) {
                int secondRandomIndex = faker.random().nextInt(fakeNames.size());
                String secondFirstName = fakeNames.get(secondRandomIndex);
                fakeName = firstName + " " + secondFirstName + " Jaga";
                break;
            } else {
                if (firstName.length() <= maxWordCount) {
                    fakeName = firstName;
                    break;
                }
            }
        }
        //  System.out.println(fakeName); // maxWordCount 10'dan büyük olduğunda 2 ismi çıktıya ekler
        return fakeName;
    }


}
