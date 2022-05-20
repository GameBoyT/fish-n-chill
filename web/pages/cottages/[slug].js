import { useRouter } from 'next/router'
import { useState, useEffect } from 'react'
import CottageProfile from '../../components/CottageProfile'
import cottageService from '../../services/cottage'

const Cottage = () => {
  const router = useRouter()
  const { slug } = router.query
  const [cottage, setCottage] = useState({})

  useEffect(() => {
    const fetchData = async () => setCottage(await cottageService.getById(slug))
    router.isReady ? fetchData() : console.log('router not ready')
  }, [slug])

  if (Object.keys(cottage).length === 0) {
    return (<div>Loading....</div>)
  }

  return (
    <>
      <CottageProfile cottage={cottage} />
    </>
  )
}

export default Cottage
