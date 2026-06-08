import java.util.ArrayList;
import java.util.Scanner;

public class SalaryList {
    private ArrayList<Salary> salaries;

    public SalaryList() {
        salaries = new ArrayList<>();
    }

    public void manageSalaries(Scanner sc, PlayerList playerList) {
        int choice;

        do {
            System.out.println("\n===== SALARY MANAGEMENT =====");
            System.out.println("1. Add salary");
            System.out.println("2. Display all salaries");
            System.out.println("3. Search salary by Player ID");
            System.out.println("4. Update salary");
            System.out.println("5. Delete salary");
            System.out.println("6. Exit salary management");
            choice = inputMenuChoice(sc, "Choose option: ");

            switch (choice) {
                case 1:
                    addSalaryByPlayer(sc, playerList);
                    break;

                case 2:
                    System.out.println("\n===== ALL SALARIES =====");
                    displayAllSalaries();
                    break;

                case 3:
                    System.out.println("\n===== SEARCH SALARY =====");
                    String searchId = inputNumericString(sc, "Enter Player ID to search salary: ");
                    displaySalariesByPlayerId(searchId);
                    break;

                case 4:
                    System.out.println("\n===== UPDATE SALARY =====");
                    String updatePlayerId = inputNumericString(sc, "Enter Player ID: ");
                    int updateMonth = inputMonth(sc, "Enter Month: ");
                    int updateYear = inputYearFrom2026(sc, "Enter Year: ");
                    updateSalary(updatePlayerId, updateMonth, updateYear, sc, playerList);
                    break;

                case 5:
                    System.out.println("\n===== DELETE SALARY =====");
                    String deletePlayerId = inputNumericString(sc, "Enter Player ID: ");
                    int deleteMonth = inputMonth(sc, "Enter Month: ");
                    int deleteYear = inputYearFrom2026(sc, "Enter Year: ");
                    deleteSalary(deletePlayerId, deleteMonth, deleteYear);
                    break;

                case 6:
                    System.out.println("Exit salary management.");
                    break;

                default:
                    System.out.println("Invalid option. Please choose again.");
                    break;
            }
        } while (choice != 6);
    }

    private int inputMenuChoice(Scanner sc, String message) {
        int choice = -1;
        boolean valid = false;

        do {
            try {
                System.out.print(message);
                choice = Integer.parseInt(sc.nextLine().trim());
                valid = true;
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number.");
            }
        } while (!valid);

        return choice;
    }

    private String inputNumericString(Scanner sc, String message) {
        String value;
        do {
            System.out.print(message);
            value = sc.nextLine().trim();

            if (!value.matches("\\d+")) {
                System.out.println("Invalid input. ID must contain numbers only.");
            }
        } while (!value.matches("\\d+"));

        return value;
    }

    private int inputMonth(Scanner sc, String message) {
        int number = 0;
        boolean valid = false;

        do {
            try {
                System.out.print(message);
                number = Integer.parseInt(sc.nextLine().trim());

                if (number >= 1 && number <= 12) {
                    valid = true;
                } else {
                    System.out.println("Invalid month. Month must be from 1 to 12.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid integer number.");
            }
        } while (!valid);

        return number;
    }

    private int inputYearFrom2026(Scanner sc, String message) {
        int number = 0;
        boolean valid = false;

        do {
            try {
                System.out.print(message);
                number = Integer.parseInt(sc.nextLine().trim());

                if (number >= 2026) {
                    valid = true;
                } else {
                    System.out.println("Invalid year. Year must be from 2026 onwards.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid integer number.");
            }
        } while (!valid);

        return number;
    }

    private void addSalaryByPlayer(Scanner sc, PlayerList playerList) {
        System.out.println("\n===== ADD SALARY =====");
        String playerId = inputNumericString(sc, "Enter Player ID for this salary: ");

        Player player = playerList.searchPlayerById(playerId);

        if (player == null) {
            System.out.println("Player not found. Please add player first.");
            return;
        }

        Salary salary = new Salary();
        salary.inputSalaryInfo(sc, player);

        if (searchSalary(player.getPlayerId(), salary.getMonth(), salary.getYear()) != null) {
            System.out.println("Salary for this player/month/year already exists. Cannot add duplicate salary.");
            return;
        }

        salaries.add(salary);
        System.out.println("Salary added successfully.");
    }

    public Salary searchSalary(String playerId, int month, int year) {
        for (Salary salary : salaries) {
            if (salary.getPlayerId().equalsIgnoreCase(playerId.trim())
                    && salary.getMonth() == month
                    && salary.getYear() == year) {
                return salary;
            }
        }
        return null;
    }

    public void displaySalariesByPlayerId(String playerId) {
        boolean found = false;

        for (Salary salary : salaries) {
            if (salary.getPlayerId().equalsIgnoreCase(playerId.trim())) {
                salary.displaySalaryInfo();
                System.out.println("-----------------------------");
                found = true;
            }
        }

        if (!found) {
            System.out.println("No salary found for this player.");
        }
    }

    public void updateSalary(String playerId, int month, int year, Scanner sc, PlayerList playerList) {
        Salary salary = searchSalary(playerId, month, year);

        if (salary == null) {
            System.out.println("Salary not found.");
            return;
        }

        Player player = playerList.searchPlayerById(playerId);

        if (player == null) {
            System.out.println("Related player not found. Cannot update salary.");
            return;
        }

        salary.updateSalaryInfo(sc, player);
        System.out.println("Salary updated successfully.");
    }

    public void deleteSalary(String playerId, int month, int year) {
        Salary salary = searchSalary(playerId, month, year);

        if (salary != null) {
            salaries.remove(salary);
            System.out.println("Salary deleted successfully.");
        } else {
            System.out.println("Salary not found.");
        }
    }

    public void displayAllSalaries() {
        if (salaries.isEmpty()) {
            System.out.println("No salaries available.");
            return;
        }

        for (Salary salary : salaries) {
            salary.displaySalaryInfo();
            System.out.println("-----------------------------");
        }
    }
}
