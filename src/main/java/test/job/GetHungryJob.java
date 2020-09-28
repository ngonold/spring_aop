package test.job;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import test.Zoo;
import test.event.ZooEventPublisher;

@Service
public class GetHungryJob {
    private final Zoo zoo;
    private ZooEventPublisher zooEventPublisher;
    @Autowired
    public GetHungryJob(Zoo zoo, ZooEventPublisher zooEventPublisher) {
        this.zoo = zoo;
        this.zooEventPublisher = zooEventPublisher;
    }

    /**
     * for now set 5 sec fixedDelay to make a Cat hungry
     */
    @Scheduled(fixedDelay = 5000)
    public void setCatHungry() {
        System.out.println("Getting cat hungry>>");
        if (!zoo.getCat().isHungry()) {
            zoo.getCat().setHungry();
            zooEventPublisher.publishHungryEvent("cat");
        }
    }

    /**
     * for now set 6 sec fixedDelay to make a Dog hungry
     */
    @Scheduled(fixedDelay = 6000)
    public void setDogHungry() {
        System.out.println("Getting dog hungry>>");
        if (!zoo.getDog().isHungry()) {
            zoo.getDog().setHungry();
            zooEventPublisher.publishHungryEvent("dog");
        }
    }

    /**
     * for now set 3 sec fixedDelay to make a Fish hungry
     */
    @Scheduled(fixedDelay = 3000)
    public void setFishHungry() {
        System.out.println("Getting fish hungry>>");
        if (!zoo.getFish().isHungry()) {
            zoo.getFish().setHungry();
            zooEventPublisher.publishHungryEvent("fish");
        }
    }
}
