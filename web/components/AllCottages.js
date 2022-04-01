import * as React from 'react';
import AppBar from '@mui/material/AppBar';
import Button from '@mui/material/Button';
import Card from '@mui/material/Card';
import CardActions from '@mui/material/CardActions';
import CardContent from '@mui/material/CardContent';
import CardMedia from '@mui/material/CardMedia';
import Grid from '@mui/material/Grid';
import Box from '@mui/material/Box';
import Typography from '@mui/material/Typography';
import Container from '@mui/material/Container';
import { InputBase } from '@mui/material';
import LoggedOutNavBar from './LoggedOutNavBar';
import LoggedInNavBar from './LoggedInNavBar';


const AllCottages = ({ loggedInUser, cottages, handleChange }) => {
  return (
    <>
      <AppBar position="relative">
        {loggedInUser ? <LoggedInNavBar /> : <LoggedOutNavBar />}
      </AppBar>
      <main>
        {/* Hero unit */}
        <Box>
          <InputBase
            sx={{ ml: 65, flex: 1, width: '25%' }}
            size='large'
            placeholder="Search cottages"
            inputProps={{ 'aria-label': 'search google maps', style: { textAlign: 'center', fontSize: 25 } }}
            onChange={(e) => handleChange(e)}
          />
        </Box>
        <Container sx={{ py: 8 }} maxWidth="md">
          {/* End hero unit */}
          <Grid container spacing={4}>
            {cottages.map((cottage) => (
              <Grid item key={cottage.id} xs={12} sm={6} md={4}>
                <Card sx={{ height: '100%', display: 'flex', flexDirection: 'column' }}>
                  <CardMedia
                    component="img"
                    sx={{
                      pt: '0%',
                    }}
                    image={cottage.images[0].url}
                    alt="random"
                  />
                  <CardContent sx={{ flexGrow: 1 }}>
                    <Typography gutterBottom variant="h5" component="h2">
                      {cottage.name}
                    </Typography>
                    <Typography
                      sx={{
                        display: '-webkit-box',
                        overflow: 'hidden',
                        WebkitBoxOrient: 'vertical',
                        WebkitLineClamp: 4,
                      }}
                    >
                      {cottage.description}
                    </Typography>
                  </CardContent>
                  <CardActions>
                    <Button size="small" href={'cottage/' + cottage.id}>
                      View
                    </Button>
                  </CardActions>
                </Card>
              </Grid>
            ))}
          </Grid>
        </Container>
      </main>
    </>
  );
}

export default AllCottages
