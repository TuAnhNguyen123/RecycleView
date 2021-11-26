package com.example.recycleview;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

public class FoodModel {
    private String name;
    private String address;
    private BusinessType businessType;
    private float distance;
    private float rating;
    private int image;

    public FoodModel() {
    }

    public FoodModel(String name, String address, BusinessType businessType, float distance, float rating, int image) {
        this.name = name;
        this.address = address;
        this.businessType = businessType;
        this.distance = distance;
        this.rating = rating;
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public BusinessType getBusinessType() {
        return businessType;
    }

    public void setBusinessType(BusinessType businessType) {
        this.businessType = businessType;
    }

    public float getDistance() {
        return distance;
    }

    public void setDistance(float distance) {
        this.distance = distance;
    }

    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    @Override
    public String toString() {
        return "FoodModel{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", businessType=" + businessType +
                ", distance=" + distance +
                ", rating=" + rating +
                ", image=" + image +
                '}';
    }
    public static List<FoodModel> getMock(){
        return Arrays.asList(
                new FoodModel("Phá Lấu Cô Mai - Tôn Đản","266/77 Tôn Đản P. 4, Quận 4, TP. HCM",BusinessType.BISTRO,1.5f,4.5f,R.drawable.hinh_phalaucomai),
                new FoodModel("Bếp Bà Muối - Ăn Vặt Online","606/52 Đường 3 Tháng 2, P. 14, Quận 10, TP. HCM",BusinessType.SHOP_ONLINE,2.5f,4.5f,R.drawable.hinh_bepbamuoi),
                new FoodModel("Tâm Ký II - Cơm Chiên & Nui Xào - Lương Định Của","Hẻm 281A Lương Định Của, P. An Phú, Quận 2, TP. HCM",BusinessType.BISTRO,3.5f,4.5f,R.drawable.hinh_tamki2),
                new FoodModel("PyPo Food - Bắp Xào Trứng Muối Sốt Phô Mai","266/18A Tôn Đản, P. 8, Quận 4, TP. HCM",BusinessType.BISTRO,4.5f,5.0f,R.drawable.hinh_popy),
                new FoodModel("Crab Restaurant - Chuyên Các Món Cua","Tầng 2, Tầng 2, 304 Tôn Thất Hiệp, P. 12, Quận 11, TP. HCM",BusinessType.RESTAURANT,1.5f,4.5f,R.drawable.hinh_crabrestaurant),
                new FoodModel("Anh Quán - Mì Khô Gà Quay & Hủ Tiếu Mì Sủi Cảo","80/17/138 Dương Quảng Hàm, P. 5, Gò Vấp, TP. HCM",BusinessType.BISTRO,2.5f,4.5f,R.drawable.hinh_anhquan),
                new FoodModel("Xiên Que Ngon","15/45A Cầu Xéo, P. Tân Sơn Nhì, Tân Phú, TP. HCM",BusinessType.SHOP_ONLINE,3.5f,3.5f,R.drawable.hinh_xienquengon),
                new FoodModel("Đô Na - Quán Ốc","237/40 Trần Văn Đang, Quận 3, TP. HCM",BusinessType.BISTRO,4.5f,4.5f,R.drawable.hinh_dona),
                new FoodModel("Minh Thư 8 - Cơm Gà Xối Mỡ, Cơm Trắng & Phở","218 Hoàng Diệu 2, P. Linh Chiểu, Thủ Đức, TP. HCM",BusinessType.BISTRO,2.5f,4.5f,R.drawable.hinh_minhthu8),
                new FoodModel("Kimbap Hoàng Tử - Món Hàn Quốc - Lê Văn Sỹ","337/2 Lê Văn Sỹ, P.1, Tân Bình, TP. HCM",BusinessType.BISTRO,4.5f,5.0f,R.drawable.hinh_kimbaphoangtu),
                new FoodModel("Sức Sống Mới - Nước Ép & Sinh Tố - Lê Lợi","27 Lê Lợi, P. 4, Gò Vấp, TP. HCM",BusinessType.BISTRO,2.5f,4.5f,R.drawable.hinh_sucsongmoi),
                new FoodModel("Cơm Sườn Nướng 102 - Đường Số 2","79 Đường Số 2, P. Hiệp Bình Phước, Thủ Đức, TP. HCM",BusinessType.BISTRO,2.5f,4.5f,R.drawable.hinh_comsuonnuong),
                new FoodModel("Royaltea - Trần Hưng Đạo","391TK44/23 Trần Hưng Đạo, P. Cầu Kho, Quận 1, TP. HCM",BusinessType.BISTRO,3.5f,5.0f,R.drawable.hinh_royaltea),
                new FoodModel("Japanit Matcha & Coffee House - Trần Hưng Đạo","130 Trần Hưng Đạo, P. Phạm Ngũ Lão, Quận 1, TP. HCM",BusinessType.BISTRO,4.5f,4.5f,R.drawable.hinh_japanitmatcha),
                new FoodModel("TocoToco Bubble Tea - Phạm Hùng","179 Phạm Hùng, P. 4, Quận 8, TP. HCM",BusinessType.BISTRO,4.5f,4.5f,R.drawable.hinh_toco)
        );
    }
}