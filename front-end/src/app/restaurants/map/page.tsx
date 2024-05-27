import { Box } from "@mui/material";
import 'leaflet/dist/leaflet.css';
import { fetchData } from "@/api/apiClient";
import dynamic from 'next/dynamic';

export type RestaurantTable = {
  id: number
  seats: number
}

export type MapCoordinates = {
  coordinateX: number
  coordinateY: number
}

export type Restaurant = {
  id: number
  name: string
  description: string
  mapCoordinates: MapCoordinates
  restaurantTables?: RestaurantTable[]
}

const Map = dynamic(() => import("@/components/organisms/Map"), {
  ssr: false,
});


export default async function Page() {
  const data = await fetchData('/restaurants')
  console.log(data);

  return (
    <Box>
      {!!data && 
        <Map data={data}/>
      } 
    </Box>
  );
}