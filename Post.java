import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DecimalFormat;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Scanner;

public class Post implements PostInterface {
    private int postID;
    private String author;
    private String text;
    private Instant timestamp;
    private ArrayList<String> commentsList;
    private String filename;

    // Constructor for creating a new post
    public Post(int postID, String author, String text) {
        this.postID = postID;
        this.author = author;
        this.text = text;
        this.timestamp = Instant.now();  // Sets the timestamp to the current time
        this.commentsList = new ArrayList<>();  // Initializes the list of comments
        this.filename = String.format("Post-%05d.txt", postID); // Generates filename based on postID
        writePostToFile();  // Write the post data to a file
    }
    

    // Constructor for restoring a post from a file
    // Constructor for recovering a post from a file
    public Post(int postID)
    {
        this.postID = postID;
        this.filename = String.format("Post-%05d.txt", postID); // Generates filename based on postID
        this.commentsList = new ArrayList<>();  // Initializes the list of comments
        System.out.println("Attempting to open file for postID: " + postID);
        readPostFromFile();  // Try to read the post data from the file
    }
        
    // Reads the post data and comments from the corresponding file
    private void readPostFromFile() {
        File file = new File(this.filename);  // Create a File object for the post file
        if (!file.exists()) {  // If the file doesn't exist, print an error and exit
            System.err.println("File could not be opened: " + this.filename);
            return;
        }
    
        try (Scanner scanner = new Scanner(file)) {  // Use a Scanner to read the file
            if (scanner.hasNextLine()) {
                // First line contains the post ID, timestamp, author, and text
                String line = scanner.nextLine();
                String[] tokens = line.split(" ", 4); // Split into four parts: ID, timestamp, author, text
                
                // Parse and assign values
                this.postID = Integer.parseInt(tokens[0]);
                this.timestamp = Instant.parse(tokens[1]);
                this.author = tokens[2];
                this.text = tokens[3];
            }
            
            // Remaining lines are comments
            while (scanner.hasNextLine()) {
                commentsList.add(scanner.nextLine());  // Add each comment to the list
            }
        } catch (FileNotFoundException e) {  // Handle file not found error
            System.err.println("File not found: " + this.filename);
            e.printStackTrace();
        } catch (Exception e) {  // Handle any other exceptions
            System.err.println("Error reading from file: " + this.filename);
            e.printStackTrace();
        }
    }
        
    // Writes the post data (ID, timestamp, author, text) to the file
    private void writePostToFile()
    {
        try (PrintWriter writer = new PrintWriter(new FileWriter(getFilename()))) {  // Open the file for writing
            writer.printf("%s %s %s %s\n", getFormattedPostID(), timestamp, author, text);  // Write formatted post data to file
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Formats the post ID with leading zeros (e.g., 00001, 00002, etc.)
    private String getFormattedPostID() {
        return new DecimalFormat("00000").format(postID);  // Format the post ID as a 5-digit string
    }

    @Override
    public void addComment(String author, String text) {
        String comment = String.format("%s %s %s", Instant.now(), author, text);  // Format the comment with timestamp, author, and text
        commentsList.add(comment);  // Add the comment to the list
        try (PrintWriter writer = new PrintWriter(new FileWriter(getFilename(), true))) {  // Open the file in append mode
            writer.println(comment);  // Append the comment to the file
        } catch (IOException e) {  // Handle any I/O exceptions
            e.printStackTrace();
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Post:\n");
        sb.append(toStringPostOnly()).append("\nComments:\n");  // Append post details and comments
        for (String comment : commentsList) {
            sb.append(comment).append("\n");  // Add each comment to the string representation
        }
        return sb.toString();  // Return the full string representation of the post
    }

    @Override
    public String toStringPostOnly() {
        return String.format("%s %s %s %s", getFormattedPostID(), timestamp, author, text);  // Return only the post details as a string
    }

    @Override
    public String getFilename() {
        return "Post-" + getFormattedPostID() + ".txt";  // Return the filename based on the formatted post ID
    }

    @Override
    public int getPostID() {
        return postID;  // Return the post ID
    }

    @Override
    public String getText() {
        return text;  // Return the text of the post
    }

    @Override
    public Instant getTimestamp() {
        return timestamp;  // Return the timestamp of the post
    }

    @Override
    public String getAuthor() {
        return author;  // Return the author of the post
    }
}
