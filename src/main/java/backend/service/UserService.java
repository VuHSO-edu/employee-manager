package backend.service;

import backend.datalayer.IUserRepository;
import lombok.AllArgsConstructor;
import user.ProSkill;
import user.User;

import java.io.IOException;
import java.sql.SQLException;
@AllArgsConstructor
public class UserService implements IUserService{
    private IUserRepository repository;
    @Override
    public User findByProjectID(int id) throws SQLException, IOException {
        return repository.findByProjectID(id);
    }

    @Override
    public User findByManager() throws SQLException, IOException {
        return repository.findByManager();
    }

    @Override
    public User login(String email, String password) throws SQLException, ClassNotFoundException {
        return repository.login(email,password);
    }

    @Override
    public boolean addEmployee(int id, String fullName, String email, String password, int projectId, ProSkill proSkill) throws SQLException, IOException {
        return repository.addEmployee(id, fullName, email, password, projectId, proSkill);
    }

    @Override
    public boolean addManager(int id, String fullName, String email, String password, int projectId, int expInYear) throws SQLException, IOException {
        return repository.addManager(id, fullName, email, password, projectId, expInYear);
    }
}
