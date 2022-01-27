import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';

export class marks{
  constructor( public id: number ,public name: String, public Mathamatics:number,
     public English: number,public Science: number,public Chemistry: number,
     public Physics: number, public PakStudies: number,public Urdu: number){

  }
}

@Component({
  selector: 'app-user',
  templateUrl: './user.component.html',
  styleUrls: ['./user.component.css']
})


export class UserComponent implements OnInit {
  Marks: marks[] = [];
  constructor(private httpClient: HttpClient) { }

  ngOnInit(): void {
    this.getUsers();
  }

  getUsers(){
    this.httpClient.get<any>('http://localhost:3000/marks').subscribe(
      response => {
        console.log(response);
        this.Marks = response;
        
      }
    );
  }

  
  

}
