/** @type {import('tailwindcss').Config} */
export default {
  content: [
    "./index.html",
    "./src/**/*.{js,ts,jsx,tsx}",
  ],
  theme: {
    extend: {
      colors: {
        nba: {
          blue: '#1d428a',
          red: '#c8102e',
        }
      }
    },
  },
  plugins: [],
}