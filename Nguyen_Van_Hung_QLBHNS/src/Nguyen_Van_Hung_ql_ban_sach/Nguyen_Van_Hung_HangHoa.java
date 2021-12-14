package Nguyen_Van_Hung_ql_ban_sach;
import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

    public class Nguyen_Van_Hung_HangHoa implements Serializable{

        public String MaSanPham;
        public String MaDanhMuc;
        public String TenSanPham;
        public float Giaban;
        public Date NgayNhap;
        public Date NgayBan;
        public Date HanSuDung;
        public String MotaSanPham;

        public Nguyen_Van_Hung_HangHoa() {
        }

        public Nguyen_Van_Hung_HangHoa(String MaSanPham, String MaDanhMuc, String TenSanPham, float Giaban, Date NgayNhap, Date NgayBan, Date HanSuDung, String MotaSanPham) {
            this.MaSanPham = MaSanPham;
            this.MaDanhMuc = MaDanhMuc;
            this.TenSanPham = TenSanPham;
            this.Giaban = Giaban;
            this.NgayNhap = NgayNhap;
            this.NgayBan = NgayBan;
            this.HanSuDung = HanSuDung;
            this.MotaSanPham = MotaSanPham;
        }

        public String getMaSanPham() {
            return MaSanPham;
        }

        public void setMaSanPham(String MaSanPham) {
            this.MaSanPham = MaSanPham;
        }

        public String getMaDanhMuc() {
            return MaDanhMuc;
        }

        public void setMaDanhMuc(String MaDanhMuc) {
            this.MaDanhMuc = MaDanhMuc;
        }

        public String getTenSanPham() {
            return TenSanPham;
        }

        public void setTenSanPham(String TenSanPham) {
            this.TenSanPham = TenSanPham;
        }

        public float getGiaban() {
            return Giaban;
        }

        public void setGiaban(float Giaban) {
            this.Giaban = Giaban;
        }

        public Date getNgayNhap() {
            return NgayNhap;
        }

        public void setNgayNhap(Date NgayNhap) {
            this.NgayNhap = NgayNhap;
        }

        public Date getNgayBan() {
            return NgayBan;
        }

        public void setNgayBan(Date NgayBan) {
            this.NgayBan = NgayBan;
        }

        public Date getHanSuDung() {
            return HanSuDung;
        }

        public void setHanSuDung(Date HanSuDung) {
            this.HanSuDung = HanSuDung;
        }

        public String getMotaSanPham() {
            return MotaSanPham;
        }

        public void setMotaSanPham(String MotaSanPham) {
            this.MotaSanPham = MotaSanPham;
        }

        @Override
        public String toString() {
            return "Product{" + "MaSanPham=" + MaSanPham + ", MaDanhMuc=" + MaDanhMuc + ", TenSanPham=" + TenSanPham + ", Giaban=" + Giaban + ", NgayNhap=" + NgayNhap + ", NgayBan=" + NgayBan + ", HanSuDung=" + HanSuDung + ", MotaSanPham=" + MotaSanPham + '}';
        }

        public void NhapDuLieu() {
            SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
            Scanner scan = new Scanner(System.in);

            System.out.println("Nhap Ma San Pham: ");
            MaSanPham = scan.nextLine();

            System.out.println("Nhap Ma Danh Muc: ");
            MaDanhMuc = scan.nextLine();

            System.out.println("Nhap Ten San Pham: ");
            TenSanPham = scan.nextLine();

            System.out.println("Nhap Gia ban San Pham: ");
            Giaban = Float.parseFloat(scan.nextLine());

            System.out.println("Nhap Ngay nhap San Pham: ");
            String ngaynhapString = scan.nextLine();
            if (ngaynhapString.equals("")) {
                NgayNhap = null;
            } else {

                try {
                    NgayNhap = format.parse(ngaynhapString);
                } catch (ParseException ex) {
                    Logger.getLogger(Nguyen_Van_Hung_HangHoa.class.getName()).log(Level.SEVERE, null, ex);
                }

            }

            System.out.println("Nhap Ngay Ban San Pham: ");
            String ngaybanString = scan.nextLine();

            if (ngaybanString.equals("")) {
                NgayBan = null;
            } else {
                try {
                    NgayBan = format.parse(ngaybanString);
                } catch (ParseException ex) {
                    Logger.getLogger(Nguyen_Van_Hung_HangHoa.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            System.out.println("Nhap Han Su Dung San Pham: ");
            String HSDString = scan.nextLine();

            if (HSDString.equals("")) {
                HanSuDung = null;
            } else {
                try {
                    HanSuDung = format.parse(HSDString);
                } catch (ParseException ex) {
                    Logger.getLogger(Nguyen_Van_Hung_HangHoa.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            System.out.println("Nhap mo ta san pham: ");
            MotaSanPham = scan.nextLine();
        }

        public void HienThi() {
            System.out.println(this);
        }

    }
