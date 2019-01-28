
export class Contatto  {
    public idcontatto: number;
    public nome: string;
    public cognome: string;
    public telefono: string;
    public email: string;
    public idcliente: number | string;
    public ruolo: string;
    public reparto: string;
    public note: string;



    constructor(idcontatto?: number,
                nome?: string,
                cognome?: string,
                telefono?: string,
                email?: string,
                idcliente?: number | string,
                ruolo?: string,
                reparto?: string,
                note?: string) 
                        {
                    this.idcontatto=idcontatto;
                    this.nome=nome;
                    this.cognome=cognome;
                    this.telefono=telefono;
                    this.email=email;
                    this.idcliente=idcliente;
                    this.ruolo=ruolo;
                    this.reparto=reparto;
                    this.note=note;
                }   

}