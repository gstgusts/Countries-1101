package com.company;

import org.junit.Test;

public class Main {
    public static void main(String[] args) {
      var db = new DatabaseManager();

      var country1 = new Country(0, "GG", "Funny name 3");
      db.save(country1);

       System.out.println(country1.getId());

       var result = db.getCountries();

//       var countryToUpdate = result.get(result.size() - 1);
//       countryToUpdate.setName("Funny name 2 - 1");
//       db.update(countryToUpdate);

        for (var country :
                result) {
            System.out.println(country.getName());
        }
    }

    @Test
    public void delete() {
        var dm = new DatabaseManager();
        var result = dm.getCountries();

        var itemToDelete = result.get(result.size() - 1);

        dm.delete(itemToDelete);
    }

    @Test
    public void getById() {
        var dm = new DatabaseManager();
        dm.getById(1);
    }

    @Test
    public void getFromView() {
        var dm = new DatabaseManager();
        dm.getCountriesFromView();
    }

    @Test
    public void getById2() {
        var dm = new DatabaseManager();
        dm.getById(1);
    }

    @Test
    public void getById3() {
        var dm = new DatabaseManager();
        dm.getById(1);
    }

    @Test
    public void getById4() {
        var dm = new DatabaseManager();
        dm.getById(1);
    }

    @Test
    public void getById5() {
        var dm = new DatabaseManager();
        dm.getById(1);
    }

    @Test
    public void getById6() {
        var dm = new DatabaseManager();
        dm.getById(1);
    }
}
