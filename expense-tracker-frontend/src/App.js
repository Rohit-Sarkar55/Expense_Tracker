
import Navbar from './Navbar';
import Home from './Home';
import About from './Components/About/About';

function App() {
  return (
    <div className="App">
     
      <div className="content">
       <Home /> <Navbar />
       <About />
      </div>
    </div>
  );
}

export default App;
