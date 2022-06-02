import axios from 'axios'
const baseUrl = process.env.NEXT_PUBLIC_API_URL + 'users/'

const getMe = async () => {
  const res = await axios.get(baseUrl + 'whoami/')
  return res.data
}

const updateUser = async (credentials) => {
  const response = await axios.post(baseUrl + 'update/', credentials)
  return response.data
}

const userService = {
  getMe,
  updateUser
}

export default userService