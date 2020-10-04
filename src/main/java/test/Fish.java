package test;

import org.springframework.stereotype.Component;
import test.dto.Food;
import test.dto.FoodType;

@Component
public class Fish implements Animal {
    private boolean isHungry = true;


    @Override
    public void gimmeFood() {
        System.out.println("A fish is gurgling for food!");
    }

    @Override
    public boolean eat(Food food) {
        if (!food.isWrong()) {
            isHungry = false;
            System.out.println("A fish is full!");
        }
        else
            System.out.println("Bad food for fishy!");
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

    @Override
    public void eatFromCan() {

    }
}
