import React, { useState, useEffect } from 'react';
import axios from 'axios';

const UserProfile = () => {
  const [userData, setUserData] = useState({});

  useEffect(() => {
    const fetchUserData = async () => {
      try {
        const response = await axios.get('/api/user');
        setUserData(response.data);
      } catch (error) {
        console.error(error);
      }
    };
    fetchUserData();
  }, []);

  return (
    <div>
      <h2>User Profile</h2>
      <p>Username: {userData.username}</p>
      <p>Email: {userData.email}</p>
      <p>Full Name: {userData.fullName}</p>
    </div>
  );
};

export default UserProfile;
