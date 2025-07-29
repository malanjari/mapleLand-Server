import {
  victoria,
  elnath,
  ludusLake,
  minarForest,
  aquaRoad,
  mulung,
  nihalDesert,
} from "@/shared/assets/world";

export interface World {
  name: string;
  keyword: string;
  image: string;
}

export const WORLDS: World[] = [
  { name: "빅토리아", keyword: "Victoria", image: victoria },
  { name: "엘나스", keyword: "Elnath", image: elnath },
  { name: "루더스 호수", keyword: "LudusLake", image: ludusLake },
  { name: "미나르 숲", keyword: "MinarForest", image: minarForest },
  { name: "아쿠아 로드", keyword: "AquaRoad", image: aquaRoad },
  { name: "무릉도원", keyword: "MuLung", image: mulung },
  { name: "니할 사막", keyword: "NihalDesert", image: nihalDesert },
];
