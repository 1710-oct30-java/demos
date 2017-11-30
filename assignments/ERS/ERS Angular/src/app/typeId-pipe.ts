import {Pipe, PipeTransform} from '@angular/core'

@Pipe({
    name: 'type'
})

export class TypeIdPipe implements PipeTransform {
    transform(type) {
        if (type == 1) return "Lodging";
        else if (type == 2) return "Travel";
        else if (type == 3) return "Food";
        else return "Other";
    }
    
}