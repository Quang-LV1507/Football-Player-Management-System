import java.util.ArrayList;

public class TrainingSessionList {

    private ArrayList<TrainingSession> trainingList = new ArrayList<>();

    // Add
    public void addTrainingSession(TrainingSession training) {
        trainingList.add(training);
        System.out.println("Training session added successfully.");
    }

    // Display all
    public void displayAllTrainingSessions() {
        if (trainingList.isEmpty()) {
            System.out.println("No training sessions available.");
        } else {
            for (TrainingSession training : trainingList) {
                training.displayTrainingSession();
                System.out.println("-------------------------");
            }
        }
    }

    // Search by ID
    public TrainingSession searchTrainingSessionById(String trainingId) {
        for (TrainingSession training : trainingList) {
            if (training.getTrainingId().equalsIgnoreCase(trainingId)) {
                return training;
            }
        }
        return null;
    }

    // Display search result
    public void displayTrainingSessionById(String trainingId) {
        TrainingSession training = searchTrainingSessionById(trainingId);

        if (training != null) {
            training.displayTrainingSession();
        } else {
            System.out.println("Training session not found.");
        }
    }

    // Update
    public void updateTrainingSession(String trainingId, String newDate, String newLocation, String newTopic) {
        TrainingSession training = searchTrainingSessionById(trainingId);

        if (training != null) {
            training.setTrainingDate(newDate);
            training.setTrainingLocation(newLocation);
            training.setTrainingTopic(newTopic);
            System.out.println("Training session updated successfully.");
        } else {
            System.out.println("Training session not found.");
        }
    }

    // Delete
    public void deleteTrainingSession(String trainingId) {
        TrainingSession training = searchTrainingSessionById(trainingId);

        if (training != null) {
            trainingList.remove(training);
            System.out.println("Training session deleted successfully.");
        } else {
            System.out.println("Training session not found.");
        }
    }
}