public abstract class Driver {
    private String name;
    private String country;
    private String team;


    public Driver(String name, String country, String team) {
        this.name = name;
        this.country = country;
        this.team = team;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getTeam() {
        return team;
    }

    public void setTeam(String team) {
        this.team = team;
    }
}
