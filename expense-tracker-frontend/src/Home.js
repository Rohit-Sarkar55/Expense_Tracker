import {useState} from 'react';

const Home = () => {

    const [name, setName] =  useState("sachin");

    const handleClick = () =>{
        console.log("logged");
    }

    const handleClickAgain = (name) =>{
        console.log(name);
        setName("sachyaaa");
    }

    return ( 
        <>
        <div className="home">
            <h2>Homepage</h2>
            <h4>{name}</h4>
            <button onClick={handleClick}>click me</button>
            <button onClick={() => handleClickAgain(name)}>Click me again</button>
        </div>
        </>
     );
}
 
export default Home;