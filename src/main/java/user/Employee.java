package user;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter

public class Employee extends User {
    private int projectID;
    private ProSkill proSkill;

    public Employee() {
        super();
    }

    public Employee(int id, String fullName, String email, String password, Role role) {
        super(id, fullName, email, password, role);
    }

    public Employee(int id, String fullName, String email, String password, Role role, int projectID, ProSkill proSkill) {
        super(id, fullName, email, password, role);
        this.projectID = projectID;
        this.proSkill = proSkill;
    }
}
