import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import test.Zoo;
import test.configuration.AnnotationConfiguration;
import test.dto.Food;
import test.dto.FoodCan;
import test.dto.FoodType;
import test.service.ZooService;

import java.time.LocalDateTime;

public class Main {
//    public static void main(String[] args) {
//        Zoo zoo = new Zoo(new Dog(), new Cat());
//        zoo.getCat().voice();
//        zoo.getDog().voice();
//    }

    public static void main(String[] args) {
        ApplicationContext context = getAnnotationContext();
        feedAnimal(context);
    }

    public static void feedAnimal(ApplicationContext context) {
        ZooService service = context.getBean(ZooService.class);
        //FoodCan foodCan = new FoodCan();
        //Food food = new Food(FoodType.FISH, LocalDateTime.now().plusSeconds(20));
        //service.feed(foodCan.takeFood());
    }

    public static ApplicationContext getAnnotationContext() {
        return new AnnotationConfigApplicationContext(AnnotationConfiguration.class);
    }
}
