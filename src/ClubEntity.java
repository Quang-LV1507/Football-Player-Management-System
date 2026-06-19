import java.util.Scanner;

/*
 * Top-level abstract class.
 * Every main object in the football club system has an ID and can display itself.
 */
public abstract class ClubEntity {
    private String id;

    protected ClubEntity() {
    }

    protected ClubEntity(String id) {
        setId(id);
    }

    public String getId() {
        return id;
    }

    protected void setId(String id) {
        if (id != null && id.matches("\\d+")) {
            this.id = id;
        }
    }

    protected String inputNumericId(Scanner sc, String label) {
        while (true) {
            System.out.print(label);
            String value = sc.nextLine().trim();
            if (value.matches("\\d+")) {
                return value;
            }
            System.out.println("ID must contain numbers only.");
        }
    }

    public abstract String getEntityType();

    public abstract void displayInfo();
}
