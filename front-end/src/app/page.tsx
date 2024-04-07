import Image from "next/image";
import styles from "./page.module.css";
import CustomButton  from "@/components/CustomButton";
import Box from '@mui/material/Box';



export default function Home() {
  return (
    <main>
      <Box sx={ {display: 'flex', justifyContent: 'center', alignItems: 'center', height: '100vh'} }>
      <Box style={{ display: 'flex', gap: '20px' }}>
        <CustomButton text="View List" />
        <CustomButton text="View Map" />
      </Box>
      </Box>
    </main>
  );
}
