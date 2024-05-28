"use client"

import { Restaurant } from "@/app/restaurants/list/page"
import { Card, CardMedia, CardContent, Typography, CardActions, Button } from "@mui/material"

type RestaurantCardProps = {
  restaurant: Restaurant
}

const RestaurantCard = ({restaurant}: RestaurantCardProps) => {
  console.log(restaurant);
  
  return(
    <>
      <Card sx={{ maxWidth: 345 }}>
      <CardMedia
        sx={{ height: 140 }}
        image={`http://localhost:8080/images/${restaurant.imageUrl}`}
        title="green iguana"
      />
      <CardContent>
        <Typography gutterBottom variant="h5" component="div">
          {restaurant.name}
        </Typography>
        <Typography variant="body2" color="text.secondary">
          {restaurant.description}
        </Typography>
      </CardContent>
      <CardActions>
        <Button size="small">Share</Button>
        <Button size="small">Learn More</Button>
      </CardActions>
    </Card>
    </>
  )
}

export default RestaurantCard