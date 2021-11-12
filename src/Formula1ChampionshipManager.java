public class Formula1ChampionshipManager implements ChampionshipManager {
    private int numOfDrivers;
    private int numOfCars;
    private Formula1Driver driver;

    public Formula1ChampionshipManager(Formula1Driver driver) {
        this.driver = driver;
    }

    public Formula1ChampionshipManager(int numOfDrivers, int numOfCars) {
        this.numOfDrivers = numOfDrivers;
        this.numOfCars = numOfCars;

    }

    public int getNumOfDrivers() {
        return numOfDrivers;
    }

    public void setNumOfDrivers(int numOfDrivers) {
        this.numOfDrivers = numOfDrivers;
    }

    public int getNumOfCars() {
        return numOfCars;
    }

    public void setNumOfCars(int numOfCars) {
        this.numOfCars = numOfCars;
    }


    public Formula1Driver getDriver() {
        return driver;
    }

    public void setDriver(Formula1Driver driver) {
        this.driver = driver;
    }

    public void DoSomethingAlpha() {
        this.driver.displayInfo();//https://stackoverflow.com/questions/6576855/java-how-to-access-methods-from-another-class/6576928
    }

}
