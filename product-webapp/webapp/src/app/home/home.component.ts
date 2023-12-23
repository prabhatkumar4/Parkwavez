import { Component } from '@angular/core';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent {

  images = [
    {
      imageSrc:
        'https://i.ibb.co/6DkymM9/carousel1.png',
      imageAlt: 'parking2',
    },
    {
      imageSrc:
        'https://i.ibb.co/8MLG9gP/carousel4.jpg',
      imageAlt: 'parking3',
    },
    {
      imageSrc:
        'https://i.ibb.co/5Tg7Txc/carousel3.jpg',
      imageAlt: 'parking1',
    },
    {
      imageSrc:
        'https://i.ibb.co/hMrw0s0/carousel5.jpg',
      imageAlt: 'parking4',
    },
    {
      imageSrc:
        'https://i.ibb.co/zR3YgsJ/carousel6.jpg',
      imageAlt: 'parking4',
    },
    {
      imageSrc:
        'https://i.ibb.co/G9bDqJj/carousel7.jpg',
      imageAlt: 'parking4',
    },
  ];


  searchResults: string[] = [];

  onSearch(searchText: String) {
    // Perform search logic here and update searchResults
    // you can make an HTTP request to fetch parking areas based on the searchText
    // Update this.searchResults with the search results
  }
}
