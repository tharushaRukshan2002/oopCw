import java.util.ArrayList;
import java.util.Scanner;

public class Formula1ChampionshipManager implements ChampionshipManager {
    private int numOfDrivers;
    private int numOfCars = numOfDrivers;
    private final Scanner sc = new Scanner(System.in);
    private final ArrayList<Formula1Driver> driver = new ArrayList<>();

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

    /**
     * This method will call all the sub methods. All the methods inside this method has been created below.
     */
    @Override
    public void mainMethod() {

        try {
            while (true) {
                System.out.println("\n\n+++++++++++++++++++++Main Menu+++++++++++++++++++++++++++++");
                System.out.println("1. Add a new driver.");
                System.out.println("2. Delete a driver.");
                System.out.println("3. Change the driver for an existing constructor team.");
                System.out.println("4. View driver details.");
                System.out.println("5. Championship standings(descending order).");
                int choice = sc.nextInt();

                switch (choice) {
                    case 1 -> addNewDriver();
                    case 2 -> deleteDriver();
                    case 3 -> changeDriver();
                    case 4 -> driverInfoDisplay();
                }
            }

        } catch (Exception e) {
            System.out.println("\nThe input is not valid.");
        }

    }

    /**
     * This method will add a new driver to the team. Before it add it will check whether that team already has a
     * driver in it. If the team doesn't have a driver it will add otherwise it will display a msg informing the
     * user that the user is not able to add the driver to that particular team.
     * CASE1 in the main method
     */

    @Override
    public void addNewDriver() {
        String currentTeam = "";
        boolean hasMatch = false;
        try {
            System.out.println("\nEnter the team you want to add:");
            String team = sc.next();

            for (int i = 0; i < driver.size(); i++) {
                currentTeam = driver.get(i).getTeam();
                hasMatch = currentTeam.equalsIgnoreCase(team);
                if (hasMatch) {
                    System.out.println("This team already has a driver.");
                    break;
                }
            }
            if (!hasMatch) {
                System.out.println("Enter the name:");
                String name = sc.next();
                System.out.println("Enter the country:");
                String country = sc.next();
                driver.add(new Formula1Driver(name, country, team));
                numOfDrivers++;
            }


        } catch (Exception e) {
            System.out.println("\nThe input is not valid.");
        }


    }

    /**
     * This function is used to delete drivers and teams all the data that relevant to that driver and team will be
     * deleted .
     * CASE 2 in the main method
     */

    @Override
    public void deleteDriver() {
        try {
            System.out.println("Select the number of the driver and the team you want to delete.");
            for (int i = 0; i < driver.size(); i++) {
                System.out.println((i + 1) + ". Name: " + driver.get(i).getName());
            }
            int index = sc.nextInt();
            driver.remove(index - 1);
            numOfDrivers--;
        } catch (Exception e) {
            System.out.println("\nThe input is not valid.");
        }

    }

    /**
     * This function will change the team of a driver. Before Changing it will check if that team is already
     * occupied by another driver.
     * CASE 3 in the main method
     */

    @Override
    public void changeDriver() {
        boolean hasMatch = false;
        String currentTeam = "";
        try {
            System.out.println("Select the number of the driver you want to change:");
            for (int i = 0; i < driver.size(); i++) {
                System.out.println((i + 1) + ". Name: " + driver.get(i).getName());

            }

            int index = sc.nextInt();
            System.out.println("Enter the new team:");
            String team = sc.next();
            for (int i = 0; i < driver.size(); i++) {
                currentTeam = driver.get(i).getTeam();
                hasMatch = currentTeam.equalsIgnoreCase(team);
                if (hasMatch) {
                    System.out.println("You Cannot change the team of the driver.");
                    break;
                }
            }
            if (!hasMatch) {
                driver.get(index - 1).setTeam(team);
            }

        } catch (Exception e) {
            System.out.println("\nThe input is not valid.");
        }

    }

    /**
     * Display driver information
     * CASE 4 in the main method
     */

    public void driverInfoDisplay() {
        try {
            System.out.println("Select the number of the driver you want to see details:");
            for (int i = 0; i < driver.size(); i++) {
                System.out.println((i + 1) + ". Name: " + driver.get(i).getName());
            }
            int index = sc.nextInt();
            driver.get(index - 1).displayInfo();

        } catch (Exception e) {
            System.out.println("\nThe input is not valid.");
        }
    }


    /**
     * This method is used to sort and display the driver rankings according to points. In case if points are equal
     * then we see the driver who has most 1st positions.
     * CASE 5 in the main method
     */

    public void sortMethodToTable() {

    }

}


