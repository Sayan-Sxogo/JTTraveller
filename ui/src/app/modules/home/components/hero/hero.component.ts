import { Component } from '@angular/core';

@Component({
  selector: 'app-hero',
  templateUrl: './hero.component.html',
  styleUrls: ['./hero.component.css']
})
export class HeroComponent {
  slides = [
    {video:"https://mdbcdn.b-cdn.net/img/video/Tropical.mp4"},
    {video:"https://mdbcdn.b-cdn.net/img/video/Agua-natural.mp4"},
    {video:"https://mdbcdn.b-cdn.net/img/video/forest.mp4"}
  ]

  slideConfig = {
    "slidesToShow": 1,
    "slidesToScroll": 1,
    "dots": false,
    "infinite": true,
    "responsive": [
      {
        breakpoint: 1024,
        settings: {
          slidesToShow: 3,
          slidesToScroll: 3,
          infinite: true,
          dots: true
        }
      },
      {
        breakpoint: 600,
        settings: {
          slidesToShow: 2,
          slidesToScroll: 2
        }
      },
      {
        breakpoint: 480,
        settings: {
          slidesToShow: 1,
          slidesToScroll: 1
        }
      }
    ],
    "autoplay":true,
    "arrows":false
  };

  addSlide() {
    // this.slides.push(488)
  }

  removeSlide() {
    this.slides.length = this.slides.length - 1;
  }

  slickInit(e: any) {
    // console.log('slick initialized');
  }

  breakpoint(e: any) {
    // console.log('breakpoint');
  }

  afterChange(e: any) {
    // console.log('afterChange');
  }

  beforeChange(e: any) {
    // console.log('beforeChange');
  }
}
