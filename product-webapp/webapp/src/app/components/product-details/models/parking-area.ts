export interface ParkingArea {
  id: number;
  name: string;
  pricePerHour: number;
  vehicleType: string; // Car, Bike, Both, etc.
  numberOfSpots: number;
}