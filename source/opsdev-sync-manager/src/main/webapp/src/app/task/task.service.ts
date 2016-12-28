import {Injectable} from '@angular/core';
import {TASKS} from './task.mock';
import {Http, Headers} from '@angular/http';
import Task from "./task";

@Injectable()
export class TaskService {

  private headers = new Headers({'Content-Type': 'application/json'});

  constructor(private http: Http) {
  }

  fetchTasks() {
    return this.http.get("/task/list").toPromise()
      .then(response => response.json().data as Task[]);
  }


  fetch(id: number) {
    return this.http.get("/task/" + id).toPromise()
      .then(response => response.json().data as Task);
  }

  modifyTask(task: Task) {
    return this.http.post("/task", JSON.stringify(task), {headers: this.headers}).toPromise()
      .then(response => response.toString());
  }

  remove(id: number) {
    return this.http.delete("/task/" + id).toPromise()
      .then(response => response.toString());
  }

  add(task: Task) {
    return this.http.put("/task", JSON.stringify(task), {headers: this.headers}).toPromise()
      .then(response => response.toString());
  }
}
