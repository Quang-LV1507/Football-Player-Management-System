import java.util.Scanner;

public class Salary {
    private String playerId;
    private int month;
    private int year;
    private double baseSalary;
    private double performanceBonus;
    private double totalSalary;

    public Salary() {
    }

    public Salary(String playerId, int month, int year,
                  double baseSalary, double performanceBonus) {
        setPlayerId(playerId);
        setMonth(month);
        setYear(year);
        setBaseSalary(baseSalary);
        setPerformanceBonus(performanceBonus);
        calculateTotalSalary();
    }

    public void inputSalaryInfo(Scanner sc, Player player) {
        System.out.println("\n===== ENTER SALARY INFORMATION =====");

        playerId = player.getPlayerId();
        baseSalary = player.getBaseSalary();
        month = inputMonth(sc, "Month: ");
        year = inputYearFrom2026(sc, "Year: ");
        performanceBonus = inputNonNegativeDouble(sc, "Performance Bonus: ");
        calculateTotalSalary();
    }

    public void updateSalaryInfo(Scanner sc, Player player) {
        System.out.println("\n===== UPDATE SALARY INFORMATION =====");

        baseSalary = player.getBaseSalary();
        performanceBonus = inputNonNegativeDouble(sc, "New Performance Bonus: ");
        calculateTotalSalary();
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

    private double inputNonNegativeDouble(Scanner sc, String message) {
        double number = 0;
        boolean valid = false;

        do {
            try {
                System.out.print(message);
                number = Double.parseDouble(sc.nextLine().trim());

                if (number >= 0) {
                    valid = true;
                } else {
                    System.out.println("Invalid input. Number cannot be negative.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid number.");
            }
        } while (!valid);

        return number;
    }

    private boolean isNumeric(String value) {
        return value != null && value.matches("\\d+");
    }

    private void calculateTotalSalary() {
        totalSalary = baseSalary + performanceBonus;
    }

    public String getPlayerId() {
        return playerId;
    }

    public void setPlayerId(String playerId) {
        if (!isNumeric(playerId)) {
            throw new IllegalArgumentException("Player ID must contain numbers only.");
        }
        this.playerId = playerId.trim();
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        if (month < 1 || month > 12) {
            throw new IllegalArgumentException("Month must be from 1 to 12.");
        }
        this.month = month;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        if (year < 2026) {
            throw new IllegalArgumentException("Year must be from 2026 onwards.");
        }
        this.year = year;
    }

    public double getBaseSalary() {
        return baseSalary;
    }

    public void setBaseSalary(double baseSalary) {
        if (baseSalary < 0) {
            throw new IllegalArgumentException("Base salary cannot be negative.");
        }
        this.baseSalary = baseSalary;
        calculateTotalSalary();
    }

    public double getPerformanceBonus() {
        return performanceBonus;
    }

    public void setPerformanceBonus(double performanceBonus) {
        if (performanceBonus < 0) {
            throw new IllegalArgumentException("Performance bonus cannot be negative.");
        }
        this.performanceBonus = performanceBonus;
        calculateTotalSalary();
    }

    public double getTotalSalary() {
        return totalSalary;
    }

    public void displaySalaryInfo() {
        System.out.println("Player ID: " + playerId);
        System.out.println("Month: " + month);
        System.out.println("Year: " + year);
        System.out.println("Base Salary: " + baseSalary);
        System.out.println("Performance Bonus: " + performanceBonus);
        System.out.println("Total Salary: " + totalSalary);
    }
}
