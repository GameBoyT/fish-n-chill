import { useState, useEffect } from 'react'
import HomePage from '../components/HomePage'

const Index = () => {
  const [loggedInUser, setLoggedInUser] = useState([])
  useEffect(() => {
    setLoggedInUser(JSON.parse(window.localStorage.getItem('loggedInUser')))
  }, []);
  return (
    <>
      <HomePage loggedInUser={loggedInUser} />
    </>
  )
}

export default Index
