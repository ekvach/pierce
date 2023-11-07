package dtos.products;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductImageDto {
    private String name;
    private String type;
    private String effectiveUrl;
    private String viewID;
    private String typeID;
    private boolean primaryImage;
}
