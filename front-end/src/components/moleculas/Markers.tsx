"use client"
import LocationOnIcon from '@mui/icons-material/LocationOn';
import L from "leaflet";
import { renderToString } from 'react-dom/server';
import { Restaurant } from "@/app/restaurants/map/page";
import { Marker, Popup } from "react-leaflet";

type MarkersProps = {
    restaurant: Restaurant;
}

const CustomIcon = L.divIcon({
    className: '',
    html: renderToString(<LocationOnIcon color="primary" fontSize="large" />),
    iconSize: [36, 36],
    iconAnchor: [18, 36],
});

const Markers = ({ restaurant }: MarkersProps) => {
  const { coordinateX,  coordinateY} = restaurant.mapCoordinates;
    return (
        <Marker position={[coordinateX, coordinateY]} icon={CustomIcon}>
            <Popup>
                {restaurant.name}
            </Popup>
        </Marker>
    );
}

export default Markers;
