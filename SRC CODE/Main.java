import java.util.Scanner;

public class Main {
    private Scanner scanner;
    private PlayerList playerList;
    private TrainingSessionList trainingSessionList;
    private MatchRecordList matchRecordList;
    private ContractList contractList;
    private SalaryList salaryList;

    public Main() {
        scanner = new Scanner(System.in);
        playerList = new PlayerList();
        trainingSessionList = new TrainingSessionList();
        matchRecordList = new MatchRecordList();
        contractList = new ContractList();
        salaryList = new SalaryList();
    }

    public static void main(String[] args) {
        Main program = new Main();
        program.runProgram();
    }

    public void runProgram() {
        int choice;

        do {
            showMainMenu();
            choice = inputChoice("Choose option: ", 1, 6);

            switch (choice) {
                case 1:
                    playerList.managePlayers(scanner);
                    break;
                case 2:
                    trainingSessionList.manageTrainingSessions(scanner);
                    break;
                case 3:
                    matchRecordList.manageMatchRecords(scanner);
                    break;
                case 4:
                    contractList.manageContracts(scanner, playerList);
                    break;
                case 5:
                    salaryList.manageSalaries(scanner, playerList);
                    break;
                
                case 6:
                    System.out.println("Program ended.");
                    break;
            }
        } while (choice != 7);

        scanner.close();
    }

    private void showMainMenu() {
        System.out.println("\n========== FOOTBALL PLAYER MANAGEMENT SYSTEM ==========");
        System.out.println("1. Manage Players");
        System.out.println("2. Manage Training Sessions");
        System.out.println("3. Manage Match Records");
        System.out.println("4. Manage Contracts");
        System.out.println("5. Manage Salaries");
        System.out.println("6. Exit");
    }

    private int inputChoice(String message, int min, int max) {
        while (true) {
            try {
                System.out.print(message);
                int number = Integer.parseInt(scanner.nextLine().trim());

                if (number >= min && number <= max) {
                    return number;
                }

                System.out.println("Please choose from " + min + " to " + max + ".");
            } catch (NumberFormatException e) {
                System.out.println("Invalid number. Please try again.");
            }
        }
    }
}
