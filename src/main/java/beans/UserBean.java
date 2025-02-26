package beans;

import entities.User;
import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import services.UserService;
import java.io.Serializable;
import java.util.List;

@Named
@SessionScoped
public class UserBean implements Serializable {
    private String username;
    private String password;
    private User loggedUser;

    @Inject
    private UserService userService;

    public String login() {
        List<User> users = userService.getAllUsers();
        for (User u : users) {
            if (u.getEmail().equals(username) && u.getPassword().equals(password)) {
                loggedUser = u;
                return u.getRole().equals("admin") ? "admin.xhtml" : "user.xhtml";
            }
        }
        return "error.xhtml";
    }

    // Getters et Setters
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public User getLoggedUser() {
        return loggedUser;
    }

    public void setLoggedUser(User loggedUser) {
        this.loggedUser = loggedUser;
    }
}
