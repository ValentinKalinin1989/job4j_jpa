package entities.car;

import entities.address.Address;
import entities.owner.Owner;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(length = 20)
    @Basic(fetch = FetchType.EAGER)
    private String brand;
    @Column(length = 20)
    private String model;
    @Enumerated(EnumType.STRING)
    @Column(length = 10)
    private TypeBody typeBody;
    @Enumerated(EnumType.STRING)
    @Column(length = 10)
    private GearBox gearBox;
    @Enumerated(EnumType.STRING)
    @Column(length = 10)
    private TypeEngine typeEngine;
    @Enumerated(EnumType.STRING)
    @Column(length = 10)
    private Drive drive;
    @Column(length = 20)
    private float volumeEngine;
    @Column(length = 4)
    private int yearOfRelease;
    @Column(length = 4)
    private int millage;
    @Column(length = 7)
    private int price;
    @Column(length = 17)
    private String vin;
    @ManyToOne(
            cascade = {
                    CascadeType.DETACH,
                    CascadeType.MERGE,
                    CascadeType.PERSIST,
                    CascadeType.REFRESH
            })
    private Owner owner;
    @ManyToOne(
            fetch = FetchType.EAGER,
            cascade = {
                    CascadeType.DETACH,
                    CascadeType.MERGE,
                    CascadeType.PERSIST,
                    CascadeType.REFRESH
            })
    private Address address;
    private byte[] imageData;
    private LocalDate datePublish;
    @Enumerated(EnumType.STRING)
    @Column(length = 8)
    private StatusCar statusCar;
    @Column(length = 1000)
    private String description;

    public Car() {
    }

    public Car(String brand, String model, TypeBody typeBody, GearBox gearBox,
               TypeEngine typeEngine, Drive drive, float volumeEngine, int yearOfRelease,
               int millage, int price, String vin, byte[] imageData, LocalDate datePublish,
               StatusCar statusCar, String description) {
        this.brand = brand;
        this.model = model;
        this.typeBody = typeBody;
        this.gearBox = gearBox;
        this.typeEngine = typeEngine;
        this.drive = drive;
        this.volumeEngine = volumeEngine;
        this.yearOfRelease = yearOfRelease;
        this.millage = millage;
        this.price = price;
        this.vin = vin;
        this.imageData = imageData;
        this.datePublish = datePublish;
        this.statusCar = statusCar;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public TypeBody getTypeBody() {
        return typeBody;
    }

    public void setTypeBody(TypeBody typeBody) {
        this.typeBody = typeBody;
    }

    public GearBox getGearBox() {
        return gearBox;
    }

    public void setGearBox(GearBox gearBox) {
        this.gearBox = gearBox;
    }

    public TypeEngine getTypeEngine() {
        return typeEngine;
    }

    public void setTypeEngine(TypeEngine typeEngine) {
        this.typeEngine = typeEngine;
    }

    public Drive getDrive() {
        return drive;
    }

    public void setDrive(Drive drive) {
        this.drive = drive;
    }

    public float getVolumeEngine() {
        return volumeEngine;
    }

    public void setVolumeEngine(float volumeEngine) {
        this.volumeEngine = volumeEngine;
    }

    public int getYearOfRelease() {
        return yearOfRelease;
    }

    public void setYearOfRelease(int yearOfRelease) {
        this.yearOfRelease = yearOfRelease;
    }

    public int getMillage() {
        return millage;
    }

    public void setMillage(int millage) {
        this.millage = millage;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }

    public String getVin() {
        return vin;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public byte[] getImageData() {
        return imageData;
    }

    public void setImageData(byte[] imageData) {
        this.imageData = imageData;
    }

    public LocalDate getDatePublish() {
        return datePublish;
    }

    public void setDatePublish(LocalDate datePublish) {
        this.datePublish = datePublish;
    }

    public void setStatusCar(StatusCar statusCar) {
        this.statusCar = statusCar;
    }

    public StatusCar getStatusCar() {
        return statusCar;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public int hashCode() {
        return model.hashCode()
                + brand.hashCode()
                + typeBody.hashCode()
                + gearBox.hashCode()
                + typeEngine.hashCode()
                + drive.hashCode()
                + (int) volumeEngine * 10
                + yearOfRelease
                + address.getState().hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Car objCar = (Car) obj;
        if (!vin.equals(objCar.getVin())) {
            return false;
        }
        return true;
    }
}
