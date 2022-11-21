public class Menu {
    String idMenu;
    String name_menu;
    String category;
    double price;

    public Menu(String idMenu, String name_menu, String category, double price) {
        this.idMenu = idMenu;
        this.name_menu = name_menu;
        this.category = category;
        this.price = price;
    }

    public String getIdMenu() {
        return idMenu;
    }

    public void setIdMenu(String idMenu) {
        this.idMenu = idMenu;
    }

    public String getName_menu() {
        return name_menu;
    }

    public void setName_menu(String name_menu) {
        this.name_menu = name_menu;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Menu [idMenu=" + idMenu + ", name_menu=" + name_menu + ", category=" + category + ", price=" + price
                + "]";
    }

}
