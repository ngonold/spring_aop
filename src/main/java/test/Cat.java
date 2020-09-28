package test;

import org.springframework.stereotype.Component;
import test.dto.Food;
import test.dto.FoodCan;
import test.dto.FoodType;

@Component
public class Cat implements Animal {
    private boolean isHungry = false;

    @Override
    public void gimmeFood() {
        System.out.println("Meow! gimme some fish, bro!");
        eatFromCan();
    }

    @Override
    public boolean eat(Food food) {
        //probably this stuff should be handled within some Aspect
        if (food.getFoodType() == FoodType.FISH && food.isFresh()) {
            isHungry = false;
            System.out.println("A cat is full!");
        }
        else
            System.out.println("Bad food for kitten!");
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
        FoodCan foodCan = FoodCan.getFoodCanInstance();
        eat(foodCan.takeFood());
    }
}
