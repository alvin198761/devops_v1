import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';
import {FormsModule} from '@angular/forms';
import {HttpModule} from '@angular/http';
import {RouterModule, Routes}   from '@angular/router';

import {TaskModule} from './task/task.module';
import {AppComponent} from './app.component';
import {TaskComponent} from "./task/task.component";
import {EditTaskComponent} from "./task/edit/task.edit.component";
import {AddTaskComponent} from "./task/add/task.add.component";

const appRoutes: Routes = [
  {path: 'task', component: TaskComponent, data: {title: '任务管理'}},
  {path: 'task/:id', component: EditTaskComponent, data: {title: '编辑任务'}},
  {path: 'add-task', component: AddTaskComponent, data: {title: '上传任务'}},
  {path: '', component: TaskComponent, data: {title: '任务管理'}}
]

@NgModule({
  declarations: [
    AppComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpModule,
    RouterModule.forRoot(appRoutes),
    TaskModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule {
}


