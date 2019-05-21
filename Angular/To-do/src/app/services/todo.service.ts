import { Injectable } from '@angular/core';
import {HttpClient , HttpHeaders} from '@angular/common/http'
import { Todo } from '../Models/todo';
import {Observable} from 'rxjs'

const httpOptions = {
  headers : new HttpHeaders({
      'Content-Type':'application/json'
  })
}



@Injectable({
  providedIn: 'root'
})
export class TodoService {
 todosUrl:string ='https://jsonplaceholder.typicode.com/todos'
  constructor(private http:HttpClient)
  {
    
  }

  // Get Todos
  getTodos():Observable<Todo[]>
  {
    return this.http.get<Todo[]>(this.todosUrl)
}

//Toggle Completed
toggleCompleted(todo:Todo):Observable<any>
{
  const url = `${this.todosUrl}/${todo.id}`
  return this.http.put(url,todo,httpOptions)
}

//delet todo
deleteTodo(todo:Todo):Observable<Todo>
{
  const url = `${this.todosUrl}/${todo.id}`
  return this.http.delete<Todo>(url,httpOptions)
}

addTodo(todo:Todo):Observable<Todo>
{

  return this.http.post<Todo>(this.todosUrl,todo,httpOptions)
}


}