import { useState, useEffect } from 'react'
import AllCottages from "../components/AllCottages";
import cottageService from "../services/cottage"

const Cottages = () => {
  const [cottages, setCottages] = useState([])
  const [loggedInUser, setLoggedInUser] = useState([])

  useEffect(() => {
    fetchData();
    setLoggedInUser(JSON.parse(window.localStorage.getItem('loggedInUser')))
  }, []);

  function handleChange(e) {
    if (e.target.value.length < 3)
      fetchData();
    else if (e.target.value.length >= 3)
      fetchByName(e.target.value);
  }

  const fetchByName = async (name) => setCottages(await cottageService.getByNameContaining(name));


  const fetchData = async () => setCottages(await cottageService.getAll())

  return (
    <>
      <AllCottages loggedInUser={loggedInUser} cottages={cottages} handleChange={(e) => handleChange(e)} />
    </>
  )
}

export default Cottages