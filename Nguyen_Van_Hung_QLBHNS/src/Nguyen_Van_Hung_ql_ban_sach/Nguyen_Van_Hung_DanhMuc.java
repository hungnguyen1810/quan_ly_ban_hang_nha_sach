package Nguyen_Van_Hung_ql_ban_sach;
import java.io.Serializable;
import java.util.Scanner;
    public class Nguyen_Van_Hung_DanhMuc implements Serializable{
        public String MaDanhMuc;
        public String TenDanhMuc;
        public Nguyen_Van_Hung_DanhMuc() {
        }
        public Nguyen_Van_Hung_DanhMuc(String MaDanhMuc, String TenDanhMuc) {
            this.MaDanhMuc = MaDanhMuc;
            this.TenDanhMuc = TenDanhMuc;
        }
        public String getMaDanhMuc() {
            return MaDanhMuc;
        }
        public void setMaDanhMuc(String MaDanhMuc) {
            this.MaDanhMuc = MaDanhMuc;
        }
        public String getTenDanhMuc() {
            return TenDanhMuc;
        }
        public void setTenDanhMuc(String TenDanhMuc) {
            this.TenDanhMuc = TenDanhMuc;
        }
        @Override
        public String toString() {
            return "Category{" + "MaDanhMuc=" + MaDanhMuc + ", TenDanhMuc=" + TenDanhMuc + '}';
        }
        public void Hienthi() {
            System.out.println(this);
        }
        public void nhapDuLieu() {
            Scanner scan = new Scanner(System.in);
            System.out.println("Nhap ten danh muc");
            TenDanhMuc = scan.nextLine();
            System.out.println("Nhap ma danh muc");
            MaDanhMuc = scan.nextLine();
        }
    }
