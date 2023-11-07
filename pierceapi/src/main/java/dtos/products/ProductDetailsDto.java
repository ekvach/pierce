package dtos.products;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class ProductDetailsDto {
    private String name;
    private String type;
    private String sku;
    private String productName;
    private String longDescription;
    private boolean availability;
    private boolean retailSet;
    private boolean productMaster;
    private boolean mastered;
    private int minOrderQuantity;
    private String productBundle;
    private String manufacturer;
    private List<ProductImageDto> images;
}
