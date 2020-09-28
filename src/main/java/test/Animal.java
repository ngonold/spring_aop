package test;

import test.dto.Food;

public interface Animal {
    void gimmeFood();

    boolean eat(Food food);

    boolean isHungry();

    void setHungry();

    void eatFromCan();
}
