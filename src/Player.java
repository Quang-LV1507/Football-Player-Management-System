import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;


public abstract class Player {
    private String playerId;
    private String fullName;
    private int age;
    private String nationality;
    private String position;
    private int shirtNumber;
    private double baseSalary;
    private String status;

    private final Set<String> countryCodes = new HashSet<>(Arrays.asList(
            "AFG", "ALB", "DZA", "AND", "AGO", "ATG", "ARG", "ARM", "AUS", "AUT",
            "AZE", "BHS", "BHR", "BGD", "BRB", "BLR", "BEL", "BLZ", "BEN", "BTN",
            "BOL", "BIH", "BWA", "BRA", "BRN", "BGR", "BFA", "BDI", "CPV", "KHM",
            "CMR", "CAN", "CAF", "TCD", "CHL", "CHN", "COL", "COM", "COG", "CRI",
            "CIV", "HRV", "CUB", "CYP", "CZE", "COD", "DNK", "DJI", "DMA", "DOM",
            "ECU", "EGY", "SLV", "GNQ", "ERI", "EST", "SWZ", "ETH", "FJI", "FIN",
            "FRA", "GAB", "GMB", "GEO", "DEU", "GHA", "GRC", "GRD", "GTM", "GIN",
            "GNB", "GUY", "HTI", "HND", "HUN", "ISL", "IND", "IDN", "IRN", "IRQ",
            "IRL", "ISR", "ITA", "JAM", "JPN", "JOR", "KAZ", "KEN", "KIR", "KWT",
            "KGZ", "LAO", "LVA", "LBN", "LSO", "LBR", "LBY", "LIE", "LTU", "LUX",
            "MDG", "MWI", "MYS", "MDV", "MLI", "MLT", "MHL", "MRT", "MUS", "MEX",
            "FSM", "MDA", "MCO", "MNG", "MNE", "MAR", "MOZ", "MMR", "NAM", "NRU",
            "NPL", "NLD", "NZL", "NIC", "NER", "NGA", "PRK", "MKD", "NOR", "OMN",
            "PAK", "PLW", "PSE", "PAN", "PNG", "PRY", "PER", "PHL", "POL", "PRT",
            "QAT", "ROU", "RUS", "RWA", "KNA", "LCA", "VCT", "WSM", "SMR", "STP",
            "SAU", "SEN", "SRB", "SYC", "SLE", "SGP", "SVK", "SVN", "SLB", "SOM",
            "ZAF", "KOR", "SSD", "ESP", "LKA", "SDN", "SUR", "SWE", "CHE", "SYR",
            "TJK", "TZA", "THA", "TLS", "TGO", "TON", "TTO", "TUN", "TUR", "TKM",
            "TUV", "UGA", "UKR", "ARE", "GBR", "USA", "URY", "UZB", "VUT", "VAT",
            "VEN", "VNM", "YEM", "ZMB", "ZWE"
    ));

    public Player() {
    }

    public Player(String playerId, String fullName, int age, String nationality,
                  String position, int shirtNumber, double baseSalary, String status) {
        if (playerId != null && playerId.matches("\\d+")) {
            this.playerId = playerId;
        }
        if (fullName != null && !fullName.trim().isEmpty()) {
            this.fullName = fullName.trim();
        }
        if (age > 0) {
            this.age = age;
        }
        if (nationality != null && countryCodes.contains(nationality.toUpperCase())) {
            this.nationality = nationality.toUpperCase();
        }
        if (position != null && !position.trim().isEmpty()) {
            this.position = position.trim();
        }
        if (shirtNumber > 0) {
            this.shirtNumber = shirtNumber;
        }
        if (baseSalary >= 0) {
            this.baseSalary = baseSalary;
        }
        if (status != null && (status.equalsIgnoreCase("active")
                || status.equalsIgnoreCase("inactive"))) {
            this.status = status.toLowerCase();
        }
    }

    public abstract String getPlayerType();

    public abstract double calculateMonthlySalary();

    public abstract void displayInfo();

