import axios from 'axios'
const baseUrl = process.env.NEXT_PUBLIC_API_URL + 'cottages/'

const getAll = async () => {
  const res = await axios.get(baseUrl)
  return res.data
}

const getById = async (id) => {
  const res = await axios.get(baseUrl + id)
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

const cottageService = {
  getAll,
  getById,
  create,
  update,
  remove,
}

export default cottageService