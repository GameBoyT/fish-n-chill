import axios from 'axios'
const baseUrl = process.env.NEXT_PUBLIC_API_URL + 'users/'

const getMe = async () => {
    const res = await axios.get(baseUrl + 'whoami/')
    return res.data
  }

const userService = {
    getMe
  }
  
  export default userService