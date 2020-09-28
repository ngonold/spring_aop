package test.dto;

import java.time.LocalDateTime;
import java.util.Random;
import java.util.Stack;

public class FoodCan {
    private final Stack<Food> can;

    public FoodCan(Stack<Food> can) {
        this.can = can;
    }
    public void addFood(Food food) {
        can.push(food);
    }
    public Food takeFood() {
        return can.pop();
    }

    public void addRandomFood() {
        Random random = new Random();
        switch (random.nextInt(3)) {
            case 0:
                addFood(new Food(FoodType.FISH, LocalDateTime.now().plusSeconds(random.nextInt())));
                break;
            case 1:
                addFood(new Food(FoodType.BONE, LocalDateTime.now().plusSeconds(random.nextInt())));
                break;
            case 2:
                addFood(new Food(FoodType.WORM, LocalDateTime.now().plusSeconds(random.nextInt())));
                break;
            default:
                addFood(new Food(FoodType.FISH, LocalDateTime.now().plusSeconds(5)));
                break;
        }
    }
}
