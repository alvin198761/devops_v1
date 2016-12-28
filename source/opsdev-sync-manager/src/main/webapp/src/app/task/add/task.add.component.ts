import {Component, OnInit} from '@angular/core';
import Task from '../task';
import {TaskService} from "../task.service";
import {ActivatedRoute, Params, Router} from "@angular/router";

@Component({
  selector: 'app-root',
  templateUrl: './task.add.component.html',
  styleUrls: ['./task.add.component.css']
})
export class AddTaskComponent implements OnInit {

  task: Task;

  ngOnInit(): void {
    this.task = new Task();
  }

  constructor(private route: ActivatedRoute, private router: Router, private taskservice: TaskService) {
  }

  addTask(): void {
    this.taskservice.add(this.task);
  }

  onUpload(evt): void {

  }


}
