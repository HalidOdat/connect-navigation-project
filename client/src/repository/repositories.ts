import { Injectable } from '@angular/core';

const ServerLocation = 'https://connect-navigation.azurewebsites.net/api/v2/features/';

export interface FeatureRepository {
  all(): Promise<object[]>;
}

@Injectable()
export class CoffeeShopRepository implements FeatureRepository {
  async all() {
    const resp = await fetch(ServerLocation + 'coffee-shops/all');
    const data = await resp.json();
    return data;
  }
}

@Injectable()
export class GasStationRepository implements FeatureRepository {
  async all() {
    const resp = await fetch(ServerLocation + 'gas-stations/all');
    const data = await resp.json();
    return data;
  }
}

@Injectable()
export class HotelRepository implements FeatureRepository {
  async all() {
    const resp = await fetch(ServerLocation + 'hotels/all');
    const data = await resp.json();
    return data;
  }
}

@Injectable()
export class SuperMarketRepository implements FeatureRepository {
  async all() {
    const resp = await fetch(ServerLocation + 'super-markets/all');
    const data = await resp.json();
    return data;
  }
}

@Injectable()
export class RestaurantRepository implements FeatureRepository {
  async all() {
    const resp = await fetch(ServerLocation + 'restaurants/all');
    const data = await resp.json();
    return data;
  }
}

