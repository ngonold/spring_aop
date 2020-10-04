package test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import test.dto.Food;
import test.dto.FoodCan;

import java.util.List;
import java.util.Stack;

@Component
public class Zoo {
    private final Animal dog;
    private final Animal cat;
    private final Animal fish;

    private final String name;
    private final FoodCan can;

    private final List<Animal> animals;
    @Autowired
    public Zoo(
            Animal dog,
            Animal cat,
            Animal fish,
            FoodCan can,
            @Value("${zoo.name}") String name,
            List<Animal> animals
            ) {
        this.dog = dog;
        this.cat = cat;
        this.fish = fish;
        this.name = name;
        this.can = can;
        this.animals = animals;
        //can.addRandomFood();
    }

    public Animal getDog() {
        return dog;
    }

    public Animal getCat() {
        return cat;
    }

    public Animal getFish() {
        return fish;
    }

    public Food canTakeFood() {
        return can.takeFood();
    }

    public List<Animal> getAnimals() {
        return animals;
    }

}
