package enums.categories;

import lombok.Getter;

@Getter
public enum TestCategoryFileNames {
    NO_DISCOUNT("nodiscount.json");

    private final String name;

    TestCategoryFileNames(String name) {
        this.name = name;
    }
}
