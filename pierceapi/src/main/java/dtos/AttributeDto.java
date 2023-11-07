package dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AttributeDto {
    private String name;
    private String type;
    private Object value;
}
