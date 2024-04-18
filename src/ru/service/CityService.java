package ru.service;

import ru.converter.CityConverter;
import ru.model.City;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.*;

/**
 * A class that performs actions with a list of cities.
 *
 * @author Amir Khusnutdinov
 */
public class CityService {

    private static List<City> cities = new ArrayList<>();

    public CityService(String path) throws IOException {
        try (Scanner scanner = new Scanner(Paths.get(path))){

            while (scanner.hasNextLine()) {
                cities.add(CityConverter.stringToCity(scanner.nextLine()));
            }

        } catch (IOException e) {
            throw e;
        }
    }

    public void showAllCities() {
        for (City city : cities) {
            System.out.println(city);
        }
    }

    /**
     * Сортировка списка городов по наименованию в алфавитном порядке по убыванию без учета регистра.
     */
    public void showCitiesSortedByName() {
        List<City> sortedCities = cities;

        sortedCities.sort((o1, o2) -> o1.getName().compareToIgnoreCase(o2.getName()));

        for (City city : sortedCities) {
            System.out.println(city);
        }
    }

    /**
     * Сортировка списка городов по федеральному округу и наименованию города внутри каждого федерального округа
     * в алфавитном порядке по убыванию с учетом регистра.
     */
    public void showCitiesSortedByDistrictByName() {
        List<City> sortedCities = cities;

        sortedCities.sort(Comparator.comparing(City::getDistrict).thenComparing(City::getName));

        for (City city : sortedCities) {
            System.out.println(city);
        }
    }

    /**
     * Поиск города с наибольшим количеством жителей методом перебора.
     */
    public void showCityWithHighestPopulation() {
        City[] citiesArray = cities.toArray(new City[0]);

        int highestPopulation = 0;
        int index = 0;

        for (int i = 0; i < citiesArray.length; i++) {
            if (citiesArray[i].getPopulation() > highestPopulation) {
                highestPopulation = citiesArray[i].getPopulation();
                index = i;
            }
        }

        System.out.println("[" + index + "] = " + highestPopulation);
    }

    /**
     * Определение количества городов в каждом регионе.
     */
    public void showNumberOfCitiesInEachRegion() {
        List<City> sortedCities = cities;

        sortedCities.sort((o1, o2) -> o1.getRegion().compareTo(o2.getRegion()));

        String currentRegion = sortedCities.get(0).getRegion();
        int numberOfCities = 0;

        for (City city : sortedCities) {
            if (Objects.equals(currentRegion, city.getRegion())) {
                numberOfCities++;
            } else {
                System.out.println(currentRegion + " - " + numberOfCities);
                currentRegion = city.getRegion();
                numberOfCities = 1;
            }
        }

        System.out.println(currentRegion + " - " + numberOfCities);
    }
}
