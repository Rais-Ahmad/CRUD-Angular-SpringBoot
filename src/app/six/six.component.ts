import { Component, OnInit } from '@angular/core';
import { __values } from 'tslib';

@Component({
  selector: 'app-six',
  templateUrl: './six.component.html',
  styleUrls: ['./six.component.css']
})
export class SixComponent implements OnInit {

  title="blog";
  // currentVal="";
  // getVal(val: string){
  //   console.warn(val)
  //   this.currentVal = val
  // }
  values = '';

  // onKey(event: any) { 
  //   this.values = event.target.value;
  // }
  showName(username: string){
    this.values = username;
  }
  

  constructor() { }

  ngOnInit(): void {
  }

}
