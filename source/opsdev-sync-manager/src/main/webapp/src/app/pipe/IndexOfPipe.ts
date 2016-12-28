import {Pipe} from '@angular/core';

@Pipe({
  name: 'IndexOfPipe'
})
export class IndexOfPipe  {
  transform(items: any[], args: any[]): any {
    let title = args;
    return items.filter(item => item.name.indexOf(title) != -1);
  }
}
