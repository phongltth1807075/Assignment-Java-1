package controller;

import Model.EmployeesModel;

import java.util.Scanner;
import entity.Employee;

public class EmployeeController {
    private EmployeesModel model = new EmployeesModel();
    private Scanner scanner = new Scanner(System.in);

    public void register() {
        while (true) {
            System.out.println("Nhập vào tên:");
            String name = scanner.nextLine();
            System.out.println("Nhập vào tên tài khoản!");
            String account = scanner.nextLine();
            System.out.println("Nhập vào email!");
            String email = scanner.nextLine();
            System.out.println("Nhập vào password:");
            String password = scanner.nextLine();
            System.out.println("Nhập vào địa chỉ:");
            String address = scanner.nextLine();
            if (model.checkExistAccount(account)) {
                System.err.println("Tên tài khoản đã tồn tại!");
                System.out.println("Nhập lại tên thông tin tài khoản!");
            } else {
                Employee employee = new Employee(account, email, password, name, address);
                model.register(employee);
                break;
            }

        }


    }

    public void login() {
        Employee employee;
        while (true) {
            System.out.println("Nhập vào tên tài khoản!");
            String account = scanner.nextLine();
            System.out.println("Nhập vào password:");
            String password = scanner.nextLine();
            employee = model.login(account, password);
            if (employee == null) {
                System.out.println("không tồn tại tài khoản trên!");
            } else {
                System.out.println("Đăng nhập thành công.");
                break;
            }
        }
        System.out.println("Thông tin");
        System.out.println("Tên: " + employee.getName());
        System.out.println("Tên tài khoản : " + employee.getAccount());
        System.out.println("Email: " + employee.getEmail());
        System.out.println("Địa chỉ: " + employee.getAddress());
        System.out.println("Ngày tạo: " + employee.getCreatedAt());

    }
}
