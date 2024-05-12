package frontend;

import backend.controller.UserController;
import jdbcutil.ScannerUtil;
import lombok.AllArgsConstructor;
import user.ProSkill;
import user.User;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;
@AllArgsConstructor
public class Function {
    private UserController controller;



    public void findByProjectId(int projectId) throws SQLException,IOException {
        List<User> users = (List<User>) controller.findByProjectID(projectId);

        System.out.println("Danh sách Employee:");
        System.out.println("+------+--------------------+--------------------+");
        System.out.println("|  ID  |     FULL NAME      |       EMAIL        |");
        System.out.println("+------+--------------------+--------------------+");

        if (users.isEmpty()) {
            System.out.printf("| %-4s | %-18s | %-18s |%n", "NULL","NULL","NULL");
        } else {
            for (User user : users) {
                int id = user.getId();
                String fullName = user.getFullName();
                String email = user.getEmail();
                System.out.printf("| %-4s | %-18s | %-18s |%n", id, fullName, email);
                System.out.println("+------+--------------------+--------------------+");
            }
        }
    }

    public void findByManager() throws SQLException, IOException {
        List<User> users = (List<User>) controller.findByManager();

        System.out.println("Danh sách Manager:");
        System.out.println("+------+--------------------+--------------------+");
        System.out.println("|  ID  |     FULL NAME      |       EMAIL        |");
        System.out.println("+------+--------------------+--------------------+");

        if (users.isEmpty()) {
            System.out.printf("| %-4s | %-18s | %-18s |%n", "NULL","NULL","NULL");
        } else {
            for (User user : users) {
                int id = user.getId();
                String fullName = user.getFullName();
                String email = user.getEmail();
                System.out.printf("| %-4s | %-18s | %-18s |%n", id, fullName, email);
                System.out.println("+------+--------------------+--------------------+");
            }
        }

    }

    public void login() throws SQLException, ClassNotFoundException {
        while (true) {
            System.out.print("Mời bạn nhập Email: ");
            String email = ScannerUtil.inputEmail();

            System.out.print("Mời bạn nhập Password: ");
            String password = ScannerUtil.inputPassword();

            User user = controller.login(email,password);

            if (user != null) {
                System.out.printf("Chao mung %s (%s) \n \n \n", user.getFullName(),user.getRole());
            } else {
                System.out.println("Email/Password sai");
                System.out.println("Yêu cầu nhập lại ");
            }
        }
    }

    public void addEmplyee() throws SQLException, IOException {
        System.out.println("Mời nhập ID:");
        int id = ScannerUtil.inputInteger();
        System.out.println("Mời nhập full name:");
        String fullName = ScannerUtil.inputString();
        System.out.println("Mời nhập Email:");
        String email = ScannerUtil.inputEmail();
        System.out.println("Mời nhập Password:");
        String password = ScannerUtil.inputPassword();
        System.out.println("Mời nhập ProjectID:");
        int projectId = ScannerUtil.inputInteger();
        System.out.println("Mời nhập ProSkill:");
        ProSkill proSkill = ProSkill.valueOf(ScannerUtil.inputString());

        boolean check = controller.addEmployee(id,fullName,email,password,projectId,proSkill);

        if (check){
            System.out.println("tạo thành công");
        } else {
            System.out.println("Tạo thất bại");
        }
    }

    public void addManager() throws SQLException, IOException {
        System.out.println("Mời nhập ID:");
        int id = ScannerUtil.inputInteger();
        System.out.println("Mời nhập full name:");
        String fullName = ScannerUtil.inputString();
        System.out.println("Mời nhập Email:");
        String email = ScannerUtil.inputEmail();
        System.out.println("Mời nhập Password:");
        String password = ScannerUtil.inputPassword();
        System.out.println("Mời nhập ProjectID:");
        int projectId = ScannerUtil.inputInteger();
        System.out.println("Mời nhập ExpInYear:");
        int expInYear = ScannerUtil.inputInteger();

        boolean check = controller.addManager(id,fullName,email,password,projectId,expInYear);

        if (check){
            System.out.println("tạo thành công");
        } else {
            System.out.println("Tạo thất bại");
        }
    }

    public void showMenu() throws SQLException, IOException, ClassNotFoundException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("1.Tạo tài khoản Emloyee");
        System.out.println("2.Tạo tài khoản Manager");
        System.out.println("3.Login");
        System.out.println("4.Thoát");

        String choose = scanner.nextLine();

        if (choose.equals("1")){
            addEmplyee();
        } else if (choose.equals("2")) {
            addManager();
        } else if (choose.equals("3")) {
            login();
        } else if (choose.equals("4")) {
            return;
        }
    }

}
