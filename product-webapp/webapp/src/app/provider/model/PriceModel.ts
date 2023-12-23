export enum SpotType {
  TwoWheeler,
  FourWheeler,
  BigVehicle,
  Handicap,
  Null,
}

export enum ChargeType {
  Hourly,
  Monthly,
  Residental,
  Yearly,
}
export interface Price {
  priceId: string;
  areaId: string;
  spotType: SpotType;
  chargeType: ChargeType;
  price: number;
  discount: number;
}
