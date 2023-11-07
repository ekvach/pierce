import { BasePage } from './base/BasePage';

export class CartPage extends BasePage {
    get checkoutItemsList() {
        return this.page.locator('//p-product-line-items');
    }

    get checkoutItemPrice() {
        return this.checkoutItemsList.locator("//span[contains(@class,'actual-price')]");
    }

    get checkoutItemTitle() {
        return this.checkoutItemsList.locator("//span[contains(@class,'item-name')]");
    }
}