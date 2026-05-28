/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Windows
 */
public class Player {
    private String playerId;
    private String fullName;
    private int age;
    private String nationality;
    private String position;
    private int shirtNumber;
    private double baseSalary;
    private String playerType;
    private String status;

    public Player(String playerId, String fullName, int age, String nationality,
                  String position, int shirtNumber, double baseSalary,
                  String playerType, String status) {
        this.playerId = playerId;
        this.fullName = fullName;
        this.age = age;
        this.nationality = nationality;
        this.position = position;
        this.shirtNumber = shirtNumber;
        this.baseSalary = baseSalary;
        this.playerType = playerType;
        this.status = status;
    }

    public String getPlayerId() {
        return playerId;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public int getShirtNumber() {
        return shirtNumber;
    }

    public void setShirtNumber(int shirtNumber) {
        this.shirtNumber = shirtNumber;
    }

    public double getBaseSalary() {
        return baseSalary;
    }

    public void setBaseSalary(double baseSalary) {
        this.baseSalary = baseSalary;
    }

    public String getPlayerType() {
        return playerType;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void displayPlayerInfo() {
        System.out.println("Player ID: " + playerId);
        System.out.println("Full Name: " + fullName);
        System.out.println("Age: " + age);
        System.out.println("Nationality: " + nationality);
        System.out.println("Position: " + position);
        System.out.println("Shirt Number: " + shirtNumber);
        System.out.println("Base Salary: " + baseSalary);
        System.out.println("Player Type: " + playerType);
        System.out.println("Status: " + status);
    }
}