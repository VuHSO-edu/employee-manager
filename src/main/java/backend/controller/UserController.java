package backend.controller;

import backend.service.IUserService;
import lombok.AllArgsConstructor;
import user.ProSkill;
import user.User;

import java.io.IOException;
import java.sql.SQLException;

@AllArgsConstructor
public class UserController {
    private IUserService service;

    public User findByProjectID(int id) throws SQLException, IOException {
        return service.findByProjectID(id);
    }


    public User findByManager() throws SQLException, IOException {
        return service.findByManager();
    }


    public User login(String email, String password) throws SQLException, ClassNotFoundException {
        return service.login(email,password);
    }


    public boolean addEmployee(int id, String fullName, String email, String password, int projectId, ProSkill proSkill) throws SQLException, IOException {
        return service.addEmployee(id, fullName, email, password, projectId, proSkill);
    }


    public boolean addManager(int id, String fullName, String email, String password, int projectId, int expInYear) throws SQLException, IOException {
        return service.addManager(id, fullName, email, password, projectId, expInYear);
    }
}
