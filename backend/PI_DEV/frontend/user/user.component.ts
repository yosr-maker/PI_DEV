import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-user',
  templateUrl: './user.component.html',
  styleUrls: ['./user.component.css']
})
export class UserComponent implements OnInit {

  constructor() { }

  ngOnInit(): void {
    saveUser(){
      this.userService.createEmployee(this.user).subscribe( data =>{
        console.log(data);
        this.goToUserList();
      },
      error => console.log(error));
    }
  
    goToUserList(){
      this.router.navigate(['/user']);
    }
    
    onSubmit(){
      console.log(this.user);
      this.saveUser();
    }
  }
  
  }

}
