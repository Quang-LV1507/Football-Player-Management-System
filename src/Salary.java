import java.util.Scanner;

public class Salary extends ClubRecord {
    private String playerId;
    private int month;
    private int year;
    private double playerMonthlySalary;
    private double performanceBonus;
    private double totalSalary;

    public Salary() {
        super();
    }

    public Salary(String salaryId, String playerId, int month, int year,
                  double playerMonthlySalary, double performanceBonus) {
        super(salaryId);
        this.playerId = playerId;
        this.month = month;
        this.year = year;
        this.playerMonthlySalary = playerMonthlySalary;
        this.performanceBonus = performanceBonus;
        calculateTotalSalary();
    }

    public void inputSalaryInformation(Scanner sc) {
        System.out.println("\n===== ENTER SALARY INFORMATION =====");
        setId(inputNumericId(sc, "Salary ID: "));
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
        return getId();
    }

    public String getPlayerId() {
        return playerId;
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

    @Override
    public String getEntityType() {
        return "Salary Record";
    }

    @Override
    public void displayInfo() {
        System.out.println("Salary ID: " + getId());
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
