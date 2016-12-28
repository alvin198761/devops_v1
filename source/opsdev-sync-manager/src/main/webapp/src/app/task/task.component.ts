import {Component, OnInit} from '@angular/core';
import Task from './task';
import {TaskService} from "./task.service";
import {Router} from "@angular/router";

import { ConfirmationService} from 'primeng/primeng';

@Component({
  selector: 'app-root',
  templateUrl: './task.component.html',
  styleUrls: ['./task.component.css']
})
export class TaskComponent implements OnInit {

  ngOnInit(): void {
    this.getTasks();
  }

  constructor(private router: Router,
              private taskService: TaskService,
              private confirmationService: ConfirmationService) {
  }

  filterStr = '';
  tasks: Task[];
  allData:Task[];

  getTasks(): void {
    this.allData = this.taskService.fetchTasks();
    this.tasks = this.filter(this.filterStr);
  }

  doEditTask(id: number): void {
    this.router.navigate(["/task", id])
  }

  doRemoteTask(id: number): void {
    this.confirmationService.confirm({
      message: '你确定要删除吗？',
      header: '删除提示',
      accept: () => {this.taskService.remove(id)}
    });
  }

  filterTask(evt){
    this.tasks = this.filter(evt.target.value);
  }

  filter(str){
    return this.allData.filter(item => item.name.indexOf(str) !=-1);
  }

  toAddPage(): void {
    this.router.navigate(["/add-task"])
  }
}


