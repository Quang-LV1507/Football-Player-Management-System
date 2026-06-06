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
            choice = Player.inputMenuChoice(sc, "Choose option: ", 1, 6);

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
                    String searchPlayerId = Player.inputNumericString(sc, "Enter Player ID to search salary: ", "Player ID");
                    displaySalariesByPlayerId(searchPlayerId);
                    break;

                case 4:
                    System.out.println("\n===== UPDATE SALARY =====");
                    String updatePlayerId = Player.inputNumericString(sc, "Enter Player ID: ", "Player ID");
                    int updateMonth = Player.inputIntInRange(sc, "Enter Month (1-12): ", "Month", 1, 12);
                    int updateYear = Player.inputYearFrom2026(sc, "Enter Year (from 2026 onwards): ");
                    updateSalary(updatePlayerId, updateMonth, updateYear, sc, playerList);
                    break;

                case 5:
                    System.out.println("\n===== DELETE SALARY =====");
                    String deletePlayerId = Player.inputNumericString(sc, "Enter Player ID: ", "Player ID");
                    int deleteMonth = Player.inputIntInRange(sc, "Enter Month (1-12): ", "Month", 1, 12);
                    int deleteYear = Player.inputYearFrom2026(sc, "Enter Year (from 2026 onwards): ");
                    deleteSalary(deletePlayerId, deleteMonth, deleteYear);
                    break;

                case 6:
                    System.out.println("Exit salary management.");
                    break;
            }
        } while (choice != 6);
    }

    private void addSalaryByPlayer(Scanner sc, PlayerList playerList) {
        System.out.println("\n===== ADD SALARY =====");
        String playerId = Player.inputNumericString(sc, "Enter Player ID for this salary: ", "Player ID");

        Player player = playerList.searchPlayerById(playerId);

        if (player == null) {
            System.out.println("Player not found. Please add player first.");
            return;
        }

        Salary salary = new Salary();
        salary.inputSalaryInfo(sc, player);

        if (searchSalary(salary.getPlayerId(), salary.getMonth(), salary.getYear()) != null) {
            System.out.println("Salary for this player, month and year already exists.");
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
