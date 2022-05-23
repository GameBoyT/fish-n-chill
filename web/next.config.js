module.exports = {
  reactStrictMode: true,
  images: {
    domains: ['i.ibb.co'],
  },
  async rewrites() {
    return [
      {
        source: '/api/:path*',
        destination: 'https://localhost:8080/api/:path*',
      },
    ]
  },
}
