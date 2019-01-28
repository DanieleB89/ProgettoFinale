import { ListAbstract } from "./listAbstract"
import { HttpClient } from "@angular/common/http";
import { Observable } from "rxjs";
import { Contatto } from "./contatto";
import { Injectable } from "@angular/core";


@Injectable()
export class RestService extends ListAbstract {


    private contattiurl = 'http://localhost:8080/spring-crm-rest/api/contatti';
    private deleteUrl = '';

    constructor(private http: HttpClient) {
        super();
    }

    
    getAllContatti(): Observable<Contatto[]> {
        return this.http.get<Contatto[]>(this.contattiurl);
    }

    saveContatto(contatto:Contatto): Observable<Contatto> {
       return this.http.post<Contatto>(this.contattiurl,contatto);
    }

    deleteContatto(contatto:Contatto): Observable<{}> {
        this.deleteUrl = this.contattiurl + '/' + contatto.idcontatto;
        console.log(this.deleteUrl);
        return this.http.delete<Contatto>(this.deleteUrl);
    }

    updateContatto(contatto:Contatto): Observable<Contatto> {
        return this.http.put<Contatto>(this.contattiurl,contatto); 
    }

}
