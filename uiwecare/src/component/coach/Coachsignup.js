
import React, { useState } from 'react';
import axios from 'axios';
import './Coachsignup.css';

function Coachsignup() {
  const [formData, setFormData] = useState({
    name: '',
    password: '',
    dateOfBirth: '',
    gender: '',
    mobileNumber: '',
    speciality: '',
  });
  const [errors, setErrors] = useState({});

  const handleChange = (event) => {
    setFormData({ ...formData, [event.target.name]: event.target.value });
  };

  const handleSubmit = (event) => {
    event.preventDefault();
    setErrors({}); // clear any previous errors

    // perform validation
    if (!formData.name || formData.name.length < 3 || formData.name.length > 50) {
      setErrors({ name: 'Name must be between 3 and 50 characters' });
    }
    if (!formData.password || formData.password.length < 5 || formData.password.length > 10) {
      setErrors({ password: 'Password must be between 5 and 10 characters' });
    }
    if (!formData.dateOfBirth) {
      setErrors({ dateOfBirth: 'Age is required' });
    } else {
      // here you can use moment.js or date-fns library to perform date related validation
      const date = new Date(formData.dateOfBirth);
      const age = new Date().getFullYear() - date.getFullYear();
      if (age < 20 || age > 100) {
        setErrors({ dateOfBirth: 'Age should be between 20 and 100 years' });
      }
    }
    if (!formData.gender) {
      setErrors({ gender: 'Gender is required' });
    }
    if (!formData.mobileNumber || formData.mobileNumber.length !== 10) {
      setErrors({ mobileNumber: 'Mobile Number should have 10 digits' });
    }
    if (!formData.speciality || formData.speciality.length < 10 || formData.speciality.length > 50) {
      setErrors({ speciality: 'Speciality should have 10 to 50 characters' });
    }

    if (!Object.keys(errors).length) {
      // no errors, proceed with form submission
      axios.post('http://COACH-SERVICE/coaches/register', formData)
        .then((response) => {
          
        })
        .catch((error) => {
          console.error(error);
        });
    }
  };

  return (
    <><form onSubmit={handleSubmit}>
          <div>
              <label htmlFor="name">Name:</label>
              <input type="text" name="name" value={formData.name} onChange={handleChange} />
              {errors.name && <p className="error">{errors.name}</p>}
          </div>
          <div>
              <label htmlFor="password">Password:</label>
              <input type="password" name="password" value={formData.password} onChange={handleChange} />

              {errors.password && <p className="error">{errors.password}</p>}
          </div>
          <div>
              <label htmlFor="dateOfBirth">Age:</label>
              <input type="date" name="dateOfBirth" value={formData.dateOfBirth} onChange={handleChange} />
              {errors.dateOfBirth && <p className="error">{errors.dateOfBirth}</p>}
          </div>
          <div>
              <label htmlFor="gender">Gender:</label>
              <select name="gender" value={formData.gender} onChange={handleChange}>
                  <option value="">Select Gender</option>
                  <option value="male">Male</option>
                  <option value="female">Female</option>
                  <option value="other">Other</option>
              </select>
              {errors.gender && <p className="error">{errors.gender}</p>}
          </div>
          <div>
              <label htmlFor="mobileNumber">Mobile Number:</label>
              <input type="text" name="mobileNumber" value={formData.mobileNumber} onChange={handleChange} />
              {errors.mobileNumber && <p className="error">{errors.mobileNumber}</p>}
          </div>
          <div>
              <label htmlFor="speciality">Speciality:</label>
              <input type="text" name="speciality" value={formData.speciality} onChange={handleChange} />
              {errors.speciality && <p className="error">{errors.speciality}</p>}
          </div>
          <button type="submit">Register</button>
      </form>
      <button onClick={() => { } }>Login Now</button></>
  );
}

export default Coachsignup;
