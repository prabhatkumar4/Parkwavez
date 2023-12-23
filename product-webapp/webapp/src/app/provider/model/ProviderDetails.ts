export enum Role {
  USER = 'USER',
  ADMIN = 'ADMIN',
  PROVIDER = 'PROVIDER',
}

export interface Address {
  street: string;
  city: string;
  zip: number;
  state: string;
}

export interface ProviderDetails {
  userId: string;
  userName: string;
  email: string;
  role: Role;
  address: Address;
  image: any;
}
