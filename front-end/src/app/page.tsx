"use client";

import CustomButton from "@/components/moleculas/CustomButton";
import Box from "@mui/material/Box";
import Typography from "@mui/material/Typography";

export default function Home() {
  return (
    <Box sx={{
        display: "flex",
        justifyContent: "center",
        alignItems: "center",
        height: "100vh",
    }}>
      <Box sx={{ textAlign: "center" }}>
        <Typography sx={{
          fontFamily: "monospace",
          fontWeight: 700,
          fontSize: "20px",
          lineHeight: "1.2",
          letterSpacing: ".1rem",
        }}>
          DineIn: <br /> Effortlessly Secure Your Favorite Restaurant Table{" "}
          <br /> With just a few clicks
        </Typography>
        <Box sx={{
          display: "flex",
          gap: "40px",
          justifyContent: "center",
          marginTop: "30px",
        }}>
          <CustomButton text="View List" route="/restaurants/list" />
          <CustomButton text="View Map" route="/restaurants/map" />
        </Box>
      </Box>
    </Box>
  );
}
