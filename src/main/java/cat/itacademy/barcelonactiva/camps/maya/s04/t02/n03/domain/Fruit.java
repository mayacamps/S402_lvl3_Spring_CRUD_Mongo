package cat.itacademy.barcelonactiva.camps.maya.s04.t02.n03.domain;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Min;
import lombok.*;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.annotation.Id;

@Data
@NoArgsConstructor
@Document(collection = "fruits")
public class Fruit{
    @Id
    private String id;

    @Indexed(unique = true)
    @NotEmpty(message = "cannot be null.")
    private String name;

    @NotNull(message = "cannot be null.")
    @Min(value = 0, message =  "cannot be negative.")
    private Integer quantKilos;

    public Fruit(String name, int quantKilos) {
        this.name = name;
        this.quantKilos = quantKilos;
    }

    @Override
    public String toString(){
        return "Fruit:\n\t[id=" + id + ", \n\tname=" + name + ", \n\tquantity(kg)=" + quantKilos + "]\n";
    }
}
