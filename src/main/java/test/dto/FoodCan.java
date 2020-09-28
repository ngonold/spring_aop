package test.dto;

import java.time.LocalDateTime;
import java.util.EmptyStackException;
import java.util.Random;
import java.util.Stack;

/**
 * try to make a singleton Oo
 */
public class FoodCan {
    private static FoodCan foodCanInstance;
    private final Stack<Food> can;

    private FoodCan(Stack<Food> can) {
        this.can = can;
    }

    public static FoodCan getFoodCanInstance() {
        if (foodCanInstance == null)
            foodCanInstance = new FoodCan(new Stack<Food>());
        return foodCanInstance;
    }

    public void addFood(Food food) {
        can.push(food);
    }
    public Food takeFood() {
        try {
            return can.pop();
        }
        catch (EmptyStackException exception) {
           exception.getStackTrace();
        }
        return null;
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
