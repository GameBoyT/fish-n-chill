import LoginForm from '../components/LoginForm'
import loginService from '../services/login'

const Login = () => {
  const handleLogin = async (credentials) => {
    try {
      const loggedInUser = await loginService.login(credentials)
      window.localStorage.setItem('loggedInUser', JSON.stringify(loggedInUser))
      window.location.href = 'http://localhost:3000'
    } catch (exception) {
      console.log(exception)
    }
  }

  return (
    <>
      <LoginForm handleLogin={handleLogin} />
    </>
  )
}

export default Login
