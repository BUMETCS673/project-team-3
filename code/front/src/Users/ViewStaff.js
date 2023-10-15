import React, { useEffect, useState } from 'react';
import {Link, useParams} from 'react-router-dom';
import axios from 'axios';
import api from '../api';


export default function ViewStaff() {

    const [user, setUsers] = useState({
        name:"",
        jobTitle: "",
        annualSalary:""
    }); 

    
    const {id}=useParams(); 

    useEffect(() => {
        loadStaff()
    }, []);

    const loadStaff = async ()=>{
        const result = await api.get(`/employee/${id}`);
        setUsers(result.data);
    };


  return (

    <div className='container'>              {/*make a container*/}  
    <div className='row'>
      <div className='col-md-6 offset-md-3 border rounded p-4 mt-2 shadow'>
        <h2 className='text-center m-4'>Staff Details</h2>                      {/*container title*/}

        <div className='card'>                  {/*card format*/}
            <div className='card-header'>
                Detail of user id:{user.id}
                <ul className='list-group list-group-flush'>
                    <li className='list-group-item'>
                        <b>Name: </b>
                        {user.name}
                    </li>

                    <li className='list-group-item'>
                        <b>Job Title: </b>
                        {user.jobTitle}
                    </li>
                    
                    <li className='list-group-item'>
                        <b>Annual Salary: </b>
                        {user.annualSalary}
                    </li>
                </ul>
            </div>
        </div>
        <Link className='btn btn-primary my-2' to={'/home'}>
            Back to Home
        </Link>

        </div>
        </div>
        </div>

  )
}
