import { Component, OnInit, Inject } from '@angular/core';
import { User } from './User';

export class Ticket {
    reimbID: Number;
    amount: Number;
    submitted: Date;
    resolved: Date;
    description: String;
    receipt: Blob;
    author: User;
    resolver: User;
    status: String;
    type: String;

}
