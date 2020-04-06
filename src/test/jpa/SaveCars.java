import car.*;
import org.junit.Test;
import owner.Owner;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class SaveCars {
    @Test
    public void tryToSaveCar() {
        EntityManager manager = Persistence.createEntityManagerFactory("car").createEntityManager();
        manager.getTransaction().begin();
        Car carFirst = new Car("Ford", "Fiesta", TypeBody.SEDAN, GearBox.CVT, TypeEngine.GAS,
                Drive.FRONT, 1.6f, 2010, 89000, 400000,
                "Якутия", "Якутск", "WWWXT12432FRTWE44");
        Car carSecond = new Car("Ford", "Focus", TypeBody.WAGON, GearBox.CVT, TypeEngine.GASOLINE,
                Drive.FRONT, 1.6f, 2018, 45000, 900000,
                "Свердловская область","Екатеринбург" ,"WRTXT124FDFRTWE44");
        Owner owner = new Owner("Джон Уик", "12431 4344", "Boogerman", "kililhhgj");
        owner.setCar(carFirst);
        owner.setCar(carSecond);
        manager.persist(owner);
        manager.getTransaction().commit();
        manager.close();
    }
}
