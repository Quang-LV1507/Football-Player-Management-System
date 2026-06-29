import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.format.ResolverStyle;
import java.util.Scanner;


public class MatchRecord {
    private String matchId;
    private String matchDate;
    private String opponentTeam;
    private String matchType;

    private final DateTimeFormatter matchDateFormat =
            DateTimeFormatter.ofPattern("uuuu-MM-dd").withResolverStyle(ResolverStyle.STRICT);

    public MatchRecord() {
    }

    public MatchRecord(String matchId, String matchDate, String opponentTeam, String matchType) {
        if (matchId != null && matchId.matches("\\d+")) {
            this.matchId = matchId;
        }
        this.matchDate = matchDate;
        this.opponentTeam = opponentTeam;
        this.matchType = matchType;
    }

    public void inputMatchRecordInfo(Scanner sc) {
        System.out.println("\n===== ENTER MATCH RECORD =====");
        matchId = inputNumericId(sc, "Match ID: ");
        matchDate = inputMatchDate(sc, "Match Date (yyyy-MM-dd): ");
        opponentTeam = inputRequiredValue(sc, "Opponent Team: ");
        matchType = inputRequiredValue(sc, "Match Type: ");
    }

    public void editMatchRecordInfo(Scanner sc) {
        System.out.println("\n===== UPDATE MATCH RECORD =====");
        matchDate = inputMatchDate(sc, "New Match Date (yyyy-MM-dd): ");
        opponentTeam = inputRequiredValue(sc, "New Opponent Team: ");
        matchType = inputRequiredValue(sc, "New Match Type: ");
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

    private String inputRequiredValue(Scanner sc, String label) {
        String value;
        do {
            System.out.print(label);
            value = sc.nextLine().trim();
            if (value.isEmpty()) {
                System.out.println("This field cannot be empty.");
            }
        } while (value.isEmpty());
        return value;
    }

    private String inputMatchDate(Scanner sc, String label) {
        while (true) {
            System.out.print(label);
            String value = sc.nextLine().trim();
            try {
                LocalDate date = LocalDate.parse(value, matchDateFormat);
                if (date.getYear() >= 2026) {
                    return value;
                }
                System.out.println("Year must be from 2026 onward.");
            } catch (DateTimeParseException e) {
                System.out.println("Invalid date. Example: 2026-09-01.");
            }
        }
    }

    public boolean isCompetitiveMatch() {
        return matchType.equalsIgnoreCase("league")
                || matchType.equalsIgnoreCase("cup")
                || matchType.equalsIgnoreCase("tournament");
    }

    public String getMatchId() {
        return matchId;
    }

    public void setMatchId(String matchId) {
        if (matchId != null && matchId.matches("\\d+")) {
            this.matchId = matchId;
        }
    }

    public String getMatchDate() {
        return matchDate;
    }

    public void setMatchDate(String matchDate) {
        this.matchDate = matchDate;
    }

    public String getOpponentTeam() {
        return opponentTeam;
    }

    public void setOpponentTeam(String opponentTeam) {
        this.opponentTeam = opponentTeam;
    }

    public String getMatchType() {
        return matchType;
    }

    public void setMatchType(String matchType) {
        this.matchType = matchType;
    }

    public void displayInfo() {
        System.out.println("Match ID: " + matchId);
        System.out.println("Match Date: " + matchDate);
        System.out.println("Opponent Team: " + opponentTeam);
        System.out.println("Match Type: " + matchType);
    }

    public void printMatchRecord() {
        displayInfo();
    }
}
