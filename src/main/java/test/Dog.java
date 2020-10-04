package test;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import test.dto.Food;
import test.dto.FoodType;

import static org.springframework.beans.factory.config.BeanDefinition.SCOPE_PROTOTYPE;

@Component
@Scope(value = SCOPE_PROTOTYPE)
public class Dog implements Animal {
    private boolean isHungry = true;

    public void gimmeFood() {
        System.out.println("I'm a hungry angry beast! Wanna eat!");
    }

    @Override
    public boolean eat(Food food) {
        if (!food.isWrong()) {
            isHungry = false;
            System.out.println("A dog is full!");
        }
        else
            System.out.println("Bad food for doggy!");
        return isHungry();
    }

    @Override
    public boolean isHungry() {
        return false;
    }

    @Override
    public void setHungry() {
        isHungry = true;
    }

    @Override
    public void eatFromCan() {

    }
}
