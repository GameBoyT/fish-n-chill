import axios from 'axios'
const baseUrl = 'http://localhost:8080/api/auth'

let token = null
let config = null

const setToken = (newToken) => {
  token = `bearer ${newToken}`
  config = {
    headers: { Authorization: token },
  }
}

const getAll = async () => {
  const res = await axios.get(baseUrl, config)
  return res.data
}

const create = async (newObject) => {
  const res = await axios.post(baseUrl, newObject, config)
  return res.data
}

const update = async (newObject) => {
  const res = await axios.put(baseUrl + newObject._id, newObject, config)
  return res.data
}

const remove = async (id) => {
  await axios.delete(baseUrl + id, config)
}

export { getAll, setToken, create, update, remove }
