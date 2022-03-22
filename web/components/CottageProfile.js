import { Box, Divider, Typography, Container, Skeleton, Paper } from '@mui/material'
import Image from 'next/image'
import AppBar from '@mui/material/AppBar'
import UnregNavBar from './UnregNavBar'
import RegNavBar from './RegNavBar'


const CottageProfile = ({ loggedInUser, cottage }) => {
  return (
    <>
      <AppBar position="relative">
        {loggedInUser ? <RegNavBar /> : <UnregNavBar />}
      </AppBar>
      <Container component="main" maxWidth="md">
        <Box
          sx={{
            marginTop: 8,
            display: 'flex',
            flexDirection: 'column',
            alignItems: 'center',
          }}
        >
          <Paper>
            <Typography variant="h3" mx="auto" align="center" gutterBottom component="div">
              {cottage.name}
            </Typography>
            {cottage.images ? (
              <Image width={600} height={400} src={cottage.images[0].url} alt="cottage" />
            ) : (
              <Skeleton variant="rectangular" width={600} height={400} />
            )}
            <Divider variant="middle" />
            <Typography variant="h5" gutterBottom component="div">
              {cottage.description}
            </Typography>
          </Paper>
        </Box>
      </Container>
    </>
  )
}

export default CottageProfile
