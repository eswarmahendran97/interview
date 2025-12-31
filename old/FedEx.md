FedEx

Frontend
@HostListener('mouseenter') onMouseEnter() {}

Explain
import { Injectable } from '@angular/core';

import { HttpClient } from '@angular/common/http';

import { Observable, BehaviorSubject } from 'rxjs';

import { tap } from 'rxjs/operators';

 

@Injectable({

    providedIn: 'root',

})

export class DataService {

    private dataSubject = new BehaviorSubject < any > (null);

    data$ = this.dataSubject.asObservable();

 

    constructor(private http: HttpClient) { }

 

    fetchData(): Observable<any> {

        return this.http.get('https://api.example.com/data').pipe(

            tap((data) => this.dataSubject.next(data))

        );

    }

 

    getData(): Observable<any> {

        return this.data$;

    }

}


Backend
Given an integer array nums sorted in non-decreasing order, 

remove some duplicates in-place such that each unique element appears at most twice. The relative order of the elements should be kept the same.

Input: nums = [0,0,1,1,1,1,2,3,3]

Output: 5, nums = [0,1,1,2,3,_,_, _]


Starting point of springboot application

Student repo
Student{
studentId
studentName
subjectId
subjectMark
}

1) find total mark of student
2) Top 3 student based on total mark


Join below tables
Table1		Table2

1		1

1		1

2		1

2		2

2		2

3		3

null		3
		
		null


