import SignupForm from '../components/SignupForm'
import signupService from '../services/signup'

const Signup = () => {
  const handleSignup = async (credentials) => {
    try {
      await signupService.signup(credentials)
      console.log('signed up')
    } catch (exception) {
      console.log(exception)
    }
  }

  return (
    <div>
      <SignupForm handleSignup={handleSignup} />
    </div>
  )
}

export default Signup
