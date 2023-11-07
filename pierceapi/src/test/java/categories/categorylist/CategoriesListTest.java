package categories.categorylist;

import base.AbstractBaseTest;
import dtos.categories.CategoryDetailsDto;
import dtos.categories.CategoryDto;
import enums.categories.TestCategoryFileNames;
import org.apache.http.HttpStatus;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import utils.providers.TestDataProvider;
import utils.providers.UriProvider;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class CategoriesListTest extends AbstractBaseTest {
    @BeforeClass
    public void setUp() {
        reqSpec.basePath(UriProvider.getCategoriesPath());
    }

    @Test
    public void verifyCategoryIsPresentInListTest() {
        CategoryDetailsDto categoryDetails = TestDataProvider.getCategoryDetailsObj(TestCategoryFileNames.NO_DISCOUNT);

        List<CategoryDto> categories = reqSpec
                .get()
                .then()
                .log()
                .ifValidationFails()
                .statusCode(HttpStatus.SC_OK)
                .extract()
                .jsonPath()
                .getList("elements", CategoryDto.class);

        CategoryDto actualCategory = categories
                .stream()
                .filter(x -> x.getUri().endsWith(categoryDetails.getId()))
                .findFirst()
                .orElseThrow();

        assertThat(actualCategory)
                .as("Categories list should contain all the categories")
                .hasFieldOrPropertyWithValue("type", categoryDetails.getType())
                .hasFieldOrPropertyWithValue("id", categoryDetails.getId());
    }
}
