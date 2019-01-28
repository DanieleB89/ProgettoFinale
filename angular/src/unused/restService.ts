/*
import { ListAbstract } from "./listAbstract"
import { HttpClient } from "@angular/common/http";
import { Observable } from "rxjs";
import { Corso } from "./corso"; //check correct path!!!
import { Injectable } from "@angular/core";


@Injectable()
export class RestService extends ListAbstract {


    private corsiurl = 'http://localhost:8080/spring-crm-rest/api/corso';
    private deleteUrl = '';

    constructor(private http: HttpClient) {
        super();
    }


    getAllCourses(): Observable<Corso[]> {
        return this.http.get<Corso[]>(this.corsiurl);
    }

    saveCourse(course:Corso): Observable<Corso> {
       return this.http.post<Corso>(this.corsiurl,course);
    }

    deleteCourse(course:Corso): Observable<{}> {
        this.deleteUrl = this.corsiurl + '/' + course.id;
        return this.http.delete(this.deleteUrl);
    }

    updateCourse(course:Corso): Observable<Corso> {
        return this.http.put<Corso>(this.corsiurl,course); 
    }

}
*/
