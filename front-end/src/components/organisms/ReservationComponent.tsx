"use client"

import { getRestaurant, makeReservation } from "@/app/actions";
import { Box, Button, Typography } from "@mui/material"
import React, { useEffect } from "react";
import dayjs, { Dayjs } from 'dayjs';
import { AdapterDayjs } from '@mui/x-date-pickers/AdapterDayjs';
import { DateCalendar } from '@mui/x-date-pickers/DateCalendar';
import { LocalizationProvider } from '@mui/x-date-pickers/LocalizationProvider';
import { TimePicker } from '@mui/x-date-pickers/TimePicker';
import InputLabel from '@mui/material/InputLabel';
import MenuItem from '@mui/material/MenuItem';
import FormControl from '@mui/material/FormControl';
import Select, { SelectChangeEvent } from '@mui/material/Select';
import TextField from '@mui/material/TextField';
import { Restaurant, RestaurantTable } from "@/app/restaurants/list/page";

type ReservationComponentProps = {
  restaurant: Restaurant
}

type Reservation = {
  tables: RestaurantTable[]
}

type ReservationInvalid = {
  created: boolean
}

const ReservationComponent = ({restaurant}:ReservationComponentProps) => {

  const [time, setTime] = React.useState<Dayjs | null>(dayjs());
  const [date, setDate] = React.useState<Dayjs>(dayjs());  

  const [phoneNumber, setPhoneNumber] = React.useState<string>("");  
  const [numberOfPeople, setNumberOfPeople] = React.useState<number>(2);  
  const [reservationTime, setReservationTime] = React.useState<number>(1);

  const [result, setResult] = React.useState<Reservation | null>(null);
  const [notCreated, setNoCreated] = React.useState<boolean>(false);

  const handleChange = (event: SelectChangeEvent) => {
    setReservationTime(JSON.parse(event.target.value));
  };
  
  const handleOnClick = async () => {
    const combinedDateTime = dayjs(`${date.format("YYYY-MM-DD")}T${time?.format("HH")}:00:00`);

    const res = await makeReservation({
      reservationDuration: reservationTime,
      startReservationTime: combinedDateTime.toISOString(),
      numberOfPeople: numberOfPeople,
      restaurantId: restaurant.id,
      phoneNumber: "0770157915",
    })
    if(res.notCreated){
      setNoCreated(true)
      return
    }
    setResult(res)
  }

  return(
    <>
      <Box sx={{
        display: "flex",
        justifyContent: "center",
        flexDirection: "column",
        backgroundColor: "#fff",
        color: "#000",
        gap: "2rem",
        px: "1rem",
        py: "2rem",
        borderRadius: "1rem"
      }}>
        <Box sx={{
          display: "flex",
          alignItems: "center",
          flexDirection: "column",
          gap: "1rem",
        }}>
          <Box sx={{
            width: "fit-content"
          }}>
            <LocalizationProvider dateAdapter={AdapterDayjs}>
              <DateCalendar value={date} onChange={(newValue) => {
                setDate(newValue)
              }} />
            </LocalizationProvider>
          </Box>
          <Box sx={{
            width: "fit-content"
          }}>
            <LocalizationProvider dateAdapter={AdapterDayjs}>
              <TimePicker value={time} onChange={(newValue) => setTime(newValue)} views={['hours']} />
            </LocalizationProvider>
          </Box>
          <Box sx={{
            width: "fit-content"
          }}>
            <FormControl sx={{ m: 1, minWidth: 120 }} size="small">
              <InputLabel id="reservation-time-label">Reservation Time</InputLabel>
              <Select
                labelId="reservation-time-label"
                id="reservation-time"
                value={reservationTime.toString()}
                label="Reservation Time"
                onChange={handleChange}
              >
                <MenuItem value={0.5}>30 min</MenuItem>
                <MenuItem value={1.0}>1 hour</MenuItem>
                <MenuItem value={1.5}>1.5 hours</MenuItem>
                <MenuItem value={2.0}>2 hours</MenuItem>
                <MenuItem value={2.5}>2.5 hours</MenuItem>
                <MenuItem value={3.0}>3 hours</MenuItem>
              </Select>
            </FormControl>
          </Box>
          <Box
            component="form"
            sx={{
              '& > :not(style)': { m: 1, width: '25ch' },
            }}
            noValidate
            autoComplete="off"
          >
            <TextField
              type="number"
              id="number-of-people"
              label="NumberOfPeople"
              value={numberOfPeople}
              onChange={(event: React.ChangeEvent<HTMLInputElement>) => {
                setNumberOfPeople(JSON.parse(event.target.value));
              }}
            />
            <TextField
              type="text"
              id="phone-number"
              label="PhoneNumber"
              value={phoneNumber}
              onChange={(event: React.ChangeEvent<HTMLInputElement>) => {
                setPhoneNumber(event.target.value);
              }}
            />
          </Box>
        </Box>
        {notCreated === true ? <Typography sx={{textAlign: "center"}}>Nu mai exista mese libere</Typography> :
          !result ? 
          <Button variant="outlined" sx={{
            width: "fit-content",
            margin: "auto",
          }} onClick={handleOnClick}>
            Reserve
          </Button> : 
          <Box sx={{
            textAlign: "center"
          }}>
            <Typography>
              Your reserved tables are:
            </Typography>
            <Box sx={{
              display: "flex",
              flexDirection: "column",
              gap: "0.5rem",
              mt: "1rem"
            }}>
              {result.tables.map(x=>
                <Typography key={x.id}>
                  Tables id: {x.id} Seats: {x.seats}
                </Typography>
              )}
            </Box>
          </Box>
        }
      </Box>
    </>
  )
}

export default ReservationComponent