package utinity;
import controller.EmployeeController;

import java.util.Scanner;

public class MenuUtil {
    private EmployeeController employeeController= new EmployeeController();
    private Scanner scanner = new Scanner(System.in);
    public void createMenu(){
        while (true){
            System.out.println("-------------Menu----------------");
            System.out.println("1. Đăng Kí.");
            System.out.println("2. Đăng Nhập.");
            System.out.println("3. Thoát.");
            System.out.println("---------------------------------");
            System.out.println("Nhập lựa chọn của bạn: ");
            int choice= scanner.nextInt();
            switch (choice){
                case 1:
                    employeeController.register();
                    break;
                case 2:
                    employeeController.login();
                    break;
                case 3:
                    System.out.println("Hẹn Gặp Lại Lần Sau!");
                    break;
                    default:
                        System.out.println("Lựa chọn sai, vui lòng nhập số trong khoảng từ 1 đến 3.");
                        break;
            }
            if (choice==3){
                break;
            }
        }
    }

}
