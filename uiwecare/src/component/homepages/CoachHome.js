import React, { useState, useEffect } from 'react';
import axios from 'axios';

const CoachHome = () => {
  const [coachData, setCoachData] = useState([]);

  useEffect(() => {
    const fetchData = async () => {
      const result = await axios.get('/api/coach');
      setCoachData(result.data);
    };

    fetchData();
  }, []);

  return (
    <div>
      <h2>Welcome Coach!</h2>
      <ul>
        {coachData.map(coach => (
          <li key={coach.id}>
            {coach.name}: {coach.specialty}
          </li>
        ))}
      </ul>
    </div>
  );
};

export default CoachHome;
