"use client"
import { Restaurant } from "@/app/restaurants/list/page"
import { Card, CardMedia, CardContent, Typography, CardActions, Button, Box } from "@mui/material"
import CustomButton from "./CustomButton"

type RestaurantCardProps = {
  restaurant: Restaurant
}

const RestaurantCard = ({ restaurant }: RestaurantCardProps) => {
  const descriptionBeforeComma = restaurant.description.split(',')[0];
  return (
    <>
      <Card sx={{ maxWidth: 345 }}>
        <CardMedia
          sx={{ height: 140 }}
          image={`http://localhost:8080/images/${restaurant.imageUrl}`}
          title="green iguana"
        />
        <CardContent>
          <Box display="flex" flexDirection="column" alignItems="center">
            <Typography gutterBottom variant="h5" component="div" textAlign="center">
              {restaurant.name}
            </Typography>
            <Typography variant="body2" color="text.secondary" textAlign="center">
              {descriptionBeforeComma}
            </Typography>
          </Box>
        </CardContent>
        <CardActions>
          <Box display="flex" justifyContent="center" width="100%">
            <CustomButton text="BOOK" route={`/reservations/${restaurant.id}`}/>
            <CustomButton text="MORE" route={`/restaurants/${restaurant.id}`} />
          </Box>
        </CardActions>
      </Card>
    </>
  )
}

export default RestaurantCard
