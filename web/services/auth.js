import axios from 'axios'
const baseUrl = process.env.NEXT_PUBLIC_API_URL + 'auth'

const getAll = async () => {
  const res = await axios.get(baseUrl)
  return res.data
}

const create = async (newObject) => {
  const res = await axios.post(baseUrl, newObject)
  return res.data
}

const update = async (newObject) => {
  const res = await axios.put(baseUrl + newObject.id, newObject)
  return res.data
}

const remove = async (id) => {
  await axios.delete(baseUrl + id)
}

const authService = { getAll, create, update, remove }

export default authService
