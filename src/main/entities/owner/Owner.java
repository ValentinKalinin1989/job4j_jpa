package owner;

import car.Car;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Owner {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(length = 50)
    private String fullName;
    @Column(length = 10)
    private String passport;
    @Column(length = 20)
    private String login;
    @Column(length = 20)
    private String password;
    @OneToMany(mappedBy = "owner", cascade = CascadeType.ALL)
    private List<Car> carList;

    public Owner() {
    }

    public Owner(String fullName, String passport, String login, String password) {
        this.fullName = fullName;
        this.passport = passport;
        this.login = login;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getPassport() {
        return passport;
    }

    public void setPassport(String passport) {
        this.passport = passport;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Car> getCarList() {
        return carList;
    }

    public void setCar(Car car) {
        if (this.carList == null) {
            carList = new ArrayList<Car>();
        }
        carList.add(car);
    }
}
