package test.job;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import test.dto.Food;
import test.dto.FoodCan;
import test.event.ZooEventPublisher;

import java.util.Stack;

@Service
public class RefreshFoodCan {
    ZooEventPublisher zooEventPublisher;
    private FoodCan foodCan;

    @Autowired
    RefreshFoodCan(ZooEventPublisher zooEventPublisher) {
        this.zooEventPublisher = zooEventPublisher;
        this.foodCan = FoodCan.getFoodCanInstance();
    }

    @Scheduled(fixedDelay = 1000)
    public void refreshCan() {
        foodCan.addRandomFood();
    }

}
