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
            choice = Player.inputMenuChoice(sc, "Choose option: ", 1, 6);

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
                    String searchId = Player.inputNumericString(sc, "Enter Contract ID to search: ", "Contract ID");
                    displayContractById(searchId);
                    break;

                case 4:
                    System.out.println("\n===== UPDATE CONTRACT =====");
                    String updateId = Player.inputNumericString(sc, "Enter Contract ID to update: ", "Contract ID");
                    updateContract(updateId, sc, playerList);
                    break;

                case 5:
                    System.out.println("\n===== DELETE CONTRACT =====");
                    String deleteId = Player.inputNumericString(sc, "Enter Contract ID to delete: ", "Contract ID");
                    deleteContract(deleteId);
                    break;

                case 6:
                    System.out.println("Exit contract management.");
                    break;
            }
        } while (choice != 6);
    }

    private void addContractByPlayer(Scanner sc, PlayerList playerList) {
        System.out.println("\n===== ADD CONTRACT =====");
        String playerId = Player.inputNumericString(sc, "Enter Player ID for this contract: ", "Player ID");

        Player player = playerList.searchPlayerById(playerId);

        if (player == null) {
            System.out.println("Player not found. Please add player first.");
            return;
        }

        Contract contract = new Contract();
        contract.inputContractInfo(sc, player);
        addContract(contract);
    }

    public void addContract(Contract contract) {
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

    public void updateContract(String contractId, Scanner sc, PlayerList playerList) {
        Contract contract = searchContractById(contractId);

        if (contract == null) {
            System.out.println("Contract not found.");
            return;
        }

        Player player = playerList.searchPlayerById(contract.getPlayerId());

        if (player == null) {
            System.out.println("Related player not found. Cannot update contract.");
            return;
        }

        contract.updateContractInfo(sc, player);
        System.out.println("Contract updated successfully.");
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
