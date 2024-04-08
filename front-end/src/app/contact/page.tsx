"use client";

import CustomButton from "@/components/moleculas/CustomButton";
import Box from '@mui/material/Box';
import Typography from '@mui/material/Typography';
import ConstructionIcon from '@mui/icons-material/Construction';

export default function Page() {
  return (
    <Box sx={{
      display: 'flex',
      justifyContent: 'center',
      alignItems: 'center',
      height: '100vh'
    }}>
      <Box sx={{
        textAlign: 'center'
      }}>
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
