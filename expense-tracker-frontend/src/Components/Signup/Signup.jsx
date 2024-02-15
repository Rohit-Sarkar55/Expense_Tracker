import React, { useState } from 'react';
import './Login-Signup.css'; // Import the CSS file for styling

const AuthForm = () => {
  const [showSignUp, setShowSignUp] = useState(false);

  const [signInData, setSignInData] = useState({ email: '', password: '' });
  const [signUpData, setSignUpData] = useState({
fullName: 'zaaa',
    userEmail: '',
    password: '',
    confirmPassword: '',
    phoneNo: '',
  });
  const [errors, setErrors] = useState({});

  const handleSignInChange = (e) => {
    const { name, value } = e.target;
    setSignInData({ ...signInData, [name]: value });
  };

  const handleSignUpChange = (e) => {
    const { name, value } = e.target;
    setSignUpData({ ...signUpData, [name]: value });
  };

  const handleSignInSubmit = async(e)  => {
    e.preventDefault();
    // Add your sign-in logic here

    try{
        console.log('Sign In:', signInData);

      // Replace the following URL with your authentication API endpoint
      const apiUrl = 'http://localhost:8081/user/login';
       
      const response = await fetch(apiUrl, {
        method: 'POST',
        headers: {
          'Content-Type': 'application/json',
        },
        body: JSON.stringify(signInData),
      });

      if (!response.ok) {
        throw new Error('Authentication failed'); // Customize the error message as needed
      }

      const data = await response.json();
      console.alert('Authentication successful:', data);
      localStorage.setItem("user-info" ,"JSON.stringify(data)");
            

    }catch(error){
        console.alert("Error during SignIn " + error.message);
    }



    console.log('Sign In:', signInData);
  };


  const validateSignUpForm = () => {
    const errors = {};

    if (!signUpData.fullName.trim()) {
      errors.fullName = 'Full Name is required';
    }

    if (!signUpData.userEmail.trim()) {
      errors.userEmail = 'Email is required';
    } else if (!/^\S+@\S+\.\S+$/.test(signUpData.userEmail)) {
      errors.userEmail = 'Invalid email format';
    }

    if (!signUpData.password.trim()) {
      errors.password = 'Password is required';
    } else if (signUpData.password.length < 6) {
      errors.password = 'Password must be at least 6 characters long';
    }

    if (signUpData.password !== signUpData.confirmPassword) {
      errors.confirmPassword = 'Passwords do not match';
    }

    setErrors(errors);
    return Object.keys(errors).length === 0; // Return true if no errors
  };

  const handleSignUpSubmit = async(e) => {
    e.preventDefault();
    try {
        // Add your sign-up logic here
        console.log('Sign Up:', signUpData);
  
        // Replace the following URL with your signup API endpoint
        if(validateSignUpForm()){
        const apiUrl = 'http://localhost:8081/user/signup';
        const userDetails = {
            fullName:signUpData.fullName,
            email: signUpData.userEmail,
            phoneNo: signUpData.password,
            password: (signUpData.password === signUpData.confirmPassword)? signUpData.password : null
        }
        const response = await fetch(apiUrl, {
          method: 'POST',
          headers: {
            'Content-Type': 'application/json',
          },
          body: JSON.stringify(userDetails),
        });
  
        if (!response.ok) {
          throw new Error('Signup failed'); // Customize the error message as needed
        }
  
        const data = await response.json();
        console.alert('Signup successful:', data);
        handleToggleForm();

    }else{
        console.log('Form has errors. Please fix them. ' + errors);
    }
  
        // Add additional logic based on the response from the signup API
      } catch (error) {
        console.error('Error during sign-up:', error.message);
        // Handle the error, e.g., display an error message to the user
      }
    console.log('Sign Up:', signUpData);
  };

  const handleToggleForm = () => {
    setShowSignUp((prev) => !prev);
  };

  return (
    <div className="auth-container">
      {showSignUp ? (
        <div className="auth-form">
          <h2>Sign Up</h2>
          <form onSubmit={handleSignUpSubmit}>
            <label>
              Full Name:
              <input type="text" name="fullName" value={signUpData.fullName} onChange={handleSignUpChange} required />
            </label>
            <label>
              Email:
              <input type="email" name="userEmail" value={signUpData.userEmail} onChange={handleSignUpChange} required />
            </label>
            <label>
              Password:
              <input type="password" name="password" value={signUpData.password} onChange={handleSignUpChange} required />
            </label>
            <label>
              Confirm Password:
              <input type="password" name="confirmPassword" value={signUpData.confirmPassword} onChange={handleSignUpChange} required />
            </label>
            <label>
              Phone No:
              <input type="tel" name="phoneNo" value={signUpData.phoneNo} onChange={handleSignUpChange} />
            </label>
            <button type="submit">Sign Up</button>
          </form>
          <p>
            Already have an account?{' '}
            <button type="button" onClick={handleToggleForm}>
              Sign In
            </button>
          </p>
        </div>
      ) : (
        <div className="auth-form">
          <h2>Sign In</h2>
          <form onSubmit={handleSignInSubmit}>
            <label>
              Email:
              <input type="email" name="email" value={signInData.email} onChange={handleSignInChange} required />
            </label>
            <label>
              Password:
              <input type="password" name="password" value={signInData.password} onChange={handleSignInChange} required />
            </label>
            <button type="submit">Sign In</button>
          </form>
          <p>
            Don't have an account?{' '}
            <button type="button" onClick={handleToggleForm}>
              Sign Up
            </button>
          </p>
        </div>
      )}
    </div>
  );
};

export default AuthForm;
