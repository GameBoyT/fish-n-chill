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
    const fetchData = async () => setCottage(await cottageService.getById(slug))
    setLoggedInUser(JSON.parse(window.localStorage.getItem('loggedInUser')))

    router.isReady ? fetchData() : console.log('router not ready')
  }, [slug])

  return (
    <>
      <CottageProfile loggedInUser={loggedInUser} cottage={cottage}/>
    </>
  )
}

export default Cottage
