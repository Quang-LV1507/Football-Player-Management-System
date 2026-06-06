import java.util.Scanner;

public class TrainingSession {
    private String trainingId;
    private String trainingDate;
    private String trainingLocation;
    private String trainingTopic;

    public TrainingSession() {
    }

    public TrainingSession(String trainingId, String trainingDate,
                           String trainingLocation, String trainingTopic) {
        setTrainingId(trainingId);
        setTrainingDate(trainingDate);
        setTrainingLocation(trainingLocation);
        setTrainingTopic(trainingTopic);
    }

    public void inputTrainingSessionInfo(Scanner sc) {
        System.out.println("\n===== ENTER TRAINING SESSION INFORMATION =====");

        trainingId = Player.inputNumericString(sc, "Training ID: ", "Training ID");
        trainingDate = Player.inputDateString(sc, "Training Date (yyyy-MM-dd): ", "Training date");
        trainingLocation = Player.inputNotEmptyString(sc, "Training Location: ", "Training Location");
        trainingTopic = Player.inputNotEmptyString(sc, "Training Topic: ", "Training Topic");
    }

    public void updateTrainingSessionInfo(Scanner sc) {
        System.out.println("\n===== UPDATE TRAINING SESSION INFORMATION =====");

        trainingDate = Player.inputDateString(sc, "New Training Date (yyyy-MM-dd): ", "Training date");
        trainingLocation = Player.inputNotEmptyString(sc, "New Training Location: ", "Training Location");
        trainingTopic = Player.inputNotEmptyString(sc, "New Training Topic: ", "Training Topic");
    }

    public String getTrainingId() {
        return trainingId;
    }

    public void setTrainingId(String trainingId) {
        if (!Player.isNumeric(trainingId)) {
            throw new IllegalArgumentException("Training ID must contain numbers only.");
        }
        this.trainingId = trainingId.trim();
    }

    public String getTrainingDate() {
        return trainingDate;
    }

    public void setTrainingDate(String trainingDate) {
        if (!Player.isValidDateString(trainingDate)) {
            throw new IllegalArgumentException("Training date must use yyyy-MM-dd format and year must be from 2026 onwards.");
        }
        this.trainingDate = trainingDate.trim();
    }

    public String getTrainingLocation() {
        return trainingLocation;
    }

    public void setTrainingLocation(String trainingLocation) {
        if (trainingLocation == null || trainingLocation.trim().isEmpty()) {
            throw new IllegalArgumentException("Training location cannot be empty.");
        }
        this.trainingLocation = trainingLocation.trim();
    }

    public String getTrainingTopic() {
        return trainingTopic;
    }

    public void setTrainingTopic(String trainingTopic) {
        if (trainingTopic == null || trainingTopic.trim().isEmpty()) {
            throw new IllegalArgumentException("Training topic cannot be empty.");
        }
        this.trainingTopic = trainingTopic.trim();
    }

    public void displayTrainingSessionInfo() {
        System.out.println("Training ID: " + trainingId);
        System.out.println("Training Date: " + trainingDate);
        System.out.println("Training Location: " + trainingLocation);
        System.out.println("Training Topic: " + trainingTopic);
    }
}
