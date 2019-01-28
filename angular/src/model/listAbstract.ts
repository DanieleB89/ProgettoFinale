import { Observable } from "rxjs";
import { Contatto } from "./contatto";

export abstract class ListAbstract  {
  
   abstract getAllContatti(): Observable<Contatto[]>;

   abstract saveContatto(contatto:Contatto) : Observable<Contatto>;

   abstract deleteContatto(contatto:Contatto): Observable<{}>;

   abstract updateContatto(contatto:Contatto): Observable<Contatto>;

   

}