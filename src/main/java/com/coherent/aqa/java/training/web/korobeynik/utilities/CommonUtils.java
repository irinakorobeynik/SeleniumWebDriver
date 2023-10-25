package com.coherent.aqa.java.training.web.korobeynik.utilities;


import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;


public class CommonUtils {

    public static String getPropertyValue(String property) {
        String value = null;
        try (InputStream input = Files.newInputStream(Paths.get("src/main/resources/config.properties"))) {
            Properties prop = new Properties();
            prop.load(input);
            value = prop.getProperty(property);
        } catch (NullPointerException | IOException e) {
            throw new RuntimeException("Something wrong with getting values for testing: " + e);
        }
        return value;
    }

    public static Set<Integer> getThreeRandom(int size) {
        Set<Integer> integerList = new HashSet<>();
        while (integerList.size() < 3) {
            integerList.add(new Random().nextInt(size));
        }
        return integerList;
    }

    public static List<String> getRandomOptionsFrom(List<String> source) {
        return getThreeRandom(source.size())
                .stream()
                .map(source::get)
                .sorted()
                .toList();

    }
}
