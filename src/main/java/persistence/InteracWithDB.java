package persistence;

import entities.car.Car;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import java.util.Base64;
import java.util.List;

public class InteracWithDB {
    private EntityManager manager;
    public InteracWithDB() {
        manager = Persistence.createEntityManagerFactory("car").createEntityManager();
    }

    public String getAllCarsInJson() {
        manager.getTransaction().begin();
        List<Car> carList = manager.createQuery("select c from Car c").getResultList();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[");
        int lengthList = carList.size();
        for (int i = 0; i < lengthList; i++) {
            stringBuilder.append("{");
            stringBuilder.append("\"id\":");
            stringBuilder.append(carList.get(i).getId());
            stringBuilder.append(",");

            stringBuilder.append("\"brand\":");
            stringBuilder.append("\"");
            stringBuilder.append(carList.get(i).getBrand());
            stringBuilder.append("\",");

            stringBuilder.append("\"model\":");
            stringBuilder.append("\"");
            stringBuilder.append(carList.get(i).getModel());
            stringBuilder.append("\",");

            stringBuilder.append("\"typeBody\":");
            stringBuilder.append("\"");
            stringBuilder.append(carList.get(i).getTypeBody());
            stringBuilder.append("\",");

            stringBuilder.append("\"gearBox\":");
            stringBuilder.append("\"");
            stringBuilder.append(carList.get(i).getGearBox());
            stringBuilder.append("\",");

            stringBuilder.append("\"typeEngine\":");
            stringBuilder.append("\"");
            stringBuilder.append(carList.get(i).getTypeEngine());
            stringBuilder.append("\",");

            stringBuilder.append("\"drive\":");
            stringBuilder.append("\"");
            stringBuilder.append(carList.get(i).getDrive());
            stringBuilder.append("\",");

            stringBuilder.append("\"volumeEngine\":");
            stringBuilder.append(carList.get(i).getVolumeEngine());
            stringBuilder.append(",");

            stringBuilder.append("\"yearOfRelease\":");
            stringBuilder.append(carList.get(i).getYearOfRelease());
            stringBuilder.append(",");

            stringBuilder.append("\"millage\":");
            stringBuilder.append(carList.get(i).getMillage());
            stringBuilder.append(",");

            stringBuilder.append("\"price\":");
            stringBuilder.append(carList.get(i).getPrice());
            stringBuilder.append(",");

            stringBuilder.append("\"vin\":");
            stringBuilder.append("\"");
            stringBuilder.append(carList.get(i).getVin());
            stringBuilder.append("\",");

            stringBuilder.append("\"state\":");
            stringBuilder.append("\"");
            stringBuilder.append(carList.get(i).getAddress().getState());
            stringBuilder.append("\",");

            stringBuilder.append("\"town\":");
            stringBuilder.append("\"");
            stringBuilder.append(carList.get(i).getAddress().getTown());
            stringBuilder.append("\",");


            stringBuilder.append("\"imageData\":");
            stringBuilder.append("\"");
            stringBuilder.append(Base64.getEncoder().encodeToString(carList.get(i).getImageData()));
            stringBuilder.append("\"");


            stringBuilder.append("}");

            if (i == lengthList - 1) {
                break;
            }

            stringBuilder.append(",");
        }
        stringBuilder.append("]");

        return stringBuilder.toString();
    }
}
