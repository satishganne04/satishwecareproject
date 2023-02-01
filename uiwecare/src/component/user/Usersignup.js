import React, { useState } from 'react';
import axios from 'axios';
import './UserSignupForm.css';

function Usersignup() {
  const [name, setName] = useState('');
  const [password, setPassword] = useState('');
  const [mobileNumber, setMobileNumber] = useState('');
  const [email, setEmail] = useState('');
  const [dateOfBirth, setDateOfBirth] = useState('');
  const [gender, setGender] = useState('');
  const [pincode, setPincode] = useState('');
  const [city, setCity] = useState('');
  const [state, setState] = useState('');
  const [country, setCountry] = useState('');

  const [nameError, setNameError] = useState('');
  const [passwordError, setPasswordError] = useState('');
  const [mobileNumberError, setMobileNumberError] = useState('');
  const [emailError, setEmailError] = useState('');
  const [dateOfBirthError, setDateOfBirthError] = useState('');
  const [genderError, setGenderError] = useState('');
  const [pincodeError, setPincodeError] = useState('');
  const [cityError, setCityError] = useState('');
  const [stateError, setStateError] = useState('');
  const [countryError, setCountryError] = useState('');

  const handleSubmit = async (event) => {
    event.preventDefault();
    let isValid = true;

    if (name.length < 3 || name.length > 50) {
      setNameError("Name should have 3 to 50 characters");
      isValid = false;
    } else {
      setNameError("");
    }
    if (password.length < 5 || password.length > 10) {
      setPasswordError("Password should have 5 to 10 characters");
      isValid = false;
    } else {
      setPasswordError("");
    }
    if (mobileNumber.length !== 10) {
      setMobileNumberError("Mobile Number should have 10 digits");
      isValid = false;
    } else {
      setMobileNumberError("");
    }
    if (!email) {
      setEmailError("Email is required");
      isValid = false;
    } else {
      setEmailError("");
    }
    if (!dateOfBirth) {
      setDateOfBirthError("Date of Birth is required");
      isValid = false;
    } else {
      const age = new Date().getFullYear() - new Date(dateOfBirth).getFullYear();
      if (age < 20 || age > 100) {
        setDateOfBirthError("Age should be between 20 and 100 years");
        isValid = false;
      } else {
        setDateOfBirthError("");
      }
    }
    if (!gender)
    {
      setGenderError("Gender is required");
      isValid = false;
    } else {
    setGenderError("");
    }
    if (pincode.length !== 6) {
    setPincodeError("Pincode should have 6 digits");
    isValid = false;
    } else {
    setPincodeError("");
    }
    if (city.length < 6 || city.length > 20) {
    setCityError("City should have 6 to 20 characters");
    isValid = false;
    } else {
    setCityError("");
    }
    if (state.length < 6 || state.length > 20) {
    setStateError("State should have 6 to 20 characters");
    isValid = false;
    } else {
    setStateError("");
    }
    if (country.length < 6 || country.length > 20) {
    setCountryError("Country should have 6 to 20 characters");
    isValid = false;
    } else {
    setCountryError("");
    }
    if (!isValid) {
    return;
    }
    try {
    await axios.post('http://localhost:8066/user/signup', {
    name,
    password,
    mobileNumber,
    email,
    dateOfBirth,
    gender,
    pincode,
    city,
    state,
    country
    });
    alert("Signup successful!");
    } catch (error) {
    alert(error);
    }
    };
    
    return (
    <div className="login-page">
    <div className="logo">
    
    <h1>User profile</h1>
    </div>
    <form className="login-form" onSubmit={handleSubmit}>
    <div className="form-control">
    <label htmlFor="name">Name</label>
    <input
    type="text"
    id="name"
    value={name}
    onChange={(e) => setName(e.target.value)}
    />
    {nameError && <div className="error-message">{nameError}</div>}
    </div>
    <div className="form-control">
    <label htmlFor="password">Password</label>
    <input
    type="password"
    id="password"
    value={password}
    onChange={(e) => setPassword(e.target.value)}
    />
    {passwordError && (
    <div className="error-message">{passwordError}</div>
    )}
    </div>
    <div className="form-control">
    <label htmlFor="mobileNumber">Mobile Number</label>
    <input
    type="text"
    id="mobileNumber"
    value={mobileNumber}
    onChange={(e) => setMobileNumber(e.target.value)}
    />
    {mobileNumberError && (
    <div className="error-message">{mobileNumberError}</div>
    )}
    </div>
    <div className="form-control">
    <label htmlFor="email">Email</label>
    <input type="email"
id="email"
value={email}
onChange={(e) => setEmail(e.target.value)}
/>
{emailError && <div className="error-message">{emailError}</div>}
</div>
<div className="form-control">
<label htmlFor="dateOfBirth">Date of Birth</label>
<input
type="date"
id="dateOfBirth"
value={dateOfBirth}
onChange={(e) => setDateOfBirth(e.target.value)}
/>
{dateOfBirthError && (
<div className="error-message">{dateOfBirthError}</div>
)}
</div>
<div className="form-control">
<label htmlFor="gender">Gender</label>
<input
type="text"
id="gender"
value={gender}
onChange={(e) => setGender(e.target.value)}
/>
{genderError && <div className="error-message">{genderError}</div>}
</div>
<div className="form-control">
<label htmlFor="pincode">Pincode</label>
<input
type="text"
id="pincode"
value={pincode}
onChange={(e) => setPincode(e.target.value)}
/>
{pincodeError && <div className="error-message">{pincodeError}</div>}
</div>
<div className="form-control">
<label htmlFor="city">City</label>
<input
type="text"
id="city"
value={city}
onChange={(e) => setCity(e.target.value)}
/>
{cityError && <div className="error-message">{cityError}</div>}
</div>
<div className="form-control">
<label htmlFor="state">State</label>
<input
type="text"
id="state"
value={state}
onChange={(e) => setState(e.target.value)}
/>
{stateError && <div className="error-message">{stateError}</div>}
</div>
<div className="form-control">
<label htmlFor="country">Country</label>
<input
type="text"
id="country"
value={country}
onChange={(e) => setCountry(e.target.value)}
/>
{countryError && <div className="error-message">{countryError}</div>}
</div>
<button className="submit-button" type="submit">
Signup
</button>
</form>
</div>
);
}

export default Usersignup;