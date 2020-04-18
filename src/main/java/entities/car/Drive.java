package entities.car;

public enum Drive {
    FRONT("Передний"),
    REAR("Задний"),
    FULL("Полный");
    private final String ruName;

    Drive(String ruName) {
        this.ruName = ruName;
    }

    public String getRuName() {
        return ruName;
    }
}
