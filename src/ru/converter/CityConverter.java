package ru.converter;

import ru.model.City;

/**
 * A class that convert string to City object.
 *
 * @author Amir Khusnutdinov
 */
public class CityConverter {

    public static City stringToCity(String str) {
        String[] args = str.split(";", -1);
        City city = new City(args[1], args[2], args[3], Integer.parseInt(args[4]), args[5]);
        return city;
    }

}
