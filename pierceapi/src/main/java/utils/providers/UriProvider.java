package utils.providers;

import java.util.ResourceBundle;

public class UriProvider {
    private static final String URI_FILENAME = "properties/uris";

    private static final String UNSECURE_PROTOCOL_PREFIX = "http://";

    private UriProvider() {
        throw new IllegalStateException("Utility class");
    }

    public static String getBaseUri() {
        ResourceBundle rb = ResourceBundle.getBundle(URI_FILENAME);

        return String.format("%s%s", UNSECURE_PROTOCOL_PREFIX, rb.getString("URI_BASE"));
    }

    public static String getProductsPath() {
        ResourceBundle rb = ResourceBundle.getBundle(URI_FILENAME);

        return rb.getString("PATH_PRODUCTS");
    }

    public static String getCategoriesPath() {
        ResourceBundle rb = ResourceBundle.getBundle(URI_FILENAME);

        return rb.getString("PATH_CATEGORIES");
    }

    public static String composeProductDetailsPath(String productSku) {
        return String.format("%s/%s", getProductsPath(), productSku);
    }

    public static String composeCategoryDetailsPath(String categoryName) {
        return String.format("%s/%s", getCategoriesPath(), categoryName);
    }
}
