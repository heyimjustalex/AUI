package pl.edu.aui.laboratorium.Coach;
import lombok.*;
import org.springframework.stereotype.Component;
import pl.edu.aui.laboratorium.Footballer.Footballer;

import java.util.List;
import java.util.UUID;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Component

public class Coach
{
    private UUID id;
    private String name;
    private String surname;
    private List<Footballer> footballers;

    public Coach(String name, String surname)
    {
        this.id = UUID.randomUUID();
        this.name = name;
        this.surname = surname;
    }

    @Override
    public String toString() {
        return "Coach{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                '}';
    }




}
