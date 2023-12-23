export interface ParkingSpotDetails {
    parkingSpotId: string;
    parkingSpotNumber: number;
    spotType: string;
    parkingAreaId: string; // Car, Bike, Both, etc.
    occupied: boolean;
  }