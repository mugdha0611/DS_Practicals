import java.util.*;

public class BullyAlgorithm {
    int processes[];
    int n;
    int coordinator;

    public BullyAlgorithm(int n) {
        this.n = n;
        processes = new int[n];
        for(int i = 0; i < n; i++) {
            processes[i] = 1; // 1 means process is up
            System.out.println("P" + (i+1) + " is up.");
        }
        coordinator = n;
        System.out.println("P" + coordinator + " is the coordinator.");
    }

    void displayProcesses() {
        for(int i = 0; i < n; i++) {
            if(processes[i] == 1)
                System.out.println("P" + (i+1) + " is up.");
            else
                System.out.println("P" + (i+1) + " is down.");
        }
        System.out.println("Current coordinator is P" + coordinator);
    }

    void upProcess(int id) {
        if(processes[id-1] == 1)
            System.out.println("Process P" + id + " is already up.");
        else {
            processes[id-1] = 1;
            System.out.println("Process P" + id + " is now up.");
        }
    }

    void downProcess(int id) {
        if(processes[id-1] == 0)
            System.out.println("Process P" + id + " is already down.");
        else {
            processes[id-1] = 0;
            System.out.println("Process P" + id + " is now down.");
            if(id == coordinator)
                System.out.println("Coordinator is down. Election needed!");
        }
    }

    void election(int initiator) {
        if(processes[initiator-1] == 0) {
            System.out.println("P" + initiator + " is down. Cannot start election.");
            return;
        }
        System.out.println("P" + initiator + " has initiated an election.");
        boolean newCoordinatorFound = false;
        for(int i = initiator; i < n; i++) {
            if(processes[i] == 1) {
                System.out.println("Election message sent from P" + initiator + " to P" + (i+1));
                newCoordinatorFound = true;
            }
        }
        if(newCoordinatorFound) {
            for(int i = n-1; i >= 0; i--) {
                if(processes[i] == 1) {
                    coordinator = i+1;
                    break;
                }
            }
            System.out.println("P" + coordinator + " becomes the new coordinator.");
        }
        else {
            System.out.println("No higher process is up. P" + initiator + " remains coordinator.");
            coordinator = initiator;
        }
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        BullyAlgorithm bully = null;
        int n, id, choice;

        while(true) {
            System.out.println("\nBully Algorithm");
            System.out.println("1. Create Processes");
            System.out.println("2. Display Processes");
            System.out.println("3. Bring Up a Process");
            System.out.println("4. Bring Down a Process");
            System.out.println("5. Start Election");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch(choice) {
                case 1:
                    System.out.print("Enter number of processes: ");
                    n = sc.nextInt();
                    bully = new BullyAlgorithm(n);
                    break;
                case 2:
                    bully.displayProcesses();
                    break;
                case 3:
                    System.out.print("Enter process id to up: ");
                    id = sc.nextInt();
                    bully.upProcess(id);
                    break;
                case 4:
                    System.out.print("Enter process id to down: ");
                    id = sc.nextInt();
                    bully.downProcess(id);
                    break;
                case 5:
                    System.out.print("Enter initiator id: ");
                    id = sc.nextInt();
                    bully.election(id);
                    break;
                case 6:
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }
}
