package Nguyen_Van_Hung_ql_ban_sach;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
    public class Nguyen_Van_Hung_TTSanPham {
        int Ma_san_pham,Ma_danh_muc,lc;
        String Ten_san_pham,Mo_ta;
        double Gia_ban;
        String Ngnhap,Ngayban,Hansd;
        Date Ngay_nhap,Ngay_ban,Han_sd;
        public Nguyen_Van_Hung_TTSanPham() {
        }

        public Nguyen_Van_Hung_TTSanPham(int Ma_san_pham, int Ma_danh_muc, int lc, String Ten_san_pham, String Mo_ta, double Gia_ban, String Ngnhap, String Ngayban, String Hansd, Date Ngay_nhap, Date Ngay_ban, Date Han_sd) {
            this.Ma_san_pham = Ma_san_pham;
            this.Ma_danh_muc = Ma_danh_muc;
            this.lc = lc;
            this.Ten_san_pham = Ten_san_pham;
            this.Mo_ta = Mo_ta;
            this.Gia_ban = Gia_ban;
            this.Ngnhap = Ngnhap;
            this.Ngayban = Ngayban;
            this.Hansd = Hansd;
            this.Ngay_nhap = Ngay_nhap;
            this.Ngay_ban = Ngay_ban;
            this.Han_sd = Han_sd;
        }

        public int getMa_san_pham() {
            return Ma_san_pham;
        }

        public void setMa_san_pham(int Ma_san_pham) {
            this.Ma_san_pham = Ma_san_pham;
        }

        public int getMa_danh_muc() {
            return Ma_danh_muc;
        }

        public void setMa_danh_muc(int Ma_danh_muc) {
            this.Ma_danh_muc = Ma_danh_muc;
        }

        public int getLc() {
            return lc;
        }

        public void setLc(int lc) {
            this.lc = lc;
        }

        public String getTen_san_pham() {
            return Ten_san_pham;
        }

        public void setTen_san_pham(String Ten_san_pham) {
            this.Ten_san_pham = Ten_san_pham;
        }

        public String getMo_ta() {
            return Mo_ta;
        }

        public void setMo_ta(String Mo_ta) {
            this.Mo_ta = Mo_ta;
        }

        public double getGia_ban() {
            return Gia_ban;
        }

        public void setGia_ban(double Gia_ban) {
            this.Gia_ban = Gia_ban;
        }

        public String getNgnhap() {
            return Ngnhap;
        }

        public void setNgnhap(String Ngnhap) {
            this.Ngnhap = Ngnhap;
        }

        public String getNgayban() {
            return Ngayban;
        }

        public void setNgayban(String Ngayban) {
            this.Ngayban = Ngayban;
        }

        public String getHansd() {
            return Hansd;
        }

        public void setHansd(String Hansd) {
            this.Hansd = Hansd;
        }

        public Date getNgay_nhap() {
            return Ngay_nhap;
        }

        public void setNgay_nhap(Date Ngay_nhap) {
            this.Ngay_nhap = Ngay_nhap;
        }

        public Date getNgay_ban() {
            return Ngay_ban;
        }

        public void setNgay_ban(Date Ngay_ban) {
            this.Ngay_ban = Ngay_ban;
        }

        public Date getHan_sd() {
            return Han_sd;
        }

        public void setHan_sd(Date Han_sd) {
            this.Han_sd = Han_sd;
        }

        public void Nhap(){
            Scanner sc = new Scanner(System.in);
            System.out.println("Nhap ma san pham");
            Ma_san_pham = Integer.parseInt(sc.nextLine());
            System.out.println("Nhap ma danh muc");
            Ma_danh_muc = Integer.parseInt(sc.nextLine());
            System.out.println("Nhap ten san pham");
            Ten_san_pham = sc.nextLine();
            System.out.println("Nhap gia ban");
            Gia_ban= Double.parseDouble(sc.nextLine());
            System.out.println("Nhap ngay nhap hang");
            Ngnhap = sc.nextLine();
            SimpleDateFormat format = new SimpleDateFormat("dd/mm/yy");
            try {
                Ngay_nhap = format.parse(Ngnhap);
            } catch (ParseException ex) {
                Logger.getLogger(Nguyen_Van_Hung_TTSanPham.class.getName()).log(Level.SEVERE, null, ex);
            }
            System.out.println("Nhap Ngay ban");
            System.out.println("");
            System.out.println("Ban co nhap ngay ban khong");
            System.out.println("1 co:");
            System.out.println("2 khong:");
            System.out.println("Nhap su lua chon");
            lc = Integer.parseInt(sc.nextLine());
            switch(lc){
                case 1:
                    System.out.println("Nhap ngay ban:");
                    Ngayban = sc.nextLine();
                    SimpleDateFormat format1 = new SimpleDateFormat("dd/mm/yy");
                    if (Ngayban != null) {
                        try {
                            Ngay_ban= format1.parse(Ngayban);
                        } catch (ParseException ex) {
                            Logger.getLogger(Nguyen_Van_Hung_TTSanPham.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        break;
                    }
                case 2:
                    break;
            }
            System.out.println("Nhap han su dung");
            Hansd = sc.nextLine();
            SimpleDateFormat format2 = new SimpleDateFormat("dd/mm/yy");
            try {
                Han_sd = format2.parse(Hansd);
            } catch (ParseException ex) {
                Logger.getLogger(Nguyen_Van_Hung_TTSanPham.class.getName()).log(Level.SEVERE, null, ex);
            }
            System.out.println("Nhap mo ta san pham");
            Mo_ta = sc.nextLine();
        }
        public void hienthi(){
            System.out.println(this);
        }
        public void hienthitonkho(){
            System.out.println(tonkho());
        }

        @Override
        public String toString() {
            return "Ma_san_pham=" + Ma_san_pham + ", Ma_danh_muc=" + Ma_danh_muc + ", Ten_san_pham=" + Ten_san_pham + ", Ngay_nhap=" + Ngay_nhap + ", Ngay_ban=" + Ngay_ban + ", Han_sd=" + Han_sd + ", Mo_ta=" + Mo_ta + ", Gia_ban=" + Gia_ban ;
        }
        public String tonkho() {
            return "Ma_san_pham=" + Ma_san_pham + ", Ma_danh_muc=" + Ma_danh_muc + ", Ten_san_pham=" + Ten_san_pham + ", Ngay_nhap=" + Ngay_nhap +", Han_sd=" + Han_sd + ", Mo_ta=" + Mo_ta + ", Gia_ban=" + Gia_ban ;
        }
    }
