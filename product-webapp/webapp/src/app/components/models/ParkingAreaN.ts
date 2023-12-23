export interface ParkingAreaN {
  areaId: string | undefined;
  parkingName: string;
  totalNoSpot: number;
  address: Address;
  providerId: number;
}
export interface Address {
  street: string;
  city: string;
  zip: number;
  state: string;
  location: {
    lat: string;
    lon: string;
  };
}