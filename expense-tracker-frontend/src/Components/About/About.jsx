import React from "react";
import image from "../About/image/DP-images-16.jpg"

const About=()=>{
    return(
        <>
        <div className="container emp-profile">
            <form method="">
                <div className="row">
                    <div className="col-md-4">
                        <img src={image} alt="aleternateimage"/>
                    </div>
                    <div className="col-md-6">
                        <div className="profile-head">
                            <h5>sonakshi</h5>
                            <h6>web developer</h6>
                        </div>
                    </div>
                </div>
            </form>

        </div>
        </>
    )
}
export default About;