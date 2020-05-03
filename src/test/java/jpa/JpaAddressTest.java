package jpa;

import org.junit.Test;
import persistence.InteracWithDB;

import java.util.List;


public class JpaAddressTest {
    @Test
    public void whenTestFindingStates() {
        InteracWithDB interacWithDB = new InteracWithDB();
        List<String> listStates = interacWithDB.getAllUniqStates();
        listStates.forEach(System.out::println);
    }

    @Test
    public void whenTestFindingTowns() {
        InteracWithDB interacWithDB = new InteracWithDB();
        List<String> listTowns = interacWithDB.getAllUniqTowns("Тульская область");
        listTowns.forEach(System.out::println);
    }
}
