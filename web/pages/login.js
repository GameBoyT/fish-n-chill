import LoginForm from '../components/LoginForm'
import loginService from '../services/login'

const Login = () => {
  const handleLogin = async (credentials) => {
    try {
      const loggedInUser = await loginService.login(credentials)
      window.localStorage.setItem('loggedInUser', JSON.stringify(loggedInUser))

      console.log('login successful')
    } catch (exception) {
      console.log(exception)
    }
  }

  return (
    <div>
      <LoginForm handleLogin={handleLogin} />
    </div>
  )
}

export default Login
