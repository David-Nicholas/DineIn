"use client"

import { makeReservation } from "@/app/actions";
import { Box, Button } from "@mui/material"
import React from "react";
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


type RestaurantPageProps = {
  params: {
    id: string;
  }
};

const RestaurantPage = ({params}: RestaurantPageProps) => {

  const [time, setTime] = React.useState<Dayjs | null>(dayjs());
  const [date, setDate] = React.useState<Dayjs>(dayjs());  

  const [numberOfPeople, setNumberOfPeople] = React.useState<number>(2);  
  const [reservationTime, setReservationTime] = React.useState<number>(1);

  const handleChange = (event: SelectChangeEvent) => {
    setReservationTime(JSON.parse(event.target.value));
  };
  
  const handleOnClick = async () => {
    const combinedDateTime = dayjs(`${date.format("YYYY-MM-DD")}T${time?.format("HH")}:00:00`);

    const res = await makeReservation({
      reservationDuration: reservationTime,
      startReservationTime: combinedDateTime.toISOString(),
      numberOfPeople: numberOfPeople,
      restaurantId: JSON.parse(params.id),
      phoneNumber: "0770157915",
    })
  }

  return(
    <>
      <Box sx={{
        display: "flex",
        justifyContent: "center",
        flexDirection: "column"
      }}>
        <Box sx={{
          display: "flex",
          alignItems: "center",
          flexDirection: "column",
        }}>
          <Box sx={{
            backgroundColor: "#fff",
            color: "#000",
            width: "fit-content"
          }}>
            <LocalizationProvider dateAdapter={AdapterDayjs}>
              <DateCalendar value={date} onChange={(newValue) => {
                setDate(newValue)
              }} />
            </LocalizationProvider>
          </Box>
          <Box sx={{
            backgroundColor: "#fff",
            color: "#000",
            width: "fit-content"
          }}>
            <LocalizationProvider dateAdapter={AdapterDayjs}>
              <TimePicker value={time} onChange={(newValue) => setTime(newValue)} views={['hours']} />
            </LocalizationProvider>
          </Box>
          <Box sx={{
            backgroundColor: "#fff",
            color: "#000",
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
              backgroundColor: "#fff",
              color: "#000",
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
          </Box>
        </Box>
        <Button onClick={handleOnClick}>
          Click me
        </Button>
      </Box>
    </>
  )
}

export default RestaurantPage