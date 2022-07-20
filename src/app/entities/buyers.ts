import {Districts} from "./districts";
import {BuyerDistricts} from "./buyerDistricts";

export interface Buyers{
  "id": number,
  "buyerName": string,
  "buyerPhone": string,
  "buyerDistricts": BuyerDistricts
  "houseAreaGTE": number,
  "houseAreaLTE": number,
  "maxPrice": number,
  "buyerFilters": number
}
