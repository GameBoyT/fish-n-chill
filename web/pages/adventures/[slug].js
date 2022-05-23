import { useRouter } from 'next/router'
import { useState, useEffect } from 'react'
import adventureService from '../../services/adventure'
import AdventureProfile from '../../components/AdventureProfile'

const Adventure = () => {
  const router = useRouter()
  const { slug } = router.query
  const [adventure, setAdventure] = useState({})

  useEffect(() => {
    const fetchData = async () => setAdventure(await adventureService.getById(slug))
    router.isReady ? fetchData() : console.log('router not ready')
  }, [slug])

  if (Object.keys(adventure).length === 0) {
    return (<div>Loading....</div>)
  }

  return (
    <>
      <AdventureProfile adventure={adventure} />
    </>
  )
}

export default Adventure
