import { Box, Divider, Typography, Container, Skeleton, Paper, Rating, Button, TextField } from '@mui/material'
import { DatePicker } from '@mui/x-date-pickers'
import Image from 'next/image'
import { useState, useEffect } from 'react'
import dateUtils from '../utils/dateUtils'

const CottageProfile = ({ cottage, scheduleReservation }) => {
  const [loggedInUser, setLoggedInUser] = useState(null)
  const [checkInDate, setCheckInDate] = useState(null)
  const [checkOutDate, setCheckOutDate] = useState(null)
  const [penalty, setPenalty] = useState(null)

  useEffect(() => {
    setLoggedInUser(JSON.parse(window.localStorage.getItem('loggedInUser')))
    setPenalty(JSON.parse(window.localStorage.getItem('penalty')))
  }, [])

  const onReservationButtonClick = () => {
    const reservation = {
      // Pomjera datum za vremensku zonu da bi bila UTC kad se salju na back
      reservationStart: dateUtils.toUtcDate(checkInDate),
      reservationEnd: dateUtils.toUtcDate(checkOutDate),
      entityId: cottage.id,
    }
    scheduleReservation(reservation)
  }

  return (
    <>
      <Container component="main" maxWidth="lg">
        <Box
          sx={{
            marginTop: 8,
            display: 'flex',
            flexDirection: 'column',
            alignItems: 'center',
            mb: 8,
          }}
        >
          <Paper>
            <Typography variant="h3" mx="auto" align="center" gutterBottom component="div" sx={{ ml: 1, mr: 1 }}>
              {cottage.name}
            </Typography>
            <Box textAlign="center">
              <Rating size="large" name="read-only" value={cottage.ratingAverage ?? 0} precision={0.5} readOnly />
              <Typography
                variant="subtitle1"
                mx="auto"
                align="center"
                gutterBottom
                component="div"
                sx={{ ml: 1, mr: 1 }}
              >
                ({cottage.ratingCount} ratings)
              </Typography>
            </Box>
            <div
              style={{
                display: 'flex',
                justifyContent: 'center',
                marginTop: '20px',
              }}
            >
              {cottage.images ? (
                <Image width={600} height={400} src={cottage.images[0].url} alt="cottage" />
              ) : (
                <Skeleton variant="rectangular" width={600} height={400} />
              )}
            </div>

            <Divider variant="middle" sx={{ mt: 1 }} />
            <Typography variant="h5" fontWeight="fontWeightMedium" sx={{ ml: 3, mr: 3 }} display="inline">
              Address:
            </Typography>
            <Typography variant="h5" gutterBottom component="div" sx={{ mr: 3 }} display="inline">
              {cottage.address}
            </Typography>
            <div></div>
            <Typography variant="h5" fontWeight="fontWeightMedium" sx={{ ml: 3, mr: 3 }} display="inline">
              Price:
            </Typography>
            <Typography variant="h5" gutterBottom component="div" sx={{ mr: 3 }} display="inline">
              {cottage.price}???/day
            </Typography>
            <div></div>
            <Typography variant="h5" fontWeight="fontWeightMedium" sx={{ ml: 3, mr: 3 }} display="inline">
              Available:
            </Typography>
            <Typography variant="h5" gutterBottom component="div" sx={{ mr: 3 }} display="inline">
              {cottage.availabilityStart.toLocaleDateString('en-UK')}
            </Typography>
            <Typography variant="h5" fontWeight="fontWeightMedium" sx={{ mr: 2 }} display="inline">
              -
            </Typography>
            <Typography variant="h5" gutterBottom component="div" sx={{ mr: 3 }} display="inline">
              {cottage.availabilityEnd.toLocaleDateString('en-UK')}
            </Typography>
            <div></div>
            <Typography variant="h5" fontWeight="fontWeightMedium" sx={{ ml: 3, mr: 3 }} display="inline">
              Capacity:
            </Typography>
            <Typography variant="h5" gutterBottom component="div" sx={{ mr: 3 }} display="inline">
              {cottage.capacity} people
            </Typography>
            <Typography variant="h5" fontWeight="fontWeightMedium" sx={{ ml: 3, mr: 3 }}>
              Description:
            </Typography>
            <Typography variant="h5" gutterBottom component="div" sx={{ ml: 3, mr: 3 }}>
              {cottage.description}
            </Typography>
            {/*Ako je ulogovan user prikazati dugme za rezervisanje*/}
            <DatePicker
              label="Check-in"
              value={checkInDate}
              disablePast={true}
              onChange={(newValue) => {
                setCheckInDate(newValue)
              }}
              shouldDisableDate={(dateParam) => {
                return checkOutDate === null
                  ? dateParam < cottage.availabilityStart || dateParam > cottage.availabilityEnd
                  : dateParam < cottage.availabilityStart ||
                      dateParam > cottage.availabilityEnd ||
                      dateParam > checkOutDate
              }}
              renderInput={(params) => <TextField {...params} />}
            />
            <DatePicker
              label="Check-out"
              value={checkOutDate}
              disablePast={true}
              onChange={(newValue) => {
                setCheckOutDate(newValue)
              }}
              shouldDisableDate={(dateParam) => {
                return checkInDate === null
                  ? dateParam < cottage.availabilityStart || dateParam > cottage.availabilityEnd
                  : dateParam < cottage.availabilityStart ||
                      dateParam > cottage.availabilityEnd ||
                      dateParam < checkInDate
              }}
              renderInput={(params) => <TextField {...params} />}
            />
            {loggedInUser ? (
              <Button
                onClick={onReservationButtonClick}
                disabled={penalty >= 3}
                size="large"
                variant="contained"
                sx={{ ml: 3, mb: 3 }}
              >
                Schedule Reservation
              </Button>
            ) : (
              // {penalty >= 3 && <p style={{
              //   color: "red",
              //   fontSize: "13px",
              //   marginLeft: "25px",
              //   marginTop: "5px"
              // }}>You have 3 or more penalties and can't schedule reservations</p>}</>
              <></>
            )}
          </Paper>
        </Box>
      </Container>
    </>
  )
}

export default CottageProfile
