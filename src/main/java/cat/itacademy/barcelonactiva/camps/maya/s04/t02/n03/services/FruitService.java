package cat.itacademy.barcelonactiva.camps.maya.s04.t02.n03.services;

import cat.itacademy.barcelonactiva.camps.maya.s04.t02.n03.domain.Fruit;

import java.util.List;

public interface FruitService {
    public List<Fruit> getAllFruits();
    public Fruit getFruit(String id);
    public void addFruit(Fruit fruit);
    public void updateFruit(String id, Fruit fruit);
    public void deleteFruit(String id);

}
