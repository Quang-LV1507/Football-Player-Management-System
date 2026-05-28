/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Windows
 */
public class Contract {
    private String contractId;
    private String playerId;
    private String playerType;
    private double baseSalary;
    private String startDate;
    private String endDate;
    private String status;

    public Contract(String contractId, String playerId, String playerType,
                    double baseSalary, String startDate, String endDate, String status) {
        this.contractId = contractId;
        this.playerId = playerId;
        this.playerType = playerType;
        this.baseSalary = baseSalary;
        this.startDate = startDate;
        this.endDate = endDate;
        this.status = status;
    }

    public String getContractId() {
        return contractId;
    }

    public String getPlayerId() {
        return playerId;
    }

    public String getPlayerType() {
        return playerType;
    }

    public void setPlayerType(String playerType) {
        this.playerType = playerType;
    }

    public double getBaseSalary() {
        return baseSalary;
    }

    public void setBaseSalary(double baseSalary) {
        this.baseSalary = baseSalary;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public boolean validateContract() {
        return baseSalary > 0 && status != null && !status.isEmpty();
    }

    public void displayContractInfo() {
        System.out.println("Contract ID: " + contractId);
        System.out.println("Player ID: " + playerId);
        System.out.println("Player Type: " + playerType);
        System.out.println("Base Salary: " + baseSalary);
        System.out.println("Start Date: " + startDate);
        System.out.println("End Date: " + endDate);
        System.out.println("Status: " + status);
    }
}
