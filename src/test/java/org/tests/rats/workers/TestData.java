package org.tests.rats.workers;

import com.github.javafaker.Faker;
import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class TestData {

    public static String firstName() {
        Faker faker = new Faker(new Locale("en-US"));
        return faker.name().firstName();
    }

    public static String lastName() {
        Faker faker = new Faker(new Locale("en-US"));
        return faker.name().lastName();
    }

    public static String fullName() {
        Faker faker = new Faker(new Locale("en-US"));
        return faker.name().fullName();
    }

    public static int age() {
        Faker faker = new Faker(new Locale("en-US"));
        return faker.number().numberBetween(1, 100);
    }

    public static String email() {
        Faker faker = new Faker(new Locale("en-US"));
        return faker.internet().emailAddress().toLowerCase();
    }

    public static String url() {
        Faker faker = new Faker(new Locale("en-US"));
        return faker.internet().url();
    }

    public static String password() {
        Faker faker = new Faker(new Locale("en-US"));
        return faker.internet().password(6, 8);
    }

    public static String country() {
        Faker faker = new Faker(new Locale("en-US"));
        return faker.address().country();
    }

    public static String countryCode() {
        Faker faker = new Faker(new Locale("en-US"));
        return faker.address().countryCode();
    }

    public static String city() {
        Faker faker = new Faker(new Locale("en-US"));
        return faker.address().city();
    }

    public static String street() {
        Faker faker = new Faker(new Locale("en-US"));
        return faker.address().streetName();
    }

    public static String house() {
        Faker faker = new Faker(new Locale("en-US"));
        return faker.address().buildingNumber();
    }

    public static int randomNumber() {
        Faker faker = new Faker(new Locale("en-US"));
        return faker.number().numberBetween(0, Integer.MAX_VALUE);
    }

    public static String occupation() {
        Faker faker = new Faker(new Locale("en-US"));
        return faker.job().position();
    }

    public static Date date() {
        Faker faker = new Faker(new Locale("en-US"));
        return faker.date().birthday();
    }

    public static String company() {
        Faker faker = new Faker(new Locale("en-US"));
        return faker.company().name();
    }

    public static int negativeRandomNumber() {
        Faker faker = new Faker(new Locale("en-US"));
        return faker.number().numberBetween(Integer.MIN_VALUE, -1);
    }

    public static String naughtyString() {
        Faker faker = new Faker();
        Gson gson = new Gson();
        try {
            JsonReader jsonFile = new JsonReader(new FileReader("src/test/resources/blns.json"));
            List<String> naughtyStrings = gson.fromJson(jsonFile, ArrayList.class);
            int randomNumber = faker.number().numberBetween(1, naughtyStrings.size());
            jsonFile.close();
            return naughtyStrings.get(randomNumber);
        } catch (IOException e) {
            return "-1";
        }
    }

    public static String naughtyString64() {
        Faker faker = new Faker();
        Gson gson = new Gson();
        try {
            JsonReader jsonFile = new JsonReader(new FileReader("src/test/resources/blns64.json"));
            List<String> naughtyStrings = gson.fromJson(jsonFile, ArrayList.class);
            int randomNumber = faker.number().numberBetween(1, naughtyStrings.size());
            jsonFile.close();
            return naughtyStrings.get(randomNumber);
        } catch (IOException e) {
            return "-1";
        }
    }
}
