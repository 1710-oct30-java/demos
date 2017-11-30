import {Pipe, PipeTransform} from '@angular/core'

@Pipe({
    name: 'status'
})

export class StatusPipe implements PipeTransform {
    transform(status) {
        if (status == 1) return "Pending";
        else if (status == 2) return "Accepted";
        else if (status == 3) return "Denied";
    }
    
}