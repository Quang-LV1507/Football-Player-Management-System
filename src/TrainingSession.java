import java.time.LocalDate;
import java.time.format.DateTimeParseException;
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

        trainingId = inputNumericString(sc, "Training ID: ");
        trainingDate = inputDateString(sc, "Training Date (yyyy-MM-dd): ");
        trainingLocation = inputNotEmptyString(sc, "Training Location: ");
        trainingTopic = inputNotEmptyString(sc, "Training Topic: ");
    }

    public void updateTrainingSessionInfo(Scanner sc) {
        System.out.println("\n===== UPDATE TRAINING SESSION INFORMATION =====");

        trainingDate = inputDateString(sc, "New Training Date (yyyy-MM-dd): ");
        trainingLocation = inputNotEmptyString(sc, "New Training Location: ");
        trainingTopic = inputNotEmptyString(sc, "New Training Topic: ");
    }

    private String inputNumericString(Scanner sc, String message) {
        String value;
        do {
            System.out.print(message);
            value = sc.nextLine().trim();

            if (!isNumeric(value)) {
                System.out.println("Invalid input. ID must contain numbers only.");
            }
        } while (!isNumeric(value));

        return value;
    }

    private String inputNotEmptyString(Scanner sc, String message) {
        String value;
        do {
            System.out.print(message);
            value = sc.nextLine().trim();

            if (value.isEmpty()) {
                System.out.println("Invalid input. This field cannot be empty.");
            }
        } while (value.isEmpty());

        return value;
    }

    private String inputDateString(Scanner sc, String message) {
        String value;
        do {
            System.out.print(message);
            value = sc.nextLine().trim();

            if (!isValidDateString(value)) {
                System.out.println("Invalid date. Use yyyy-MM-dd, real date, and year must be from 2026 onwards.");
            }
        } while (!isValidDateString(value));

        return value;
    }

    private boolean isNumeric(String value) {
        return value != null && value.matches("\\d+");
    }

    private boolean isValidDateString(String date) {
        if (date == null || !date.matches("\\d{4}-\\d{2}-\\d{2}")) {
            return false;
        }

        try {
            LocalDate parsedDate = LocalDate.parse(date);
            return parsedDate.getYear() >= 2026;
        } catch (DateTimeParseException e) {
            return false;
        }
    }

    public String getTrainingId() {
        return trainingId;
    }

    public void setTrainingId(String trainingId) {
        if (!isNumeric(trainingId)) {
            throw new IllegalArgumentException("Training ID must contain numbers only.");
        }
        this.trainingId = trainingId.trim();
    }

    public String getTrainingDate() {
        return trainingDate;
    }

    public void setTrainingDate(String trainingDate) {
        if (!isValidDateString(trainingDate)) {
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
