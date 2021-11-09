import React, { useState, useEffect, useRef } from 'react'
import LoginForm from '../components/LoginForm'
import authService from '../services/auth'
import loginService from '../services/login'

const Login = () => {
  const [user, setUser] = useState(null)

  const handleLogin = async ( credentials ) => {
    try {
      const loggedInUser = await loginService.login(credentials)

      window.localStorage.setItem(
        'loggedInUser', JSON.stringify(loggedInUser)
      )
      authService.setToken(loggedInUser.token)


      setUser(loggedInUser)

      // setNotificationMessage(`Welcome ${user.name}`)
      // setTimeout(() => {
      //   setNotificationMessage(null)
      // }, 5000)
      console.log('gud')

    } catch (exception) {
      // setNotificationMessage('Wrong credentials')
      // setNotificationType('error')
      // setTimeout(() => {
      //   setNotificationMessage(null)
      //   setNotificationType(null)
      // }, 5000)
      console.log('exception')
    }
  }

  return (
    <div>
      <LoginForm handleLogin={handleLogin} />
    </div>
  )
}

export default Login