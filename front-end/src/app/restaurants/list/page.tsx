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
  imageUrl: string;
  menuUrl: string;
  phoneNumber: string;
}

export default async function Page() {
  const data = await fetchData('/restaurants')
  
  return (
    <Box>
      {data &&
        <Box sx={{
          display: "grid",
          gridTemplateColumns: {
            xs: '1fr', 
            sm: 'repeat(2, 1fr)', 
            md: 'repeat(3, 1fr)' 
          },
          gap: 3
        }}>
          {data.map((item: Restaurant)=>(
            <RestaurantCard key={item.id} restaurant={item}/>
          ))}
        </Box>
      }
    </Box>
  );
}