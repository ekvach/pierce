package products.productdetails;

import base.AbstractBaseTest;
import dtos.products.ProductDetailsDto;
import enums.products.TestProductFileNames;
import org.apache.http.HttpStatus;
import org.testng.annotations.Test;
import utils.providers.TestDataProvider;
import utils.providers.UriProvider;

import static org.assertj.core.api.Assertions.assertThat;

public class ProductDetailsTest extends AbstractBaseTest {
    @Test
    public void verifyProductDetailsIsCorrectTest() {
        ProductDetailsDto expectedProduct = TestDataProvider.getProductDetailsObj(TestProductFileNames.SPRAY);

        ProductDetailsDto actualProduct = reqSpec
                .basePath(UriProvider.composeProductDetailsPath(expectedProduct.getSku()))
                .get()
                .then()
                .log()
                .ifValidationFails()
                .statusCode(HttpStatus.SC_OK)
                .extract()
                .as(ProductDetailsDto.class);

        assertThat(actualProduct)
                .as("Product details are incorrect for '%s'", expectedProduct.getProductName())
                .usingRecursiveComparison()
                .isEqualTo(expectedProduct);
    }
}