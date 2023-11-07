import { Page } from '@playwright/test';

export abstract class BasePage {
    protected page: Page;

    constructor(parent: Page) {
        this.page = parent;
    }

    get headerCartButton() {
        return this.page.locator("//div[contains(@class,'header-cart')]");
    }

    get headerSearchInput() {
        return this.page.locator("//input[@id='search-desktop']");
    }

    get searchAutocompleteLink() {
        return this.page.locator("//a[@class='autocomplete-item']");
    }

    get productContainer() {
        return this.page.locator('//p-productcard[./a]');
    }

    get productCardPrice() {
        return this.page.locator("//div[contains(@class,'product-price')]/span[1]");
    }

    get productCardTitle() {
        return this.page.locator("//div[contains(@class,'card-info__title')]/span");
    }
}