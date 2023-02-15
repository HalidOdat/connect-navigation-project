import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppComponent } from './app.component';
import { MapComponent } from './map/map.component';
import { ControlsComponent } from './controls/controls.component';
import { FeatureButtomComponent } from './feature-buttom/feature-buttom.component';
import { CoffeeShopRepository, GasStationRepository, HotelRepository, RestaurantRepository, SuperMarketRepository } from 'src/repository/repositories';

@NgModule({
  declarations: [
    AppComponent,
    MapComponent,
    ControlsComponent,
    FeatureButtomComponent
  ],
  imports: [
    BrowserModule
  ],
  providers: [
    CoffeeShopRepository,
    SuperMarketRepository,
    GasStationRepository,
    HotelRepository,
    RestaurantRepository,
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
