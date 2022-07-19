import { useState, useEffect } from 'react'
import AllAdventures from '../../components/AllAdventures'
import adventureService from '../../services/adventure'

let filter = 'anything'

const Adventures = () => {
  const [adventures, setAdventures] = useState([])

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

  const fetchData = async () => setAdventures(await adventureService.getAll())
  const fetchByName = async (name) => setAdventures(await adventureService.getByNameContaining(name))
  const fetchByDescription = async (description) =>
    setAdventures(await adventureService.getByDescriptionContaining(description))
  const fetchByAddress = async (address) => setAdventures(await adventureService.getByAddressContaining(address))
  const fetchByAnything = async (anything) => setAdventures(await adventureService.getByAnything(anything))

  return (
    <>
      <AllAdventures
        adventures={adventures}
        handleChange={(e) => handleChange(e)}
        handleSelect={(e) => handleSelect(e)}
      />
    </>
  )
}

export default Adventures
