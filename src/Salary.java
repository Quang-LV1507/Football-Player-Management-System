/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Windows
 */
public class Salary {
    private String playerId;
    private int month;
    private int year;
    private double baseSalary;
    private double performanceBonus;
    private double totalSalary;

    public Salary(String playerId, int month, int year,
                  double baseSalary, double performanceBonus) {
        this.playerId = playerId;
        this.month = month;
        this.year = year;
        this.baseSalary = baseSalary;
        this.performanceBonus = performanceBonus;
        this.totalSalary = baseSalary + performanceBonus;
    }

    public String getPlayerId() {
        return playerId;
    }

    public int getMonth() {
        return month;
    }

    public int getYear() {
        return year;
    }

    public double getBaseSalary() {
        return baseSalary;
    }

    public double getPerformanceBonus() {
        return performanceBonus;
    }

    public void setPerformanceBonus(double performanceBonus) {
        this.performanceBonus = performanceBonus;
        this.totalSalary = baseSalary + performanceBonus;
    }

    public double getTotalSalary() {
        return totalSalary;
    }

    public void displaySalaryInfo() {
        System.out.println("Player ID: " + playerId);
        System.out.println("Month/Year: " + month + "/" + year);
        System.out.println("Base Salary: " + baseSalary);
        System.out.println("Performance Bonus: " + performanceBonus);
        System.out.println("Total Salary: " + totalSalary);
    }
}