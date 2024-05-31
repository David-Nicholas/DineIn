import LocationOnIcon from '@mui/icons-material/LocationOn';
import L from "leaflet";
import { renderToString } from 'react-dom/server';
import { Restaurant } from "@/app/restaurants/list/page"
import { Marker, Popup } from "react-leaflet";
import { CardMedia } from '@mui/material';
import CustomButton from './CustomButton';

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
    console.log(restaurant);
    const { coordinateX, coordinateY } = restaurant.mapCoordinates;
    return (
        <Marker position={[coordinateX, coordinateY]} icon={CustomIcon}>
            <Popup>
                <div style={{ textAlign: 'center', width: '200px' }}>
                    <h3>{restaurant.name}</h3>
                    <CardMedia
                        sx={{ height: 140, borderRadius: 2 }}
                        image={`http://localhost:8080/images/${restaurant.imageUrl}`}
                        title={restaurant.name}
                    />
                    <br />
                    <CustomButton text="MORE" route={`/restaurants/${restaurant.id}`} />
                </div>
            </Popup>
        </Marker>
    );
}

export default Markers;
