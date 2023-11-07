import { BasePage } from './base/BasePage';

export class ProductDetailsPage extends BasePage {
    get addToCartButton() {
        return this.page.locator("//button[contains(@class,'add-to-cart')]");
    }

    get continueShoppingButton() {
        return this.page.locator("//button[contains(@class,'continue-shopping')]");
    }

    get productPrice() {
        return this.page.locator("//div[contains(@class,'m-product-pricing__price ')]");
    }
}