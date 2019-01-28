
import { HttpClient } from "@angular/common/http";
import { Observable } from "rxjs";
import { Injectable } from "@angular/core";
import { Clienti } from "./clienti";
import { ListAbstractClienti } from "./listAbstractClienti";


@Injectable()
export class RestServiceClienti extends ListAbstractClienti {

    private clientiurl='http://localhost:8080/spring-crm-rest/api/clienti';
    private deleteUrl='';
    private getUrl='';

    constructor(private http: HttpClient) {
        super();
    }

    getAllClienti(): Observable<Clienti[]> {
        return this.http.get<Clienti[]>(this.clientiurl);
    }

    saveClienti(clienti:Clienti): Observable<Clienti> {
        return this.http.post<Clienti>(this.clientiurl,clienti);
     }

     deleteClienti(clienti: Clienti): Observable<{}> {
        this.deleteUrl=this.clientiurl + '/' + clienti.idcliente;
        return this.http.delete<Clienti>(this.deleteUrl);    
    }

    updateClienti(clienti:Clienti): Observable<Clienti> {
        return this.http.put<Clienti>(this.clientiurl,clienti);
     }

     getSingleCliente(theId:number):Observable<Clienti> {
        this.getUrl=this.clientiurl + '/' + theId;
        console.log("CHIAMO INDIRIZZO: " + this.getUrl)
        return this.http.get<Clienti>(this.getUrl);
     }

}