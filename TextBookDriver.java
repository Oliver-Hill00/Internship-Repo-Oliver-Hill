import java.util.Scanner;

public class TextBookDriver {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter your username: ");
        String username = scanner.next();
        TextBook textBook = new TextBook();

        String choice;
        do {
            displayMenu();
            choice = scanner.next().toLowerCase();
            switch (choice) {
                case "p":
                    System.out.println(textBook);
                    break;
                case "a":
                    System.out.print("Enter post text: ");
                    scanner.nextLine();  // Consume newline
                    String postText = scanner.nextLine();
                    textBook.addPost(username, postText);
                    break;
                case "d":
                    System.out.print("Enter post index to delete: ");
                    int deleteIndex = scanner.nextInt();
                    if (isValidIndex(deleteIndex, textBook)) {
                        textBook.removePost(deleteIndex);
                    } else {
                        System.out.println("Invalid index.");
                    }
                    break;
                case "c":
                    System.out.print("Enter post index to comment on: ");
                    int commentIndex = scanner.nextInt();
                    if (isValidIndex(commentIndex, textBook)) {
                        System.out.print("Enter comment text: ");
                        scanner.nextLine();  // Consume newline
                        String commentText = scanner.nextLine();
                        textBook.addComment(commentIndex, username, commentText);
                    } else {
                        System.out.println("Invalid index.");
                    }
                    break;
                case "r":
                    System.out.print("Enter post index to read: ");
                    int readIndex = scanner.nextInt();
                    if (isValidIndex(readIndex, textBook)) {
                        System.out.println(textBook.getPostString(readIndex));
                    } else {
                        System.out.println("Invalid index.");
                    }
                    break;
                case "m":
                    break;
                case "q":
                    System.out.println("Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice.");
                    break;
            }
        } while (!choice.equals("q"));

        scanner.close();
    }

    private static void displayMenu() {
        System.out.println("\nMenu Options:");
        System.out.println("(p) Print the TextBook");
        System.out.println("(a) Add a post");
        System.out.println("(d) Delete a post");
        System.out.println("(c) Comment on a post");
        System.out.println("(r) Read a post (including comments)");
        System.out.println("(m) Display menu");
        System.out.println("(q) Quit");
        System.out.print("Choose an option: ");
    }

    private static boolean isValidIndex(int index, TextBook textBook) {
        return index >= 0 && index < textBook.getPostCount();
    }
}
