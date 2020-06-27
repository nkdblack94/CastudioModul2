import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Menu implements InterfaceMenu{
    private List<Menu> menu = new ArrayList<Menu>();
    private int ID;
    private String name;
    private int amount;
    private double mass;

    public Menu(){}

    public Menu(int ID, String name, double mass) {
        this.ID = ID;
        this.name = name;
        this.mass = mass;
    }

    public Menu(int ID,String name, int amount) {
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

    public void addMenu(int ID,String name, int amount) {
        menu.add(new Menu(ID, name, amount));
    }

    public void deleteMenu(String name) {
        for (int i = 0; i < menu.size(); i++) {
            if (menu.get(i).getName().equals(name)) {
                menu.remove(menu.get(i));
            }
        }
    }

    public void EditMenu() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập tên món ăn cần sửa");
        String name = scanner.next();
        for (int i = 0; i < menu.size(); i++) {
            if (menu.get(i).getName().equals(name)) {
                System.out.println("Sửa tên món thành");
                String newName = scanner.next();
                menu.get(i).setName(newName);
                System.out.println("Sửa giá món thành");
                int newAmount = scanner.nextInt();
                menu.get(i).setAmount(newAmount);
            }
        }
    }

    public void showMenu() {
        System.out.println("   ---> MENU <---");
        addMenu(1,"Phở tái    ---> ", 30000);
        addMenu(2,"Phở chín   ---> ", 30000);
        addMenu(3,"Bún bò tái ---> ", 30000);
        addMenu(4,"Cơm giang  ---> ", 30000);
        addMenu(5,"Nếu bạn muốn đổi món xin chọn  ---> ", 5);
        addMenu(6,"Exit --> ",0);
        for (int i = 0; i < menu.size(); i++) {
            System.out.println( menu.get(i).getID() + "." + menu.get(i).getName() + menu.get(i).getAmount());
        }
    }
}
