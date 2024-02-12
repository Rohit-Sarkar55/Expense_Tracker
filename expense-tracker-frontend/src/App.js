
import Navbar from './Navbar';
import Home from './Home';
import UserProfile from './Components/UserProfile/UserProfile';

function App() {
  return (
    <div className="App">
     
      <div className="content">
       <Home /> <Navbar />
       
       <UserProfile userId={202401}/>
      </div>
    </div>
  );
}

export default App;
