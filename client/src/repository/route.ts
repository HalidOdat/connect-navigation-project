import { Injectable } from '@angular/core';
import { Point } from "ol/geom";

const ServerLocation = 'https://connect-navigation.azurewebsites.net/api/v2/';

@Injectable()
export class RouteRepository {
  async route(fromLat: number, fromLon: number, toLat: number, toLon: number) {
    const resp = await fetch(ServerLocation + `/route/${fromLat}/${fromLon}/${toLat}/${toLon}`);
    const data = await resp.json();
    return data;
  }
}
