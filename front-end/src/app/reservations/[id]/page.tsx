import { fetchData } from "@/api/apiClient";
import { Restaurant } from "@/app/restaurants/list/page";
import ReservationComponent from "@/components/organisms/ReservationComponent";
import { Box, Typography } from "@mui/material";
import Image from "next/image";
import React from "react";


type ReservationPageProps = {
  params: {
    id: number;
  }
};

const ReservationPage = async ({params}: ReservationPageProps) => {
  
  const restuarant : Restaurant = await fetchData(`/restaurants/${params.id}`)

  return(
    <>
      <Box sx={{
        display: "flex",
        flexDirection: "column",
        gap: "1rem",
        alignItems: "center"
      }}>
        <Typography variant="h4">
          {restuarant.name}
        </Typography>
        <ReservationComponent restaurant={restuarant} />
      </Box>
    </>
  )
}

export default ReservationPage