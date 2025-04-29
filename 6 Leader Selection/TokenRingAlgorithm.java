import java.util.*;

public class TokenRingAlgorithm {
    int n;
    boolean processes[];
    int token;

    public TokenRingAlgorithm(int n) {
        this.n = n;
        processes = new boolean[n];
        for(int i = 0; i < n; i++) {
            processes[i] = true;
            System.out.println("P" + (i+1) + " is up.");
        }
        token = 0; // starting token holder
    }

    void displayProcesses() {
        for(int i = 0; i < n; i++) {
            if(processes[i])
                System.out.println("P" + (i+1) + " is up.");
            else
                System.out.println("P" + (i+1) + " is down.");
        }
        System.out.println("Token is at P" + (token+1));
    }

    void downProcess(int id) {
        if(!processes[id-1]) {
            System.out.println("Process P" + id + " is already down.");
        } else {
            processes[id-1] = false;
            System.out.println("Process P" + id + " is now down.");
        }
    }

    void upProcess(int id) {
        if(processes[id-1]) {
            System.out.println("Process P" + id + " is already up.");
        } else {
            processes[id-1] = true;
            System.out.println("Process P" + id + " is now up.");
        }
    }

    void passToken() {
        System.out.println("Passing token...");
        int start = token;
        do {
            token = (token + 1) % n;
            System.out.println("Token passed from P" + (start+1) + " to P" + (token+1));
            start = token;
        } while(!processes[token]);
        System.out.println("P" + (token+1) + " now has the token.");
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        TokenRingAlgorithm ring = null;
        int n, id, choice;

        while(true) {
            System.out.println("\nToken Ring Algorithm");
            System.out.println("1. Create Processes");
            System.out.println("2. Display Processes");
            System.out.println("3. Bring Up a Process");
            System.out.println("4. Bring Down a Process");
            System.out.println("5. Pass Token");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch(choice) {
                case 1:
                    System.out.print("Enter number of processes: ");
                    n = sc.nextInt();
                    ring = new TokenRingAlgorithm(n);
                    break;
                case 2:
                    ring.displayProcesses();
                    break;
                case 3:
                    System.out.print("Enter process id to up: ");
                    id = sc.nextInt();
                    ring.upProcess(id);
                    break;
                case 4:
                    System.out.print("Enter process id to down: ");
                    id = sc.nextInt();
                    ring.downProcess(id);
                    break;
                case 5:
                    ring.passToken();
                    break;
                case 6:
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }
}
