export class UriProvider {
    private static HTTP_PROTOCOL = 'https://';

    private static uris = require('../properties/uris.json');

    static get baseUri() {
        return this.HTTP_PROTOCOL + this.uris.baseUri
    }
}