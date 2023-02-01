import React, { useState } from 'react';
import axios from 'axios';

const BookAppointment = () => {
  const [appointment, setAppointment] = useState({
    dateOfAppointment: '',
    slot: '',
  });
  const [success, setSuccess] = useState(false);

  const handleChange = (event) => {
    setAppointment({
      ...appointment,
      [event.target.name]: event.target.value,
    });
  };

  const handleSubmit = (event) => {
    event.preventDefault();

    axios
      .post('/api/appointments', appointment)
      .then((response) => {
        setSuccess(true);
      })
      .catch((error) => {
        console.error(error);
      });
  };

  return (
    <form onSubmit={handleSubmit}>
      <div>
        <label htmlFor="dateOfAppointment">Date of Appointment:</label>
        <input
          type="date"
          name="dateOfAppointment"
          id="dateOfAppointment"
          value={appointment.dateOfAppointment}
          onChange={handleChange}
          required
        />
      </div>
      <div>
        <label htmlFor="slot">Slot:</label>
        <select
          name="slot"
          id="slot"
          value={appointment.slot}
          onChange={handleChange}
          required
        >
          <option value="">Choose a slot</option>
          <option value="morning">Morning</option>
          <option value="afternoon">Afternoon</option>
          <option value="evening">Evening</option>
        </select>
      </div>
      <button type="submit">Confirm your Appointment</button>
      {success && <p>Your appointment has been booked!</p>}
    </form>
  );
};

export default BookAppointment;
