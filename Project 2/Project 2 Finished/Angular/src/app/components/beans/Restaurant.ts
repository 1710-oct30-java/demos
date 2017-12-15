import { Review } from './Review';

export class Restaurant {

    restaruantId: number;
    streetAddress: string;
    name: string;
    city: string;
    state: string;
    zipCode: string;
    picture: Blob;
    ownerId: number;
    culture: string;
    reviews: Array<Review>;
    // constructor() {
    // }

    public static isNull(rest: Restaurant): boolean {
        return rest.restaruantId === null;
    }

}
