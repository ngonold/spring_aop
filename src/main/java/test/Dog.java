package test;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import test.dto.Food;

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
        isHungry = false;
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
