package entities.car;

public enum TypeBody {
    SEDAN("Седан"),
    HATCHBACK("Хетчбэк"),
    CUV("Кроссовер"),
    COUPE("Купе"),
    CONVERTIBLE("Кабриолет"),
    WAGON("Универсал"),
    VAN("Минивен"),
    JEEP("Джип"),
    PICK_UP("Пикап");
    private final String ruName;

    TypeBody(String ruName) {
        this.ruName = ruName;
    }

    public String getRuName() {
        return ruName;
    }
}
