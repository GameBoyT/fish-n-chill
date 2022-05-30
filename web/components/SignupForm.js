import { Formik, Field, Form } from 'formik'
import { Box, Typography, Button, Container } from '@mui/material'
import { TextField } from 'formik-mui'
import * as Yup from 'yup'

const SignupSchema = Yup.object({
  password: Yup.string().required('Password is required'),
  passwordConfirmation: Yup.string()
    .required()
    .oneOf([Yup.ref('password'), null], 'Passwords must match'),
})

const SignupForm = ({ handleSignup }) => (
  <Container component="main" maxWidth="xs">
    <Box
      sx={{
        marginTop: 8,
        display: 'flex',
        flexDirection: 'column',
        alignItems: 'center',
      }}
    >
      <Typography component="h1" variant="h5">
        Sign up
      </Typography>
      <Formik
        initialValues={{
          firstName: '',
          lastName: '',
          email: '',
          username: '',
          password: '',
          passwordConfirmation: '',
        }}
        validationSchema={SignupSchema}
        onSubmit={async (values) => {
          handleSignup(values)
        }}
      >
        <Form>
          <Field
            id="firstName"
            margin="normal"
            required
            fullWidth
            component={TextField}
            label="first name"
            name="firstName"
            type="text"
          />
          <Field
            id="lastName"
            margin="normal"
            required
            fullWidth
            component={TextField}
            label="last name"
            name="lastName"
            type="text"
          />
          <Field
            id="email"
            margin="normal"
            required
            fullWidth
            component={TextField}
            label="email"
            name="email"
            type="email"
          />
          <Field
            id="username"
            margin="normal"
            required
            fullWidth
            component={TextField}
            label="username"
            name="username"
            type="text"
          />
          <Field
            id="password"
            required
            fullWidth
            margin="normal"
            component={TextField}
            label="password"
            name="password"
            type="password"
          />
          <Field
            id="passwordConfirmation"
            required
            fullWidth
            margin="normal"
            component={TextField}
            label="passwordConfirmation"
            name="passwordConfirmation"
            type="password"
          />
          <Button type="submit" fullWidth variant="contained" sx={{ mt: 3, mb: 2 }}>
            Sign Up
          </Button>
        </Form>
      </Formik>
    </Box>
  </Container>
)

export default SignupForm
