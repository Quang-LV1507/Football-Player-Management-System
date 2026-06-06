import java.time.LocalDate;
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
        validateEndDateAfterStartDate();
        setStatus(status);
    }

    public void inputContractInfo(Scanner sc, Player player) {
        System.out.println("\n===== ENTER CONTRACT INFORMATION =====");

        contractId = Player.inputNumericString(sc, "Contract ID: ", "Contract ID");
        playerId = player.getPlayerId();
        playerType = player.getPlayerType();
        baseSalary = player.getBaseSalary();
        status = player.getStatus();
        startDate = Player.inputDateString(sc, "Start Date (yyyy-MM-dd): ", "Start date");
        endDate = Player.inputEndDateAfterStartDate(sc, "End Date (yyyy-MM-dd): ", startDate);
    }

    public void updateContractInfo(Scanner sc, Player player) {
        System.out.println("\n===== UPDATE CONTRACT INFORMATION =====");

        playerType = player.getPlayerType();
        baseSalary = player.getBaseSalary();
        status = player.getStatus();
        startDate = Player.inputDateString(sc, "New Start Date (yyyy-MM-dd): ", "Start date");
        endDate = Player.inputEndDateAfterStartDate(sc, "New End Date (yyyy-MM-dd): ", startDate);
    }

    private void validateEndDateAfterStartDate() {
        LocalDate start = Player.parseDate(startDate);
        LocalDate end = Player.parseDate(endDate);

        if (start != null && end != null && !end.isAfter(start)) {
            throw new IllegalArgumentException("End date must be after start date.");
        }
    }

    public String getContractId() {
        return contractId;
    }

    public void setContractId(String contractId) {
        if (!Player.isNumeric(contractId)) {
            throw new IllegalArgumentException("Contract ID must contain numbers only.");
        }
        this.contractId = contractId.trim();
    }

    public String getPlayerId() {
        return playerId;
    }

    public void setPlayerId(String playerId) {
        if (!Player.isNumeric(playerId)) {
            throw new IllegalArgumentException("Player ID must contain numbers only.");
        }
        this.playerId = playerId.trim();
    }

    public String getPlayerType() {
        return playerType;
    }

    public void setPlayerType(String playerType) {
        if (!Player.isValidPlayerType(playerType)) {
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
        if (!Player.isValidDateString(startDate)) {
            throw new IllegalArgumentException("Start date must use yyyy-MM-dd format and year must be from 2026 onwards.");
        }
        this.startDate = startDate.trim();
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        if (!Player.isValidDateString(endDate)) {
            throw new IllegalArgumentException("End date must use yyyy-MM-dd format and year must be from 2026 onwards.");
        }
        this.endDate = endDate.trim();
        validateEndDateAfterStartDate();
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        if (!Player.isValidStatus(status)) {
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
