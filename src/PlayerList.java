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
            printPlayerMenu();
            choice = readMenuChoice(sc);

            switch (choice) {
                case 1:
                    addPlayer(sc);
                    break;
                case 2:
                    displayAllPlayers();
                    break;
                case 3:
                    searchPlayer(sc);
                    break;
                case 4:
                    updatePlayer(sc);
                    break;
                case 5:
                    deletePlayer(sc);
                    break;
                case 6:
                    System.out.println("Back to main menu.");
                    break;
            }
        } while (choice != 6);
    }

    private void printPlayerMenu() {
        System.out.println("\n===== PLAYER MANAGEMENT =====");
        System.out.println("1. Add player");
        System.out.println("2. Display all players");
        System.out.println("3. Search player by ID");
        System.out.println("4. Update player");
        System.out.println("5. Delete player");
        System.out.println("6. Back to main menu");
    }

    private void addPlayer(Scanner sc) {
        Player player = createPlayerByType(sc);
        player.inputPlayerInfo(sc);

        if (findPlayerById(player.getPlayerId()) != null) {
            System.out.println("Player ID already exists.");
            return;
        }

        players.add(player);
        System.out.println(player.getPlayerType() + " player added successfully.");
    }

    private Player createPlayerByType(Scanner sc) {
        while (true) {
            System.out.print("Player Type (Star/Regular): ");
            String playerType = sc.nextLine().trim();

            if (playerType.equalsIgnoreCase("Star")) {
                return new StarPlayer();
            }
            if (playerType.equalsIgnoreCase("Regular")) {
                return new RegularPlayer();
            }
            System.out.println("Player type must be Star or Regular.");
        }
    }

    private void displayAllPlayers() {
        if (players.isEmpty()) {
            System.out.println("No player data available.");
            return;
        }

        for (int i = 0; i < players.size(); i++) {
            System.out.println("\n--- Player " + (i + 1) + " ---");
            Player player = players.get(i);
            player.displayInfo();
        }
    }

    private void searchPlayer(Scanner sc) {
        System.out.print("Enter Player ID to search: ");
        String id = sc.nextLine().trim();

        Player player = findPlayerById(id);
        if (player == null) {
            System.out.println("Player not found.");
        } else {
            player.displayInfo();
        }
    }

    private void updatePlayer(Scanner sc) {
        System.out.print("Enter Player ID to update: ");
        String id = sc.nextLine().trim();

        Player player = findPlayerById(id);
        if (player == null) {
            System.out.println("Player not found.");
            return;
        }

        player.updatePlayerInfo(sc);
        System.out.println("Player updated successfully.");
    }

    private void deletePlayer(Scanner sc) {
        System.out.print("Enter Player ID to delete: ");
        String id = sc.nextLine().trim();

        Player player = findPlayerById(id);
        if (player == null) {
            System.out.println("Player not found.");
        } else {
            players.remove(player);
            System.out.println("Player deleted successfully.");
        }
    }

    public Player findPlayerById(String id) {
        for (Player player : players) {
            if (player.getPlayerId().equals(id)) {
                return player;
            }
        }
        return null;
    }

    private int readMenuChoice(Scanner sc) {
        while (true) {
            try {
                System.out.print("Choose option: ");
                int choice = Integer.parseInt(sc.nextLine().trim());
                if (choice >= 1 && choice <= 6) {
                    return choice;
                }
                System.out.println("Please choose from 1 to 6.");
            } catch (NumberFormatException e) {
                System.out.println("Invalid number. Please try again.");
            }
        }
    }
}
