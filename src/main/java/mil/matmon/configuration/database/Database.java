package mil.matmon.configuration.database;

public abstract class Database {
    private String name;

    public Database(String name)
    {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
