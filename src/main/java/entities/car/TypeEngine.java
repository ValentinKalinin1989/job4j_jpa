package entities.car;

public enum TypeEngine {
    GASOLINE("Бензин"),
    DIESEL("Дизель"),
    GAS("Газ"),
    ELECTRIC("Електро"),
    HYBRID("Гибрид");

    private final String ruName;

    TypeEngine(String ruName) {
        this.ruName = ruName;
    }

    public String getRuName() {
        return ruName;
    }
}
