import { Box, Divider, Typography, Container, Skeleton, Paper, Rating, Button } from '@mui/material'


const UserProfile = ({ user }) => {
console.log(user)
  return (
    <>
      <Container component="main" maxWidth="sm">
        <Box
          sx={{
            marginTop: 8,
            display: 'flex',
            flexDirection: 'column',
            mb: 8
          }}
        >
          <Paper>
            <Typography variant="h4"  align="left" component="div" sx={{ ml: 1, mr: 1 }}>
              {user.username}
            </Typography>
            
            <Typography variant="h6" display="inline"  align="left"  component="div" sx={{ ml: 1, mr: 1 }}>
              Email:
            </Typography>
            <Typography variant="h5" display="inline" align="left"  component="div" sx={{ ml: 1, mr: 1 }}>
              {user.email}
            </Typography>
            <Divider></Divider>
            <Typography variant="h6" display="inline"  align="left"  component="div" sx={{ ml: 1, mr: 1 }}>
              Full name:
            </Typography>
            <Typography variant="h5" display="inline" align="left"  component="div" sx={{ ml: 1, mr: 1 }}>
              {user.firstName} {user.lastName}
            </Typography>
            <Divider></Divider>
            <Button size="small" href='/' variant="contained" sx={{ml:2, mb:2, mt:2}}>
              Change password
            </Button>
          </Paper>
        </Box>
      </Container>
    </>
  )
}

export default UserProfile
