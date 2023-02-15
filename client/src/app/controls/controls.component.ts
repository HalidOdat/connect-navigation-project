import { Component, Inject, Input } from '@angular/core';

import Map from 'ol/Map';
import View from 'ol/View';
import { OSM } from 'ol/source';
import TileLayer from 'ol/layer/Tile';
import {useGeographic} from 'ol/proj';
import {LineString, Point} from "ol/geom";
import VectorSource from "ol/source/Vector";
import VectorLayer from "ol/layer/Vector";
import {Feature, VectorTile} from "ol";
import {
  CoffeeShopRepository,
  GasStationRepository,
  HotelRepository, RestaurantRepository,
  SuperMarketRepository
} from "../../repository/repositories";
import {Fill, Icon, Stroke, Style, Text} from "ol/style";
import {Size} from "ol/size";
import CircleStyle from "ol/style/Circle";
import {RouteRepository} from "../../repository/route";
import LayerGroup from "ol/layer/Group";
import {defaults} from "ol/control"

@Component({
  selector: 'app-controls',
  template: `
    <div id="control-panel">
    <div>
        <div id="search-box">
        <div>
            <input id="search-input" type="text" placeholder="Search...">

        <div id="search-results" hidden="true">
        </div>
        </div>
        <button id="search-button" class="button"><i class="fa-solid fa-magnifying-glass"></i></button>
        </div>
    </div>

    <app-feature-buttom [name]="'Coffee Shops'" [icon]="'fa-mug-hot'" [map]="map" [pointLayer]="pointLayer" [pointStyle]="pointStyle" [repository]="coffeeShopRepository"></app-feature-buttom>
    <app-feature-buttom [name]="'Gas Stations'" [icon]="'fa-gas-pump'" [map]="map" [pointLayer]="pointLayer" [pointStyle]="pointStyle" [repository]="gasStationRepository"></app-feature-buttom>
    <app-feature-buttom [name]="'Hotels'" [icon]="'fa-bed'" [map]="map" [pointLayer]="pointLayer" [pointStyle]="pointStyle" [repository]="hotelRepository"></app-feature-buttom>
    <app-feature-buttom [name]="'Restaurants'" [icon]="'fa-utensils'" [map]="map" [pointLayer]="pointLayer" [pointStyle]="pointStyle" [repository]="restaurantRepsoitory"></app-feature-buttom>
    <app-feature-buttom [name]="'Super Markets'" [icon]="'fa-cart-shopping'" [map]="map" [pointLayer]="pointLayer" [pointStyle]="pointStyle" [repository]="superMarketRepository"></app-feature-buttom>
    </div>
  `,
  styleUrls: ['./controls.component.css']
})
export class ControlsComponent {

  @Input() map!: Map;
  @Input() yourLocation!: number[];
  @Input() routes!: object[];

  pointLayer!: LayerGroup;
  pointStyle!: Style;

  constructor(
    public coffeeShopRepository: CoffeeShopRepository,
    public superMarketRepository: SuperMarketRepository,
    public gasStationRepository: GasStationRepository,
    public hotelRepository: HotelRepository,
    public restaurantRepsoitory: RestaurantRepository,
  ) {}

