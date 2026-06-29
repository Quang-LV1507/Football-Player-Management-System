import java.util.Scanner;


public class Salary {
    private String salaryId;
    private String playerId;
    private int month;
    private int year;
    private double playerMonthlySalary;
    private double performanceBonus;
    private double totalSalary;

    public Salary() {
    }

    public Salary(String salaryId, String playerId, int month, int year,
                  double playerMonthlySalary, double performanceBonus) {
        if (salaryId != null && salaryId.matches("\\d+")) {
            this.salaryId = salaryId;
        }
        if (playerId != null && playerId.matches("\\d+")) {
            this.playerId = playerId;
        }
        if (month >= 1 && month <= 12) {
            this.month = month;
        }
        if (year >= 2026) {
            this.year = year;
        }
        if (playerMonthlySalary >= 0) {
            this.playerMonthlySalary = playerMonthlySalary;
        }
        if (performanceBonus >= 0) {
            this.performanceBonus = performanceBonus;
        }
        calculateTotalSalary();
    }

    public void inputSalaryInformation(Scanner sc) {
        System.out.println("\n===== ENTER SALARY INFORMATION =====");
        salaryId = inputNumericId(sc, "Salary ID: ");
        playerId = inputNumericId(sc, "Player ID: ");
        month = inputMonth(sc, "Month (1-12): ");
        year = inputYear(sc, "Year (from 2026): ");
        performanceBonus = inputNonNegativeDouble(sc, "Performance Bonus: ");
        calculateTotalSalary();
    }

    public void updateSalaryInformation(Scanner sc) {
        System.out.println("\n===== UPDATE SALARY INFORMATION =====");
        month = inputMonth(sc, "New Month (1-12): ");
        year = inputYear(sc, "New Year (from 2026): ");
        performanceBonus = inputNonNegativeDouble(sc, "New Performance Bonus: ");
        calculateTotalSalary();
    }

    private String inputNumericId(Scanner sc, String label) {
        while (true) {
            System.out.print(label);
            String value = sc.nextLine().trim();
            if (value.matches("\\d+")) {
                return value;
            }
            System.out.println("ID must contain numbers only.");
        }
    }

    private int inputMonth(Scanner sc, String message) {
        while (true) {
            try {
                System.out.print(message);
                int value = Integer.parseInt(sc.nextLine().trim());
                if (value >= 1 && value <= 12) {
                    return value;
                }
                System.out.println("Month must be from 1 to 12.");
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid month number.");
            }
        }
    }

    private int inputYear(Scanner sc, String message) {
        while (true) {
            try {
                System.out.print(message);
                int value = Integer.parseInt(sc.nextLine().trim());
                if (value >= 2026) {
                    return value;
                }
                System.out.println("Year must be from 2026 onward.");
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid year number.");
            }
        }
    }

    private double inputNonNegativeDouble(Scanner sc, String message) {
        while (true) {
            try {
                System.out.print(message);
                double value = Double.parseDouble(sc.nextLine().trim());
                if (value >= 0) {
                    return value;
                }
                System.out.println("Value cannot be negative.");
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number.");
            }
        }
    }

    private void calculateTotalSalary() {
        totalSalary = playerMonthlySalary + performanceBonus;
    }

    public String getSalaryId() {
        return salaryId;
    }

    public void setSalaryId(String salaryId) {
        if (salaryId != null && salaryId.matches("\\d+")) {
            this.salaryId = salaryId;
        }
    }

    public String getPlayerId() {
        return playerId;
    }

    public void setPlayerId(String playerId) {
        if (playerId != null && playerId.matches("\\d+")) {
            this.playerId = playerId;
        }
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        if (month >= 1 && month <= 12) {
            this.month = month;
        }
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        if (year >= 2026) {
            this.year = year;
        }
    }

    public double getBaseSalary() {
        return playerMonthlySalary;
    }

    public void setBaseSalary(double playerMonthlySalary) {
        setPlayerMonthlySalary(playerMonthlySalary);
    }

    public double getPlayerMonthlySalary() {
        return playerMonthlySalary;
    }

    public void setPlayerMonthlySalary(double playerMonthlySalary) {
        if (playerMonthlySalary >= 0) {
            this.playerMonthlySalary = playerMonthlySalary;
            calculateTotalSalary();
        }
    }

    public double getPerformanceBonus() {
        return performanceBonus;
    }

    public void setPerformanceBonus(double performanceBonus) {
        if (performanceBonus >= 0) {
            this.performanceBonus = performanceBonus;
            calculateTotalSalary();
        }
    }

    public double getTotalSalary() {
        return totalSalary;
    }

    public void displayInfo() {
        System.out.println("Salary ID: " + salaryId);
        System.out.println("Player ID: " + playerId);
        System.out.println("Month: " + month);
        System.out.println("Year: " + year);
        System.out.println("Player Monthly Salary: " + playerMonthlySalary);
        System.out.println("Performance Bonus: " + performanceBonus);
        System.out.println("Total Salary: " + totalSalary);
    }

    public void displaySalaryInformation() {
        displayInfo();
    }
}
