import { useState, useEffect } from 'react'
import AllBoats from '../../components/AllBoats';
import boatService from '../../services/boat';


let filter = 'anything';

const Boats = () => {
  const [boats, setBoats] = useState([])

  useEffect(() => {
    fetchData()
  }, [])

  function handleChange(e) {
    if (e.value.length < 3) fetchData()
    else if (filter == 'name') fetchByName(e.value)
    else if (filter == 'description') fetchByDescription(e.value)
    else if (filter == 'address') fetchByAddress(e.value)
    else if (filter == 'anything') fetchByAnything(e.value)
  }

  function handleSelect(e) {
    filter = e.target.value
  }

  const fetchData = async () => setBoats(await boatService.getAll())
  const fetchByName = async (name) => setBoats(await boatService.getByNameContaining(name))
  const fetchByDescription = async (description) => setBoats(await boatService.getByDescriptionContaining(description))
  const fetchByAddress = async (address) => setBoats(await boatService.getByAddressContaining(address))
  const fetchByAnything = async (anything) => setBoats(await boatService.getByAnything(anything))

  return (
    <>
      <AllBoats boats={boats} handleChange={(e) => handleChange(e)} handleSelect={(e) => handleSelect(e)} />
    </>
  )
}

export default Boats