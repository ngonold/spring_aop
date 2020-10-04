package test;

import org.springframework.stereotype.Component;
import test.dto.Food;

@Component
public class Cat implements Animal {
    private boolean isHungry = false;

    @Override
    public void gimmeFood() {
        System.out.println("Meow! gimme some fish, bro!");
    }

    @Override
    public boolean eat(Food food) {
        //probably this stuff should be handled within some Aspect
        if (!food.isWrong()) {
            isHungry = false;
            System.out.println("A cat is full!");
        }
        return isHungry;
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
        //??? WRONG!
//        FoodCan foodCan = FoodCan.getFoodCanInstance();
//        eat(foodCan.takeFood());
    }
}
