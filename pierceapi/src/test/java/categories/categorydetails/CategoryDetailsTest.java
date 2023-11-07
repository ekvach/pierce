package categories.categorydetails;

import base.AbstractBaseTest;
import dtos.categories.CategoryDetailsDto;
import enums.categories.TestCategoryFileNames;
import org.apache.http.HttpStatus;
import org.testng.annotations.Test;
import utils.providers.TestDataProvider;
import utils.providers.UriProvider;

import static org.assertj.core.api.Assertions.assertThat;

public class CategoryDetailsTest extends AbstractBaseTest {
    @Test
    public void verifyCategoryDetailsIsCorrectTest() {
        CategoryDetailsDto expectedCategory = TestDataProvider.getCategoryDetailsObj(TestCategoryFileNames.NO_DISCOUNT);

        CategoryDetailsDto actualCategory = reqSpec
                .basePath(UriProvider.composeCategoryDetailsPath(expectedCategory.getId()))
                .get()
                .then()
                .log()
                .ifValidationFails()
                .statusCode(HttpStatus.SC_OK)
                .extract()
                .as(CategoryDetailsDto.class);

        assertThat(actualCategory)
                .as("Category details are incorrect for '%s'", expectedCategory.getId())
                .usingRecursiveComparison()
                .isEqualTo(expectedCategory);
    }
}