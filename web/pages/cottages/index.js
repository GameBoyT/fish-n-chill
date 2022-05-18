import { useState, useEffect } from 'react'
import AllCottages from '../../components/AllCottages'
import cottageService from '../../services/cottage'

let filter = 'anything';

const Cottages = () => {
  const [cottages, setCottages] = useState([])

  useEffect(() => {
    fetchData()
  }, [])

  function handleChange(e) {
    if (e.value.length < 3) fetchData()
    else if (filter == 'name') fetchByName(e.value)
    else if (filter == 'description') fetchByDescription(e.value)
    else if (filter == 'anything') fetchByNameOrDescription(e.value)
  }

  function handleSelect(e) {
    filter = e.target.value
  }

  const fetchData = async () => setCottages(await cottageService.getAll())
  const fetchByName = async (name) => setCottages(await cottageService.getByNameContaining(name))
  const fetchByDescription = async (description) => setCottages(await cottageService.getByDescriptionContaining(description))
  const fetchByNameOrDescription = async (name) => setCottages(await cottageService.getByNameOrDescriptionContaining(name))

  return (
    <>
      <AllCottages cottages={cottages} handleChange={(e) => handleChange(e)} handleSelect={(e) => handleSelect(e)} />
    </>
  )
}

export default Cottages