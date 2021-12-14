package Nguyen_Van_Hung_ql_ban_sach;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
public class Nguyen_Van_Hung_DuLieu {
    List<Nguyen_Van_Hung_QuanLyBanHang> listCategory = null;
    List<Nguyen_Van_Hung_QuanLyBanHang> listProduct = null;
    private static Nguyen_Van_Hung_DuLieu instance;

    public Nguyen_Van_Hung_DuLieu() {
        listCategory = new ArrayList<>();
        listProduct = new ArrayList<>();
    }

    public static synchronized Nguyen_Van_Hung_DuLieu getInstance() {
        if (instance == null) {
            instance = new Nguyen_Van_Hung_DuLieu();
        }
        return instance;
    }

    public List<Nguyen_Van_Hung_QuanLyBanHang> getSoldProducts() {
        if (instance == null || instance.getListProduct() == null) return null;
        List<Nguyen_Van_Hung_QuanLyBanHang> soldProducts = new ArrayList<>();
        instance.getListProduct().stream().
                filter((product) -> product.isSold()).
                forEachOrdered((product) -> {
                    soldProducts.add(product);
                });
        return soldProducts;
    }

    public List<Nguyen_Van_Hung_QuanLyBanHang> getExpiryProducts() {
        if (instance == null || instance.getListProduct() == null) return null;
        List<Nguyen_Van_Hung_QuanLyBanHang> expiryProducts = new ArrayList<>();
        Date today = new Date();
        instance.getListProduct().stream().
                filter((product) -> (product.isExpire())).
                forEachOrdered((product) -> {
                    expiryProducts.add(product);
                });
        return expiryProducts;
    }

    public List<Nguyen_Van_Hung_QuanLyBanHang> getSoonExpiryProducts() {
        if (instance == null || instance.getListProduct() == null) return null;
        List<Nguyen_Van_Hung_QuanLyBanHang> soonExpiryProducts = new ArrayList<>();
        Date today = new Date();
        Calendar cal = Calendar.getInstance();
        cal.setTime(today);
        cal.add(Calendar.DATE, 7);
        Date todayPlus7 = cal.getTime();
        Nguyen_Van_Hung_DuLieu.getInstance().getListProduct().stream().
                filter((product) -> (product.isSoonExpire())).
                forEachOrdered(soonExpiryProducts::add);
        return soonExpiryProducts;
    }

    public List<Nguyen_Van_Hung_QuanLyBanHang> getRemainsProducts() {
        if (instance == null || instance.getListProduct() == null) return null;
        List<Nguyen_Van_Hung_QuanLyBanHang> remains = new ArrayList<>();
        instance.getListProduct().stream().filter((prod) -> (!prod.
                isExpire() && !prod.isSold())).forEachOrdered((prod) -> {
            remains.add(prod);
        });
        return remains;
    }

    public List<Nguyen_Van_Hung_QuanLyBanHang> getListCategory() {
        return listCategory;
    }

    public List<Nguyen_Van_Hung_QuanLyBanHang> getListProduct() {
        return listProduct;
    }

    public void setListCategory(List<Nguyen_Van_Hung_QuanLyBanHang> listCategory) {
        this.listCategory = listCategory;
    }

    public void setListProduct(List<Nguyen_Van_Hung_QuanLyBanHang> listProduct) {
        this.listProduct = listProduct;
    }
}
