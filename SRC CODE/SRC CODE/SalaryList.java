import java.util.ArrayList;
import java.util.Scanner;

public class SalaryList {
    private ArrayList<Salary> salaryRecords;

    public SalaryList() {
        salaryRecords = new ArrayList<>();
    }

    public void manageSalaries(Scanner sc, PlayerList playerList) {
        int selectedOption;
        do {
            printSalaryMenu();
            selectedOption = readSalaryMenuOption(sc);

            switch (selectedOption) {
                case 1:
                    addNewSalaryRecord(sc, playerList);
                    break;
                case 2:
                    displayAllSalaryRecords();
                    break;
                case 3:
                    searchSalaryRecord(sc);
                    break;
                case 4:
                    updateSalaryRecord(sc, playerList);
                    break;
                case 5:
                    deleteSalaryRecord(sc);
                    break;
                case 6:
                    System.out.println("Back to main menu.");
                    break;
            }
        } while (selectedOption != 6);
    }

    private void printSalaryMenu() {
        System.out.println("\n===== SALARY MANAGEMENT =====");
        System.out.println("1. Add salary record");
        System.out.println("2. Display all salary records");
        System.out.println("3. Search salary by ID");
        System.out.println("4. Update salary record");
        System.out.println("5. Delete salary record");
        System.out.println("6. Back to main menu");
    }

    private void addNewSalaryRecord(Scanner sc, PlayerList playerList) {
        Salary salary = new Salary();
        salary.inputSalaryInformation(sc);

        if (findSalaryById(salary.getSalaryId()) != null) {
            System.out.println("Salary ID already exists.");
            return;
        }

        Player player = playerList.findPlayerById(salary.getPlayerId());
        if (player == null) {
            System.out.println("Player ID does not exist. Please add player first.");
            return;
        }

        // Dynamic dispatch: StarPlayer and RegularPlayer calculate salary differently.
        salary.setPlayerMonthlySalary(player.calculateMonthlySalary());
        salaryRecords.add(salary);
        System.out.println("Salary record added successfully.");
    }

    private void displayAllSalaryRecords() {
        if (salaryRecords.isEmpty()) {
            System.out.println("No salary data available.");
            return;
        }

        for (int i = 0; i < salaryRecords.size(); i++) {
            System.out.println("\n--- Salary Record " + (i + 1) + " ---");
            salaryRecords.get(i).displayInfo();
        }
    }

    private void searchSalaryRecord(Scanner sc) {
        System.out.print("Enter Salary ID to search: ");
        String searchId = sc.nextLine().trim();

        Salary salary = findSalaryById(searchId);
        if (salary == null) {
            System.out.println("Salary record not found.");
        } else {
            salary.displayInfo();
        }
    }

    private void updateSalaryRecord(Scanner sc, PlayerList playerList) {
        System.out.print("Enter Salary ID to update: ");
        String updateId = sc.nextLine().trim();

        Salary salary = findSalaryById(updateId);
        if (salary == null) {
            System.out.println("Salary record not found.");
            return;
        }

        Player player = playerList.findPlayerById(salary.getPlayerId());
        if (player != null) {
            salary.setPlayerMonthlySalary(player.calculateMonthlySalary());
        }

        salary.updateSalaryInformation(sc);
        System.out.println("Salary record updated successfully.");
    }

    private void deleteSalaryRecord(Scanner sc) {
        System.out.print("Enter Salary ID to delete: ");
        String deleteId = sc.nextLine().trim();

        Salary salary = findSalaryById(deleteId);
        if (salary == null) {
            System.out.println("Salary record not found.");
        } else {
            salaryRecords.remove(salary);
            System.out.println("Salary record deleted successfully.");
        }
    }

    private Salary findSalaryById(String salaryId) {
        for (Salary salary : salaryRecords) {
            if (salary.getSalaryId().equals(salaryId)) {
                return salary;
            }
        }
        return null;
    }

    private int readSalaryMenuOption(Scanner sc) {
        while (true) {
            try {
                System.out.print("Choose option: ");
                int option = Integer.parseInt(sc.nextLine().trim());
                if (option >= 1 && option <= 6) {
                    return option;
                }
            } catch (NumberFormatException e) {
                // message shown below
            }
            System.out.println("Please choose a valid option from 1 to 6.");
        }
    }
}
