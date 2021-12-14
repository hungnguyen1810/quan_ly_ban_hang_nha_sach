package Nguyen_Van_Hung_ql_ban_sach;
import java.util.Scanner;
public class Nguyen_Van_Hung_DanhMucSanPham {
    int Ma_danh_muc;
    String Ten_danh_muc;

    public Nguyen_Van_Hung_DanhMucSanPham() {
    }

    public Nguyen_Van_Hung_DanhMucSanPham(int Ma_danh_muc, String Ten_danh_muc) {
        this.Ma_danh_muc = Ma_danh_muc;
        this.Ten_danh_muc = Ten_danh_muc;
    }

    public static void add(Nguyen_Van_Hung_DanhMucSanPham p) {
    }

    public int getMa_danh_muc() {
        return Ma_danh_muc;
    }

    public void setMa_danh_muc(int Ma_danh_muc) {
        this.Ma_danh_muc = Ma_danh_muc;
    }

    public String getTen_danh_muc() {
        return Ten_danh_muc;
    }

    public void setTen_danh_muc(String Ten_danh_muc) {
        this.Ten_danh_muc = Ten_danh_muc;
    }

    @Override
    public String toString() {
        return "Ma_danh_muc=" + Ma_danh_muc + ", Ten_danh_muc=" + Ten_danh_muc;
    }
    public void Nhap(){
        Scanner sc = new  Scanner(System.in);
        System.out.println("Nhap ma danh muc");
        Ma_danh_muc = Integer.parseInt(sc.nextLine());
        System.out.println("Nhap ten danh muc");
        Ten_danh_muc = sc.nextLine();
    }
    public void hienthi(){
        System.out.println(toString());
    }
    public String hienthi1(){
        return "Ma danh muc: "+Ma_danh_muc+":: Ten danh muc: "+Ten_danh_muc;
    }
}
