import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-name',
  templateUrl: './name.component.html',
  styleUrls: ['./name.component.css']
})
export class NameComponent implements OnInit {

  constructor() { }
  
  title = 'todo-app';

  color = "orange";
  err = true;
  updateColor(){
   this.err = !this.err;    
  }
  
  nextId = 4;
  todos = [
    {
      id: 1,
      label: 'Bring Milk',
      done: false
    },
    {
      id: 2,
      label: 'Pay mobile bill',
      done: false
    },
    {
      id: 3,
      label: 'Bring Milk',
      done: true
    },
  ];
  
  delete(todo: { id: number; }) {
    this.todos = this.todos.filter(t => t.id !== todo.id);
  }

  add(newTodoLabel: any) {
    let newTodo = {
      id: this.nextId,
      label: newTodoLabel,
      done: false
    };
    this.todos.push(newTodo);
    this.nextId++;
  }

  toggle(todo: { done: boolean; }) {
    todo.done = !todo.done;
  }

  ngOnInit(): void {
  }

}
