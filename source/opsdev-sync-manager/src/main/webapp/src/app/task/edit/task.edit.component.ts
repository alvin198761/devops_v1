import {Component, OnInit} from '@angular/core';
import Task from '../task';
import {TaskService} from "../task.service";
import {ActivatedRoute, Params, Router} from "@angular/router";

@Component({
  selector: 'app-root',
  templateUrl: './task.edit.component.html',
  styleUrls: ['./task.edit.component.css']
})
export class EditTaskComponent implements OnInit {

  task:Task;
  ngOnInit(): void {
    let id:number = this.route.params['value'].id;
    this.task = this.taskservice.fetch(id);
  }

  constructor( private route: ActivatedRoute,private router:Router,private taskservice: TaskService) {
  }

  doModifyRemark():void{
    this.taskservice.modifyTask(this.task);
    this.router.navigate(["/task"]);
  }

}
