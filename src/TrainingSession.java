import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.format.ResolverStyle;
import java.util.Scanner;


public class TrainingSession {
    private String trainingId;
    private String trainingDate;
    private String trainingLocation;
    private String trainingTopic;

    private final DateTimeFormatter dateFormat =
            DateTimeFormatter.ofPattern("uuuu-MM-dd").withResolverStyle(ResolverStyle.STRICT);

    public TrainingSession() {
    }

    public TrainingSession(String trainingId, String trainingDate,
                           String trainingLocation, String trainingTopic) {
        if (trainingId != null && trainingId.matches("\\d+")) {
            this.trainingId = trainingId;
        }
        this.trainingDate = trainingDate;
        this.trainingLocation = trainingLocation;
        this.trainingTopic = trainingTopic;
    }

    public void input(Scanner sc) {
        System.out.println("\n===== ENTER TRAINING SESSION =====");
        trainingId = inputNumericId(sc, "Training ID: ");
        trainingDate = inputDate(sc, "Training Date (yyyy-MM-dd): ");
        trainingLocation = inputText(sc, "Training Location: ");
        trainingTopic = inputText(sc, "Training Topic: ");
    }

    public void update(Scanner sc) {
        System.out.println("\n===== UPDATE TRAINING SESSION =====");
        trainingDate = inputDate(sc, "New Training Date (yyyy-MM-dd): ");
        trainingLocation = inputText(sc, "New Training Location: ");
        trainingTopic = inputText(sc, "New Training Topic: ");
    }

    private String inputNumericId(Scanner sc, String label) {
        while (true) {
            System.out.print(label);
            String value = sc.nextLine().trim();
            if (value.matches("\\d+")) {
                return value;
            }
            System.out.println("ID must contain numbers only.");
        }
    }

    private String inputText(Scanner sc, String message) {
        while (true) {
            System.out.print(message);
            String value = sc.nextLine().trim();
            if (!value.isEmpty()) {
                return value;
            }
            System.out.println("This field cannot be empty.");
        }
    }

    private String inputDate(Scanner sc, String message) {
        while (true) {
            System.out.print(message);
            String value = sc.nextLine().trim();
            try {
                LocalDate date = LocalDate.parse(value, dateFormat);
                if (date.getYear() >= 2026) {
                    return value;
                }
                System.out.println("Year must be from 2026 onward.");
            } catch (DateTimeParseException e) {
                System.out.println("Invalid date. Example: 2026-05-20.");
            }
        }
    }

    public boolean isFitnessTraining() {
        return trainingTopic.equalsIgnoreCase("fitness")
                || trainingTopic.equalsIgnoreCase("physical training");
    }

    public String getTrainingId() {
        return trainingId;
    }

    public void setTrainingId(String trainingId) {
        if (trainingId != null && trainingId.matches("\\d+")) {
            this.trainingId = trainingId;
        }
    }

    public String getTrainingDate() {
        return trainingDate;
    }

    public void setTrainingDate(String trainingDate) {
        this.trainingDate = trainingDate;
    }

    public String getTrainingLocation() {
        return trainingLocation;
    }

    public void setTrainingLocation(String trainingLocation) {
        this.trainingLocation = trainingLocation;
    }

    public String getTrainingTopic() {
        return trainingTopic;
    }

    public void setTrainingTopic(String trainingTopic) {
        this.trainingTopic = trainingTopic;
    }

    public void displayInfo() {
        System.out.println("Training ID: " + trainingId);
        System.out.println("Training Date: " + trainingDate);
        System.out.println("Training Location: " + trainingLocation);
        System.out.println("Training Topic: " + trainingTopic);
    }

    public void show() {
        displayInfo();
    }
}
