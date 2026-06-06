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

        matchId = Player.inputNumericString(sc, "Match ID: ", "Match ID");
        matchDate = Player.inputDateString(sc, "Match Date (yyyy-MM-dd): ", "Match date");
        opponentTeam = Player.inputNotEmptyString(sc, "Opponent Team: ", "Opponent Team");
        matchType = Player.inputNotEmptyString(sc, "Match Type: ", "Match Type");
    }

    public void updateMatchInfo(Scanner sc) {
        System.out.println("\n===== UPDATE MATCH INFORMATION =====");

        matchDate = Player.inputDateString(sc, "New Match Date (yyyy-MM-dd): ", "Match date");
        opponentTeam = Player.inputNotEmptyString(sc, "New Opponent Team: ", "Opponent Team");
        matchType = Player.inputNotEmptyString(sc, "New Match Type: ", "Match Type");
    }

    public String getMatchId() {
        return matchId;
    }

    public void setMatchId(String matchId) {
        if (!Player.isNumeric(matchId)) {
            throw new IllegalArgumentException("Match ID must contain numbers only.");
        }
        this.matchId = matchId.trim();
    }

    public String getMatchDate() {
        return matchDate;
    }

    public void setMatchDate(String matchDate) {
        if (!Player.isValidDateString(matchDate)) {
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
