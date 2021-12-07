/**
 * This class is extends driver class and this class contains details about driver details
 * number of first, second, Third positions, total points
 */
public class Formula1Driver extends Driver  {
    private int firstPositions;
    private int secondPositions;
    private int thirdPositions;
    private int totalPoints ;
    private int totalNumberOfRacers;
    private int points;

    public Formula1Driver(String name, String country, String teams){
        super(name, country,teams );

    }
    public int getFirstPositions() {
        return firstPositions;
    }

    public void setFirstPositions(int firstPositions) {
        this.firstPositions = firstPositions;
    }

    public int getSecondPositions() {
        return secondPositions;
    }

    public void setSecondPositions(int secondPositions) {
        this.secondPositions = secondPositions;
    }

    public int getThirdPositions() {
        return thirdPositions;
    }

    public void setThirdPositions(int thirdPositions) {
        this.thirdPositions = thirdPositions;
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

    /**
     * This will update points
     */
    public int updatePoints(int choice){
        switch (choice) {
            case 0 ->{
                totalNumberOfRacers +=1;
            }
            case 1 -> {
                totalPoints += 25;
                firstPositions += 1;
                totalNumberOfRacers += 1;
                points = 25;

            }
            case 2 -> {
                totalPoints += 18;
                secondPositions += 1;
                totalNumberOfRacers += 1;
                points = 18;
            }
            case 3 -> {
                totalPoints += 15;
                thirdPositions += 1;
                totalNumberOfRacers += 1;
                points = 15;
            }
            case 4 -> {
                totalPoints += 12;
                totalNumberOfRacers += 1;
                points = 12;
            }
            case 5 -> {
                totalPoints += 10;
                totalNumberOfRacers += 1;
                points = 10;
            }
            case 6 -> {
                totalPoints += 8;
                totalNumberOfRacers += 1;
                points = 8;
            }
            case 7 -> {
                totalPoints += 6;
                totalNumberOfRacers += 1;
                points = 6;
            }
            case 8 -> {
                totalPoints += 4;
                totalNumberOfRacers += 1;
                points = 4;
            }
            case 9 -> {
                totalPoints += 2;
                totalNumberOfRacers += 1;
                points = 2;
                }
            case 10 -> {
                totalPoints += 1;
                totalNumberOfRacers += 1;
                points = 1;
            }
            default -> totalNumberOfRacers += 1;
        }
        return points;
}


}



