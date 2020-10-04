package test.dto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.EmptyStackException;
import java.util.Random;
import java.util.Stack;

/**
 * try to make a singleton Oo
 */
@Service
public class FoodCan {
//    private static FoodCan foodCanInstance;
    private final Stack<Food> foodCan;

    @Autowired
    public FoodCan() {
        this.foodCan = new Stack<>();
        for (int i = 0; i < 3; i++) {
            this.addRandomFood();
        }
    }

//    private FoodCan(Stack<Food> can) {
//        this.can = can;
//    }

//    public static FoodCan getFoodCanInstance() {
//        if (foodCanInstance == null)
//            foodCanInstance = new FoodCan(new Stack<Food>());
//        return foodCanInstance;
//    }

    public void addFood(Food food) {
        foodCan.push(food);
    }
    public Food takeFood() {
        try {
            return foodCan.pop();
        }
        catch (EmptyStackException exception) {
           exception.getStackTrace();
            System.out.println("No food in the can!");
            throw new EmptyStackException();
        }

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
