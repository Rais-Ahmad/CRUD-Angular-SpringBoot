import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';

export class allInstitutions{
  constructor(public id: number, public name: string){

  }
}

@Component({
  selector: 'app-institute',
  templateUrl: './institute.component.html',
  styleUrls: ['./institute.component.css']
})
export class InstituteComponent implements OnInit {
  Institution: allInstitutions[] = [];
  constructor(private httpClient: HttpClient) { }

  ngOnInit(): void {
    this.getInstitutions();
  }
  getInstitutions(){
    this.httpClient.get<any>('http://localhost:8090/institution/allInstitutions').subscribe(
      response => {
        console.log(response);
        this.Institution = response;
        
      }
    );
  }

}
