import { Injectable } from '@angular/core';

const ServerLocation = 'https://connect-navigation.azurewebsites.net/api/v2/features/';

@Injectable()
export class CoffeeShopRepository {
  async all() {
    const resp = await fetch(ServerLocation + 'coffee-shops/all');
    const data = await resp.json();
    return data;
  }
}

@Injectable()
export class GasStationRepository {
  async all() {
    const resp = await fetch(ServerLocation + 'gas-stations/all');
    const data = await resp.json();
    return data;
  }
}

@Injectable()
export class HotelRepository {
  async all() {
    const resp = await fetch(ServerLocation + 'hotels/all');
    const data = await resp.json();
    return data;
  }
}

@Injectable()
export class SuperMarketRepository {
  async all() {
    const resp = await fetch(ServerLocation + 'super-markets/all');
    const data = await resp.json();
    return data;
  }
}

@Injectable()
export class RestaurantRepository {
  async all() {
    const resp = await fetch(ServerLocation + 'restaurants/all');
    const data = await resp.json();
    return data;
  }
}

