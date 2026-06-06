import java.util.ArrayList;
import java.util.Scanner;

public class MatchList {
    private ArrayList<Match> matches;

    public MatchList() {
        matches = new ArrayList<>();
    }

    public void manageMatches(Scanner sc) {
        int choice;

        do {
            System.out.println("\n===== MATCH MANAGEMENT =====");
            System.out.println("1. Add match");
            System.out.println("2. Display all matches");
            System.out.println("3. Search match by ID");
            System.out.println("4. Update match");
            System.out.println("5. Delete match");
            System.out.println("6. Exit match management");
            choice = Player.inputMenuChoice(sc, "Choose option: ", 1, 6);

            switch (choice) {
                case 1:
                    Match match = new Match();
                    match.inputMatchInfo(sc);
                    addMatch(match);
                    break;

                case 2:
                    System.out.println("\n===== ALL MATCHES =====");
                    displayAllMatches();
                    break;

                case 3:
                    System.out.println("\n===== SEARCH MATCH =====");
                    String searchId = Player.inputNumericString(sc, "Enter Match ID to search: ", "Match ID");
                    displayMatchById(searchId);
                    break;

                case 4:
                    System.out.println("\n===== UPDATE MATCH =====");
                    String updateId = Player.inputNumericString(sc, "Enter Match ID to update: ", "Match ID");
                    updateMatch(updateId, sc);
                    break;

                case 5:
                    System.out.println("\n===== DELETE MATCH =====");
                    String deleteId = Player.inputNumericString(sc, "Enter Match ID to delete: ", "Match ID");
                    deleteMatch(deleteId);
                    break;

                case 6:
                    System.out.println("Exit match management.");
                    break;
            }
        } while (choice != 6);
    }

    public void addMatch(Match match) {
        if (searchMatchById(match.getMatchId()) != null) {
            System.out.println("Match ID already exists. Cannot add duplicate match.");
            return;
        }

        matches.add(match);
        System.out.println("Match added successfully.");
    }

    public Match searchMatchById(String matchId) {
        for (Match match : matches) {
            if (match.getMatchId().equalsIgnoreCase(matchId.trim())) {
                return match;
            }
        }
        return null;
    }

    public void displayMatchById(String matchId) {
        Match match = searchMatchById(matchId);

        if (match != null) {
            match.displayMatchInfo();
        } else {
            System.out.println("Match not found.");
        }
    }

    public void updateMatch(String matchId, Scanner sc) {
        Match match = searchMatchById(matchId);

        if (match != null) {
            match.updateMatchInfo(sc);
            System.out.println("Match updated successfully.");
        } else {
            System.out.println("Match not found.");
        }
    }

    public void deleteMatch(String matchId) {
        Match match = searchMatchById(matchId);

        if (match != null) {
            matches.remove(match);
            System.out.println("Match deleted successfully.");
        } else {
            System.out.println("Match not found.");
        }
    }

    public void displayAllMatches() {
        if (matches.isEmpty()) {
            System.out.println("No matches available.");
            return;
        }

        for (Match match : matches) {
            match.displayMatchInfo();
            System.out.println("-----------------------------");
        }
    }
}
