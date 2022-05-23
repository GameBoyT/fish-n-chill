import { useRouter } from 'next/router'
import { useState, useEffect } from 'react'
import CottageProfile from '../../components/CottageProfile'
import cottageService from '../../services/cottage'

const Cottage = () => {
  const router = useRouter()
  const { slug } = router.query
  const [cottage, setCottage] = useState({})
  const [loggedInUser, setLoggedInUser] = useState([])

  useEffect(() => {
    setLoggedInUser(JSON.parse(window.localStorage.getItem('loggedInUser')))
  }, [])


  useEffect(() => {
    const fetchData = async () => setCottage(await cottageService.getById(slug))
    router.isReady ? fetchData() : console.log('router not ready')
  }, [slug])

  if (Object.keys(cottage).length === 0) {
    return (<div>Loading....</div>)
  }

  const scheduleReservation = async () => {
    try {
      await cottageService.scheduleReservation()
      console.log('proslo')
    } catch (exception) {
      console.log(exception)
    }
  }

  return (
    <>
      <CottageProfile cottage={cottage} scheduleReservation={() => scheduleReservation()} />
    </>
  )
}

export default Cottage
