import {Districts} from "./districts";

export interface Buyers{
  "id": number,
  "buyerName": string,
  "buyerPhone": string,
  "buyerDistricts": Districts
  "houseAreaGTE": number,
  "houseAreaLTE": number,
  "maxPrice": number,
  "buyerFilters": number
}
