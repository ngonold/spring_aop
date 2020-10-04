package test.dto;

import java.time.LocalDateTime;

public class Food {
//    private String foodName;
    private LocalDateTime expirationDate;
    private FoodType foodType;
    private boolean isWrong = false;

    public Food(FoodType foodType, LocalDateTime expirationDate) {
//        this.foodName = foodName;
        this.expirationDate = expirationDate;
        this.foodType = foodType;
    }

    public FoodType getFoodType() {
        return foodType;
    }

    public void setWrong() {
        isWrong = true;
    }

    public boolean isWrong(){
        return isWrong;
    }

    public void setFoodType(FoodType foodType) {
        this.foodType = foodType;
    }

//    public String getFoodName() {
//        return foodName;
//    }
//
//    public void setFoodName(String foodName) {
//        this.foodName = foodName;
//    }

    public LocalDateTime getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(LocalDateTime expirationDate) {
        this.expirationDate = expirationDate;
    }

    public boolean isFresh() {
        return !LocalDateTime.now().isAfter(expirationDate);
    }
}
