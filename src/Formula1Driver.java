public class Formula1Driver extends Driver {
    private int FirstPositions;
    private int SecondPositions;
    private int ThirdPositions;
    private int totalPoints ;
    private int totalNumberOfRacers;

    public Formula1Driver(String name, String country, String team){
        super(name, country, team);
    }
    public int getFirstPositions() {
        return FirstPositions;
    }

    public void setFirstPositions(int firstPositions) {
        FirstPositions = firstPositions;
    }

    public int getSecondPositions() {
        return SecondPositions;
    }

    public void setSecondPositions(int secondPositions) {
        SecondPositions = secondPositions;
    }

    public int getThirdPositions() {
        return ThirdPositions;
    }

    public void setThirdPositions(int thirdPositions) {
        ThirdPositions = thirdPositions;
    }

    public int getTotalPoints() {
        return totalPoints;
    }

    public void setTotalPoints(int totalPoints) {
        this.totalPoints = totalPoints;
    }

    public int getTotalNumberOfRacers() {
        return totalNumberOfRacers;
    }

    public void setTotalNumberOfRacers(int totalNumberOfRacers) {
        this.totalNumberOfRacers = totalNumberOfRacers;
    }


    /**
     * This method will show all the details of a selected driver.
     */
    public void displayInfo(){
        System.out.println("\n--Showing details of the Driver--");
        System.out.println("\nName: " + getName());
        System.out.println("Team: " + getTeam());
        System.out.println("Country: " + getCountry());
        System.out.println("Points: " + getTotalPoints());
        System.out.println("Positions:");
        System.out.println("\t1st places earned: " + getFirstPositions());
        System.out.println("\t2nd places earned: " + getSecondPositions());
        System.out.println("\t3rd places earned: " + getThirdPositions());
    }
}



