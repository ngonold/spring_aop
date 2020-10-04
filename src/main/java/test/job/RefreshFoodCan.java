package test.job;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import test.dto.FoodCan;


@Service
public class RefreshFoodCan {
    private final FoodCan foodCan;

    @Autowired
    RefreshFoodCan(FoodCan foodCan) {
        this.foodCan = foodCan;
    }

    @Scheduled(fixedDelay = 1000)
    public void refreshCan() {
        foodCan.addRandomFood();
    }

}
