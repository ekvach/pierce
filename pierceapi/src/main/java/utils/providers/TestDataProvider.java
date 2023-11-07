package utils.providers;

import com.fasterxml.jackson.databind.ObjectMapper;
import dtos.categories.CategoryDetailsDto;
import dtos.products.ProductDetailsDto;
import enums.categories.TestCategoryFileNames;
import enums.products.TestProductFileNames;

import java.io.File;
import java.net.URL;
import java.util.Objects;

public class TestDataProvider {
    private static final String PRODUCT_PATH_PREFIX = "expecteddata/products/";
    private static final String CATEGORIES_PATH_PREFIX = "expecteddata/categories/";

    private static final ObjectMapper mapper = new ObjectMapper();
    private static final ClassLoader classLoader = Thread.currentThread().getContextClassLoader();

    private TestDataProvider() {
        throw new IllegalStateException("Utility class");
    }

    public static ProductDetailsDto getProductDetailsObj(TestProductFileNames filename) {
        URL url = classLoader.getResource(String.format("%s%s", PRODUCT_PATH_PREFIX, filename.getName()));

        Objects.requireNonNull(url, String.format("Cannot find resource file '%s'", filename));

        return mapFileToObject(new File(url.getPath()), ProductDetailsDto.class);
    }

    public static CategoryDetailsDto getCategoryDetailsObj(TestCategoryFileNames filename) {
        URL url = classLoader.getResource(String.format("%s%s", CATEGORIES_PATH_PREFIX, filename.getName()));

        Objects.requireNonNull(url, String.format("Cannot find resource file '%s'", filename));

        return mapFileToObject(new File(url.getPath()), CategoryDetailsDto.class);
    }

    private static <T> T mapFileToObject(File file, Class<T> mappedClass) {
        try {
            return mapper.readValue(file, mappedClass);
        } catch (Exception e) {
            String message = String.format("Something went wrong while parsing '%s' resource", file.getPath());
            throw new RuntimeException(message, e);
        }
    }
}
