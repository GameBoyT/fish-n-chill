import LoginForm from '../components/LoginForm'
import authService from '../services/auth'
import loginService from '../services/login'

const Login = () => {

  const handleLogin = async ( credentials ) => {
    try {
      const loggedInUser = await loginService.login(credentials)
      window.localStorage.setItem(
        'loggedInUser', JSON.stringify(loggedInUser)
      )
      authService.setToken(loggedInUser.token)

      console.log('gud')
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