import {Districts} from "./districts";

export interface Sales {
  id: number;

  sellerName: string;

  phone: string;

  sellerDistrict: Districts

  countFloors: number;

  floorNumber: number;

  houseArea: number;

  housePrice: number;
}
