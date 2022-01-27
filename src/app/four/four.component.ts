import { Component, OnInit } from '@angular/core';
import { degree } from '../degree';
import { ApiService } from '../degree.service';

@Component({
  selector: 'app-four',
  templateUrl: './four.component.html',
  styleUrls: ['./four.component.css']
})
export class FourComponent implements OnInit {
  title = 'httpGet Example';
  Degree:degree[] | undefined;
  degree = new degree();
  apiService: any;
  value : number = 1;
  deg : string | undefined;
  noData:string | undefined;
  status: string | undefined;
  
  constructor(private degreeService:ApiService) {
    
  }
 
  ngOnInit() {
    // this.refreshDegree()
   
  }
 
  
 /* View all degrees  */
  refreshDegree() {
    this.degreeService.getDegree()
      .subscribe((data: degree[] | undefined) => {
        
        console.log(data)
        this.Degree=data;
      })      
 
  }

/*  View particular degree */
  viewReport(){
    this.Degree = [];  
    var num =(<HTMLInputElement>document.getElementById('num')).value;
    this.value = parseInt(num);
    console.log(this.value);
    this.degreeService.getDegreeById(this.value).subscribe((data: degree) => {
      console.log(data);
      if (data == null) {
        console.log("No Data available")
        this.noData = "No Data available at this Id! "
      }
      else
      this.Degree?.push(data);  
    })  
  }

 /* Add Degree */
  addDegree() {
    this.degreeService.addDegree(this.degree)
      .subscribe((data: any) => {
        console.log(data)
        this.refreshDegree();
      })      
  }

  updateDegree() {
    var numb =(<HTMLInputElement>document.getElementById('numb')).value;
    this.value = parseInt(numb);
    console.log(this.value);
    var degName =(<HTMLInputElement>document.getElementById('degName')).value;
    this.deg = degName;
    console.log(this.deg);
    this.degreeService.updateDegree(this.value , this.deg)
      .subscribe((data: any) => {
        console.log(data)
        this.refreshDegree();
      })      
  }

  deleteDegree() {
    var x =(<HTMLInputElement>document.getElementById('x')).value;
    this.value = parseInt(x);
    console.log(this.value);
    this.degreeService.deleteDegree(this.value)
      .subscribe(data => {

      });
  }


}
