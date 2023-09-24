import React from "react";
import { Link } from "react-router-dom";


//code for top nagivation bar
{/*these are Comments*/}

export default function Navbar() {
  return (
    <div>

      {/*logo link button  */}
      <nav className="navbar navbar-expand-lg navbar-dark bg-primary">
        <div className="container-fluid">
          <Link className="navbar-brand" to={'/'}>
            HRMasery
          </Link>
          <button
            className="navbar-toggler"
            type="button"
            data-bs-toggle="collapse"
            data-bs-target="#navbarSupportedContent"
            aria-controls="navbarSupportedContent"
            aria-expanded="false"
            aria-label="Toggle navigation"
          >
            <span className="navbar-toggler-icon"></span>
          </button>

        {/*button link to 'Add staff' */}
        {/*clicking on it will lead to url/addStaff -> which will allows App.js to route to AddStaff.js page */}
          <Link className="btn btn-outline-light" to="/addStaff">   
            Add Staff
          </Link>




        </div>
      </nav>
    </div>
  );
}
