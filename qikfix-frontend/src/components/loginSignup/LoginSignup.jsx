import React, { useState } from 'react';
import axios from 'axios';
import './LoginSignup.css';

import user_icon from '../assets/person.png';
import email_icon from '../assets/email.png';
import password_icon from '../assets/password.png';

const RegisterForm = () => {
  const [action, setAction] = useState('Sign Up');

  const [user, setUser] = useState({
    username: '',
    email: '',
    password: '',
  });

  const [loginUser, setLoginUser] = useState({
    email: '',
    password: '',
  });

  const handleChange = (e) => {
    const { name, value } = e.target;

    if (action === 'Sign Up') {
      setUser({ ...user, [name]: value });
    } else if (action === 'Login') {
      setLoginUser({ ...loginUser, [name]: value });
    }
  };

  const handleSubmit = async (e) => {
    e.preventDefault();

    try {
      if (action === 'Sign Up') {
        const response = await axios.post('http://localhost:8080/api/register', user);
        console.log(response.data);
        setUser({ username: '', email: '', password: '' });
      } else if (action === 'Login') {
        const response = await axios.post('http://localhost:8080/api/login', loginUser);
        console.log('Login successful:', response.data);
      }
    } catch (error) {
      console.error(action === 'Sign Up' ? 'Registration failed:' : 'Login failed:', error);
    }
  };

  return (
    <div className="container">
      <div className="header">
        <div className="text">{action}</div>
        <div className="underline"></div>
      </div>
      <form onSubmit={handleSubmit}>
        {action === 'Sign Up' && (
          <>
            <div className="input">
              <img src={user_icon} alt="" />
              <input 
              type="text" required 
              name="username" 
              value={user.username} 
              onChange={handleChange} 
              placeholder="Username" />
            </div>
          </>
        )}

        <div className="input">
          <img src={email_icon} alt="" />
          <input
            type="email" required
            name={"email"}
            value={action === 'Sign Up' ? user.email : loginUser.email}
            onChange={handleChange}
            placeholder="Email"
          />
        </div>

        <div className="input">
          <img src={password_icon} alt="" />
          <input
            type="password" required
            name={"password"}
            value={action === 'Sign Up' ? user.password : loginUser.password}
            onChange={handleChange}
            placeholder="Password"
          />
        </div>
         <div className='submit-container'>
            
         <button className='submit' type="submit">{action === 'Sign Up' ? 'Sign Up' : 'Login'}</button>
         <button className='submit gray' onClick={() => setAction(action === 'Sign Up' ? 'Login' : 'Sign Up')}>{action === 'Sign Up' ? "Login" : 'Sign Up'}</button>

        </div>
      </form>

      
    </div>
  );
};

export default RegisterForm;
