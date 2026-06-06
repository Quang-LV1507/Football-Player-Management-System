import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.format.ResolverStyle;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Player {
    private String playerId;
    private String fullName;
    private int age;
    private String nationality;
    private String position;
    private int shirtNumber;
    private double baseSalary;
    private String playerType;
    private String status;

    private static final int MIN_YEAR = 2026;

    private static final Set<String> VALID_COUNTRY_CODES = new HashSet<>(Arrays.asList(
            "AFG", "ALB", "DZA", "AND", "AGO", "ATG", "ARG", "ARM", "AUS", "AUT",
            "AZE", "BHS", "BHR", "BGD", "BRB", "BLR", "BEL", "BLZ", "BEN", "BTN",
            "BOL", "BIH", "BWA", "BRA", "BRN", "BGR", "BFA", "BDI", "CPV", "KHM",
            "CMR", "CAN", "CAF", "TCD", "CHL", "CHN", "COL", "COM", "COG", "COD",
            "CRI", "CIV", "HRV", "CUB", "CYP", "CZE", "DNK", "DJI", "DMA", "DOM",
            "ECU", "EGY", "SLV", "GNQ", "ERI", "EST", "SWZ", "ETH", "FJI", "FIN",
            "FRA", "GAB", "GMB", "GEO", "DEU", "GHA", "GRC", "GRD", "GTM", "GIN",
            "GNB", "GUY", "HTI", "HND", "HUN", "ISL", "IND", "IDN", "IRN", "IRQ",
            "IRL", "ISR", "ITA", "JAM", "JPN", "JOR", "KAZ", "KEN", "KIR", "KWT",
            "KGZ", "LAO", "LVA", "LBN", "LSO", "LBR", "LBY", "LIE", "LTU", "LUX",
            "MDG", "MWI", "MYS", "MDV", "MLI", "MLT", "MHL", "MRT", "MUS", "MEX",
            "FSM", "MDA", "MCO", "MNG", "MNE", "MAR", "MOZ", "MMR", "NAM", "NRU",
            "NPL", "NLD", "NZL", "NIC", "NER", "NGA", "PRK", "MKD", "NOR", "OMN",
            "PAK", "PLW", "PAN", "PNG", "PRY", "PER", "PHL", "POL", "PRT", "QAT",
            "ROU", "RUS", "RWA", "KNA", "LCA", "VCT", "WSM", "SMR", "STP", "SAU",
            "SEN", "SRB", "SYC", "SLE", "SGP", "SVK", "SVN", "SLB", "SOM", "ZAF",
            "KOR", "SSD", "ESP", "LKA", "SDN", "SUR", "SWE", "CHE", "SYR", "TJK",
            "TZA", "THA", "TLS", "TGO", "TON", "TTO", "TUN", "TUR", "TKM", "TUV",
            "UGA", "UKR", "ARE", "GBR", "USA", "URY", "UZB", "VUT", "VAT", "VEN",
            "VNM", "YEM", "ZMB", "ZWE", "PSE"
    ));

    public Player() {
    }

    public Player(String playerId, String fullName, int age, String nationality,
                  String position, int shirtNumber, double baseSalary,
                  String playerType, String status) {
        setPlayerId(playerId);
        setFullName(fullName);
        setAge(age);
        setNationality(nationality);
        setPosition(position);
        setShirtNumber(shirtNumber);
        setBaseSalary(baseSalary);
        setPlayerType(playerType);
        setStatus(status);
    }

    public void inputPlayerInfo(Scanner sc) {
        System.out.println("\n===== ENTER PLAYER INFORMATION =====");

        playerId = inputNumericString(sc, "Player ID: ", "Player ID");
        fullName = inputNotEmptyString(sc, "Full Name: ", "Full Name");
        age = inputPositiveInt(sc, "Age: ", "Age");
        nationality = inputNationality(sc, "Nationality code (3 letters, example VNM, USA): ");
        position = inputNotEmptyString(sc, "Position: ", "Position");
        shirtNumber = inputPositiveInt(sc, "Shirt Number: ", "Shirt Number");
        baseSalary = inputNonNegativeDouble(sc, "Base Salary: ", "Base Salary");
        playerType = inputPlayerType(sc, "Player Type (Star/Regular): ");
        status = inputStatus(sc, "Status (active/inactive): ");
    }

    public void updatePlayerInfo(Scanner sc) {
        System.out.println("\n===== UPDATE PLAYER INFORMATION =====");

        fullName = inputNotEmptyString(sc, "New Full Name: ", "Full Name");
        age = inputPositiveInt(sc, "New Age: ", "Age");
        nationality = inputNationality(sc, "New Nationality code (3 letters, example VNM, USA): ");
        position = inputNotEmptyString(sc, "New Position: ", "Position");
        shirtNumber = inputPositiveInt(sc, "New Shirt Number: ", "Shirt Number");
        baseSalary = inputNonNegativeDouble(sc, "New Base Salary: ", "Base Salary");
        playerType = inputPlayerType(sc, "New Player Type (Star/Regular): ");
        status = inputStatus(sc, "New Status (active/inactive): ");
    }

    public static String inputNumericString(Scanner sc, String message, String fieldName) {
        String value;
        do {
            System.out.print(message);
            value = sc.nextLine().trim();

            if (!isNumeric(value)) {
                System.out.println(fieldName + " must contain numbers only.");
            }
        } while (!isNumeric(value));

        return value;
    }

    public static String inputNotEmptyString(Scanner sc, String message, String fieldName) {
        String value;
        do {
            System.out.print(message);
            value = sc.nextLine().trim();

            if (value.isEmpty()) {
                System.out.println(fieldName + " cannot be empty.");
            }
        } while (value.isEmpty());

        return value;
    }

    public static int inputPositiveInt(Scanner sc, String message, String fieldName) {
        int number = 0;
        boolean valid;

        do {
            try {
                System.out.print(message);
                number = Integer.parseInt(sc.nextLine().trim());
                valid = number > 0;

                if (!valid) {
                    System.out.println(fieldName + " must be greater than 0.");
                }
            } catch (NumberFormatException e) {
                System.out.println(fieldName + " must be an integer number.");
                valid = false;
            }
        } while (!valid);

        return number;
    }

    public static int inputIntInRange(Scanner sc, String message, String fieldName, int min, int max) {
        int number = 0;
        boolean valid;

        do {
            try {
                System.out.print(message);
                number = Integer.parseInt(sc.nextLine().trim());
                valid = number >= min && number <= max;

                if (!valid) {
                    System.out.println(fieldName + " must be from " + min + " to " + max + ".");
                }
            } catch (NumberFormatException e) {
                System.out.println(fieldName + " must be an integer number.");
                valid = false;
            }
        } while (!valid);

        return number;
    }

    public static int inputYearFrom2026(Scanner sc, String message) {
        int year = 0;
        boolean valid;

        do {
            try {
                System.out.print(message);
                year = Integer.parseInt(sc.nextLine().trim());
                valid = year >= MIN_YEAR;

                if (!valid) {
                    System.out.println("Year must be from " + MIN_YEAR + " onwards.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Year must be an integer number.");
                valid = false;
            }
        } while (!valid);

        return year;
    }

    public static int inputMenuChoice(Scanner sc, String message, int min, int max) {
        return inputIntInRange(sc, message, "Option", min, max);
    }

    public static double inputNonNegativeDouble(Scanner sc, String message, String fieldName) {
        double number = 0;
        boolean valid;

        do {
            try {
                System.out.print(message);
                number = Double.parseDouble(sc.nextLine().trim());
                valid = number >= 0;

                if (!valid) {
                    System.out.println(fieldName + " cannot be negative.");
                }
            } catch (NumberFormatException e) {
                System.out.println(fieldName + " must be a number.");
                valid = false;
            }
        } while (!valid);

        return number;
    }

    public static String inputDateString(Scanner sc, String message, String fieldName) {
        String value;
        do {
            System.out.print(message);
            value = sc.nextLine().trim();

            if (!isValidDateString(value)) {
                System.out.println(fieldName + " must use yyyy-MM-dd format and year must be from " + MIN_YEAR + " onwards.");
            }
        } while (!isValidDateString(value));

        return value;
    }

    public static String inputEndDateAfterStartDate(Scanner sc, String message, String startDate) {
        String endDate;
        LocalDate start = parseDate(startDate);
        LocalDate end;
        boolean valid;

        do {
            endDate = inputDateString(sc, message, "End date");
            end = parseDate(endDate);
            valid = start != null && end != null && end.isAfter(start);

            if (!valid) {
                System.out.println("End date must be after start date.");
            }
        } while (!valid);

        return endDate;
    }

    public static String inputNationality(Scanner sc, String message) {
        String value;
        do {
            System.out.print(message);
            value = sc.nextLine().trim().toUpperCase();

            if (!isValidNationality(value)) {
                System.out.println("Nationality must be a valid 3-letter country code, example: VNM, USA, JPN.");
            }
        } while (!isValidNationality(value));

        return value;
    }

    public static String inputPlayerType(Scanner sc, String message) {
        String value;
        do {
            System.out.print(message);
            value = sc.nextLine().trim();

            if (!isValidPlayerType(value)) {
                System.out.println("Player type must be Star or Regular.");
            }
        } while (!isValidPlayerType(value));

        if (value.equalsIgnoreCase("star")) {
            return "Star";
        }
        return "Regular";
    }

    public static String inputStatus(Scanner sc, String message) {
        String value;
        do {
            System.out.print(message);
            value = sc.nextLine().trim().toLowerCase();

            if (!isValidStatus(value)) {
                System.out.println("Status must be active or inactive.");
            }
        } while (!isValidStatus(value));

        return value;
    }

    public static boolean isNumeric(String value) {
        return value != null && value.trim().matches("\\d+");
    }

    public static boolean isValidNationality(String nationality) {
        return nationality != null && VALID_COUNTRY_CODES.contains(nationality.trim().toUpperCase());
    }

    public static boolean isValidPlayerType(String playerType) {
        return playerType != null
                && (playerType.trim().equalsIgnoreCase("Star")
                || playerType.trim().equalsIgnoreCase("Regular"));
    }

    public static boolean isValidStatus(String status) {
        return status != null
                && (status.trim().equalsIgnoreCase("active")
                || status.trim().equalsIgnoreCase("inactive"));
    }

    public static boolean isValidDateString(String date) {
        LocalDate localDate = parseDate(date);
        return localDate != null && localDate.getYear() >= MIN_YEAR;
    }

    public static LocalDate parseDate(String date) {
        try {
            DateTimeFormatter formatter = DateTimeFormatter
                    .ofPattern("uuuu-MM-dd")
                    .withResolverStyle(ResolverStyle.STRICT);
            return LocalDate.parse(date.trim(), formatter);
        } catch (DateTimeParseException | NullPointerException e) {
            return null;
        }
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

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        if (fullName == null || fullName.trim().isEmpty()) {
            throw new IllegalArgumentException("Full name cannot be empty.");
        }
        this.fullName = fullName.trim();
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if (age <= 0) {
            throw new IllegalArgumentException("Age must be greater than 0.");
        }
        this.age = age;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        if (!isValidNationality(nationality)) {
            throw new IllegalArgumentException("Nationality must be a valid 3-letter country code.");
        }
        this.nationality = nationality.trim().toUpperCase();
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        if (position == null || position.trim().isEmpty()) {
            throw new IllegalArgumentException("Position cannot be empty.");
        }
        this.position = position.trim();
    }

    public int getShirtNumber() {
        return shirtNumber;
    }

    public void setShirtNumber(int shirtNumber) {
        if (shirtNumber <= 0) {
            throw new IllegalArgumentException("Shirt number must be greater than 0.");
        }
        this.shirtNumber = shirtNumber;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        if (!isValidStatus(status)) {
            throw new IllegalArgumentException("Status must be active or inactive.");
        }
        this.status = status.trim().toLowerCase();
    }

    public void displayPlayerInfo() {
        System.out.println("Player ID: " + playerId);
        System.out.println("Full Name: " + fullName);
        System.out.println("Age: " + age);
        System.out.println("Nationality: " + nationality);
        System.out.println("Position: " + position);
        System.out.println("Shirt Number: " + shirtNumber);
        System.out.println("Base Salary: " + baseSalary);
        System.out.println("Player Type: " + playerType);
        System.out.println("Status: " + status);
    }
}
