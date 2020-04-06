package car;

import owner.Owner;

import javax.persistence.*;

@Entity
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(length = 20)
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
    @Column(length = 100)
    private String state;
    @Column(length = 50)
    private String town;
    @ManyToOne(cascade = {
            CascadeType.DETACH,
            CascadeType.MERGE,
            CascadeType.PERSIST,
            CascadeType.REFRESH
    })
    private Owner owner;
    @Column(length = 17)
    private String vin;


    public Car() {
    }

    public Car(String brand, String model, TypeBody typeBody, GearBox gearBox,
               TypeEngine typeEngine, Drive drive, float volumeEngine, int yearOfRelease,
               int millage, int price, String state, String town, String vin) {
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
        this.state = state;
        this.town = town;
        this.vin = vin;
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
}
