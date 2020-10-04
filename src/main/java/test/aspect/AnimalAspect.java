package test.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import test.dto.Food;
import test.dto.FoodType;

import java.time.LocalDateTime;
import java.util.Objects;

@Aspect
@Component
public class AnimalAspect {

    @Pointcut("execution(* test.Animal.eat(..))")
    public void eatPoint() {
    }

    @Pointcut("within(test.Fish)")
    public void fishPoint() {
    }
    @Pointcut("within(test.Dog)")
    public void dogPoint() {
    }
    @Pointcut("within(test.Cat)")
    public void catPoint() {
    }

    @Before(value = "eatPoint() && args(food)")
    public void beforeEat(JoinPoint joinPoint, Food food) {
        System.out.println("start eat");
        String animalType = joinPoint.getTarget().getClass().getName();
        if (food.isFresh()) {
            switch (animalType) {
                case "test.Cat":
                    if (!food.getFoodType().equals(FoodType.FISH)) {
                        System.out.println("Cat: not Okay!");
                        food.setWrong();
                    }
                    break;
                case  "test.Dog":
                    if (!food.getFoodType().equals(FoodType.BONE)) {
                        System.out.println("Dog: not Okay!");
                        food.setWrong();
                    }
                    break;
                case "test.Fish":
                    if (!food.getFoodType().equals(FoodType.WORM)) {
                        System.out.println("Fish: not Okay!");
                        food.setWrong();
                    }
                    break;
            }
        } else {
            System.out.println("It stinks!");
        }

    }

    @After(value = "eatPoint()")
    public void afterEat() {
//        System.out.println("end eat");
    }

    @AfterThrowing(value = "eatPoint()", throwing = "ex")
    public void eatFailed(Throwable ex) {
//        System.out.println("eat failed: " + ex.getMessage());
        System.out.println("the can is empty! no food");
    }

    @AfterReturning(value = "eatPoint()")
    public void eatSuccess(JoinPoint joinPoint) {
//        System.out.println("eat success");
    }

    @Around(value = "eatPoint() && args(food) && !fishPoint()")
    public Object eatAround(ProceedingJoinPoint proceedingJoinPoint, Food food) throws Throwable {
        String target = proceedingJoinPoint.getTarget().getClass().toString();
        if (LocalDateTime.now().isAfter(food.getExpirationDate())){
            return false;
        }
        System.out.println(target + " start eat");
        try {
            Object result = proceedingJoinPoint.proceed();
//            System.out.println(target + " eat success");
//            System.out.println(target + " end eat");
            return result;
        } catch (Throwable e) {
//            System.out.println(target + " eat failed: " + e.getMessage());
            throw e;
        }
    }

    @Around(value = "eatPoint() && args(food) && fishPoint()")
    public Object validateEatForFish(ProceedingJoinPoint proceedingJoinPoint, Food food) throws Throwable {
        if (Objects.equals(food.getFoodType(), FoodType.WORM)) {
            return false;
        } else {
            return eatAround(proceedingJoinPoint, food);
        }
    }
    @Around(value = "eatPoint() && args(food) && catPoint()")
    public Object validateEatForCat(ProceedingJoinPoint proceedingJoinPoint, Food food) throws Throwable {
        if (Objects.equals(food.getFoodType(), FoodType.FISH)) {
            return false;
        } else {
            return eatAround(proceedingJoinPoint, food);
        }
    }

    @Around(value = "eatPoint() && args(food) && dogPoint()")
    public Object validateEatForDog(ProceedingJoinPoint proceedingJoinPoint, Food food) throws Throwable {
        if (Objects.equals(food.getFoodType(), FoodType.BONE)) {
            return false;
        } else {
            return eatAround(proceedingJoinPoint, food);
        }
    }
}
