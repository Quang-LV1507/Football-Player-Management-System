import java.util.ArrayList;
import java.util.Scanner;


public class ContractList {
    private ArrayList<Contract> contractCollection;

    public ContractList() {
        contractCollection = new ArrayList<>();
    }

    public void manageContracts(Scanner sc, PlayerList playerList) {
        int selectedFunction;
        do {
            System.out.println("\n===== CONTRACT MANAGEMENT =====");
            System.out.println("1. Add contract");
            System.out.println("2. Display all contracts");
            System.out.println("3. Search contract by ID");
            System.out.println("4. Update contract");
            System.out.println("5. Delete contract");
            System.out.println("6. Back to main menu");
            selectedFunction = readMenuNumber(sc);

            switch (selectedFunction) {
                case 1:
                    addNewContract(sc, playerList);
                    break;
                case 2:
                    displayContractList();
                    break;
                case 3:
                    searchContractById(sc);
                    break;
                case 4:
                    updateContractById(sc);
                    break;
                case 5:
                    deleteContractById(sc);
                    break;
                case 6:
                    System.out.println("Back to main menu.");
                    break;
            }
        } while (selectedFunction != 6);
    }

    private void addNewContract(Scanner sc, PlayerList playerList) {
        Contract contract = new Contract();
        contract.inputContractInformation(sc);

        if (findContract(contract.getContractId()) != null) {
            System.out.println("Contract ID already exists.");
            return;
        }

        if (playerList.findPlayerById(contract.getPlayerId()) == null) {
            System.out.println("Player ID does not exist. Please add player first.");
            return;
        }

        contractCollection.add(contract);
        System.out.println("Contract added successfully.");
    }

    private void displayContractList() {
        if (contractCollection.isEmpty()) {
            System.out.println("No contract data available.");
            return;
        }

        for (int i = 0; i < contractCollection.size(); i++) {
            System.out.println("\n--- Contract " + (i + 1) + " ---");
            contractCollection.get(i).displayContractInformation();
        }
    }

    private void searchContractById(Scanner sc) {
        System.out.print("Enter Contract ID to search: ");
        String searchId = sc.nextLine().trim();

        Contract contract = findContract(searchId);
        if (contract == null) {
            System.out.println("Contract not found.");
        } else {
            contract.displayContractInformation();
        }
    }

    private void updateContractById(Scanner sc) {
        System.out.print("Enter Contract ID to update: ");
        String updateId = sc.nextLine().trim();

        Contract contract = findContract(updateId);
        if (contract == null) {
            System.out.println("Contract not found.");
            return;
        }

        contract.updateContractInformation(sc);
        System.out.println("Contract updated successfully.");
    }

    private void deleteContractById(Scanner sc) {
        System.out.print("Enter Contract ID to delete: ");
        String deleteId = sc.nextLine().trim();

        Contract contract = findContract(deleteId);
        if (contract == null) {
            System.out.println("Contract not found.");
        } else {
            contractCollection.remove(contract);
            System.out.println("Contract deleted successfully.");
        }
    }

    private Contract findContract(String contractId) {
        for (Contract contract : contractCollection) {
            if (contract.getContractId().equals(contractId)) {
                return contract;
            }
        }
        return null;
    }

    private int readMenuNumber(Scanner sc) {
        while (true) {
            try {
                System.out.print("Choose option: ");
                int number = Integer.parseInt(sc.nextLine().trim());
                if (number >= 1 && number <= 6) {
                    return number;
                }
            } catch (NumberFormatException e) {
                // handled by the message below
            }
            System.out.println("Please choose a valid option from 1 to 6.");
        }
    }
}
