package dtos.categories;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class CategoryDetailsDto {
    private String type;
    private boolean hasOnlineSubCategories;
    private String online;
    private int subCategoriesCount;
    private String id;
    private List<SubCategoryDetailsDto> subCategories;
    private String canonicalName;
}
