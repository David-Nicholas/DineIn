import CustomButton from "@/components/moleculas/CustomButton";
import Box from '@mui/material/Box';
import Typography from '@mui/material/Typography';
import ConstructionIcon from '@mui/icons-material/Construction';

async function getRestaurants() {
  const res = await fetch('http://localhost:8080/restaurants')
  // The return value is *not* serialized
  // You can return Date, Map, Set, etc.
 
  if (!res.ok) {
    // This will activate the closest `error.js` Error Boundary
    throw new Error('Failed to fetch data')
  }
 
  return res.json()
}

export default async function Page() {
  const data = await getRestaurants()
  console.log(data);

  return (
    <Box sx={{
      display: 'flex',
      justifyContent: 'center',
      alignItems: 'center',
      height: '100vh'
    }}>
      <Box sx={{ textAlign: 'center' }}>
        <Typography sx={{
          fontFamily: 'monospace',
          fontWeight: 700,
          fontSize: '20px',
          lineHeight: '1.2',
          letterSpacing: '.1rem'
        }}>
          <ConstructionIcon sx={{ fontSize: 64 }}/> <br />  Coming Soon
        </Typography>
        <Box sx={{
          display: 'flex',
          gap: '40px',
          justifyContent: 'center',
          marginTop: '30px'
        }}>
          <CustomButton text="back" route="/" />
        </Box>
      </Box>
    </Box>
  );
}
