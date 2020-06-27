import com.sun.xml.internal.ws.api.model.wsdl.WSDLPortType;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public abstract class Order extends Menu {

    private List<Menu> menus = new ArrayList<Menu>();

    public void orderFood() {
        Scanner input = new Scanner(System.in);
        System.out.println("Mời bạn chọn món");
        int choose;
        super.showMenu();
        do {
            choose = input.nextInt();
            switch (choose) {
                case 1:
                    System.out.println("Bạn muốn gọi mấy bát");
                    double mass = input.nextDouble();
                    boolean check = false;
                    for (int i = 0; i < menus.size(); i++){
                        if (choose == menus.get(i).getID()){
                            menus.get(i).setMass(menus.get(i).getMass() + mass);
                            check = true;
                            break;
                        }
                    }
                    if (!check){
                        menus.add(new Menu(1, "Phở tái", mass));
                        System.out.println("Bạn có muốn chọn tiếp nếu không xin chọn 0");
                    }
                    break;
                case 2:
                    System.out.println("Bạn muốn gọi mấy bát");
                    double mass1 = input.nextDouble();
                    menus.add(new Menu(2, "Phở chín", mass1));
                    System.out.println("Bạn có muốn chọn tiếp nếu không xin chọn 0");
                    break;
                case 3:
                    System.out.println("Bạn muốn gọi mấy bát");
                    double mass2 = input.nextDouble();
                    menus.add(new Menu(3, "Bún bò tái", mass2));
                    System.out.println("Bạn có muốn chọn tiếp nếu không xin chọn 0");
                    break;
                case 4:
                    System.out.println("Bạn muốn gọi mấy bát");
                    double mass3 = input.nextDouble();
                    menus.add(new Menu(4, "Cơm giang", mass3));
                    System.out.println("Bạn có muốn chọn tiếp nếu không xin chọn 0");
                    break;
                case 5:
                    editFood();
                    break;
            }
        } while (choose != 0);
        System.out.println("những món bạn đã chọn là");
        showMenu();
    }

    public void editFood() {
        Scanner input = new Scanner(System.in);
        showMenu();
        System.out.println("Hãy chọn món bạn muốn sửa");
        int editFood = input.nextInt();
        for (int i = 0; i < menus.size(); i++) {
            System.out.println(menus.get(i).getID());
            if (editFood == menus.get(i).getID()) {
                System.out.println("Bạn muốn thay đổi");
                System.out.println("1. Món");
                System.out.println("2. Số lượng món");
                System.out.println("0. Exit");
                int choose = input.nextInt();
                switch (choose) {
                    case 1:
                        menus.remove(menus.get(i));
                        System.out.println("Mời bạn chọn lại món");
                        break;
                    case 2:
                        System.out.println("Nhập số lượng món muốn đổi");
                        choose = input.nextInt();
                        menus.get(i).setMass(choose);
                        break;
                }
            }
        }
        showMenu();
        System.out.println("Bạn có muốn chọn thêm món");
    }

    public boolean checkId(int ID) {
        boolean check = false;
        for (int i = 0; i < menus.size(); i++) {
            if (ID == menus.get(i).getID()) {
                check = true;
            }
        }
        return check;
    }

    @Override
    public void showMenu() {
        System.out.println("Khách order");
        for (int i = 0; i < menus.size(); i++) {
            System.out.println(i + 1 + "." + menus.get(i).getName() + " --> Số lượng " + menus.get(i).getMass());
        }
    }
}
