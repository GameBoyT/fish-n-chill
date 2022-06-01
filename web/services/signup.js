import axios from 'axios'
const baseUrl = process.env.NEXT_PUBLIC_AUTH_URL + 'signup/client'

const signup = async (credentials) => {
  const response = await axios.post(baseUrl, credentials)
  return response.data
}

const signupService = { signup }

export default signupService
