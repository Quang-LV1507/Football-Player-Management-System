import java.util.Scanner;

public class TrainingSession {

    // khai bao fields
    private String trainingId;
    private String trainingDate;
    private String trainingLocation;
    private String trainingTopic;

    // constructor rong
    public TrainingSession() {
    }

    // constructor co tham so
    public TrainingSession(String trainingId, String trainingDate,
                           String trainingLocation, String trainingTopic) {
        this.trainingId = trainingId;
        this.trainingDate = trainingDate;
        this.trainingLocation = trainingLocation;
        this.trainingTopic = trainingTopic;
    }

    // getter va setter
    public String getTrainingId() {
        return trainingId;
    }

    public void setTrainingId(String trainingId) {
        this.trainingId = trainingId;
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

    // ham nhap thong tin training
    public void inputTrainingSession() {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Training ID: ");
        trainingId = sc.nextLine();

        System.out.print("Enter Training Date: ");
        trainingDate = sc.nextLine();

        System.out.print("Enter Training Location: ");
        trainingLocation = sc.nextLine();

        System.out.print("Enter Training Topic: ");
        trainingTopic = sc.nextLine();
    }

    // ham xuat thong tin training
    public void outputTrainingSession() {
        System.out.printf("%-15s %-20s %-25s %-25s\n",
                trainingId, trainingDate, trainingLocation, trainingTopic);
    }

    // ham nay de khop voi Main.java cua minh
    public void displayTrainingSession() {
        System.out.println("Training ID: " + trainingId);
        System.out.println("Training Date: " + trainingDate);
        System.out.println("Training Location: " + trainingLocation);
        System.out.println("Training Topic: " + trainingTopic);
    }
}