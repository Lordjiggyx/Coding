import { Component, OnInit , Input , EventEmitter , Output} from '@angular/core';
import {Todo} from 'src/app/models/Todo'
import {TodoService} from '../../services/todo.service'
@Component({
  selector: 'app-todo-item',
  templateUrl: './todo-item.component.html',
  styleUrls: ['./todo-item.component.css']
})
export class TodoItemComponent implements OnInit 
{
@Input() todo:Todo;
@Output() deleteTodo:EventEmitter<Todo> = new EventEmitter();
  constructor(private tododService:TodoService) { }

  ngOnInit() {
  }

  //set dynamic classes
  setClasses()
  {
    let classes = {
      todo:true,
      //is compete is a reference to the css file
      'is-complete':this.todo.completed 
    }
    return classes
  }
  
 
  onToggle(todo)
 {
   //Toggle in UI
   todo.completed = !todo.completed
   //Toggle in Server
   this.tododService.toggleCompleted(todo).subscribe(todo =>
    console.log(todo))
 }

 onDelete(todo)
 {
  this.deleteTodo.emit(todo)
 }

}
