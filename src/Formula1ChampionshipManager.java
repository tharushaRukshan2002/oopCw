import java.io.*;
import java.util.*;

/**
 * This class implements championshipManager class.
 * This class contains num of drivers participating in the championship and the number of cars
 * and this has methods to add new driver, delete a driver, change a team of a driver, display information of a requested
 * driver,display drivers from max points to min points, update race details and save data method.
 */

public class Formula1ChampionshipManager implements ChampionshipManager {
    private int numOfDrivers;
    private int numOfCars;
    private final Scanner sc = new Scanner(System.in);
    private ArrayList<Formula1Driver> driver = new ArrayList<>();
    private ArrayList<Object> races = new ArrayList<>();

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

    public ArrayList<Formula1Driver> getDriver() {
        return driver;
    }

    public void setDriver(ArrayList<Formula1Driver> driver) {
        this.driver = driver;
    }


    /**
     * This method will call all the sub methods. All the methods inside this method has been created below.
     */
    @Override
    public void mainMethod() {
        boolean goAgain = true;
        try {

            while (goAgain) {
                System.out.println("\n+++++++++++++++++++++Main Menu+++++++++++++++++++++++++++++");
                System.out.println("1. Add a new driver.");
                System.out.println("2. Delete a driver.");
                System.out.println("3. Change the driver for an existing constructor team.");
                System.out.println("4. View driver details.");
                System.out.println("5. Championship standings(descending order).");
                System.out.println("6. Update race details.");
                System.out.println("7. Save data(current data).");
                System.out.println("999. Exit\n");

                int choice = sc.nextInt();

                switch (choice) {
                    case 1 -> addNewDriver();
                    case 2 -> deleteDriver();
                    case 3 -> changeDriver();
                    case 4 -> driverInfoDisplay();
                    case 5 -> sort();
                    case 6 -> updateRaceDetails();
                    case 7 -> saveToFile();
                    case 999 -> goAgain = false;
                    default -> System.out.println("Not acceptable.\n");

                }
            }

        } catch (Exception e) {
            System.out.println("Error: " + e);
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
        String currentTeam;
        boolean hasMatch = false;
        try {
            System.out.println("\t--Add new driver--");
            System.out.println("Enter the team you want to add:");
            String team = sc.next();
            team += sc.nextLine();
            for (Formula1Driver formula1Driver : getDriver()) {
                currentTeam = formula1Driver.getTeam();
                hasMatch = currentTeam.equalsIgnoreCase(team);
                if (hasMatch) {
                    System.out.println("This team already has a driver.");
                    break;
                }
            }
            if (!hasMatch) {
                System.out.println("Enter the Full name:");
                String name = sc.next();
                name += sc.nextLine();
                System.out.println("Enter the country: ");
                String country = sc.nextLine();
                getDriver().add(new Formula1Driver(name, country, team));
                numOfDrivers++;
            }
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }


    }

    /**
     * This function is used to delete drivers and teams all the data that relevant to that driver and team will be
     * deleted.
     * CASE 2 in the main method
     */
    @Override
    public void deleteDriver() {
        try {
            System.out.println("Select the number of the driver and the team you want to delete.");
            for (int i = 0; i < getDriver().size(); i++) {
                System.out.println((i + 1) + ". Name: " + getDriver().get(i).getName());
            }
            int index = sc.nextInt();
            getDriver().remove(index - 1);
            numOfDrivers--;
        } catch (Exception e) {
            System.out.println("Error: " + e);
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
            for (int i = 0; i < getDriver().size(); i++) {
                System.out.println((i + 1) + ". Name: " + getDriver().get(i).getName());

            }

            int index = sc.nextInt();
            System.out.println("Enter the new team:");
            String team = sc.next();
            team += sc.nextLine();
            for (Formula1Driver formula1Driver : getDriver()) {
                currentTeam = formula1Driver.getTeam();
                hasMatch = currentTeam.equalsIgnoreCase(team);
                if (hasMatch) {
                    System.out.println("You Cannot change the team of the driver.");
                    break;
                }
            }
            if (!hasMatch) {
                getDriver().get(index - 1).setTeam(team);
            }

        } catch (Exception e) {
            System.out.println("Error: " + e);
        }

    }

    /**
     * Display driver information.
     * CASE 4 in the main method
     */
    @Override
    public void driverInfoDisplay() {
        try {
            System.out.println("Select the number of the driver you want to see details:");
            for (int i = 0; i < getDriver().size(); i++) {
                System.out.println((i + 1) + ". Name: " + getDriver().get(i).getName());
            }
            int index = sc.nextInt();
            getDriver().get(index - 1).displayInfo();

        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
    }

    /**
     * Sorting method is implemented here I have used Comparator to do the sorting(list.sort). First this method will
     * check the comparison of the total points if it is 0 it will check the number of first positions.And after that it
     * will display the data in a table format to the user.
     * CASE 5 in the main method
     */
    @Override
    public void sort() {
        ArrayList<Formula1Driver> copy = new ArrayList<>(getDriver());//shallow copy of the original driver list.
        try {
            boolean sameAsLast = false;
            copy.sort(new Comparator<Formula1Driver>() {
                @Override
                public int compare(Formula1Driver o1, Formula1Driver o2) {
                    int comparison;
                    comparison = Integer.compare(o2.getTotalPoints(), o1.getTotalPoints());
                    if (comparison == 0) {
                        comparison = Integer.compare(o2.getFirstPositions(), o1.getFirstPositions());
                    }
                    return comparison;
                }
            });
            System.out.println("-------------------------Driver Standings-----------------------");
            System.out.format("%-15s%-20s%-10s%-10s%-10s", "Position", "Name", "Team", "Points", "1st Places");
            int i = 0;
            for (Formula1Driver currentDriver : copy) {
                i++;
                System.out.format("\n%-15d%-20s%-10s%-10d%-10d", i, currentDriver.getName(), currentDriver.getTeam(),
                        currentDriver.getTotalPoints(), currentDriver.getFirstPositions());
            }
            System.out.print("\n----------------------------------------------------------------");
            System.out.println();

        } catch (Exception e) {
            System.out.println("Error: " + e);
        }


    }

    /**
     * This method will take drivers position as input, and then it will update number of points according to the
     * position.
     * CASE 6 in the main method
     */
    public void updateRaceDetails() {
        int[] positions = new int[getDriver().size()];
        int i = 0;
        try {
            System.out.println("Date of the race(dd-mm-yyyy): ");
            String date = sc.next();
            while (i < getDriver().size()) {
                boolean hasMatch = false;

                System.out.println("Enter the position for: " + getDriver().get(i).getName());
                int position = sc.nextInt();
                for (int k : positions) {
                    if (k == position || position > getDriver().size()) {
                        hasMatch = true;
                        break;
                    }
                }
                if (hasMatch) {
                    System.out.println("The position is you entered is not valid.");
                } else {
                    getDriver().get(i).updatePoints(position);
                    races.add(date + " " + getDriver().get(i).getName() + " " + position);
                    positions[i] = position;
                    i++;
                }
            }
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
    }

    /**
     * This method is created to save the program using  Serialization
     * https://stackoverflow.com/questions/34626970/how-to-write-an-array-of-objects-to-a-file-in-java
     * CASE 7 in the main method.
     */
    public void saveToFile() {
        try {
            FileOutputStream file = new FileOutputStream("drivers.ser");
            ObjectOutputStream out = new ObjectOutputStream(file);
            // Method for serialization of object
            out.writeObject(getDriver());
            out.close();
            file.close();


        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
    }

    /**
     * This method is created deserialize data and load it back to the program.
     */
    public void loadData() {
        try {
            FileInputStream file = new FileInputStream("drivers.ser");
            ObjectInputStream in = new ObjectInputStream(file);
            // Method for deserialization of object
            setDriver((ArrayList<Formula1Driver>) in.readObject());
            in.close();
            file.close();


        } catch (Exception ignored) {


        }
    }
}





