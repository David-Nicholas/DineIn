import Box from '@mui/material/Box';
import Typography from '@mui/material/Typography';
import { fetchData } from "@/api/apiClient";
import RestaurantCard from '@/components/moleculas/RestaurantCard';

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
      <Typography>Restaurants</Typography>
      {data &&
        <Box sx={{
          display: "flex",
          flexDirection: "row",
          gap: 3,
          // justifyContent: "center",
          flexWrap: "wrap"
        }}>
          {data.map((item: Restaurant)=>(
            <RestaurantCard restaurant={item}/>
          ))}
        </Box>
      }
    </Box>
  );
}
