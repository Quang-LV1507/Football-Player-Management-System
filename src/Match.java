import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class Match {
    private String matchId;
    private String matchDate;
    private String opponentTeam;
    private String matchType;

    public Match() {
    }

    public Match(String matchId, String matchDate, String opponentTeam, String matchType) {
        setMatchId(matchId);
        setMatchDate(matchDate);
        setOpponentTeam(opponentTeam);
        setMatchType(matchType);
    }

    public void inputMatchInfo(Scanner sc) {
        System.out.println("\n===== ENTER MATCH INFORMATION =====");

        matchId = inputNumericString(sc, "Match ID: ");
        matchDate = inputDateString(sc, "Match Date (yyyy-MM-dd): ");
        opponentTeam = inputNotEmptyString(sc, "Opponent Team: ");
        matchType = inputNotEmptyString(sc, "Match Type: ");
    }

    public void updateMatchInfo(Scanner sc) {
        System.out.println("\n===== UPDATE MATCH INFORMATION =====");

        matchDate = inputDateString(sc, "New Match Date (yyyy-MM-dd): ");
        opponentTeam = inputNotEmptyString(sc, "New Opponent Team: ");
        matchType = inputNotEmptyString(sc, "New Match Type: ");
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

    private String inputNotEmptyString(Scanner sc, String message) {
        String value;
        do {
            System.out.print(message);
            value = sc.nextLine().trim();

            if (value.isEmpty()) {
                System.out.println("Invalid input. This field cannot be empty.");
            }
        } while (value.isEmpty());

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

    public String getMatchId() {
        return matchId;
    }

    public void setMatchId(String matchId) {
        if (!isNumeric(matchId)) {
            throw new IllegalArgumentException("Match ID must contain numbers only.");
        }
        this.matchId = matchId.trim();
    }

    public String getMatchDate() {
        return matchDate;
    }

    public void setMatchDate(String matchDate) {
        if (!isValidDateString(matchDate)) {
            throw new IllegalArgumentException("Match date must use yyyy-MM-dd format and year must be from 2026 onwards.");
        }
        this.matchDate = matchDate.trim();
    }

    public String getOpponentTeam() {
        return opponentTeam;
    }

    public void setOpponentTeam(String opponentTeam) {
        if (opponentTeam == null || opponentTeam.trim().isEmpty()) {
            throw new IllegalArgumentException("Opponent team cannot be empty.");
        }
        this.opponentTeam = opponentTeam.trim();
    }

    public String getMatchType() {
        return matchType;
    }

    public void setMatchType(String matchType) {
        if (matchType == null || matchType.trim().isEmpty()) {
            throw new IllegalArgumentException("Match type cannot be empty.");
        }
        this.matchType = matchType.trim();
    }

    public void displayMatchInfo() {
        System.out.println("Match ID: " + matchId);
        System.out.println("Match Date: " + matchDate);
        System.out.println("Opponent Team: " + opponentTeam);
        System.out.println("Match Type: " + matchType);
    }
}
