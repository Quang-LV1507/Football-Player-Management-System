import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        PlayerList playerList = new PlayerList();
        TrainingSessionList trainingSessionList = new TrainingSessionList();
        MatchList matchList = new MatchList();
        ContractList contractList = new ContractList();
        SalaryList salaryList = new SalaryList();

        int choice;

        do {
            System.out.println("\n========== FOOTBALL PLAYER MANAGEMENT SYSTEM ==========");
            System.out.println("1. Player Management");
            System.out.println("2. Training Session Management");
            System.out.println("3. Match Management");
            System.out.println("4. Contract Management");
            System.out.println("5. Salary Management");
            System.out.println("6. Exit Program");
            choice = inputMenuChoice(sc, "Choose option: ");

            switch (choice) {
                case 1:
                    playerList.managePlayers(sc);
                    break;

                case 2:
                    trainingSessionList.manageTrainingSessions(sc);
                    break;

                case 3:
                    matchList.manageMatches(sc);
                    break;

                case 4:
                    contractList.manageContracts(sc, playerList);
                    break;

                case 5:
                    salaryList.manageSalaries(sc, playerList);
                    break;

                case 6:
                    System.out.println("Exit program.");
                    break;

                default:
                    System.out.println("Invalid option. Please choose again.");
                    break;
            }
        } while (choice != 6);

        sc.close();
    }

    private static int inputMenuChoice(Scanner sc, String message) {
        int choice = -1;
        boolean valid = false;

        do {
            try {
                System.out.print(message);
                choice = Integer.parseInt(sc.nextLine().trim());
                valid = true;
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number.");
            }
        } while (!valid);

        return choice;
    }
}
