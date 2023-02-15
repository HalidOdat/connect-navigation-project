import { Component, Inject, Input } from '@angular/core';
import { Feature, Map } from 'ol';
import { Point } from 'ol/geom';
import LayerGroup from 'ol/layer/Group';
import Layer from 'ol/layer/Layer';
import VectorLayer from 'ol/layer/Vector';
import VectorSource from 'ol/source/Vector';
import { Style } from 'ol/style';
import { FeatureRepository } from 'src/repository/repositories';

@Component({
  selector: 'app-feature-buttom',
  template: `
    <button id="super-market-button" class="button" (click)="click($event)"><i class="fa-solid {{ icon }}"></i>&nbsp;{{ name }}</button>
  `,
  styleUrls: ['./feature-buttom.component.css']
})
export class FeatureButtomComponent {
  @Input() name!: string;
  @Input() icon!: string;
  @Input() map!: Map;
  @Input() repository!: FeatureRepository;
  @Input() pointLayer!: LayerGroup;
  @Input() pointStyle!: Style;

  private layer!: Layer;

  click(event: MouseEvent) {
    (async () => {
      let target = (event.target || event.currentTarget) as Element;
      if (target.classList.contains('selected-button')) {
        this.pointLayer.getLayers().remove(this.layer);
        target.classList.remove('selected-button');
        return;
      }
      let values = await this.repository.all();
      let features: Feature[] = [];
      for (let value of values) { // @ts-ignore
        features.push(new Feature(new Point([value.lat, value.lon])));
      }

      if (this.layer) {
        this.pointLayer.getLayers().remove(this.layer);
      }

      this.layer = new VectorLayer({
        source: new VectorSource({
          features: features,
        }),
        style: this.pointStyle
      });

      target.classList.add('selected-button');
      this.pointLayer.getLayers().push(this.layer);
      this.map.render();
    })()
  }
}
