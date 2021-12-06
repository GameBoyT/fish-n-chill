import { useRouter } from 'next/router'
import { useState, useEffect } from 'react'
import cottageService from '../../services/cottage'

const Cottage = () => {
  const router = useRouter()
  const { slug } = router.query

  const [cottage, setCottage] = useState({})

  useEffect(() => {
    const fetchData = async () => setCottage(await cottageService.getById(slug))

    router.isReady ? fetchData() : console.log('router not ready')
  }, [slug])

  return <>{cottage.name}</>
}

export default Cottage
