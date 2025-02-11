package file_handling.text_file;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LoginService {
    public List<Map<String, String>> readFromUserLoginFile(String filePath) {
        List<Map<String, String>> users = new ArrayList<>();
        File file = new File(filePath);

        if (!file.exists()) {
            System.err.println("File does not exist!");
            return users;
        }

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",", 2);
                if (parts.length == 2) {
                    Map<String, String> user = new HashMap<>();
                    user.put("username", parts[0].trim());
                    user.put("password", parts[1].trim());
                    users.add(user);
                }
            }
        } catch (FileNotFoundException e) {
            System.err.println("Error reading file: " + e.getMessage());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return users;
    }

    public void writeToUserLoginFile(String filePath, List<Map<String, String>> usersToWrite) {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(filePath, true))) {
            for (Map<String, String> user : usersToWrite) {
                String username = user.get("username");
                String password = user.get("password");
                if (username != null && password != null) {
                    bufferedWriter.write(username + "," + password);
                    bufferedWriter.newLine();
                }
            }
        } catch (IOException e) {
            System.err.println("Error writing to file: " + e.getMessage());
        }
    }

    public static void displayUsersLoggedIn(List<Map<String, String>> users) {
        for (Map<String, String> user : users) {
            System.out.println("Username: " + user.get("username") + ", Password: " + user.get("password"));
        }
    }
}
