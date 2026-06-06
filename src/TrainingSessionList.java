import java.util.ArrayList;
import java.util.Scanner;

public class TrainingSessionList {
    private ArrayList<TrainingSession> trainingSessions;

    public TrainingSessionList() {
        trainingSessions = new ArrayList<>();
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
            System.out.println("6. Exit training session management");
            choice = Player.inputMenuChoice(sc, "Choose option: ", 1, 6);

            switch (choice) {
                case 1:
                    TrainingSession training = new TrainingSession();
                    training.inputTrainingSessionInfo(sc);
                    addTrainingSession(training);
                    break;

                case 2:
                    System.out.println("\n===== ALL TRAINING SESSIONS =====");
                    displayAllTrainingSessions();
                    break;

                case 3:
                    System.out.println("\n===== SEARCH TRAINING SESSION =====");
                    String searchId = Player.inputNumericString(sc, "Enter Training ID to search: ", "Training ID");
                    displayTrainingSessionById(searchId);
                    break;

                case 4:
                    System.out.println("\n===== UPDATE TRAINING SESSION =====");
                    String updateId = Player.inputNumericString(sc, "Enter Training ID to update: ", "Training ID");
                    updateTrainingSession(updateId, sc);
                    break;

                case 5:
                    System.out.println("\n===== DELETE TRAINING SESSION =====");
                    String deleteId = Player.inputNumericString(sc, "Enter Training ID to delete: ", "Training ID");
                    deleteTrainingSession(deleteId);
                    break;

                case 6:
                    System.out.println("Exit training session management.");
                    break;
            }
        } while (choice != 6);
    }

    public void addTrainingSession(TrainingSession trainingSession) {
        if (searchTrainingSessionById(trainingSession.getTrainingId()) != null) {
            System.out.println("Training ID already exists. Cannot add duplicate training session.");
            return;
        }

        trainingSessions.add(trainingSession);
        System.out.println("Training session added successfully.");
    }

    public TrainingSession searchTrainingSessionById(String trainingId) {
        for (TrainingSession trainingSession : trainingSessions) {
            if (trainingSession.getTrainingId().equalsIgnoreCase(trainingId.trim())) {
                return trainingSession;
            }
        }
        return null;
    }

    public void displayTrainingSessionById(String trainingId) {
        TrainingSession trainingSession = searchTrainingSessionById(trainingId);

        if (trainingSession != null) {
            trainingSession.displayTrainingSessionInfo();
        } else {
            System.out.println("Training session not found.");
        }
    }

    public void updateTrainingSession(String trainingId, Scanner sc) {
        TrainingSession trainingSession = searchTrainingSessionById(trainingId);

        if (trainingSession != null) {
            trainingSession.updateTrainingSessionInfo(sc);
            System.out.println("Training session updated successfully.");
        } else {
            System.out.println("Training session not found.");
        }
    }

    public void deleteTrainingSession(String trainingId) {
        TrainingSession trainingSession = searchTrainingSessionById(trainingId);

        if (trainingSession != null) {
            trainingSessions.remove(trainingSession);
            System.out.println("Training session deleted successfully.");
        } else {
            System.out.println("Training session not found.");
        }
    }

    public void displayAllTrainingSessions() {
        if (trainingSessions.isEmpty()) {
            System.out.println("No training sessions available.");
            return;
        }

        for (TrainingSession trainingSession : trainingSessions) {
            trainingSession.displayTrainingSessionInfo();
            System.out.println("-----------------------------");
        }
    }
}
