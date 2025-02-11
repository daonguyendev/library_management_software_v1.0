package file_handling.text_file;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LoginExample {
    private static final String FILE_PATH =
            "D:\\codegym\\module-02-advanced-programming-with-java\\" +
                    "sources\\library_management_software_v1.0\\src\\" +
                    "file_handling\\text_file\\user_login.txt";

    public static void main(String[] args) {
        LoginService loginService = new LoginService();

        List<Map<String, String>> users = loginService.readFromUserLoginFile(FILE_PATH);
        LoginService.displayUsersLoggedIn(users);

        List<Map<String, String>> newUsers = new ArrayList<>();
        Map<String, String> user1 = new HashMap<>();
        user1.put("username", "tincuc789");
        user1.put("password", "123456");

        Map<String, String> user2 = new HashMap<>();
        user2.put("username", "duccop891");
        user2.put("password", "456789");

        newUsers.add(user1);
        newUsers.add(user2);

        loginService.writeToUserLoginFile(FILE_PATH, newUsers);
    }
}
