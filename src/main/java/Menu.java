import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Menu implements InterfaceMenu {
    private List<Menu> menus = new ArrayList<Menu>();
    private int ID;
    private String name;
    private int amount;
    private double mass;

    public Menu() {
    }

    public Menu(int ID, String name, double mass) {
        this.ID = ID;
        this.name = name;
        this.mass = mass;
    }

    public Menu(int ID, String name, int amount) {
        this.ID = ID;
        this.name = name;
        this.amount = amount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public double getMass() {
        return mass;
    }

    public void setMass(double mass) {
        this.mass = mass;
    }

    public void addMenu(int ID, String name, int amount) {
        menus.add(new Menu(ID, name, amount));
    }

    public void deleteMenu(String name) {
        for (int i = 0; i < menus.size(); i++) {
            if (menus.get(i).getName().equals(name)) {
                menus.remove(menus.get(i));
            }
        }
    }

    public void editMenu() {
        Scanner scanner = new Scanner(System.in);
        showMenu();
        System.out.println("Chọn món bạn muốn sửa");
        int choose = scanner.nextInt();
        for (int i = 0; i < menus.size(); i++) {
            if (choose == menus.get(i).getID()) {
                System.out.println("Sửa tên món thành");
                String newName = scanner.next();
                menus.get(i).setName(newName);
                System.out.println("Sửa giá món thành");
                int newAmount = scanner.nextInt();
                menus.get(i).setAmount(newAmount);
            }
        }
        showMenu();
    }

    public void showMenu() {
        System.out.println("   ---> MENU <---");
        addMenu(1, "Phở tái    ---> ", 30000);
        addMenu(2, "Phở chín   ---> ", 30000);
        addMenu(3, "Bún bò tái ---> ", 30000);
        addMenu(4, "Cơm giang  ---> ", 30000);
        addMenu(5, "Nếu bạn muốn đổi món xin chọn  ---> ", 5);
        addMenu(6, "Exit --> ", 0);
        for (int i = 0; i < menus.size(); i++) {
            System.out.println(menus.get(i).getID() + "." + menus.get(i).getName() + menus.get(i).getAmount());
        }
    }
}
