import axios from 'axios';
import React, { useState } from 'react'
import { Link, useNavigate } from 'react-router-dom';

{/*these are Comments*/}


function AddStaff() {

  let navigate = useNavigate(); 


  {/*make object*/}
  const [user, setUsers] = useState({
    name:"",
    jobTitle:"",
    annualSalary:""
  }); 

  const{name, jobTitle, annualSalary} = user; 


  {/*for each object, get each value*/}  
  const onInputChange = (e) =>{
    setUsers({...user, [e.target.name]:e.target.value});

  }; 

  {/*when clicking submit -> uses axios to postMapping onto url*/}
  {/*then navigate back to homepage*/}
  const onSubmit= async(e) => {
    e.preventDefault();
    await axios.post("http://localhost:8082/", user);  {/*postMapping for 1 staff*/}
    navigate('/'); 
  }; 

  {/*this is the actual render page*/}
  return (
    
    <div className='container'>   {/*make a container*/}
      <div className='row'>
        <div className='col-md-6 offset-md-3 border rounded p-4 mt-2 shadow'>
          <h2 className='text-center m-4'>Register Staff</h2>         {/*container title*/}

          <form onSubmit={(e) => onSubmit(e)}>      {/*when submit -> trigger onSubmit function */}
          <div className='mb-3'>
            <label htmlFor="Name" className='form-label'> {/*for label */}
              Name
            </label>

            {/*when user inputs, type string, assigned to name*/}
            <input        
            type={"text"}
            className='form-control'
            placeholder='Enter name'
            name='name'
            value={name}
            onChange={(e)=> onInputChange(e)}>
            </input>
          </div>

          <div className='mb-3'>
            <label htmlFor="jobTitle" className='form-label'>
              Job Title
            </label>
            <input
            type={"text"}
            className='form-control'
            placeholder='Enter Job Title'
            name='jobTitle'
            value={jobTitle}
            onChange={(e)=> onInputChange(e)}>
            </input>
          </div>

          <div className='mb-3'>
            <label htmlFor="annualSalary" className='form-label'>
              Annual Salary
            </label>
            <input
            type={"text"}
            className='form-control'
            placeholder='Enter Annual Salary'
            name='annualSalary'
            value={annualSalary}
            onChange={(e)=> onInputChange(e)}>
            </input>
          </div>

          <button type='submit' className='bnt btn-outline-primary'>  {/*submit button is submit class */}
            Submit 
          </button>

          <Link className='bnt btn-outline-danger mx-2' to='/'>     {/*Cancel button has link to home page '/'*/}
            Cancel 
          </Link>
          </form>

        </div>
      </div>
    </div>



  )
}

export default AddStaff; 