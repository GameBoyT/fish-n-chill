import * as React from 'react'
import Button from '@mui/material/Button'
import Card from '@mui/material/Card'
import CardActions from '@mui/material/CardActions'
import CardContent from '@mui/material/CardContent'
import CardMedia from '@mui/material/CardMedia'
import Grid from '@mui/material/Grid'
import Box from '@mui/material/Box'
import Typography from '@mui/material/Typography'
import Container from '@mui/material/Container'
import FormControl from '@mui/material/FormControl';
import InputLabel from '@mui/material/InputLabel';
import MenuItem from '@mui/material/MenuItem';
import Select from '@mui/material/Select';
import TextField from '@mui/material/TextField';
import Rating from '@mui/material/Rating';
import Divider from '@mui/material/Divider'

const AllCottages = ({ cottages, handleChange, handleSelect }) => {
  return (
    <>
      <main>
        <Box sx={{ backgroundColor: 'grey.300', width: '100%' }}>
          <TextField
            id="searchCottages"
            sx={{ mt: 0.5, ml: 55, flex: 1, width: '25%' }}
            variant="filled"
            size="small"
            placeholder="Search cottages"
            inputProps={{ 'aria-label': 'search google maps', style: { textAlign: 'center', fontSize: 22 } }}
            onChange={(e) => handleChange(e.target)}
          />
          <FormControl variant='filled'
            sx={{ mt: 0.5, ml: 0, flex: 1, width: '10%' }}>
            <InputLabel >Search by</InputLabel>
            <Select
              defaultValue=""
              size="large"
              labelId="searchFilter"
              id="searchFilter"
              label="Search by"
              onChange={(e) => { handleSelect(e); searchCottages.value = ''; handleChange(searchCottages); }}
            >
              <MenuItem value={'name'}>Name</MenuItem>
              <MenuItem value={'description'}>Description</MenuItem>
              <MenuItem value={'address'}>Adress</MenuItem>
              <MenuItem value={'anything'}>Anything</MenuItem>
            </Select>
          </FormControl>
          <Box sx={{ minWidth: 120 }}>
          </Box>
        </Box>

        <Container sx={{ py: 8 }} maxWidth="md">
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
                    <Typography borderBottom={1} gutterBottom variant="h5" component="h2" align="center">
                      {cottage.name}
                    </Typography>
                    <Typography variant="subtitle2" align="center">
                      {cottage.address}
                    </Typography>
                    <Typography variant="subtitle2" component="div" align="center">
                      {cottage.availabilityStart[2] ?? "#Not available#"}.{cottage.availabilityStart[1]}.{cottage.availabilityStart[0]} - {cottage.availabilityEnd[2] ?? "#Not available#"}.{cottage.availabilityEnd[1]}.{cottage.availabilityEnd[0]}
                    </Typography>
                    <Divider variant="middle" sx={{ mb: 0.5 }} />

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
                    <Divider variant="middle" />
                  </CardContent>
                  <Box><Typography variant="subtitle2" align="left" sx={{ ml: 1 }} display="inline">
                    {cottage.price}€/day
                  </Typography>
                  <Typography variant="subtitle2" display="inline" sx={{ ml: 18 }}>
                    {cottage.capacity}&#128100;
                  </Typography></Box>
                  
                  <CardActions>
                    <Button size="small" href={'cottages/' + cottage.id} variant="contained">
                      View
                    </Button>
                    <Rating name="read-only" value={cottage.ratingAverage ?? 0} precision={0.5} readOnly sx={{ ml: 7 }} />
                  </CardActions>
                </Card>
              </Grid>
            ))}
          </Grid>
        </Container>
      </main>
    </>
  )
}

export default AllCottages