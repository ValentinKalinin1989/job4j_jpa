package jpa;

import entities.address.Address;
import entities.car.*;
import entities.owner.Owner;
import org.junit.Test;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import java.time.LocalDate;

public class SaveCars {
    @Test
    public void tryToSaveCar() {
        EntityManager manager = Persistence.createEntityManagerFactory("car").createEntityManager();
        manager.getTransaction().begin();
        Car carFirst = new Car("Ford", "Focus", TypeBody.SEDAN, GearBox.CVT,
                TypeEngine.GASOLINE, Drive.FRONT, 1.6f, 2008,
                150800, 450000, "xww1256ght5678hjn", null, LocalDate.now(),
                StatusCar.FOR_SALE, " Первое авто на продажу");
        Car carSecond = new Car("Gas", "Siber", TypeBody.WAGON, GearBox.AT,
                TypeEngine.DIESEL, Drive.FULL, 1.9f, 2010,
                100800, 980000, "xta256ght5678hjn", null, LocalDate.now(),
                StatusCar.FOR_SALE, " Второе авто на продажу");

        Car carThird = new Car("Subary", "Legacy", TypeBody.WAGON, GearBox.AT,
                TypeEngine.DIESEL, Drive.FULL, 2.2f, 2012,
                100800, 900000, "xta256ght5678hjn", null, LocalDate.now(),
                StatusCar.FOR_SALE, " Третьте авто на продажу");

        Car carFourth = new Car("Lada", "Niva", TypeBody.CUV, GearBox.MT,
                TypeEngine.DIESEL, Drive.FULL, 1.4f, 2000,
                100800, 450000, "xta256ght5678hjn", null, LocalDate.now(),
                StatusCar.FOR_SALE, " Четвертое авто на продажу");


        Owner ownerFirst = new Owner("Джон Уик", "12431 4344", "Boogerman", "kililhhgj");
        Address addressFirst = new Address("Карелия", "Петрозаводск");
        Owner ownerSecond = new Owner("Джек Ричер ", "15431 4344", "Man", "kilil");
        Address addressSecond = new Address("Ленинградская область", "Санкт-Петербург");

        carFirst.setOwner(ownerFirst);
        carFirst.setAddress(addressFirst);
        carSecond.setOwner(ownerFirst);
        carSecond.setAddress(addressFirst);
        carThird.setOwner(ownerSecond);
        carThird.setAddress(addressSecond);
        carFourth.setOwner(ownerSecond);
        carFourth.setAddress(addressSecond);
        manager.persist(carFirst);
        manager.persist(carSecond);
        manager.persist(carThird);
        manager.persist(carFourth);
        manager.getTransaction().commit();
        manager.close();
    }
}
