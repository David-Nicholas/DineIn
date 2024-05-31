'use server'

import { fetchData, getRequiredVariable } from "@/api/apiClient"

type MakeReservationProps = {
  reservationDuration: number
  startReservationTime: string
  restaurantId: number,
  numberOfPeople: number,
  phoneNumber: string,
}

export async function makeReservation({reservationDuration, startReservationTime, numberOfPeople, restaurantId, phoneNumber}: MakeReservationProps){

  const res = await fetch(`${getRequiredVariable('NEXT_PUBLIC_API_URL')}/reservations`, {
    method: 'POST',
    headers: {
      'Content-Type': 'application/json',
    },
    body: JSON.stringify({ 
      reservationDuration: reservationDuration,
      startReservationTime: startReservationTime,
      restaurantId: restaurantId,
      numberOfPeople: numberOfPeople,
      phoneNumber: phoneNumber,
    }),
  })
  return res.json()
}

export async function getRestaurant({id}:{id: number}) {
  console.log(`/restaurants/${id}`);
  return await fetchData(`/restaurants/${id}`)
}