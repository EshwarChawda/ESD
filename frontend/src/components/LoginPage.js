import React, { useState, useEffect } from 'react';
import { TextField, Button } from '@mui/material';
import axios from 'axios';
import { useNavigate } from 'react-router-dom';

const LoginPage = () => {
  const [username, setUsername] = useState('');
  const [password, setPassword] = useState('');
  const navigate = useNavigate();

  const handleUsernameChange = (event) => {
    setUsername(event.target.value);
  };

  const handlePasswordChange = (event) => {
    setPassword(event.target.value);
  };

  async function handleLogin() {
    if (!username || !password) {
      console.error('Username and password are required');
      return;
    }

    try {
      const response = await axios.post('http://localhost:8080/api/home/authenticate', {
        username: username,
        password: password,
      });

      if (response.data !== null) {
        navigate(`/courses/${username}`);
      } else {
        console.error('Authentication failed:', 'Invalid credentials');
      }
    } catch (error) {
      console.error('Authentication failed:', error.message);
    }
  }

  return (
    <form>
      <TextField
        id="filled-basic"
        label="Username"
        variant="filled"
        margin="normal"
        value={username}
        onChange={handleUsernameChange}
      />
      <br></br>
      <TextField
        id="standard-password-input"
        label="Password"
        type="password"
        autoComplete="current-password"
        variant="standard"
        margin="normal"
        value={password}
        onChange={handlePasswordChange}
      />
      <br>
      </br>
      <br>
      </br>
      <Button variant="contained" color="primary" onClick={handleLogin}>
        Submit
      </Button>
    </form>
  );
};

export default LoginPage;