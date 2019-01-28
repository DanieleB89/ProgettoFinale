
export class Corso  {
    public id: number;
    public nome: string;
    public docente: string;
    public durata: number;
    public prezzo: number;



    constructor(id?: number,
                nome?: string,
                docente?: string,
                durata?: number,
                prezzo?: number) 
                        {
                    this.id=id;
                    this.nome=nome;
                    this.docente=docente;
                    this.durata=durata;
                    this.prezzo=prezzo;
                }   
                
                

}