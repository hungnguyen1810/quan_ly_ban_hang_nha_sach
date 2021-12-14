package Nguyen_Van_Hung_ql_ban_sach;

public class NguyenVanHung_SachThamKhao extends Nguyen_Van_Hung_Sach {
    private double thue, thanhTien;
    public NguyenVanHung_SachThamKhao() {
        super();
    }
    public NguyenVanHung_SachThamKhao(double thue) {
        super();
        this.thue = thue;
    }
    public double getThue() {
        return thue;
    }
    public void setThue(double thue) {
        this.thue = thue;
    }
    public void nhapSach() {
        super.nhapSach();
        System.out.print("Nhập thuế: ");
        thue = scanner.nextDouble();
    }
    @Override
    public String toString() {
        return super.toString() + ", thuế: " + this.thue;
    }
}