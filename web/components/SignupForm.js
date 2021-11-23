import { Formik, Field, Form } from 'formik'
import { TextField } from 'formik-mui'
import * as Yup from 'yup'

const SignupSchema = Yup.object({
  password: Yup.string().required('Password is required'),
  passwordConfirmation: Yup.string()
    .required()
    .oneOf([Yup.ref('password'), null], 'Passwords must match'),
})

const SignupForm = ({ handleSignup }) => (
  <div>
    <h1>Signup</h1>
    <Formik
      initialValues={{
        firstName: '',
        lastName: '',
        username: '',
        password: '',
        passwordConfirmation: '',
        email: '',
      }}
      validationSchema={SignupSchema}
      onSubmit={async (values) => {
        alert(JSON.stringify(values, null, 2))
        console.log(values)
        handleSignup(values)
      }}
    >
      <Form>
        <label htmlFor="firstName">First Name</label>
        <Field id="firstName" component={TextField} name="firstName" placeholder="first name" />

        <label htmlFor="lastName">Last Name</label>
        <Field id="lastName" name="lastName" placeholder="last name" />

        <label htmlFor="username">Username</label>
        <Field id="username" name="username" placeholder="username" type="text" />

        <label htmlFor="password">Password</label>
        <Field id="password" name="password" placeholder="password" type="password" />

        <label htmlFor="passwordConfirmation">Confirm Password</label>
        <Field id="passwordConfirmation" name="passwordConfirmation" placeholder="password" type="password" />

        <label htmlFor="email">Email</label>
        <Field id="email" name="email" placeholder="email@abc.com" type="email" />
        <button type="submit">Submit</button>
      </Form>
    </Formik>
  </div>
)

export default SignupForm
