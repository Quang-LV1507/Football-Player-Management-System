public class RegularPlayer extends Player {
    private static final double REGULAR_BONUS_RATE = 0.05;

    public RegularPlayer() {
        super();
    }

    public RegularPlayer(String playerId, String fullName, int age, String nationality,
                         String position, int shirtNumber, double baseSalary, String status) {
        super(playerId, fullName, age, nationality, position, shirtNumber, baseSalary, status);
    }

    @Override
    public String getPlayerType() {
        return "Regular";
    }

    @Override
    public double calculateMonthlySalary() {
        return getBaseSalary() * (1 + REGULAR_BONUS_RATE);
    }

    @Override
    public void displayInfo() {
        displayCommonPlayerInfo();
        System.out.println("Player Type: " + getPlayerType());
        System.out.println("Regular Bonus Rate: 5%");
        System.out.println("Calculated Monthly Salary: " + calculateMonthlySalary());
        System.out.println("Benefit: Standard team training program.");
    }

    public void displayPlayerInfo() {
        displayInfo();
    }
}
