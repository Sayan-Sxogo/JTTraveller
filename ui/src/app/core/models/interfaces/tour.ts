export interface Tour {
  id: string;
  name: string;
  author: string;
  days: number;
  nights: number;
  difficultyLevel: string;
  status: string;
  address: string;
  startAt: string;
  endAt: string;
  batchIds: string[];
}

export interface CreateTour {
  name: string;
  startAt: string;
  endAt: string;
  duration: number;
  mode: string;
  difficultyLevel: string;
}

export interface Batch {
  id: string;
  start: string;
  capacity: number;
  TourId: string;
  status: string;
  tourGuide: TourGuide;
  cost: number;
}

interface TourGuide {
  name: string;
  mobile: string;
  email: string;
}
