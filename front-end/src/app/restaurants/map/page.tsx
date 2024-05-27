import { Box } from "@mui/material";
import 'leaflet/dist/leaflet.css';
import { fetchData } from "@/api/apiClient";
import Map from "@/components/organisms/Map";

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

export default async function Page() {
  const data = await fetchData('/restaurants')

  return (
    <Box>
      {!!data && 
      <Map data={data}/>
}
    </Box>
  );
}