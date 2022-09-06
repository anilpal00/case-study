import { Component, OnInit } from '@angular/core';
// import {FormBuilder } from '@angular/forms';
import { UserService } from '../../services/user.service';

@Component({
  selector: 'app-signup',
  templateUrl: './signup.component.html',
  styleUrls: ['./signup.component.css']
})
export class SignupComponent implements OnInit {

  loading = false;
  submitted = false;
  error = '';
  
  user = {
    username:"",
    password:"",
    email:"",
    mobile:""
  }
  users:any[] =[];
  constructor( private userService:UserService) { }

  ngOnInit(): void {
  }

  // register(){
  //   console.log("form is submit");
  //   if((this.user.username!='' && this.user.password!='') && (this.user.username!=null && this.user.password!=null)){
  //     console.log("if");
  //   }else{
  //     console.log("else");
  //   }
  // }


  register() {
    console.log('clicked');
    const promise = this.userService.save(this.user);
    promise.subscribe((responseBody: any) => {   //success handler
      console.log(responseBody);
      this.users.push(responseBody);
    },
      (error: any) => {
        console.log(error);
      }
    );
  }

}
