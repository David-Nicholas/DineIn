"use client"

import { MapContainer, TileLayer } from "react-leaflet"
import Markers from "../moleculas/Markers"
import { Restaurant } from "@/app/restaurants/map/page"

const mapStyle = {
    width: `calc(100% - 40px)`, 
    height: `calc(75vh - 20px)`, 
    margin: '1px auto 20px auto', 
  };

type MarkersProps = {
    data: any
}

const Map = ({data}:MarkersProps) =>{
    return(
     <MapContainer center={[45.756148, 21.228273]} zoom={13} scrollWheelZoom={false} style={mapStyle}>
      <TileLayer
        attribution='&copy; <a href="https://www.openstreetmap.org/copyright">OpenStreetMap</a> contributors'
        url="https://{s}.tile.openstreetmap.org/{z}/{x}/{y}.png"
      />
      { data && data.map((item: Restaurant)=>(
        <Markers key={item.id} restaurant={item}/>
      ))}
    </MapContainer>
    )
}
export default Map