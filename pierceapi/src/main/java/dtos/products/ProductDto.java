package dtos.products;

import dtos.AttributeDto;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class ProductDto {
    private String type;
    private List<AttributeDto> attributes;
    private String uri;
    private String title;
    private String description;
}
