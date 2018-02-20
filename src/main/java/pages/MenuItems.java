package pages;


public enum MenuItems {
    JOB("Работа"),
    AUTO("Авто"),
    WEATHER("Погода");

    private String title;

    MenuItems(String title) {
        this.title = title;
    }

    public String get() {
        return this.title;
    }
}