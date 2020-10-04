package test.event;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;
import test.Zoo;

@Service
public class EventService {
    public Zoo zoo;
    @Autowired
    EventService(Zoo zoo) {
        this.zoo = zoo;
    }
    @EventListener(ZooEvent.class)
    public void onApplicationEvent(ZooEvent zooEvent) {
        final String CAT = "cat";
        final String DOG = "dog";
        final String FISH = "fish";
        System.out.println(zooEvent.getMessage());
        String eventMsg = zooEvent.getMessage();
        switch (eventMsg) {
            case CAT:
                zoo.getCat().gimmeFood();
                break;
            case DOG:
                zoo.getDog().gimmeFood();
                break;
            case FISH:
                zoo.getFish().gimmeFood();
            default:
                break;
        }
        //give the food to each
        zoo.getAnimals().forEach(animal -> animal.eat(zoo.canTakeFood()));
    }
}