  ngOnInit() {
    const pointStyle = new Style({
      image: new Icon({
        anchor: [0.5, 0.96],
        crossOrigin: 'anonymous',
        src: 'assets/icon.png',
        scale: 0.05,
      }),
    });
    this.pointStyle = pointStyle;

    // All the route layer goes here, like the line from one place to another.
    const routeLayer = new LayerGroup({
      layers: []
    });

    // All the points go in this layer
    const pointLayer = new LayerGroup({
      layers: []
    });
    this.pointLayer = pointLayer;

    // Special layer for selected points,
    // could be merged into pointLayer.
    const selectedLayer = new LayerGroup({
      layers: []
    });

    this.map.addLayer(routeLayer);
    this.map.addLayer(pointLayer);
    this.map.addLayer(selectedLayer);

    let map = this.map;
    let yourLocation = this.yourLocation;

    let routes = this.routes;

    // Helper function used to get the route between two points
    async function getRouteLayer(from: number[], to: number[], color: number[] = [100, 200, 255, 0.8]) {
      let route = await new RouteRepository().route(from[0], from[1], to[1], to[0]);
      // have to reverse the coords because OpenLayers expects [lon, lat] format
      let distance = route.distance;
      route = route.points.map((x: { lat: any; lon: any; }) => [x.lon, x.lat]);

      let polyline = new LineString(route);
      const routeFeature = new Feature({
        type: 'route',
        geometry: polyline,
      });

      routeFeature.setStyle(
        new Style({
          fill: new Fill({ color: color }),
          stroke: new Stroke({ color: color, width: 3 }),
          text: new Text({
            text: `${ (distance / 1000).toFixed(2) } km`,
            font: '18px "Roboto", Helvetica Neue, Helvetica, Arial, sans-serif',
            fill: new Fill({ color: 'black' }),
            scale: 0.7,
          })
        })
      );

      const vectorLayer = new VectorLayer({
        source: new VectorSource({
          // @ts-ignore
          features: [routeFeature],
        }),
        style: new Style({
          stroke: new Stroke({
            width: 5,
            color: color,
          }),
        }),
      });

      return vectorLayer
    }

    // @ts-ignore
    let input: HTMLInputElement = document.getElementById("search-input");
    // @ts-ignore
    let results: HTMLElement = document.getElementById('search-results');

    let features: object = {};
    let keys: string[] = [];
    // Gets all the location, this is used for search.
    async function get() {
      let coffeeShops = new CoffeeShopRepository().all();
      let gasStations = new GasStationRepository().all();
      let hotels = new HotelRepository().all();
      let restaurants = new RestaurantRepository().all();
      let superMarkets =  new SuperMarketRepository().all();

      for (let value of await coffeeShops) {
        let key = `${value.city} - Coffee Shop - "${value.name}"`;
        // @ts-ignore
        features[key] = value;
        keys.push(key);
      }
      for (let value of await gasStations) {// @ts-ignore
        let key = `${value.city} - Gas Station - "${value.name}"`;
        // @ts-ignore
        features[key] = value;
        keys.push(key);
      }
      // @ts-ignore
      let hotelsSorted = (await hotels).sort((a: object, b: object) => (b.stars - a.stars));
      for (let value of hotelsSorted) {// @ts-ignore
        let key = `${value.city} - Hotel - "${value.name}"`;
        // @ts-ignore
        features[key] = value;
        keys.push(key);
      }
      // @ts-ignore
      let restaurantsSorted = (await restaurants).sort((a: object, b: object) => (b.stars - a.stars));
      for (let value of restaurantsSorted) {// @ts-ignore
        let key = `${value.city} - Restaurant - "${value.name}"`;
        // @ts-ignore
        features[key] = value;
        keys.push(key);
      }
      for (let value of await superMarkets) {// @ts-ignore
        let key = `${value.city} - Super Market - "${value.name}"`;
        // @ts-ignore
        features[key] = value;
        keys.push(key);
      }
    }

    // Add a listener that is executed on key event. This is for search
    input.addEventListener('keyup', function () {
      let value =  input.value.toLowerCase();
      if (value === '') {
        results.setAttribute('hidden', 'true');
      } else {
        results.removeAttribute('hidden');
      }
      results.innerHTML = '';
      let count = 0;
      for (let key of keys) {
        if (count > 6) {
          break;
        }
        if (!key.toLowerCase().includes(value)) {
          continue;
        }
        let elem = document.createElement('p');
        // @ts-ignore
        elem.innerHTML = key;
        elem.classList.add('search-result-item');

        // @ts-ignore
        let stars = features[key].stars;
        if (stars != undefined) {
          let starsContainer = document.createElement('span');
          starsContainer.style.textAlign = 'right';
          let star = document.createElement('i');
          star.classList.add('fa-solid');
          star.classList.add('fa-star');
          star.style.color = 'yellow';
          let counter = document.createElement('span');
          counter.innerHTML = `x ${stars}`;
          starsContainer.appendChild(star);
          starsContainer.appendChild(counter);
          elem.appendChild(starsContainer);
        }

        // @ts-ignore
        if (features[key].vectorLayers) {
          elem.classList.add('selected-item');
        }

        elem.onclick = function() {
          if (!yourLocation) {
            return;
          }

          elem.classList.toggle('selected-item');

          // @ts-ignore
          let coords = [features[key].lat, features[key].lon];
          let pointFeature = new Feature(new Point(coords));
          const vectorLayer = new VectorLayer({
            source: new VectorSource({
              // @ts-ignore
              features: [pointFeature],
            }),
            style: pointStyle,
          });

          // @ts-ignore
          let layers = features[key].vectorLayers;
          if (layers) {
            // @ts-ignore
            for (let layer of layers) {
              map.removeLayer(layer);
              // @ts-ignore
              routes = routes.filter(x => x.layer != layer);
            }

            // @ts-ignore
            features[key].vectorLayers = undefined;
            return;
          }

          try {
            getRouteLayer(yourLocation.map(x => x).reverse(), coords)
              .then(layer => {
                // @ts-ignore
                features[key].vectorLayers = [layer, vectorLayer];
                // @ts-ignore
                layers = features[key].vectorLayers;
                // @ts-ignore
                for (let layer of layers) {
                  map.addLayer(layer);
                  // @ts-ignore
                  routes.push({layer:layer, coords: coords, feature: features[key], elem: elem});
                }
                // Do nothing if route is not possble
              });
          } catch (e) {
            // Do nothing if route is not possible
            elem.classList.toggle('selected-item');
          }
        }

        results.appendChild(elem);
        count++;
      }
    });

    get();
  }
}
