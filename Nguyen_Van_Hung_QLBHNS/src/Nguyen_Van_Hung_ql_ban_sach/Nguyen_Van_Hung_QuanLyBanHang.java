package Nguyen_Van_Hung_ql_ban_sach;
import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;
    public class Nguyen_Van_Hung_QuanLyBanHang implements Serializable{
        String productName,categoryCode,productCode;
        Float price;
        Date importDate,sellDate,expiryDate;
        String description;

        public boolean isSold() {
            return (sellDate != null);
        }

        public boolean isExpire() {
            Date today = new Date();
            return (expiryDate.before(today));
        }

        public boolean isSoonExpire() {
            Date today = new Date();
            Calendar cal = Calendar.getInstance();
            cal.setTime(today);
            cal.add(Calendar.DATE, 7);
            Date todayPlus7 = cal.getTime();
            return (expiryDate.after(today) && expiryDate.before(todayPlus7));
        }

        public void input() {
            Scanner inp = new Scanner(System.in);
            while (true) {
                System.out.println("Input category code");
                if (isExistCategory(categoryCode = inp.nextLine())) break;
                System.out.println("Category does not exist, choose from the list below:");
                Nguyen_Van_Hung_DuLieu.getInstance().getListCategory().forEach((cate) -> {
                    System.out.println(cate.getCategoryCode());
                });
            }

            System.out.println("Input product code");
            productCode = inp.nextLine();
            System.out.println("Input product name");
            productName = inp.nextLine();
            System.out.println("Input price");
            price = Float.parseFloat(inp.nextLine());
            System.out.println("Input description");
            description = inp.nextLine();

            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            while (true) {
                try {
                    System.out.println("Input import date");
                    importDate = sdf.parse(inp.nextLine());
                    break;
                } catch (ParseException ex) {
                    System.out.println("Please input in this format (dd/mm/yyyy)");
                }
            }

            while (true) {
                try {
                    System.out.println("Input expiry date");
                    String inpStr = inp.nextLine();
                    if (!inpStr.equals("")){
                        expiryDate = sdf.parse(inpStr);
                    }
                    break;
                } catch (ParseException ex) {
                    System.out.println("Please input in this format (dd/mm/yyyy)");
                }
            }

            while (true) {
                try {
                    System.out.println("Input sell date");
                    String inpStr = inp.nextLine();
                    if (!inpStr.equals("")){
                        sellDate = sdf.parse(inpStr);
                    }
                    break;
                } catch (ParseException ex) {
                    System.out.println("Please input in this format (dd/mm/yyyy)");
                }
            }
        }

        @Override
        public String toString() {
            return "Product{" + "productName=" + productName + ", categoryCode=" + categoryCode + ", productCode=" + productCode + ", price=" + price + ", importDate=" + importDate + ", sellDate=" + sellDate + ", expiryDate=" + expiryDate + ", description=" + description + '}';
        }

        public void output() {
            System.out.println(this);
        }

        private boolean isExistCategory(String inpCate) {
            return Nguyen_Van_Hung_DuLieu.getInstance().getListCategory().stream().
                    anyMatch((category) -> (inpCate.
                            equalsIgnoreCase(category.getCategoryCode())));
        }

        public Nguyen_Van_Hung_QuanLyBanHang() {
        }

        public String getProductName() {
            return productName;
        }

        public void setProductName(String productName) {
            this.productName = productName;
        }

        public String getCategoryCode() {
            return categoryCode;
        }

        public void setCategoryCode(String categoryCode) {
            this.categoryCode = categoryCode;
        }

        public String getProductCode() {
            return productCode;
        }

        public void setProductCode(String productCode) {
            this.productCode = productCode;
        }

        public Float getPrice() {
            return price;
        }

        public void setPrice(Float price) {
            this.price = price;
        }

        public Date getImportDate() {
            return importDate;
        }

        public void setImportDate(Date importDate) {
            this.importDate = importDate;
        }

        public Date getSellDate() {
            return sellDate;
        }

        public void setSellDate(Date sellDate) {
            this.sellDate = sellDate;
        }

        public Date getExpiryDate() {
            return expiryDate;
        }

        public void setExpiryDate(Date expiryDate) {
            this.expiryDate = expiryDate;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }
    }
