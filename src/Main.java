/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */

/**
 *
 * @author Windows
 */
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input Player
        System.out.println("===== ENTER PLAYER INFORMATION =====");

        System.out.print("Player ID: ");
        String playerId = sc.nextLine();

        System.out.print("Full Name: ");
        String fullName = sc.nextLine();

        System.out.print("Age: ");
        int age = Integer.parseInt(sc.nextLine());

        System.out.print("Nationality: ");
        String nationality = sc.nextLine();

        System.out.print("Position: ");
        String position = sc.nextLine();

        System.out.print("Shirt Number: ");
        int shirtNumber = Integer.parseInt(sc.nextLine());

        System.out.print("Base Salary: ");
        double baseSalary = Double.parseDouble(sc.nextLine());

        System.out.print("Player Type: ");
        String playerType = sc.nextLine();

        System.out.print("Status: ");
        String status = sc.nextLine();

        Player player = new Player(
                playerId, fullName, age, nationality,
                position, shirtNumber, baseSalary,
                playerType, status
        );

        // Input Training Session
        System.out.println("\n===== ENTER TRAINING SESSION =====");

        System.out.print("Training ID: ");
        String trainingId = sc.nextLine();

        System.out.print("Training Date: ");
        String trainingDate = sc.nextLine();

        System.out.print("Training Location: ");
        String trainingLocation = sc.nextLine();

        System.out.print("Training Topic: ");
        String trainingTopic = sc.nextLine();

        TrainingSession training = new TrainingSession(
                trainingId,
                trainingDate,
                trainingLocation,
                trainingTopic
        );

        // Input Match
        System.out.println("\n===== ENTER MATCH INFORMATION =====");

        System.out.print("Match ID: ");
        String matchId = sc.nextLine();

        System.out.print("Match Date: ");
        String matchDate = sc.nextLine();

        System.out.print("Opponent Team: ");
        String opponentTeam = sc.nextLine();

        System.out.print("Match Type: ");
        String matchType = sc.nextLine();

        Match match = new Match(
                matchId,
                matchDate,
                opponentTeam,
                matchType
        );

        // Input Contract
        System.out.println("\n===== ENTER CONTRACT INFORMATION =====");

        System.out.print("Contract ID: ");
        String contractId = sc.nextLine();

        System.out.print("Start Date: ");
        String startDate = sc.nextLine();

        System.out.print("End Date: ");
        String endDate = sc.nextLine();

        Contract contract = new Contract(
                contractId,
                player.getPlayerId(),
                player.getPlayerType(),
                player.getBaseSalary(),
                startDate,
                endDate,
                player.getStatus()
        );

        // Input Salary
        System.out.println("\n===== ENTER SALARY INFORMATION =====");

        System.out.print("Month: ");
        int month = Integer.parseInt(sc.nextLine());

        System.out.print("Year: ");
        int year = Integer.parseInt(sc.nextLine());

        System.out.print("Performance Bonus: ");
        double performanceBonus = Double.parseDouble(sc.nextLine());

        Salary salary = new Salary(
                player.getPlayerId(),
                month,
                year,
                player.getBaseSalary(),
                performanceBonus
        );

        // Output
        System.out.println("\n========== OUTPUT ==========");

        System.out.println("\n===== PLAYER =====");
        player.displayPlayerInfo();

        System.out.println("\n===== TRAINING SESSION =====");
        training.displayTrainingSession();

        System.out.println("\n===== MATCH =====");
        match.displayMatchInfo();

        System.out.println("\n===== CONTRACT =====");
        contract.displayContractInfo();

        System.out.println("\n===== SALARY =====");
        salary.displaySalaryInfo();

        sc.close();
    }
}