    public void inputPlayerInfo(Scanner sc) {
        System.out.println("\n===== ENTER PLAYER INFORMATION =====");
        playerId = inputNumericId(sc, "Player ID: ");
        fullName = readRequiredText(sc, "Full Name: ");
        age = readPositiveInteger(sc, "Age: ");
        nationality = readNationalityCode(sc, "Nationality code, example VNM, USA: ");
        position = readRequiredText(sc, "Position: ");
        shirtNumber = readPositiveInteger(sc, "Shirt Number: ");
        baseSalary = readNonNegativeDouble(sc, "Base Salary: ");
        status = readStatus(sc, "Status (active/inactive): ");
    }

    public void updatePlayerInfo(Scanner sc) {
        System.out.println("\n===== UPDATE PLAYER INFORMATION =====");
        fullName = readRequiredText(sc, "New Full Name: ");
        age = readPositiveInteger(sc, "New Age: ");
        nationality = readNationalityCode(sc, "New Nationality code: ");
        position = readRequiredText(sc, "New Position: ");
        shirtNumber = readPositiveInteger(sc, "New Shirt Number: ");
        baseSalary = readNonNegativeDouble(sc, "New Base Salary: ");
        status = readStatus(sc, "New Status (active/inactive): ");
    }

    protected void displayCommonPlayerInfo() {
        System.out.println("Player ID: " + playerId);
        System.out.println("Full Name: " + fullName);
        System.out.println("Age: " + age);
        System.out.println("Nationality: " + nationality);
        System.out.println("Position: " + position);
        System.out.println("Shirt Number: " + shirtNumber);
        System.out.println("Base Salary: " + baseSalary);
        System.out.println("Status: " + status);
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

    private String readRequiredText(Scanner sc, String label) {
        while (true) {
            System.out.print(label);
            String value = sc.nextLine().trim();
            if (!value.isEmpty()) {
                return value;
            }
            System.out.println("This field cannot be empty.");
        }
    }

    private int readPositiveInteger(Scanner sc, String label) {
        while (true) {
            try {
                System.out.print(label);
                int value = Integer.parseInt(sc.nextLine().trim());
                if (value > 0) {
                    return value;
                }
                System.out.println("Value must be greater than 0.");
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid integer.");
            }
        }
    }

    private double readNonNegativeDouble(Scanner sc, String label) {
        while (true) {
            try {
                System.out.print(label);
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

    private String readNationalityCode(Scanner sc, String label) {
        while (true) {
            System.out.print(label);
            String value = sc.nextLine().trim().toUpperCase();
            if (countryCodes.contains(value)) {
                return value;
            }
            System.out.println("Invalid country code. Use 3-letter country codes such as VNM, USA, JPN.");
        }
    }

    private String readStatus(Scanner sc, String label) {
        while (true) {
            System.out.print(label);
            String value = sc.nextLine().trim().toLowerCase();
            if (value.equals("active") || value.equals("inactive")) {
                return value;
            }
            System.out.println("Status must be active or inactive.");
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

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        if (fullName != null && !fullName.trim().isEmpty()) {
            this.fullName = fullName.trim();
        }
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if (age > 0) {
            this.age = age;
        }
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        if (nationality != null && countryCodes.contains(nationality.toUpperCase())) {
            this.nationality = nationality.toUpperCase();
        }
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        if (position != null && !position.trim().isEmpty()) {
            this.position = position.trim();
        }
    }

    public int getShirtNumber() {
        return shirtNumber;
    }

    public void setShirtNumber(int shirtNumber) {
        if (shirtNumber > 0) {
            this.shirtNumber = shirtNumber;
        }
    }

    public double getBaseSalary() {
        return baseSalary;
    }

    public void setBaseSalary(double baseSalary) {
        if (baseSalary >= 0) {
            this.baseSalary = baseSalary;
        }
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        if (status != null && (status.equalsIgnoreCase("active") || status.equalsIgnoreCase("inactive"))) {
            this.status = status.toLowerCase();
        }
    }
}
