import java.util.ArrayList;
import java.util.Scanner;

public class PlayerList {
    private ArrayList<Player> players;

    public PlayerList() {
        players = new ArrayList<>();
    }

    public void managePlayers(Scanner sc) {
        int choice;

        do {
            System.out.println("\n===== PLAYER MANAGEMENT =====");
            System.out.println("1. Add player");
            System.out.println("2. Display all players");
            System.out.println("3. Search player by ID");
            System.out.println("4. Update player");
            System.out.println("5. Delete player");
            System.out.println("6. Exit player management");
            choice = Player.inputMenuChoice(sc, "Choose option: ", 1, 6);

            switch (choice) {
                case 1:
                    Player player = new Player();
                    player.inputPlayerInfo(sc);
                    addPlayer(player);
                    break;

                case 2:
                    System.out.println("\n===== ALL PLAYERS =====");
                    displayAllPlayers();
                    break;

                case 3:
                    System.out.println("\n===== SEARCH PLAYER =====");
                    String searchId = Player.inputNumericString(sc, "Enter Player ID to search: ", "Player ID");
                    displayPlayerById(searchId);
                    break;

                case 4:
                    System.out.println("\n===== UPDATE PLAYER =====");
                    String updateId = Player.inputNumericString(sc, "Enter Player ID to update: ", "Player ID");
                    updatePlayer(updateId, sc);
                    break;

                case 5:
                    System.out.println("\n===== DELETE PLAYER =====");
                    String deleteId = Player.inputNumericString(sc, "Enter Player ID to delete: ", "Player ID");
                    deletePlayer(deleteId);
                    break;

                case 6:
                    System.out.println("Exit player management.");
                    break;
            }
        } while (choice != 6);
    }

    public void addPlayer(Player player) {
        if (searchPlayerById(player.getPlayerId()) != null) {
            System.out.println("Player ID already exists. Cannot add duplicate player.");
            return;
        }

        players.add(player);
        System.out.println("Player added successfully.");
    }

    public Player searchPlayerById(String playerId) {
        for (Player player : players) {
            if (player.getPlayerId().equalsIgnoreCase(playerId.trim())) {
                return player;
            }
        }
        return null;
    }

    public void displayPlayerById(String playerId) {
        Player player = searchPlayerById(playerId);

        if (player != null) {
            player.displayPlayerInfo();
        } else {
            System.out.println("Player not found.");
        }
    }

    public void updatePlayer(String playerId, Scanner sc) {
        Player player = searchPlayerById(playerId);

        if (player != null) {
            player.updatePlayerInfo(sc);
            System.out.println("Player updated successfully.");
        } else {
            System.out.println("Player not found.");
        }
    }

    public void deletePlayer(String playerId) {
        Player player = searchPlayerById(playerId);

        if (player != null) {
            players.remove(player);
            System.out.println("Player deleted successfully.");
        } else {
            System.out.println("Player not found.");
        }
    }

    public void displayAllPlayers() {
        if (players.isEmpty()) {
            System.out.println("No players available.");
            return;
        }

        for (Player player : players) {
            player.displayPlayerInfo();
            System.out.println("-----------------------------");
        }
    }
}
