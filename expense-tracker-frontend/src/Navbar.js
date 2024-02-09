import React, { useState } from 'react';
import { Link } from 'react-scroll'; // If using React Router for navigation

const Navbar = () => {
  const [activeTab, setActiveTab] = useState('Home');

  const handleTabClick = (tab) => {
    setActiveTab(tab);
    // You can add additional logic here if needed
  };

  return (
    <nav className="navbar">
      <div className="navbar-container">
        <Link to="/" className={`nav-item ${activeTab === 'Home' ? 'active' : ''}`} onClick={() => handleTabClick('Home')}>
          Home
        </Link>
        <Link to="/expenses" className={`nav-item ${activeTab === 'Expenses' ? 'active' : ''}`} onClick={() => handleTabClick('Expenses')}>
          Expenses
        </Link>
        <Link to="/about" className={`nav-item ${activeTab === 'About' ? 'active' : ''}`} onClick={() => handleTabClick('About')}>
          About
        </Link>
      </div>
    </nav>
  );
};

export default Navbar;
