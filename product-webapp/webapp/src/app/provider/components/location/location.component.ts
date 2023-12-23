import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-location',
  templateUrl: './location.component.html',
  styleUrls: ['./location.component.css'],
})
export class LocationComponent implements OnInit {
  location = {
    lat: 0,
    lon: 0,
  };
  ngOnInit(): void {
    
  }
}
