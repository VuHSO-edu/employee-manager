package user;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class User {
    private int id;
    private String fullName;
    private String email;
    private String password;
    private Role role;

    public User() {
    }

    public void setRole(String role) {
        this.role = Role.valueOf(role);
    }

}
