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

    public List<String> getAllUniqStates() {
        manager.getTransaction().begin();
        List<String> stateList = manager.createQuery("select distinct a.state from Address a").getResultList();
        return stateList;
    }

    public List<String> getAllUniqTowns(String state) {
        manager.getTransaction().begin();
        List<String> stateTowns = manager.createQuery("select distinct a.town from Address a where a.state = ?1")
                .setParameter(1, state).getResultList();
        return stateTowns;
    }
}
