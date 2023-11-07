package products.productlist;

import base.AbstractBaseTest;
import dtos.products.ProductDetailsDto;
import dtos.products.ProductDto;
import enums.products.TestProductFileNames;
import org.apache.http.HttpStatus;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import utils.providers.TestDataProvider;
import utils.providers.UriProvider;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class ProductsListTest extends AbstractBaseTest {
    @BeforeClass
    public void setUp() {
        reqSpec.basePath(UriProvider.getProductsPath());
    }

    @Test
    public void verifyProductIsPresentInListTest() {
        ProductDetailsDto expectedProduct = TestDataProvider.getProductDetailsObj(TestProductFileNames.SPRAY);

        List<ProductDto> products = reqSpec
                .get()
                .then()
                .log()
                .ifValidationFails()
                .statusCode(HttpStatus.SC_OK)
                .extract()
                .jsonPath()
                .getList("elements", ProductDto.class);

        ProductDto actualProduct = products
                .stream()
                .filter(x -> x.getUri().endsWith(expectedProduct.getSku()))
                .findFirst()
                .orElseThrow();

        assertThat(actualProduct)
                .as("Product list should contain all the products")
                .hasFieldOrPropertyWithValue("title", expectedProduct.getProductName());
    }
}
