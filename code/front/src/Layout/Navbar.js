import React from "react";
import { Link, useNavigate } from 'react-router-dom';


export default function Navbar() {

  let navigate = useNavigate();

  function logOut(){
    localStorage.clear();
    console.log(localStorage);
    console.log("localstorage is clear");
    navigate('/login');
  }

  return (
    <div>

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

          <Link className="btn btn-outline-light" to="/addStaff">
            Add Staff
          </Link>

          <button className="btn btn-outline-light"
            onClick={()=>logOut()}>
            Log Out
          </button>


        </div>
      </nav>
    </div>
  );
}
