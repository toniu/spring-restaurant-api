/** @type {import('tailwindcss').Config} */
module.exports = {
  content: [
    "./src/main/resources/templates/**/*.{html,js}", // Include all HTML files in your templates directory
    "./src/main/resources/static/js/**/*.{js}", // If you have any JS files
  ],
  theme: {
    extend: {},
  },
  plugins: [],
}