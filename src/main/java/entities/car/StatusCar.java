package entities.car;

public enum StatusCar {
    SALES("Продано"),
    FOR_SALE("Продается");
    private final String ruName;

    StatusCar(String ruName) {
        this.ruName = ruName;
    }

    public String getRuNme() {
        return ruName;
    }
}


