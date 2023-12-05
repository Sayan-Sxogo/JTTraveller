const PORT = 3000;
const SERVER = 8080;
const Query = 'happiness';
export const API = {
  baseUrl: `http://localhost:${SERVER}/`,
  tourApi: 'tours',
  authApi: 'auth',
  batches: 'batches',
  book: 'book',
};
export const API_KEY = 'wMpqdB58FSaxI9aeq4NPPw==mAOw4SMPZNzFJflI';

export const quoteAPI = {
  baseUrl: `https://api.api-ninjas.com/v1/quotes`,
  query: `?category=${Query}`,
};
