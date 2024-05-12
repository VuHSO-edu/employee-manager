package backend.datalayer;

import jdbcutil.JdbcUtil;
import user.*;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserRepository implements IUserRepository{
    @Override
    public User findByProjectID(int projectId) throws SQLException, IOException {
        String url = "SELECT * FROM users WHERE project_id = ? AND role ='EMPLOYEE' ";

        try (
                Connection connection = JdbcUtil.getConnection();
                PreparedStatement pStmt = connection.prepareStatement(url);
        ){
            pStmt.setInt(1,projectId);
            try (
                    ResultSet rs = pStmt.executeQuery()
            ) {
                if (rs.next() == true) {
                    Employee user = new Employee();
                    int id = rs.getInt("id");
                    user.setId(id);

                    String fullName = rs.getString("full_name");
                    user.setFullName(fullName);

                    String email = rs.getString("email");
                    user.setEmail(email);

                    String password = rs.getString("password");
                    user.setPassword(password);

                    String role = rs.getString("role");
                    user.setRole(role);

                    user.setProjectID(projectId);

                    String proSkill = rs.getString("pro_skill");
                    user.setProSkill(ProSkill.valueOf(proSkill));

                    return user;

                } else {
                    return null;
                }
            }
        }
    }

    @Override
    public User findByManager() throws SQLException, IOException {
        String url = "SELECT * FROM users WHERE role ='MANAGER' ";

        try (
                Connection connection = JdbcUtil.getConnection();
                PreparedStatement pStmt = connection.prepareStatement(url);
        ){
            try (
                    ResultSet rs = pStmt.executeQuery()
            ) {
                if (rs.next() == true) {
                    Manager user = new Manager();
                    int id = rs.getInt("id");
                    user.setId(id);

                    String fullName = rs.getString("full_name");
                    user.setFullName(fullName);

                    String email = rs.getString("email");
                    user.setEmail(email);

                    String password = rs.getString("password");
                    user.setPassword(password);

                    String role = rs.getString("role");
                    user.setRole(role);

                    int projectId = rs.getInt("project_id");
                    user.setProjectID(projectId);

                    int expInYear = rs.getInt("exp_in_year");
                    user.setExpInYear(expInYear);

                    return user;

                } else {
                    return null;
                }
            }
        }
    }

    @Override
    public User login(String email, String password) throws SQLException, ClassNotFoundException {
        String sql = "SELECT * FROM users WHERE email = ? AND password = ?";
        try (
                Connection connection = JdbcUtil.getConnection();
                PreparedStatement pStmt = connection.prepareStatement(sql);
                ) {
            pStmt.setString(1, email);
            pStmt.setString(2, password);

            // Step 3: Execute SQL query
            try ( ResultSet rs = pStmt.executeQuery();) {
               if (rs.next()) {
                   int id = rs.getInt("id");
                   String fullName = rs.getString("full_name");

                   String role = rs.getString("role");

                   if (role.equals("MANAGER")) {
                       int expInYear = rs.getInt("exp_in_year");
                       int projectId = rs.getInt("project_id");

                       Manager manager = new Manager(id,fullName,email,password,role,expInYear,projectId);
                       return manager;
                   }
               }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    @Override
    public boolean addEmployee(int id, String fullName, String email, String password, int projectId, ProSkill proSkill) throws SQLException, IOException {
        String sql = "INSERT INTO candidate (id, full_name, email, password, exp_in_year, pro_skill,project_id, role)" +
                " VALUES (?, ?, ?, ?,NULL, ?,  ?, 'EMPLOYEE');";
        try (
                Connection connection = JdbcUtil.getConnection();
                PreparedStatement pStmt = connection.prepareStatement(sql);
                ) {
            pStmt.setInt(1,id);
            pStmt.setString(2,fullName);
            pStmt.setString(3,email);
            pStmt.setString(4,password);
            pStmt.setString(5, proSkill.toString());
            pStmt.setInt(6,projectId);

            int check = pStmt.executeUpdate();
            if (check > 0) {
                return true;
            }
            return false;
        }
    }

    @Override
    public boolean addManager(int id, String fullName, String email, String password, int projectId, int expInYear) throws SQLException, IOException {
        String sql = "INSERT INTO candidate (id, full_name, email, password, exp_in_year, pro_skill,project_id, role)" +
                " VALUES (?, ?, ?, ?,?, NULL, ?, 'EMPLOYEE');";
        try (
                Connection connection = JdbcUtil.getConnection();
                PreparedStatement pStmt = connection.prepareStatement(sql);
        ) {
            pStmt.setInt(1,id);
            pStmt.setString(2,fullName);
            pStmt.setString(3,email);
            pStmt.setString(4,password);
            pStmt.setInt(5,expInYear);
            pStmt.setInt(6,projectId);

            int check = pStmt.executeUpdate();
            if (check > 0) {
                return true;
            }
            return false;
        }
    }


}




