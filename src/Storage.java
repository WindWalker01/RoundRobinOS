import java.util.Scanner;

class User {
    //Declare all user information
    int arrivalTime;
    int burstTime;


    //Use constructor to initialize all data (data stored in constructor so it can be accessed as a whole)
    public User(int arrivalTime, int burstTime) {
        this.arrivalTime = arrivalTime;
        this.burstTime = burstTime;
    }
}

//Node
class Node {
    User data; //data
    Node next; //pointer

    // Constructor to initialize a node
    public Node(User data, Node next) {
        this.data = data;
        this.next = next;
    }
}

class LinkedList {
    Node firstNode = null;
    Node lastNode = null;

    //Accepts the user information gathered from main
    public void addUser(User user) {
        Node newNode = new Node(user, null);
        if (lastNode != null) {
            lastNode.next = newNode;
            lastNode = newNode;
        } else {
            firstNode = newNode;
            lastNode = newNode;
        }
    }

    //display the users in the list
    public void display() {
        Node current = firstNode;
        while (current != null) {
            User user = current.data;
            System.out.println(user.arrivalTime + " " + user.burstTime);
            current = current.next;
        }
    }
}

public class Storage {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LinkedList list = new LinkedList();

        System.out.print("Number of processes");
        int processNum = scanner.nextInt();
        scanner.nextLine();

        for (int i = 0; i < processNum; i++) {


            System.out.print("Enter Arrival Time: ");
            int arrivalTime = scanner.nextInt();

            System.out.print("Enter Burst Time: ");
            int  burstTime = scanner.nextInt();



            //Create an object to store the information
            User user = new User(arrivalTime, burstTime);
            //Add all information to the linked list class
            list.addUser(user);
        }

        //Call display method from Linked List Class
        list.display();
        scanner.close();
    }
}
