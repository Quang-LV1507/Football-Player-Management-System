import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.format.ResolverStyle;
import java.util.Scanner;

public class Contract extends ClubRecord {
    private String playerId;
    private String startDate;
    private String endDate;
    private String contractStatus;

    private final DateTimeFormatter contractDateFormat =
            DateTimeFormatter.ofPattern("uuuu-MM-dd").withResolverStyle(ResolverStyle.STRICT);

    public Contract() {
        super();
    }

    public Contract(String contractId, String playerId, String startDate, String endDate, String contractStatus) {
        super(contractId);
        this.playerId = playerId;
        this.startDate = startDate;
        this.endDate = endDate;
        this.contractStatus = contractStatus;
    }

    public void inputContractInformation(Scanner sc) {
        System.out.println("\n===== ENTER CONTRACT INFORMATION =====");
        setId(inputNumericId(sc, "Contract ID: "));
        playerId = inputNumericId(sc, "Player ID: ");
        startDate = enterContractDate(sc, "Start Date (yyyy-MM-dd): ");
        endDate = enterEndDate(sc, "End Date (yyyy-MM-dd): ", startDate);
        contractStatus = enterContractStatus(sc, "Contract Status (active/inactive): ");
    }

    public void updateContractInformation(Scanner sc) {
        System.out.println("\n===== UPDATE CONTRACT INFORMATION =====");
        startDate = enterContractDate(sc, "New Start Date (yyyy-MM-dd): ");
        endDate = enterEndDate(sc, "New End Date (yyyy-MM-dd): ", startDate);
        contractStatus = enterContractStatus(sc, "New Contract Status (active/inactive): ");
    }

    private String enterContractStatus(Scanner sc, String label) {
        while (true) {
            System.out.print(label);
            String input = sc.nextLine().trim().toLowerCase();
            if (input.equals("active") || input.equals("inactive")) {
                return input;
            }
            System.out.println("Status must be active or inactive.");
        }
    }

    private String enterContractDate(Scanner sc, String label) {
        while (true) {
            System.out.print(label);
            String input = sc.nextLine().trim();
            try {
                LocalDate date = LocalDate.parse(input, contractDateFormat);
                if (date.getYear() >= 2026) {
                    return input;
                }
                System.out.println("Contract year must be from 2026 onward.");
            } catch (DateTimeParseException e) {
                System.out.println("Invalid date. Example: 2026-01-01.");
            }
        }
    }

    private String enterEndDate(Scanner sc, String label, String currentStartDate) {
        while (true) {
            String input = enterContractDate(sc, label);
            LocalDate start = LocalDate.parse(currentStartDate, contractDateFormat);
            LocalDate end = LocalDate.parse(input, contractDateFormat);
            if (end.isAfter(start)) {
                return input;
            }
            System.out.println("End date must be after start date.");
        }
    }

    public boolean isActiveOn(String dateText) {
        LocalDate date = LocalDate.parse(dateText, contractDateFormat);
        LocalDate start = LocalDate.parse(startDate, contractDateFormat);
        LocalDate end = LocalDate.parse(endDate, contractDateFormat);
        return contractStatus.equals("active") && !date.isBefore(start) && !date.isAfter(end);
    }

    public String getContractId() {
        return getId();
    }

    public String getPlayerId() {
        return playerId;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getContractStatus() {
        return contractStatus;
    }

    public void setContractStatus(String contractStatus) {
        this.contractStatus = contractStatus;
    }

    @Override
    public String getEntityType() {
        return "Contract";
    }

    @Override
    public void displayInfo() {
        System.out.println("Contract ID: " + getId());
        System.out.println("Player ID: " + playerId);
        System.out.println("Start Date: " + startDate);
        System.out.println("End Date: " + endDate);
        System.out.println("Contract Status: " + contractStatus);
    }

    public void displayContractInformation() {
        displayInfo();
    }
}
