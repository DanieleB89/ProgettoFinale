import { FormsModule, ReactiveFormsModule } from '@angular/forms';

import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import { PaginaprincipaleComponent } from './paginaprincipale/paginaprincipale.component';
import { ListAbstract } from 'src/model/listAbstract';
import { RestService } from 'src/model/restService';
import { ListAbstractClienti } from 'src/model/listAbstractClienti';
import { RestServiceClienti } from 'src/model/restServiceClienti';
import {  HttpClientModule } from '@angular/common/http';

import {RouterModule} from '@angular/router';
import { ContattiComponent } from './contatti/contatti.component';
import { GraficoComponent } from './grafico/grafico.component';
// Setup needed in app.module.ts
import { FusionChartsModule } from 'angular-fusioncharts';
// Load FusionCharts
import * as FusionCharts from 'fusioncharts';
// Load Charts module
import * as Charts from 'fusioncharts/fusioncharts.charts';
// Load themes
import * as FusionTheme from 'fusioncharts/themes/fusioncharts.theme.fusion';
//import { OpportunitaComponent } from './opportunita/opportunita.component';



FusionChartsModule.fcRoot(
  FusionCharts,
  Charts,
  FusionTheme
)

@NgModule({
  declarations: [
    AppComponent,
    PaginaprincipaleComponent,
    ContattiComponent,
    GraficoComponent,
    
  ],
  imports: [
    BrowserModule, HttpClientModule, BrowserModule, FormsModule, FusionChartsModule,
    RouterModule.forRoot([
      
      { path: 'Clienti', component: AppComponent},
      { path: 'Contatti', component: ContattiComponent},
      { path: 'Commerciali', component: AppComponent},
      { path: 'Grafico', component: GraficoComponent},
      { path: 'Opportunita', component: AppComponent},])

  ],
  providers: [{provide:ListAbstractClienti, useClass:RestServiceClienti},
    {provide:ListAbstract, useClass:RestService}],
  bootstrap: [PaginaprincipaleComponent]
})
export class AppModule { }
