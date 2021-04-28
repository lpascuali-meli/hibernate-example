package meli.bootcamp.hibernate.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DentistDto {
    private Long id;
    private String name;
    private String lastname;
}
