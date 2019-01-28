import { EmailValidator } from "@angular/forms";

export class Clienti  {
  
      
      public ragionesociale: string;
      public iva: string;
      public email: string;
      public telefono: number;
      public indirizzo: string;
      public note: Text;
      public idcontatto: number;
      public idcliente: number;
  
  
      constructor(
  
        
        ragionesociale?: string,
        iva?: string,
        email?: string,
        telefono?: number,
        indirizzo?: string,
        idcontatto?: number,
        note?: Text,
        idcliente?: number,
       ) 
                          {
                      this.idcliente=idcliente;
                      this.ragionesociale=ragionesociale;
                      this.iva=iva;
                      this.email=email;
                      this.telefono=telefono;
                      this.indirizzo=indirizzo;
                      this.idcontatto=idcontatto;
                      this.note=note;
                  }   
                  
  
  }