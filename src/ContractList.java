import java.util.ArrayList;
import java.util.Scanner;

public class ContractList {
    private ArrayList<Contract> contracts;

    public ContractList() {
        contracts = new ArrayList<>();
    }

    public void manageContracts(Scanner sc, PlayerList playerList) {
        int choice;

        do {
            System.out.println("\n===== CONTRACT MANAGEMENT =====");
            System.out.println("1. Add contract");
            System.out.println("2. Display all contracts");
            System.out.println("3. Search contract by ID");
            System.out.println("4. Update contract");
            System.out.println("5. Delete contract");
            System.out.println("6. Exit contract management");
            choice = inputMenuChoice(sc, "Choose option: ");

            switch (choice) {
                case 1:
                    addContractByPlayer(sc, playerList);
                    break;

                case 2:
                    System.out.println("\n===== ALL CONTRACTS =====");
                    displayAllContracts();
                    break;

                case 3:
                    System.out.println("\n===== SEARCH CONTRACT =====");
                    String searchId = inputNumericString(sc, "Enter Contract ID to search: ");
                    displayContractById(searchId);
                    break;

                case 4:
                    System.out.println("\n===== UPDATE CONTRACT =====");
                    String updateId = inputNumericString(sc, "Enter Contract ID to update: ");
                    updateContract(updateId, sc);
                    break;

                case 5:
                    System.out.println("\n===== DELETE CONTRACT =====");
                    String deleteId = inputNumericString(sc, "Enter Contract ID to delete: ");
                    deleteContract(deleteId);
                    break;

                case 6:
                    System.out.println("Exit contract management.");
                    break;

                default:
                    System.out.println("Invalid option. Please choose again.");
                    break;
            }
        } while (choice != 6);
    }

    private int inputMenuChoice(Scanner sc, String message) {
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

    private String inputNumericString(Scanner sc, String message) {
        String value;
        do {
            System.out.print(message);
            value = sc.nextLine().trim();

            if (!value.matches("\\d+")) {
                System.out.println("Invalid input. ID must contain numbers only.");
            }
        } while (!value.matches("\\d+"));

        return value;
    }

    private void addContractByPlayer(Scanner sc, PlayerList playerList) {
        System.out.println("\n===== ADD CONTRACT =====");
        String playerId = inputNumericString(sc, "Enter Player ID for this contract: ");

        Player player = playerList.searchPlayerById(playerId);

        if (player == null) {
            System.out.println("Player not found. Please add player first.");
            return;
        }

        Contract contract = new Contract();
        contract.inputContractInfo(sc, player);

        if (searchContractById(contract.getContractId()) != null) {
            System.out.println("Contract ID already exists. Cannot add duplicate contract.");
            return;
        }

        contracts.add(contract);
        System.out.println("Contract added successfully.");
    }

    public Contract searchContractById(String contractId) {
        for (Contract contract : contracts) {
            if (contract.getContractId().equalsIgnoreCase(contractId.trim())) {
                return contract;
            }
        }
        return null;
    }

    public void displayContractById(String contractId) {
        Contract contract = searchContractById(contractId);

        if (contract != null) {
            contract.displayContractInfo();
        } else {
            System.out.println("Contract not found.");
        }
    }

    public void updateContract(String contractId, Scanner sc) {
        Contract contract = searchContractById(contractId);

        if (contract != null) {
            contract.updateContractInfo(sc);
            System.out.println("Contract updated successfully.");
        } else {
            System.out.println("Contract not found.");
        }
    }

    public void deleteContract(String contractId) {
        Contract contract = searchContractById(contractId);

        if (contract != null) {
            contracts.remove(contract);
            System.out.println("Contract deleted successfully.");
        } else {
            System.out.println("Contract not found.");
        }
    }

    public void displayAllContracts() {
        if (contracts.isEmpty()) {
            System.out.println("No contracts available.");
            return;
        }

        for (Contract contract : contracts) {
            contract.displayContractInfo();
            System.out.println("-----------------------------");
        }
    }
}
