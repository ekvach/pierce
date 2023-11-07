package enums.products;

import lombok.Getter;

@Getter
public enum TestProductFileNames {
    SPRAY("spray.json");

    private final String name;

    TestProductFileNames(String name) {
        this.name = name;
    }
}
