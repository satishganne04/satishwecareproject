import React, { useState, useEffect } from "react";
import axios from "axios";

const UserHome = () => {
  const [userData, setUserData] = useState({});

  useEffect(() => {
    // Fetch user data from API using Axios
    axios.get("https://your-api.com/user").then(res => {
      setUserData(res.data);
    });
  }, []);

  return (
    <div>
      <h1>Welcome {userData.name}</h1>
      <p>Your email is: {userData.email}</p>
    </div>
  );
};

export default UserHome;
