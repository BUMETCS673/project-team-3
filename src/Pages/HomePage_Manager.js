import React, { useEffect, useState } from 'react';
import axios from 'axios';
import {Link, useParams} from "react-router-dom"; 

{/*these are Comments*/}


export default function HomePage_Manager() {

    {/*use id as variable*/}
    const{id} = useParams(); 

    const[users, setUsers] = useState([])

    {/*load data onto page*/}
    useEffect(() =>{
        loadStaff(); 
    },[])

    {/*use axio to get getMapping of all employee*/}
    {/*set the users to new data*/}
    const loadStaff = async() =>{
        const result = await axios.get("http://localhost:8082/allemployee");              {/*getMapping for all staff */}
        setUsers(result.data); 
    }; 

    {/*use axio to get deletMapping with id variable*/}
    const deleteUser = async(id)=>{
      await axios.delete(`http://localhost:8082/${id}`);                                  {/*deleteMapping for 1 staff*/}
      loadStaff(); 
    }; 


  return (
    <div className='container'>       {/*make a container*/}

        <div className='py-4'>
        <table className="table border shadow"> {/*make table inside the container*/}
  <thead>
    <tr>              {/*colum names inside the table*/}
      <th scope="col">#</th>
      <th scope="col">ID</th>
      <th scope="col">Name</th>
      <th scope="col">Job Title</th>
      <th scope="col">Annual Salary</th>
    </tr>
  </thead>
  <tbody>

    {/*mape each staff object to each row*/}
        {users.map((user, index) => (
            <tr>
            <th scope="row" key={index}> {index+1} </th>
            <td>{user.id}</td>
            <td>{user.name}</td>
            <td>{user.jobTitle}</td>
            <td>${user.annualSalary}</td>

            {/*action buttons*/}
            {/*each button links to each different url with variable id -> App.js takes care of each route*/}
            <td>
                <Link className='btn btn-primary mx-2'
                to={`/viewstaff/${user.id}`}>
                    View Employee
                </Link>

                <Link className='btn btn-outline-primary mx-2'
                to={`/editstaff/${user.id}`}>
                    Edit Employee
                </Link>

                <button className='btn btn-outline-danger mx-2'
                onClick={()=>deleteUser(user.id)}>
                    Delete Employee
                </button>
                
            </td>

          </tr>
        ))
    }

  </tbody>
</table>
        </div>

    </div>
  )
}
