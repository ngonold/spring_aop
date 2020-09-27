package test.event;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;
import test.Zoo;

@Service
public class EventService {
    Zoo zoo;
    @Autowired
    EventService(Zoo zoo) {
        this.zoo = zoo;
    }
    @EventListener(ZooEvent.class)
    public void onApplicationEvent(ZooEvent zooEvent) {
        System.out.println(zooEvent.getMessage());
        String eventMsg = zooEvent.getMessage();
        switch (eventMsg) {
            case "cat":
                zoo.getCat().gimmeFood();
                break;
            case "dog":
                zoo.getDog().gimmeFood();
                break;
            case "fish":
                zoo.getFish().gimmeFood();
            default:
                break;
        }
    }
}
