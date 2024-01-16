package com.ayah.qnj.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ayah.qnj.models.Country;

@Repository
public interface CountryRepository extends CrudRepository<Country, Long> {
	List<Country> findAll();

	@Query(value = """
			SELECT name, language, percentage FROM countries
			INNER JOIN languages
			ON countries.id = languages.country_id
			WHERE language='Slovene'
			ORDER BY percentage DESC;
			""", nativeQuery = true)
	List<Object[]> sloveneSpeakingCountries();

	@Query(value = """
			SELECT countries.name, sum((case when countries.id = cities.country_id then 1 else 0 end)) as 'cities' FROM countries
			INNER JOIN cities
			ON countries.id = cities.country_id
			GROUP BY countries.id
			ORDER BY sum((case when countries.id = cities.country_id then 1 else 0 end)) DESC;
			""", nativeQuery = true)
	List<Object[]> citiesPerCountry();

	@Query(value = """
			SELECT cities.name, cities.population FROM countries
			INNER JOIN cities
			ON countries.id = cities.country_id
			WHERE countries.name = 'Mexico' AND cities.population > 500000
			ORDER BY cities.population DESC;
			""", nativeQuery = true)
	List<Object[]> mexicanCityPop();

	@Query(value = """
			SELECT name, language, percentage FROM countries
			INNER JOIN languages
			ON countries.id = languages.country_id
			WHERE percentage > 89
			ORDER BY percentage DESC;
			""", nativeQuery = true)
	List<Object[]> countryLanguages();

	@Query(value = """
			SELECT name, surface_area, population FROM countries
			WHERE surface_area < 501 AND population > 100000;
			""", nativeQuery = true)
	List<Object[]> countrySurfaceArea();

	@Query(value = """
			SELECT name, government_form, surface_area, life_expectancy FROM countries
			WHERE government_form = 'Constitutional Monarchy' AND surface_area > 200 AND life_expectancy > 75;
			""", nativeQuery = true)
	List<Object[]> constitutionalMonarchies();

	@Query(value = """
			SELECT countries.name, cities.name, cities.district, cities.population FROM countries
			INNER JOIN cities
			ON countries.id = cities.country_id
			WHERE countries.name = 'Argentina' AND district = 'Buenos Aires' AND cities.population > 500000
			ORDER BY cities.population DESC;
			""", nativeQuery = true)
	List<Object[]> argentinaCities();

	@Query(value = """
			SELECT region, sum((case when region = region then 1 else 0 end)) as 'countries'
			FROM countries
			GROUP BY region
			ORDER BY sum((case when region = region then 1 else 0 end)) DESC;
			""", nativeQuery = true)
	List<Object[]> countriesPerRegion();
}