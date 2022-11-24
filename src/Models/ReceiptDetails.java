package Models;
public class ReceiptDetails {
    String idReceiptDetails;
    String idReceipt;
    String idMenu;
    int quantity;
    String statusFoodProgress;
    double total;

    public ReceiptDetails(String idReceiptDetails, String idReceipt, String idMenu, int quantity, String statusFoodProgress, double total){
        this.idReceiptDetails = idReceiptDetails;
        this.idReceipt = idReceipt;
        this.idMenu = idMenu;
        this.quantity = quantity;
        this.statusFoodProgress = statusFoodProgress;
        this.total = total;
    }

    public String getIdReceiptDetails(){
        return idReceiptDetails;
    }

    public void setIdReceiptDetails(String idReceiptDetails){
        this.idReceiptDetails = idReceiptDetails;      
    }

    public String getIdReceipt(){
        return idReceiptDetails;
    }

    public void setIdReceipt(String idReceipt){
        this.idReceipt = idReceipt;      
    }

    public String getIdMenu(){
        return idMenu;
    }

    public void setIdMenu(String idMenu){
        this.idMenu = idMenu;      
    }

    public int getQuantity(){
        return quantity;
    }

    public void setQuantity(int quantity){
        this.quantity = quantity;      
    }

    public String getStatusFoodProgress(){
        return statusFoodProgress;
    }

    public void setStatusFoodProgress(String statusFoodProgress){
        this.statusFoodProgress = statusFoodProgress;      
    }

    public double getTotal(){
        return total;
    }

    public void setTotal(double total){
        this.total = total;      
    }
}