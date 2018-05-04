import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-user',
  templateUrl: './user.component.html',
  styleUrls: ['./user.component.css']
})
export class UserComponent implements OnInit {
  hide = false;
  username = '';
  password = '';
  selectedIndex = 0;
  constructor() { }

  ngOnInit() {
  }

}
