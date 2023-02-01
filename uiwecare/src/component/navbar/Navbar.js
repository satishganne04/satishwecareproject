import React from "react";
import "./Navbar.css";

const Navbar = () => {
  return (
    <nav className="navbar">
      <a href="#" className="brand-icon">We Care Project</a>
      <div className="navbar-right">
        <a href="#" className="nav-item">Call Us</a>
        <a href="#" className="nav-item">Join as a Coach</a>
        <a href="#" className="nav-item">Login as a Coach</a>
        <a href="#" className="nav-item">Join as a User</a>
        <a href="#" className="nav-item">Login as a User</a>
      </div>
    </nav>
  );
};

export default Navbar;


