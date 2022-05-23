import { useRouter } from 'next/router'
import { useState, useEffect } from 'react'
import boatService from '../../services/boat'
import BoatProfile from '../../components/BoatProfile'

const Boat = () => {
  const router = useRouter()
  const { slug } = router.query
  const [boat, setBoat] = useState({})

  useEffect(() => {
    const fetchData = async () => setBoat(await boatService.getById(slug))
    router.isReady ? fetchData() : console.log('router not ready')
  }, [slug])

  if (Object.keys(boat).length === 0) {
    return (<div>Loading....</div>)
  }

  return (
    <>
      <BoatProfile boat={boat} />
    </>
  )
}

export default Boat
