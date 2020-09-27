package test.job;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import test.Zoo;
import test.event.ZooEventPublisher;

@Service
public class GetHungryJob {
    private Zoo zoo;
    private ZooEventPublisher zooEventPublisher;
    @Autowired
    public GetHungryJob(Zoo zoo, ZooEventPublisher zooEventPublisher) {
        this.zoo = zoo;
        this.zooEventPublisher = zooEventPublisher;
    }

    @Scheduled(fixedDelay = 5000)
    public void getCatHungry() {
        System.out.println("Getting cat hungry>>");
        if (!zoo.getCat().isHungry()) {
            zoo.getCat().setHungry();
            zooEventPublisher.publishHungryEvent("cat");
        }
    }
    @Scheduled(fixedDelay = 6000)
    public void getDogHungry() {
        System.out.println("Getting dog hungry>>");
        zoo.getDog().setHungry();
    }
}
