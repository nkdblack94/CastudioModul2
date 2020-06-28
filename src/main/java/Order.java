import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Order extends Menu implements InterfaceMenu {

    private List<Menu> menus = new ArrayList<Menu>();

    public void orderFood() {
        Scanner input = new Scanner(System.in);
        int choose;
        super.showMenu();
        do {
            System.out.println("Mời bạn chọn món");
            choose = input.nextInt();
            switch (choose) {
                case 1:
                    customersOrder(choose, food1);
                    break;
                case 2:
                    customersOrder(choose, food2);
                    break;
                case 3:
                    customersOrder(choose, food3);
                    break;
                case 4:
                    customersOrder(choose, food4);
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

    public void customersOrder(int id, String food) {
        Scanner input = new Scanner(System.in);
        System.out.println("Bạn muốn gọi mấy bát");
        int mass = input.nextInt();
        if (checkId(id)) {
            addQuantity(id, mass);
        } else {
            editName(id, food, mass);
        }
    }

    public void editName(int id, String name, double mass) {
        Menu newDish = new Menu(id, name, mass);
        menus.add(newDish);
        System.out.println("Bạn có muốn chọn tiếp nếu không xin chọn 0");
    }

    public void addQuantity(int id, int mass) {
        for (int i = 0; i < menus.size(); i++) {
            if (id == menus.get(i).getID()) {
                menus.get(i).setMass(menus.get(i).getMass() + mass);
            }
        }
    }

    public boolean checkId(int ID) {
        boolean check = false;
        for (int i = 0; i < menus.size(); i++) {
            if (ID == menus.get(i).getID()) {
                check = true;
                break;
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
