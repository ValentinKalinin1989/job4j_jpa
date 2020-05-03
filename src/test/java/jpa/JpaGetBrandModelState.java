package jpa;

import org.junit.Test;
import persistence.InteracWithDB;

import java.util.List;

public class JpaGetBrandModelState {
    @Test
    public void whenTestGetBrands() {
        InteracWithDB interacWithDB = new InteracWithDB();
        List<String> listBrands = interacWithDB.getAllUniqBrands();
        listBrands.forEach(System.out::println);
    }

    @Test
    public void whenTestGetModels() {
        InteracWithDB interacWithDB = new InteracWithDB();
        List<String> listModels = interacWithDB.getAllUniqModels("Ford");
        listModels.forEach(System.out::println);
    }

}
