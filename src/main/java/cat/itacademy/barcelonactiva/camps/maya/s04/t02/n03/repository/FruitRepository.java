package cat.itacademy.barcelonactiva.camps.maya.s04.t02.n03.repository;

import cat.itacademy.barcelonactiva.camps.maya.s04.t02.n03.domain.Fruit;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface FruitRepository extends MongoRepository<Fruit, Integer> {
    Optional<Fruit> findById(String id);
    void deleteById(String id);
}
