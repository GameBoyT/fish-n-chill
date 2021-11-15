import { Formik, Field, Form } from 'formik';

const LoginForm = ({ handleLogin }) => (
  <div>
    <h1>Login</h1>
    <Formik
      initialValues={{
        username: '',
        password: '',
      }}
      onSubmit={async (values) => {
        handleLogin(values)
      }}
    >
      <Form>
        <label htmlFor="username">Username</label>
        <Field
          id="username"
          name="username"
          placeholder="username"
          type="text"
        />
        
        <label htmlFor="password">Password</label>
        <Field
          id="password"
          name="password"
          placeholder="password"
          type="password"
        />
        <button type="submit">Submit</button>
      </Form>
    </Formik>
  </div>
)

export default LoginForm