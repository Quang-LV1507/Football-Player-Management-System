import java.util.ArrayList;
import java.util.Scanner;


public class MatchRecordList {
    private ArrayList<MatchRecord> matchRecords;

    public MatchRecordList() {
        matchRecords = new ArrayList<>();
    }

    public void manageMatchRecords(Scanner sc) {
        while (true) {
            System.out.println("\n===== MATCH RECORD MANAGEMENT =====");
            System.out.println("1. Add match record");
            System.out.println("2. Display all match records");
            System.out.println("3. Search match record by ID");
            System.out.println("4. Update match record");
            System.out.println("5. Delete match record");
            System.out.println("6. Back to main menu");

            int option = readOption(sc);
            switch (option) {
                case 1:
                    addMatchRecord(sc);
                    break;
                case 2:
                    displayMatchRecords();
                    break;
                case 3:
                    searchMatchRecord(sc);
                    break;
                case 4:
                    updateMatchRecord(sc);
                    break;
                case 5:
                    deleteMatchRecord(sc);
                    break;
                case 6:
                    System.out.println("Back to main menu.");
                    return;
            }
        }
    }

    private void addMatchRecord(Scanner sc) {
        MatchRecord record = new MatchRecord();
        record.inputMatchRecordInfo(sc);

        if (getMatchRecord(record.getMatchId()) != null) {
            System.out.println("Match ID already exists.");
            return;
        }

        matchRecords.add(record);
        System.out.println("Match record added successfully.");
    }

    private void displayMatchRecords() {
        if (matchRecords.isEmpty()) {
            System.out.println("No match record data available.");
            return;
        }

        int count = 1;
        for (MatchRecord record : matchRecords) {
            System.out.println("\n--- Match Record " + count + " ---");
            record.printMatchRecord();
            count++;
        }
    }

    private void searchMatchRecord(Scanner sc) {
        System.out.print("Enter Match ID to search: ");
        String id = sc.nextLine().trim();
        MatchRecord record = getMatchRecord(id);

        if (record == null) {
            System.out.println("Match record not found.");
        } else {
            record.printMatchRecord();
        }
    }

    private void updateMatchRecord(Scanner sc) {
        System.out.print("Enter Match ID to update: ");
        String id = sc.nextLine().trim();
        MatchRecord record = getMatchRecord(id);

        if (record == null) {
            System.out.println("Match record not found.");
            return;
        }

        record.editMatchRecordInfo(sc);
        System.out.println("Match record updated successfully.");
    }

    private void deleteMatchRecord(Scanner sc) {
        System.out.print("Enter Match ID to delete: ");
        String id = sc.nextLine().trim();
        MatchRecord record = getMatchRecord(id);

        if (record == null) {
            System.out.println("Match record not found.");
        } else {
            matchRecords.remove(record);
            System.out.println("Match record deleted successfully.");
        }
    }

    private MatchRecord getMatchRecord(String id) {
        for (MatchRecord record : matchRecords) {
            if (record.getMatchId().equals(id)) {
                return record;
            }
        }
        return null;
    }

    private int readOption(Scanner sc) {
        while (true) {
            try {
                System.out.print("Choose option: ");
                int option = Integer.parseInt(sc.nextLine().trim());
                if (option >= 1 && option <= 6) {
                    return option;
                }
            } catch (NumberFormatException e) {
                // handled by message below
            }
            System.out.println("Please enter a number from 1 to 6.");
        }
    }
}
