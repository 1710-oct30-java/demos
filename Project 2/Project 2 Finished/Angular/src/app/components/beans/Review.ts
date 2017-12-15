export class Review {

    review_id: number;
    rating: number;
    picture: Blob;
    comment: String;

    constructor() {
    }

    public static isNull(review: Review): boolean {
        return review.review_id === 0;
    }

}
