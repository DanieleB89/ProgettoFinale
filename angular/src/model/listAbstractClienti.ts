
import { Observable } from "rxjs";
import { Clienti } from "./clienti";

export abstract class ListAbstractClienti  {

 

   //consente di andare a leggere i clienti 
   abstract getAllClienti():Observable<Clienti[]>;

   abstract saveClienti(clienti:Clienti) : Observable<Clienti>;

   abstract deleteClienti(clienti: Clienti):Observable<{}>;

   abstract updateClienti(clienti: Clienti):Observable<Clienti>;

   abstract getSingleCliente(theId:number):Observable<Clienti>;

   
}