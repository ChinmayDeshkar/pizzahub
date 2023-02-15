import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { AuthService } from '../_services/auth.service';
import { StorageService } from '../_services/storage.service';

@Component({
  selector: 'app-forget',
  templateUrl: './forget.component.html',
  styleUrls: ['./forget.component.css']
})
export class ForgetComponent {
  form: any = {
    username: null,
    password: null,
    fpassword:null
  };
  isSuccessful = false;
  isSignUpFailed = false;
  isMissMatched=false;
  errorMessage = '';

  constructor(private authService: AuthService) { }

  ngOnInit(): void {
  }

  onSubmit(): void {
    const { username,password ,fpassword} = this.form;
    if(!(fpassword==password)){
      console.log(fpassword);
      console.log(password);
      
      this.isMissMatched=true;
    }else{
      this.authService.forget(username, password).subscribe({
        next: data => {
          console.log(data);
          this.isSuccessful = true;
          this.isSignUpFailed = false;
        },
        error: err => {
          this.errorMessage = err.error.message;
          this.isSignUpFailed = true;
        }
      });
    }

    
  }

}
