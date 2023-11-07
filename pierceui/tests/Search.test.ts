import { expect, test } from '@playwright/test';
import { UriProvider } from '../providers/UriProvider';
import { HomePage } from '../pages/HomePage';
import { SearchResultsPage } from '../pages/SearchResultsPage';
import { ProductDetailsPage } from '../pages/ProductDetailsPage';
import { ProductCardDto } from '../dtos/ProductCardDto';
import { CartPage } from '../pages/CartPage';

test.beforeEach(async ({ page }) => {
    await page.goto(UriProvider.baseUri);
});

test('Verify Product can be added to the Cart', async ({ page }) => {
    const productName = 'Raven Edge Charge MX Goggles Blue Mirror';

    const homePage = new HomePage(page);

    await homePage.headerSearchInput.fill(productName);
    await homePage.searchAutocompleteLink
        .filter({ hasText: new RegExp(productName.toLowerCase() + '$') })
        .click();

    await new SearchResultsPage(page).productContainer.filter({ hasText: productName }).click();

    const productDetailsPage = new ProductDetailsPage(page);

    const expectedProduct: ProductCardDto = {
        name: productName,
        price: (<string>await productDetailsPage.productPrice.textContent()).trim()
    };

    await productDetailsPage.addToCartButton.click();
    await productDetailsPage.continueShoppingButton.click({ timeout: 30 * 1000 });
    await productDetailsPage.headerCartButton.click();

    const cartPage = new CartPage(page);

    const actualProduct: ProductCardDto = {
        name: (<string>await cartPage.checkoutItemTitle.textContent()).trim(),
        price: (<string>await cartPage.checkoutItemPrice.textContent()).trim(),
    }

    expect(actualProduct, `'${productName}' should be properly added to the cart`)
        .toEqual(expectedProduct);
});

test.afterEach(async ({ page }) => {
    await page.close();
});