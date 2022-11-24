package Models;

public class ReceiptDetails {
    String idReceiptDetails;
    String idReceipt;
    String idMenu;
    int quantity;
    EnumStatusFood statusFoodProgress;

    public ReceiptDetails(String idReceiptDetails, String idReceipt, String idMenu, int quantity,
            EnumStatusFood statusFoodProgress) {
        this.idReceiptDetails = idReceiptDetails;
        this.idReceipt = idReceipt;
        this.idMenu = idMenu;
        this.quantity = quantity;
        this.statusFoodProgress = statusFoodProgress;
    }

    public String getIdReceiptDetails() {
        return idReceiptDetails;
    }

    public void setIdReceiptDetails(String idReceiptDetails) {
        this.idReceiptDetails = idReceiptDetails;
    }

    public String getIdReceipt() {
        return idReceipt;
    }

    public void setIdReceipt(String idReceipt) {
        this.idReceipt = idReceipt;
    }

    public String getIdMenu() {
        return idMenu;
    }

    public void setIdMenu(String idMenu) {
        this.idMenu = idMenu;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public EnumStatusFood getStatusFoodProgress() {
        return statusFoodProgress;
    }

    public void setStatusFoodProgress(EnumStatusFood statusFoodProgress) {
        this.statusFoodProgress = statusFoodProgress;
    }
}
//