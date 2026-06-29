public class StarPlayer extends Player {
    private static final double STAR_BONUS_RATE = 0.20;

    public StarPlayer() {
        super();
    }

    public StarPlayer(String playerId, String fullName, int age, String nationality,
                      String position, int shirtNumber, double baseSalary, String status) {
        super(playerId, fullName, age, nationality, position, shirtNumber, baseSalary, status);
    }

    @Override
    public String getPlayerType() {
        return "Star";
    }

    @Override
    public double calculateMonthlySalary() {
        return getBaseSalary() * (1 + STAR_BONUS_RATE);
    }

    @Override
    public void displayInfo() {
        displayCommonPlayerInfo();
        System.out.println("Player Type: " + getPlayerType());
        System.out.println("Star Bonus Rate: 20%");
        System.out.println("Calculated Monthly Salary: " + calculateMonthlySalary());
        System.out.println("Benefit: Priority training and promotion activities.");
    }

    public void displayPlayerInfo() {
        displayInfo();
    }
}
