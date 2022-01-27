import { Component, OnInit } from '@angular/core';
import { FormControl } from '@angular/forms';
import { debounce, interval, mergeMap, skip } from 'rxjs';

import { AppModel } from './app.model';
import { AppService } from './app.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {
  title = 'guusto-client-angular';

  list: AppModel[] = []; 
  filterName = new FormControl();
  filterCountryCAN = new FormControl();
  filterCountryUSA = new FormControl();
  loged = false;
  hasError = false;
  hasSuccess = false;
  loading = false;

  username = new FormControl();
  password = new FormControl();

  timeOut: any = null;

  //Primeiro
  constructor(private service: AppService) {    
  }

  //Inicio das fases
  ngOnInit(): void {
    //this.service.getMerchants('Ba').subscribe( (items) => this.list = items );
  }

  buscar() {

    console.log('can',this.filterCountryCAN.value, 'usd',this.filterCountryUSA.value);
    let country = '';
    if(this.filterCountryCAN.value && !this.filterCountryUSA.value){
      country = 'cad';
    }
    if(this.filterCountryUSA.value && !this.filterCountryCAN.value){
      country = 'usd';
    }
    let name = this.filterName.value ?? '';

    if(this.timeOut != null) {
      clearTimeout(this.timeOut);
    }
    this.timeOut = setTimeout(() => {
      this.service.getMerchants(name, country).subscribe( (items) => this.list = items );
    },      
    500);
  }

  login() {
      localStorage.removeItem("Authorization");
      this.loading = true;
      this.hasSuccess = false;
      this.hasError = false;

      this.service.login(this.username.value, this.password.value)
      .subscribe(
        (res) => {
          let obj = JSON.parse(JSON.stringify(res));
          localStorage.setItem("Authorization", obj.body.Authorization);
          
          this.loading = false;

          this.hasSuccess = true;
          this.loged = true;
      }, 
      (error) => { 
        this.hasError = true;
        this.loading = false;
      });
  }

}
