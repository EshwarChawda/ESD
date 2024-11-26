import React, { useState, useEffect } from 'react';
import { TextField, Button } from '@material-ui/core';
import { useNavigate } from 'react-router-dom'; // Import useNavigate instead of useHistory


const LoginPage = () => {
  const [username, setUsername] = useState('');
  const [password, setPassword] = useState('');
  const navigate = useNavigate(); // Use useNavigate hook


  const handleUsernameChange = (event) => {
    setUsername(event.target.value);
  };

  const handlePasswordChange = (event) => {
    setPassword(event.target.value);
  };

  function handleLogin() {
    console.log(username);
    console.log(password);
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