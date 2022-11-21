public class Discount {
    String idDiscount;
    int discountAmount;

    public Discount(String idDiscount, int discountAmount) {
        this.idDiscount = idDiscount;
        this.discountAmount = discountAmount;
    }

    public String getIdDiscount() {
        return idDiscount;
    }

    public void setIdDiscount(String idDiscount) {
        this.idDiscount = idDiscount;
    }

    public int getDiscountAmount() {
        return discountAmount;
    }

    public void setDiscountAmount(int discountAmount) {
        this.discountAmount = discountAmount;
    }

    @Override
    public String toString() {
        return "Discount [idDiscount=" + idDiscount + ", discountAmount=" + discountAmount + "]";
    }

}
