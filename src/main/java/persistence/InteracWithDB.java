package persistence;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import entities.car.Car;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import java.util.List;

public class InteracWithDB {
    private EntityManager manager;
    public InteracWithDB() {
        manager = Persistence.createEntityManagerFactory("car").createEntityManager();
    }

    public String getAllCarsInJson() throws JsonProcessingException {
        manager.getTransaction().begin();
        List<Car> carList = manager.createQuery("select c from Car c").getResultList();
        return new ObjectMapper().writeValueAsString(carList);
    }
}
