import React from "react";
import { useState,useEffect } from "react";
const UserProfile=({userId})=>
{
    const[user,setUser]=useState(null);
  useEffect(()=>
  {
    const fetchUserData=async()=>
    {
      try{
        const response=await fetch(`http://localhost:8081/user/${userId}`);
        const user=await response.json();
        setUser(user);

      }
      catch(error)
      {
        console.error('error fetching user data:',error);
      }
    };
    fetchUserData();
    console.log(user);

  },[userId]);
 if(!user)
 {
  return <p>loading...</p>
 }

    return(
        <div>
            <img src={`https://i.pravatar.cc`}
             alt={`${user.fullName}'s profile`}
             style={{width:'200px',height:'200px'}}
             />
            <h3>Name: {user.fullName}</h3>
            <p>Email:{user.email}</p>
            <p>Phone:{user.phoneNo}</p>
            <p>registrationDate:{user.dateOfRegistration}</p>

        </div>
    );
};
export default UserProfile;