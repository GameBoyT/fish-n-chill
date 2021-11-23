module.exports = {
  reactStrictMode: true,
  async rewrites() {
    return [
      {
        source: '/api/:path*',
        destination: 'https://localhost:8080/api/:path*',
      },
    ]
  },
}
