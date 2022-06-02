import { useState, useEffect } from 'react'
import userService from '../../../services/user'
import UserProfile from '../../../components/UserProfile'

const User = () => {
  const [user, setUser] = useState({})

  useEffect(() => {
    fetchData()
  }, [])

  const fetchData = async () => setUser(await userService.getMe())

  if (Object.keys(user).length === 0) {
    return (<div>Loading....</div>)
  }
  return (
    <>
      <UserProfile user={user}></UserProfile>
    </>
  )
}

export default User