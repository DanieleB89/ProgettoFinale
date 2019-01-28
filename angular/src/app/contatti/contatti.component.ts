import { Component, OnInit, Injectable } from '@angular/core';
import { ListAbstract } from 'src/model/listAbstract';
import { HttpClient } from '@angular/common/http';
import { RestService } from 'src/model/restService';
import { NgForm } from '@angular/forms';
import { Contatto } from 'src/model/contatto';
import { ListAbstractClienti } from 'src/model/listAbstractClienti';
import { RestServiceClienti } from 'src/model/restServiceClienti';
import { Clienti } from 'src/model/clienti';
//import { saveAs } from 'node_modules/file-saver/src/FileSaver';


@Component({
  selector: 'app-contatti',
  templateUrl: './contatti.component.html',
  styleUrls: ['./contatti.component.css']
})
export class ContattiComponent implements OnInit {

  private contatto:Contatto=new Contatto();

  service: ListAbstract;
  serviceClienti: ListAbstractClienti;//=new RestServiceClienti(http:HttpClient);
  lista: Contatto[];

  proponiForm: boolean = false;

  constructor(private http:HttpClient) {
    this.service = new RestService(http);
    this.serviceClienti = new RestServiceClienti(http);
    this.loadAll();
  }

  loadAll() {
    this.proponiForm=false;
    this.service.getAllContatti().subscribe( cs => this.onLoadAll(cs) )



  }

  onLoadAll(cs:Contatto[]) {
      this.lista = cs;
      for (let c of this.lista) {console.log(c.nome);}

      let nomecliente:string = '';
      let cliente:Clienti = new Clienti();
      let theId:number;
      for (let i=0; i<this.lista.length; i++) {
        theId = Number(this.lista[i].idcliente);
        this.serviceClienti.getSingleCliente(theId).subscribe( 
          cs => this.lista[i].idcliente = cs.ragionesociale         
          );    
      }

  }




  save(corsoForm: NgForm) {
    //console.log(corsoForm.value);
    //console.log(JSON.stringify(this.contatto));
    this.service.saveContatto(this.contatto).subscribe(
      c => this.loadAll()
    );
}

selection(item:Contatto) {
  this.contatto=item;
  this.proponiForm=true;
}

delete() {
  this.service.deleteContatto(this.contatto).subscribe( c => this.loadAll() );
}

addItem() {
  let nullContatto:Contatto = new Contatto();
  nullContatto.idcontatto = 0;
  this.contatto = nullContatto;
  this.proponiForm=true;
}


update() {
  this.service.updateContatto(this.contatto).subscribe(c => this.loadAll());
}

isClassVisibile(item:Contatto): boolean  {
  return item.idcontatto===this.contatto.idcontatto;
 }


 export(data: any) {
  const replacer = (key, value) => value === null ? '' : value; // specify how you want to handle null values here
  const header = Object.keys(data[0]);
  let csv = data.map(row => header.map(fieldName => JSON.stringify(row[fieldName], replacer)).join('\t\t'));
  csv.unshift(header.join('\t\t'));
  let csvArray = csv.join('\r\n');

  var a = document.createElement('a');
  var blob = new Blob([csvArray], {type: 'text/csv' }),
  url = window.URL.createObjectURL(blob);

  a.href = url;
  a.download = "myFile.csv";
  a.click();
  window.URL.revokeObjectURL(url);
  a.remove();

 }
  ngOnInit() {
  }

}
