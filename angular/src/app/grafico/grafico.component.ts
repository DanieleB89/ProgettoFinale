import { Component, Injectable, NgZone } from '@angular/core';
import { Corso } from 'src/model/corso';
import { ListAbstract } from 'src/model/listAbstract';
import { HttpClient } from '@angular/common/http';
import { RestService } from 'src/model/restService';
import { NgForm } from '@angular/forms';

@Component({
  selector: 'app-grafico',
  templateUrl: './grafico.component.html',
  styleUrls: ['./grafico.component.css']
})
export class GraficoComponent {

  dataSource: any;
  private gigi:number =30000;
  constructor(private zone: NgZone) {
    this.dataSource = {
      "chart": {
        "caption": "Bakersfield Central - Total footfalls",
        "subCaption": "Last week",
        "xAxisName": "Day",
        "yAxisName": "No. of Visitors (In 1000s)",
        "showValues": "0",
        "theme": "fusion"
      },
      "annotations": {
        "groups": [{
          "id": "anchor-highlight",
          "items": [{
              "id": "high-star",
              "type": "circle",
              "x": "$dataset.0.set.2.x",
              "y": "$dataset.0.set.2.y",
              "radius": "12",
              "color": "#6baa01",
              "border": "2",
              "borderColor": "#f8bd19"
            },
            {
              "id": "label",
              "type": "text",
              "text": "Highest footfall 25.5K",
              "fillcolor": "#6baa01",
              "rotate": "90",
              "x": "$dataset.0.set.2.x+75",
              "y": "$dataset.0.set.2.y-2"
            }
          ]
        }]
      },
      "data": [{
          "label": "Mon",
          "value": "15320"
        },
        {
          "label": "Tue",
          "value": "14233"
        },
        {
          "label": "Wed",
          "value": "25507"
        },
        {
          "label": "Thu",
          "value": "9110"
        },
        {
          "label": "Fri",
          "value": "15529"
        },
        {
          "label": "Sat",
          "value": "20803"
        },
        {
          "label": "Sun",
          "value": "19202"
        }
      ]
    }



}
}
