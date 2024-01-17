package cat.itacademy.barcelonactiva.camps.maya.s04.t02.n03.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.io.Serializable;

@Document(collection = "fruits")
@NoArgsConstructor
@Data
/*TODO
Not null when only changing name
No have repeated name
 */

public class Fruit implements Serializable {
    @Id
    private String id;

    @Field
    @NotNull(message = "cannot be null.")
    private String name;

    @Field
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
