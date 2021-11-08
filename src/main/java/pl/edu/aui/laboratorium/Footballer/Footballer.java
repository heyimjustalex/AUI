package pl.edu.aui.laboratorium.Footballer;
import lombok.*;
import org.springframework.stereotype.Component;
import pl.edu.aui.laboratorium.Coach.Coach;

import java.util.List;
import java.util.UUID;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor

@EqualsAndHashCode

@Component
public class Footballer
{

    private UUID id;
    private String name;
    private String surname;
    private String position;
    private Coach coach;

    public Footballer(String name, String surname, String position, Coach coach) {
        this.id = UUID.randomUUID();
        this.name = name;
        this.surname = surname;
        this.position = position;
        this.coach = coach;
    }

    @Override
    public String toString() {
        return "Footballer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", position='" + position + '\'' +
                ", coach=" + coach +
                '}';
    }
}
