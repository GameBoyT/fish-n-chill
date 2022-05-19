import { Box, Divider, Typography, Container, Skeleton, Paper, Rating, Button } from '@mui/material'
import Image from 'next/image'
import { useState, useEffect } from 'react'


const CottageProfile = ({ cottage }) => {
  const [loggedInUser, setLoggedInUser] = useState([])
  useEffect(() => {
    setLoggedInUser(JSON.parse(window.localStorage.getItem('loggedInUser')))
  }, [])
  return (
    <>
      <Container component="main" maxWidth="md">
        <Box
          sx={{
            marginTop: 8,
            display: 'flex',
            flexDirection: 'column',
            alignItems: 'center',
            mb: 8
          }}
        >
          <Paper>
            <Typography variant="h3" mx="auto" align="center" gutterBottom component="div" sx={{ ml: 1, mr: 1 }}>
              {cottage.name}
            </Typography>
            <div
              style={{
                display: "flex",
                justifyContent: "center",
                marginTop: "20px"
              }}
            >
              {cottage.images ? (
                <Image width={600} height={400} src={cottage.images[0].url} alt="cottage" />
              ) : (
                <Skeleton variant="rectangular" width={600} height={400} />
              )}
            </div>

            <Divider variant="middle" sx={{ mt: 1 }} />
            <Typography variant="h5" fontWeight='fontWeightMedium' sx={{ ml: 3, mr: 3 }} display="inline">
              Address:
            </Typography>
            <Typography variant="h5" gutterBottom component="div" sx={{ mr: 3 }} display="inline">
              {cottage.address}
            </Typography>
            <div></div>
            <Rating name="read-only" value={cottage.ratingAverage ?? 0} precision={0.5} readOnly sx={{ ml: 2 }} display="inline" />
            <Typography variant="h5" fontWeight='fontWeightMedium' sx={{ ml: 3, mr: 3 }}>
              Description:
            </Typography>
            <Typography variant="h5" gutterBottom component="div" sx={{ ml: 3, mr: 3 }}>
              {cottage.description}
            </Typography>
            {/*Ako je ulogovan user prikazati dugme za rezervisanje*/}
            {loggedInUser ? <Button size="large" href='/' variant="contained" sx={{ml:3, mb:3}}>
              Create Reservation
            </Button> : <></>}
          </Paper>
        </Box>
      </Container>
    </>
  )
}

export default CottageProfile
