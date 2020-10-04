package test.job;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import test.Zoo;
import test.event.ZooEventPublisher;

@Service
public class GetHungryJob {
    private final Zoo zoo;
    private final ZooEventPublisher zooEventPublisher;
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
        final String CAT = "cat";
        System.out.println("A cat is getting hungry>>");
        if (!zoo.getCat().isHungry()) {
            zoo.getCat().setHungry();
            zooEventPublisher.publishHungryEvent(CAT);
        }
    }

    /**
     * for now set 6 sec fixedDelay to make a Dog hungry
     */
    @Scheduled(fixedDelay = 6000)
    public void setDogHungry() {
        final String DOG = "dog";
        System.out.println("A dog is getting hungry>>");
        if (!zoo.getDog().isHungry()) {
            zoo.getDog().setHungry();
            zooEventPublisher.publishHungryEvent(DOG);
        }
    }

    /**
     * for now set 3 sec fixedDelay to make a Fish hungry
     */
    @Scheduled(fixedDelay = 3000)
    public void setFishHungry() {
        final String FISH = "fish";
        System.out.println("A fish is getting hungry>>");
        if (!zoo.getFish().isHungry()) {
            zoo.getFish().setHungry();
            zooEventPublisher.publishHungryEvent(FISH);
        }
    }
}
