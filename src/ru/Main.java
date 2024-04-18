package ru;

import ru.service.CityService;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * @author Amir Khusnutdinov
 */
public class Main {

    public static String PATH = "src/resources/cities.csv";

    public static void main(String[] args) {

        try {
            CityService service = new CityService(PATH);
            service.showNumberOfCitiesInEachRegion();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
