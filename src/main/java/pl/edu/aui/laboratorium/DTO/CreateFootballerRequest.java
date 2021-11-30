package pl.edu.aui.laboratorium.DTO;
import lombok.*;
import pl.edu.aui.laboratorium.Entity.Coach;
import pl.edu.aui.laboratorium.Entity.Footballer;
import java.util.function.Function;

@Builder
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@ToString
@EqualsAndHashCode
@Getter
@Setter

public class CreateFootballerRequest {
    private String name;
    private String surname;
    private String position;
    private Coach coach;


    public static Function<CreateFootballerRequest, Footballer> dtoToEntityMapper(Function<Integer, Footballer> coach){
        return request -> Footballer.builder()
                .name(request.getName())
                .surname(request.getSurname())
                .position(request.getPosition())
                .coach(request.coach)
                .build();
    }
}
