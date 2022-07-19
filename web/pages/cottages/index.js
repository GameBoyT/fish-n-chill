import { useState, useEffect } from 'react'
import AllCottages from '../../components/AllCottages'
import cottageService from '../../services/cottage'

let filter = 'anything'

const Cottages = () => {
  const [cottages, setCottages] = useState([])

  useEffect(() => {
    fetchData()
  }, [])

  function handleChange(e) {
    if (e.value.length < 3) fetchData()
    else if (filter === 'name') fetchByName(e.value)
    else if (filter === 'description') fetchByDescription(e.value)
    else if (filter === 'address') fetchByAddress(e.value)
    else if (filter === 'anything') fetchByAnything(e.value)
  }

  function handleSelect(e) {
    filter = e.target.value
  }

  function compare(a, b) {
    if (a.name < b.name) {
      return -1
    }
    if (a.name > b.name) {
      return 1
    }
    return 0
  }

  function handleSort() {}

  const fetchData = async () => setCottages(await cottageService.getAll())
  const fetchByName = async (name) => setCottages(await cottageService.getByNameContaining(name))
  const fetchByAddress = async (address) => setCottages(await cottageService.getByAddressContaining(address))
  const fetchByDescription = async (description) =>
    setCottages(await cottageService.getByDescriptionContaining(description))
  const fetchByAnything = async (anything) => setCottages(await cottageService.getByAnything(anything))

  return (
    <>
      <AllCottages
        cottages={cottages}
        handleChange={(e) => handleChange(e)}
        handleSelect={(e) => handleSelect(e)}
        handleSort={(e) => handleSort(e)}
      />
    </>
  )
}

export default Cottages
