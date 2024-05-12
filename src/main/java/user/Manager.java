package user;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Manager extends User {

    private int expInYear;
    private int projectID;

    public Manager() {
        
    }

    public Manager(int id, String fullName, String email, String password, Role role) {
        super(id, fullName, email, password, role);
    }



    public Manager(int id, String fullName, String email, String password, Role role, int expInYear, int projectID) {
        super(id, fullName, email, password, role);
        this.expInYear = expInYear;
        this.projectID = projectID;
    }


    public Manager(int id, String fullName, String email, String password, String role, int expInYear, int projectId) {
    }
}
