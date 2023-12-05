/** @type {import('tailwindcss').Config} */
module.exports = {
  content: [
    "./src/**/*.{html,ts}",
    "./node_modules/flowbite/**/*.js"
  ],
  theme: {
    extend: {
      colors: {
        'tiny-dark': '#4b5563',
        'light-dark': '#374151',
        'base-dark': '#1f2937',
        'very-dark': '#111827'
      },
      backgroundImage:{
        'booking-img':"url('/assets/images/booking-background.jpg')"
      }
    },
  },
  plugins: [
    require('flowbite/plugin')
  ],
  darkMode: 'class',
  darkMode: 'media'
}

