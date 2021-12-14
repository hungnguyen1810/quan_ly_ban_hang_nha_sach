package Nguyen_Van_Hung_ql_ban_sach;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Nguyen_Van_Hung_Main {

        static List<Nguyen_Van_Hung_DanhMuc> categoryList = new ArrayList<>();
        static List<Nguyen_Van_Hung_HangHoa> productList = new ArrayList<>();
        static Date dateSystem = new Date();

        public static void main(String[] agrs) {
            Scanner scan = new Scanner(System.in);
            int choose;
            do {
                Menu();
                choose = Integer.parseInt(scan.nextLine());

                switch (choose) {
                    case 1 -> NhapThongTinDanhMuc();
                    case 2 -> NhapThongTinSanPham();
                    case 3 -> InSanPhamDaBan();
                    case 4 -> InSanPhamTonKho();
                    case 5 -> InSanPhamQuaHan();
                    case 6 -> InSanPhamSapHetHan();
                    case 7 -> TimKiem();
                    case 8 -> LuuFile();
                    case 9 -> DocFile();
                    default -> System.err.println("Nhap choose sai!!!");
                }

            } while (choose != 9);

        }

        static void Menu() {
            System.out.println("1. Nhập thông tin danh mục");
            System.out.println("2. Nhập thông tin sản phẩm(sách, văn phòng phẩm...) ");
            System.out.println("3. In ra danh sách các sản phẩm đã bán");
            System.out.println("4. In ra danh sách sản phầm còn tồn kho");
            System.out.println("5. In ra danh sách sản phẩm đã quá hạn sử dụng(áp dụng cho keo dán, bút...): ");
            System.out.println("6. In ra danh sách sản phẩm sắp hết hạn sử dụng(áp dụng cho keo dán, bút...):");
            System.out.println("7.Tìm kiếm ");
            System.out.println("8. Lưu vào file");
            System.out.println("9. Đọc dữ liệu từ file và lưu ra chương trình");
            System.out.println("Chon: ");
        }

        private static void NhapThongTinDanhMuc() {
            Scanner scan = new Scanner(System.in);
            System.out.println("Nhap so luong danh muc muon them: ");
            int num = Integer.parseInt(scan.nextLine());

            for (int i = 0; i < num; i++) {
                System.out.format("Nhap danh muc thu %d", i + 1);
                Nguyen_Van_Hung_DanhMuc category = new Nguyen_Van_Hung_DanhMuc();
                category.nhapDuLieu();
                categoryList.add(category);
            }
        }

        private static void NhapThongTinSanPham() {
            Scanner scan = new Scanner(System.in);
            System.out.println("Nhap so luong san pham muon them: ");
            int num = Integer.parseInt(scan.nextLine());
            for (int i = 0; i < num; i++) {
                System.out.format("Nhap san pham thu %d", i + 1);
                Nguyen_Van_Hung_HangHoa product = new Nguyen_Van_Hung_HangHoa();
                product.NhapDuLieu();
                productList.add(product);
            }
        }

        private static void InSanPhamDaBan() {
            for (Nguyen_Van_Hung_HangHoa product : productList) {
                if (product.getNgayBan() != null) {
                    product.HienThi();
                }
            }

        }

        private static void InSanPhamTonKho() {
            for (Nguyen_Van_Hung_HangHoa product : productList) {
                if (product.getNgayBan() == null) {
                    product.HienThi();
                }
            }
        }

        private static void InSanPhamQuaHan() {
            for (Nguyen_Van_Hung_HangHoa product : productList) {
                if (product.getHanSuDung().before(dateSystem)) {
                    product.HienThi();
                }
            }

        }

        private static void InSanPhamSapHetHan() {

            for (Nguyen_Van_Hung_HangHoa product : productList) {
                Date HanSuDung = product.getHanSuDung();
                Calendar c = Calendar.getInstance();
                c.setTime(HanSuDung);
                c.add(Calendar.DATE, 7);
                Date HanSuDungPlus = c.getTime();

                int compare1 = HanSuDungPlus.compareTo(dateSystem);
                int compare2 = (product.getHanSuDung()).compareTo(dateSystem);
                if (compare1 > 0 && compare2 < 0) {
                    product.HienThi();
                }
            }
        }

        private static void TimKiem() {
            Scanner scan = new Scanner(System.in);
            System.out.println("Nhap ten san pham can tim");
            String name = scan.nextLine();
            int count = 0;
            for (Nguyen_Van_Hung_HangHoa product : productList) {
                if (product.getTenSanPham().equalsIgnoreCase(name)) {
                    count += 1;
                    product.HienThi();
                }
            }
            System.out.println("So luong san pham:" + count);

        }

        private static void LuuFile() {
            FileOutputStream fos = null;
            ObjectOutputStream oos = null;

            try {
                fos = new FileOutputStream("category.dat");
                oos = new ObjectOutputStream(fos);
                for (Nguyen_Van_Hung_DanhMuc category : categoryList) {
                    oos.writeObject(category);
                }
            } catch (FileNotFoundException ex) {
                Logger.getLogger(Nguyen_Van_Hung_Main.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(Nguyen_Van_Hung_Main.class.getName()).log(Level.SEVERE, null, ex);
            }

            FileOutputStream fos_sell = null;
            ObjectOutputStream oos_sell = null;

            try {
                fos_sell = new FileOutputStream("sell.dat");
                oos_sell = new ObjectOutputStream(fos_sell);
                for (Nguyen_Van_Hung_HangHoa product : productList) {
                    if (product.NgayBan != null) {
                        oos_sell.writeObject(product);
                    }
                }
            } catch (FileNotFoundException ex) {
                Logger.getLogger(Nguyen_Van_Hung_Main.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(Nguyen_Van_Hung_Main.class.getName()).log(Level.SEVERE, null, ex);
            }

            FileOutputStream fos_expire = null;
            ObjectOutputStream oos_expire = null;

            try {
                fos_expire = new FileOutputStream("expire.dat");
                oos_expire = new ObjectOutputStream(fos_expire);
                for (Nguyen_Van_Hung_HangHoa product : productList) {
                    int compare = product.HanSuDung.compareTo(dateSystem);
                    if (compare > 0) {
                        oos_expire.writeObject(product);
                    }
                }
            } catch (FileNotFoundException ex) {
                Logger.getLogger(Nguyen_Van_Hung_Main.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(Nguyen_Van_Hung_Main.class.getName()).log(Level.SEVERE, null, ex);
            }

            FileOutputStream fos_other = null;
            ObjectOutputStream oos_other = null;
            try {
                fos_other = new FileOutputStream("product.dat");
                oos_other = new ObjectOutputStream(fos_other);
                for (Nguyen_Van_Hung_HangHoa product : productList) {
                    int compare1 = product.HanSuDung.compareTo(dateSystem);
                    int compare2 = (product.getHanSuDung()).compareTo(dateSystem);
                    if ((compare1 > 0 && compare2 < 0) || (product.NgayBan != null)) {
                        continue;
                    }
                    oos_other.writeObject(product);
                }
            } catch (FileNotFoundException ex) {
                Logger.getLogger(Nguyen_Van_Hung_Main.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(Nguyen_Van_Hung_Main.class.getName()).log(Level.SEVERE, null, ex);
            }

        }

        private static void DocFile() {
            FileInputStream fis = null;
            ObjectInputStream ois = null;

            try {

                fis = new FileInputStream("category.dat");
                ois = new ObjectInputStream(fis);
                while (true) {
                    Nguyen_Van_Hung_DanhMuc category = (Nguyen_Van_Hung_DanhMuc) ois.readObject();
                    if (category != null) {
                        categoryList.add(category);
                    } else {
                        break;
                    }
                }
            } catch (FileNotFoundException ex) {
                Logger.getLogger(Nguyen_Van_Hung_Main.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException | ClassNotFoundException ex) {
                Logger.getLogger(Nguyen_Van_Hung_Main.class.getName()).log(Level.SEVERE, null, ex);
            }

            FileInputStream fis_sell = null;
            ObjectInputStream ois_sell = null;

            try {

                fis_sell = new FileInputStream("sell.dat");
                ois_sell = new ObjectInputStream(fis_sell);
                while (true) {
                    Nguyen_Van_Hung_HangHoa product = (Nguyen_Van_Hung_HangHoa) ois_sell.readObject();
                    if (product != null) {
                        productList.add(product);
                    } else {
                        break;
                    }
                }
            } catch (FileNotFoundException ex) {
                Logger.getLogger(Nguyen_Van_Hung_Main.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException | ClassNotFoundException ex) {
                Logger.getLogger(Nguyen_Van_Hung_Main.class.getName()).log(Level.SEVERE, null, ex);
            }

            FileInputStream fis_expire = null;
            ObjectInputStream ois_expire = null;

            try {

                fis_expire = new FileInputStream("expire.dat");
                ois_expire = new ObjectInputStream(fis_expire);
                while (true) {
                    Nguyen_Van_Hung_HangHoa product = (Nguyen_Van_Hung_HangHoa) ois_expire.readObject();
                    if (product != null) {
                        productList.add(product);
                    } else {
                        break;
                    }
                }
            } catch (FileNotFoundException ex) {
                Logger.getLogger(Nguyen_Van_Hung_Main.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException | ClassNotFoundException ex) {
                Logger.getLogger(Nguyen_Van_Hung_Main.class.getName()).log(Level.SEVERE, null, ex);
            }

            FileInputStream fis_other = null;
            ObjectInputStream ois_other = null;

            try {

                fis_other = new FileInputStream("product.dat");
                ois_other = new ObjectInputStream(fis_other);
                while (true) {
                    Nguyen_Van_Hung_HangHoa product = (Nguyen_Van_Hung_HangHoa) ois_other.readObject();
                    if (product != null) {
                        productList.add(product);
                    } else {
                        break;
                    }
                }
            } catch (FileNotFoundException ex) {
                Logger.getLogger(Nguyen_Van_Hung_Main.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException | ClassNotFoundException ex) {
                Logger.getLogger(Nguyen_Van_Hung_Main.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }
