import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class TextBook implements TextBookInterface {
    //final array list
    final private ArrayList<Post> postsList;
    private int lastID;

    public TextBook() {
        postsList = new ArrayList<>();
        lastID = 0;
        loadPosts();  // Attempt to load existing posts if any
    }

    // Load existing posts from POST_LIST_FILENAME if the file exists
    private void loadPosts() {
        try (Scanner scanner = new Scanner(new File(POST_LIST_FILENAME))) {
            while (scanner.hasNextInt()) {
                int postID = scanner.nextInt();
                postsList.add(new Post(postID)); // Use Post recovery constructor
                lastID = Math.max(lastID, postID); // Update lastID to the highest found
            }
        } catch (FileNotFoundException e) {
            // No previous posts found, so we start with an empty list
        }
    }

    @Override
    public int getLastID() {
        return lastID;
    }

    @Override
    public int getPostCount() {
        return postsList.size();
    }

    @Override
    public String getPostString(int index) {
        // Validate the index before accessing the list
        if (index < 0 || index >= postsList.size()) {
            throw new IndexOutOfBoundsException("Invalid index: " + index);
        }
        return postsList.get(index).toString();
    }

    @Override
    public void addPost(String author, String text) {
        lastID++;
        Post newPost = new Post(lastID, author, text);
        postsList.add(newPost);
        appendPostIDToFile(lastID); // Append new post ID to file
    }

    // Helper method to append a new post ID to the list file
    private void appendPostIDToFile(int postID) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(POST_LIST_FILENAME, true))) {
            writer.println(postID);
        } catch (IOException e) {
            System.err.println("Error updating post list file: " + e.getMessage());
        }
    }

    @Override
    public Post removePost(int index) {
        if (index < 0 || index >= postsList.size()) {
            throw new IndexOutOfBoundsException("Invalid index: " + index);
        }
        Post removedPost = postsList.remove(index);
        updatePostListFile(); // Update the file after removal
        return removedPost;
    }

    // Helper method to rewrite POST_LIST_FILENAME after a post is removed
    private void updatePostListFile() {
        try (PrintWriter writer = new PrintWriter(new FileWriter(POST_LIST_FILENAME))) {
            for (Post post : postsList) {
                writer.println(post.getPostID());
            }
        } catch (IOException e) {
            System.err.println("Error updating post list file: " + e.getMessage());
        }
    }

    @Override
    public void addComment(int postIndex, String author, String text) {
        if (postIndex < 0 || postIndex >= postsList.size()) {
            throw new IndexOutOfBoundsException("Invalid post index: " + postIndex);
        }
        postsList.get(postIndex).addComment(author, text);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("TextBook contains " + getPostCount() + " posts:\n");
        for (int i = 0; i < postsList.size(); i++) {
            sb.append(i).append(" - ").append(postsList.get(i).toStringPostOnly()).append("\n");
        }
        return sb.toString();
    }

    @Override
    public ArrayList<Post> getPosts()
    {
        return new ArrayList<>(postsList);
    }

}
