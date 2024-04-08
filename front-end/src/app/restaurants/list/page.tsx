import CustomButton from "@/components/moleculas/CustomButton";
import Box from '@mui/material/Box';
import Typography from '@mui/material/Typography';
import ConstructionIcon from '@mui/icons-material/Construction';
import { fetchData } from "@/api/apiClient";


export default async function Page() {
  const data = await fetchData('/restaurants')
  console.log(data);

  return (
    <Box>
      <Typography>Restaurants</Typography>
    </Box>
  );
}
