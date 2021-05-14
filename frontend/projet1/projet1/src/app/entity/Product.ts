import { StockDetail } from "./StockDetail";

export class Product{
    id: number;
    price: number;
    name: string;
    description : string;
    quantity : number;
    category : string;
    image : string;
    stockDetail : StockDetail;
}