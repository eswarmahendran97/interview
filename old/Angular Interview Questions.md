Var vs Let
Var is like a gobal declaration. If Var value is declared and defined in a sub function and if it is accessed outside it, we can access it. In Let we can not do that
Hoisting can be done in Var(getting the var value before declariting will not throw error)
Redeclaration can be done in Var
Var can be declared globally

For Loop
Object
 	let a = { a:1,b:2};
	for(let b in a){
	console.log(a[b])}
Array
	let a=[1,2]
	for(let b of a){
	console.log(b)}

Array.find vs Array.Filter
The Array.find function returns only one object(first red car). If we want to get all similar objects(eg: red cars), we need to use Array.filter.

Pipes:
Pipes are used to transform a value
built-in pipe(Upper Case, lower case, date)
Custom pipe

Eg:
Built-in pipe
<p>{{ myDateValue | date:'M/d/yy' }}</p>

Custome Pipe
<p>{{ myDateValue | myDate}}</p>

create a pipe component
import { Pipe } from '@angular/core';
@Pipe({ name: 'myDate' })
export class MyDatePipe implements PipeTransform{
	transform(value:any) {
		return "Thursday";
	}
}

LifeCycle methods in Angular
ngOnChange()
ngOninIt()
ngDoCheck()
ngAfterContentInit()	
ngAfterContentChecked()	
ngAfterViewInit()	
ngAfterViewChecked()	
ngOnDestroy()
