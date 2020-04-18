package entities.address;

import entities.car.Car;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(length = 50)
    private String state;
    @Column(length = 30)
    private String town;
    @OneToMany(mappedBy = "address",
            cascade = {
                    CascadeType.DETACH,
                    CascadeType.MERGE,
                    CascadeType.PERSIST,
                    CascadeType.REFRESH
            })
    private List<Car> carList;

    public Address() {
    }

    public Address(String state, String town) {
        this.state = state;
        this.town = town;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getTown() {
        return town;
    }

    public void setTown(String town) {
        this.town = town;
    }

    public List<Car> getCarList() {
        return carList;
    }

    public void setCarList(List<Car> carList) {
        if (carList == null) {
            carList = new ArrayList<>();
        }
        this.carList = carList;
    }

    public int getId() {
        return id;
    }

    @Override
    public int hashCode() {
        return state.hashCode()
                + town.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Address objAddress = (Address) obj;
        if (state.equals(objAddress.getState()) && town.equals(objAddress.getTown())) {
            return true;
        }
        return false;
    }
}
