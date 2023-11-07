package dtos.categories;

import dtos.AttributeDto;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class CategoryDto {
    private String name;
    private String type;
    private List<AttributeDto> attributes;
    private boolean hasOnlineSubCategories;
    private String online;
    private String id;
    private String uri;
}
