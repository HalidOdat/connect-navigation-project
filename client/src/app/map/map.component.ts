import { Component, OnInit } from '@angular/core';

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
  selector: 'app-map',
  template: `
    <app-controls [map]="map" [yourLocation]="yourLocation" [routes]="routes"></app-controls>
    <div id="map" class="map"></div>
  `,
  styleUrls: ['./map.component.css', '../../../node_modules/ol/ol.css']
})
export class MapComponent implements OnInit {
  public map!: Map
  public center!: number[]
  public yourLocation!: number[];
  public yourLocationFeature!: Feature;
  public routes!: object[];

  constructor() {
    // This is the center of macedonia use to align the map.
    // lon, lat
    this.center = [21.8958, 41.5363];

    // Your location on the map we initially assign it to a Skopje location.
    // lon, lat
    this.yourLocation = [21.4051544, 42.0112726];
  }

  ngOnInit(): void {
    useGeographic();

    // Point style to represent point on the map
    const homePointStyle = new Style({
      image: new Icon({
        anchor: [0.5, 0.96],
        crossOrigin: 'anonymous',
        src: 'assets/home-point.png',
        scale: 0.05,
      }),
    });

    const view = new View({
      center: this.center,
      zoom: 8.7
    });

    // Create the map.
    this.map = new Map({
      controls: defaults({ attribution: false }),
      layers: [
        new TileLayer({
          source: new OSM(),
        })
      ],
      target: 'map',
      view: view,
    });

    this.yourLocationFeature = new Feature({
      geometry: new Point(this.yourLocation),
    });

    const positionFeature = new Feature();
    positionFeature.setStyle(
      new Style({
        image: new CircleStyle({
          radius: 6,
          fill: new Fill({
            color: '#3399CC',
          }),
          stroke: new Stroke({
            color: '#fff',
            width: 2,
          }),
        }),
      })
    );

    new VectorLayer({
      map: this.map,
      source: new VectorSource({
        features: [this.yourLocationFeature],
      }),
      style: homePointStyle,
    });

    let map = this.map;
    let yourLocation = this.yourLocation;
    let yourLocationFeature = this.yourLocationFeature;

    // Clear routes on point change
    let routes: object[] = []
    this.routes = routes;
    map.on('click', function (e) {
      yourLocation[0] = e.coordinate[0];
      yourLocation[1] = e.coordinate[1];
      for (let route of routes) {
        // @ts-ignore
        map.removeLayer(route.layer);
        // @ts-ignore
        route.elem.classList.remove('selected-item');
        // @ts-ignore
        route.feature.vectorLayers = undefined;
      }
      yourLocationFeature.setGeometry(new Point(yourLocation));
    });

    // Render the map.
    map.render();
  }
}
