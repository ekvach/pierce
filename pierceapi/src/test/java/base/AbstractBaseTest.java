package base;

import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.BeforeClass;
import utils.providers.UriProvider;

public abstract class AbstractBaseTest {
    protected RequestSpecification reqSpec;

    @BeforeClass
    public void globalSetUp() {
        reqSpec = RestAssured
                .given()
                .baseUri(UriProvider.getBaseUri());
    }
}
