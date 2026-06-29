import java.util.ArrayList;
import java.util.Scanner;


public class TrainingSessionList {
    private ArrayList<TrainingSession> sessions;

    public TrainingSessionList() {
        sessions = new ArrayList<>();
    }

    public void manageTrainingSessions(Scanner sc) {
        int choice;
        do {
            System.out.println("\n===== TRAINING SESSION MANAGEMENT =====");
            System.out.println("1. Add training session");
            System.out.println("2. Display all training sessions");
            System.out.println("3. Search training session by ID");
            System.out.println("4. Update training session");
            System.out.println("5. Delete training session");
            System.out.println("6. Back to main menu");
            choice = menu(sc);

            if (choice == 1) {
                add(sc);
            } else if (choice == 2) {
                display();
            } else if (choice == 3) {
                search(sc);
            } else if (choice == 4) {
                update(sc);
            } else if (choice == 5) {
                delete(sc);
            } else {
                System.out.println("Back to main menu.");
            }
        } while (choice != 6);
    }

    private void add(Scanner sc) {
        TrainingSession session = new TrainingSession();
        session.input(sc);

        if (findIndex(session.getTrainingId()) != -1) {
            System.out.println("Training ID already exists.");
            return;
        }

        sessions.add(session);
        System.out.println("Training session added successfully.");
    }

    private void display() {
        if (sessions.isEmpty()) {
            System.out.println("No training session data available.");
            return;
        }

        for (int i = 0; i < sessions.size(); i++) {
            System.out.println("\n--- Training Session " + (i + 1) + " ---");
            sessions.get(i).show();
        }
    }

    private void search(Scanner sc) {
        System.out.print("Enter Training ID to search: ");
        String id = sc.nextLine().trim();
        int index = findIndex(id);

        if (index == -1) {
            System.out.println("Training session not found.");
        } else {
            sessions.get(index).show();
        }
    }

    private void update(Scanner sc) {
        System.out.print("Enter Training ID to update: ");
        String id = sc.nextLine().trim();
        int index = findIndex(id);

        if (index == -1) {
            System.out.println("Training session not found.");
        } else {
            sessions.get(index).update(sc);
            System.out.println("Training session updated successfully.");
        }
    }

    private void delete(Scanner sc) {
        System.out.print("Enter Training ID to delete: ");
        String id = sc.nextLine().trim();
        int index = findIndex(id);

        if (index == -1) {
            System.out.println("Training session not found.");
        } else {
            sessions.remove(index);
            System.out.println("Training session deleted successfully.");
        }
    }

    private int findIndex(String id) {
        for (int i = 0; i < sessions.size(); i++) {
            if (sessions.get(i).getTrainingId().equals(id)) {
                return i;
            }
        }
        return -1;
    }

    private int menu(Scanner sc) {
        while (true) {
            try {
                System.out.print("Choose option: ");
                int choice = Integer.parseInt(sc.nextLine().trim());
                if (choice >= 1 && choice <= 6) {
                    return choice;
                }
            } catch (NumberFormatException e) {
                // The message below handles invalid input.
            }
            System.out.println("Please enter a number from 1 to 6.");
        }
    }
}
