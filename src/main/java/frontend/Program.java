package frontend;

import backend.controller.UserController;
import backend.datalayer.IUserRepository;
import backend.datalayer.UserRepository;
import backend.service.IUserService;
import backend.service.UserService;
import jdbcutil.JdbcUtil;

import java.io.IOException;
import java.sql.SQLException;

public class Program {
    public static void main(String[] args) throws SQLException, IOException, ClassNotFoundException {
        IUserRepository repository = new UserRepository();
        IUserService service = new UserService(repository);
        UserController controller = new UserController(service);
        Function function = new Function(controller);
        function.showMenu();
    }
}
