import React, { useEffect, useState } from 'react';
import {Link, useParams} from 'react-router-dom';
import axios from 'axios';
import api from '../api';
import Navbar_2 from '../Layout/Navbar_2';


export default function ViewStaff() {

    const [user, setUsers] = useState({
        name:"",
        jobTitle: "",
        annualSalary:""
    });

    const username=localStorage.getItem('username');

    useEffect(() => {
        loadStaff()
    }, []);

    const loadStaff = async ()=>{
        const result = await api.post(`/staff/${username}`);
        setUsers(result.data);
    };


    return (

        <div className='container'>
            <Navbar_2 />
            <div className='row'>
                <div className='col-md-6 offset-md-3 border rounded p-4 mt-2 shadow'>
                    <h2 className='text-center m-4'>Staff Details</h2>
                    <div className='card'>
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
                </div>
            </div>
        </div>

    )
}
