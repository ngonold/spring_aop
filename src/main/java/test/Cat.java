package test;

import org.springframework.stereotype.Component;
import test.dto.Food;
import test.dto.FoodType;

@Component
public class Cat implements Animal {
    private boolean isHungry = false;

    @Override
    public void gimmeFood() {
        System.out.println("Meow! gimme some fish, bro!");
    }

    @Override
    public boolean eat(Food food) {
        if (food.getFoodType() == FoodType.FISH && food.isFresh()) {
            isHungry = false;
            System.out.println("A cat is full!");
        }
        return isHungry();
    }

    @Override
    public boolean isHungry() {
        return isHungry;
    }
    @Override
    public void setHungry() {
        this.isHungry = true;
    }
}
