package backend.datalayer;

import user.Manager;
import user.ProSkill;
import user.User;

import java.io.IOException;
import java.sql.SQLException;

public interface IUserRepository {
    User findByProjectID(int id) throws SQLException, IOException;
    User findByManager() throws SQLException, IOException;

    User login(String email, String password) throws SQLException, ClassNotFoundException;

    boolean addEmployee(int id, String fullName, String email, String password, int projectId, ProSkill proSkill)throws SQLException, IOException;
    boolean addManager(int id, String fullName, String email, String password, int projectId, int expInYear)throws SQLException, IOException;
}
