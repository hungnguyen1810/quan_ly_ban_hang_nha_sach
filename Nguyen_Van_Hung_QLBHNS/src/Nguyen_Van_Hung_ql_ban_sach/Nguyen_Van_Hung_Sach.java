package Nguyen_Van_Hung_ql_ban_sach;
import java.util.Scanner;
public class Nguyen_Van_Hung_Sach {
        private String maSach, nhaXuatBan;
        private double donGia;
        private int soLuong;
        Scanner scanner = new Scanner(System.in);
        public Nguyen_Van_Hung_Sach() {
            super();
        }
        public Nguyen_Van_Hung_Sach(String maSach, String nhaXuatBan, double donGia, int soLuong) {
            super();
            this.maSach = maSach;
            this.nhaXuatBan = nhaXuatBan;
            this.donGia = donGia;
            this.soLuong = soLuong;
        }
        public String getMaSach() {
            return maSach;
        }
        public void setMaSach(String maSach) {
            this.maSach = maSach;
        }
        public String getNhaXuatBan() {
            return nhaXuatBan;
        }
        public void setNhaXuatBan(String nhaXuatBan) {
            this.nhaXuatBan = nhaXuatBan;
        }
        public double getDonGia() {
            return donGia;
        }
        public void setDonGia(double donGia) {
            this.donGia = donGia;
        }
        public int getSoLuong() {
            return soLuong;
        }
        public void setSoLuong(int soLuong) {
            this.soLuong = soLuong;
        }
        public void nhapSach() {
            System.out.print("Nhập mã sách: ");
            maSach = scanner.nextLine();
            System.out.print("Nhập tên nhà xuất bản: ");
            nhaXuatBan = scanner.nextLine();
            System.out.print("Nhập đơn giá: ");
            donGia = scanner.nextDouble();
            System.out.print("Nhập số lượng: ");
            soLuong = scanner.nextInt();
        }
        @Override
        public String toString() {
            return "Mã sách: " + this.maSach + ", tên nhà xuất bản: " + this.nhaXuatBan + ", đơn giá: " +
                    this.donGia + ", số lượng: " + this.soLuong;
        }
}
