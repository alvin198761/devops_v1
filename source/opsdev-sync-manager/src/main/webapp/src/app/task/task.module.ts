import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { HttpModule } from '@angular/http';

import { TaskComponent } from './task.component';
import {TaskService} from "./task.service";
import {EditTaskComponent} from "./edit/task.edit.component";
import {AddTaskComponent} from "./add/task.add.component";
import {FileUploadModule,ConfirmDialogModule} from 'primeng/primeng';
import {ConfirmationService} from "primeng/components/common/api";
@NgModule({
  declarations: [
    TaskComponent,
    EditTaskComponent,
    AddTaskComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpModule　,
    FileUploadModule,
    ConfirmDialogModule
  ],
  providers: [
    TaskService,
    ConfirmationService
  ],
  bootstrap: [TaskComponent]
})
export class TaskModule { }
