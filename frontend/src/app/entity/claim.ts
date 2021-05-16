import { Product } from './Product';
import { User } from './user';
export class Claim  {
    idClaim: number;
    decision: string;
    dateClaim: Date;
    descriptionText : string;
    client:User;
    product:Product;
}