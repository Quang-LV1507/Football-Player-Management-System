import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class Contract {
    private String contractId;
    private String playerId;
    private String playerType;
    private double baseSalary;
    private String startDate;
    private String endDate;
    private String status;

    public Contract() {
    }

    public Contract(String contractId, String playerId, String playerType,
                    double baseSalary, String startDate, String endDate, String status) {
        setContractId(contractId);
        setPlayerId(playerId);
        setPlayerType(playerType);
        setBaseSalary(baseSalary);
        setStartDate(startDate);
        setEndDate(endDate);
        setStatus(status);
    }

    public void inputContractInfo(Scanner sc, Player player) {
        System.out.println("\n===== ENTER CONTRACT INFORMATION =====");

        contractId = inputNumericString(sc, "Contract ID: ");
        playerId = player.getPlayerId();
        playerType = player.getPlayerType();
        baseSalary = player.getBaseSalary();
        status = player.getStatus();

        startDate = inputDateString(sc, "Start Date (yyyy-MM-dd): ");
        endDate = inputEndDate(sc, "End Date (yyyy-MM-dd): ", startDate);
    }

    public void updateContractInfo(Scanner sc) {
        System.out.println("\n===== UPDATE CONTRACT INFORMATION =====");

        startDate = inputDateString(sc, "New Start Date (yyyy-MM-dd): ");
        endDate = inputEndDate(sc, "New End Date (yyyy-MM-dd): ", startDate);
    }

    private String inputNumericString(Scanner sc, String message) {
        String value;
        do {
            System.out.print(message);
            value = sc.nextLine().trim();

            if (!isNumeric(value)) {
                System.out.println("Invalid input. ID must contain numbers only.");
            }
        } while (!isNumeric(value));

        return value;
    }

    private String inputDateString(Scanner sc, String message) {
        String value;
        do {
            System.out.print(message);
            value = sc.nextLine().trim();

            if (!isValidDateString(value)) {
                System.out.println("Invalid date. Use yyyy-MM-dd, real date, and year must be from 2026 onwards.");
            }
        } while (!isValidDateString(value));

        return value;
    }

    private String inputEndDate(Scanner sc, String message, String startDate) {
        String value;
        do {
            System.out.print(message);
            value = sc.nextLine().trim();

            if (!isValidDateString(value)) {
                System.out.println("Invalid date. Use yyyy-MM-dd, real date, and year must be from 2026 onwards.");
            } else if (!isEndDateAfterStartDate(startDate, value)) {
                System.out.println("Invalid end date. End date must be after start date.");
            }
        } while (!isValidDateString(value) || !isEndDateAfterStartDate(startDate, value));

        return value;
    }

    private boolean isNumeric(String value) {
        return value != null && value.matches("\\d+");
    }

    private boolean isValidDateString(String date) {
        if (date == null || !date.matches("\\d{4}-\\d{2}-\\d{2}")) {
            return false;
        }

        try {
            LocalDate parsedDate = LocalDate.parse(date);
            return parsedDate.getYear() >= 2026;
        } catch (DateTimeParseException e) {
            return false;
        }
    }

    private boolean isEndDateAfterStartDate(String startDate, String endDate) {
        try {
            LocalDate start = LocalDate.parse(startDate);
            LocalDate end = LocalDate.parse(endDate);
            return end.isAfter(start);
        } catch (DateTimeParseException e) {
            return false;
        }
    }

    private boolean isValidPlayerType(String playerType) {
        return playerType != null
                && (playerType.equalsIgnoreCase("Star")
                || playerType.equalsIgnoreCase("Regular"));
    }

    private boolean isValidStatus(String status) {
        return status != null
                && (status.equalsIgnoreCase("active")
                || status.equalsIgnoreCase("inactive"));
    }

    public String getContractId() {
        return contractId;
    }

    public void setContractId(String contractId) {
        if (!isNumeric(contractId)) {
            throw new IllegalArgumentException("Contract ID must contain numbers only.");
        }
        this.contractId = contractId.trim();
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

    public String getPlayerType() {
        return playerType;
    }

    public void setPlayerType(String playerType) {
        if (!isValidPlayerType(playerType)) {
            throw new IllegalArgumentException("Player type must be Star or Regular.");
        }

        if (playerType.equalsIgnoreCase("star")) {
            this.playerType = "Star";
        } else {
            this.playerType = "Regular";
        }
    }

    public double getBaseSalary() {
        return baseSalary;
    }

    public void setBaseSalary(double baseSalary) {
        if (baseSalary < 0) {
            throw new IllegalArgumentException("Base salary cannot be negative.");
        }
        this.baseSalary = baseSalary;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        if (!isValidDateString(startDate)) {
            throw new IllegalArgumentException("Start date must use yyyy-MM-dd format and year must be from 2026 onwards.");
        }
        this.startDate = startDate.trim();
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        if (!isValidDateString(endDate)) {
            throw new IllegalArgumentException("End date must use yyyy-MM-dd format and year must be from 2026 onwards.");
        }

        if (startDate != null && !isEndDateAfterStartDate(startDate, endDate)) {
            throw new IllegalArgumentException("End date must be after start date.");
        }

        this.endDate = endDate.trim();
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        if (!isValidStatus(status)) {
            throw new IllegalArgumentException("Status must be active or inactive.");
        }
        this.status = status.trim().toLowerCase();
    }

    public void displayContractInfo() {
        System.out.println("Contract ID: " + contractId);
        System.out.println("Player ID: " + playerId);
        System.out.println("Player Type: " + playerType);
        System.out.println("Base Salary: " + baseSalary);
        System.out.println("Start Date: " + startDate);
        System.out.println("End Date: " + endDate);
        System.out.println("Status: " + status);
    }
}
