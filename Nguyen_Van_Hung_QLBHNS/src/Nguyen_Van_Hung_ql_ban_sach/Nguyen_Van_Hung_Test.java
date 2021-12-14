package Nguyen_Van_Hung_ql_ban_sach;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Nguyen_Van_Hung_Test {

    static ArrayList<Nguyen_Van_Hung_TTSanPham> Productlist = new ArrayList<Nguyen_Van_Hung_TTSanPham>();
    static ArrayList<Nguyen_Van_Hung_DanhMucSanPham> Product_portfoliolist = new ArrayList<Nguyen_Van_Hung_DanhMucSanPham>();
    static ArrayList<Nguyen_Van_Hung_HangHoa> Sanpham_hethansd = new ArrayList<>();
    static ArrayList<Nguyen_Van_Hung_HangHoa> San_pham_da_ban = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int lc;
        do {
            menu();
            System.out.println("Nhap su lua chon");
            lc = Integer.parseInt(sc.nextLine());
            switch (lc) {
                case 1 -> nhap_danh_muc_sp();
                case 2 -> nhap_sp();
                case 3 -> ds_san_pham_ban();
                case 4 -> ds_san_pham_ton_kho();
                case 5 -> ds_sp_qua_han();
                case 6 -> San_shh();
                case 7 -> Tim_kiem();
                case 8 -> {
                    luu_file();
                }
                 case 9 -> {
                    Hienthifile();
                }
                default -> System.out.println("Nhap lai");
            }
        } while (lc < 10);
    }

    public static void menu() {
        System.out.println("1 Nhap thong tin danh muc");
        System.out.println("2 Nhap thong tin san pham");
        System.out.println("3 In ra cac san pham da ban");
        System.out.println("4 In ra danh sach san pham ton kho");
        System.out.println("5 In ra danh sach san pham qua han");
        System.out.println("6 In ra danh sach san pham sap het han");
        System.out.println("7 Tim kiem san pham");
        System.out.println("8 Luu vao file");
        System.out.println("9 doc du lieu trong file va in ra ");
    }

    private static void nhap_danh_muc_sp() {
        int n;
        System.out.println("So luong danh muc ");
        n = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < n; i++) {
            Nguyen_Van_Hung_DanhMucSanPham p = new Nguyen_Van_Hung_DanhMucSanPham();
            p.Nhap();
            Product_portfoliolist.add(p);
        }
    }

    private static void nhap_sp() {
        if (Product_portfoliolist.size() < 0) {
            System.out.println("chua co danh muc san pham nao!!");
        } else {
            System.out.println("======== danh muc san pham ========");
            for (int i = 0; i < Product_portfoliolist.size(); i++) {
                System.out.println(i + 1 + ":  " + Product_portfoliolist.get(i).hienthi1());
            }
            System.out.println("======== Nhap san pham ===========");
            int n;
            System.out.println("Nhap so luong san pham can them");
            n = Integer.parseInt(sc.nextLine());
            for (int i = 0; i < n; i++) {
                Nguyen_Van_Hung_TTSanPham product = new Nguyen_Van_Hung_TTSanPham();
                product.Nhap();
                Productlist.add(product);
            }
        }
    }

    private static void ds_san_pham_ban() {
        System.out.println("Danh sach san pham da ban:");
        Productlist.stream().filter((product) -> (product.getLc() == 1)).forEachOrdered((product) -> {
            product.hienthi();
        });
    }

    private static void ds_san_pham_ton_kho() {
        System.out.println("Danh sach san pham ton kho:");
        Productlist.stream().filter((product) -> (product.getLc() != 1)).forEachOrdered((product) -> product.hienthitonkho());
    }

    private static void ds_sp_qua_han() {
        long millis = System.currentTimeMillis();
        java.sql.Date today = new java.sql.Date(millis);
        Productlist.stream().filter((product) -> (product.getHan_sd().before(today) && product.getLc() == 1)).forEachOrdered((product) -> {
            product.hienthi();
        });
    }

    private static void Tim_kiem() {
        int k = 0;
        System.out.println("Nhap ten can tim kiem!!");
        String tkiem = sc.nextLine();
        k = Productlist.stream().filter((product) -> (product.getTen_san_pham().equalsIgnoreCase(tkiem))).map((product) -> {
            product.hienthi();
            return product;
        }).map((_item) -> 1).reduce(k, Integer::sum);
        if (k != 0) {
            System.out.println("Khong co san pham nao !!");
        } else {
            System.out.println("Co " + k + " san pham!!");
        }
    }

    private static void San_shh() {
        long millis = System.currentTimeMillis();
        Date date = new Date(millis);
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.DATE, -7);
        java.util.Date gioi_han = cal.getTime();
        Productlist.stream().filter((product) -> (gioi_han.after(product.getHan_sd()))).forEachOrdered((product) -> {
            product.hienthi();
        });
    }

    private static void luu_file() {
        long millis = System.currentTimeMillis();
        java.sql.Date today = new java.sql.Date(millis);
// danh mục sẽ được lưu vào file category.dat
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        try {
            fos = new FileOutputStream("category.dat");
            oos = new ObjectOutputStream(fos);
            for (Nguyen_Van_Hung_DanhMucSanPham pr : Product_portfoliolist) {
                oos.writeObject(pr);
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Nguyen_Van_Hung_Test.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Nguyen_Van_Hung_Test.class.getName()).log(Level.SEVERE, null, ex);
        }

        for (Nguyen_Van_Hung_TTSanPham product : Productlist) {
            if (product.getLc() == 1) {
                //  sản phẩm đã bán vào sell.dat
                FileOutputStream fos1 = null;
                ObjectOutputStream oos1 = null;

                try {
                    fos = new FileOutputStream("sell.dat");
                    oos = new ObjectOutputStream(fos);
                    oos1.writeObject(product);
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(Nguyen_Van_Hung_Test.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IOException ex) {
                    Logger.getLogger(Nguyen_Van_Hung_Test.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else {
                FileOutputStream fos1 = null;
                ObjectOutputStream oos1 = null;
                if (product.getHan_sd().before(today) && product.getLc() == 2) {
    // hết hạn sử dụng vào file : expire.dat,
                    try {
                        fos1 = new FileOutputStream("expire.dat");
                        oos1 = new ObjectOutputStream(fos);
                        oos1.writeObject(product);
                    } catch (FileNotFoundException ex) {
                        Logger.getLogger(Nguyen_Van_Hung_Test.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (IOException ex) {
                        Logger.getLogger(Nguyen_Van_Hung_Test.class.getName()).log(Level.SEVERE, null, ex);
                    }

                } else {
                    // product.dat
                    try {
                        fos1 = new FileOutputStream("product.dat");
                        oos1 = new ObjectOutputStream(fos);
                        oos1.writeObject(product);
                    } catch (FileNotFoundException ex) {
                        Logger.getLogger(Nguyen_Van_Hung_Test.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (IOException ex) {
                        Logger.getLogger(Nguyen_Van_Hung_Test.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        }

    }

    private static void Hienthifile() {
        System.out.println("Danh sach danh muc san pham!!");
        FileInputStream fis = null;
        ObjectInputStream ois = null;
        try {
            fis = new FileInputStream("category.dat");
            ois = new ObjectInputStream(fis);
            while (true) {
                Object obj = ois.readObject();
                if (obj != null) {
                    Product_portfoliolist.add((Nguyen_Van_Hung_DanhMucSanPham) obj);
                } else {
                    break;
                }
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Nguyen_Van_Hung_Test.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException | ClassNotFoundException ex) {
            Logger.getLogger(Nguyen_Van_Hung_Test.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (fis != null) {
                try {
                    fis.close();
                } catch (IOException ex) {
                    Logger.getLogger(Nguyen_Van_Hung_Test.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (ois != null) {
                try {
                    ois.close();
                } catch (IOException ex) {
                    Logger.getLogger(Nguyen_Van_Hung_Test.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

        }
        System.out.println();
        System.out.println("Danh sach san pham het han");
        FileInputStream fis1 = null;
        ObjectInputStream ois1 = null;
        try {
            fis = new FileInputStream("expire.dat");
            ois = new ObjectInputStream(fis);
            while (true) {
                Object obj = ois1.readObject();
                if (obj != null) {
                    Sanpham_hethansd.add((Nguyen_Van_Hung_HangHoa) obj);
                } else {
                    break;
                }
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Nguyen_Van_Hung_Test.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException | ClassNotFoundException ex) {
            Logger.getLogger(Nguyen_Van_Hung_Test.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (fis1 != null) {
                try {
                    fis1.close();
                } catch (IOException ex) {
                    Logger.getLogger(Nguyen_Van_Hung_Test.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (ois1 != null) {
                try {
                    ois1.close();
                } catch (IOException ex) {
                    Logger.getLogger(Nguyen_Van_Hung_Test.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        System.out.println();
        System.out.println("Danh sach san pham da ban");
        FileInputStream fis2 = null;
        ObjectInputStream ois2 = null;
        try {
            fis2 = new FileInputStream("sell.dat");
            ois2 = new ObjectInputStream(fis);
            while (true) {
                Object obj = ois2.readObject();
                if (obj != null) {
                    San_pham_da_ban.add((Nguyen_Van_Hung_HangHoa) obj);
                } else {
                    break;
                }
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Nguyen_Van_Hung_Test.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException | ClassNotFoundException ex) {
            Logger.getLogger(Nguyen_Van_Hung_Test.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (fis2 != null) {
                try {
                    fis2.close();
                } catch (IOException ex) {
                    Logger.getLogger(Nguyen_Van_Hung_Test.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (ois2 != null) {
                try {
                    ois2.close();
                } catch (IOException ex) {
                    Logger.getLogger(Nguyen_Van_Hung_Test.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        System.out.println();
        System.out.println("Danh sach san pham con trong kho");
        FileInputStream fis3 = null;
        ObjectInputStream ois3 = null;
        try {
            fis3 = new FileInputStream("product.dat");
            ois3 = new ObjectInputStream(fis);
            while (true) {
                Object obj = ois3.readObject();
                if (obj != null) {
                    Productlist.add((Nguyen_Van_Hung_TTSanPham) obj);
                } else {
                    break;
                }
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Nguyen_Van_Hung_Test.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException | ClassNotFoundException ex) {
            Logger.getLogger(Nguyen_Van_Hung_Test.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (fis3 != null) {
                try {
                    fis3.close();
                } catch (IOException ex) {
                    Logger.getLogger(Nguyen_Van_Hung_Test.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (ois3 != null) {
                try {
                    ois3.close();
                } catch (IOException ex) {
                    Logger.getLogger(Nguyen_Van_Hung_Test.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

}