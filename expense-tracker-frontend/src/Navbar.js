import React, { useState } from 'react';
import { Link } from 'react-scroll'; // If using React Router for navigation

import About from './Components/About/About';
import Home from './Home';



const Navbar = () => {
  const [activeTab, setActiveTab] = useState('Home');

  
  const handleTabClick = (tab) => {
    setActiveTab(tab)
    console.log("handle click" + activeTab);
    // You can add additional logic here if needed
    // renderComponent
    
  };


  const renderComponent = () => {
    console.log(activeTab);
    switch (activeTab) {
      case 'Home':
        console.log("Home Triggered");
        return <Home />
      case 'Expenses':
        // return <Expenses />;
        return null;
      case 'About':
        return <About />;
        
      default:
        return null; // Render null or a default component if no match
    }
  };

  return (
    <>
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
    <div>
    {renderComponent()}
  </div>
  </>
  );
};

export default Navbar;
